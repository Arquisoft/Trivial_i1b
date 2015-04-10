package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class StatisticsWindow extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPlayer;
	public JTextField txPlayer;
	private JScrollPane spTable;
	public JTable tabStatistics;
	private JButton btnClose;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsWindow frame = new StatisticsWindow();
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
	public StatisticsWindow() {
		setTitle("Statistics of the player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 336);
		contentPane = new JPanel();
		//contentPane.setBackground(InitialWindow.pnFondo.getBackground());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPlayer());
		contentPane.add(getTxPlayer());
		contentPane.add(getSpTable());
		contentPane.add(getBtnClose());
		
		
	}

	private JLabel getLblPlayer() {
		if (lblPlayer == null) {
			lblPlayer = new JLabel("Player:");
			lblPlayer.setFont(new Font("Arial", Font.BOLD, 15));
			lblPlayer.setBounds(167, 26, 61, 20);
		}
		return lblPlayer;
	}
	private JTextField getTxPlayer() {
		if (txPlayer == null) {
			txPlayer = new JTextField();
			txPlayer.setEditable(false);
			txPlayer.setBounds(256, 27, 174, 20);
			txPlayer.setColumns(10);
		}
		return txPlayer;
	}
	private JScrollPane getSpTable() {
		if (spTable == null) {
			spTable = new JScrollPane();
			spTable.setBounds(42, 73, 508, 105);
			spTable.setViewportView(getTabStatistics());
		}
		return spTable;
	}
	private JTable getTabStatistics() {
		if (tabStatistics == null) {
			tabStatistics = new JTable();
			tabStatistics.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
				},
				new String[] {
					"Won games", "Lost games", "Correct answers", "Incorrect answers"
				}
			));
		}
		return tabStatistics;
	}
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnClose.setBounds(444, 248, 89, 23);
		}
		return btnClose;
	}
}
