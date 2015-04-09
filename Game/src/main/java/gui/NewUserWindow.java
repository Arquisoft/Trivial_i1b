package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Game;


public class NewUserWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitle;
	private JLabel label;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfPassword;
	private JButton btnOk;
	private JLabel label_1;
	
	private Game game;

	/**
	 * Create the frame.
	 */
	public NewUserWindow(Game game) {
		this.game = game;
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/Images/icono.png")));
		setTitle("Trivial - Software Architecture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		
		contentPane = new JPanel();
		contentPane.setBackground(InitialWindow.pnFondo.getBackground());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitle());
		contentPane.add(getLabel());
		contentPane.add(getLblName());
		contentPane.add(getLblEmail());
		contentPane.add(getLblPassword());
		contentPane.add(getTfUsername());
		contentPane.add(getTfEmail());
		contentPane.add(getTfPassword());
		contentPane.add(getBtnOk());
		contentPane.add(getLabel_1());
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("");
			lbTitle.setIcon(new ImageIcon(NewUserWindow.class.getResource("/Images/titulo.png")));
			lbTitle.setBounds(47, 53, 1175, 184);
		}
		return lbTitle;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(NewUserWindow.class.getResource("/Images/labelNewUser.png")));
			label.setBounds(158, 269, 321, 52);
		}
		return label;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name: ");
			lblName.setForeground(new Color(255, 255, 255));
			lblName.setFont(new Font("Arial", Font.PLAIN, 16));
			lblName.setBounds(133, 367, 81, 14);
		}
		return lblName;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email: ");
			lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			lblEmail.setForeground(new Color(255, 255, 255));
			lblEmail.setBounds(133, 415, 64, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBounds(133, 455, 161, 14);
		}
		return lblPassword;
	}
	private JTextField getTfUsername() {
		if (tfUsername == null) {
			tfUsername = new JTextField();
			tfUsername.setBounds(230, 366, 172, 20);
			tfUsername.setColumns(10);
		}
		return tfUsername;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(230, 414, 172, 20);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setBounds(230, 454, 172, 20);
			tfPassword.setColumns(10);
		}
		return tfPassword;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tfUsername.getText().equals("") || tfEmail.getText().equals("") || tfPassword.getText().equals("")){
						JOptionPane.showMessageDialog(null, "You must fill all the information to create a new user");
					}
					else{
						if(game.register(tfUsername.getText(), tfEmail.getText(), tfPassword.getText()) == null)
							
						JOptionPane.showMessageDialog(null, "New user created");
					}
				}
			});
			btnOk.setBounds(221, 522, 89, 23);
		}
		return btnOk;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(NewUserWindow.class.getResource("/Images/TEXTO.jpg")));
			label_1.setBounds(469, 127, 854, 573);
		}
		return label_1;
	}

	public Game getGame() {
		return game;
	}
}
