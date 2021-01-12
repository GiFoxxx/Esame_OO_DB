package GUI;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;

public class Launcher extends JFrame {

	private JPanel contentPane;

	private Image imgsfondoLauncher = new ImageIcon(Avvio.class.getResource("immaginiLauncher/imgsfondoLauncher.jpg")).getImage().getScaledInstance(1200, 735, Image.SCALE_SMOOTH);

	Controller controllerLauncher;
	
	int mouseX;
	int mouseY;
	

	
	
	public Launcher(Controller controller) {
	
		controllerLauncher = controller;
		
	
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		JButton btnAvvia = new JButton("AVVIA");
		btnAvvia.setBackground(new Color(139, 69, 19));
		btnAvvia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerLauncher.Avvio();
			}
		});
		
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
						Launcher.this.dispose();
					}
				});
				
				lblX.setForeground(Color.WHITE);
				lblX.setFont(new Font("Arial", Font.BOLD, 15));
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.setBounds(1176, 0, 24, 23);
				contentPane.add(lblX);
		btnAvvia.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnAvvia.setFont(new Font("Arial", Font.BOLD, 15));
		btnAvvia.setBounds(463, 567, 258, 82);
		contentPane.add(btnAvvia);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setForeground(new Color(128, 128, 128));
		separator.setToolTipText("");
		separator.setBounds(261, 70, 659, 7);
		contentPane.add(separator);

		JLabel lblTitolo = new JLabel("AMMINISTRAZIONE AEREOPORTO");
		lblTitolo.setBackground(Color.BLACK);
		lblTitolo.setEnabled(false);
		lblTitolo.setForeground(Color.DARK_GRAY);
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitolo.setBounds(0, 0, 1184, 93);
		contentPane.add(lblTitolo);

		JLabel lblimgsfondoLauncher = new JLabel("");
	
		lblimgsfondoLauncher.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgsfondoLauncher.setIcon(new ImageIcon(imgsfondoLauncher));
		lblimgsfondoLauncher.setBounds(0, 0, 1200, 735);
		contentPane.add(lblimgsfondoLauncher);
	}
}
