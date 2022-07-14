package ui.Menu;

import collections.Department;

import java.io.IOException;
import java.sql.SQLException;

public class DepartmentMenu extends ClassMenu {

    public DepartmentMenu() {
        super(new Department());
    }

    @Override
    public void print() {
        System.out.println("************************************************");
        System.out.println("* 1. list of all departments                   *");
        System.out.println("* 2. add new department                        *");
        System.out.println("* 3. edit department                           *");
        System.out.println("* 4. delete department                         *");
        System.out.println("* 5. exit                                      *");
        System.out.println("************************************************");
    }

    @Override
    public void handle(String option) throws IOException, SQLException {
        super.handle(option);
    }


}
