package collections;
import dbConnect.DbContext;
import org.bson.types.ObjectId;
import java.util.HashMap;

public class Department extends Collection {

    public Department() {
        this.collection = DbContext.getMongoDatabase().getCollection("Department");
    }

    @Override
    public void insert(HashMap<String, String> info) {
        ObjectId id = getObjectIdAccordingName(info.get("name"));
        if(id != null){
            throw  new IllegalArgumentException("Department already exist");
        }
        super.insert(info);
    }

}
