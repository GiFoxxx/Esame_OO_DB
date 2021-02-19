package GUI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Controller.Controller;
import Immagini.Immagini;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegistrazioneEffettuataConSuccesso extends JDialog {
	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	private JLabel lblLayout;
	private JLabel lblSpostaRegistrazioneEffettuataConSuccesso;
	private JLabel lblComplimenti;
	private JLabel lblSpuntaSuccesso;
	private JLabel lblClicca;

	// GETTER E SETTER
	public JLabel getLblComplimenti() {
		return lblComplimenti;
	}

	public void setLblComplimenti(JLabel lblUscire) {
		this.lblComplimenti = lblUscire;
	}

	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
	}

	public JLabel getLblSpostaRegistrazioneEffettuataConSuccesso() {
		return lblSpostaRegistrazioneEffettuataConSuccesso;
	}

	public void setLblSpostaRegistrazioneEffettuataConSuccesso(JLabel lblSpostaUscita) {
		this.lblSpostaRegistrazioneEffettuataConSuccesso = lblSpostaUscita;
	}

	public JLabel getLblSpuntaSuccesso() {
		return lblSpuntaSuccesso;
	}

	public void setLblSpuntaSuccesso(JLabel lblSpuntaSuccesso) {
		this.lblSpuntaSuccesso = lblSpuntaSuccesso;
	}

	public JLabel getLblClicca() {
		return lblClicca;
	}

	public void setLblClicca(JLabel lblClicca) {
		this.lblClicca = lblClicca;
	}

	Immagini img = new Immagini();

	Controller controllerRegistrazioneEffettuataConSuccesso;

	public RegistrazioneEffettuataConSuccesso(Controller controller) {
		controllerRegistrazioneEffettuataConSuccesso = controller;

		setModal(true);

		setBounds(100, 100, 500, 300);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(null);
		{

			lblSpostaRegistrazioneEffettuataConSuccesso = new JLabel("");
			lblSpostaRegistrazioneEffettuataConSuccesso.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);

				}
			});
			lblSpostaRegistrazioneEffettuataConSuccesso.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();

				}
			});
			lblSpostaRegistrazioneEffettuataConSuccesso.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaRegistrazioneEffettuataConSuccesso.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaRegistrazioneEffettuataConSuccesso.setBounds(1, 0, 498, 37);
			getContentPane().add(lblSpostaRegistrazioneEffettuataConSuccesso);

			lblComplimenti = new JLabel("Complimenti registrazione effettuata con successo.");
			lblComplimenti.setHorizontalAlignment(SwingConstants.CENTER);
			lblComplimenti.setFont(controllerRegistrazioneEffettuataConSuccesso.fontScritteJDialog);
			lblComplimenti.setForeground(controllerRegistrazioneEffettuataConSuccesso.coloreScritteTemaScuro);
			lblComplimenti.setBounds(0, 81, 498, 52);
			getContentPane().add(lblComplimenti);

			lblClicca = new JLabel("Clicca per accedere.");
			lblClicca.setHorizontalAlignment(SwingConstants.CENTER);
			lblClicca.setFont(controllerRegistrazioneEffettuataConSuccesso.fontLabel);
			lblClicca.setForeground(controllerRegistrazioneEffettuataConSuccesso.coloreScritteTemaScuro);
			lblClicca.setBounds(170, 211, 160, 14);
			getContentPane().add(lblClicca);

			lblSpuntaSuccesso = new JLabel("");
			lblSpuntaSuccesso.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					controllerRegistrazioneEffettuataConSuccesso.fineRegistrazioneEffettuataConSuccesso();
				}
			});
			lblSpuntaSuccesso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblSpuntaSuccesso.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpuntaSuccesso.setIcon(new ImageIcon(img.spuntaSuccesso()));
			lblSpuntaSuccesso.setBounds(227, 163, 46, 37);
			getContentPane().add(lblSpuntaSuccesso);

		}
		lblLayout = new JLabel("");
		lblLayout.setBorder(null);

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerRegistrazioneEffettuataConSuccesso.centramentoJDialog(this);
	}
}
