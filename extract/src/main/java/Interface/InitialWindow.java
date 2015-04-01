package Interface;


public class initialWindow extends JFrame {

	public static JPanel pnFondo;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(initialWindow.class.getResource("main/resources/Images/icono.png")));
		setTitle("Trivial - Software Architecture");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		pnFondo = new JPanel();
		pnFondo.setBackground(new Color(0, 0, 139));
		pnFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnFondo);
		pnFondo.setLayout(null);
		
		JLabel lbTitulo = new JLabel("");
		lbTitulo.setIcon(new ImageIcon(initialWindow.class.getResource("main/resources/Images/titulo.png")));
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
		btLog.setIcon(new ImageIcon(initialWindow.class.getResource("main/resources/Images/loginn.png")));
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
		button.setIcon(new ImageIcon(initialWindow.class.getResource("main/resources/Images/newuser.png")));
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
			btnG.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnFondo.setBackground(new Color(50,205,50));
				}
			});
			btnG.setBackground(new Color(50, 205, 50));
			btnG.setBounds(70, 361, 89, 23);
		}
		return btnG;
	}
	private JButton getBtnBlue() {
		if (btnBlue == null) {
			btnBlue = new JButton("Blue");
			btnBlue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnFondo.setBackground(new Color (0, 0, 205));
				}
			});
			btnBlue.setBackground(new Color(0, 0, 205));
			btnBlue.setBounds(70, 399, 89, 23);
		}
		return btnBlue;
	}
	private JButton getBtnPink() {
		if (btnPink == null) {
			btnPink = new JButton("Pink");
			btnPink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pnFondo.setBackground(Color.PINK);
				}
			});
			btnPink.setBackground(Color.PINK);
			btnPink.setBounds(70, 436, 89, 23);
		}
		return btnPink;
	}
	private JButton getBtnYellow() {
		if (btnYellow == null) {
			btnYellow = new JButton("Yellow");
			btnYellow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pnFondo.setBackground(Color.YELLOW);
				}
			});
			btnYellow.setBackground(Color.YELLOW);
			btnYellow.setBounds(70, 470, 89, 23);
		}
		return btnYellow;
	}
}
