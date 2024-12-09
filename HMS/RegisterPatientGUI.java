import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterPatientGUI extends JFrame {
    private JPanel registerPane;
    
    private JTextField nameField;
    private JTextField idField;
    private JTextField sexField;
    private JTextField ageField;

    public RegisterPatientGUI(JFrame parent, patientManager manager) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        registerPane = new JPanel();
        registerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(registerPane);
        registerPane.setLayout(null);

        JLabel title = new JLabel("Register New Patient");
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

        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setBounds(50, 200, 100, 30);
        registerPane.add(sexLabel);

        sexField = new JTextField();
        sexField.setBounds(150, 200, 200, 30);
        registerPane.add(sexField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 250, 100, 30);
        registerPane.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 250, 200, 30);
        registerPane.add(ageField);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(200, 300, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewPatient(manager);
                JOptionPane.showMessageDialog(RegisterPatientGUI.this, "Patient Registered!");
            }
        });
        registerPane.add(registerButton);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                RegisterPatientGUI.this.dispose();
            }
        });
        registerPane.add(returnButton);
    }

    private void createNewPatient(patientManager manager) {
        String name = nameField.getText();
        String id = idField.getText();
        String sex = sexField.getText();
        String age = ageField.getText();  

        Patient newPatient = new Patient(id, name, sex, age);
        
        manager.addPatient(newPatient);
    }
}
