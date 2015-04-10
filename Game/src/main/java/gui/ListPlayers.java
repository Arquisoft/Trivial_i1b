package gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.DB.MongoUserManager;
import logic.model.User;
public class ListPlayers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane spUsers;
	private JTable tabUsers;
	private MongoUserManager mongo;
	
	private List<User> users = mongo.getAllUsers();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPlayers frame = new ListPlayers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListPlayers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSpUsers());
		
		JTable tabUsers = new JTable();
		DefaultTableModel model = (DefaultTableModel)tabUsers.getModel();
		Object[] row = new Object[model.getColumnCount()];
		for (int i = 0; i < users.size(); i++) {
			row[0] = users.get(i).getUsername();
			row[2] = users.get(i).getEmail();
			model.addRow(row);
		}
	}
	private JScrollPane getSpUsers() {
		if (spUsers == null) {
			spUsers = new JScrollPane();
			spUsers.setBounds(41, 26, 306, 188);
			spUsers.setViewportView(getTabUsers());
		}
		return spUsers;
	}
	private JTable getTabUsers() {
		if (tabUsers == null) {
			tabUsers = new JTable();
			tabUsers.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					
				},
				new String[] {
					"Username", "Email"
				}
			));
		}
		return tabUsers;
	}
}
