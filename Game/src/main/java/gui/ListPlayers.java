package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.DB.MongoUserManager;
import logic.model.Statistics;
import logic.model.User;

import javax.swing.JLabel;

import java.awt.Font;
public class ListPlayers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane spUsers;
	private JTable tabUsers;
	
	private MongoUserManager mongo = new MongoUserManager();
	
	private List<User> users;
	private JButton btnClose;
	private JLabel lbListUsers;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public ListPlayers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getSpUsers());
		contentPane.add(getBtnClose());
		contentPane.setBackground(InitialWindow.pnFondo.getBackground());
		
		JButton btnSeeStatistics = new JButton("See statistics");
		btnSeeStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				users = mongo.getAllUsers();
				StatisticsWindow statistics = new StatisticsWindow();
				statistics.setVisible(true);
				statistics.txPlayer.setText((String) tabUsers.getValueAt(tabUsers.getSelectedRow(), 0));
				int row = tabUsers.getSelectedRow();
				for (User u : users){
					if (u.getEmail().equals(tabUsers.getValueAt(row, 1))){
						Statistics s = u.getStatistics();
						statistics.tabStatistics.setValueAt(s.getQuestionsMatched(), row, 0);
						statistics.tabStatistics.setValueAt(s.getQuestionsAnswered(), row, 1);
						statistics.tabStatistics.setValueAt(s.getTimesPlayed(), row, 2);	
					}
				}
			}
		});
		btnSeeStatistics.setBounds(357, 42, 123, 23);
		contentPane.add(btnSeeStatistics);
		contentPane.add(getLbListUsers());
	
	}
	private JScrollPane getSpUsers() {
		if (spUsers == null) {
			spUsers = new JScrollPane();
			spUsers.setBounds(42, 103, 306, 128);
			spUsers.setViewportView(getTabUsers());
			spUsers.setBackground(InitialWindow.pnFondo.getBackground());

		}
		return spUsers;
	}
	private JTable getTabUsers() {
		if (tabUsers == null) {
			tabUsers = new JTable();
			tabUsers.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Username", "Email"
				}
			));
		}
		DefaultTableModel model = (DefaultTableModel)tabUsers.getModel();
		listUsers(model);

		return tabUsers;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnClose.setBounds(378, 230, 76, 23);
		}
		return btnClose;
	}
	
	private void listUsers(DefaultTableModel model) {
		users = mongo.getAllUsers();
		Object[] row = new Object[2];
		for (int i = 0; i < users.size(); i++) {
			row[0] = users.get(i).getUsername();
			row[1] = users.get(i).getEmail();
			
			model.addRow(row);
		}
	}
	private JLabel getLbListUsers() {
		if (lbListUsers == null) {
			lbListUsers = new JLabel("List of users:");
			lbListUsers.setFont(new Font("Arial", Font.PLAIN, 25));
			lbListUsers.setBounds(142, 32, 195, 32);
		}
		return lbListUsers;
	}
}
