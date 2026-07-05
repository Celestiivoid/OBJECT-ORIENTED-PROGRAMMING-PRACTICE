package APPOINTMENTSCHEDULER;

class Appointment {
    private String patientName;
    private String doctorName;
    private String schedule;
    private boolean isBooked;

    Appointment(String patientName, String doctorName, String schedule) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.schedule = schedule;
        this.isBooked = false;
    }

    String bookAppointment() {
        if(isBooked) {
            return "Appointment already booked.";
        }
        isBooked = true;
        return "Successfully booked " + patientName + " Appointment.";
    }
    String cancealAppointment() {
        if(!isBooked) {
            return "Appointment not booked.";
        }
        isBooked = false;
        return "Successfully cancelled " + patientName + " Appointment.";
    }
    void displayAppointment() {
        System.out.println("Patient: " + patientName);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Schedule: " + schedule);
        System.out.println("Status: " + getBooked());
    }

    String getPatientName() {
        return patientName;
    }
    String getDoctorName() {
        return doctorName;
    }
    String getSchedule() {
        return schedule;
    }
    String getBooked() {
        if(isBooked) {
            return "Booked";
        }
        else {
            return "Available for booking";
        }
    }
}
