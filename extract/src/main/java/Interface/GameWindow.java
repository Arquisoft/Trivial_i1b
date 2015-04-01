package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;


public class GameWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lbTitle;
	private JPanel panel;
	private JButton btnPulsarDado;
	private JLabel lblTurnoDelJugador;
	private JTextField textField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameWindow.class.getResource("/imagenes/icono.png")));
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
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("");
			lbTitle.setIcon(new ImageIcon(GameWindow.class.getResource("/imagenes/tituloSmall.png")));
			lbTitle.setBounds(68, 28, 678, 114);
		}
		return lbTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(79, 195, 640, 505);
			panel.setLayout(null);
		}
		return panel;
	}
	private JButton getBtnPulsarDado() {
		if (btnPulsarDado == null) {
			btnPulsarDado = new JButton("Pulsar dado");
			btnPulsarDado.setBounds(810, 90, 89, 23);
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
	}------------
}
