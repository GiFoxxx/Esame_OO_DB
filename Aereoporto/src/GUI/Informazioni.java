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
		
		JTextArea txtInformazioni = new JTextArea();
		txtInformazioni.setEditable(false);
		txtInformazioni.setText("Sviluppatori: \r\nBuonanno Manuel\r\nDe Marco Luigi\r\n\r\nSoftware utilizzati:\r\nAdobe XD\r\nPichon\r\nGitHub\r\npgAdmin\r\n\r\n");
		txtInformazioni.setToolTipText("");
		txtInformazioni.setBounds(10, 11, 330, 503);
		contentPanel.add(txtInformazioni);
		
		JLabel lblTornaIndietro = new JLabel("");
		lblTornaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerInformazioni.annullaInformazioni();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro2()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro1()));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro2()));
			}
		});
		lblTornaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTornaIndietro.setIcon(new ImageIcon(img.tornaIndietro1()));
		lblTornaIndietro.setBounds(16, 566, 319, 36);
		contentPanel.add(lblTornaIndietro);
	
		
		controllerInformazioni.centramentoJDialog(this);
	}
}
