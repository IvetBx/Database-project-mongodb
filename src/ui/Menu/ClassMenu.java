package ui.Menu;

import collections.*;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Documented;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassMenu extends Menu {

    Collection collection;

    public ClassMenu(Collection collection){
        this.collection = collection;
    }

    @Override
    public void print() { }

    @Override
    public void handle(String option) throws IOException, SQLException {
        switch (option) {
            case "1":   listALl(); break;
            case "2":   addNew(); break;
            case "3":   edit(); break;
            case "4":   delete(); break;
            case "5":   exit(); MainMenu m = new MainMenu(); m.run(); break;
            default:    System.out.println("Unknown option"); break;
        }
    }

    public String getInformationToFoundObject() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name or title of object, which you want to find:");
        String name = br.readLine();
        return name;
    }

    public HashMap<String, String> getInfo() throws IOException {
        HashMap<String, String> info = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter name:");
        String name = br.readLine();
        info.put("name", name);

        return info;
    }

    public void addNew() throws IOException {
        try {
            HashMap<String, String> newInfo = getInfo();
            collection.insert(newInfo);
            System.out.println("The object has been sucessfully added");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    };

    public void edit() throws IOException {
        try {
            String name = getInformationToFoundObject();
            HashMap<String, String> newInfo = getInfo();
            collection.update(newInfo, name);
            System.out.println("Successfully updated");

        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete() throws IOException {
        String name = getInformationToFoundObject();
        try {
            collection.delete(name);
            System.out.println("Successfully deleted");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    public void listALl() {
        ArrayList<Document> all = collection.listALl();
        for(Document doc : all){
            System.out.println(doc.toJson());
        }
    };

}
