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

public class SceltaProfiloSenzaAccesso extends JDialog {
	Immagini img = new Immagini();

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JLabel lblLayout;
	private JLabel lblSpostaSceltaProfiloSenzaAccesso;
	private JLabel lblX;
	private JLabel lblAnnulla;
	private JLabel lblRegistrati;
	private JLabel lblAccedi;
	private JLabel lblContinuare;

	// GETTER E SETTER
	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblRegistrati() {
		return lblRegistrati;
	}

	public void setLblRegistrati(JLabel lblRegistrati) {
		this.lblRegistrati = lblRegistrati;
	}

	public JLabel getLblAccedi() {
		return lblAccedi;
	}

	public void setLblAccedi(JLabel lblAccedi) {
		this.lblAccedi = lblAccedi;
	}

	public JLabel getLblContinuare() {
		return lblContinuare;
	}

	public void setLblContinuare(JLabel lblContinuare) {
		this.lblContinuare = lblContinuare;
	}

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}

	public JLabel getLblSpostaSceltaProfiloSenzaAccesso() {
		return lblSpostaSceltaProfiloSenzaAccesso;
	}

	public void setLblSpostaSceltaProfiloSenzaAccesso(JLabel lblSpostaSceltaProfiloSenzaAccesso) {
		this.lblSpostaSceltaProfiloSenzaAccesso = lblSpostaSceltaProfiloSenzaAccesso;
	}

	Controller controllerSceltaProfiloSenzaAccesso;

	public SceltaProfiloSenzaAccesso(Controller controller) {
		controllerSceltaProfiloSenzaAccesso = controller;

		setModal(true);

		setBounds(100, 100, 500, 300);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(null);
		{

			lblAnnulla = new JLabel("");
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.annullaSceltaProfiloSenzaAccesso();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAnnulla, img.annulla2TemaChiaro(),
							img.annulla2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAnnulla, img.annulla1TemaChiaro(),
							img.annulla1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAnnulla, img.annulla3TemaChiaro(),
							img.annulla3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAnnulla, img.annulla2TemaChiaro(),
							img.annulla2());
				}
			});
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(92, 222, 319, 36);
			getContentPane().add(lblAnnulla);

			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.annullaSceltaProfiloSenzaAccesso();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblX, img.X2TemaChiaro(), img.X2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblX, img.X3TemaChiaro(), img.X3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblX, img.X1TemaChiaro(), img.X1());
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(448, 1, 51, 34);
			getContentPane().add(lblX);

			lblSpostaSceltaProfiloSenzaAccesso = new JLabel("");
			lblSpostaSceltaProfiloSenzaAccesso.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaSceltaProfiloSenzaAccesso.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaSceltaProfiloSenzaAccesso.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);
				}
			});
			lblSpostaSceltaProfiloSenzaAccesso.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();

				}
			});
			lblSpostaSceltaProfiloSenzaAccesso.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaSceltaProfiloSenzaAccesso);

			lblAccedi = new JLabel("");
			lblAccedi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.setPannelloPrecedente(2);
					controllerSceltaProfiloSenzaAccesso.vaiAdAccediDaSceltaProfiloSenzaAccesso();
					controllerSceltaProfiloSenzaAccesso.getDashboard().getPanelAccedi()
							.setBackground(controllerSceltaProfiloSenzaAccesso.pannelloSceltoTemaScuro);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAccedi, img.accedi2TemaChiaro(),
							img.accedi2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAccedi, img.accedi1TemaChiaro(),
							img.accedi1());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAccedi, img.accedi3TemaChiaro(),
							img.accedi3());
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblAccedi, img.accedi1TemaChiaro(),
							img.accedi1());
				}
			});
			lblAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccedi.setIcon(new ImageIcon(img.accedi1()));
			lblAccedi.setBounds(92, 118, 319, 36);
			getContentPane().add(lblAccedi);

			lblRegistrati = new JLabel("");
			lblRegistrati.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.setPannelloPrecedente(3);
					controllerSceltaProfiloSenzaAccesso.vaiARegistrazioneDaSceltaProfiloSenzaAccesso();
					controllerSceltaProfiloSenzaAccesso.getDashboard().getPanelRegistrati()
							.setBackground(controllerSceltaProfiloSenzaAccesso.pannelloSceltoTemaScuro);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblRegistrati, img.registrati2TemaChiaro(),
							img.registrati2());
				}

				@Override
				public void mouseExited(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblRegistrati, img.registrati1TemaChiaro(),
							img.registrati1());

				}

				@Override
				public void mousePressed(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblRegistrati, img.registrati3TemaChiaro(),
							img.registrati3());

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					controllerSceltaProfiloSenzaAccesso.cambioImmagineTema(lblRegistrati, img.registrati1TemaChiaro(),
							img.registrati1());

				}
			});
			lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistrati.setIcon(new ImageIcon(img.registrati1()));
			lblRegistrati.setBounds(92, 170, 319, 36);
			getContentPane().add(lblRegistrati);

			{
				lblContinuare = new JLabel("Accedi o registrati per proseguire");
				lblContinuare.setHorizontalAlignment(SwingConstants.CENTER);
				lblContinuare.setFont(controllerSceltaProfiloSenzaAccesso.fontScritteJDialog);
				lblContinuare.setForeground(controllerSceltaProfiloSenzaAccesso.coloreScritteTemaScuro);
				lblContinuare.setBounds(2, 60, 498, 37);
				getContentPane().add(lblContinuare);
			}

		}

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerSceltaProfiloSenzaAccesso.centramentoJDialog(this);
	}

}
