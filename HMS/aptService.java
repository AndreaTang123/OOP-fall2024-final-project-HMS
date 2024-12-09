import java.util.*;;

public class aptService {
    private List<Appointment> appointments = new ArrayList<>();

    public aptService(){
        // Pre-store three appointment objects
        appointments.add(new Appointment("P001", "S001", "2024-12-10", "Scheduled"));
        appointments.add(new Appointment("P002", "S002", "2024-12-11", "Scheduled"));
        appointments.add(new Appointment("P003", "S003", "2024-12-12", "Scheduled"));
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

 // Search by patientid
    public List<Appointment> searchAppointmentByPatient(String pid) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equalsIgnoreCase(pid)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Search by staffid
    public List<Appointment> searchAppointmentByStaff(String sid) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getStaffId().equalsIgnoreCase(sid)) {
                result.add(appointment);
            }
        }
        return result;
    }

    //view all
    public List<Appointment> viewAllAppointments() {
        return appointments;
    }
    
    //edit 
    public boolean editApt (Appointment selected, String pid, String sid, String date){
        if (selected != null) {
            selected.editDetails(pid, sid, date);
            return true;
        }
        return false;
    }

    public boolean editStatus(Appointment selected, String status){
        if (selected != null) {
            selected.editStatus(status);
            return true;
        }
        return false;
    }

    public boolean cancelApt(Appointment apt){
        if(apt!=null && appointments.contains(apt)){
            appointments.remove(apt);
            return true;
        }
        return false;
    }
    

}