package ui.Menu;

import collections.Member;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;

public class MemberMenu extends ClassMenu {

    public MemberMenu() {
        super(new Member());
    }

    @Override
    public void print() {
        System.out.println("************************************************");
        System.out.println("* 1. list of all members                       *");
        System.out.println("* 2. add new member                            *");
        System.out.println("* 3. edit member                               *");
        System.out.println("* 4. delete member                             *");
        System.out.println("* 5. exit                                      *");
        System.out.println("************************************************");
    }

    @Override
    public void handle(String option) throws IOException, SQLException {
        super.handle(option);
    }

    @Override
    public HashMap<String, String> getInfo() throws IOException {
        HashMap<String, String> info = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter first name:");
        String first_name = br.readLine();
        info.put("name:first", first_name);

        System.out.println("Enter last name:");
        String last_name = br.readLine();
        info.put("name:last", last_name);

        System.out.println("Enter email:");
        String email = br.readLine();
        info.put("email", email);

        System.out.println("Enter date of birth:");
        String date = br.readLine();
        info.put("dateOfBirth", date);

        System.out.println("Enter department (if person is in more departments, split it with comma ):");
        String department = br.readLine();
        info.put("departmentId", department);

        System.out.println("Enter group (if person is in more groups, split it with comma ):");
        String group = br.readLine();
        info.put("groupId", group);

        return info;
    }

}
