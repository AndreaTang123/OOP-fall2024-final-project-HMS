import java.util.*;
public class Patient {
	
	//attributes
	private String id;
	private String name;
	private String sexuality;
	private String birthdate;
	private List<String> appointments;
	
	//constructor
	public Patient(String id, String name, String sexuality, String birthdate) {
        this.id = id;
        this.name = name;
        this.sexuality = sexuality;
        this.birthdate = birthdate;
        this.appointments = new ArrayList<>();
    }
	public Patient() {}
	
	// Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void addAppointment(String appointment) {
        this.appointments.add(appointment);
    }
    
    //methods
    public void addPatient(String name, String sexuality, String id, String birthdate) {
        this.name = name;
        this.sexuality = sexuality;
        this.id = id;
        this.birthdate = birthdate;
    }
    
    public void removePatient() {
        this.name = null;
        this.sexuality = null;
        this.id = null;
        this.birthdate = null;
        this.appointments.clear();
    }
    
    public void viewPatient() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Sexuality: " + sexuality);
        System.out.println("Birthdate: " + birthdate);
        System.out.println("Appointments: " + appointments);
    }
    
    public boolean searchPatientByName(String name) {
        return this.name != null && this.name.contains(name);
    }

    public boolean searchPatientById(String id) {
        return this.id != null && this.id.equals(id);
    }
    
   

}
