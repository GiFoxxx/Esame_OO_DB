package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class Uscita extends JDialog {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	JLabel lblSpostaUscita;
	JLabel lblX;
	JLabel lblAnnulla;
	JLabel lblSi;
	JLabel lblUscire;

	// GETTER E SETTER
	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblSi() {
		return lblSi;
	}

	public void setLblSi(JLabel lblSi) {
		this.lblSi = lblSi;
	}

	public JLabel getLblUscire() {
		return lblUscire;
	}

	public void setLblUscire(JLabel lblUscire) {
		this.lblUscire = lblUscire;
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

	public JLabel getLblSpostaUscita() {
		return lblSpostaUscita;
	}

	public void setLblSpostaUscita(JLabel lblSpostaUscita) {
		this.lblSpostaUscita = lblSpostaUscita;
	}

	Immagini img = new Immagini();

	Controller controllerUscita;

	public Uscita(Controller controller) {
		controllerUscita = controller;

		setModal(true);

		setBounds(100, 100, 500, 300);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(null);
		{

			lblSpostaUscita = new JLabel("");
			lblSpostaUscita.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);

				}
			});
			lblSpostaUscita.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();

				}
			});

			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.annullaUscita();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblX.setIcon(new ImageIcon(img.X1TemaChiaro()));
					} else {
						lblX.setIcon(new ImageIcon(img.X1()));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblX.setIcon(new ImageIcon(img.X3TemaChiaro()));
					} else {
						lblX.setIcon(new ImageIcon(img.X3()));
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblX.setIcon(new ImageIcon(img.X2TemaChiaro()));
					} else {
						lblX.setIcon(new ImageIcon(img.X2()));
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblX.setIcon(new ImageIcon(img.X2TemaChiaro()));
					} else {
						lblX.setIcon(new ImageIcon(img.X2()));
					}
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(448, 1, 51, 34);
			getContentPane().add(lblX);
			lblSpostaUscita.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaUscita.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaUscita.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaUscita);

			lblAnnulla = new JLabel("");
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.annullaUscita();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita2TemaChiaro()));
					} else {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita2()));
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita1TemaChiaro()));
					} else {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita1()));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita3TemaChiaro()));
					} else {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita3()));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita2TemaChiaro()));
					} else {
						lblAnnulla.setIcon(new ImageIcon(img.annullaUscita2()));
					}
				}
			});
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annullaUscita1()));
			lblAnnulla.setBounds(290, 203, 130, 36);
			getContentPane().add(lblAnnulla);

			lblSi = new JLabel("");
			lblSi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.esci();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblSi.setIcon(new ImageIcon(img.si2TemaChiaro()));
					} else {
						lblSi.setIcon(new ImageIcon(img.si2()));
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblSi.setIcon(new ImageIcon(img.si1TemaChiaro()));
					} else {
						lblSi.setIcon(new ImageIcon(img.si1()));
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblSi.setIcon(new ImageIcon(img.si3TemaChiaro()));
					} else {
						lblSi.setIcon(new ImageIcon(img.si3()));
					}
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					if (controllerUscita.cambioTema()) {
						lblSi.setIcon(new ImageIcon(img.si2TemaChiaro()));
					} else {
						lblSi.setIcon(new ImageIcon(img.si2()));
					}
				}
			});
			lblSi.setHorizontalAlignment(SwingConstants.CENTER);
			lblSi.setIcon(new ImageIcon(img.si1()));
			lblSi.setBounds(80, 203, 130, 36);
			getContentPane().add(lblSi);

			{
				lblUscire = new JLabel("Sei sicuro di voler uscire dal programma?");
				lblUscire.setHorizontalAlignment(SwingConstants.CENTER);
				lblUscire.setFont(controllerUscita.fontScritteJDialog);
				lblUscire.setForeground(controllerUscita.coloreScritteTemaScuro);
				lblUscire.setBounds(0, 81, 498, 52);
				getContentPane().add(lblUscire);
			}

		}

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerUscita.centramentoJDialog(this);
	}
}
