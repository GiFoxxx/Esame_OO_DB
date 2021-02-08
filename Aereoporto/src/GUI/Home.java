package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JPanel {

	private Immagini img = new Immagini();

	private JLabel lblTratte;
	private JLabel lblCompagniaAerea;
	private JLabel lblGestioneAccount;
	private JLabel lblPrenotazioni;
	private JLabel lblGate;
	private JLabel lblVolo;
	private JLabel lblFareAccesso;

	// GETTER E SETTER

	public JLabel getLblFareAccesso() {
		return lblFareAccesso;
	}

	public void setLblFareAccesso(JLabel lblFareAccesso) {
		this.lblFareAccesso = lblFareAccesso;
	}
	
	public JLabel getLblTratte() {
		return lblTratte;
	}

	public void setLblTratte(JLabel lblTratte) {
		this.lblTratte = lblTratte;
	}

	public JLabel getLblCompagniaAerea() {
		return lblCompagniaAerea;
	}

	public void setLblCompagniaAerea(JLabel lblCompagniaAerea) {
		this.lblCompagniaAerea = lblCompagniaAerea;
	}

	public JLabel getLblGestioneAccount() {
		return lblGestioneAccount;
	}

	public void setLblGestioneAccount(JLabel lblGestioneAccount) {
		this.lblGestioneAccount = lblGestioneAccount;
	}

	public JLabel getLblPrenotazioni() {
		return lblPrenotazioni;
	}

	public void setLblPrenotazioni(JLabel lblPrenotazioni) {
		this.lblPrenotazioni = lblPrenotazioni;
	}

	public JLabel getLblGate() {
		return lblGate;
	}

	public void setLblGate(JLabel lblGate) {
		this.lblGate = lblGate;
	}

	public JLabel getLblVolo() {
		return lblVolo;
	}

	public void setLblVolo(JLabel lblVolo) {
		this.lblVolo = lblVolo;
	}

	Controller controllerHome;

	public Home(Controller controller) {
		controllerHome = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerHome.sfondo);
		setLayout(null);

		lblTratte = new JLabel("");
		lblTratte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneTratte());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione delle tratte, accedere al proprio account.");
				}
			}
		});
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(img.tratte1()));
		lblTratte.setBounds(82, 110, 276, 162);
		add(lblTratte);

		lblCompagniaAerea = new JLabel("");
		lblCompagniaAerea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneCompagnieAeree());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione delle compagnie aeree, accedere al proprio account.");
				}
			}
		});
		lblCompagniaAerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
		lblCompagniaAerea.setBounds(399, 110, 282, 167);
		add(lblCompagniaAerea);

		lblGestioneAccount = new JLabel("");
		lblGestioneAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneUtenti());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione degli account, accedere al proprio account.");
				}
			}
		});
		lblGestioneAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneAccount.setIcon(new ImageIcon(img.gestioneAccount1()));
		lblGestioneAccount.setBounds(708, 110, 282, 167);
		add(lblGestioneAccount);

		lblPrenotazioni = new JLabel("");
		lblPrenotazioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni1()));
			}
		});
		lblPrenotazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenotazioni.setIcon(new ImageIcon(img.prenotazioni1()));
		lblPrenotazioni.setBounds(76, 320, 282, 167);
		add(lblPrenotazioni);

		lblGate = new JLabel("");
		lblGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneGate());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione dei gate, accedere al proprio account.");
				}
			}
		});
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(img.gate1()));
		lblGate.setBounds(708, 320, 282, 167);
		add(lblGate);

		lblVolo = new JLabel("");
		lblVolo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneVoli());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione dei voli devi prima accedere al tuo account.");
				}
			}
		});
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(img.voli1()));
		lblVolo.setBounds(399, 320, 282, 167);
		add(lblVolo);

		lblFareAccesso = new JLabel("");
		lblFareAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFareAccesso.setFont(controllerHome.fontScritte);
		lblFareAccesso.setForeground(controllerHome.coloreScritturaAllerta);
		lblFareAccesso.setBounds(80, 522, 867, 28);
		add(lblFareAccesso);
	}

}
