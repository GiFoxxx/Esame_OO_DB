package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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

public class Recensione extends JDialog {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;

	JLabel lblLayout;
	private boolean flag = true;

	Immagini img = new Immagini();
	Controller controllerRecensione;

	public Recensione(Controller controller) {
		controllerRecensione = controller;

		setModal(true);

		setBounds(100, 100, 500, 300);
		setFocusable(true);
		setUndecorated(true);
		
		JLabel lblStella1 = new JLabel("");
		JLabel lblStella2 = new JLabel("");
		JLabel lblStella3 = new JLabel("");
		JLabel lblStella4 = new JLabel("");
		JLabel lblStella5 = new JLabel("");
		JLabel lblStella6 = new JLabel("");
		JLabel lblStella7 = new JLabel("");
		JLabel lblStella8 = new JLabel("");
		JLabel lblStella9 = new JLabel("");
		JLabel lblStella10 = new JLabel("");
		JLabel lblStella11 = new JLabel("");
		JLabel lblStella12 = new JLabel("");
		JLabel lblStella13 = new JLabel("");
		JLabel lblStella14 = new JLabel("");
		JLabel lblStella15 = new JLabel("");
		JLabel lblStella16 = new JLabel("");
		JLabel lblStella17 = new JLabel("");
		JLabel lblStella18 = new JLabel("");
		JLabel lblStella19 = new JLabel("");
		JLabel lblStella20 = new JLabel("");
		JLabel lblStella21 = new JLabel("");
		JLabel lblStella22 = new JLabel("");
		JLabel lblStella23 = new JLabel("");
		JLabel lblStella24 = new JLabel("");
		JLabel lblStella25 = new JLabel("");
		JLabel lblStella26 = new JLabel("");
		JLabel lblStella27 = new JLabel("");
		JLabel lblStella28 = new JLabel("");
		JLabel lblStella29 = new JLabel("");
		JLabel lblStella30 = new JLabel("");



		getContentPane().setLayout(null);
		{

			JLabel lblSpostaUscita = new JLabel("");
			lblSpostaUscita.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpostaUscita.setIcon(new ImageIcon(img.spostaUscita()));
			lblSpostaUscita.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent spostaDashboard) {
					x = spostaDashboard.getXOnScreen();
					y = spostaDashboard.getYOnScreen();
					xMouseSuSchermo = spostaDashboard.getXOnScreen();
					yMouseSuSchermo = spostaDashboard.getYOnScreen();
					setLocation(x - xMouse, y - yMouse);

				}
			});
			lblSpostaUscita.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent prendiPosizioneMouse) {

					xMouse = prendiPosizioneMouse.getX();
					yMouse = prendiPosizioneMouse.getY();

				}
			});

			JLabel lblX = new JLabel("");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Recensione.this.dispose();
					controllerRecensione.getDashboard().dispose();
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X2()));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X1()));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X3()));
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lblX.setIcon(new ImageIcon(img.X1()));
				}
			});

			JLabel lblAnnulla = new JLabel("");
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
				}
			});
			
			JLabel lblInviaRecensione = new JLabel("");
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
			lblInviaRecensione.setBounds(40, 232, 174, 47);
			getContentPane().add(lblInviaRecensione);
			lblStella11.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella11.setBounds(68, 94, 35, 35);
			getContentPane().add(lblStella11);
			
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
				}
			});
			lblStella12.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella12.setBounds(118, 94, 35, 35);
			getContentPane().add(lblStella12);
			
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
				}
			});
			lblStella13.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella13.setBounds(188, 94, 35, 35);
			getContentPane().add(lblStella13);
			
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
				}
			});
			lblStella14.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella14.setBounds(262, 94, 35, 35);
			getContentPane().add(lblStella14);
			
			lblStella2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella2.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella2.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella2.setBounds(68, 48, 35, 35);
			getContentPane().add(lblStella2);
			
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
				}
			});
			lblStella15.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella15.setBounds(323, 94, 35, 35);
			getContentPane().add(lblStella15);
			
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
				}
			});
			lblStella8.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella8.setBounds(415, 48, 35, 35);
			getContentPane().add(lblStella8);
			
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
				}
			});
			lblStella10.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella10.setBounds(10, 94, 35, 35);
			getContentPane().add(lblStella10);
			
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
				}
			});
			lblStella16.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella16.setBounds(368, 94, 35, 35);
			getContentPane().add(lblStella16);
			
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
				}
			});
			lblStella17.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella17.setBounds(415, 94, 35, 35);
			getContentPane().add(lblStella17);
			
			lblStella1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella1.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella1.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella1.setBounds(10, 48, 35, 35);
			getContentPane().add(lblStella1);
			
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
				}
			});
			lblStella18.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella18.setBounds(460, 94, 35, 35);
			getContentPane().add(lblStella18);
			
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
				}
			});
			lblStella9.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella9.setBounds(460, 48, 35, 35);
			getContentPane().add(lblStella9);
			
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
				}
			});
			lblStella19.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella19.setBounds(20, 140, 35, 35);
			getContentPane().add(lblStella19);
			
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
				}
			});
			lblStella20.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella20.setBounds(68, 140, 35, 35);
			getContentPane().add(lblStella20);
			
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
				}
			});
			lblStella7.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella7.setBounds(370, 48, 35, 35);
			getContentPane().add(lblStella7);
			
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
				}
			});
			lblStella21.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella21.setBounds(128, 140, 35, 35);
			getContentPane().add(lblStella21);
			
			lblStella6.addMouseListener(new MouseAdapter() {
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
				}
			});
			lblStella6.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella6.setBounds(313, 48, 35, 35);
			getContentPane().add(lblStella6);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella22.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella22.setBounds(198, 140, 35, 35);
			getContentPane().add(lblStella22);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella23.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella23.setBounds(252, 140, 35, 35);
			getContentPane().add(lblStella23);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella24.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella24.setBounds(323, 140, 35, 35);
			getContentPane().add(lblStella24);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella25.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella25.setBounds(368, 151, 35, 35);
			getContentPane().add(lblStella25);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella26.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella26.setBounds(415, 151, 35, 35);
			getContentPane().add(lblStella26);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella27.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella27.setBounds(460, 151, 35, 35);
			getContentPane().add(lblStella27);
			
			lblStella4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella4.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella4.setBounds(188, 48, 35, 35);
			getContentPane().add(lblStella4);
			
			lblStella5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella4.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella5.setIcon(new ImageIcon(img.stellaPiena()));
				
				}
			});
			lblStella5.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella5.setBounds(252, 48, 35, 35);
			getContentPane().add(lblStella5);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella28.setIcon(new ImageIcon(img.stellaPiena()));
				
				}
			});
			lblStella28.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella28.setBounds(30, 186, 35, 35);
			getContentPane().add(lblStella28);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella23.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella24.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella25.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella26.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella27.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella28.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella29.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella29.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella29.setBounds(78, 186, 35, 35);
			getContentPane().add(lblStella29);
			
			lblStella3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStella1.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella2.setIcon(new ImageIcon(img.stellaPiena()));
					lblStella3.setIcon(new ImageIcon(img.stellaPiena()));
				}
			});
			lblStella3.setHorizontalAlignment(SwingConstants.CENTER);
			lblStella3.setIcon(new ImageIcon(img.stellaVuota()));
			lblStella3.setBounds(129, 48, 35, 35);
			getContentPane().add(lblStella3);
			
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
//					lblStella22.setIcon(new ImageIcon(img.stellaPiena()));
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
			lblStella30.setBounds(138, 186, 35, 35);
			getContentPane().add(lblStella30);
			lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
			lblAnnulla.setBounds(301, 232, 174, 47);
			getContentPane().add(lblAnnulla);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setIcon(new ImageIcon(img.X1()));
			lblX.setBounds(449, 0, 51, 37);
			getContentPane().add(lblX);
			lblSpostaUscita.setEnabled(false);
			lblSpostaUscita.setBounds(0, 0, 500, 37);
			getContentPane().add(lblSpostaUscita);

		}
		
		

		lblLayout = new JLabel("");
		lblLayout.setBorder(null);

		lblLayout.setBounds(0, 0, 500, 300);
		lblLayout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayout.setIcon(new ImageIcon(img.sfondoUscita()));
		getContentPane().add(lblLayout);

		controllerRecensione.centramentoJDialog(this);
	}
}
