package interfaz;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;


public class initialWindow extends JFrame {

	private JPanel pnFondo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialWindow frame = new initialWindow();
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
	public initialWindow() {
		final JTextField textField=new JTextField();
		final JTextField textField_1 = new JTextField();
		

		final JLabel lblEmail = new JLabel("Email:");

		final JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameWindow game = new gameWindow();
				game.setVisible(true);
			}
		});

		final JLabel lblPassword = new JLabel("Password:");
		setIconImage(Toolkit.getDefaultToolkit().getImage(initialWindow.class.getResource("/imagenes/icono.png")));
		setTitle("Trivial - Software Architecture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		pnFondo = new JPanel();
		pnFondo.setBackground(new Color(0, 0, 139));
		pnFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnFondo);
		pnFondo.setLayout(null);
		
		JLabel lbTitulo = new JLabel("");
		lbTitulo.setIcon(new ImageIcon(initialWindow.class.getResource("/imagenes/titulo.png")));
		lbTitulo.setBounds(74, 38, 1334, 183);
		pnFondo.add(lbTitulo);
		JButton btLog = new JButton("");
		btLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEmail.setVisible(true);
				lblPassword.setVisible(true);
				textField_1.setVisible(true);
				textField.setVisible(true);
				btnLogIn.setVisible(true);
			}
		});
		btLog.setFocusPainted(false);
		btLog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btLog.setContentAreaFilled(false);
		btLog.setBorderPainted(false);
		btLog.setBorder(null);
		btLog.setOpaque(false);
		btLog.setIcon(new ImageIcon(initialWindow.class.getResource("/imagenes/loginn.png")));
		btLog.setBounds(456, 248, 302, 159);
		pnFondo.add(btLog);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newUser ventana = new newUser();
				ventana.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(initialWindow.class.getResource("/imagenes/newuser.png")));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(434, 441, 351, 172);
		pnFondo.add(button);
		
		
		lblEmail.setVisible(false);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(889, 304, 46, 14);
		pnFondo.add(lblEmail);
		
		lblPassword.setVisible(false);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(889, 348, 123, 14);
		pnFondo.add(lblPassword);
		
		textField.setVisible(false);
		textField.setBounds(1003, 303, 192, 20);
		pnFondo.add(textField);
		textField.setColumns(10);
		
		textField_1.setVisible(false);
		textField_1.setBounds(1002, 347, 193, 20);
		pnFondo.add(textField_1);
		textField_1.setColumns(10);
		
		btnLogIn.setVisible(false);
		btnLogIn.setBounds(987, 399, 89, 23);
		pnFondo.add(btnLogIn);
	}
}
