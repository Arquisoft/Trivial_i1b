package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AboutTrivial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lbTitle;
	private JTextArea txtrThisProjectIs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutTrivial frame = new AboutTrivial();
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
	public AboutTrivial() {
		setTitle("Trivial - Software Architecture");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/Images/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBackground(InitialWindow.pnFondo.getBackground());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitle());
		contentPane.add(getTxtrThisProjectIs());
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("");
			lbTitle.setIcon(new ImageIcon(AboutTrivial.class.getResource("/Images/tituloSmall.png")));
			lbTitle.setBounds(52, 30, 726, 160);
		}
		return lbTitle;
	}
	private JTextArea getTxtrThisProjectIs() {
		if (txtrThisProjectIs == null) {
			txtrThisProjectIs = new JTextArea();
			txtrThisProjectIs.setFont(new Font("Arial Black", Font.BOLD, 13));
			txtrThisProjectIs.setForeground(new Color(255, 255, 255));
			txtrThisProjectIs.setBackground(InitialWindow.pnFondo.getBackground());
			txtrThisProjectIs.setEditable(false);
			txtrThisProjectIs.setLineWrap(true);
			txtrThisProjectIs.setWrapStyleWord(true);
			txtrThisProjectIs.setText("This project is developed for the Software Architecture course.\r\nIt's developed by:\r\n-Ana Areces Gonz\u00E1lez\r\n-Raquel Arrojo L\u00F3pez\r\n-Mar\u00EDa Gonz\u00E1lez Gonz\u00E1lez\r\n-\u00C1lvaro Palanco Lorenzo\r\n-David Casado Corona\r\n-Iv\u00E1n S\u00E1nchez Vald\u00E9s\r\n\r\n\r\n\r\n\r\n\r\n\r\nMore information about the project can be found on:\r\nhttps://github.com/Arquisoft/Trivial_i1b    and     http://arquisoft.github.io/Trivial_i1b/\r\n");
			txtrThisProjectIs.setBounds(62, 201, 933, 401);
		}
		return txtrThisProjectIs;
	}
}
