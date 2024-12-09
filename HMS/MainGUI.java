import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

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
		title.setBounds(140,50,300,30);
		mainPane.add(title);
		
		Patient = new JButton("Patient");
		Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPatientGUI();
			}
		});
		Patient.setBounds(200, 130, 100, 30);
		mainPane.add(Patient);
		
		Staff = new JButton("Staff");
	    Staff.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            openStaffGUI();
	        }
	    });
	    Staff.setBounds(200, 230, 100, 30);
	    mainPane.add(Staff);

	    Appointment = new JButton("Appointment");
	    Appointment.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            openAppointmentGUI();
	        }
	    });
	    Appointment.setBounds(190, 330, 120, 30);
	    mainPane.add(Appointment);
    }

	private void openPatientGUI(){
		patientGUI patientGUI = new patientGUI(this);
		patientGUI.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	private void openStaffGUI(){
		staffGUI staffGUI = new staffGUI(this);
		staffGUI.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	private void openAppointmentGUI(){
		appointmentGUI appointmentGUI = new appointmentGUI(this);
		appointmentGUI.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
}
