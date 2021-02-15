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
							public void mouseEntered(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X2()));
							}

							@Override
							public void mouseExited(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X1()));
							}

							@Override
							public void mousePressed(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X3()));
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								lblX.setIcon(new ImageIcon(img.X1()));
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
			lblAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.annullaUscita();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
				}
			});
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(281, 213, 135, 41);
			getContentPane().add(lblAnnulla);

			lblSi = new JLabel("");
			lblSi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.esci();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblSi.setIcon(new ImageIcon(img.si2()));

				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblSi.setIcon(new ImageIcon(img.si1()));

				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblSi.setIcon(new ImageIcon(img.si3()));

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblSi.setIcon(new ImageIcon(img.si1()));

				}
			});
			lblSi.setHorizontalAlignment(SwingConstants.CENTER);
			lblSi.setIcon(new ImageIcon(img.si1()));
			lblSi.setBounds(64, 213, 135, 41);
			getContentPane().add(lblSi);

			{
				lblUscire = new JLabel("Sei sicuro di voler uscire dal programma?");
				lblUscire.setHorizontalAlignment(SwingConstants.CENTER);
				lblUscire.setFont(controllerUscita.fontScritteJDialog);
				lblUscire.setForeground(controllerUscita.coloreScritte);
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
