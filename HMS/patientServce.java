import java.util.*;

public class patientServce {

  private List<Patient> patients = new ArrayList<>(); 
  
  // Add a new patient
  public void addPatient(Patient patient){
    patients.add(patient);
  }

  //search methods
  public Patient searchPatientById(String id) {
    for (Patient patient : patients) {
        if (patient.getId() == id) {
            return patient;
        }
    }
    return null; // Not found
  }

  public Patient searchPatientByName(String name){
    for (Patient patient : patients) {
        if (patient.getName() == name) {
            return patient;
        }
    }
    return null;
  }

  //view all patient
  public List<Patient> viewAllPatient(){
    return patients;
  }

  

  //edit
  public boolean editPatient(String name, String gender, String id, String age){

  }


    





}
