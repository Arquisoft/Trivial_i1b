
package gui;
import java.awt.Color;
import java.awt.EventQueue;
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
	private JTextField txEmail;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JButton btnOk ;
	private JButton btnNewUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow frame = new GameWindow();
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
	public GameWindow() {
		setTitle("Trivial - Software Architecture");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/Images/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTitle());
		contentPane.add(getPanel());
		contentPane.add(getBtnPulsarDado());
		contentPane.add(getLblTurnoDelJugador());
		contentPane.add(getTextField());
		contentPane.add(getTxDado());
		contentPane.add(getLabel());
		
		contentPane.add(getBtnAddPlayer());
		contentPane.add(getTxPassword());
		contentPane.add(getTxEmail());
		contentPane.add(getLblEmail());
		contentPane.add(getLblPassword());
		
		
		btnOk = new JButton("OK");
		btnOk.setVisible(false);
		
		btnOk.setBounds(978, 370, 89, 23);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(SystemColor.activeCaption);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txEmail.getText().equals("")|| txPassword.getText().equals("")){

					JOptionPane.showMessageDialog(null, "You must fill all the information to add the player");			
					
				}
				else{
				JOptionPane.showMessageDialog(null, "New user: "+txEmail.getText().toUpperCase()+" added to the game");	}		
				}
		});
		contentPane.add(btnOk);
		
		btnNewUser = new JButton("New user");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserWindow newu = new NewUserWindow();
				newu.setVisible(true);
			}
		});
		btnNewUser.setVisible(false);
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewUser.setBackground(SystemColor.activeCaption);
		btnNewUser.setForeground(Color.WHITE);
		btnNewUser.setBounds(1046, 367, 89, 23);
		contentPane.add(btnNewUser);
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("");
			lbTitle.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/tituloSmall.png")));
			lbTitle.setBounds(68, 28, 678, 114);
		}
		return lbTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(SystemColor.desktop);
			panel.setBounds(79, 195, 760, 505);
			panel.setLayout(null);
			
			JButton btAmarillo1 = new JButton("New button");
			btAmarillo1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaAmarillo.png")));
			btAmarillo1.setBounds(211, 60, 59, 34);
			panel.add(btAmarillo1);
			
			JButton btAzul1 = new JButton("New button");
			btAzul1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaAzul.png")));
			btAzul1.setBounds(270, 60, 59, 34);
			panel.add(btAzul1);
			
			JButton btMarron1 = new JButton("New button");
			btMarron1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaMarron.png")));
			btMarron1.setBounds(327, 60, 59, 34);
			panel.add(btMarron1);
			
			JButton btNaranja1 = new JButton("New button");
			btNaranja1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaNaranja.png")));
			btNaranja1.setBounds(383, 60, 59, 34);
			panel.add(btNaranja1);
			
			JButton btRosa1 = new JButton("New button");
			btRosa1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaRosa.png")));
			btRosa1.setBounds(440, 60, 59, 34);
			panel.add(btRosa1);
			
			JButton btVerde1 = new JButton("New button");
			btVerde1.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaVerde.png")));
			btVerde1.setBounds(497, 60, 59, 34);
			panel.add(btVerde1);
			
			JButton btVerde4 = new JButton("New button");
			btVerde4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaVerde.png")));
			btVerde4.setBounds(211, 406, 59, 34);
			panel.add(btVerde4);
			
			JButton btRosa4 = new JButton("New button");
			btRosa4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaRosa.png")));
			btRosa4.setBounds(270, 406, 59, 34);
			panel.add(btRosa4);
			
			JButton btNaranja4 = new JButton("New button");
			btNaranja4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaNaranja.png")));
			btNaranja4.setBounds(327, 406, 59, 34);
			panel.add(btNaranja4);
			
			JButton btMarron4 = new JButton("New button");
			btMarron4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaMarron.png")));
			btMarron4.setBounds(383, 406, 59, 34);
			panel.add(btMarron4);
			
			JButton btAzul4 = new JButton("New button");
			btAzul4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaAzul.png")));
			btAzul4.setBounds(440, 406, 59, 34);
			panel.add(btAzul4);
			
			JButton btAmarillo4 = new JButton("New button");
			btAmarillo4.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/casillaAmarillo.png")));
			btAmarillo4.setBounds(497, 406, 59, 34);
			panel.add(btAmarillo4);
		}
		return panel;
	}
	private JButton getBtnPulsarDado() {
		if (btnPulsarDado == null) {
			btnPulsarDado = new JButton("");
			btnPulsarDado.setContentAreaFilled(false);
			btnPulsarDado.setBorderPainted(false);
			btnPulsarDado.setOpaque(false);
			btnPulsarDado.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/Dado.png")));
			btnPulsarDado.setBounds(818, 107, 137, 85);
		}
		return btnPulsarDado;
	}
	private JLabel getLblTurnoDelJugador() {
		if (lblTurnoDelJugador == null) {
			lblTurnoDelJugador = new JLabel("Turno del jugador :");
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
			label.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/tablero.jpg")));
			label.setBounds(0, 0, 500, 473);
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
					txEmail.setVisible(true);
					lblEmail.setVisible(true);
					lblPassword.setVisible(true);
					btnOk.setVisible(true);
					btnNewUser.setVisible(true);
				}
			});
			btnAddPlayer.setBounds(949, 243, 160, 23);
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
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setVisible(false);
			txEmail.setBounds(934, 296, 288, 20);
			txEmail.setColumns(10);
		}
		return txEmail;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setVisible(false);
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
			lblEmail.setBounds(812, 299, 112, 14);
		}
		return lblEmail;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setVisible(false);
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 13));
			lblPassword.setBounds(802, 330, 122, 14);
		}
		return lblPassword;
	}
}

