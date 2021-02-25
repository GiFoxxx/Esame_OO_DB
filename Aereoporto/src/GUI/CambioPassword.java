package GUI;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Amministrazione.*;
import java.awt.Font;

public class CambioPassword extends JPanel {

	private Immagini img = new Immagini();

	private JTextField txtVecchiaPassword;
	private JPasswordField txtNuovaPassword;
	private JPasswordField txtRipetiNuovaPassword;
	
	private JLabel lblMostraNuovaPassword;
	private JLabel lblCensuraNuovaPassword;
	private JLabel lblMostraRipetiNuovaPassword;
	private JLabel lblCensuraRipetiNuovaPassword;
	private JLabel lblCambioPassword;
	private JLabel lblPasswordDimenticata;
	private JLabel lblSalva;
	private JLabel lblAnnulla;
	
	// GETTER E SETTER

	public JLabel getLblSalva() {
		return lblSalva;
	}

	public void setLblSalva(JLabel lblSalva) {
		this.lblSalva = lblSalva;
	}

	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	public JLabel getLblMostraNuovaPassword() {
		return lblMostraNuovaPassword;
	}

	public void setLblMostraNuovaPassword(JLabel lblMostraNuovaPassword) {
		this.lblMostraNuovaPassword = lblMostraNuovaPassword;
	}

	public JLabel getLblCensuraNuovaPassword() {
		return lblCensuraNuovaPassword;
	}

	public void setLblCensuraNuovaPassword(JLabel lblCensuraNuovaPassword) {
		this.lblCensuraNuovaPassword = lblCensuraNuovaPassword;
	}

	public JLabel getLblMostraRipetiNuovaPassword() {
		return lblMostraRipetiNuovaPassword;
	}

	public void setLblMostraRipetiNuovaPassword(JLabel lblMostraRipetiNuovaPassword) {
		this.lblMostraRipetiNuovaPassword = lblMostraRipetiNuovaPassword;
	}

	public JLabel getLblCensuraRipetiNuovaPassword() {
		return lblCensuraRipetiNuovaPassword;
	}

	public void setLblCensuraRipetiNuovaPassword(JLabel lblCensuraRipetiNuovaPassword) {
		this.lblCensuraRipetiNuovaPassword = lblCensuraRipetiNuovaPassword;
	}

	public JLabel getLblCambioPassword() {
		return lblCambioPassword;
	}

	public void setLblCambioPassword(JLabel lblCambioPassword) {
		this.lblCambioPassword = lblCambioPassword;
	}

	public JTextField getTxtVecchiaPassword() {
		return txtVecchiaPassword;
	}

	public void setTxtVecchiaPassword(JTextField txtVecchiaPassword) {
		this.txtVecchiaPassword = txtVecchiaPassword;
	}

	public JPasswordField getTxtNuovaPassword() {
		return txtNuovaPassword;
	}

	public void setTxtNuovaPassword(JPasswordField txtNuovaPassword) {
		this.txtNuovaPassword = txtNuovaPassword;
	}

	public JPasswordField getTxtRipetiNuovaPassword() {
		return txtRipetiNuovaPassword;
	}

	public void setTxtRipetiNuovaPassword(JPasswordField txtRipetiNuovaPassword) {
		this.txtRipetiNuovaPassword = txtRipetiNuovaPassword;
	}
	
	public JLabel getLblPasswordDimenticata() {
		return lblPasswordDimenticata;
	}

	public void setLblPasswordDimenticata(JLabel lblPasswordDimenticata) {
		this.lblPasswordDimenticata = lblPasswordDimenticata;
	}

	Controller controllerCambioPassword;

	public CambioPassword(Controller controller) {
		controllerCambioPassword = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerCambioPassword.sfondoTemaScuro);
		setLayout(null);

		txtVecchiaPassword = new JTextField();
		txtVecchiaPassword.setBorder(null);
		txtVecchiaPassword.setFont(controllerCambioPassword.fontScritte);
		txtVecchiaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtVecchiaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtVecchiaPassword.setBounds(361, 175, 304, 23);
		txtVecchiaPassword.setColumns(10);
		add(txtVecchiaPassword);

		txtNuovaPassword = new JPasswordField();
		txtNuovaPassword.setBorder(null);
		txtNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtNuovaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtNuovaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtNuovaPassword.setBounds(361, 279, 304, 23);
		add(txtNuovaPassword);

		txtRipetiNuovaPassword = new JPasswordField();
		txtRipetiNuovaPassword.setBorder(null);
		txtRipetiNuovaPassword.setFont(controllerCambioPassword.fontScritte);
		txtRipetiNuovaPassword.setBackground(controllerCambioPassword.sfondoTemaScuro);
		txtRipetiNuovaPassword.setForeground(controllerCambioPassword.coloreScritteTemaScuro);
		txtRipetiNuovaPassword.setBounds(361, 384, 314, 23);
		add(txtRipetiNuovaPassword);

		lblMostraNuovaPassword = new JLabel("");
		lblMostraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraNuovaPassword.setVisible(false);
				txtNuovaPassword.setEchoChar((char)0);
			}
		});
		lblMostraNuovaPassword.setToolTipText("Mostra password");
		lblMostraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraNuovaPassword.setBounds(684, 282, 20, 20);
		add(lblMostraNuovaPassword);

		lblCensuraNuovaPassword = new JLabel("");
		lblCensuraNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraNuovaPassword.setVisible(true);
				txtNuovaPassword.setEchoChar('●');
			}
		});
		lblCensuraNuovaPassword.setToolTipText("Nascondi password");
		lblCensuraNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraNuovaPassword.setBounds(684, 282, 20, 20);
		add(lblCensuraNuovaPassword);

		lblMostraRipetiNuovaPassword = new JLabel("");
		lblMostraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiNuovaPassword.setVisible(false);
				txtRipetiNuovaPassword.setEchoChar((char)0);
			}
		});
		lblMostraRipetiNuovaPassword.setToolTipText("Mostra password");
		lblMostraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiNuovaPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraRipetiNuovaPassword.setBounds(684, 387, 20, 20);
		add(lblMostraRipetiNuovaPassword);

		lblCensuraRipetiNuovaPassword = new JLabel("");
		lblCensuraRipetiNuovaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiNuovaPassword.setVisible(true);
				txtRipetiNuovaPassword.setEchoChar('●');
			}
		});
		lblCensuraRipetiNuovaPassword.setToolTipText("Nascondi password");
		lblCensuraRipetiNuovaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraRipetiNuovaPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiNuovaPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraRipetiNuovaPassword.setBounds(684, 387, 20, 20);
		add(lblCensuraRipetiNuovaPassword);

		lblCambioPassword = new JLabel("");
		lblCambioPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambioPassword.setIcon(new ImageIcon(img.cambioPassword()));
		lblCambioPassword.setBounds(360, 146, 344, 263);
		add(lblCambioPassword);
		
		lblPasswordDimenticata = new JLabel("Password dimenticata?");
		lblPasswordDimenticata.setForeground(Color.LIGHT_GRAY);
		lblPasswordDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.mostraPasswordDimenticata();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelPressedTemaScuro);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelTemaScuro);
			}
		});
		lblPasswordDimenticata.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPasswordDimenticata.setForeground(controllerCambioPassword.coloreLabelTemaScuro);
		lblPasswordDimenticata.setFont(controllerCambioPassword.fontLabel);
		lblPasswordDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordDimenticata.setBounds(563, 418, 141, 14);
		add(lblPasswordDimenticata);
		
		JLabel lblSalva = new JLabel("");
		lblSalva.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalva.setIcon(new ImageIcon(img.salvaModifiche1()));
		lblSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.cambioPasswordDaProfilo();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalva.setIcon(new ImageIcon(img.salvaModifiche2()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSalva.setIcon(new ImageIcon(img.salvaModifiche1()));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblSalva.setIcon(new ImageIcon(img.salvaModifiche3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblSalva.setIcon(new ImageIcon(img.salvaModifiche2()));
			}
		});
		lblSalva.setBounds(383, 494, 321, 41);
		add(lblSalva);
		
		JLabel lblAnnulla = new JLabel("");
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerCambioPassword.mostraPannelli(controllerCambioPassword.getDashboard().getProfilo());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro2()));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro2()));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro2()));

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.frecciaIndietro2()));

			}
		});
		lblAnnulla.setBounds(100, 51, 41, 41);
		add(lblAnnulla);

	}

	// METODI

}
