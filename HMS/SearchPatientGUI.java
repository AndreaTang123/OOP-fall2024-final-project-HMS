import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class SearchPatientGUI extends JFrame {
    private JPanel searchPane;
    private patientManager manager;
    private JList<String> patientList;
    private DefaultListModel<String> listModel;
    private JButton editButton;
    private JButton deleteButton;

    public SearchPatientGUI(JFrame parent, patientManager manager) {
        this.manager = manager;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        searchPane = new JPanel();
        searchPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(searchPane);
        searchPane.setLayout(null);

        JLabel title = new JLabel("Search Patients");
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
                List<Patient> patients = manager.searchPatientByName(name);  // Returns a list of matching patients
                updatePatientList(patients);
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
                List<Patient> patients = manager.searchPatientById(id);  // Returns a list of matching patients
                updatePatientList(patients);
            }
        });
        searchPane.add(searchButtonByID);

        // Create a scrollable area for displaying patients
        listModel = new DefaultListModel<>();
        patientList = new JList<>(listModel);
        patientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(patientList);
        listScrollPane.setBounds(50, 200, 400, 150);
        searchPane.add(listScrollPane);

        // Edit and Delete buttons
        editButton = new JButton("Edit");
        editButton.setBounds(460, 200, 80, 30);
        editButton.setEnabled(false);  // Initially disabled
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editPatient();
            }
        });
        searchPane.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(460, 250, 80, 30);
        deleteButton.setEnabled(false);  // Initially disabled
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePatient();
            }
        });
        searchPane.add(deleteButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(460, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                SearchPatientGUI.this.dispose();
            }
        });
        searchPane.add(returnButton);

        // Enable/Disable buttons based on selection
        patientList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && patientList.getSelectedIndex() != -1) {
                    editButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                } else {
                    editButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
            }
        });
    }

    // Update JList with search results (Name, ID, Sex, and Age)
    private void updatePatientList(List<Patient> patients) {
        listModel.clear();
        for (Patient patient : patients) {
            // Display all relevant patient details in the list
            listModel.addElement("Name: " + patient.getName() + ", ID: " + patient.getId() +
                                 ", Sex: " + patient.getGender() + ", Age: " + patient.getAge());
        }
    }

    // Edit the selected patient
    private void editPatient() {
        int selectedIndex = patientList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedPatientData = patientList.getSelectedValue();
            String id = selectedPatientData.split(",")[1].split(":")[1].trim();
            Patient patientToEdit = manager.searchPatientById(id).get(0);  // Get the first patient from the list

            if (patientToEdit != null) {
                EditPatientGUI g = new EditPatientGUI(this, patientToEdit, manager);  // Open the EditPatientGUI with selected patient
                g.setVisible(true);
                SearchPatientGUI.this.setVisible(false);
                SearchPatientGUI.this.dispose();  // Close SearchPatientGUI when opening EditPatientGUI
            }
        }
    }

    // Delete the selected patient
    private void deletePatient() {
        int selectedIndex = patientList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedPatientData = patientList.getSelectedValue();
            String id = selectedPatientData.split(",")[1].split(":")[1].trim();
            Patient patientToDelete = manager.searchPatientById(id).get(0);  // Get the first patient from the list

            if (patientToDelete != null) {
                manager.deletePatient(patientToDelete);
                JOptionPane.showMessageDialog(this, "Patient deleted!");
                updatePatientList(manager.viewAllPatient());  // Refresh the list
            }
        }
    }
}
