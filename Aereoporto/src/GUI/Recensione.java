package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class Recensione extends JPanel {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	JLabel lblAnnulla;
	JLabel lblStella1;
	JLabel lblStella2;
	JLabel lblStella3;
	JLabel lblStella4;
	JLabel lblStella5;
	JLabel lblStella6;
	JLabel lblStella7;
	JLabel lblStella8;
	JLabel lblStella9;
	JLabel lblStella10;
	JLabel lblStella11;
	JLabel lblStella12;
	JLabel lblStella13;
	JLabel lblStella14;
	JLabel lblStella15;
	JLabel lblStella16;
	JLabel lblStella17;
	JLabel lblStella18;
	JLabel lblStella19;
	JLabel lblStella20;
	JLabel lblStella21;
	JLabel lblStella22;
	JLabel lblStella23;
	JLabel lblStella24;
	JLabel lblStella25;
	JLabel lblStella26;
	JLabel lblStella27;
	JLabel lblStella28;
	JLabel lblStella29;
	JLabel lblStella30;

	JLabel lblInviaRecensione;

	Immagini img = new Immagini();
	Controller controllerRecensione;

	public Recensione(Controller controller) {
		controllerRecensione = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRecensione.sfondo);
		setLayout(null);

		lblAnnulla = new JLabel("");
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRecensione.annullaUscita();
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
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
		lblAnnulla.setBounds(200, 513, 174, 47);
		add(lblAnnulla);

		lblInviaRecensione = new JLabel("");
		lblInviaRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione3()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1()));
			}
		});
		lblInviaRecensione.setHorizontalAlignment(SwingConstants.CENTER);
		lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1()));
		lblInviaRecensione.setBounds(720, 513, 174, 47);
		add(lblInviaRecensione);
		
		lblStella1 = new JLabel("");
		lblStella1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella3.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella1.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella1.setBounds(67, 100, 35, 35);
		add(lblStella1);
		
		lblStella2 = new JLabel("");
		lblStella2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella2.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella2.setBounds(169, 100, 35, 35);
		add(lblStella2);
		
		lblStella3 = new JLabel("");
		lblStella3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella3.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella3.setBounds(271, 100, 35, 35);
		add(lblStella3);
		
		lblStella4 = new JLabel("");
		lblStella4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella4.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella4.setBounds(373, 100, 35, 35);
		add(lblStella4);
		
		lblStella5 = new JLabel("");
		lblStella5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella5.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella5.setBounds(475, 100, 35, 35);
		add(lblStella5);
		
		lblStella6 = new JLabel("");
		lblStella6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella6.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella6.setBounds(577, 100, 35, 35);
		add(lblStella6);
		
		lblStella7 = new JLabel("");
		lblStella7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella7.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella7.setBounds(679, 100, 35, 35);
		add(lblStella7);
		
		lblStella8 = new JLabel("");
		lblStella8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella8.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella8.setBounds(781, 100, 35, 35);
		add(lblStella8);
		
		lblStella9 = new JLabel("");
		lblStella9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella9.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella9.setBounds(883, 100, 35, 35);
		add(lblStella9);
		
		lblStella10 = new JLabel("");
		lblStella10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella10.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella10.setBounds(985, 100, 35, 35);
		add(lblStella10);
		
		lblStella11 = new JLabel("");
		lblStella11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella11.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella11.setBounds(67, 225, 35, 35);
		add(lblStella11);
		
		lblStella12 = new JLabel("");
		lblStella12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella12.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella12.setBounds(169, 225, 35, 35);
		add(lblStella12);
		
		lblStella13 = new JLabel("");
		lblStella13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella13.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella13.setBounds(271, 225, 35, 35);
		add(lblStella13);
		
		lblStella14 = new JLabel("");
		lblStella14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella14.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella14.setBounds(373, 225, 35, 35);
		add(lblStella14);

		lblStella15 = new JLabel("");
		lblStella15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella15.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella15.setBounds(475, 225, 35, 35);
		add(lblStella15);
		
		lblStella16 = new JLabel("");
		lblStella16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella16.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella16.setBounds(577, 225, 35, 35);
		add(lblStella16);
		
		lblStella17 = new JLabel("");
		lblStella17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella17.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella17.setBounds(679, 225, 35, 35);
		add(lblStella17);
		
		lblStella18 = new JLabel("");
		lblStella18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella18.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella18.setBounds(781, 225, 35, 35);
		add(lblStella18);
		
		lblStella19 = new JLabel("");
		lblStella19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella19.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella19.setBounds(883, 225, 35, 35);
		add(lblStella19);
		
		lblStella20 = new JLabel("");
		lblStella20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella20.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella20.setBounds(985, 225, 35, 35);
		add(lblStella20);
		
		lblStella21 = new JLabel("");
		lblStella21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella21.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella21.setBounds(67, 350, 35, 35);
		add(lblStella21);
		
		
		lblStella22 = new JLabel("");
		lblStella22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella22.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella22.setBounds(169, 350, 35, 35);
		add(lblStella22);
		
		lblStella23 = new JLabel("");
		lblStella23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella23.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella23.setBounds(271, 350, 35, 35);
		add(lblStella23);
		
		lblStella24 = new JLabel("");
		lblStella24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella24.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella24.setBounds(373, 350, 35, 35);
		add(lblStella24);
		
		lblStella25 = new JLabel("");
		lblStella25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella25.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella25.setBounds(475, 350, 35, 35);
		add(lblStella25);
		
		lblStella26 = new JLabel("");
		lblStella26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella26.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella26.setBounds(577, 350, 35, 35);
		add(lblStella26);
		
		lblStella27 = new JLabel("");
		lblStella27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella27.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella27.setBounds(679, 350, 35, 35);
		add(lblStella27);
		
		lblStella28 = new JLabel("");
		lblStella28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella28.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella28.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella28.setBounds(781, 350, 35, 35);
		add(lblStella28);
		
		lblStella29 = new JLabel("");
		lblStella29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella28.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella29.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
			}
		});
		lblStella29.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella29.setBounds(883, 350, 35, 35);
		add(lblStella29);

		
		lblStella30 = new JLabel("");
		lblStella30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella6.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella7.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella8.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella9.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella10.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella11.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella12.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella13.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella14.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella15.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella16.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella17.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella18.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella19.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella20.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella21.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella28.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella29.setIcon(new ImageIcon(img.stellaPiena()));
				lblStella30.setIcon(new ImageIcon(img.stellaPiena()));
			}
		});
		lblStella30.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella30.setBounds(985, 350, 35, 35);
		add(lblStella30);

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);
		lblLayout.setBounds(0, 0, 1090, 642);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondo()));
		add(lblLayout);

	}
	
	
}
