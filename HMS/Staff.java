
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
    public void addStaff(String name, String id, String role, String contact) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.contact = contact;
        this.status = status;
    }

    public void viewStaff() {
        System.out.println("Staff Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Role: " + role);
        System.out.println("Contact: " + contact);
        System.out.println("Status: " + status);
    }
    
    public void removeStaff() {
    	
    }
 
    public boolean editStaff(String name, String id, String role, String contact) {
    	
    }
    

    public void editStatus(String newStatus) {
        this.status = newStatus;
    }

    public boolean searchStaff(String keyword) {
        return name.contains(keyword) || id.contains(keyword) || role.contains(keyword);
    }

}
