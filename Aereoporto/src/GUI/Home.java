package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Home extends JPanel {
	
	private Image volo1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/volo1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image volo2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/volo2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gate1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gate1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gate2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gate2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image prenotazioni1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/prenotazioni1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image prenotazioni2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/prenotazioni2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image tratte1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/tratte1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image tratte2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/tratte2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gestioneAccount1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gestioneAccount1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image gestioneAccount2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/gestioneAccount2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image uscita1 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/uscita1.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	private Image uscita2 = new ImageIcon(Accesso.class.getResource("immaginiDashboard/uscita2.png")).getImage().getScaledInstance(272, 152, Image.SCALE_SMOOTH);
	
	
	private JPanel contentPane;
	
	Controller controllerHome;
	
	public Home(Controller controller) {
		controllerHome = controller;

		
		setBounds(100, 100, 904, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblTratte = new JLabel("");
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(tratte1));
		lblTratte.setBounds(46, 270, 272, 148);
		contentPane.add(lblTratte);
		
		JLabel lblUscita = new JLabel("");
		lblUscita.setHorizontalAlignment(SwingConstants.CENTER);
		lblUscita.setIcon(new ImageIcon(uscita1));
		lblUscita.setBounds(313, 111, 272, 148);
		contentPane.add(lblUscita);
		
		JLabel lblGestioneAccount = new JLabel("");
		lblGestioneAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneAccount.setIcon(new ImageIcon(gestioneAccount1));
		lblGestioneAccount.setBounds(585, 270, 272, 148);
		contentPane.add(lblGestioneAccount);
		
		JLabel lblPrenotazioni = new JLabel("");
		lblPrenotazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenotazioni.setIcon(new ImageIcon(prenotazioni1));
		lblPrenotazioni.setBounds(313, 270, 272, 148);
		contentPane.add(lblPrenotazioni);
		
		JLabel lblGate = new JLabel("");
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(gate1));
		lblGate.setBounds(575, 111, 272, 148);
		contentPane.add(lblGate);
		
		JLabel lblVolo = new JLabel("");
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(volo1));
		lblVolo.setBounds(46, 111, 272, 148);
		contentPane.add(lblVolo);
		
	}
}		
		
		
	