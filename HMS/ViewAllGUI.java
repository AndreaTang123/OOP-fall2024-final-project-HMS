import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.List;

public class ViewAllGUI extends JFrame {
    private JPanel viewPane;
    private aptService manager;  // Service to manage appointments
    private JList<String> appointmentList;
    private DefaultListModel<String> listModel;

    // Constructor now accepts an aptService manager
    public ViewAllGUI(JFrame parent, aptService manager) {
        this.manager = manager;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        viewPane = new JPanel();
        viewPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(viewPane);
        viewPane.setLayout(null);

        JLabel title = new JLabel("View All Appointments");
        title.setBounds(150, 50, 200, 30);
        viewPane.add(title);

        listModel = new DefaultListModel<>();
        appointmentList = new JList<>(listModel);
        appointmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        JScrollPane listScrollPane = new JScrollPane(appointmentList); 
        listScrollPane.setBounds(50, 100, 400, 250); 
        viewPane.add(listScrollPane);

        // Button to refresh and load all appointments
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(200, 380, 100, 30);
        refreshButton.addActionListener(e -> loadAppointments());
        viewPane.add(refreshButton);

        // Return Button to go back to the previous screen
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 380, 100, 30);  // Positioned to the left of the refresh button
        returnButton.addActionListener(e -> {
            parent.setVisible(true);  // Show the parent window
            this.dispose();  // Close the current window
        });
        viewPane.add(returnButton);
        
        // Load appointments when the GUI is first created
        loadAppointments();
    }

    private void loadAppointments() {
        List<Appointment> appointments = manager.viewAllAppointments();

        listModel.clear(); 

        for (Appointment apt : appointments) {
            listModel.addElement(apt.viewApt());
        }
    }
}
