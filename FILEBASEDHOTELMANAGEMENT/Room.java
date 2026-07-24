package FILEBASEDHOTELMANAGEMENT;

class Room {
    private String roomNumber;
    private String roomType;
    private int capacity;
    private double pricePerNight;
    private String roomStatus;

    Room(String roomNumber, String roomType, int capacity, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.roomStatus = "Available";
    }

    void displayRoom() {

    }
    String setStatus() {
        if(roomStatus.equals("Available")) {
            return "Room " + roomNumber + " is already available.";
        }
        return "Succesfully set room to " + roomStatus;
    }
    String getStatus() {
        return roomStatus;
    }
    String getRoomNumber() {
        return roomNumber;
    }
    String getRoomType() {
        return roomType;
    }
    int getRoomCapacity() {
        return capacity;
    }
    double getPricePerNight() {
        return pricePerNight;
    }
}
