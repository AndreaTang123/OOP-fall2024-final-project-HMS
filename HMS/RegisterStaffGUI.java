import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterStaffGUI extends JFrame {
    private JPanel registerPane;
    
    private JTextField nameField;
    private JTextField idField;
    private JTextField roleField;
    private JTextField contactField;

    public RegisterStaffGUI(JFrame parent, staffManager manager) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        registerPane = new JPanel();
        registerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(registerPane);
        registerPane.setLayout(null);

        JLabel title = new JLabel("Register New Staff");
        title.setBounds(150, 50, 200, 30);
        registerPane.add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        registerPane.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        registerPane.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 100, 30);
        registerPane.add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 150, 200, 30);
        registerPane.add(idField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(50, 200, 100, 30);
        registerPane.add(roleLabel);

        roleField = new JTextField();
        roleField.setBounds(150, 200, 200, 30);
        registerPane.add(roleField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(50, 250, 100, 30);
        registerPane.add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(150, 250, 200, 30);
        registerPane.add(contactField);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(200, 300, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewStaff(manager);
                JOptionPane.showMessageDialog(RegisterStaffGUI.this, "Staff Registered!");
            }
        });
        registerPane.add(registerButton);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                RegisterStaffGUI.this.dispose();
            }
        });
        registerPane.add(returnButton);
    }

    private void createNewStaff(staffManager manager) {
        String name = nameField.getText();
        String id = idField.getText();
        String role = roleField.getText();
        String contact = contactField.getText();  

        Staff newStaff = new Staff(name, id, role, contact);
        
        manager.addStaff(newStaff);
    }
}
