package com.company;

import dbConnect.DbContext;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import ui.Menu.MainMenu;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        String uri = "";
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);

        try {
            MongoDatabase mongoDatabase = mongoClient.getDatabase("projektDDB");
            DbContext.setMongoDatabase(mongoDatabase);

           //GENERATE SCRIPT
            /*Script script = new Script();
            script.generateScript();*/
            MainMenu mainMenu = new MainMenu();
            mainMenu.run();
        } finally {
            mongoClient.close();
            DbContext.clear();
        }
    }
}
