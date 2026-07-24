package FILEBASEDHOTELMANAGEMENT;
import java.util.Scanner;
import java.util.ArrayList;

class HotelService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Guest> guest = new ArrayList<>();
    static ArrayList<Room> room = new ArrayList<>();
    static ArrayList<Reservation> reservation = new ArrayList<>();

    void addRoom() {
        while(true) {
            System.out.println("=====ADD-ROOM=====");
            System.out.println("Enter room number: (DLX-XXX)");
            String roomNumber = scanner.nextLine();

            if(!roomNumber.matches("(DLX)-\\d{3}")) {
                System.out.println("Invalid room number format.");
                continue;
            }

            System.out.println("\nRoom types: " 
            + "\nStandard" 
            + "\nDeluxe" 
            + "\nSuite");
            
            System.out.println("Enter room type: ");
            String roomType = scanner.nextLine();

            if(!roomType.matches("(Standard|Deluxe|Suite)")) {
                System.out.println("Invalid room type.");
                continue;
            }

            System.out.println("\nCapacity guide: "
            + "\nStandard: 3 Person"
            + "\nDeluxe: 6 Person"
            + "\nSuite: 10 Person"
            );

            System.out.println("Enter room capacity: ");
            int capacity;

            try {
                capacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(!roomType.matches("(Standard|Deluxe|Suite)")) {
                System.out.println("Invalid room type.");
            }

            if(capacity > 3 || capacity < 3) {
                if(roomType.equals("Standard")) {
                    System.out.println("Cannot set less or more than 3 person for standard room type.");
                    continue;
                }
            }

            if(capacity > 6 || capacity < 6) {
                if(roomType.equals("Deluxe")) {
                    System.out.println("Cannot set less or more than 6 person for deluxe room type.");
                    continue;
                }
            }

            if(capacity > 10 || capacity < 10) {
                if(roomType.equals("Suite")) {
                    System.out.println("Cannot set less or more than 10 person for suite room type.");
                    continue;
                }
            }
            
            System.out.println("Enter price per night: ");
            double price;

            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                continue;
            }

            if(price <= 0.0) {
            System.out.println("Cannot set 0 or negative numbers.");
            }

            Room newRoom = new Room(roomNumber, roomType, capacity, price);
            String result = newRoom.setStatus();
            room.add(newRoom);
            System.out.println(result);
            System.out.println("Successfully created room.");
            return;
        }
    }
    void viewRooms() {
        if(room.isEmpty()) {
            System.out.println("No available rooms.");
            return;
        }

        for(int i = 0; i < room.size(); i++) {
            Room view = room.get(i);
            System.out.println((i + 1) 
                    + ".) " + "Room number: " + view.getRoomNumber() 
                    + " | Room type: " + view.getRoomType() 
                    + " | Room capacity: " + view.getRoomCapacity() 
                    + " | Price per night: $" + view.getPricePerNight()
                    + " | Room status: " + view.getStatus());
        }
    }
    void searchRoom() {
        while(true) {
            System.out.println("=====SEARCH-ROOM=====");
            System.out.println("Enter room number: ");
            String search = scanner.nextLine();

            for(int i = 0; i < room.size(); i++) {
                Room findRoom = room.get(i);
                if(search.contains(findRoom.getRoomNumber())) {
                    System.out.println("Room found!");
                    System.out.println((i + 1) 
                    + ".) " + "Room number: " + findRoom.getRoomNumber() 
                    + " | Room type: " + findRoom.getRoomType() 
                    + " | Room capacity: " + findRoom.getRoomCapacity() 
                    + " | Price per night: $" + findRoom.getPricePerNight()
                    + " | Room status: " + findRoom.getStatus());
                    return;
                }
            }
            System.out.println("Room not found!");
            return;
        }
    }
    void updateRoom() {
        if(room.isEmpty()) {
            viewRooms();
        }

        viewRooms();
        System.out.println("Pick a room to update: ");
    }
    void removeRoom() {

    }
    void addGuest() {

    }
    void searchGuest() {

    }
    void reserveRoom() {

    }
    void cancelReservation() {

    }
    void checkIn() {

    }
    void checkOut() {

    }
    void viewReservations() {

    }
}
