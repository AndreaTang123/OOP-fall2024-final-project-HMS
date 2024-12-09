
public class Patient {
	
	//attributes
	private String id;
	private String name;
    private String age;
	private String gender;
	
	
	
	//constructor
	public Patient(String id, String name, String gender, String age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
     
        
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

    public void editDetails(String name, String gender, String id, String age){
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.age = age;
    }

  
    
    
   

    
    
   

}
