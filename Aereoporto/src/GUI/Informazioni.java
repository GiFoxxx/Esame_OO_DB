package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Immagini.Immagini;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Informazioni extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Immagini img = new Immagini();


	Controller controllerInformazioni;
	JLabel lblTornaIndietro;
	JTextArea txtInformazioni;
	
	public JLabel getLblTornaIndietro() {
		return lblTornaIndietro;
	}

	public void setLblTornaIndietro(JLabel lblTornaIndietro) {
		this.lblTornaIndietro = lblTornaIndietro;
	}

	public Informazioni(Controller controller) {
		controllerInformazioni = controller;
		
		setBounds(100, 100, 350, 642);
		setModal(true);
		setFocusable(true);
		setUndecorated(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtInformazioni = new JTextArea();
		txtInformazioni.setEditable(false);
		txtInformazioni.setText("Sviluppatori: \r\nBuonanno Manuel\r\nDe Marco Luigi\r\n\r\nSoftware utilizzati:\r\nAdobe XD\r\nPichon\r\nGitHub\r\npgAdmin\r\n\r\nVersione: v.00439796");
		txtInformazioni.setToolTipText("");
		txtInformazioni.setBounds(10, 11, 330, 503);
		contentPanel.add(txtInformazioni);
		
		lblTornaIndietro = new JLabel("");
		lblTornaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerInformazioni.annullaInformazioni();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				controllerInformazioni.cambioImmagineTema(lblTornaIndietro, img.tornaIndietro2TemaChiaro(), img.tornaIndietro2());

			}
			@Override
			public void mouseExited(MouseEvent e) {
				controllerInformazioni.cambioImmagineTema(lblTornaIndietro, img.tornaIndietro1TemaChiaro(), img.tornaIndietro1());

			}
			@Override
			public void mousePressed(MouseEvent e) {
				controllerInformazioni.cambioImmagineTema(lblTornaIndietro, img.tornaIndietro3TemaChiaro(), img.tornaIndietro3());

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerInformazioni.cambioImmagineTema(lblTornaIndietro, img.tornaIndietro2TemaChiaro(), img.tornaIndietro2());

			}
		});
		lblTornaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro1()));
		lblTornaIndietro.setBounds(16, 566, 319, 36);
		contentPanel.add(lblTornaIndietro);
	
		
		controllerInformazioni.centramentoJDialog(this);
	}
}
