package ui.Menu;
import collections.Group;

import java.io.IOException;
import java.sql.SQLException;

public class GroupMenu extends ClassMenu {

    public GroupMenu() {
        super(new Group());
    }

    @Override
    public void print() {
        System.out.println("************************************************");
        System.out.println("* 1. list of all group                         *");
        System.out.println("* 2. add new group                             *");
        System.out.println("* 3. edit group                                *");
        System.out.println("* 4. delete group                              *");
        System.out.println("* 5. exit                                      *");
        System.out.println("************************************************");
    }

    @Override
    public void handle(String option) throws IOException, SQLException {
        super.handle(option);
    }

}
