import java.util.*;;

public class aptService {
    private List<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    //search 
    public Appointment searchAppointmentByPatient(String pid) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId() == pid) {
                return appointment;
            }
        }
        return null; // Not found
    }

    public Appointment searchAppointmentByStaff(String sid) {
        for (Appointment appointment : appointments) {
            if (appointment.getStaffId() == sid) {
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
    public boolean editApt (Appointment selected, String pid, String sid, String date)
}
