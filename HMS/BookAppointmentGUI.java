import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BookAppointmentGUI extends JFrame{
	private JPanel registerPane;
    
    private JTextField pnameField;
    private JTextField snameField;
    private JTextField dateField;
    private JTextField statusField;

    
    public BookAppointmentGUI(JFrame parent, aptService manager) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        registerPane = new JPanel();
        registerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(registerPane);
        registerPane.setLayout(null);

        JLabel title = new JLabel("Book Appointment");
        title.setBounds(150, 50, 200, 30);
        registerPane.add(title);

        JLabel pnameLabel = new JLabel("Appointment Name:");
        pnameLabel.setBounds(50, 100, 100, 30);
        registerPane.add(pnameLabel);

        pnameField = new JTextField();
        pnameField.setBounds(150, 100, 200, 30);
        registerPane.add(pnameField);

        JLabel snameLabel = new JLabel("Staff Name:");
        snameLabel.setBounds(50, 150, 100, 30);
        registerPane.add(snameLabel);

        snameField = new JTextField();
        snameField.setBounds(150, 150, 200, 30);
        registerPane.add(snameField);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 200, 100, 30);
        registerPane.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(150, 200, 200, 30);
        registerPane.add(dateField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 250, 100, 30);
        registerPane.add(statusLabel);

        statusField = new JTextField();
        statusField.setBounds(150, 250, 200, 30);
        registerPane.add(statusField);

        JButton registerButton = new JButton("Confirm");
        registerButton.setBounds(200, 300, 100, 30);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewAppointment(manager);
                JOptionPane.showMessageDialog(BookAppointmentGUI.this, "Appointment Registered!");
            }
        });
        registerPane.add(registerButton);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 350, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                BookAppointmentGUI.this.dispose();
            }
        });
        registerPane.add(returnButton);
    }

    private void createNewAppointment(aptService manager) {
        String pname = pnameField.getText();
        String sname = snameField.getText();
        String date = dateField.getText();
        String status = statusField.getText();

        Appointment newAppointment = new Appointment(pname,sname,date,status);
        
        manager.bookAppointment(newAppointment);
    }
}
