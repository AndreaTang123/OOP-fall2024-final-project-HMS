import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.util.*;

public class MainGUI extends JFrame {
	private JPanel mainPane;
    private JLabel title;
	private JButton Patient;
	private JButton Staff;
	private JButton Appointment;
	
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JLabel title = new JLabel("Welcome to Hospital Management System!");
		lblResult.setBounds(6,80,120,16);
		mainPane.add(title);
		
		Patient = new JButton("Patient");
		Patient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPatientGUI();
			}
		});
		Patient.setBounds(16, 130, 100, 30);
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
	    Appointment.setBounds(240, 130, 100, 30);
	    mainPane.add(Appointment);
    }
}