package transaction;

import collections.Department;
import collections.Member;
import collections.Publication;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class SortingPublication {

    static Publication publication = new Publication();

    public static FindIterable sortAccordingYear(Integer ascending, Integer year){
        FindIterable it = publication.getCollection().find(gt("attributes.year", year)).sort(new Document("attributes.year", ascending)).projection(include( "type", "attributes.title", "attributes.year")).projection(excludeId());
        return it;
    }

    public static FindIterable sortAccordingAuthor(Integer ascending, ObjectId id){
        FindIterable it = publication.getCollection().find(eq("attributes.author", id)).sort(new Document("attributes.year", ascending)).projection(include( "type", "attributes.title", "attributes.year")).projection(excludeId());
        return it;
    }

    public static FindIterable sortPublicationAuthorAndYear(Integer ascending, Integer year, ObjectId id){
        FindIterable it = publication.getCollection().find(and(eq("attributes.author", id), gt("attributes.year", year))).sort(new Document("attributes.year", ascending)).projection(include("type", "attributes.title", "attributes.year")).projection(excludeId());
        return it;
    }

    public static FindIterable sortAccordingType(Integer ascending, String type){
        FindIterable it = publication.getCollection().find(eq("type", type)).sort(new Document("attributes.title", ascending)).projection(include("attributes.title")).projection(excludeId());
        return it;
    }

    public static FindIterable sortAccordingCategory(Integer ascending, String category){
        FindIterable it = publication.getCollection().find(eq("category", category)).sort(new Document("attributes.title", ascending)).projection(include( "attributes.title")).projection(excludeId());
        return it;
    }

    public static FindIterable sortPublicationTypeAndCategory(Integer ascending, String type, String category){
        FindIterable it = publication.getCollection().find(and(eq("type", type), eq("category", category))).sort(new Document("attributes.title", ascending)).projection(include("attributes.title")).projection(excludeId());
        return it;
    }

    public static AggregateIterable getAllPublicationOfAuthorWithName(ObjectId id){
        Member member = new Member();

        AggregateIterable output = member.getCollection().aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("_id", id)),
                        Aggregates.lookup("Publication", "_id", "attributes.author", "info"),
                        Aggregates.unwind("$info"),
                        Aggregates.project(Projections.fields(excludeId(), include("name", "email", "info.type", "info.category", "info.attributes.title")))
                )
        );
        return output;
    }

    public static AggregateIterable getNumberOfGroup(ObjectId id){
        Member member = new Member();


        AggregateIterable output = member.getCollection().aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("_id", id)),
                        Aggregates.unwind("$departmentId"),
                        Aggregates.lookup("Department", "departmentId", "_id", "info")
                )
        );
        return output;
    }

}
