package collections;
import dbConnect.DbContext;
import org.bson.types.ObjectId;

import java.util.HashMap;

public class Group extends Collection{

    public Group() {
        this.collection = DbContext.getMongoDatabase().getCollection("Group");
    }

    @Override
    public void insert(HashMap<String, String> info) {
        ObjectId id = getObjectIdAccordingName(info.get("name"));
        if(id != null){
            throw  new IllegalArgumentException("Group already exist");
        }
        super.insert(info);
    }

}
