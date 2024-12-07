public class Appointment {

    private String appointmentId;
    private String patientId;
    private String staffId;
    private String date;
    private String status;

    // Constructor
    public Appointment(String appointmentId, String patientId, String staffId, String date, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.staffId = staffId;
        this.date = date;
        this.status = status;
    }

    // Methods
    public void bookApt(String appointmentId, String patientId, String staffId, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.staffId = staffId;
        this.date = date;
        this.status = "booked";
    }

    public void editApt(String date, String status) {
        if (date != null) this.date = date;
        if (status != null) this.status = status;
    }

    public void cancelApt() {
        this.status = "cancelled";
    }

    public boolean searchAptByPatient(String patientId) {
        if (this.patientId != null && this.patientId.equals(patientId)) {
            viewApt();
            return true;
        }
        return false;
    }

    public boolean searchAptByStaff(String staffId) {
        if (this.staffId != null && this.staffId.equals(staffId)) {
            viewApt();
            return true;
        }
        return false;
    }

    public void viewApt() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Staff ID: " + staffId);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }
}
