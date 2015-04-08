package gui;
import java.awt.Color;
import java.awt.EventQueue;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnOk;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserWindow frame = new NewUserWindow();
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
	public NewUserWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/Images/icono.png")));
		setTitle("Trivial - Software Architecture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitle());
		contentPane.add(getLabel());
		contentPane.add(getLblName());
		contentPane.add(getLblEmail());
		contentPane.add(getLblPassword());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(230, 366, 172, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(230, 414, 172, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(230, 454, 172, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")){
						JOptionPane.showMessageDialog(null, "You must fill all the information to create a new user");
					}
					else{
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
}