package collections;

import dbConnect.DbContext;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;

import static com.mongodb.client.model.Filters.*;

public class Member extends Collection {

    public Member() {
        this.collection = DbContext.getMongoDatabase().getCollection("Member");
    }

    @Override
    public void insert(HashMap<String, String> info) {
        Document doc = new Document();
        Document name = new Document();

        for(String key: info.keySet()){
            String[] nestedInformation = key.split(":");

            if(nestedInformation.length == 2){
                name.append(nestedInformation[1], info.get(key));
            } else {
                if("departmentId".equals(key)){
                    Department d = new Department();
                    ArrayList<ObjectId> departments = new ArrayList<>();
                    String[] departmentsFromInput = info.get(key).split(",");
                    for(String dep : departmentsFromInput){
                        ObjectId idDep = d.getObjectIdAccordingName(dep);
                        if(idDep == null){
                            throw new IllegalArgumentException(dep + " doesnt exist");
                        }
                        departments.add(idDep);
                    }
                    doc.append(key, departments);
                } else if("groupId".equals(key)){
                    Group g = new Group();
                    ArrayList<ObjectId> groups = new ArrayList<>();
                    String[] groupsFromInput = info.get(key).split(",");
                    for(String group : groupsFromInput){
                        ObjectId idGroup = g.getObjectIdAccordingName(group);
                        if(idGroup == null){
                            throw new IllegalArgumentException(group + " doesnt exist");
                        }
                        groups.add(idGroup);
                    }
                    doc.append(key, groups);
                } else{
                    doc.append(key, info.get(key));
                }
            }
        }
        doc.append("name", name);
        collection.insertOne(doc);
    }


    private ArrayList<ObjectId> getNewDepartments(HashMap<String, String> info){
        ArrayList<ObjectId> departmentsId = new ArrayList<>();
        String[] departments = info.get("departmentId").split(",");
        Department d = new Department();
        for(String dep : departments){
            ObjectId id = d.getObjectIdAccordingName(dep);
            if(id != null){
                departmentsId.add(id);
            }
        }
        return departmentsId;
    }

    private ArrayList<ObjectId> getNewGroups(HashMap<String, String> info){
        ArrayList<ObjectId> groupsId = new ArrayList<>();
        String[] groups = info.get("groupId").split(",");
        Group g = new Group();
        for(String group : groups){
            ObjectId id = g.getObjectIdAccordingName(group);
            if(id != null){
                groupsId.add(id);
            }
        }
        return groupsId;
    }

    @Override
    public void update(HashMap<String, String> info, String objectName) {
        ObjectId idOfObjectInCollection = getObjectIdAccordingId(objectName);

        if(idOfObjectInCollection == null){
            throw new IllegalArgumentException("Object with this name doesnt exist");
        }

        Document searchQuery = getDocumentAccordingObjectId(idOfObjectInCollection);
        if(!searchQuery.isEmpty()){
            ArrayList<ObjectId> departments = (ArrayList<ObjectId>) searchQuery.get("departmentId");
            ArrayList<ObjectId> groups = (ArrayList<ObjectId>) searchQuery.get("groupId");
            Document update = new Document();
            Document nestedDocumentName = new Document();

            for(String key : info.keySet()){
                String[] nestedDocInformation = key.split(":");
                if(key.equals("departmentId")){
                    ArrayList<ObjectId> dep = getNewDepartments(info);
                    if(!dep.isEmpty()){
                        departments.addAll(dep);
                    }
                    update.append("departmentId", departments);

                } else if(key.equals("groupId")){
                    ArrayList<ObjectId> group = getNewGroups(info);
                    if(!group.isEmpty()){
                        groups.addAll(getNewGroups(info));
                    }
                    update.append("groupId", groups);
                } else if(nestedDocInformation[0].equals("name")){
                    nestedDocumentName.append(nestedDocInformation[1], info.get(key));

                } else{
                    update.append(key, info.get(key));
                }
            }

            update.append("name", nestedDocumentName);

            collection.updateOne(eq("_id", idOfObjectInCollection), new Document("$set", update));
        }
    }

    @Override
    public void delete(String name) {
        ObjectId id = getObjectIdAccordingId(name);
        if(id == null){
            throw new IllegalArgumentException("Object with this name doesnt exist");
        }
        Document doc = new Document("_id", id);
        collection.deleteOne(doc);
    }

    @Override
    public ObjectId getObjectIdAccordingName(String objectName) {
        String[] firstAndLastName = objectName.split(" ");
        Document found = collection.find(and(eq("name.first", firstAndLastName[0]), eq("name.last", firstAndLastName[1]))).first();
        if(found == null){
            return null;
        }
        return found.getObjectId("_id");
    }

    public ObjectId getObjectIdAccordingId(String objectId) {
        Document found = collection.find(eq("_id", new ObjectId(objectId))).first();
        if(found == null){
            return null;
        }
        return found.getObjectId("_id");
    }

}
