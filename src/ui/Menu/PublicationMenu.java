package ui.Menu;

import additionalData.AdditionToPublication;
import collections.Publication;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import transaction.SortingPublication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;

public class PublicationMenu extends ClassMenu {

    private Publication publication = new Publication();

    public PublicationMenu() {
        super(new Publication());
    }

    @Override
    public void print() {
        System.out.println("******************************************************");
        System.out.println("* 1. list of all publications                        *");
        System.out.println("* 2. add new publication                             *");
        System.out.println("* 3. edit publication                                *");
        System.out.println("* 4. delete publication                              *");
        System.out.println("* 5. list of publications according author and year  *");
        System.out.println("* 6. list of publications according type and category*");
        System.out.println("* 7. list of publication of author                   *");
        System.out.println("* 8. number of member's group                        *");
        System.out.println("* 9. exit                                            *");
        System.out.println("******************************************************");
    }

    @Override
    public void handle(String option) throws IOException, SQLException {
        switch (option) {
            case "1":   listALl(); break;
            case "2":   addNew(); break;
            case "3":   edit(); break;
            case "4":   delete(); break;
            case "5":   publicationAccordingAuthorYear(); break;
            case "6":   publicationAccordingTypeCategories(); break;
            case "7":   getAllPublicationOfAuthorWithName(); break;
         //   case "8":   getNumberOfGroup(); break;
            case "9":   exit(); MainMenu m = new MainMenu(); m.run(); break;
            default:    System.out.println("Unknown option"); break;
        }
    }

    @Override
    public HashMap<String, String> getInfo() throws IOException {
        HashMap<String, String> info = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter type:");
        String type = br.readLine();
        info.put("type", type);

        if(!AdditionToPublication.type.containsKey(type)){
            throw new IllegalArgumentException("This type doesnt exist");
        }

        System.out.println("Enter  category:");
        String category = br.readLine();
        info.put("category", category);

        if(!AdditionToPublication.category.containsKey(category)){
            throw new IllegalArgumentException("This category doesnt exist");
        }

        HashMap<String, String> attributes;
        try {
            attributes = readAttributes(type);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());

            try {
                attributes = readAttributes(type);
            } catch (IllegalArgumentException ex1){
                throw new IllegalArgumentException("Try again fill everything");
            }
        }
        info.putAll(attributes);

        return info;
    }

    public HashMap<String, String> readAttributes(String type) throws IOException {
        HashMap<String, String> result = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Boolean required;
        for(String key : AdditionToPublication.type.get(type).keySet()){
            String message = "Enter " + key;
            if(AdditionToPublication.type.get(type).get(key) == '+'){
                message += " (required):";
                required = true;
            } else{
                message += " (optional):";
                required = false;
            }
            System.out.println(message);
            String attr = br.readLine();
            if(attr.isEmpty() && required){
                throw new IllegalArgumentException("This is required attribute");
            } else{
                if(!attr.isEmpty()){
                    result.put("attributes:" + key, attr);
                }
            }
        }
        return result;
    }

    public void publicationAccordingAuthorYear() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter author id: (optional) ");
        String id = br.readLine();
        System.out.println("Enter year: (optional) ");
        String y = br.readLine();
        System.out.println("(Year) Ascending : 1 or Descending: - 1");
        Integer ascending = Integer.parseInt(br.readLine());
        Integer year = 0;
        if(!y.isEmpty()){
            year = Integer.parseInt(y);
        }
        FindIterable it;
        if(id.isEmpty()){
            it = SortingPublication.sortAccordingYear(ascending, year);
        } else if(y.isEmpty()){
            it = SortingPublication.sortAccordingAuthor(ascending, new ObjectId(id));
        } else{
            it = SortingPublication.sortPublicationAuthorAndYear(ascending, year, new ObjectId(id));
        }

        for (Object o : it) {
            Document doc = (Document) o;
            System.out.println(doc.toJson());
        }
    }

    public void publicationAccordingTypeCategories() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter type: (optional) ");
        String type = br.readLine();
        System.out.println("Enter category: (optional) ");
        String category  = br.readLine();
        System.out.println("(Title) Ascending : 1 or Descending: - 1");
        Integer ascending = Integer.parseInt(br.readLine());

        FindIterable it;
        if(type.isEmpty()){
            it = SortingPublication.sortAccordingCategory(ascending, category);
        } else if(category.isEmpty()){
            it = SortingPublication.sortAccordingType(ascending, type);
        } else{
            it = SortingPublication.sortPublicationTypeAndCategory(ascending, type, category);
        }

        for (Object o : it) {
            Document doc = (Document) o;
            System.out.println(doc.toJson());
        }
    }

    public void getAllPublicationOfAuthorWithName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter author id, which publication you want to find:");
        String id = br.readLine();

        AggregateIterable output = SortingPublication.getAllPublicationOfAuthorWithName(new ObjectId(id));

        for(Object out : output){
            System.out.println(out.toString());
        }
    }

  /*  public void getNumberOfGroup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter author id, which group you want to find:");
        String id = br.readLine();

        AggregateIterable output = SortingPublication.getNumberOfGroup(new ObjectId(id));

        for(Object out : output){
            System.out.println(out.toString());
        }
    }*/

}
