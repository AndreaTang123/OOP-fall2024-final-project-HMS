import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.List;

public class SearchAppointmentGUI extends JFrame {
    private JPanel searchPane;
    private aptService manager;
    private JList<String> appointmentList;
    private DefaultListModel<String> listModel;
    private JButton editButton;
    private JButton cancelButton;

    public SearchAppointmentGUI(JFrame parent, aptService manager) {
        this.manager = manager;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        searchPane = new JPanel();
        searchPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(searchPane);
        searchPane.setLayout(null);

        JLabel title = new JLabel("Search Appointments");
        title.setBounds(230, 50, 150, 30);
        searchPane.add(title);

        // Search by Patient Name
        JLabel searchByPatientLabel = new JLabel("Search by Patient Name:");
        searchByPatientLabel.setBounds(50, 100, 150, 30);
        searchPane.add(searchByPatientLabel);

        JTextField pnameField = new JTextField();
        pnameField.setBounds(200, 100, 150, 30);
        searchPane.add(pnameField);

        JButton searchButtonByPatient = new JButton("Search");
        searchButtonByPatient.setBounds(370, 100, 80, 30);
        searchButtonByPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pname = pnameField.getText().trim();
                List<Appointment> appointments = manager.searchAppointmentByPatient(pname);
                updateAppointmentList(appointments);
            }
        });
        searchPane.add(searchButtonByPatient);

        // Search by Staff Name
        JLabel searchByStaffLabel = new JLabel("Search by Staff Name:");
        searchByStaffLabel.setBounds(50, 150, 150, 30);
        searchPane.add(searchByStaffLabel);

        JTextField snameField = new JTextField();
        snameField.setBounds(200, 150, 150, 30);
        searchPane.add(snameField);

        JButton searchButtonByStaff = new JButton("Search");
        searchButtonByStaff.setBounds(370, 150, 80, 30);
        searchButtonByStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sname = snameField.getText().trim();
                List<Appointment> appointments = manager.searchAppointmentByStaff(sname);
                updateAppointmentList(appointments);
            }
        });
        searchPane.add(searchButtonByStaff);

        // Create a DefaultListModel to hold appointment information
        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Single selection mode
        JScrollPane listScrollPane = new JScrollPane(appointmentList);  // Make the list scrollable
        listScrollPane.setBounds(50, 200, 400, 150);
        searchPane.add(listScrollPane);

        // Edit Button
        editButton = new JButton("Edit");
        editButton.setBounds(460, 200, 80, 30);
        editButton.setEnabled(false);  // Initially disabled
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editAppointment();
            }
        });
        searchPane.add(editButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 250, 80, 30);
        cancelButton.setEnabled(false);  // Initially disabled
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelAppointment();
            }
        });
        searchPane.add(cancelButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(460, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                SearchAppointmentGUI.this.dispose();  // Close SearchAppointmentGUI when returning
            }
        });
        searchPane.add(returnButton);

        // Enable/Disable buttons based on selection
        appointmentList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && appointmentList.getSelectedIndex() != -1) {
                    editButton.setEnabled(true);
                    cancelButton.setEnabled(true);
                } else {
                    editButton.setEnabled(false);
                    cancelButton.setEnabled(false);
                }
            }
        });
    }

    // Update the list of appointments in the display area
    private void updateAppointmentList(List<Appointment> appointments) {
        listModel.clear();  // Clear the list before adding new search results

        // If there are no results, let the user know
        if (appointments.isEmpty()) {
            listModel.addElement("No results found.");
        }

        for (Appointment apt : appointments) {
        	listModel.addElement(apt.viewApt());  // Add each appointment to the list model
        }
    }

    // Edit the selected appointment
    private void editAppointment() {
        int selectedIndex = appointmentList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedAppointmentData = appointmentList.getSelectedValue();
            int appointmentId = Integer.parseInt(selectedAppointmentData.split(",")[0].split(":")[1].trim());  // Extract and convert Appointment ID
            Appointment appointmentToEdit = null;

            // Find the appointment by ID
            for (Appointment apt : manager.viewAllAppointments()) {
                if (apt.getAptId() != -1 && apt.getAptId() == appointmentId) {
                    appointmentToEdit = apt;
                    break;
                }
            }

            if (appointmentToEdit != null) {
            	EditAppointmentGUI a = new EditAppointmentGUI(this, appointmentToEdit, manager);  // Open the EditAppointmentGUI with selected appointment
                a.setVisible(true);
            	SearchAppointmentGUI.this.setVisible(false);
                SearchAppointmentGUI.this.dispose();  // Close SearchAppointmentGUI when opening EditAppointmentGUI
            }
        }
    }

    // Cancel the selected appointment
    private void cancelAppointment() {
        int selectedIndex = appointmentList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedAppointmentData = appointmentList.getSelectedValue();
            int appointmentId = Integer.parseInt(selectedAppointmentData.split(",")[0].split(":")[1].trim());
            Appointment appointmentToCancel = null;

            // Find the appointment by ID
            for (Appointment apt : manager.viewAllAppointments()) {
                if (apt.getAptId() != -1 && apt.getAptId() == appointmentId) {
                    appointmentToCancel = apt;
                    break;
                }
            }

            if (appointmentToCancel != null) {
                manager.cancelApt(appointmentToCancel);  // Cancel the appointment
                JOptionPane.showMessageDialog(this, "Appointment cancelled!");
                loadAppointments();  // Reload the appointments to update the list
            }
        }
    }

    // Load all appointments and display them in the list (No pre-population)
    private void loadAppointments() {
        listModel.clear();  // Clear the list model before loading any appointments
    }
}