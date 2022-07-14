package ui.Menu;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenu extends Menu {

        @Override
        public void print() {
            System.out.println("************************************************");
            System.out.println("* 1. continue with publications                *");
            System.out.println("* 2. continue with members of department       *");
            System.out.println("* 3. continue with groups                      *");
            System.out.println("* 4. continue with departments                 *");
            System.out.println("* 5. exit                                      *");
            System.out.println("************************************************");
        }

        @Override
        public void handle(String option) throws IOException, SQLException {
            Menu m;
            switch (option) {
                case "1":   m = new PublicationMenu(); m.run(); break;
                case "2":   m = new MemberMenu(); m.run(); break;
                case "3":   m = new GroupMenu(); m.run(); break;
                case "4":   m = new DepartmentMenu(); m.run(); break;
                case "5":   exit(); break;
                default:    System.out.println("Unknown option"); break;
            }
        }

        public static void main(String[] args) throws IOException, SQLException {
            MainMenu mainMenu = new MainMenu();
            mainMenu.run();
        }
}
