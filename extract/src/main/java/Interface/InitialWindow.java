package Interface;
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


public class InitialWindow extends JFrame {

	private JPanel pnFondo;
	private JButton btnRed;
	private JButton btnG;
	private JButton btnBlue;
	private JButton btnPink;
	private JButton btnYellow;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialWindow frame = new InitialWindow();
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
	public InitialWindow() {
		final JTextField textField=new JTextField();
		final JTextField textField_1 = new JTextField();
		

		final JLabel lblEmail = new JLabel("Email:");

		final JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameWindow game = new GameWindow();
				game.setVisible(true);
			}
		});

		final JLabel lblPassword = new JLabel("Password:");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InitialWindow.class.getResource("/imagenes/icono.png")));
		setTitle("Trivial - Software Architecture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		pnFondo = new JPanel();
		pnFondo.setBackground(new Color(0, 0, 139));
		pnFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnFondo);
		pnFondo.setLayout(null);
		
		JLabel lbTitulo = new JLabel("");
		lbTitulo.setIcon(new ImageIcon(InitialWindow.class.getResource("/imagenes/titulo.png")));
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
		btLog.setIcon(new ImageIcon(InitialWindow.class.getResource("/imagenes/loginn.png")));
		btLog.setBounds(456, 248, 302, 159);
		pnFondo.add(btLog);
		
		JButton button = new JButton("");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUserWindow ventana = new NewUserWindow();
				ventana.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(InitialWindow.class.getResource("/imagenes/newuser.png")));
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
		pnFondo.add(getBtnRed());
		pnFondo.add(getBtnG());
		pnFondo.add(getBtnBlue());
		pnFondo.add(getBtnPink());
		pnFondo.add(getBtnYellow());
	}
	private JButton getBtnRed() {
		if (btnRed == null) {
			btnRed = new JButton("Red");
			btnRed.setBackground(Color.RED);
			btnRed.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnFondo.setBackground(Color.RED);
				}
			});
			btnRed.setBounds(70, 324, 89, 23);
		}
		return btnRed;
	}
	private JButton getBtnG() {
		if (btnG == null) {
			btnG = new JButton("Green");
			btnG.setBounds(70, 361, 89, 23);
		}
		return btnG;
	}
	private JButton getBtnBlue() {
		if (btnBlue == null) {
			btnBlue = new JButton("Blue");
			btnBlue.setBounds(70, 399, 89, 23);
		}
		return btnBlue;
	}
	private JButton getBtnPink() {
		if (btnPink == null) {
			btnPink = new JButton("Pink");
			btnPink.setBounds(70, 436, 89, 23);
		}
		return btnPink;
	}
	private JButton getBtnYellow() {
		if (btnYellow == null) {
			btnYellow = new JButton("Yellow");
			btnYellow.setBounds(70, 470, 89, 23);
		}
		return btnYellow;
	}
}
