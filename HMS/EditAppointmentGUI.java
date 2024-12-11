import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAppointmentGUI extends JFrame {
    private JPanel editPane;
    private JTextField pnameField, snameField, dateField, statusField;
    private aptService manager;
    private Appointment appointmentToEdit;

    public EditAppointmentGUI(JFrame parent, Appointment appointment, aptService manager) {
        this.manager = manager;
        this.appointmentToEdit = appointment;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        editPane = new JPanel();
        editPane.setLayout(null);
        setContentPane(editPane);

        JLabel title = new JLabel("Edit Appointment");
        title.setBounds(150, 50, 200, 30);
        editPane.add(title);

        // Patient Name Field (editable)
        JLabel pnameLabel = new JLabel("Patient ID:");
        pnameLabel.setBounds(50, 100, 100, 30);
        editPane.add(pnameLabel);
        
        pnameField = new JTextField(appointment.getPatientId());  // Pre-fill with current patient ID
        pnameField.setBounds(150, 100, 200, 30);
        editPane.add(pnameField);

        // Staff Name Field (editable)
        JLabel snameLabel = new JLabel("Staff ID:");
        snameLabel.setBounds(50, 150, 100, 30);
        editPane.add(snameLabel);

        snameField = new JTextField(appointment.getStaffId());  // Pre-fill with current staff ID
        snameField.setBounds(150, 150, 200, 30);
        editPane.add(snameField);

        // Appointment Date Field (editable)
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 200, 100, 30);
        editPane.add(dateLabel);

        dateField = new JTextField(appointment.getDate());  // Pre-fill with current appointment date
        dateField.setBounds(150, 200, 200, 30);
        editPane.add(dateField);

        // Status Field (editable)
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 250, 100, 30);
        editPane.add(statusLabel);

        statusField = new JTextField(appointment.getStatus());  // Pre-fill with current status
        statusField.setBounds(150, 250, 200, 30);
        editPane.add(statusField);

        // Confirm Button to save the changes
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 300, 100, 30);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateAppointment();  // Call method to save changes
            }
        });
        editPane.add(confirmButton);

        // Cancel Button to discard changes
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 300, 100, 30);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);  // Bring back the previous window
                EditAppointmentGUI.this.dispose();  // Close the current window
            }
        });
        editPane.add(cancelButton);
    }

    private void updateAppointment() {
        String patientId = pnameField.getText();
        String staffId = snameField.getText();
        String date = dateField.getText();
        String status = statusField.getText();

        // Call manager to update the appointment
        manager.editApt(appointmentToEdit, patientId, staffId, date);
        manager.editStatus(appointmentToEdit, status);  // Update the status

        JOptionPane.showMessageDialog(this, "Appointment updated successfully!");
        this.dispose();
    }
}
