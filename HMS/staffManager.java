import java.util.*;

public class staffManager {
    private List<Staff> staffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    //search methods
    public Staff searchStaffById(String id){
        for(Staff staff: staffList){
            if(staff.getId()==id){
                return staff;
            }
        }
        return null;
    }

    public Staff searchStaffByName(String name){
        for(Staff staff: staffList){
            if(staff.getName()==name){
                return staff;
            }
        }
        return null;
    }

    //view all staff
    public List<Staff> viewAllStaff() {
        return staffList;
    }

    
    //remove patient
    public boolean deleteStaff(Staff selected){
        if(selected!= null && staffList.contains(selected)){
            staffList.remove(selected);
            return true;
        }
        return false;
    }

    //edit
    public boolean editStaff(Staff selected, String name, String id, String role, String contact){
        if(selected!= null && staffList.contains(selected)){
            selected.editDetails(name, id, role, contact);
            return true;
        }
        return false;
    }

    public boolean editStaffStatus( Staff selected, String status){
        if(selected!= null && staffList.contains(selected)){
            selected.editStatus(status);
            return true;
        }
        return false;
    }



}
