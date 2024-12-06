import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.util.*;

public class MainGUI extends JFrame {
	private JPanel mainPane;
	private JButton Patient;
	private JButton Staff;
	private JButton Appointment;
	
	public MainGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel title = new JLabel("Welcome to Hospital Management System!");
		lblResult.setBounds(100,50,300,30);
		mainPane.add(title);
		
		Patient = new JButton("Patient");
		Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPatientGUI();
			}
		});
		Patient.setBounds(100, 130, 100, 30);
		mainPane.add(Patient);
		
		Staff = new JButton("Staff");
	    Staff.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            openStaffGUI();
	        }
	    });
	    Staff.setBounds(130, 130, 100, 30);
	    mainPane.add(Staff);

	    Appointment = new JButton("Appointment");
	    Appointment.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            openAppointmentGUI();
	        }
	    });
	    Appointment.setBounds(320, 130, 120, 30);
	    mainPane.add(Appointment);
    }

	private void openPatientGUI(){
		PatientGUI patientGUI = new PatientGUI(this);
		patientGUI.setVisible(true);
		this.setVisible(false);
	}
}

class PatientGUI extends JFrame{
    private JPanel patientPane;

	public PatientGUI(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        patientPane = new JPanel();
        patientPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(patientPane);
        patientPane.setLayout(null);

        JLabel title = new JLabel("Patient Management");
        title.setBounds(150, 50, 200, 30);
        patientPane.add(title);

        // Register Button
        JButton registerButton = new JButton("Register New Patient");
        registerButton.setBounds(150, 120, 200, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPatientGUI registerGUI = new RegisterPatientGUI(PatientGUI.this);
                registerGUI.setVisible(true);
                PatientGUI.this.setVisible(false);
            }
        });
        patientPane.add(registerButton);

        // Search Button
        JButton searchButton = new JButton("Search Existing Patients");
        searchButton.setBounds(150, 170, 200, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchPatientGUI searchGUI = new SearchPatientGUI(PatientGUI.this);
                searchGUI.setVisible(true);
                PatientGUI.this.setVisible(false);
            }
        });
        patientPane.add(searchButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(150, 220, 200, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                PatientGUI.this.dispose();
            }
        });
        patientPane.add(returnButton);
    }
}

// RegisterPatientGUI Class
class RegisterPatientGUI extends JFrame {
    private JPanel registerPane;

    public RegisterPatientGUI(JFrame parent) {
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

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        registerPane.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 100, 30);
        registerPane.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 150, 200, 30);
        registerPane.add(idField);

		JLabel sexLabel = new JLabel("Sex:");
        idLabel.setBounds(250, 150, 100, 30);
        registerPane.add(sexLabel);

        JTextField sexField = new JTextField();
        idField.setBounds(250, 150, 200, 30);
        registerPane.add(sexField);

		JLabel birthdateLabel = new JLabel("Birthdate:");
        idLabel.setBounds(250, 150, 100, 30);
        registerPane.add(birthdateLabel);

        JTextField birthDateField = new JTextField();
        idField.setBounds(250, 150, 200, 30);
        registerPane.add(birthDateField);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(150, 200, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Placeholder for Patient Registration Logic
				createNewPatient();//TODO
                JOptionPane.showMessageDialog(RegisterPatientGUI.this, "Patient Registered!");
            }
        });
        registerPane.add(registerButton);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(150, 250, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                RegisterPatientGUI.this.dispose();
            }
        });
        registerPane.add(returnButton);
    }
}

// SearchPatientGUI Class
class SearchPatientGUI extends JFrame {
    private JPanel searchPane;

    public SearchPatientGUI(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        searchPane = new JPanel();
        searchPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(searchPane);
        searchPane.setLayout(null);

        JLabel title = new JLabel("Search Patients");
        title.setBounds(150, 50, 200, 30);
        searchPane.add(title);

        JLabel searchByNameLabel = new JLabel("Search by Name:");
        searchByNameLabel.setBounds(50, 100, 100, 30);
        searchPane.add(searchByNameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        searchPane.add(nameField);

		JButton searchButton1 = new JButton("Search");
        searchButton1.setBounds(150, 200, 100, 30);
        searchButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Placeholder for Search Logic
                JOptionPane.showMessageDialog(SearchPatientGUI.this, "Search Completed!");
            }
        });
        searchPane.add(searchButton1);

        JLabel searchByIDLabel = new JLabel("Search by ID:");
        searchByIDLabel.setBounds(50, 150, 100, 30);
        searchPane.add(searchByIDLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 150, 200, 30);
        searchPane.add(idField);

        JButton searchButton2 = new JButton("Search");
        searchButton2.setBounds(150, 200, 100, 30);
        searchButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Placeholder for Search Logic
                JOptionPane.showMessageDialog(SearchPatientGUI.this, "Search Completed!");
            }
        });
        searchPane.add(searchButton2);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(150, 250, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                SearchPatientGUI.this.dispose();
            }
        });
        searchPane.add(returnButton);

		//TODO: edit button, delete button
		//TODO: result display field
    }
}