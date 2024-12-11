import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditStaffGUI extends JFrame {
    private JPanel editPane;
    private JTextField nameField;
    private JTextField idField;
    private JTextField roleField;
    private JTextField contactField;
    private staffManager manager;
    private Staff staffToEdit;

    public EditStaffGUI(JFrame parent, Staff staff, staffManager manager) {
        this.manager = manager;
        this.staffToEdit = staff;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        editPane = new JPanel();
        editPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(editPane);
        editPane.setLayout(null);

        JLabel title = new JLabel("Edit Staff");
        title.setBounds(150, 50, 200, 30);
        editPane.add(title);

        // Name Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        editPane.add(nameLabel);

        nameField = new JTextField(staff.getName());  // Pre-fill with current staff's name
        nameField.setBounds(150, 100, 200, 30);
        editPane.add(nameField);

        // ID Field
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 100, 30);
        editPane.add(idLabel);

        idField = new JTextField(staff.getId());  // Pre-fill with current staff's ID
        idField.setBounds(150, 150, 200, 30);
        editPane.add(idField);

        // Role Field
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 200, 100, 30);
        editPane.add(roleLabel);

        roleField = new JTextField(staff.getRole());  // Pre-fill with current staff's role
        roleField.setBounds(150, 200, 200, 30);
        editPane.add(roleField);

        // Contact Field
        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(50, 250, 100, 30);
        editPane.add(contactLabel);

        contactField = new JTextField(staff.getContact());  // Pre-fill with current staff's contact
        contactField.setBounds(150, 250, 200, 30);
        editPane.add(contactField);

        // Confirm Button to save the changes
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(200, 300, 100, 30);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStaff();
            }
        });
        editPane.add(confirmButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                EditStaffGUI.this.dispose();
            }
        });
        editPane.add(returnButton);
    }

    // Update the staff object
    private void updateStaff() {
        String name = nameField.getText();
        String id = idField.getText();
        String role = roleField.getText();
        String contact = contactField.getText();

        staffToEdit.editDetails(name, id, role, contact); // Update the current staff's details
        manager.editStaff(staffToEdit);
        JOptionPane.showMessageDialog(this, "Staff updated successfully!");
    }
}
