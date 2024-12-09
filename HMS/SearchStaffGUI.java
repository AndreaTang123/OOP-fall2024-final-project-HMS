import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchStaffGUI extends JFrame {
    private JPanel searchPane;
    private staffManager manager;

    public SearchStaffGUI(JFrame parent, staffManager manager) {
        this.manager = manager;  

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        searchPane = new JPanel();
        searchPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(searchPane);
        searchPane.setLayout(null);

        JLabel title = new JLabel("Search Staffs");
        title.setBounds(150, 50, 200, 30);
        searchPane.add(title);

        // Search by Name
        JLabel searchByNameLabel = new JLabel("Search by Name:");
        searchByNameLabel.setBounds(50, 100, 100, 30);
        searchPane.add(searchByNameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 150, 30);
        searchPane.add(nameField);

        JButton searchButtonByName = new JButton("Search");
        searchButtonByName.setBounds(300, 100, 80, 30);
        searchButtonByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                Staff staff = manager.searchStaffByName(name);
                if (staff != null) {
                	//TODO: need to add a scroll page
                    JOptionPane.showMessageDialog(SearchStaffGUI.this, staff.viewStaff());
                } else {
                    JOptionPane.showMessageDialog(SearchStaffGUI.this, "Staff not found!");
                }
            }
        });
        searchPane.add(searchButtonByName);

        // Search by ID
        JLabel searchByIDLabel = new JLabel("Search by ID:");
        searchByIDLabel.setBounds(50, 150, 100, 30);
        searchPane.add(searchByIDLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 150, 150, 30);
        searchPane.add(idField);

        JButton searchButtonByID = new JButton("Search");
        searchButtonByID.setBounds(300, 150, 80, 30);
        searchButtonByID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                Staff staff = manager.searchStaffById(id); 
                if (staff != null) {
                	//TODO: need to add a scroll page
                    JOptionPane.showMessageDialog(SearchStaffGUI.this, staff.viewStaff());
                } else {
                    JOptionPane.showMessageDialog(SearchStaffGUI.this, "Staff not found!");
                }
            }
        });
        searchPane.add(searchButtonByID);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(350, 300, 100, 30);
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
                SearchStaffGUI.this.dispose();
            }
        });
        searchPane.add(returnButton);
    }
}
