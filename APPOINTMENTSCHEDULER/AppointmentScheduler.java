package APPOINTMENTSCHEDULER;

import java.util.Scanner;


public class AppointmentScheduler {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();
        while(true) {
            System.out.println("=====APPOINTMENT-SCHEDULER=====");
            System.out.println("[1] Add Appointment");
            System.out.println("[2] View Appointments");
            System.out.println("[3] Book Appointment");
            System.out.println("[4] Cancel Appointment");
            System.out.println("[5] Search Appoinment");
            System.out.println("[6] Exit");

            System.out.println("\nEnter option: ");
            int option;
            
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(option < 1 || option > 6) {
                System.out.println("Out of range.");
                continue;
            }

            switch(option) {
                case 1 -> service.addAppointment();
                case 2 -> service.viewAppointment();
                case 3 -> service.bookAppointment();
                case 4 -> service.cancelAppointment();
                case 5 -> service.searchAppointment();
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
                            System.out.println("Invalid input.");
                        }
                    }
                }
            }
        }
    }    
}
