package MOVIETICKETBOOKING;
import java.util.Scanner;
public class MovieTicketBooking {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MovieService service = new MovieService();
        while(true) {
            System.out.println("=====MOVIE-TICKET-BOOKING=====");
            System.out.println("[1] Add Movie");
            System.out.println("[2] View Movies");
            System.out.println("[3] Book Ticket");
            System.out.println("[4] Cancel Ticket");
            System.out.println("[5] Search Movie");
            System.out.println("[6] View Sold Out Movies");
            System.out.println("[7] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 7) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.addMovie();
                case 2 -> service.viewMovies();
                case 3 -> service.bookTicket();
                case 4 -> service.cancelTicket();
                case 5 -> service.searchMovie();
                case 6 -> service.soldOuts();
                case 7 -> {
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
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }
}
