import java.util.*;;

public class aptService {
    private List<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    //search 
    public Appointment searchAppointmentByPatient(String pid) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(pid)) {
                return appointment;
            }
        }
        return null; // Not found
    }

    public Appointment searchAppointmentByStaff(String sid) {
        for (Appointment appointment : appointments) {
            if (appointment.getStaffId().equals(sid)) {
                return appointment;
            }
        }
        return null; // Not found
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
