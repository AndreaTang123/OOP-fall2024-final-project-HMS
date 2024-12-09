public class Patient {
    
    // Attributes
    private String id;
    private String name;
    private String age;
    private String gender;
    
    // Constructor
    public Patient(String id, String name, String gender, String age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Method to return a formatted string with all details
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
