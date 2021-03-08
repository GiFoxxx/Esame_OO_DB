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
	JLabel lblLayout;
	JLabel lblErrore;
	JLabel lblLogout;
	JLabel lblComingSoon;

	JPanel panelGestioneUtente;
	JPanel panelComingSoon;
	JPanel panelLogout;

	public JLabel getLblGestioneUtenti() {
		return lblGestioneUtenti;
	}

	public void setLblGestioneUtenti(JLabel lblGestioneUtenti) {
		this.lblGestioneUtenti = lblGestioneUtenti;
	}

	public JLabel getLblLayout() {
		return lblLayout;
	}

	public void setLblLayout(JLabel lblLayout) {
		this.lblLayout = lblLayout;
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

	public JLabel getLblComingSoon() {
		return lblComingSoon;
	}

	public void setLblComingSoon(JLabel lblBoh) {
		this.lblComingSoon = lblBoh;
	}

	public JPanel getPanelComingSoon() {
		return panelComingSoon;
	}

	public void setPanelComingSoon(JPanel pannello2) {
		this.panelComingSoon = pannello2;
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
		setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
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
				if (controllerMenuInfoAccount.cambioTema()) {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.entroPannelloTemaChiaro);
				} else {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.entroPannelloTemaScuro);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				} else {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelGestioneUtente.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}
		});
		panelGestioneUtente.setBackground(controllerMenuInfoAccount.trasparente);
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
		lblErrore.setForeground(controllerMenuInfoAccount.coloreScritturaAllertaTemaScuro);
		lblErrore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrore.setBounds(125, 0, 139, 46);
		panelGestioneUtente.add(lblErrore);

		panelComingSoon = new JPanel();
		panelComingSoon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelComingSoon.setBackground(controllerMenuInfoAccount.entroPannelloTemaChiaro);
				} else {
					panelComingSoon.setBackground(controllerMenuInfoAccount.entroPannelloTemaScuro);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelComingSoon.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelComingSoon.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelComingSoon.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				} else {
					panelComingSoon.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelComingSoon.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelComingSoon.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}
		});
		panelComingSoon.setBackground(controllerMenuInfoAccount.trasparente);
		panelComingSoon.setBounds(0, 55, 265, 46);
		add(panelComingSoon);
		panelComingSoon.setLayout(null);

		lblComingSoon = new JLabel("Coming soon");
		lblComingSoon.setHorizontalAlignment(SwingConstants.LEFT);
		lblComingSoon.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblComingSoon.setFont(controllerMenuInfoAccount.fontLabel);
		lblComingSoon.setBounds(10, 0, 107, 46);
		panelComingSoon.add(lblComingSoon);

		panelLogout = new JPanel();
		panelLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerMenuInfoAccount.logout();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelLogout.setBackground(controllerMenuInfoAccount.entroPannelloTemaChiaro);
				} else {
					panelLogout.setBackground(controllerMenuInfoAccount.entroPannelloTemaScuro);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelLogout.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelLogout.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelLogout.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				} else {
					panelLogout.setBackground(controllerMenuInfoAccount.clickPannelloTemaScuro);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerMenuInfoAccount.cambioTema()) {
					panelLogout.setBackground(controllerMenuInfoAccount.escoPannelloTemaChiaro);
				} else {
					panelLogout.setBackground(controllerMenuInfoAccount.escoPannelloTemaScuro);
				}
			}
		});
		panelLogout.setBackground(controllerMenuInfoAccount.trasparente);
		panelLogout.setBounds(0, 101, 265, 46);
		add(panelLogout);
		panelLogout.setLayout(null);

		lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setForeground(controllerMenuInfoAccount.coloreLabelPressedTemaScuro);
		lblLogout.setFont(controllerMenuInfoAccount.fontLabel);
		lblLogout.setBounds(10, 0, 107, 46);
		panelLogout.add(lblLogout);

		lblLayout = new JLabel("");
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.menu()));

		lblLayout.setBounds(0, 0, 265, 147);
		add(lblLayout);

	}
}
