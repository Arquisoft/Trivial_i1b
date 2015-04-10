package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Game;
import logic.model.Player;
import logic.model.Position;
import logic.model.User;
import Model.TrivialQuestion.Categories;

public class GameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lbTitle;
	private JPanel BoardPanel;
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
	
	private Map<Player,Icon> colorsPlayers;
	
	private JButton btCentro;
	private JButton b0_2;
	private JButton b0_3;
	private JButton b0_4;
	private JButton b0_5;
	private JButton b0_6;
	private JButton b0_7;
	private JButton b0_42;
	private JButton b0_41;
	private JButton b0_40;
	private JButton b0_39;
	private JButton b0_38;
	private JButton b0_37;
	private JButton b0_36;
	private JButton b0_35;
	private JButton b0_34;
	private JButton b0_33;
	private JButton b0_32;
	private JButton b0_31;
	private JButton b0_30;
	private JButton b0_29;
	private JButton b0_28;
	private JButton b0_27;
	private JButton b0_26;
	private JButton b0_25;
	private JButton b0_24;
	private JButton b0_23;
	private JButton b0_22;
	private JButton b0_21;
	private JButton b0_20;
	private JButton b0_19;
	private JButton b0_18;
	private JButton b0_17;
	private JButton b0_16;
	private JButton b0_15;
	private JButton b0_14;
	private JButton b0_13;
	private JButton b0_12;
	private JButton b0_11;
	private JButton b0_10;
	private JButton b0_9;
	private JButton b0_8;
	private JButton b5_1;
	private JButton b5_2;
	private JButton b5_3;
	private JButton b5_4;
	private JButton b5_5;
	private JButton b2_5;
	private JButton b2_4;
	private JButton b2_3;
	private JButton b2_2;
	private JButton b2_1;
	private JButton b6_5;
	private JButton b6_4;
	private JButton b6_3;
	private JButton b6_2;
	private JButton b6_1;
	private JButton b3_5;
	private JButton b3_4;
	private JButton b3_3;
	private JButton b3_2;
	private JButton b3_1;
	private JButton b4_1;
	private JButton b4_2;
	private JButton b4_3;
	private JButton b4_4;
	private JButton b4_5;
	private JButton b1_5;
	private JButton b1_4;
	private JButton b1_3;
	private JButton b1_2;
	private JButton b1_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

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
		contentPane.add(getBoardPanel());
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
						for (Player p : getGame().getPlayers()) {
							if (p.getUsername().equals(user.getUsername())) {
								JOptionPane.showMessageDialog(null, "User "
										+ user.getUsername()
										+ " already logued in.");
							} else {
								getGame().addPlayer(
										new Player(user, Categories.values().length));
								JOptionPane.showMessageDialog(null, "User "
										+ user.getUsername() + " logued in.");
							}
						}
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
				btnAddPlayer.setEnabled(false);
				txPassword.setVisible(false);
				txUsername.setVisible(false);
				lblUsername.setVisible(false);
				lblPassword.setVisible(false);
				btnOk.setVisible(false);
				btnNewUser.setVisible(false);
				
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStart.setBackground(SystemColor.activeCaption);
		btnStart.setForeground(Color.WHITE);
		btnStart.setBounds(1037, 203, 143, 23);
		contentPane.add(btnStart);
		
		JPanel QuestionPn = new JPanel();
		QuestionPn.setBounds(714, 415, 622, 252);
		contentPane.add(QuestionPn);
		QuestionPn.setLayout(new BorderLayout(0, 0));
		QuestionPn.setVisible(false);
		
		JLabel lbQuestion = new JLabel("Question");
		lbQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbQuestion.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		QuestionPn.add(lbQuestion, BorderLayout.NORTH);
		
		JPanel PnAnswer = new JPanel();
		QuestionPn.add(PnAnswer, BorderLayout.CENTER);
		PnAnswer.setLayout(new GridLayout(2,2));
		PnAnswer.add(getBtnNewButton());
		PnAnswer.add(getBtnNewButton_1());
		PnAnswer.add(getBtnNewButton_2());
		PnAnswer.add(getBtnNewButton_3());
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

	private JPanel getBoardPanel() {
		if (BoardPanel == null) {
			BoardPanel = new JPanel();
			BoardPanel.setBackground(InitialWindow.pnFondo.getBackground());
			BoardPanel.setBounds(162, 196, 502, 459);
			BoardPanel.setLayout(null);
			BoardPanel.add(getBtCentro());
			
			JButton b0_1 = new JButton("");
			b0_1.setContentAreaFilled(false);
			b0_1.setEnabled(false);
			b0_1.setActionCommand("0_1");
			b0_1.setBounds(152, 24, 14, 23);
			BoardPanel.add(b0_1);
			BoardPanel.add(getB0_2());
			BoardPanel.add(getB0_3());
			BoardPanel.add(getB0_4());
			BoardPanel.add(getB0_5());
			BoardPanel.add(getB0_6());
			BoardPanel.add(getB0_7());
			BoardPanel.add(get0_42());
			BoardPanel.add(getB0_41());
			BoardPanel.add(getB0_40());
			BoardPanel.add(getB0_39());
			BoardPanel.add(getB0_38());
			BoardPanel.add(getB0_37());
			BoardPanel.add(getB0_36());
			BoardPanel.add(getB0_35());
			BoardPanel.add(getB0_34());
			BoardPanel.add(getB0_33());
			BoardPanel.add(getB0_32());
			BoardPanel.add(getB0_31());
			BoardPanel.add(getB0_30());
			BoardPanel.add(getB0_29());
			BoardPanel.add(getB0_28());
			BoardPanel.add(getB0_27());
			BoardPanel.add(getB0_26());
			BoardPanel.add(getB0_25());
			BoardPanel.add(getB0_24());
			BoardPanel.add(getB0_23());
			BoardPanel.add(getB0_22());
			BoardPanel.add(getB0_21());
			BoardPanel.add(getB0_20());
			BoardPanel.add(getB0_19());
			BoardPanel.add(getB0_18());
			BoardPanel.add(getB0_17());
			BoardPanel.add(getB0_16());
			BoardPanel.add(getB0_15());
			BoardPanel.add(getB0_14());
			BoardPanel.add(getB0_13());
			BoardPanel.add(getB0_12());
			BoardPanel.add(getB0_11());
			BoardPanel.add(getB0_10());
			BoardPanel.add(getB0_9());
			BoardPanel.add(getB0_8());
			BoardPanel.add(getB5_1());
			BoardPanel.add(getB5_2());
			BoardPanel.add(getB5_3());
			BoardPanel.add(getB5_4());
			BoardPanel.add(getB5_5());
			BoardPanel.add(getB2_5());
			BoardPanel.add(getB2_4());
			BoardPanel.add(getB2_3());
			BoardPanel.add(getB2_2());
			BoardPanel.add(getB2_1());
			BoardPanel.add(getB6_5());
			BoardPanel.add(getB6_4());
			BoardPanel.add(getB6_3());
			BoardPanel.add(getB6_2());
			BoardPanel.add(getB6_1());
			BoardPanel.add(getB3_5());
			BoardPanel.add(getB3_4());
			BoardPanel.add(getB3_3());
			BoardPanel.add(getB3_2());
			BoardPanel.add(getB4_1());
			BoardPanel.add(getB4_2());
			BoardPanel.add(getB4_3());
			BoardPanel.add(getB4_4());
			BoardPanel.add(getB4_5());
			BoardPanel.add(getB1_5());
			BoardPanel.add(getB1_4());
			BoardPanel.add(getB1_3());
			BoardPanel.add(getB1_2());
			BoardPanel.add(getB1_1());
			BoardPanel.add(getB3_1());
			BoardPanel.add(getLabel());
		}
		return BoardPanel;
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
					startGame();
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
	
	private void createMapPlayers(List<Player> players){
		colorsPlayers = new HashMap<Player,Icon>();
		int i = 1;
		for(Player p: players){
			colorsPlayers.put(p, new ImageIcon(GameWindow.class.getResource("/Images/player"+i+".png")));
			i++;
		}			
	}
	
	private void startGame(){
		createMapPlayers(game.getPlayers());
		updatePlayers(game.getPlayers());
	}
	
	private void updatePlayers(List<Player> players) {
		for(Player p: players){
			
			JButton b = getButton(p.getPosition());
			b.setContentAreaFilled(true);
			b.setEnabled(true);
			b.setIcon(colorsPlayers.get(p));
		}
			
	}
	
	private JButton getButton(Position position){
		Component[] buttons = BoardPanel.getComponents();
		for (Component comp : buttons) {
			if(comp instanceof JButton){
				JButton button = (JButton) comp;
				if(String.valueOf(position.getWalk() + "_" + position.getIndex()).equals(button.getActionCommand())){
					return button;
				}
			}
		}
		return null;
	}

	

	private JButton getBtCentro() {
		if (btCentro == null) {
			btCentro = new JButton("");
			btCentro.setContentAreaFilled(false);
			btCentro.setEnabled(false);
			btCentro.setActionCommand("0_0");
			btCentro.setBounds(202, 201, 49, 40);
		}
		return btCentro;
	}
	private JButton getB0_2() {
		if (b0_2 == null) {
			b0_2 = new JButton("");
			b0_2.setContentAreaFilled(false);
			b0_2.setEnabled(false);
			b0_2.setActionCommand("0_0");
			b0_2.setBounds(176, 11, 14, 23);
		}
		return b0_2;
	}
	private JButton getB0_3() {
		if (b0_3 == null) {
			b0_3 = new JButton("");
			b0_3.setContentAreaFilled(false);
			b0_3.setEnabled(false);
			b0_3.setActionCommand("0_3");
			b0_3.setBounds(202, 11, 14, 23);
		}
		return b0_3;
	}
	private JButton getB0_4() {
		if (b0_4 == null) {
			b0_4 = new JButton("");
			b0_4.setContentAreaFilled(false);
			b0_4.setEnabled(false);
			b0_4.setActionCommand("0_4");
			b0_4.setBounds(226, 11, 14, 23);
		}
		return b0_4;
	}
	private JButton getB0_5() {
		if (b0_5 == null) {
			b0_5 = new JButton("");
			b0_5.setContentAreaFilled(false);
			b0_5.setEnabled(false);
			b0_5.setActionCommand("0_5");
			b0_5.setBounds(259, 11, 14, 23);
		}
		return b0_5;
	}
	private JButton getB0_6() {
		if (b0_6 == null) {
			b0_6 = new JButton("");
			b0_6.setContentAreaFilled(false);
			b0_6.setEnabled(false);
			b0_6.setActionCommand("0_6");
			b0_6.setBounds(283, 11, 14, 23);
		}
		return b0_6;
	}
	private JButton getB0_7() {
		if (b0_7 == null) {
			b0_7 = new JButton("");
			b0_7.setContentAreaFilled(false);
			b0_7.setEnabled(false);
			b0_7.setActionCommand("0_7");
			b0_7.setBounds(320, 35, 14, 23);
		}
		return b0_7;
	}
	private JButton get0_42() {
		if (b0_42 == null) {
			b0_42 = new JButton("");
			b0_42.setContentAreaFilled(false);
			b0_42.setEnabled(false);
			b0_42.setActionCommand("0_42");
			b0_42.setBounds(115, 35, 14, 23);
		}
		return b0_42;
	}
	private JButton getB0_41() {
		if (b0_41 == null) {
			b0_41 = new JButton("");
			b0_41.setContentAreaFilled(false);
			b0_41.setEnabled(false);
			b0_41.setActionCommand("0_41");
			b0_41.setBounds(82, 58, 14, 23);
		}
		return b0_41;
	}
	private JButton getB0_40() {
		if (b0_40 == null) {
			b0_40 = new JButton("");
			b0_40.setContentAreaFilled(false);
			b0_40.setEnabled(false);
			b0_40.setActionCommand("0_40");
			b0_40.setBounds(69, 76, 14, 23);
		}
		return b0_40;
	}
	private JButton getB0_39() {
		if (b0_39 == null) {
			b0_39 = new JButton("");
			b0_39.setContentAreaFilled(false);
			b0_39.setEnabled(false);
			b0_39.setActionCommand("0_39");
			b0_39.setBounds(45, 98, 14, 23);
		}
		return b0_39;
	}
	private JButton getB0_38() {
		if (b0_38 == null) {
			b0_38 = new JButton("");
			b0_38.setContentAreaFilled(false);
			b0_38.setEnabled(false);
			b0_38.setActionCommand("0_38");
			b0_38.setBounds(31, 118, 14, 23);
		}
		return b0_38;
	}
	private JButton getB0_37() {
		if (b0_37 == null) {
			b0_37 = new JButton("");
			b0_37.setContentAreaFilled(false);
			b0_37.setEnabled(false);
			b0_37.setActionCommand("0_37");
			b0_37.setBounds(20, 140, 14, 23);
		}
		return b0_37;
	}
	private JButton getB0_36() {
		if (b0_36 == null) {
			b0_36 = new JButton("");
			b0_36.setContentAreaFilled(false);
			b0_36.setEnabled(false);
			b0_36.setActionCommand("0_36");
			b0_36.setBounds(20, 174, 14, 23);
		}
		return b0_36;
	}
	private JButton getB0_35() {
		if (b0_35 == null) {
			b0_35 = new JButton("");
			b0_35.setContentAreaFilled(false);
			b0_35.setEnabled(false);
			b0_35.setActionCommand("0_35");
			b0_35.setBounds(20, 210, 14, 23);
		}
		return b0_35;
	}
	private JButton getB0_34() {
		if (b0_34 == null) {
			b0_34 = new JButton("");
			b0_34.setContentAreaFilled(false);
			b0_34.setEnabled(false);
			b0_34.setActionCommand("0_34");
			b0_34.setBounds(20, 250, 14, 23);
		}
		return b0_34;
	}
	private JButton getB0_33() {
		if (b0_33 == null) {
			b0_33 = new JButton("");
			b0_33.setContentAreaFilled(false);
			b0_33.setEnabled(false);
			b0_33.setActionCommand("0_33");
			b0_33.setBounds(20, 270, 14, 23);
		}
		return b0_33;
	}
	private JButton getB0_32() {
		if (b0_32 == null) {
			b0_32 = new JButton("");
			b0_32.setContentAreaFilled(false);
			b0_32.setEnabled(false);
			b0_32.setActionCommand("0_32");
			b0_32.setBounds(31, 304, 14, 23);
		}
		return b0_32;
	}
	private JButton getB0_31() {
		if (b0_31 == null) {
			b0_31 = new JButton("");
			b0_31.setContentAreaFilled(false);
			b0_31.setEnabled(false);
			b0_31.setActionCommand("0_31");
			b0_31.setBounds(45, 327, 14, 23);
		}
		return b0_31;
	}
	private JButton getB0_30() {
		if (b0_30 == null) {
			b0_30 = new JButton("");
			b0_30.setContentAreaFilled(false);
			b0_30.setEnabled(false);
			b0_30.setActionCommand("0_30");
			b0_30.setBounds(55, 345, 14, 23);
		}
		return b0_30;
	}
	private JButton getB0_29() {
		if (b0_29 == null) {
			b0_29 = new JButton("");
			b0_29.setContentAreaFilled(false);
			b0_29.setEnabled(false);
			b0_29.setActionCommand("0_29");
			b0_29.setBounds(82, 364, 14, 23);
		}
		return b0_29;
	}
	private JButton getB0_28() {
		if (b0_28 == null) {
			b0_28 = new JButton("");
			b0_28.setContentAreaFilled(false);
			b0_28.setEnabled(false);
			b0_28.setActionCommand("0_28");
			b0_28.setBounds(115, 390, 14, 23);
		}
		return b0_28;
	}
	private JButton getB0_27() {
		if (b0_27 == null) {
			b0_27 = new JButton("");
			b0_27.setContentAreaFilled(false);
			b0_27.setEnabled(false);
			b0_27.setActionCommand("0_27");
			b0_27.setBounds(152, 402, 14, 23);
		}
		return b0_27;
	}
	private JButton getB0_26() {
		if (b0_26 == null) {
			b0_26 = new JButton("");
			b0_26.setContentAreaFilled(false);
			b0_26.setEnabled(false);
			b0_26.setActionCommand("0_26");
			b0_26.setBounds(176, 402, 14, 23);
		}
		return b0_26;
	}
	private JButton getB0_25() {
		if (b0_25 == null) {
			b0_25 = new JButton("");
			b0_25.setContentAreaFilled(false);
			b0_25.setEnabled(false);
			b0_25.setActionCommand("0_25");
			b0_25.setBounds(202, 413, 14, 23);
		}
		return b0_25;
	}
	private JButton getB0_24() {
		if (b0_24 == null) {
			b0_24 = new JButton("");
			b0_24.setContentAreaFilled(false);
			b0_24.setEnabled(false);
			b0_24.setActionCommand("0_24");
			b0_24.setBounds(226, 413, 14, 23);
		}
		return b0_24;
	}
	private JButton getB0_23() {
		if (b0_23 == null) {
			b0_23 = new JButton("");
			b0_23.setContentAreaFilled(false);
			b0_23.setEnabled(false);
			b0_23.setActionCommand("0_23");
			b0_23.setBounds(259, 413, 14, 23);
		}
		return b0_23;
	}
	private JButton getB0_22() {
		if (b0_22 == null) {
			b0_22 = new JButton("");
			b0_22.setContentAreaFilled(false);
			b0_22.setEnabled(false);
			b0_22.setActionCommand("0_22");
			b0_22.setBounds(283, 402, 14, 23);
		}
		return b0_22;
	}
	private JButton getB0_21() {
		if (b0_21 == null) {
			b0_21 = new JButton("");
			b0_21.setContentAreaFilled(false);
			b0_21.setEnabled(false);
			b0_21.setActionCommand("0_21");
			b0_21.setBounds(320, 390, 14, 23);
		}
		return b0_21;
	}
	private JButton getB0_20() {
		if (b0_20 == null) {
			b0_20 = new JButton("");
			b0_20.setContentAreaFilled(false);
			b0_20.setEnabled(false);
			b0_20.setActionCommand("0_20");
			b0_20.setBounds(358, 364, 14, 23);
		}
		return b0_20;
	}
	private JButton getB0_19() {
		if (b0_19 == null) {
			b0_19 = new JButton("");
			b0_19.setContentAreaFilled(false);
			b0_19.setEnabled(false);
			b0_19.setActionCommand("0_19");
			b0_19.setBounds(371, 345, 14, 23);
		}
		return b0_19;
	}
	private JButton getB0_18() {
		if (b0_18 == null) {
			b0_18 = new JButton("");
			b0_18.setContentAreaFilled(false);
			b0_18.setEnabled(false);
			b0_18.setActionCommand("0_18");
			b0_18.setBounds(396, 327, 14, 23);
		}
		return b0_18;
	}
	private JButton getB0_17() {
		if (b0_17 == null) {
			b0_17 = new JButton("");
			b0_17.setContentAreaFilled(false);
			b0_17.setEnabled(false);
			b0_17.setActionCommand("0_17");
			b0_17.setBounds(396, 293, 14, 23);
		}
		return b0_17;
	}
	private JButton getB0_16() {
		if (b0_16 == null) {
			b0_16 = new JButton("");
			b0_16.setContentAreaFilled(false);
			b0_16.setEnabled(false);
			b0_16.setActionCommand("0_16");
			b0_16.setBounds(415, 270, 14, 23);
		}
		return b0_16;
	}
	private JButton getB0_15() {
		if (b0_15 == null) {
			b0_15 = new JButton("");
			b0_15.setContentAreaFilled(false);
			b0_15.setEnabled(false);
			b0_15.setActionCommand("0_15");
			b0_15.setBounds(425, 250, 14, 23);
		}
		return b0_15;
	}
	private JButton getB0_14() {
		if (b0_14 == null) {
			b0_14 = new JButton("");
			b0_14.setContentAreaFilled(false);
			b0_14.setEnabled(false);
			b0_14.setActionCommand("0_14");
			b0_14.setBounds(415, 210, 14, 23);
		}
		return b0_14;
	}
	private JButton getB0_13() {
		if (b0_13 == null) {
			b0_13 = new JButton("");
			b0_13.setContentAreaFilled(false);
			b0_13.setEnabled(false);
			b0_14.setActionCommand("0_13");
			b0_13.setBounds(415, 174, 14, 23);
		}
		return b0_13;
	}
	private JButton getB0_12() {
		if (b0_12 == null) {
			b0_12 = new JButton("");
			b0_12.setContentAreaFilled(false);
			b0_12.setEnabled(false);
			b0_14.setActionCommand("0_12");
			b0_12.setBounds(415, 140, 14, 23);
		}
		return b0_12;
	}
	private JButton getB0_11() {
		if (b0_11 == null) {
			b0_11 = new JButton("");
			b0_11.setContentAreaFilled(false);
			b0_11.setEnabled(false);
			b0_14.setActionCommand("0_11");
			b0_11.setBounds(396, 118, 14, 23);
		}
		return b0_11;
	}
	private JButton getB0_10() {
		if (b0_10 == null) {
			b0_10 = new JButton("");
			b0_10.setContentAreaFilled(false);
			b0_10.setEnabled(false);
			b0_14.setActionCommand("0_10");
			b0_10.setBounds(383, 98, 14, 23);
		}
		return b0_10;
	}
	private JButton getB0_9() {
		if (b0_9 == null) {
			b0_9 = new JButton("");
			b0_9.setContentAreaFilled(false);
			b0_9.setEnabled(false);
			b0_9.setActionCommand("0_9");
			b0_9.setBounds(371, 76, 14, 23);
		}
		return b0_9;
	}
	private JButton getB0_8() {
		if (b0_8 == null) {
			b0_8 = new JButton("");
			b0_8.setContentAreaFilled(false);
			b0_8.setEnabled(false);
			b0_8.setActionCommand("0_8");
			b0_8.setBounds(345, 58, 14, 23);
		}
		return b0_8;
	}
	private JButton getB5_1() {
		if (b5_1 == null) {
			b5_1 = new JButton("");
			b5_1.setContentAreaFilled(false);
			b5_1.setEnabled(false);
			b5_1.setActionCommand("5_1");	
			b5_1.setBounds(45, 210, 14, 23);
		}
		return b5_1;
	}
	private JButton getB5_2() {
		if (b5_2 == null) {
			b5_2 = new JButton("");
			b5_2.setContentAreaFilled(false);
			b5_2.setEnabled(false);
			b5_2.setActionCommand("5_2");
			b5_2.setBounds(82, 210, 14, 23);
		}
		return b5_2;
	}
	private JButton getB5_3() {
		if (b5_3 == null) {
			b5_3 = new JButton("");
			b5_3.setContentAreaFilled(false);
			b5_3.setEnabled(false);
			b5_3.setActionCommand("5_3");
			b5_3.setBounds(106, 210, 14, 23);
		}
		return b5_3;
	}
	private JButton getB5_4() {
		if (b5_4 == null) {
			b5_4 = new JButton("");
			b5_4.setContentAreaFilled(false);
			b5_4.setEnabled(false);
			b5_4.setActionCommand("5_4");
			b5_4.setBounds(134, 210, 14, 23);
		}
		return b5_4;
	}
	private JButton getB5_5() {
		if (b5_5 == null) {
			b5_5 = new JButton("");
			b5_5.setContentAreaFilled(false);
			b5_5.setEnabled(false);
			b5_5.setActionCommand("5_5");
			b5_5.setBounds(158, 210, 14, 23);
		}
		return b5_5;
	}
	private JButton getB2_5() {
		if (b2_5 == null) {
			b2_5 = new JButton("");
			b2_5.setContentAreaFilled(false);
			b2_5.setEnabled(false);
			b2_5.setActionCommand("2_5");
			b2_5.setBounds(272, 210, 14, 23);
		}
		return b2_5;
	}
	private JButton getB2_4() {
		if (b2_4 == null) {
			b2_4 = new JButton("");
			b2_4.setContentAreaFilled(false);
			b2_4.setEnabled(false);
			b2_4.setActionCommand("2_4");
			b2_4.setBounds(296, 210, 14, 23);
		}
		return b2_4;
	}
	private JButton getB2_3() {
		if (b2_3 == null) {
			b2_3 = new JButton("");
			b2_3.setContentAreaFilled(false);
			b2_3.setEnabled(false);
			b2_3.setActionCommand("2_3");
			b2_3.setBounds(334, 210, 14, 23);
		}
		return b2_3;
	}
	private JButton getB2_2() {
		if (b2_2 == null) {
			b2_2 = new JButton("");
			b2_2.setContentAreaFilled(false);
			b2_2.setEnabled(false);
			b2_2.setActionCommand("2_2");
			b2_2.setBounds(358, 210, 14, 23);
		}
		return b2_2;
	}
	private JButton getB2_1() {
		if (b2_1 == null) {
			b2_1 = new JButton("");
			b2_1.setContentAreaFilled(false);
			b2_1.setEnabled(false);
			b2_1.setActionCommand("2_1");
			b2_1.setBounds(391, 210, 14, 23);
		}
		return b2_1;
	}
	private JButton getB6_5() {
		if (b6_5 == null) {
			b6_5 = new JButton("");
			b6_5.setContentAreaFilled(false);
			b6_5.setEnabled(false);
			b6_5.setActionCommand("6_5");
			b6_5.setBounds(190, 167, 14, 23);
		}
		return b6_5;
	}
	private JButton getB6_4() {
		if (b6_4 == null) {
			b6_4 = new JButton("");
			b6_4.setContentAreaFilled(false);
			b6_4.setEnabled(false);
			b6_4.setActionCommand("6_4");
			b6_4.setBounds(176, 140, 14, 23);
		}
		return b6_4;
	}
	private JButton getB6_3() {
		if (b6_3 == null) {
			b6_3 = new JButton("");
			b6_3.setContentAreaFilled(false);
			b6_3.setEnabled(false);
			b6_3.setActionCommand("6_3");
			b6_3.setBounds(152, 118, 14, 23);
		}
		return b6_3;
	}
	private JButton getB6_2() {
		if (b6_2 == null) {
			b6_2 = new JButton("");
			b6_2.setContentAreaFilled(false);
			b6_2.setEnabled(false);
			b6_2.setActionCommand("6_2");
			b6_2.setBounds(152, 84, 14, 23);
		}
		return b6_2;
	}
	private JButton getB6_1() {
		if (b6_1 == null) {
			b6_1 = new JButton("");
			b6_1.setContentAreaFilled(false);
			b6_1.setEnabled(false);
			b6_1.setActionCommand("6_1");
			b6_1.setBounds(134, 58, 14, 23);
		}
		return b6_1;
	}
	private JButton getB3_5() {
		if (b3_5 == null) {
			b3_5 = new JButton("");
			b3_5.setContentAreaFilled(false);
			b3_5.setEnabled(false);
			b3_5.setActionCommand("3_5");
			b3_5.setBounds(246, 252, 14, 23);
		}
		return b3_5;
	}
	private JButton getB3_4() {
		if (b3_4 == null) {
			b3_4 = new JButton("");
			b3_4.setContentAreaFilled(false);
			b3_4.setEnabled(false);
			b3_4.setActionCommand("3_4");
			b3_4.setBounds(259, 282, 14, 23);
		}
		return b3_4;
	}
	private JButton getB3_3() {
		if (b3_3 == null) {
			b3_3 = new JButton("");
			b3_3.setContentAreaFilled(false);
			b3_3.setEnabled(false);
			b3_3.setActionCommand("3_3");
			b3_3.setBounds(283, 304, 14, 23);
		}
		return b3_3;
	}
	private JButton getB3_2() {
		if (b3_2 == null) {
			b3_2 = new JButton("");
			b3_2.setContentAreaFilled(false);
			b3_2.setEnabled(false);
			b3_2.setActionCommand("3_2");
			b3_2.setBounds(283, 327, 14, 23);
		}
		return b3_2;
	}
	private JButton getB3_1() {
		if (b3_1 == null) {
			b3_1 = new JButton("");
			b3_1.setContentAreaFilled(false);
			b3_1.setEnabled(false);
			b3_1.setActionCommand("3_1");
			b3_1.setBounds(307, 364, 14, 23);
		}
		return b3_1;
	}
	private JButton getB4_1() {
		if (b4_1 == null) {
			b4_1 = new JButton("");
			b4_1.setContentAreaFilled(false);
			b4_1.setEnabled(false);
			b4_1.setActionCommand("4_1");
			b4_1.setBounds(134, 364, 14, 23);
		}
		return b4_1;
	}
	private JButton getB4_2() {
		if (b4_2 == null) {
			b4_2 = new JButton("");
			b4_2.setContentAreaFilled(false);
			b4_2.setEnabled(false);
			b4_2.setActionCommand("4_2");
			b4_2.setBounds(152, 327, 14, 23);
		}
		return b4_2;
	}
	private JButton getB4_3() {
		if (b4_3 == null) {
			b4_3 = new JButton("");
			b4_3.setContentAreaFilled(false);
			b4_3.setEnabled(false);
			b4_3.setActionCommand("4_3");
			b4_3.setBounds(158, 304, 14, 23);
		}
		return b4_3;
	}
	private JButton getB4_4() {
		if (b4_4 == null) {
			b4_4 = new JButton("");
			b4_4.setContentAreaFilled(false);
			b4_4.setEnabled(false);
			b4_4.setActionCommand("4_4");
			b4_4.setBounds(176, 282, 14, 23);
		}
		return b4_4;
	}
	private JButton getB4_5() {
		if (b4_5 == null) {
			b4_5 = new JButton("");
			b4_5.setContentAreaFilled(false);
			b4_5.setEnabled(false);
			b4_5.setActionCommand("4_5");
			b4_5.setBounds(190, 250, 14, 23);
		}
		return b4_5;
	}
	private JButton getB1_5() {
		if (b1_5 == null) {
			b1_5 = new JButton("");
			b1_5.setContentAreaFilled(false);
			b1_5.setEnabled(false);
			b1_5.setActionCommand("1_5");
			b1_5.setBounds(246, 167, 14, 23);
		}
		return b1_5;
	}
	private JButton getB1_4() {
		if (b1_4 == null) {
			b1_4 = new JButton("");
			b1_4.setContentAreaFilled(false);
			b1_4.setEnabled(false);
			b1_4.setActionCommand("1_4");
			b1_4.setOpaque(false);
			b1_4.setIcon(null);
			b1_4.setBounds(259, 140, 14, 23);
		}
		return b1_4;
	}
	private JButton getB1_3() {
		if (b1_3 == null) {
			b1_3 = new JButton("");
			b1_3.setContentAreaFilled(false);
			b1_3.setEnabled(false);
			b1_3.setActionCommand("1_3");
			b1_3.setOpaque(false);
			b1_3.setIcon(null);
			b1_3.setBounds(283, 118, 14, 23);
		}
		return b1_3;
	}
	private JButton getB1_2() {
		if (b1_2 == null) {
			b1_2 = new JButton("");
			b1_2.setContentAreaFilled(false);
			b1_2.setEnabled(false);
			b1_2.setActionCommand("1_2");
			b1_2.setOpaque(false);
			b1_2.setIcon(null);
			b1_2.setBounds(283, 84, 14, 23);
		}
		return b1_2;
	}
	private JButton getB1_1() {
		if (b1_1 == null) {
			b1_1 = new JButton("");
			b1_1.setContentAreaFilled(false);
			b1_1.setEnabled(false);
			b1_1.setActionCommand("1_1");
			b1_1.setOpaque(false);
			b1_1.setIcon(null);
			b1_1.setBounds(296, 58, 14, 23);
		}
		return b1_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
			btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("New button");
			btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		}
		return btnNewButton_3;
	}
	
	
}
