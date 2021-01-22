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
	
	Controller controllerHome;
	
	public Home(Controller controller) {
		controllerHome = controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(new Color(54,57,63));
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
				
			}
		});
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(tratte1));
		lblTratte.setBounds(41, 94, 272, 152);
		add(lblTratte);
		
		JLabel lblUscita = new JLabel("");
		lblUscita.setHorizontalAlignment(SwingConstants.CENTER);
		lblUscita.setIcon(new ImageIcon(uscita1));
		lblUscita.setBounds(318, 94, 272, 152);
		add(lblUscita);
		
		JLabel lblGestioneAccount = new JLabel("");
		lblGestioneAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneAccount.setIcon(new ImageIcon(gestioneAccount1));
		lblGestioneAccount.setBounds(595, 94, 272, 152);
		add(lblGestioneAccount);
		
		JLabel lblPrenotazioni = new JLabel("");
		lblPrenotazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenotazioni.setIcon(new ImageIcon(prenotazioni1));
		lblPrenotazioni.setBounds(41, 251, 272, 152);
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
				controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneGate1());
			}
		});
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(gate1));
		lblGate.setBounds(318, 251, 272, 152);
		add(lblGate);
		
		JLabel lblVolo = new JLabel("");
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(volo1));
		lblVolo.setBounds(595, 251, 272, 152);
		add(lblVolo);
	}

}
