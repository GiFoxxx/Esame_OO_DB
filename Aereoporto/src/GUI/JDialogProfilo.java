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

public class JDialogProfilo extends JDialog {

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
	JLabel lblRegistrati;
	JLabel lblAccedi;
	JLabel lblContinuare;
	private boolean flag = true;

	Immagini img = new Immagini();
	Controller controllerJDialogProfilo;

	public JDialogProfilo(Controller controller) {
		controllerJDialogProfilo = controller;

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
					controllerJDialogProfilo.annullaJDialogProfilo();
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
			lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(164, 222, 174, 47);
			getContentPane().add(lblAnnulla);

			lblRegistrati = new JLabel("");
			lblRegistrati.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerJDialogProfilo.vaiARegistrazioneDaJDialogProfilo();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblRegistrati.setIcon(new ImageIcon(img.registrati2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblRegistrati.setIcon(new ImageIcon(img.registrati1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblRegistrati.setIcon(new ImageIcon(img.registrati3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblRegistrati.setIcon(new ImageIcon(img.registrati1()));
				}
			});
			lblRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistrati.setIcon(new ImageIcon(img.registrati1()));
			lblRegistrati.setBounds(164, 163, 174, 47);
			getContentPane().add(lblRegistrati);

			lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerJDialogProfilo.annullaJDialogProfilo();
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
			lblX.setBounds(448, 1, 51, 36);
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

			lblAccedi = new JLabel("");
			lblAccedi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerJDialogProfilo.vaiAdAccediDaJDialogProfilo();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblAccedi.setIcon(new ImageIcon(img.accedi2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAccedi.setIcon(new ImageIcon(img.accedi1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblAccedi.setIcon(new ImageIcon(img.accedi3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblAccedi.setIcon(new ImageIcon(img.accedi1()));
				}
			});
			lblAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccedi.setIcon(new ImageIcon(img.accedi1()));
			lblAccedi.setBounds(163, 100, 177, 52);
			getContentPane().add(lblAccedi);

			{
				lblContinuare = new JLabel("Accedi o registrati per proseguire");
				lblContinuare.setHorizontalAlignment(SwingConstants.CENTER);
				lblContinuare.setFont(controllerJDialogProfilo.fontScritteJDialog);
				lblContinuare.setForeground(controllerJDialogProfilo.coloreScritte);
				lblContinuare.setBounds(2, 48, 498, 37);
				getContentPane().add(lblContinuare);
			}

		}

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerJDialogProfilo.centramentoJDialog(this);
	}
}
