package GUI;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class Avvio extends JFrame {

//	private Image imgsfondoAvvio = new ImageIcon(Avvio.class.getResource("immaginiAvvio/imgsfondoAvvio.jpg")).getImage().getScaledInstance(1200, 735, Image.SCALE_SMOOTH);

	private JPanel contentPane;

	Controller controllerAvvio;

	public Avvio(Controller controller) {
		controllerAvvio = controller;

		setResizable(true);
		setTitle("Avvio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true); // togliamo l'interfaccia prefedefinita di java
		JButton btnAccesso = new JButton("Accedi");
		btnAccesso.setBounds(418, 286, 119, 47);
		btnAccesso.setBackground(new Color(51, 102, 153));
		btnAccesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerAvvio.Accesso();
			}
		});
		contentPane.setLayout(null);

		btnAccesso.setForeground(Color.BLACK);
		btnAccesso.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(btnAccesso);

		JButton btnUscita = new JButton("Esci");
		btnUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "SI", "ANNULLA" };
				if (JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire dal progrmamma?", "ATTENZIONE!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
					Avvio.this.dispose();
				}
			}

		});
		btnUscita.setBounds(418, 413, 119, 47);
		btnUscita.setBackground(Color.DARK_GRAY);

		btnUscita.setForeground(Color.WHITE);
		btnUscita.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(btnUscita);
		JButton btnRegistrazione = new JButton("Registrati");
		btnRegistrazione.setBounds(418, 344, 119, 47);
		btnRegistrazione.setBackground(Color.DARK_GRAY);
		btnRegistrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Registrazione();
			}
		});
		btnRegistrazione.setForeground(Color.WHITE);
		btnRegistrazione.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(btnRegistrazione);

		JButton btnRiconoscimenti = new JButton("Riconoscimenti");
		btnRiconoscimenti.setBounds(853, 555, 137, 34);
		btnRiconoscimenti.setBackground(Color.DARK_GRAY);
		btnRiconoscimenti.setForeground(Color.WHITE);
		btnRiconoscimenti.setFont(new Font("Calibri", Font.BOLD, 14));
		contentPane.add(btnRiconoscimenti);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override // sulla x per chiudere il programma passo sopra e metto il rosso
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}

			@Override // dalla x per chiudere il programma tolgo da sopra e rimetto il bianco
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}

			@Override // clicco sulla X e chiudo il programma
			public void mouseClicked(MouseEvent e) {
				Avvio.this.dispose();
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(976, 0, 24, 23);
		contentPane.add(lblX);

	}
}
