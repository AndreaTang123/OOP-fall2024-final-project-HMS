public class Appointment {


    private static int counter = 0;
    private int appointmentId;
    private String patientId;
    private String staffId;
    private String date;
    private String status;

    // Constructor
    public Appointment(String patientId, String staffId, String date, String status) {
        this.appointmentId = ++ counter;
        this.patientId = patientId;
        this.staffId = staffId;
        this.date = date;
        this.status = status;
    }
    public Appointment(){}

    //getters and setters
    public int getAptId(){
        return this.appointmentId;
    }

    public void setAptId(int id){
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
    public static void setCounter(int lastId){
        counter = lastId;
    }
    

    public String viewApt() {

        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Staff ID: " + staffId
        + " Date: " + date + ", Status: " + status;
    }

    public void editDetails(String pid, String sid, String date){
        this.patientId = pid;
        this.staffId = sid;
        this.date = date;
    }

    public void editStatus(String status){
        this.status = status;
    }
    
}