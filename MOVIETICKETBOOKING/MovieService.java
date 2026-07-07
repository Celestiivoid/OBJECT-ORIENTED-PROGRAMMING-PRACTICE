package MOVIETICKETBOOKING;
import java.util.Scanner;
import java.util.ArrayList;

class MovieService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Movie> movie = new ArrayList<>();

    void addMovie() {
        while(true) {
            System.out.println("=====ADD-MOVIE=====");
            System.out.println("Enter movie title: ");
            String title = scanner.nextLine();

            if(title.isEmpty()) {
                System.out.println("Title field cannot be empty.");
                return;
            }

            System.out.println("Enter ticket price per seats: ");
            double price;

            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(price <= 0.0) {
                System.out.println("Cannot set 0 or negative numbers for price field.");
                continue;
            }

            System.out.println("Enter seats maximum: ");
            int max;

            try {
                max = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(max <= 0) {
                System.out.println("Cannot set 0 or negative numbers for seats field.");
                continue;
            }

            Movie newMovie = new Movie(title, price, max, max);
            movie.add(newMovie);
            System.out.println("Successfully added, " + newMovie.getMovieTitle() + "!");
            return;
        }
    }
    void viewMovies() {
        System.out.println("=====VIEW-MOVIES=====");
        if(movie.isEmpty()) {
            System.out.println("No available movies.");
            return;
        }

        for(int i = 0; i < movie.size(); i++) {
            Movie view = movie.get(i);
            System.out.println("Movie name: " + view.getMovieTitle() 
            + " | Ticket price: " + view.getTicketPrice() 
            + " | Available seats: " + view.getAvailableSeats() + "/" + view.getAvailableSeatsMaximum());
        }
    }

    void forBookingAndCancelling() {
        if(movie.isEmpty()) {
            System.out.println("No available movies.");
            return;
        }

        for(int i = 0; i < movie.size(); i++) {
            Movie multi = movie.get(i);
            System.out.println((i + 1) + ".)" + " Movie name: " + multi.getMovieTitle() 
            + " | Ticket price: " + multi.getTicketPrice() 
            + " | Available seats: " + multi.getAvailableSeats() + "/" + multi.getAvailableSeatsMaximum());
        }
    }
    void bookTicket() {
        while(true) {
            if(movie.isEmpty()) {
                forBookingAndCancelling();
                return;
            }

            forBookingAndCancelling();
            System.out.println("Select a movie: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(pick < 1 || pick > movie.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Movie selectedMovie = movie.get(pick - 1);

            System.out.println("Enter amount of seats to book: ");
            int book;

            try {
                book = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

             String result = selectedMovie.bookSeats(book);
             System.out.println("Total price: " + selectedMovie.calculateTotal(book));
             System.out.println(result);
             return;
        }
    }
    void cancelTicket() {
        while(true) {
            System.out.println("=====CANCEL-TICKET=====");

            if(movie.isEmpty()) {
                forBookingAndCancelling();
            }

            forBookingAndCancelling();
            System.out.println("Pick a movie: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick < 1 || pick > movie.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Movie selectedMovie = movie.get(pick - 1);

            System.out.println("Enter amount of seats to cancel: ");
            int cancel;

            try {
                cancel = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(cancel > selectedMovie.getAvailableSeatsMaximum()) {
                System.out.println("Cannot cancel more than the maximum seats available.");
                continue;
            }

            String result = selectedMovie.cancelSeats(cancel);
            System.out.println(result);
            return;
        }
    }
    void searchMovie() {
        while(true) {
            System.out.println("=====SEARCH-MOVIE=====");
            System.out.println("Search movie by name: ");
            String search = scanner.nextLine();

            if(search.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                return;
            }

            for(int i = 0; i < movie.size(); i++) {
                Movie searchMovie = movie.get(i);
                if(search.equalsIgnoreCase(searchMovie.getMovieTitle())) {
                    System.out.println("Movie found!");
                    searchMovie.displayMovie();
                    return;
                }
            }

            System.out.println("Movie not found.");
            return;
        }
    }

    void soldOuts() {
        while(true) {
            boolean ifSold = false;

            for(int i = 0; i < movie.size(); i++) {
                Movie sold = movie.get(i);
                if(sold.getAvailableSeats() == 0) {
                    ifSold = true;
                    sold.displayMovie();
                    return;
                }
            }

            if(!ifSold) {
                System.out.println("No sold out movies at the moment.");
            }
        }
    }
}
