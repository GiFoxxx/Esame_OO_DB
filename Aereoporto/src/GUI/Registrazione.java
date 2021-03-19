package GUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrazione extends JPanel {

	private Immagini img = new Immagini();

	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	
	private JPasswordField txtPassword;
	private JPasswordField txtRipetiPassword;
	
	private JLabel lblAvanti;
	private JLabel lblInserimentoCredenziali;
	private JLabel lblMostraPassword;
	private JLabel lblCensuraPassword;
	private JLabel lblMostraRipetiPassword;
	private JLabel lblCensuraRipetiPassword;
	private JLabel lblMostraPasswordTT;
	private JLabel lblCensuraPasswordTT;
	private JLabel lblMostraRipetiPasswordTT;
	private JLabel lblCensuraRipetiPasswordTT;
	private JLabel lblIconaErroreNome;
	private JLabel lblIconaErroreCognome;
	private JLabel lblIconaErroreEmail;



	// GETTER E SETTER

	public JLabel getLblAvanti() {
		return lblAvanti;
	}

	public void setLblAvanti(JLabel lblAvanti) {
		this.lblAvanti = lblAvanti;
	}

	public JLabel getLblInserimentoCredenziali() {
		return lblInserimentoCredenziali;
	}

	public void setLblInserimentoCredenziali(JLabel lblInserimentoCredenziali) {
		this.lblInserimentoCredenziali = lblInserimentoCredenziali;
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

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JPasswordField getTxtRipetiPassword() {
		return txtRipetiPassword;
	}

	public void setTxtRipetiPassword(JPasswordField txtRipetiPassword) {
		this.txtRipetiPassword = txtRipetiPassword;
	}



	public JLabel getLblMostraPassword() {
		return lblMostraPassword;
	}

	public void setLblMostraPassword(JLabel lblmostraPassword) {
		this.lblMostraPassword = lblmostraPassword;
	}

	public JLabel getLblCensuraPassword() {
		return lblCensuraPassword;
	}

	public void setLblCensuraPassword(JLabel lblcensuraPassword) {
		this.lblCensuraPassword = lblcensuraPassword;
	}

	public JLabel getLblMostraRipetiPassword() {
		return lblMostraRipetiPassword;
	}

	public void setLblMostraRipetiPassword(JLabel lblmostraRipetiPassword) {
		this.lblMostraRipetiPassword = lblmostraRipetiPassword;
	}

	public JLabel getLblCensuraRipetiPassword() {
		return lblCensuraRipetiPassword;
	}

	public void setLblCensuraRipetiPassword(JLabel lblcensuraRipetiPassword) {
		this.lblCensuraRipetiPassword = lblcensuraRipetiPassword;
	}

	public JLabel getLblMostraPasswordTT() {
		return lblMostraPasswordTT;
	}

	public void setLblMostraPasswordTT(JLabel lblMostraPasswordTT) {
		this.lblMostraPasswordTT = lblMostraPasswordTT;
	}

	public JLabel getLblCensuraPasswordTT() {
		return lblCensuraPasswordTT;
	}

	public void setLblCensuraPasswordTT(JLabel lblCensuraPasswordTT) {
		this.lblCensuraPasswordTT = lblCensuraPasswordTT;
	}

	public JLabel getLblMostraRipetiPasswordTT() {
		return lblMostraRipetiPasswordTT;
	}

	public void setLblMostraRipetiPasswordTT(JLabel lblMostraRipetiPasswordTT) {
		this.lblMostraRipetiPasswordTT = lblMostraRipetiPasswordTT;
	}

	public JLabel getLblCensuraRipetiPasswordTT() {
		return lblCensuraRipetiPasswordTT;
	}

	public void setLblCensuraRipetiPasswordTT(JLabel lblCensuraRipetiPasswordTT) {
		this.lblCensuraRipetiPasswordTT = lblCensuraRipetiPasswordTT;
	}



	public JLabel getLblIconaErroreNome() {
		return lblIconaErroreNome;
	}

	public void setLblIconaErroreNome(JLabel lblIconaErroreNome) {
		this.lblIconaErroreNome = lblIconaErroreNome;
	}

	public JLabel getLblIconaErroreCognome() {
		return lblIconaErroreCognome;
	}

	public void setLblIconaErroreCognome(JLabel lblIconaErroreCognome) {
		this.lblIconaErroreCognome = lblIconaErroreCognome;
	}

	public JLabel getLblIconaErroreEmail() {
		return lblIconaErroreEmail;
	}

	public void setLblIconaErroreEmail(JLabel lblIconaErroreEmail) {
		this.lblIconaErroreEmail = lblIconaErroreEmail;
	}



	Controller controllerRegistrazione;

	public Registrazione(Controller controller) {
		controllerRegistrazione = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRegistrazione.sfondoTemaScuro);
		setLayout(null);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) {
					lblIconaErroreNome.setVisible(false);
				}
			}
		});
		
		lblIconaErroreNome = new JLabel("");
		lblIconaErroreNome.setVisible(false);
		lblIconaErroreNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaErroreNome.setIcon(new ImageIcon(img.errore()));
		lblIconaErroreNome.setBounds(693, 81, 20, 20);
		add(lblIconaErroreNome);
		
		lblIconaErroreCognome = new JLabel("");
		lblIconaErroreCognome.setVisible(false);
		lblIconaErroreCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaErroreCognome.setIcon(new ImageIcon(img.errore()));
		lblIconaErroreCognome.setBounds(693, 186, 20, 20);
		add(lblIconaErroreCognome);
		
		lblIconaErroreEmail = new JLabel("");
		lblIconaErroreEmail.setVisible(false);
		lblIconaErroreEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconaErroreEmail.setIcon(new ImageIcon(img.errore()));
		lblIconaErroreEmail.setBounds(693, 291, 20, 20);
		add(lblIconaErroreEmail);
		
		txtNome.setFont(controllerRegistrazione.fontScritte);
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtNome.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtNome.setBounds(374, 80, 310, 23);
		add(txtNome);

		txtCognome = new JTextField();
		txtCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) {
					lblIconaErroreCognome.setVisible(false);
				}
			}
		});
		txtCognome.setFont(controllerRegistrazione.fontScritte);
		txtCognome.setColumns(10);
		txtCognome.setBorder(null);
		txtCognome.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtCognome.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtCognome.setBounds(374, 185, 310, 23);
		add(txtCognome);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) {
					lblIconaErroreEmail.setVisible(false);
				}
			}
		});
		txtEmail.setFont(controllerRegistrazione.fontScritte);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtEmail.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtEmail.setBounds(374, 290, 310, 23);
		add(txtEmail);

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtPassword.setFont(controllerRegistrazione.fontScritte);
		txtPassword.setBorder(null);
		txtPassword.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtPassword.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtPassword.setBounds(374, 395, 310, 23);
		add(txtPassword);

		txtRipetiPassword = new JPasswordField();
		txtRipetiPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerRegistrazione.registrati();
				}
			}
		});
		txtRipetiPassword.setFont(controllerRegistrazione.fontScritte);
		txtRipetiPassword.setBorder(null);
		txtRipetiPassword.setBackground(controllerRegistrazione.sfondoTemaScuro);
		txtRipetiPassword.setForeground(controllerRegistrazione.coloreScritteTemaScuro);
		txtRipetiPassword.setBounds(374, 500, 310, 23);
		add(txtRipetiPassword);

		lblMostraPassword = new JLabel("");
		lblMostraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraPassword.setVisible(false);
				txtPassword.setEchoChar((char) 0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.setStopMostraPasswordTT(false);
				controllerRegistrazione.mostraTT(lblMostraPasswordTT, controllerRegistrazione.isStopMostraPasswordTT(), img.mostraPasswordTTChiaro(), img.mostraPasswordTT());
				}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.setStopMostraPasswordTT(true);
				controllerRegistrazione.chiudiTT(lblMostraPasswordTT, controllerRegistrazione.isStopMostraPasswordTT());
			}
		});
		lblMostraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraPassword.setBounds(693, 396, 20, 20);
		add(lblMostraPassword);

		lblCensuraPassword = new JLabel("");
		lblCensuraPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraPassword.setVisible(true);
				txtPassword.setEchoChar('●');
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.setStopCensuraPasswordTT(false);
				controllerRegistrazione.mostraTT(lblCensuraPasswordTT, controllerRegistrazione.isStopCensuraPasswordTT(), img.nascondiPasswordTTChiaro(), img.nascondiPasswordTT());
}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.setStopCensuraPasswordTT(true);
				controllerRegistrazione.chiudiTT(lblCensuraPasswordTT, controllerRegistrazione.isStopCensuraPasswordTT());
			}
		});
		lblCensuraPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraPassword.setBounds(693, 395, 20, 20);
		add(lblCensuraPassword);

		lblMostraRipetiPassword = new JLabel("");
		lblMostraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiPassword.setVisible(false);
				txtRipetiPassword.setEchoChar((char) 0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.setStopMostraPasswordTT(false);
				controllerRegistrazione.mostraTT(lblMostraRipetiPasswordTT, controllerRegistrazione.isStopMostraPasswordTT(), img.mostraPasswordTTChiaro(), img.mostraPasswordTT());

			}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.setStopMostraPasswordTT(true);
				controllerRegistrazione.chiudiTT(lblMostraRipetiPasswordTT, controllerRegistrazione.isStopMostraPasswordTT());
			}
		});
		lblMostraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMostraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiPassword.setIcon(new ImageIcon(img.censuraPassword()));
		lblMostraRipetiPassword.setBounds(693, 501, 20, 20);
		add(lblMostraRipetiPassword);

		lblCensuraRipetiPassword = new JLabel("");
		lblCensuraRipetiPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMostraRipetiPassword.setVisible(true);
				txtRipetiPassword.setEchoChar('●');
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.setStopCensuraPasswordTT(false);
				controllerRegistrazione.mostraTT(lblCensuraRipetiPasswordTT, controllerRegistrazione.isStopCensuraPasswordTT(), img.nascondiPasswordTTChiaro(), img.nascondiPasswordTT());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.setStopCensuraPasswordTT(true);
				controllerRegistrazione.chiudiTT(lblCensuraRipetiPasswordTT, controllerRegistrazione.isStopCensuraPasswordTT());
			}
		});
		lblCensuraRipetiPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCensuraRipetiPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiPassword.setIcon(new ImageIcon(img.mostraPassword()));
		lblCensuraRipetiPassword.setBounds(693, 500, 20, 20);
		add(lblCensuraRipetiPassword);

		lblAvanti = new JLabel("");
		lblAvanti.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRegistrazione.registrati();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti2TemaChiaro(), img.avanti2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti1TemaChiaro(), img.avanti1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti3TemaChiaro(), img.avanti3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerRegistrazione.cambioImmagineTema(lblAvanti, img.avanti1TemaChiaro(), img.avanti1());
			}
		});
		lblAvanti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAvanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvanti.setIcon(new ImageIcon(img.avanti1()));
		lblAvanti.setBackground(controllerRegistrazione.trasparente);
		lblAvanti.setBounds(386, 573, 319, 36);
		add(lblAvanti);
		
		lblMostraPasswordTT = new JLabel("");
		lblMostraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraPasswordTT.setBounds(743, 387, 123, 31);
		add(lblMostraPasswordTT);
		
		lblCensuraPasswordTT = new JLabel("");
		lblCensuraPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraPasswordTT.setBounds(743, 387, 130, 31);
		add(lblCensuraPasswordTT);
		
		lblMostraRipetiPasswordTT = new JLabel("");
		lblMostraRipetiPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraRipetiPasswordTT.setBounds(743, 492, 123, 31);
		add(lblMostraRipetiPasswordTT);
		
		lblCensuraRipetiPasswordTT = new JLabel("");
		lblCensuraRipetiPasswordTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCensuraRipetiPasswordTT.setBounds(743, 492, 130, 31);
		add(lblCensuraRipetiPasswordTT);

		lblInserimentoCredenziali = new JLabel("");
		lblInserimentoCredenziali.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoCredenziali.setIcon(new ImageIcon(img.credenzialiRegistrazione()));
		lblInserimentoCredenziali.setBounds(373, 52, 344, 473);
		add(lblInserimentoCredenziali);
	}

}
