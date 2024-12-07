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
    public Appointment(){}

    //getters and setters
    public String getAptId(){
        return appointmentId;
    }

    public void setAptId(String id){
        this.appointmentId = id;
    }
    public String getPatientId(){
        return patientId;
    }
    public void setPatientId(String pid){
        this.patientId = pid;
    }
    public String getStaffId(){
        return staffId;
    }
    public void setStaffId(String sid){
        this.staffId = sid;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String d){
        this.date = d;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String st){
        this.status = st;
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

    

    public void viewApt() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Staff ID: " + staffId);
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);
    }

    public void viewAllApt(){
        
    }
}
