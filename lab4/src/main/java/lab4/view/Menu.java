package lab4.view;

public class Menu {


    public void displayMenu() {

        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|       Enter any combination of existing entity and CRUD number :      |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                  |                                    |");
        System.out.println("|            entity:               |                CRUD:               |");
        System.out.println("|__________________________________|____________________________________|");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 1 | computer                     | 1 | GET ALL                        |");
        System.out.println("| 2 | ir_phones                    | 2 | GET ONE BY ID                  |");
        System.out.println("| 3 | company                      | 3 | CREATE                         |");
        System.out.println("| 4 | monitor                      | 4 | UPDATE                         |");
        System.out.println("| 5 | server                       | 5 | DELETE                         |");
        System.out.println("| 6 | worker                       |   |                                |");
        System.out.println("|___|______________________________|___|________________________________|");

    }
}