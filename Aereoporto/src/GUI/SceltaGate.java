package GUI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class SceltaGate extends JDialog {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	JLabel lblSpostaSceltaVolo;
	JLabel lblX;
	JLabel lblCodeDiImbarco;
	JLabel lblGate;
	JLabel lblScelta;
	JLabel lblAnnulla;
	JLabel lblTempisticheGate;

	// GETTER E SETTER

	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}

	public JLabel getLblSpostaSceltaVolo() {
		return lblSpostaSceltaVolo;
	}

	public void setLblSpostaSceltaVolo(JLabel lblSpostaUscita) {
		this.lblSpostaSceltaVolo = lblSpostaUscita;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblArrivi() {
		return lblCodeDiImbarco;
	}

	public void setLblArrivi(JLabel lblArrivi) {
		this.lblCodeDiImbarco = lblArrivi;
	}

	public JLabel getLblPartenze() {
		return lblGate;
	}

	public void setLblPartenze(JLabel lblPartenze) {
		this.lblGate = lblPartenze;
	}

	public JLabel getLblScelta() {
		return lblScelta;
	}

	public void setLblScelta(JLabel lblScelta) {
		this.lblScelta = lblScelta;
	}

	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblCodeDiImbarco() {
		return lblCodeDiImbarco;
	}

	public void setLblCodeDiImbarco(JLabel lblCodeDiImbarco) {
		this.lblCodeDiImbarco = lblCodeDiImbarco;
	}

	public JLabel getLblGate() {
		return lblGate;
	}

	public void setLblGate(JLabel lblGate) {
		this.lblGate = lblGate;
	}

	public JLabel getLblTempisticheGate() {
		return lblTempisticheGate;
	}

	public void setLblTempisticheGate(JLabel lblTempisticheGate) {
		this.lblTempisticheGate = lblTempisticheGate;
	}

	Immagini img = new Immagini();
	Controller controllerSceltaGate;

	public SceltaGate(Controller controller) {
		controllerSceltaGate = controller;

		setModal(true);

		setBounds(100, 100, 500, 300);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(null);
		{
			lblAnnulla = new JLabel("");
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaGate.annullaSceltaGate();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblAnnulla, img.annulla2TemaChiaro(), img.annulla2());

				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblAnnulla, img.annulla1TemaChiaro(), img.annulla1());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblAnnulla, img.annulla3TemaChiaro(), img.annulla3());

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblAnnulla, img.annulla2TemaChiaro(), img.annulla2());

				}
			});
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(92, 245, 319, 36);
			getContentPane().add(lblAnnulla);

			lblGate = new JLabel("");
			lblGate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaGate.vaiAGateDaSceltaGate();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblGate, img.gateScelta2TemaChiaro(), img.gateScelta2());

				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblGate, img.gateScelta1TemaChiaro(), img.gateScelta1());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblGate, img.gateScelta3TemaChiaro(), img.gateScelta3());

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblGate, img.gateScelta2TemaChiaro(), img.gateScelta2());

				}
			});
			lblGate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblGate.setHorizontalAlignment(SwingConstants.CENTER);
			lblGate.setIcon(new ImageIcon(img.gateScelta1()));
			lblGate.setBounds(92, 103, 319, 36);
			getContentPane().add(lblGate);

			lblCodeDiImbarco = new JLabel("");
			lblCodeDiImbarco.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaGate.vaiAGateCodeImbarcoDaSceltaVolo();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblCodeDiImbarco, img.codeDiImbarco2TemaChiaro(), img.codeDiImbarco2());

				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblCodeDiImbarco, img.codeDiImbarco1TemaChiaro(), img.codeDiImbarco1());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblCodeDiImbarco, img.codeDiImbarco3TemaChiaro(), img.codeDiImbarco3());

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblCodeDiImbarco, img.codeDiImbarco2TemaChiaro(), img.codeDiImbarco2());

				}
			});
			lblCodeDiImbarco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblCodeDiImbarco.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodeDiImbarco.setIcon(new ImageIcon(img.codeDiImbarco1()));
			lblCodeDiImbarco.setBounds(92, 198, 319, 36);
			getContentPane().add(lblCodeDiImbarco);
			
			lblTempisticheGate = new JLabel("");
			lblTempisticheGate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaGate.vaiATempisticheGateDaSceltaVolo();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblTempisticheGate, img.utilizzoGate2TemaChiaro(), img.utilizzoGate2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblTempisticheGate, img.utilizzoGate1TemaChiaro(), img.utilizzoGate1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblTempisticheGate, img.utilizzoGate3TemaChiaro(), img.utilizzoGate3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblTempisticheGate, img.utilizzoGate2TemaChiaro(), img.utilizzoGate2());
				}
			});
			lblTempisticheGate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblTempisticheGate.setHorizontalAlignment(SwingConstants.CENTER);
			lblTempisticheGate.setIcon(new ImageIcon(img.utilizzoGate1()));
			lblTempisticheGate.setBounds(92, 150, 319, 36);
			getContentPane().add(lblTempisticheGate);
			
			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaGate.annullaSceltaGate();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblX, img.X2TemaChiaro(), img.X2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblX, img.X3TemaChiaro(), img.X3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaGate.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}

				
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(448, 1, 51, 34);
			getContentPane().add(lblX);

			lblSpostaSceltaVolo = new JLabel("");
			lblSpostaSceltaVolo.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaSceltaVolo.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaSceltaVolo.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);
				}
			});
			lblSpostaSceltaVolo.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();
				}
			});
			lblSpostaSceltaVolo.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaSceltaVolo);

			{
				lblScelta = new JLabel("Cosa vuoi gestire?");
				lblScelta.setHorizontalAlignment(SwingConstants.CENTER);
				lblScelta.setFont(controllerSceltaGate.fontScritteJDialog);
				lblScelta.setForeground(controllerSceltaGate.coloreScritteTemaScuro);
				lblScelta.setBounds(2, 55, 498, 37);
				getContentPane().add(lblScelta);
			}

		}

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);
		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerSceltaGate.centramentoJDialog(this);
	}
}