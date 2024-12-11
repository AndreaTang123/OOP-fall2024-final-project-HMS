import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class SearchStaffGUI extends JFrame {
    private JPanel searchPane;
    private staffManager manager;
    private JList<String> staffList;
    private DefaultListModel<String> listModel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton editStatusButton;

    public SearchStaffGUI(JFrame parent, staffManager manager) {
        this.manager = manager;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        searchPane = new JPanel();
        searchPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(searchPane);
        searchPane.setLayout(null);

        JLabel title = new JLabel("Search Staff");
        title.setBounds(230, 50, 150, 30);
        searchPane.add(title);

        // Search by Name
        JLabel searchByNameLabel = new JLabel("Search by Name:");
        searchByNameLabel.setBounds(50, 100, 100, 30);
        searchPane.add(searchByNameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 150, 30);
        searchPane.add(nameField);

        JButton searchButtonByName = new JButton("Search");
        searchButtonByName.setBounds(300, 100, 80, 30);
        searchButtonByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                List<Staff> staffs = manager.searchStaffByName(name);  // Returns a list of matching staff
                updateStaffList(staffs);
            }
        });
        searchPane.add(searchButtonByName);

        // Search by ID
        JLabel searchByIDLabel = new JLabel("Search by ID:");
        searchByIDLabel.setBounds(50, 150, 100, 30);
        searchPane.add(searchByIDLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 150, 150, 30);
        searchPane.add(idField);

        JButton searchButtonByID = new JButton("Search");
        searchButtonByID.setBounds(300, 150, 80, 30);
        searchButtonByID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                List<Staff> staffs = manager.searchStaffById(id);  // Returns a list of matching staff
                updateStaffList(staffs);
            }
        });
        searchPane.add(searchButtonByID);

        // Create a scrollable area for displaying staff
        listModel = new DefaultListModel<>();
        staffList = new JList<>(listModel);
        staffList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(staffList);
        listScrollPane.setBounds(50, 200, 400, 150);
        searchPane.add(listScrollPane);

        // Edit and Delete and Edit status buttons
        editButton = new JButton("Edit");
        editButton.setBounds(460, 200, 80, 30);
        editButton.setEnabled(false);  // Initially disabled
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStaff();
            }
        });
        searchPane.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(460, 250, 80, 30);
        deleteButton.setEnabled(false);  // Initially disabled
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStaff();
            }
        });
        searchPane.add(deleteButton);
        
        editStatusButton = new JButton("Edit Status");
        editStatusButton.setBounds(460, 300, 120, 30);
        editStatusButton.setEnabled(false);  // Initially disabled
        editStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	editStatus();
            }
        });
        searchPane.add(editStatusButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(460, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                SearchStaffGUI.this.dispose();  // Close SearchStaffGUI when returning
            }
        });
        searchPane.add(returnButton);

        // Enable/Disable buttons based on selection
        staffList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && staffList.getSelectedIndex() != -1) {
                    editButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    editStatusButton.setEnabled(true);
                } else {
                    editButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    editStatusButton.setEnabled(false);
                }
            }
        });
    }

    // Update JList with search results (Name, ID, Sex, and Age)
    private void updateStaffList(List<Staff> staffs) {
        listModel.clear();
        for (Staff staff : staffs) {
            // Display all relevant staff details in the list
            listModel.addElement("Name: " + staff.getName() + ", ID: " + staff.getId() +
                                 ", Role: " + staff.getRole() + ", Contact: " + staff.getContact()+", Status: "+ staff.getStatus());
        }
    }

    // Edit the selected staff
    private void editStaff() {
        int selectedIndex = staffList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedStaffData = staffList.getSelectedValue();
            String id = selectedStaffData.split(",")[1].split(":")[1].trim();
            Staff staffToEdit = manager.searchStaffById(id).get(0);  // Get the first staff from the list

            if (staffToEdit != null) {
                EditStaffGUI g = new EditStaffGUI(this, staffToEdit, manager);  // Open the EditStaffGUI with selected staff
                g.setVisible(true);
                SearchStaffGUI.this.setVisible(false);
                SearchStaffGUI.this.dispose();  // Close SearchStaffGUI when opening EditStaffGUI
            }
        }
    }

    private void deleteStaff() {
        int selectedIndex = staffList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedStaffData = staffList.getSelectedValue();
            String id = selectedStaffData.split(",")[1].split(":")[1].trim(); // Extract ID from selected list item
            
            // Search for the staff by ID
            List<Staff> staffToDeleteList = manager.searchStaffById(id);

            if (!staffToDeleteList.isEmpty()) { 
                Staff staffToDelete = staffToDeleteList.get(0); 
                manager.deleteStaff(staffToDelete);  
                JOptionPane.showMessageDialog(this, "Staff deleted!");
                updateStaffList(manager.viewAllStaff()); 
            } else {
                JOptionPane.showMessageDialog(this, "Staff not found!");
            }
        }
    }
    
    private void editStatus() {
        int selectedIndex = staffList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedStaffData = staffList.getSelectedValue();
            String id = selectedStaffData.split(",")[1].split(":")[1].trim(); // Extract ID from selected list item

            // Search for the staff by ID
            List<Staff> staffToEditStatusList = manager.searchStaffById(id);

            if (!staffToEditStatusList.isEmpty()) {  // Check if we found any matching staff
                Staff staffToEditStatus = staffToEditStatusList.get(0);  // Get the first staff from the list
                EditStaffStatusGUI a = new EditStaffStatusGUI(this, staffToEditStatus, manager);  // Open the EditStaffStatusGUI with selected staff
                a.setVisible(true);
                SearchStaffGUI.this.setVisible(false);
                SearchStaffGUI.this.dispose();  // Close SearchStaffGUI when opening EditStaffStatusGUI
            } else {
                JOptionPane.showMessageDialog(this, "Staff not found!");
            }
        }
    }


}
