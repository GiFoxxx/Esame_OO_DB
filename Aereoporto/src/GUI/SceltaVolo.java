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

public class SceltaVolo extends JDialog {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	JLabel lblSpostaUscita;
	JLabel lblX;
	JLabel lblArrivi;
	JLabel lblPartenze;
	JLabel lblScelta;
	JLabel lblAnnulla;

	Immagini img = new Immagini();
	Controller controllerSceltaVolo;

	public SceltaVolo(Controller controller) {
		controllerSceltaVolo = controller;

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
					controllerSceltaVolo.annullaSceltaVolo();
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
			lblAnnulla.setBounds(184, 205, 135, 41);
			getContentPane().add(lblAnnulla);
			

			lblPartenze = new JLabel("");
			lblPartenze.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaVolo.vaiAVoliPartenzeDaSceltaVolo();
					controllerSceltaVolo.setPannelloPrecedente(11);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblPartenze.setIcon(new ImageIcon(img.partenze2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblPartenze.setIcon(new ImageIcon(img.partenze1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblPartenze.setIcon(new ImageIcon(img.partenze3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblPartenze.setIcon(new ImageIcon(img.partenze1()));
				}
			});
			lblPartenze.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblPartenze.setHorizontalAlignment(SwingConstants.CENTER);
			lblPartenze.setIcon(new ImageIcon(img.partenze1()));
			lblPartenze.setBounds(76, 125, 135, 41);
			getContentPane().add(lblPartenze);

			lblArrivi = new JLabel("");
			lblArrivi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaVolo.vaiAVoliArriviDaSceltaVolo();
					controllerSceltaVolo.setPannelloPrecedente(12);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblArrivi.setIcon(new ImageIcon(img.arrivi2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblArrivi.setIcon(new ImageIcon(img.arrivi1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblArrivi.setIcon(new ImageIcon(img.arrivi3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblArrivi.setIcon(new ImageIcon(img.arrivi1()));
				}
			});
			lblArrivi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblArrivi.setHorizontalAlignment(SwingConstants.CENTER);
			lblArrivi.setIcon(new ImageIcon(img.arrivi1()));
			lblArrivi.setBounds(287, 125, 135, 41);
			getContentPane().add(lblArrivi);

			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerSceltaVolo.annullaSceltaVolo();
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

			lblSpostaUscita = new JLabel("");
			lblSpostaUscita.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaUscita.setIcon(new ImageIcon(img.spostaUscita()));
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
			lblSpostaUscita.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaUscita);

			{
				lblScelta = new JLabel("Scegli che voli vuoi visualizzare e gestire");
				lblScelta.setHorizontalAlignment(SwingConstants.CENTER);
				lblScelta.setFont(controllerSceltaVolo.fontScritteJDialog);
				lblScelta.setForeground(controllerSceltaVolo.coloreScritte);
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

		controllerSceltaVolo.centramentoJDialog(this);
	}
}
