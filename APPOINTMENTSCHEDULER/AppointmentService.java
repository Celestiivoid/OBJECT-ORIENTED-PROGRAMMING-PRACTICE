package APPOINTMENTSCHEDULER;

import java.util.Scanner;
import java.util.ArrayList;

class AppointmentService {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Appointment> appointment = new ArrayList<>();

    void addAppointment() {
        while(true) {
            System.out.println("=====ADD-APPOINTMENT=====");
            System.out.println("Enter patient name: ");
            String patient = scanner.nextLine();

            if(patient.isEmpty()) {
                System.out.println("Patient field cannot be empty.");
                continue;
            }

            System.out.println("Enter doctor name: ");
            String doctor = scanner.nextLine();

            if(doctor.isEmpty()) {
                System.out.println("Doctor field cannot be empty.");
                continue;
            }
            
            System.out.println("Enter schedule: (XX:XX(AM|PM))");
            String schedule = scanner.nextLine();

            if(!schedule.matches("\\d{2}:\\d{2}(AM|PM)")) {
                System.out.println("Invalid schedule.");
                continue;
            }

            for(int i = 0; i < appointment.size(); i++) {
                Appointment find = appointment.get(i);
                if(find.getDoctorName().equalsIgnoreCase(doctor) && find.getSchedule().equalsIgnoreCase(schedule)) {
                    System.out.println("Schedule of " + find.getDoctorName() + " at " + find.getSchedule() + " is already appointed.");
                    return;
                }
            }
            Appointment newAppointment = new Appointment(patient, doctor, schedule);
            appointment.add(newAppointment);
            System.out.println("Appointment reserved successfully.");
            return;
        }
    }
    void viewAppointment() {
        if(appointment.isEmpty()) {
            System.out.println("No appointments at the moment.");
            return;
        }

        for(int i = 0; i < appointment.size(); i++) {
            Appointment display = appointment.get(i);
            display.displayAppointment();
        }
    }

    void forBookingAndCancelling() {
        for(int i = 0; i < appointment.size(); i++) {
                Appointment booking = appointment.get(i);
                System.out.println((i + 1) + ".) " + "Patient name: " + booking.getPatientName() 
                + " | Doctor name: " + booking.getDoctorName() 
                +  " | Time schedule: " + booking.getSchedule() 
                + " | Status: " + booking.getBooked());
            }
    }
    void bookAppointment() {
        while(true) {
            System.out.println("=====BOOK-APPOINTMENT=====");
            if(appointment.isEmpty()) {
                viewAppointment();
            }

            forBookingAndCancelling();
            System.out.println("Pick appointment to book: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick < 1 || pick > appointment.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Appointment selectedAppointment = appointment.get(pick - 1);

            String result = selectedAppointment.bookAppointment();
            System.out.println(result);
            return;
        }
    }
    void cancelAppointment() {
        while(true) {
            System.out.println("=====CANCEL-APPOINTMENT=====");
            if(appointment.isEmpty()) {
                viewAppointment();
            }
            
            forBookingAndCancelling();
            System.out.println("Pick appointment to cancel: ");
            int pick;

            try {
                pick = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
                continue;
            }

            if(pick < 1 || pick > appointment.size()) {
                System.out.println("Out of range.");
                continue;
            }

            Appointment cancelAppointment = appointment.get(pick - 1);
            String result = cancelAppointment.cancealAppointment();
            System.out.println(result);
            return;
        }
    }
    void searchAppointment() {
        while(true) {
            System.out.println("=====SEARCH-APPOINTMENT=====");
            System.out.println("Enter appointment by patient or doctor name: ");
            String searchName = scanner.nextLine();

            if(searchName.isEmpty()) {
                System.out.println("Search field cannot be empty.");
                continue;
            }
            for(int i = 0; i < appointment.size(); i++) {
                Appointment search = appointment.get(i);
                if(searchName.equalsIgnoreCase(search.getPatientName()) || searchName.equalsIgnoreCase(search.getDoctorName())) {
                    System.out.println("Appointment/s found!");
                    System.out.println("Patient name: " + search.getPatientName() + " | Doctor name: " + search.getDoctorName());
                }
            }
        }
    }
}