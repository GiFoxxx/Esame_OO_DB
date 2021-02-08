package GUI;

import javax.swing.JPanel;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Profilo extends JPanel {

	private Immagini img = new Immagini();
	
	ArrayList<Object[]> DatiAccount = new ArrayList<>();

	Controller controllerProfilo;
	
	private JLabel lblLogout;
	private JLabel lblDatiAccount;
	private JTextField txtfldNome;
	private JTextField txtfldCognome;
	private JTextField txtfldEmail;
	
	public JTextField getTxtfldNome() {
		return txtfldNome;
	}

	public void setTxtfldNome(JTextField txtfldNome) {
		this.txtfldNome = txtfldNome;
	}

	public JTextField getTxtfldCognome() {
		return txtfldCognome;
	}

	public void setTxtfldCognome(JTextField txtfldCognome) {
		this.txtfldCognome = txtfldCognome;
	}

	public JTextField getTxtfldEmail() {
		return txtfldEmail;
	}

	public void setTxtfldEmail(JTextField txtfldEmail) {
		this.txtfldEmail = txtfldEmail;
	}

	public Profilo(Controller controller) {
		controllerProfilo = controller;

		setBounds(0, 0, 1090, 634);
		setBackground(controllerProfilo.sfondo);
		setLayout(null);
		
		lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.logout();
			}
		});
		
		txtfldEmail = new JTextField();
		txtfldEmail.setForeground(Color.GRAY);
		txtfldEmail.setFont(null);
		txtfldEmail.setColumns(10);
		txtfldEmail.setBorder(null);
		txtfldEmail.setBackground((Color) null);
		txtfldEmail.setBounds(657, 345, 340, 23);
		add(txtfldEmail);
		
		txtfldNome = new JTextField();
		txtfldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				txtfldNome.getText(controllerProfilo.stampaDatiAccount());
//				txtfldCognome.getText();
//				txtfldEmail.getText();
			}
		});
		txtfldNome.setForeground(Color.GRAY);
		txtfldNome.setFont(null);
		txtfldNome.setColumns(10);
		txtfldNome.setBorder(null);
		txtfldNome.setBackground((Color) null);
		txtfldNome.setBounds(657, 136, 340, 23);
		add(txtfldNome);
		
		txtfldCognome = new JTextField();
		txtfldCognome.setForeground(Color.GRAY);
		txtfldCognome.setFont(null);
		txtfldCognome.setColumns(10);
		txtfldCognome.setBorder(null);
		txtfldCognome.setBackground((Color) null);
		txtfldCognome.setBounds(657, 241, 340, 23);
		add(txtfldCognome);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setForeground(controllerProfilo.coloreScritte);
		lblLogout.setFont(controllerProfilo.fontScritte);
		lblLogout.setBounds(968, 30, 100, 22);
		add(lblLogout);
		
		lblDatiAccount = new JLabel("");
		lblDatiAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiAccount.setIcon(new ImageIcon(img.datiAccount()));
		lblDatiAccount.setBounds(657, 108, 344, 263);
		add(lblDatiAccount);
		
		JLabel lblNewLabel = new JLabel("Cambia password");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerProfilo.mostraPannelli(controllerProfilo.getDashboard().getCambioPassword());
			}
		});
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(658, 422, 129, 34);
		add(lblNewLabel);
		
		JLabel lblEmailDimenticata = new JLabel("Salva");
		lblEmailDimenticata.setForeground(Color.LIGHT_GRAY);
		lblEmailDimenticata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerProfilo.modificaUtente();
			}
		});
		lblEmailDimenticata.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailDimenticata.setBounds(868, 422, 129, 34);
		add(lblEmailDimenticata);
	
	}
}
