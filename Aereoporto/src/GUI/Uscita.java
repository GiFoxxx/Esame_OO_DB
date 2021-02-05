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

public class Uscita extends JDialog {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	private boolean flag = true;

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
			JButton btnAnnulla = new JButton("Annulla");
			btnAnnulla.setBorder(null);
			btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAnnulla.setFont(controllerUscita.fontScritte);
			btnAnnulla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.annullaUscita();
				}
			});
			btnAnnulla.setBounds(322, 220, 100, 30);
			getContentPane().add(btnAnnulla);
			btnAnnulla.setActionCommand("Annulla");

			JLabel lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Uscita.this.dispose();
					controllerUscita.getDashboard().dispose();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X1()));
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(461, 0, 37, 43);
			getContentPane().add(lblX);

			{
				JLabel lblUscire = new JLabel("Sei sicuro di voler uscire dal programma?");
				lblUscire.setHorizontalAlignment(SwingConstants.CENTER);
				lblUscire.setFont(controllerUscita.fontScritteUscita);
				lblUscire.setForeground(controllerUscita.coloreScritte);
				lblUscire.setBounds(0, 81, 498, 52);
				getContentPane().add(lblUscire);
			}

		}
		{
			JButton btnOk = new JButton("OK");
			btnOk.setBorder(null);
			btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnOk.setFont(controllerUscita.fontScritte);
			btnOk.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					controllerUscita.esci();

				}
			});
			btnOk.setBounds(75, 220, 100, 30);
			getContentPane().add(btnOk);
			btnOk.setActionCommand("OK");
		}

		lblLayout = new JLabel("");

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		JLabel lblSpostaDaashboard = new JLabel("");
		lblSpostaDaashboard.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent spostaDashboard) {
				x = spostaDashboard.getXOnScreen();
				y = spostaDashboard.getYOnScreen();
				xMouseSuSchermo = spostaDashboard.getXOnScreen();
				yMouseSuSchermo = spostaDashboard.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);

			}
		});
		lblSpostaDaashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent prendiPosizioneMouse) {

				xMouse = prendiPosizioneMouse.getX();
				yMouse = prendiPosizioneMouse.getY();

			}
		});
		lblSpostaDaashboard.setEnabled(false);
		lblSpostaDaashboard.setBounds(0, 0, 500, 30);
		getContentPane().add(lblSpostaDaashboard);

		controllerUscita.centramentoJDialog(this);
	}
}
