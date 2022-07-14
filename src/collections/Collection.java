package collections;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;

import static com.mongodb.client.model.Filters.eq;

public abstract class Collection {
    protected MongoCollection<Document> collection;

    public MongoCollection<Document> getCollection(){
        return this.collection;
    }

    public void insert(HashMap<String, String> info) {
        Document doc = new Document();
        doc.putAll(info);
        collection.insertOne(doc);
    }

    public void update(HashMap<String, String> info, String objectName)  {
        ObjectId id = getObjectIdAccordingName(objectName);

        if(id == null){
            throw new IllegalArgumentException("Object with this name doesnt exist");
        }

        ObjectId idOfObjectInCollection = getObjectIdAccordingName(info.get("name"));
        if(idOfObjectInCollection != null){
            throw new IllegalArgumentException("Object with this name already exist");
        }

        Document searchQuery = getDocumentAccordingObjectId(id);
        if(!searchQuery.isEmpty()){
            Document update = new Document();
            update.putAll(info);
            Document newDocument = new Document().append("$set", update);
            collection.updateOne(searchQuery, newDocument);
        }
    }

    public Document getDocumentAccordingObjectId(ObjectId id){
        return collection.find(eq("_id", id)).first();
    }

    public ObjectId getObjectIdAccordingName(String objectName){
        Document found = collection.find(eq("name", objectName)).first();
        if(found == null){
            return null;
        }
        return found.getObjectId("_id");
    }

    public void delete(String name)  {
        ObjectId id = getObjectIdAccordingName(name);
        if(id == null){
            throw new IllegalArgumentException("Object with this name doesnt exist");
        }
        Document doc = new Document("_id", id);
        collection.deleteOne(doc);
    }

    public ArrayList<Document> listALl() {
        ArrayList<Document> result = new ArrayList<>();
        try (MongoCursor cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                result.add((Document) cursor.next());
            }
        }
        return result;
    }

}
