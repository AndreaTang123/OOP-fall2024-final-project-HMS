import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class staffGUI extends JFrame{
	
    private JPanel staffPane;
    private staffManager manager = new staffManager();

	public staffGUI(JFrame parent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        staffPane = new JPanel();
        staffPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(staffPane);
        staffPane.setLayout(null);

        JLabel title = new JLabel("Staff Management");
        title.setBounds(190, 50, 200, 30);
        staffPane.add(title);

        // Register Button
        JButton registerButton = new JButton("Register New Staff");
        registerButton.setBounds(150, 120, 200, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openRegisterGUI();
            }
        });
        staffPane.add(registerButton);

        // Search Button
        JButton searchButton = new JButton("Search Existing Staffs");
        searchButton.setBounds(150, 170, 200, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openSearchGUI();
            }
        });
        staffPane.add(searchButton);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 320, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                staffGUI.this.dispose();
            }
        });
        staffPane.add(returnButton);
    }
	
	private void openRegisterGUI(){
		RegisterStaffGUI registerGUI = new RegisterStaffGUI(staffGUI.this, manager);
        registerGUI.setVisible(true);
        staffGUI.this.setVisible(false);
        staffGUI.this.dispose();
	}
	
	private void openSearchGUI() {
		SearchStaffGUI searchGUI = new SearchStaffGUI(staffGUI.this, manager);
        searchGUI.setVisible(true);
        staffGUI.this.setVisible(false);
        staffGUI.this.dispose();
	}
}