package com.company;

import collections.*;
import org.bson.Document;

import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.util.Map.entry;

public class Script {

    Department department = new Department();
    Group group = new Group();
    Member member = new Member();
    Publication publication = new Publication();

    private int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    private String getRandom(String departmentOrGroup){
        String result = "";
        Random rand = new Random();
        for(int i = 0; i < 5; i++){
            int add = rand.nextInt(2);
            if(add == 1){
                result += departmentOrGroup + i + ",";
            }
        }
        if(result.isEmpty()){
            return departmentOrGroup + rand.nextInt(5);
        }
        return result.substring(0, result.length() - 1);
    }

    public void generateScript(){

        //vytvorenie pracovnych skupin a oddeleni
        HashMap<String, String> groupAndDepartment = new HashMap<>();
        for(int i = 0; i < 5; i++){
            groupAndDepartment.put("name", "DEP" + i);
            department.insert(groupAndDepartment);
            groupAndDepartment.put("name", "GROUP" + i);
            group.insert(groupAndDepartment);
        }

        //vytvorenie zamestnancov
        HashMap<String, String> memberMap = new HashMap<>();
        Random rand = new Random();

        for(int i = 0; i < 5; i++){
            memberMap.put("name:first", "fN" + i);
            memberMap.put("name:last", "lN" + i);
            memberMap.put("email", "fN" + i + "lN@uniba.sk" );
            LocalDate randomDate = createRandomDate(1900, 2000);
            memberMap.put("dateOfBirth", randomDate.toString());
            memberMap.put("departmentId", getRandom("DEP"));
            memberMap.put("groupId", getRandom("GROUP"));
            member.insert(memberMap);
        }

        //vytvorenie atributov ku jednotlivym publikaciam
        ArrayList<Map> attributes = new ArrayList<>();
        ArrayList<Document> allMember = member.listALl();

        Map<String, String> attr1 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:publisher", "Publisher2"), entry("attributes:title", "Kniha o matematike"), entry("attributes:volume", "vol"), entry("attributes:year", "2015")
        );
        attributes.add(attr1);

        Map<String, String> attr2 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:publisher", "PublisherXX"), entry("attributes:title", "Kniha o logike"), entry("attributes:year", "2018")
        );
        attributes.add(attr2);

        Map<String, String> attr3 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:journal", "jourXX"), entry("attributes:number", "5"), entry("attributes:pages", "3"), entry("attributes:title", "Article about everything"), entry("attributes:year", "2017")
        );
        attributes.add(attr3);

        Map<String, String> attr4 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:journal", "journalYY"), entry("attributes:pages", "12"), entry("attributes:title", "Article about XZ"), entry("attributes:year", "2018")
        );
        attributes.add(attr4);

        Map<String, String> attr5 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:note", "interesting note"), entry("attributes:publisher", "PublisherXX"), entry("attributes:title", "Kniha o robotoch"), entry("attributes:year", "2018")
        );
        attributes.add(attr5);

        Map<String, String> attr6 = Map.ofEntries(
                entry("attributes:institution", "Institute"), entry("attributes:title", "Report about bla bla"), entry("attributes:year", "2017")
        );
        attributes.add(attr6);

        Map<String, String> attr7 = Map.ofEntries(
                entry("attributes:title", "The Best Manual"), entry("attributes:year", "2018")    );
        attributes.add(attr7);

        Map<String, String> attr8 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:booktitle", "Booooook"), entry("attributes:publisher", "PublisherXX"), entry("attributes:title", "Collection"), entry("attributes:year", "2015")
        );
        attributes.add(attr8);

        Map<String, String> attr9 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:school", "UK Bratislava"),  entry("attributes:title", "Thesis about world"), entry("attributes:year", "2017")    );
        attributes.add(attr9);

        Map<String, String> attr10 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:note", "Coming soon"), entry("attributes:title", "Bla Bla")
        );
        attributes.add(attr10);

        Map<String, String> attr11 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:publisher", "Publisher2"), entry("attributes:title", "Kniha o vesmire"), entry("attributes:year", "2018")
        );
        attributes.add(attr11);

        Map<String, String> attr12 = Map.ofEntries(
                entry("attributes:author", allMember.get(rand.nextInt(allMember.size())).get("_id").toString()), entry("attributes:title", "The worst manual 2"), entry("attributes:pages", "45"), entry("attributes:year", "2017")
        );
        attributes.add(attr12);


        //vytvorenie publikacii
        Map<String, String> publicationMap = new HashMap<>();
        for(int i = 0; i < attributes.size(); i++){
            if(i == 0 || i == 1 || i == 4 || i == 10){
                publicationMap.put("type", "book");
            } else if(i == 2 || i == 3 ){
                publicationMap.put("type", "article");
            } else if(i == 5){
                publicationMap.put("type", "tech report");
            } else if(i == 6 || i == 11){
                publicationMap.put("type", "manual");
            } else if(i == 7){
                publicationMap.put("type", "incollection");
            } else if(i == 8){
                publicationMap.put("type", "mastersthesis, phdthesis");
            } else if(i == 9){
                publicationMap.put("type", "unpublished");
            }
            publicationMap.put("category", "AAA");
            publicationMap.putAll(attributes.get(i));
            publication.insert((HashMap)publicationMap);
            publicationMap = new HashMap<>();
        }
    }

}
