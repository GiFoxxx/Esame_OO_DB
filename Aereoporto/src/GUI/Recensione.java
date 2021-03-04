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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Recensione extends JPanel {

	int xMouse;
	int yMouse;
	int xMouseSuSchermo;
	int yMouseSuSchermo;
	int x;
	int y;
	int flag = 0;
	int valutazione = 0;

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
	JLabel lblCommento;

	// GETTER E SETTER
	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

//	public JLabel getLblStelleSelezionate() {
//		return lblStelleSelezionate;
//	}
//
//	public void setLblStelleSelezionate(JLabel lblStelleSelezionate) {
//		this.lblStelleSelezionate = lblStelleSelezionate;
//	}

	public JLabel getLblInviaRecensione() {
		return lblInviaRecensione;
	}

	public void setLblInviaRecensione(JLabel lblInviaRecensione) {
		this.lblInviaRecensione = lblInviaRecensione;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	

	public JLabel getLblCommento() {
		return lblCommento;
	}

	public void setLblCommento(JLabel lblCommento) {
		this.lblCommento = lblCommento;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	Immagini img = new Immagini();
	Controller controllerRecensione;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	public Recensione(Controller controller) {
		controllerRecensione = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRecensione.sfondoTemaScuro);
		setLayout(null);

		lblAnnulla = new JLabel("");
		lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRecensione.setPannelloPrecedente(5);
				controllerRecensione.mostraPannelli(controllerRecensione.getDashboard().getImpostazioni());
				stella0();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla2TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.annulla2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla3TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.annulla3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.annulla2TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.annulla2()));
				}
			}
		});
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.annulla1()));
		lblAnnulla.setBounds(150, 590, 319, 36);
		add(lblAnnulla);

		lblInviaRecensione = new JLabel("");
		lblInviaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInviaRecensione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione2TemaChiaro()));
				} else {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1TemaChiaro()));
				} else {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione3TemaChiaro()));
				} else {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerRecensione.cambioTema()) {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione2TemaChiaro()));
				} else {
					lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione2()));
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
//				votoInviato();
			controllerRecensione.svuotaArea();
			}
		});
		lblInviaRecensione.setHorizontalAlignment(SwingConstants.CENTER);
		lblInviaRecensione.setIcon(new ImageIcon(img.inviaRecensione1()));
		lblInviaRecensione.setBounds(619, 590, 319, 36);
		add(lblInviaRecensione);

		lblStella1 = new JLabel("");
		lblStella1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				riempimentoStella1();
			}
		});
		lblStella1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella1.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella1.setBounds(67, 84, 35, 35);
		add(lblStella1);

		lblStella2 = new JLabel("");
		lblStella2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella2();
			}
		});
		lblStella2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella2.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella2.setBounds(169, 84, 35, 35);
		add(lblStella2);

		lblStella3 = new JLabel("");
		lblStella3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella3();
			}
		});
		lblStella3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella3.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella3.setBounds(271, 84, 35, 35);
		add(lblStella3);

		lblStella4 = new JLabel("");
		lblStella4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella4();
			}
		});
		lblStella4.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella4.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella4.setBounds(373, 84, 35, 35);
		add(lblStella4);

		lblStella5 = new JLabel("");
		lblStella5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella5();
			}
		});
		lblStella5.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella5.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella5.setBounds(475, 84, 35, 35);
		add(lblStella5);

		lblStella6 = new JLabel("");
		lblStella6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella6();
			}
		});
		lblStella6.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella6.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella6.setBounds(577, 84, 35, 35);
		add(lblStella6);

		lblStella7 = new JLabel("");
		lblStella7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella7();
			}
		});
		lblStella7.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella7.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella7.setBounds(679, 84, 35, 35);
		add(lblStella7);

		lblStella8 = new JLabel("");
		lblStella8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella8();
			}
		});
		lblStella8.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella8.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella8.setBounds(781, 84, 35, 35);
		add(lblStella8);

		lblStella9 = new JLabel("");
		lblStella9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella9();
			}
		});
		lblStella9.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella9.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella9.setBounds(883, 84, 35, 35);
		add(lblStella9);

		lblStella10 = new JLabel("");
		lblStella10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella10();
			}
		});
		lblStella10.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella10.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella10.setBounds(985, 84, 35, 35);
		add(lblStella10);

		lblStella11 = new JLabel("");
		lblStella11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella11();
			}
		});
		lblStella11.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella11.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella11.setBounds(67, 209, 35, 35);
		add(lblStella11);

		lblStella12 = new JLabel("");
		lblStella12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella12();
			}
		});
		lblStella12.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella12.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella12.setBounds(169, 209, 35, 35);
		add(lblStella12);

		lblStella13 = new JLabel("");
		lblStella13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella13();
			}
		});
		lblStella13.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella13.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella13.setBounds(271, 209, 35, 35);
		add(lblStella13);

		lblStella14 = new JLabel("");
		lblStella14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella14();
			}
		});
		lblStella14.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella14.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella14.setBounds(373, 209, 35, 35);
		add(lblStella14);

		lblStella15 = new JLabel("");
		lblStella15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella15();
			}
		});
		lblStella15.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella15.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella15.setBounds(475, 209, 35, 35);
		add(lblStella15);

		lblStella16 = new JLabel("");
		lblStella16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella16();
			}
		});
		lblStella16.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella16.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella16.setBounds(577, 209, 35, 35);
		add(lblStella16);

		lblStella17 = new JLabel("");
		lblStella17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella17();
			}
		});
		lblStella17.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella17.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella17.setBounds(679, 209, 35, 35);
		add(lblStella17);

		lblStella18 = new JLabel("");
		lblStella18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella18();
			}
		});
		lblStella18.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella18.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella18.setBounds(781, 209, 35, 35);
		add(lblStella18);

		lblStella19 = new JLabel("");
		lblStella19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella19();
			}
		});
		lblStella19.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella19.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella19.setBounds(883, 209, 35, 35);
		add(lblStella19);

		lblStella20 = new JLabel("");
		lblStella20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella20();
			}
		});
		lblStella20.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella20.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella20.setBounds(985, 209, 35, 35);
		add(lblStella20);

		lblStella21 = new JLabel("");
		lblStella21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella21();
			}
		});
		lblStella21.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella21.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella21.setBounds(67, 334, 35, 35);
		add(lblStella21);

		lblStella22 = new JLabel("");
		lblStella22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella22();
			}
		});
		lblStella22.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella22.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella22.setBounds(169, 334, 35, 35);
		add(lblStella22);

		lblStella23 = new JLabel("");
		lblStella23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella23();
			}
		});
		lblStella23.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella23.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella23.setBounds(271, 334, 35, 35);
		add(lblStella23);

		lblStella24 = new JLabel("");
		lblStella24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella24();
			}
		});
		lblStella24.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella24.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella24.setBounds(373, 334, 35, 35);
		add(lblStella24);

		lblStella25 = new JLabel("");
		lblStella25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella25();
			}
		});
		lblStella25.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella25.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella25.setBounds(475, 334, 35, 35);
		add(lblStella25);

		lblStella26 = new JLabel("");
		lblStella26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella26();
			}
		});
		lblStella26.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella26.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella26.setBounds(577, 334, 35, 35);
		add(lblStella26);

		lblStella27 = new JLabel("");
		lblStella27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella27();
			}
		});
		lblStella27.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella27.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella27.setBounds(679, 334, 35, 35);
		add(lblStella27);

		lblStella28 = new JLabel("");
		lblStella28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella28();
			}
		});
		lblStella28.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella28.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella28.setBounds(781, 334, 35, 35);
		add(lblStella28);

		lblStella29 = new JLabel("");
		lblStella29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella29();
			}
		});
		lblStella29.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella29.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella29.setBounds(883, 334, 35, 35);
		add(lblStella29);

		lblStella30 = new JLabel("");
		lblStella30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stella30();
			}
		});
		lblStella30.setHorizontalAlignment(SwingConstants.CENTER);
		lblStella30.setIcon(new ImageIcon(img.stellaVuota()));
		lblStella30.setBounds(985, 334, 35, 35);
		add(lblStella30);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 430, 1018, 123);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 11));
		textArea.setLocation(37, 0);
		scrollPane.setViewportView(textArea);
		
		lblCommento = new JLabel("Lascia un commento e faremo il possibile per migliorare il programma!");
		lblCommento.setHorizontalAlignment(SwingConstants.LEFT);
		lblCommento.setFont(controllerRecensione.fontLabel);
		lblCommento.setForeground(controllerRecensione.coloreScritteTemaScuro);
		lblCommento.setBounds(44, 410, 525, 19);
		add(lblCommento);

		

	}

	// METODI RIEMPIMENTO STELLE

//	public void votoInviato() {
//		if (valutazione < 18) {
//			lblStelleSelezionate.setText("Voto non sufficiente");
//		} else if (valutazione > 17 && valutazione < 23) {
//			lblStelleSelezionate.setText("Voto discreto");
//		} else if (valutazione > 23 && valutazione < 27) {
//			lblStelleSelezionate.setText("Voto buono");
//		} else {
//			lblStelleSelezionate.setText("Voto ottimo");
//		}
//	}

	public void riempimentoStella1() {
		if (flag == 0) {
			stella1();
			flag = 1;
		} else if (flag == 1) {
			stella0();
			flag = 0;
		}
	}

	public void stella0() {
		lblStella1.setIcon(new ImageIcon(img.stellaVuota()));
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
		flag = 0;
		valutazione = 0;
	}

	public void stella1() {
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
		flag = 0;
		valutazione = 1;
	}

	public void stella2() {
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
		flag = 0;
		valutazione = 2;
	}

	public void stella3() {
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
		flag = 0;
		valutazione = 3;
	}

	public void stella4() {
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
		flag = 0;
		valutazione = 4;
	}

	public void stella5() {
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
		flag = 0;
		valutazione = 5;
	}

	public void stella6() {
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
		flag = 0;
		valutazione = 6;
	}

	public void stella7() {
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
		flag = 0;
		valutazione = 7;
	}

	public void stella8() {
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
		flag = 0;
		valutazione = 8;
	}

	public void stella9() {
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
		flag = 0;
		valutazione = 9;
	}

	public void stella10() {
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
		flag = 0;
		valutazione = 10;
	}

	public void stella11() {
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
		flag = 0;
		valutazione = 11;
	}

	public void stella12() {
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
		flag = 0;
		valutazione = 12;
	}

	public void stella13() {
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
		flag = 0;
		valutazione = 13;
	}

	public void stella14() {
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
		flag = 0;
		valutazione = 14;
	}

	public void stella15() {
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
		flag = 0;
		valutazione = 15;
	}

	public void stella16() {
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
		flag = 0;
		valutazione = 16;
	}

	public void stella17() {
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
		flag = 0;
		valutazione = 17;
	}

	public void stella18() {
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
		flag = 0;
		valutazione = 18;
	}

	public void stella19() {
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
		flag = 0;
		valutazione = 19;
	}

	public void stella20() {
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
		flag = 0;
		valutazione = 20;
	}

	public void stella21() {
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
		flag = 0;
		valutazione = 21;
	}

	public void stella22() {
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
		flag = 0;
		valutazione = 22;
	}

	public void stella23() {
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
		flag = 0;
		valutazione = 23;
	}

	public void stella24() {
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
		flag = 0;
		valutazione = 24;
	}

	public void stella25() {
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
		flag = 0;
		valutazione = 25;
	}

	public void stella26() {
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
		flag = 0;
		valutazione = 26;
	}

	public void stella27() {
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
		flag = 0;
		valutazione = 27;
	}

	public void stella28() {
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
		flag = 0;
		valutazione = 28;
	}

	public void stella29() {
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
		flag = 0;
		valutazione = 29;
	}

	public void stella30() {
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
		flag = 0;
		valutazione = 30;
	}
}
