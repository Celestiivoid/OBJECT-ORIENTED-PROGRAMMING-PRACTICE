package LIBRARYMANAGEMENTV1;
import java.util.Scanner;

public class LibraryManagementMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        while(true) {
            System.out.println("=====LIBRARY-MANAGEMENT=====");
            System.out.println("[1] Add Book");
            System.out.println("[2] View Books");
            System.out.println("[3] Borrow Book");
            System.out.println("[4] Return Book");
            System.out.println("[5] Search Book");
            System.out.println("[6] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range!");
                continue;
            }

            switch(option) {
                case 1 -> service.addBook();
                case 2 -> service.viewBooks();
                case 3 -> service.borrowBook();
                case 4 -> service.returnBook();
                case 5 -> service.searchBook();
                case 6 -> {
                    while(true) {
                        System.out.println("Do you want to exit? (Yes/No)");
                        String exit = scanner.nextLine();
                        
                        if(exit.equalsIgnoreCase("Yes")) {
                            return;
                        }
                        else if(exit.equalsIgnoreCase("No")) {
                            break;
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }
                }
            }
        }
    }
}
