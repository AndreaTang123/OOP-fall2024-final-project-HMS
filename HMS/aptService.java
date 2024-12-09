import java.util.*;;

public class aptService {
    private List<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

 // Search by patient name
    public List<Appointment> searchAppointmentByPatient(String pname) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equalsIgnoreCase(pname)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Search by staff name
    public List<Appointment> searchAppointmentByStaff(String sname) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getStaffId().equalsIgnoreCase(sname)) {
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