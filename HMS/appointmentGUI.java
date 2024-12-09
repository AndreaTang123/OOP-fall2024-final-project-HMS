import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class appointmentGUI extends JFrame{
	private MainGUI mainGUI;
    private JPanel appointmentPane;
    private aptService manager = new aptService();

	public appointmentGUI(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        appointmentPane = new JPanel();
        appointmentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(appointmentPane);
        appointmentPane.setLayout(null);

        JLabel title = new JLabel("Appointment Management");
        title.setBounds(190, 50, 200, 30);
        appointmentPane.add(title);

        // Register Button
        JButton registerButton = new JButton("Register New Appointment");
        registerButton.setBounds(150, 120, 200, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBookGUI();
            }
        });
        appointmentPane.add(registerButton);

        // Search Button
        JButton searchButton = new JButton("Search Appointments");
        searchButton.setBounds(150, 170, 200, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSearchGUI();
            }
        });
        appointmentPane.add(searchButton);
        
        // View ALl Button
        JButton viewAllButton = new JButton("View All Appointments");
        viewAllButton.setBounds(150, 220, 200, 30);
        viewAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	openViewAllGUI();
            }
        });
        appointmentPane.add(viewAllButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 320, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                appointmentGUI.this.dispose();
            }
        });
        appointmentPane.add(returnButton);
    }
	
	private void openBookGUI(){
		BookAppointmentGUI registerGUI = new BookAppointmentGUI(appointmentGUI.this, manager);
        registerGUI.setVisible(true);
        appointmentGUI.this.setVisible(false);
        appointmentGUI.this.dispose();
	}
	
	private void openSearchGUI() {
		SearchAppointmentGUI searchGUI = new SearchAppointmentGUI(appointmentGUI.this, manager);
        searchGUI.setVisible(true);
        appointmentGUI.this.setVisible(false);
        appointmentGUI.this.dispose();
	}
	
	private void openViewAllGUI() {
		viewAllGUI viewAllGUI = new viewAllGUI(appointmentGUI.this, manager);
		viewAllGUI.setVisible(true);
        appointmentGUI.this.setVisible(false);
        appointmentGUI.this.dispose();
	}
}