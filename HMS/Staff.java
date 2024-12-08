

public class Staff {
	
	//attributes
	private String name;
    private String id;
    private String role;
    private String contact;
    private String status;
    
    
 // Constructor
    public Staff(String name, String id, String role, String department, String contact, String status) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.contact = contact;
        this.status = "active";
        
    }
    
 // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
 // Methods
    

    public String viewStaff() {
        return "ID: " + id + ", Name: "+ name + ", Role: "+ role + ", Contact: "+ contact + ", Status: "+ status;
    }
    
    public void editDetails(String name, String id, String role, String contact){
        this.name = name;
        this.id = id;
        this.role = role;
        this.contact = contact;

    }

    public void editStatus(String status){
        this.status = status;
    }

}
