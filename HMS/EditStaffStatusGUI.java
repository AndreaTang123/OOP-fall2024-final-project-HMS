import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditStaffStatusGUI extends JFrame {
    private JPanel editPane;
    private JTextField statusField;
    private staffManager manager;
    private Staff staffToEditStatus;

    public EditStaffStatusGUI(JFrame parent, Staff staff, staffManager manager) {
        this.manager = manager;
        this.staffToEditStatus = staff;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        editPane = new JPanel();
        editPane.setLayout(null);
        setContentPane(editPane);

        JLabel title = new JLabel("Edit Staff Status");
        title.setBounds(150, 50, 200, 30);
        editPane.add(title);
        
        JLabel note = new JLabel("Active, Busy, or Out");
        note.setBounds(150,70,200,30);
        editPane.add(note);

        // Status Field
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 100, 100, 30);
        editPane.add(statusLabel);

        statusField = new JTextField(staff.getStatus());  // Pre-fill
        statusField.setBounds(150, 100, 200, 30);
        editPane.add(statusField);

        // Confirm Button to save the status change
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(200, 150, 100, 30);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStaffStatus();
            }
        });
        editPane.add(confirmButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 200, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                EditStaffStatusGUI.this.dispose();
            }
        });
        editPane.add(returnButton);
    }

    // Update the staff status
    private void updateStaffStatus() {
        String status = statusField.getText();

        // Update staff status
        manager.editStaffStatus(staffToEditStatus, status);

        JOptionPane.showMessageDialog(this, "Staff status updated successfully!");
    }
}
