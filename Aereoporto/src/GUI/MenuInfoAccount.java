package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class MenuInfoAccount extends JPanel {

	private Immagini img = new Immagini();

	JLabel lblGestioneUtenti;
	JLabel lblErrore;
	JLabel lblLogout;
	JLabel lblPrestoInArrivo;
	JLabel lblFrecciaInAlto;

	JPanel panelGestioneUtente;
	JPanel panelPrestoInArrivo;
	JPanel panelLogout;

	
	// GETTER E SETTER
	public JLabel getLblGestioneUtenti() {
		return lblGestioneUtenti;
	}

	public void setLblGestioneUtenti(JLabel lblGestioneUtenti) {
		this.lblGestioneUtenti = lblGestioneUtenti;
	}

	public JLabel getLblFrecciaInAlto() {
		return lblFrecciaInAlto;
	}

	public void setLblFrecciaInAlto(JLabel lblFrecciaInAlto) {
		this.lblFrecciaInAlto = lblFrecciaInAlto;
	}

	public JLabel getLblErrore() {
		return lblErrore;
	}

	public void setLblErrore(JLabel lblErrore) {
		this.lblErrore = lblErrore;
	}

	public JLabel getLblLogout() {
		return lblLogout;
	}

	public void setLblLogout(JLabel lblLogout) {
		this.lblLogout = lblLogout;
	}

	public JPanel getPanelLogout() {
		return panelLogout;
	}

	public void setPanelLogout(JPanel pannello3) {
		this.panelLogout = pannello3;
	}

	public JPanel getPanelGestioneUtente() {
		return panelGestioneUtente;
	}

	public void setPanelGestioneUtente(JPanel pannello1) {
		this.panelGestioneUtente = pannello1;
	}

	Controller controllerMenuInfoAccount;

	public MenuInfoAccount(Controller controller) {
		controllerMenuInfoAccount = controller;

		setBounds(710, 5, 265, 147);
		setBackground(controllerMenuInfoAccount.trasparente);
		setLayout(null);

		panelGestioneUtente = new JPanel();
		panelGestioneUtente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controllerMenuInfoAccount.isEntraGestioneUtenti()) {
					controllerMenuInfoAccount.entraInGestioneUtenti();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelGestioneUtente, controllerMenuInfoAccount.entroPannelloTemaChiaro, controllerMenuInfoAccount.entroPannelloTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelGestioneUtente, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelGestioneUtente, controllerMenuInfoAccount.clickPannelloTemaChiaro, controllerMenuInfoAccount.clickPannelloTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelGestioneUtente, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}
		});
		panelGestioneUtente.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		panelGestioneUtente.setBounds(0, 9, 265, 46);
		add(panelGestioneUtente);
		panelGestioneUtente.setLayout(null);

		lblGestioneUtenti = new JLabel("Gestione Utenti");
		lblGestioneUtenti.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestioneUtenti.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblGestioneUtenti.setFont(controllerMenuInfoAccount.fontLabel);
		lblGestioneUtenti.setBounds(10, 0, 107, 46);
		panelGestioneUtente.add(lblGestioneUtenti);

		lblErrore = new JLabel("");
		lblErrore.setFont(controllerMenuInfoAccount.fontLabel);
		lblErrore.setForeground(controllerMenuInfoAccount.coloreScrittaErroreInMenuInfo);
		lblErrore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrore.setBounds(125, 0, 139, 46);
		panelGestioneUtente.add(lblErrore);

		panelPrestoInArrivo = new JPanel();
		panelPrestoInArrivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelPrestoInArrivo, controllerMenuInfoAccount.entroPannelloTemaChiaro, controllerMenuInfoAccount.entroPannelloTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelPrestoInArrivo, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelPrestoInArrivo, controllerMenuInfoAccount.clickPannelloTemaChiaro, controllerMenuInfoAccount.clickPannelloTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelPrestoInArrivo, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}
		});
		panelPrestoInArrivo.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		panelPrestoInArrivo.setBounds(0, 55, 265, 46);
		add(panelPrestoInArrivo);
		panelPrestoInArrivo.setLayout(null);

		lblPrestoInArrivo = new JLabel("Presto in arrivo");
		lblPrestoInArrivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrestoInArrivo.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblPrestoInArrivo.setFont(controllerMenuInfoAccount.fontLabel);
		lblPrestoInArrivo.setBounds(10, 0, 107, 46);
		panelPrestoInArrivo.add(lblPrestoInArrivo);

		panelLogout = new JPanel();
		panelLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuInfoAccount.logout();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelLogout, controllerMenuInfoAccount.entroPannelloTemaChiaro, controllerMenuInfoAccount.entroPannelloTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelLogout, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelLogout, controllerMenuInfoAccount.clickPannelloTemaChiaro, controllerMenuInfoAccount.clickPannelloTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerMenuInfoAccount.cambioPannelloTema(panelLogout, controllerMenuInfoAccount.escoPannelloTemaChiaro, controllerMenuInfoAccount.escoPannelloTemaScuro);
			}
		});
		panelLogout.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
		panelLogout.setBounds(0, 101, 265, 46);
		add(panelLogout);
		panelLogout.setLayout(null);

		lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblLogout.setFont(controllerMenuInfoAccount.fontLabel);
		lblLogout.setBounds(10, 0, 107, 46);
		panelLogout.add(lblLogout);
		
		lblFrecciaInAlto = new JLabel("");
		lblFrecciaInAlto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblFrecciaInAlto.setIcon(new ImageIcon(img.frecciaInSu()));
		lblFrecciaInAlto.setBounds(224, 0, 15, 10);
		add(lblFrecciaInAlto);


	}

	public JPanel getPanelPrestoInArrivo() {
		return panelPrestoInArrivo;
	}

	public void setPanelPrestoInArrivo(JPanel panelPrestoInArrivo) {
		this.panelPrestoInArrivo = panelPrestoInArrivo;
	}

	public JLabel getLblPrestoInArrivo() {
		return lblPrestoInArrivo;
	}

	public void setLblPrestoInArrivo(JLabel lblPrestoInArrivo) {
		this.lblPrestoInArrivo = lblPrestoInArrivo;
	}
}
