package FILEBASEDHOTELMANAGEMENT;
import java.io.IOException;
import java.util.Scanner;

public class HotelMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        HotelService service = new HotelService();
        FileManager manager = new FileManager();
        while(true) {
            System.out.println("=====HOTEL-RESERVATION-MANAGEMENT=====");
            System.out.println("[1] Add Room");
            System.out.println("[2] View Rooms");
            System.out.println("[3] Search Room");
            System.out.println("[4] Update Room");
            System.out.println("[5] Remove Room");
            System.out.println("[6] Reserve Room");
            System.out.println("[7] Cancel Reservation");
            System.out.println("[8] Check-In");
            System.out.println("[9] Check-Out");
            System.out.println("[10] View Reservations");
            System.out.println("[11] Save Data");
            System.out.println("[12] Load Data");
            System.out.println("[0] Exit");

            System.out.println("\nEnter option: ");
            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(option < 1 || option > 12) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.addRoom();
                case 2 -> service.viewRooms();
                case 3 -> service.searchRoom();
                case 4 -> service.updateRoom();
                case 5 -> service.removeRoom();
                case 6 -> service.reserveRoom();
                case 7 -> service.cancelReservation();
                case 8 -> service.checkIn();
                case 9 -> service.checkOut();
                case 10 -> service.viewReservations();
                case 11 -> {
                    manager.saveGuest(HotelService.guest);
                    manager.saveRoom(HotelService.room);
                    manager.saveReservation(HotelService.guest,HotelService.room,HotelService.reservation);
                    System.out.println("Data saved successfully!");
                    return;
                }
                case 12 -> {
                    manager.loadGuest(HotelService.guest);
                    manager.loadRoom(HotelService.room);
                    manager.saveReservation(HotelService.guest,HotelService.room,HotelService.reservation);
                    System.out.println("Data loaded successfully!");
                    return;
                }
            }
        }
    }
}
