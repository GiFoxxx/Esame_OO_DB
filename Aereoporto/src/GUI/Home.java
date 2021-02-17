package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JPanel {

	private Immagini img = new Immagini();

	private JLabel lblTratte;
	private JLabel lblCompagniaAerea;
	private JLabel lblGestioneUtenti;
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

	public JLabel getLblGestioneUtenti() {
		return lblGestioneUtenti;
	}

	public void setLblGestioneUtenti(JLabel lblGestioneAccount) {
		this.lblGestioneUtenti = lblGestioneAccount;
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

		setBounds(0, 0, 1090, 642);
		setBackground(controllerHome.sfondoTemaScuro);
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
					controllerHome.setPannelloPrecedente(6);
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneTratte());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione delle tratte, accedere al proprio account.");
				}
			}
		});
		lblTratte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(img.tratte1()));
		lblTratte.setBounds(82, 110, 282, 167);
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
					controllerHome.setPannelloPrecedente(7);
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneCompagnieAeree());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione delle compagnie aeree, accedere al proprio account.");
				}
			}
		});
		lblCompagniaAerea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCompagniaAerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
		lblCompagniaAerea.setBounds(399, 110, 282, 167);
		add(lblCompagniaAerea);

		lblGestioneUtenti = new JLabel("");
		lblGestioneUtenti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblGestioneUtenti.setIcon(new ImageIcon(img.gestioneAccount2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblGestioneUtenti.setIcon(new ImageIcon(img.gestioneAccount1()));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerHome.sbloccaGestione()) {
					controllerHome.setPannelloPrecedente(8);
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneUtenti());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione degli account, accedere al proprio account.");
				}
			}
		});
		lblGestioneUtenti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestioneUtenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneUtenti.setIcon(new ImageIcon(img.gestioneAccount1()));
		lblGestioneUtenti.setBounds(708, 110, 282, 167);
		add(lblGestioneUtenti);

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

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerHome.setPannelloPrecedente(9);
			}
		});
		lblPrenotazioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					controllerHome.setPannelloPrecedente(10);
					controllerHome.mostraPannelli(controllerHome.getDashboard().getGestioneGate());
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione dei gate, accedere al proprio account.");
				}
			}
		});
		lblGate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
					controllerHome.mostraSceltaVolo();
				} else {
					lblFareAccesso.setText("Per poter accedere alla gestione dei voli devi prima accedere al tuo account.");
				}
			}
		});
		lblVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(img.voli1()));
		lblVolo.setBounds(399, 320, 282, 167);
		add(lblVolo);

		lblFareAccesso = new JLabel("");
		lblFareAccesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFareAccesso.setFont(controllerHome.fontScritte);
		lblFareAccesso.setForeground(controllerHome.coloreScritturaAllertaTemaScuro);
		lblFareAccesso.setBounds(80, 522, 867, 28);
		add(lblFareAccesso);
	}

}
