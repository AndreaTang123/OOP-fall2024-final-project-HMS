import java.util.*;

public class patientManager {

    public patientManager() {
        patients.add(new Patient("P001", "John Doe", "Male", "35"));
        patients.add(new Patient("P002", "Jane Smith", "Female", "28"));
        patients.add(new Patient("P003", "Alice Johnson", "Female", "40"));
    }

    private List<Patient> patients = new ArrayList<>(); 
    
    // Add a new patient
    public void addPatient(Patient patient){
        patients.add(patient);
    }

    // Search methods that return a list of patients with full details
    public List<Patient> searchPatientById(String id) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                result.add(patient);
            }
        }
        return result; // Return list of patients with the same ID
    }

    public List<Patient> searchPatientByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                result.add(patient);
            }
        }
        return result; // Return list of patients with the same name
    }

    // View all patients
    public List<Patient> viewAllPatient(){
        return patients;
    }

    // Remove a patient
    public boolean deletePatient(Patient selected){
        if(selected != null && patients.contains(selected)){
            patients.remove(selected);
            return true;
        }
        return false;
    }

    // Edit patient details
    public boolean editPatient(Patient selected, String name, String gender, String id, String age){
        if(selected != null && patients.contains(selected)){
            selected.editDetails(name, gender, id, age);
            return true;
        }
        return false;
    }
}
