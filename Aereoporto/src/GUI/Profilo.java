package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Profilo extends JPanel {
	Immagini img = new Immagini();

	private JLabel lblLogout;
	private JLabel lblDatiAccount;
	private JLabel lblCambiaPassword;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;

	// GETTER E SETTER

	public JLabel getLblLogout() {
		return lblLogout;
	}

	public void setLblLogout(JLabel lblLogout) {
		this.lblLogout = lblLogout;
	}

	public JLabel getLblDatiAccount() {
		return lblDatiAccount;
	}

	public void setLblDatiAccount(JLabel lblDatiAccount) {
		this.lblDatiAccount = lblDatiAccount;
	}

	public JLabel getLblCambiaPassword() {
		return lblCambiaPassword;
	}

	public void setLblCambiaPassword(JLabel lblCambiaPassword) {
		this.lblCambiaPassword = lblCambiaPassword;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCognome() {
		return txtCognome;
	}

	public void setTxtCognome(JTextField txtCognome) {
		this.txtCognome = txtCognome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	Controller controllerProfilo;

	public Profilo(Controller controller) {
		controllerProfilo = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerProfilo.sfondoTemaScuro);
		setLayout(null);

		lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.logout();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblLogout, controllerProfilo.coloreLabelEntrataTemaChiaro, controllerProfilo.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblLogout, controllerProfilo.coloreLabelTemaChiaro, controllerProfilo.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblLogout, controllerProfilo.coloreLabelPressedTemaChiaro, controllerProfilo.coloreLabelPressedTemaScuro);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblLogout, controllerProfilo.coloreLabelTemaChiaro, controllerProfilo.coloreLabelTemaScuro);
			}
		});
		lblLogout.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setForeground(controllerProfilo.coloreLabelTemaScuro);
		lblLogout.setFont(controllerProfilo.fontLabel);
		lblLogout.setBounds(375, 426, 100, 22);
		add(lblLogout);

		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setForeground(controllerProfilo.coloreScritteTemaScuro);
		txtNome.setFont(controllerProfilo.fontScritte);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(controllerProfilo.trasparente);
		txtNome.setBounds(373, 180, 340, 23);
		add(txtNome);

		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setForeground(controllerProfilo.coloreScritteTemaScuro);
		txtCognome.setFont(controllerProfilo.fontScritte);
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(controllerProfilo.trasparente);
		txtCognome.setBounds(373, 285, 340, 23);
		add(txtCognome);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setForeground(controllerProfilo.coloreScritteTemaScuro);
		txtEmail.setFont(controllerProfilo.fontScritte);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(controllerProfilo.trasparente);
		txtEmail.setBounds(373, 389, 340, 23);
		add(txtEmail);

		lblDatiAccount = new JLabel("");
		lblDatiAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiAccount.setIcon(new ImageIcon(img.datiAccount()));
		lblDatiAccount.setBounds(373, 152, 344, 263);
		add(lblDatiAccount);

		lblCambiaPassword = new JLabel("Cambia password");
		lblCambiaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.mostraPannelli(controllerProfilo.getDashboard().getCambioPassword());
				controllerProfilo.setPannelloPrecedente(13);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblCambiaPassword, controllerProfilo.coloreLabelEntrataTemaChiaro, controllerProfilo.coloreLabelEntrataTemaScuro);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblCambiaPassword, controllerProfilo.coloreLabelTemaChiaro, controllerProfilo.coloreLabelTemaScuro);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblCambiaPassword, controllerProfilo.coloreLabelPressedTemaChiaro, controllerProfilo.coloreLabelPressedTemaScuro);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerProfilo.cambioLabelTema(lblCambiaPassword, controllerProfilo.coloreLabelTemaChiaro, controllerProfilo.coloreLabelTemaScuro);
			}
		});
		lblCambiaPassword.setForeground(controllerProfilo.coloreLabelTemaScuro);
		lblCambiaPassword.setFont(controllerProfilo.fontLabel);
		lblCambiaPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambiaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCambiaPassword.setBounds(584, 430, 129, 14);
		add(lblCambiaPassword);

	}

	
	
}
