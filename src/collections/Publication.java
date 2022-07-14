package collections;
import dbConnect.DbContext;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.HashMap;

import static com.mongodb.client.model.Filters.eq;
public class Publication extends Collection {

    public Publication() {
        this.collection = DbContext.getMongoDatabase().getCollection("Publication");
    }

    @Override
    public void insert(HashMap<String, String> info) {
        ObjectId id = getObjectIdAccordingName(info.get("attributes:title"));
        if(id != null){
            throw  new IllegalArgumentException("Publication already exist");
        }
        Document doc = new Document();
        Document attributes = new Document();

        for(String key: info.keySet()){
            String[] nestedInformation = key.split(":");

            if(nestedInformation.length == 2){
                if(nestedInformation[1].equals("year")){
                    attributes.append(nestedInformation[1], Integer.parseInt(info.get(key)));
                } else if(nestedInformation[1].equals("author")){
                    attributes.append(nestedInformation[1], new ObjectId(info.get(key)));
                }
                else{
                    attributes.append(nestedInformation[1], info.get(key));
                }
            } else {
                doc.append(key, info.get(key));
            }
        }
        doc.append("attributes", attributes);
        collection.insertOne(doc);
    }

    @Override
    public void update(HashMap<String, String> info, String objectName) {
        ObjectId idOfObjectInCollection = getObjectIdAccordingName(objectName);

        if(idOfObjectInCollection == null){
            throw new IllegalArgumentException("Object with this name doesnt exist");
        }

        Document searchQuery = getDocumentAccordingObjectId(idOfObjectInCollection);
        if(!searchQuery.isEmpty()){
            Document update = new Document();
            Document nestedDocumentAttributes = new Document();

            for(String key : info.keySet()){
                String[] nestedDocInformation = key.split(":");
                if(nestedDocInformation[0].equals("attributes")) {
                    if(nestedDocInformation[1].equals("author")){
                        Member m = new Member();
                        ObjectId author = m.getObjectIdAccordingId(info.get(key));
                        if(author == null){
                            throw new IllegalArgumentException("Author doesnt exist");
                        }
                        nestedDocumentAttributes.append(nestedDocInformation[1], author);
                    } else if(nestedDocInformation[1].equals("title")){
                        ObjectId publication = getObjectIdAccordingName(info.get(key));
                        if(publication != null){
                            throw new IllegalArgumentException("Publication with this title already exist");
                        }
                        nestedDocumentAttributes.append(nestedDocInformation[1], info.get(key));
                    } else if(nestedDocInformation[1].equals("year")){
                        Integer year = Integer.parseInt(info.get(key));
                        nestedDocumentAttributes.append(nestedDocInformation[1], year);
                    } else{
                        nestedDocumentAttributes.append(nestedDocInformation[1], info.get(key));
                    }
                } else{
                    update.append(key, info.get(key));
                }
            }

            update.append("attributes", nestedDocumentAttributes);
            collection.updateOne(eq("_id", idOfObjectInCollection), new Document("$set", update));
        }
    }

    @Override
    public ObjectId getObjectIdAccordingName(String objectName) {
        Document found = collection.find(eq("attributes.title", objectName)).first();
        if(found == null){
            return null;
        }
        return found.getObjectId("_id");
    }
}
