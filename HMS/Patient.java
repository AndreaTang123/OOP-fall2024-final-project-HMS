
public class Patient {
	
	//attributes
	private String id;
	private String name;
    private String age;
	private String gender;
	
	
	
	//constructor
	public Patient(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
     
        
    }
	public Patient() {}
	
	// Getter and Setter methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sexuality) {
        this.gender = sexuality;
    }

   
    //methods
    public String viewPatient() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
      
    }

    public void addPatient(String name, String gender, String id, String age) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.age = age;
    }
    
    public void removePatient() {
        this.name = null;
        this.gender = null;
        this.id = null;
        this.age = null;
     
         
    }
    public void editPatient(String name, String gender, String id, String age){
        removePatient();
        addPatient(name, gender,id,age);
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
