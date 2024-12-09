import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditPatientGUI extends JFrame {
    private JPanel editPane;
    private JTextField nameField;
    private JTextField idField;
    private JTextField sexField;
    private JTextField ageField;
    private patientManager manager;
    private Patient patientToEdit;

    // Constructor now accepts a Patient to be edited
    public EditPatientGUI(JFrame parent, Patient patient, patientManager manager) {
        this.manager = manager;
        this.patientToEdit = patient;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        editPane = new JPanel();
        editPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(editPane);
        editPane.setLayout(null);

        JLabel title = new JLabel("Edit Patient");
        title.setBounds(150, 50, 200, 30);
        editPane.add(title);

        // Name Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        editPane.add(nameLabel);

        nameField = new JTextField(patient.getName());
        nameField.setBounds(150, 100, 200, 30);
        editPane.add(nameField);

        // ID Field
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 100, 30);
        editPane.add(idLabel);

        idField = new JTextField(patient.getId()); 
        idField.setBounds(150, 150, 200, 30);
        editPane.add(idField);

        // Sex Field
        JLabel sexLabel = new JLabel("Sex:");
        sexLabel.setBounds(50, 200, 100, 30);
        editPane.add(sexLabel);

        sexField = new JTextField(patient.getGender());
        sexField.setBounds(150, 200, 200, 30);
        editPane.add(sexField);

        // Age Field
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 250, 100, 30);
        editPane.add(ageLabel);

        ageField = new JTextField(patient.getAge());
        ageField.setBounds(150, 250, 200, 30);
        editPane.add(ageField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(200, 300, 100, 30);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePatient();
            }
        });
        editPane.add(confirmButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                EditPatientGUI.this.dispose();
            }
        });
        editPane.add(returnButton);
    }

    private void updatePatient() {
        String name = nameField.getText();
        String id = idField.getText();
        String sex = sexField.getText();
        String age = ageField.getText();

        manager.deletePatient(patientToEdit);  // Delete the old patient

        Patient updatedPatient = new Patient(id, name, sex, age); 
        manager.addPatient(updatedPatient); 

        JOptionPane.showMessageDialog(this, "Patient updated successfully!");
    }
}
