import java.util.*;

public class staffManager {
    private List<Staff> staffList = new ArrayList<>();

    // Add a new staff
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    // Search staff by ID (returns a list of matching staff)
    public List<Staff> searchStaffById(String id) {
        List<Staff> result = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff.getId().equals(id)) {
                result.add(staff);
            }
        }
        return result; // Return list of matching staff
    }

    // Search staff by name (returns a list of matching staff)
    public List<Staff> searchStaffByName(String name) {
        List<Staff> result = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff.getName().equals(name)) {
                result.add(staff);
            }
        }
        return result; // Return list of matching staff
    }

    // View all staff
    public List<Staff> viewAllStaff() {
        return staffList;
    }

    // Remove a staff
    public boolean deleteStaff(Staff selected) {
        if (selected != null && staffList.contains(selected)) {
            staffList.remove(selected);
            return true;
        }
        return false;
    }

    // Edit staff details
    public boolean editStaff(Staff selected, String name, String id, String role, String contact) {
        if (selected != null && staffList.contains(selected)) {
            selected.editDetails(name, id, role, contact);
            return true;
        }
        return false;
    }

    // Edit staff status
    public boolean editStaffStatus(Staff selected, String status) {
        if (selected != null && staffList.contains(selected)) {
            selected.editStatus(status);
            return true;
        }
        return false;
    }
}
