import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class patientGUI extends JFrame{
	
    private JPanel patientPane;
    private patientManager manager = new patientManager();

	public patientGUI(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        patientPane = new JPanel();
        patientPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(patientPane);
        patientPane.setLayout(null);

        JLabel title = new JLabel("Patient Management");
        title.setBounds(190, 50, 200, 30);
        patientPane.add(title);

        // Register Button
        JButton registerButton = new JButton("Register New Patient");
        registerButton.setBounds(150, 120, 200, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openRegisterGUI();
            }
        });
        patientPane.add(registerButton);

        // Search Button
        JButton searchButton = new JButton("Search Existing Patients");
        searchButton.setBounds(150, 170, 200, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSearchGUI();
            }
        });
        patientPane.add(searchButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 320, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                patientGUI.this.dispose();
            }
        });
        patientPane.add(returnButton);
    }
	
	private void openRegisterGUI(){
		RegisterPatientGUI registerGUI = new RegisterPatientGUI(patientGUI.this, manager);
        registerGUI.setVisible(true);
        patientGUI.this.setVisible(false);
        patientGUI.this.dispose();
	}
	
	private void openSearchGUI() {
		SearchPatientGUI searchGUI = new SearchPatientGUI(patientGUI.this, manager);
        searchGUI.setVisible(true);
        patientGUI.this.setVisible(false);
        patientGUI.this.dispose();
	}
}