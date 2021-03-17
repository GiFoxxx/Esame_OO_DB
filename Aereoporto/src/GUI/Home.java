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
	private JLabel lblGate;
	private JLabel lblVolo;

	// GETTER E SETTER
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
					controllerHome.mostraNotifica(controllerHome.erroreGeneraleHome, img.messaggioErrore());
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblTratte.setIcon(new ImageIcon(img.tratte2()));
			}
		});
		lblTratte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTratte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratte.setIcon(new ImageIcon(img.tratte1()));
		lblTratte.setBounds(179, 102, 276, 162);
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
					controllerHome.mostraNotifica(controllerHome.erroreGeneraleHome, img.messaggioErrore());
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
			}
		});
		lblCompagniaAerea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCompagniaAerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompagniaAerea.setIcon(new ImageIcon(img.compagnieAeree1()));
		lblCompagniaAerea.setBounds(634, 102, 276, 162);
		add(lblCompagniaAerea);

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
					controllerHome.mostraSceltaGate();
				} else {
					controllerHome.mostraNotifica(controllerHome.erroreGeneraleHome, img.messaggioErrore());
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblGate.setIcon(new ImageIcon(img.gate1()));
			}
		});
		lblGate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGate.setIcon(new ImageIcon(img.gate1()));
		lblGate.setBounds(634, 371, 276, 162);
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
					controllerHome.mostraNotifica(controllerHome.erroreGeneraleHome, img.messaggioErrore());
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblVolo.setIcon(new ImageIcon(img.voli1()));
			}
		});
		lblVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolo.setIcon(new ImageIcon(img.voli1()));
		lblVolo.setBounds(179, 371, 276, 162);
		add(lblVolo);

		
	}

	
}
