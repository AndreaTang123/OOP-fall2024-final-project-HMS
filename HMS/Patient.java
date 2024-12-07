
public class Patient {
	
	//attributes
	private String id;
	private String name;
	private String sexuality;
	private String birthdate;
	
	
	//constructor
	public Patient(String id, String name, String sexuality, String birthdate) {
        this.id = id;
        this.name = name;
        this.sexuality = sexuality;
        this.birthdate = birthdate;
        
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
     
         
    }
    public void editPatient(String name, String sexuality, String id, String birthdate){
        removePatient();
        addPatient(name, sexuality,id,birthdate);
    }
    
    public void viewPatient() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Sexuality: " + sexuality);
        System.out.println("Birthdate: " + birthdate);
      
    }
    
    public boolean searchPatientByName(String name) {
        if(this.name != null && this.name.equals(name)){
            viewPatient();
            return true;
        }
        return false;
    }

    public boolean searchPatientById(String id) {
        if(this.id != null && this.id.equals(id)){
            viewPatient();
            return true;
        }
        return false;
    }
    
   

}
