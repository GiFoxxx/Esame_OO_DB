package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Home extends JPanel {

	private Image voli1 = new ImageIcon(Accesso.class.getResource("immaginiHome/voli1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image voli2 = new ImageIcon(Accesso.class.getResource("immaginiHome/voli2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
	private Image gate1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image gate2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gate2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
	private Image prenotazioni1 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image prenotazioni2 = new ImageIcon(Accesso.class.getResource("immaginiHome/prenotazioni2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
	private Image tratte1 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image tratte2 = new ImageIcon(Accesso.class.getResource("immaginiHome/tratte2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
	private Image compagnieAeree1 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image compagnieAeree2 = new ImageIcon(Accesso.class.getResource("immaginiHome/compagnieAeree2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);
	private Image gestioneAccount1 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount1.png")).getImage().getScaledInstance(272, 157, Image.SCALE_SMOOTH);
	private Image gestioneAccount2 = new ImageIcon(Accesso.class.getResource("immaginiHome/gestioneAccount2.png")).getImage().getScaledInstance(276, 162, Image.SCALE_SMOOTH);

	Controller controllerHome;
	
	public Home(Controller controller) {
		controllerHome = controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(new Color(255,255,255));
		setLayout(null);
		
		JLabel lblTratte = new JLabel("");
		lblTratte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(tratte2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(tratte1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneTratte());
			}
		});
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(tratte1));
		lblTratte.setBounds(20, 110, 276, 162);
		add(lblTratte);
		
		JLabel lblUscita = new JLabel("");
		lblUscita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblUscita.setIcon(new ImageIcon(compagnieAeree2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblUscita.setIcon(new ImageIcon(compagnieAeree1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneCompagnieAeree());
			}
		});
		lblUscita.setHorizontalAlignment(SwingConstants.CENTER);
		lblUscita.setIcon(new ImageIcon(compagnieAeree1));
		lblUscita.setBounds(312, 110, 276, 162);
		add(lblUscita);
		
		JLabel lblGestioneAccount = new JLabel("");
		lblGestioneAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(gestioneAccount2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(gestioneAccount1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneUtenti());
			}
		});
		lblGestioneAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneAccount.setIcon(new ImageIcon(gestioneAccount1));
		lblGestioneAccount.setBounds(605, 110, 276, 162);
		add(lblGestioneAccount);
		
		JLabel lblPrenotazioni = new JLabel("");
		lblPrenotazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(prenotazioni2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(prenotazioni1));
			}
		});
		lblPrenotazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenotazioni.setIcon(new ImageIcon(prenotazioni1));
		lblPrenotazioni.setBounds(20, 320, 276, 162);
		add(lblPrenotazioni);
		
		JLabel lblGate = new JLabel("");
		lblGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(gate2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(gate1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneGate());
			}
		});
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(gate1));
		lblGate.setBounds(605, 320, 276, 162);
		add(lblGate);
		
		JLabel lblVolo = new JLabel("");
		lblVolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(voli2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(voli1));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneVoli());
			}
		});
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(voli1));
		lblVolo.setBounds(312, 320, 276, 162);
		add(lblVolo);
	}
}
