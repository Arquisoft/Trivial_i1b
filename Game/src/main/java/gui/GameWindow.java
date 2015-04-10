package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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

import Model.TrivialQuestion.Categories;
import logic.Game;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import java.awt.Panel;

import logic.model.Player;
import logic.model.User;

public class GameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lbTitle;
	private JPanel panel;
	private JButton btnPulsarDado;
	private JLabel lblTurnoDelJugador;
	private JTextField textField;
	private JTextField txDado;
	private JLabel label;
	private JButton btnAddPlayer;
	private JTextField txPassword;
	private JTextField txUsername;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnOk;
	private JButton btnNewUser;

	private Game game;
	
	private JTable table;
	
	private JButton btCentro;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_25;
	private JButton button_26;
	private JButton button_27;
	private JButton button_28;
	private JButton button_29;
	private JButton button_30;
	private JButton button_31;
	private JButton button_32;
	private JButton button_33;
	private JButton button_34;
	private JButton button_35;
	private JButton button_36;
	private JButton button_37;
	private JButton button_38;
	private JButton button_39;
	private JButton button_40;
	private JButton button_41;
	private JButton button_42;
	private JButton button_43;
	private JButton button_44;
	private JButton button_45;
	private JButton button_46;
	private JButton button_47;
	private JButton button_48;
	private JButton button_49;
	private JButton button_50;
	private JButton button_51;
	private JButton button_52;
	private JButton button_53;
	private JButton button_54;
	private JButton button_55;
	private JButton button_56;
	private JButton button_57;
	private JButton button_58;
	private JButton button_59;
	private JButton button_60;
	private JButton button_61;
	private JButton button_62;
	private JButton button_63;
	private JButton button_64;
	private JButton button_65;
	private JButton button_66;
	private JButton button_67;
	private JButton button_68;
	private JButton button_69;
	private JButton button_70;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GameWindow frame = new
	 * GameWindow(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public GameWindow(Game game) {
		this.game = game;
		setTitle("Trivial - Software Architecture");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				GameWindow.class.getResource("/Images/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBackground(InitialWindow.pnFondo.getBackground());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitle());
		contentPane.add(getBtnPulsarDado());
		contentPane.add(getLblTurnoDelJugador());
		contentPane.add(getTextField());
		contentPane.add(getTxDado());

		contentPane.add(getBtnAddPlayer());
		contentPane.add(getTxPassword());
		contentPane.add(getTxUsername());
		contentPane.add(getPanel());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());

		btnOk = new JButton("OK");
		btnOk.setVisible(false);

		btnOk.setBounds(949, 367, 89, 23);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txUsername.getText().equals("")
						|| txPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"You must fill all the information to log in");
				} else {
					User user = getGame().login(txUsername.getText(),
							txPassword.getText());
					if (user != null) {
						getGame().addPlayer(new Player(user,
								Categories.values().length));
						JOptionPane
						.showMessageDialog(null,
								"User " + user.getUsername() + " logued in.");
					} else
						JOptionPane
								.showMessageDialog(null,
										"There is no user with that username and password");
				}
			}
		});
		contentPane.add(btnOk);

		btnNewUser = new JButton("New user");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserWindow newu = new NewUserWindow(getGame());
				newu.setVisible(true);
			}
		});
		btnNewUser.setVisible(false);
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewUser.setBackground(SystemColor.activeCaption);
		btnNewUser.setForeground(Color.WHITE);
		btnNewUser.setBounds(1046, 367, 89, 23);
		contentPane.add(btnNewUser);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOk.setEnabled(false);
				btnAddPlayer.setEnabled(false);
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStart.setBackground(SystemColor.activeCaption);
		btnStart.setForeground(Color.WHITE);
		btnStart.setBounds(1037, 203, 143, 23);
		contentPane.add(btnStart);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(1193, 47, 143, 216);
		contentPane.add(panel_1);
		panel_1.add(getTable());
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("");
			lbTitle.setIcon(new ImageIcon(GameWindow.class
					.getResource("/Images/tituloSmall.png")));
			lbTitle.setBounds(68, 28, 678, 114);
		}
		return lbTitle;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(InitialWindow.pnFondo.getBackground());
			panel.setBounds(162, 196, 502, 459);
			panel.setLayout(null);
			panel.add(getBtCentro());
			
			JButton btAzul1 = new JButton("New button");
			btAzul1.setBounds(152, 24, 14, 23);
			panel.add(btAzul1);
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getButton_2());
			panel.add(getButton_3());
			panel.add(getButton_4());
			panel.add(getButton_5_1());
			panel.add(getButton_6_1());
			panel.add(getButton_7());
			panel.add(getButton_8());
			panel.add(getButton_9());
			panel.add(getButton_10());
			panel.add(getButton_11());
			panel.add(getButton_12());
			panel.add(getButton_13());
			panel.add(getButton_14());
			panel.add(getButton_15());
			panel.add(getButton_16());
			panel.add(getButton_17());
			panel.add(getButton_18());
			panel.add(getButton_19());
			panel.add(getButton_20());
			panel.add(getButton_21());
			panel.add(getButton_22());
			panel.add(getButton_23());
			panel.add(getButton_24());
			panel.add(getButton_25());
			panel.add(getButton_26());
			panel.add(getButton_27());
			panel.add(getButton_28());
			panel.add(getButton_29());
			panel.add(getButton_30());
			panel.add(getButton_31());
			panel.add(getButton_32());
			panel.add(getButton_33());
			panel.add(getButton_34());
			panel.add(getButton_35());
			panel.add(getButton_36());
			panel.add(getButton_37());
			panel.add(getButton_38());
			panel.add(getButton_39());
			panel.add(getButton_40());
			panel.add(getButton_41());
			panel.add(getButton_42());
			panel.add(getButton_43());
			panel.add(getButton_44());
			panel.add(getButton_45());
			panel.add(getButton_46());
			panel.add(getButton_47());
			panel.add(getButton_48());
			panel.add(getButton_49());
			panel.add(getButton_50());
			panel.add(getButton_51());
			panel.add(getButton_52());
			panel.add(getButton_53());
			panel.add(getButton_54());
			panel.add(getButton_55());
			panel.add(getButton_56());
			panel.add(getButton_57());
			panel.add(getButton_58());
			panel.add(getButton_59());
			panel.add(getButton_61());
			panel.add(getButton_62());
			panel.add(getButton_63());
			panel.add(getButton_64());
			panel.add(getButton_65());
			panel.add(getButton_66());
			panel.add(getButton_67());
			panel.add(getButton_68());
			panel.add(getButton_69());
			panel.add(getButton_70());
			panel.add(getButton_60());
			panel.add(getLabel());
		}
		return panel;
	}

	private JButton getBtnPulsarDado() {
		if (btnPulsarDado == null) {
			btnPulsarDado = new JButton("");
			btnPulsarDado.setContentAreaFilled(false);
			btnPulsarDado.setBorderPainted(false);
			btnPulsarDado.setOpaque(false);
			btnPulsarDado.setIcon(new ImageIcon(GameWindow.class
					.getResource("/Images/Dado.png")));
			btnPulsarDado.setBounds(818, 107, 137, 85);
		}
		return btnPulsarDado;
	}

	private JLabel getLblTurnoDelJugador() {
		if (lblTurnoDelJugador == null) {
			lblTurnoDelJugador = new JLabel("Turn of player:");
			lblTurnoDelJugador.setForeground(new Color(255, 255, 255));
			lblTurnoDelJugador.setFont(new Font("Arial", Font.PLAIN, 16));
			lblTurnoDelJugador.setBounds(792, 47, 143, 32);
		}
		return lblTurnoDelJugador;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(934, 55, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setBounds(949, 122, 86, 53);
			txDado.setColumns(10);
		}
		return txDado;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(0, -14, 500, 473);
			label.setIcon(new ImageIcon(GameWindow.class
					.getResource("/Images/tablero.jpg")));
		}
		return label;
	}

	private JButton getBtnAddPlayer() {
		if (btnAddPlayer == null) {
			btnAddPlayer = new JButton("Add player");
			btnAddPlayer.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAddPlayer.setForeground(Color.WHITE);
			btnAddPlayer.setBackground(SystemColor.activeCaption);
			btnAddPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txPassword.setVisible(true);
					txUsername.setVisible(true);
					lblUsername.setVisible(true);
					lblPassword.setVisible(true);
					btnOk.setVisible(true);
					btnNewUser.setVisible(true);
				}
			});
			btnAddPlayer.setBounds(867, 203, 160, 23);
		}
		return btnAddPlayer;
	}

	private JTextField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setVisible(false);
			txPassword.setBounds(934, 327, 288, 20);
			txPassword.setColumns(10);
		}
		return txPassword;
	}

	private JTextField getTxUsername() {
		if (txUsername == null) {
			txUsername = new JTextField();
			txUsername.setVisible(false);
			txUsername.setBounds(934, 296, 288, 20);
			txUsername.setColumns(10);
		}
		return txUsername;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setVisible(false);
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("Arial", Font.PLAIN, 13));
			lblUsername.setBounds(812, 299, 112, 14);
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setVisible(false);
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
			lblPassword.setBounds(812, 329, 112, 14);
		}
		return lblPassword;
	}

	public Game getGame() {
		return game;
	}
	
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	
	private JButton getBtCentro() {
		if (btCentro == null) {
			btCentro = new JButton("New button");
			btCentro.setBounds(202, 201, 49, 40);
		}
		return btCentro;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("New button");
			button.setBounds(176, 11, 14, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("New button");
			button_1.setBounds(202, 11, 14, 23);
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("New button");
			button_2.setBounds(226, 11, 14, 23);
		}
		return button_2;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("New button");
			button_3.setBounds(259, 11, 14, 23);
		}
		return button_3;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("New button");
			button_4.setBounds(283, 11, 14, 23);
		}
		return button_4;
	}
	private JButton getButton_5_1() {
		if (button_5 == null) {
			button_5 = new JButton("New button");
			button_5.setBounds(320, 35, 14, 23);
		}
		return button_5;
	}
	private JButton getButton_6_1() {
		if (button_6 == null) {
			button_6 = new JButton("New button");
			button_6.setBounds(115, 35, 14, 23);
		}
		return button_6;
	}
	private JButton getButton_7() {
		if (button_7 == null) {
			button_7 = new JButton("New button");
			button_7.setBounds(82, 58, 14, 23);
		}
		return button_7;
	}
	private JButton getButton_8() {
		if (button_8 == null) {
			button_8 = new JButton("New button");
			button_8.setBounds(69, 76, 14, 23);
		}
		return button_8;
	}
	private JButton getButton_9() {
		if (button_9 == null) {
			button_9 = new JButton("New button");
			button_9.setBounds(45, 98, 14, 23);
		}
		return button_9;
	}
	private JButton getButton_10() {
		if (button_10 == null) {
			button_10 = new JButton("New button");
			button_10.setBounds(31, 118, 14, 23);
		}
		return button_10;
	}
	private JButton getButton_11() {
		if (button_11 == null) {
			button_11 = new JButton("New button");
			button_11.setBounds(20, 140, 14, 23);
		}
		return button_11;
	}
	private JButton getButton_12() {
		if (button_12 == null) {
			button_12 = new JButton("New button");
			button_12.setBounds(20, 174, 14, 23);
		}
		return button_12;
	}
	private JButton getButton_13() {
		if (button_13 == null) {
			button_13 = new JButton("New button");
			button_13.setBounds(20, 210, 14, 23);
		}
		return button_13;
	}
	private JButton getButton_14() {
		if (button_14 == null) {
			button_14 = new JButton("New button");
			button_14.setBounds(20, 250, 14, 23);
		}
		return button_14;
	}
	private JButton getButton_15() {
		if (button_15 == null) {
			button_15 = new JButton("New button");
			button_15.setBounds(20, 270, 14, 23);
		}
		return button_15;
	}
	private JButton getButton_16() {
		if (button_16 == null) {
			button_16 = new JButton("New button");
			button_16.setBounds(31, 304, 14, 23);
		}
		return button_16;
	}
	private JButton getButton_17() {
		if (button_17 == null) {
			button_17 = new JButton("New button");
			button_17.setBounds(45, 327, 14, 23);
		}
		return button_17;
	}
	private JButton getButton_18() {
		if (button_18 == null) {
			button_18 = new JButton("New button");
			button_18.setBounds(55, 345, 14, 23);
		}
		return button_18;
	}
	private JButton getButton_19() {
		if (button_19 == null) {
			button_19 = new JButton("New button");
			button_19.setBounds(82, 364, 14, 23);
		}
		return button_19;
	}
	private JButton getButton_20() {
		if (button_20 == null) {
			button_20 = new JButton("New button");
			button_20.setBounds(115, 390, 14, 23);
		}
		return button_20;
	}
	private JButton getButton_21() {
		if (button_21 == null) {
			button_21 = new JButton("New button");
			button_21.setBounds(152, 402, 14, 23);
		}
		return button_21;
	}
	private JButton getButton_22() {
		if (button_22 == null) {
			button_22 = new JButton("New button");
			button_22.setBounds(176, 402, 14, 23);
		}
		return button_22;
	}
	private JButton getButton_23() {
		if (button_23 == null) {
			button_23 = new JButton("New button");
			button_23.setBounds(202, 413, 14, 23);
		}
		return button_23;
	}
	private JButton getButton_24() {
		if (button_24 == null) {
			button_24 = new JButton("New button");
			button_24.setBounds(226, 413, 14, 23);
		}
		return button_24;
	}
	private JButton getButton_25() {
		if (button_25 == null) {
			button_25 = new JButton("New button");
			button_25.setBounds(259, 413, 14, 23);
		}
		return button_25;
	}
	private JButton getButton_26() {
		if (button_26 == null) {
			button_26 = new JButton("New button");
			button_26.setBounds(283, 402, 14, 23);
		}
		return button_26;
	}
	private JButton getButton_27() {
		if (button_27 == null) {
			button_27 = new JButton("New button");
			button_27.setBounds(320, 390, 14, 23);
		}
		return button_27;
	}
	private JButton getButton_28() {
		if (button_28 == null) {
			button_28 = new JButton("New button");
			button_28.setBounds(358, 364, 14, 23);
		}
		return button_28;
	}
	private JButton getButton_29() {
		if (button_29 == null) {
			button_29 = new JButton("New button");
			button_29.setBounds(371, 345, 14, 23);
		}
		return button_29;
	}
	private JButton getButton_30() {
		if (button_30 == null) {
			button_30 = new JButton("New button");
			button_30.setBounds(396, 327, 14, 23);
		}
		return button_30;
	}
	private JButton getButton_31() {
		if (button_31 == null) {
			button_31 = new JButton("New button");
			button_31.setBounds(396, 293, 14, 23);
		}
		return button_31;
	}
	private JButton getButton_32() {
		if (button_32 == null) {
			button_32 = new JButton("New button");
			button_32.setBounds(415, 270, 14, 23);
		}
		return button_32;
	}
	private JButton getButton_33() {
		if (button_33 == null) {
			button_33 = new JButton("New button");
			button_33.setBounds(425, 250, 14, 23);
		}
		return button_33;
	}
	private JButton getButton_34() {
		if (button_34 == null) {
			button_34 = new JButton("New button");
			button_34.setBounds(415, 210, 14, 23);
		}
		return button_34;
	}
	private JButton getButton_35() {
		if (button_35 == null) {
			button_35 = new JButton("New button");
			button_35.setBounds(415, 174, 14, 23);
		}
		return button_35;
	}
	private JButton getButton_36() {
		if (button_36 == null) {
			button_36 = new JButton("New button");
			button_36.setBounds(415, 140, 14, 23);
		}
		return button_36;
	}
	private JButton getButton_37() {
		if (button_37 == null) {
			button_37 = new JButton("New button");
			button_37.setBounds(396, 118, 14, 23);
		}
		return button_37;
	}
	private JButton getButton_38() {
		if (button_38 == null) {
			button_38 = new JButton("New button");
			button_38.setBounds(383, 98, 14, 23);
		}
		return button_38;
	}
	private JButton getButton_39() {
		if (button_39 == null) {
			button_39 = new JButton("New button");
			button_39.setBounds(371, 76, 14, 23);
		}
		return button_39;
	}
	private JButton getButton_40() {
		if (button_40 == null) {
			button_40 = new JButton("New button");
			button_40.setOpaque(false);
			button_40.setIcon(null);
			button_40.setBounds(345, 58, 14, 23);
		}
		return button_40;
	}
	private JButton getButton_41() {
		if (button_41 == null) {
			button_41 = new JButton("New button");
			button_41.setOpaque(false);
			button_41.setIcon(null);
			button_41.setBounds(45, 210, 14, 23);
		}
		return button_41;
	}
	private JButton getButton_42() {
		if (button_42 == null) {
			button_42 = new JButton("New button");
			button_42.setOpaque(false);
			button_42.setIcon(null);
			button_42.setBounds(82, 210, 14, 23);
		}
		return button_42;
	}
	private JButton getButton_43() {
		if (button_43 == null) {
			button_43 = new JButton("New button");
			button_43.setOpaque(false);
			button_43.setIcon(null);
			button_43.setBounds(106, 210, 14, 23);
		}
		return button_43;
	}
	private JButton getButton_44() {
		if (button_44 == null) {
			button_44 = new JButton("New button");
			button_44.setOpaque(false);
			button_44.setIcon(null);
			button_44.setBounds(134, 210, 14, 23);
		}
		return button_44;
	}
	private JButton getButton_45() {
		if (button_45 == null) {
			button_45 = new JButton("New button");
			button_45.setOpaque(false);
			button_45.setIcon(null);
			button_45.setBounds(158, 210, 14, 23);
		}
		return button_45;
	}
	private JButton getButton_46() {
		if (button_46 == null) {
			button_46 = new JButton("New button");
			button_46.setOpaque(false);
			button_46.setIcon(null);
			button_46.setBounds(272, 210, 14, 23);
		}
		return button_46;
	}
	private JButton getButton_47() {
		if (button_47 == null) {
			button_47 = new JButton("New button");
			button_47.setOpaque(false);
			button_47.setIcon(null);
			button_47.setBounds(296, 210, 14, 23);
		}
		return button_47;
	}
	private JButton getButton_48() {
		if (button_48 == null) {
			button_48 = new JButton("New button");
			button_48.setOpaque(false);
			button_48.setIcon(null);
			button_48.setBounds(334, 210, 14, 23);
		}
		return button_48;
	}
	private JButton getButton_49() {
		if (button_49 == null) {
			button_49 = new JButton("New button");
			button_49.setOpaque(false);
			button_49.setIcon(null);
			button_49.setBounds(358, 210, 14, 23);
		}
		return button_49;
	}
	private JButton getButton_50() {
		if (button_50 == null) {
			button_50 = new JButton("New button");
			button_50.setOpaque(false);
			button_50.setIcon(null);
			button_50.setBounds(391, 210, 14, 23);
		}
		return button_50;
	}
	private JButton getButton_51() {
		if (button_51 == null) {
			button_51 = new JButton("New button");
			button_51.setOpaque(false);
			button_51.setIcon(null);
			button_51.setBounds(190, 167, 14, 23);
		}
		return button_51;
	}
	private JButton getButton_52() {
		if (button_52 == null) {
			button_52 = new JButton("New button");
			button_52.setOpaque(false);
			button_52.setIcon(null);
			button_52.setBounds(176, 140, 14, 23);
		}
		return button_52;
	}
	private JButton getButton_53() {
		if (button_53 == null) {
			button_53 = new JButton("New button");
			button_53.setOpaque(false);
			button_53.setIcon(null);
			button_53.setBounds(152, 118, 14, 23);
		}
		return button_53;
	}
	private JButton getButton_54() {
		if (button_54 == null) {
			button_54 = new JButton("New button");
			button_54.setOpaque(false);
			button_54.setIcon(null);
			button_54.setBounds(152, 84, 14, 23);
		}
		return button_54;
	}
	private JButton getButton_55() {
		if (button_55 == null) {
			button_55 = new JButton("New button");
			button_55.setOpaque(false);
			button_55.setIcon(null);
			button_55.setBounds(134, 58, 14, 23);
		}
		return button_55;
	}
	private JButton getButton_56() {
		if (button_56 == null) {
			button_56 = new JButton("New button");
			button_56.setOpaque(false);
			button_56.setIcon(null);
			button_56.setBounds(246, 252, 14, 23);
		}
		return button_56;
	}
	private JButton getButton_57() {
		if (button_57 == null) {
			button_57 = new JButton("New button");
			button_57.setOpaque(false);
			button_57.setIcon(null);
			button_57.setBounds(259, 282, 14, 23);
		}
		return button_57;
	}
	private JButton getButton_58() {
		if (button_58 == null) {
			button_58 = new JButton("New button");
			button_58.setOpaque(false);
			button_58.setIcon(null);
			button_58.setBounds(283, 304, 14, 23);
		}
		return button_58;
	}
	private JButton getButton_59() {
		if (button_59 == null) {
			button_59 = new JButton("New button");
			button_59.setOpaque(false);
			button_59.setIcon(null);
			button_59.setBounds(283, 327, 14, 23);
		}
		return button_59;
	}
	private JButton getButton_60() {
		if (button_60 == null) {
			button_60 = new JButton("New button");
			button_60.setOpaque(false);
			button_60.setIcon(null);
			button_60.setBounds(307, 364, 14, 23);
		}
		return button_60;
	}
	private JButton getButton_61() {
		if (button_61 == null) {
			button_61 = new JButton("New button");
			button_61.setOpaque(false);
			button_61.setIcon(null);
			button_61.setBounds(134, 364, 14, 23);
		}
		return button_61;
	}
	private JButton getButton_62() {
		if (button_62 == null) {
			button_62 = new JButton("New button");
			button_62.setOpaque(false);
			button_62.setIcon(null);
			button_62.setBounds(152, 327, 14, 23);
		}
		return button_62;
	}
	private JButton getButton_63() {
		if (button_63 == null) {
			button_63 = new JButton("New button");
			button_63.setOpaque(false);
			button_63.setIcon(null);
			button_63.setBounds(158, 304, 14, 23);
		}
		return button_63;
	}
	private JButton getButton_64() {
		if (button_64 == null) {
			button_64 = new JButton("New button");
			button_64.setOpaque(false);
			button_64.setIcon(null);
			button_64.setBounds(176, 282, 14, 23);
		}
		return button_64;
	}
	private JButton getButton_65() {
		if (button_65 == null) {
			button_65 = new JButton("New button");
			button_65.setOpaque(false);
			button_65.setIcon(null);
			button_65.setBounds(190, 250, 14, 23);
		}
		return button_65;
	}
	private JButton getButton_66() {
		if (button_66 == null) {
			button_66 = new JButton("New button");
			button_66.setOpaque(false);
			button_66.setIcon(null);
			button_66.setBounds(246, 167, 14, 23);
		}
		return button_66;
	}
	private JButton getButton_67() {
		if (button_67 == null) {
			button_67 = new JButton("New button");
			button_67.setOpaque(false);
			button_67.setIcon(null);
			button_67.setBounds(259, 140, 14, 23);
		}
		return button_67;
	}
	private JButton getButton_68() {
		if (button_68 == null) {
			button_68 = new JButton("New button");
			button_68.setOpaque(false);
			button_68.setIcon(null);
			button_68.setBounds(283, 118, 14, 23);
		}
		return button_68;
	}
	private JButton getButton_69() {
		if (button_69 == null) {
			button_69 = new JButton("New button");
			button_69.setOpaque(false);
			button_69.setIcon(null);
			button_69.setBounds(283, 84, 14, 23);
		}
		return button_69;
	}
	private JButton getButton_70() {
		if (button_70 == null) {
			button_70 = new JButton("New button");
			button_70.setOpaque(false);
			button_70.setIcon(null);
			button_70.setBounds(296, 58, 14, 23);
		}
		return button_70;
	}
}
