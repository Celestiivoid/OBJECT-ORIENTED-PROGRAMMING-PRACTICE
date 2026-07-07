package MOVIETICKETBOOKING;

class Movie {
    private String movieTitle;
    private double ticketPrice;
    private final int availableSeatsMaximum;
    private int availableSeats;

    Movie(String movieTitle, double ticketPrice, int availableSeats, int availableSeatsMaximum) {
        this.movieTitle = movieTitle;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
        this.availableSeatsMaximum = availableSeatsMaximum;
    }

    String bookSeats(int seats) {
        if(seats <= 0) {
            return "Cannot validate 0 or negative numbers";
        }
        if(availableSeats == 0) {
            return "Movie full.";
        }
        if(seats > getAvailableSeats()) {
            return "Only " + getAvailableSeats() + " seats are left for this movie.";
        }
        availableSeats -= seats;
        return "Booking successful.";
    }
    String cancelSeats(int seats) {
        if(seats <= 0) {
            return "Cannot set 0 or negative numbers for cancel field.";
        }

        if (getAvailableSeats() < getAvailableSeatsMaximum()) {
            availableSeats += seats;
            return "Successfully cancelled ticket.";
        }
        if(seats > getAvailableSeatsMaximum()) {
            return "Cannot cancel more than the maximum seats available.";
        }
        else {
            return "Cannot cancel more than the maximum seats available.";
        }
    }
    double calculateTotal(int seats) {
        double total = 0;
        if(seats <= 0) {
            return total = 0.0;
       }
        total = ticketPrice;
        return total *= seats;
    }
    void displayMovie() {
        System.out.println("Movie name: " + getMovieTitle() 
        + "\nTicket price: " + getTicketPrice() 
        + "\nAvailable seats: " + getAvailableSeats());
    }

    String getMovieTitle() {
        return movieTitle;
    }
    double getTicketPrice() {
        return ticketPrice;
    }
    int getAvailableSeatsMaximum() {
        return availableSeatsMaximum;
    }
    int getAvailableSeats() {
        return availableSeats;
    }
}
