package GUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classi.Gate;
import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class UtilizzoGate extends JPanel {

	String colonneTabellaGate[] = { "Codice Gate", "Numero Porta" };
	String colonneTabellaUtilizzi[] = { "Gate Selezionato", "Utilizzo Stimato", "Utilizzo Effettivo" };

	Gate[] row = new Gate[4];

	DefaultTableModel modelloTabellaGate = new DefaultTableModel(colonneTabellaGate, 0);
	DefaultTableModel modelloTabellaUtilizzi = new DefaultTableModel(colonneTabellaUtilizzi, 0);

	List<Gate> ListaGate = new ArrayList<Gate>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;
	private JDateChooser dataUtilizzo;

	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNumeroPorta;
	private JLabel lblCodiceGate;
	private JLabel lblSelezionaData;
	private JLabel lblCalcolaUtilizzo;
	private JLabel lblGiorno;
	private JLabel lblSettimana;
	private JLabel lblMese;
	private JLabel lblSvuota;

	private JScrollPane scrollPaneTabellaGate;
	private JTable tabellaGate;
	private JScrollPane scrollPaneTabellaUtilizzi;
	private JTable tabellaUtilizzi;

	// GETTER E SETTER
	public DefaultTableModel getModelloTabellaGate() {
		return modelloTabellaGate;
	}

	public void setModelloTabellaGate(DefaultTableModel modello) {
		this.modelloTabellaGate = modello;
	}

	public Object[] getRow() {
		return row;
	}

	public JTextField getTxtBarraRicerca() {
		return txtBarraRicerca;
	}

	public void setTxtBarraRicerca(JTextField txtBarraRicerca) {
		this.txtBarraRicerca = txtBarraRicerca;
	}

	public JLabel getLblimgfrecciaIndietro() {
		return lblimgfrecciaIndietro;
	}

	public void setLblimgfrecciaIndietro(JLabel lblimgfrecciaIndietro) {
		this.lblimgfrecciaIndietro = lblimgfrecciaIndietro;
	}

	public JLabel getLblBarraRicerca() {
		return lblBarraRicerca;
	}

	public void setLblBarraRicerca(JLabel lblBarraRicerca) {
		this.lblBarraRicerca = lblBarraRicerca;
	}

	public JLabel getLblNumeroPorta() {
		return lblNumeroPorta;
	}

	public void setLblNumeroPorta(JLabel lblNumeroPorta) {
		this.lblNumeroPorta = lblNumeroPorta;
	}

	public JLabel getLblCodiceGate() {
		return lblCodiceGate;
	}

	public void setLblCodiceGate(JLabel lblCodiceGate) {
		this.lblCodiceGate = lblCodiceGate;
	}

	public JTextField getTxtCodiceGate() {
		return txtCodiceGate;
	}

	public void setTxtCodiceGate(JTextField txtCodiceGate) {
		this.txtCodiceGate = txtCodiceGate;
	}

	public JTextField getTxtNumeroPorta() {
		return txtNumeroPorta;
	}

	public void setTxtNumeroPorta(JTextField txtNumeroPorta) {
		this.txtNumeroPorta = txtNumeroPorta;
	}

	public JTable getTabellaGate() {
		return tabellaGate;
	}

	public void setTabellaGate(JTable table) {
		this.tabellaGate = table;
	}

	public JLabel getLblSvuota() {
		return lblSvuota;
	}

	public void setLblSvuota(JLabel lblSvuota) {
		this.lblSvuota = lblSvuota;
	}

	Controller controllerTempisticheGate;

	public UtilizzoGate(Controller controller) {
		controllerTempisticheGate = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerTempisticheGate.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerTempisticheGate.setPannelloPrecedente(1);
				controllerTempisticheGate.mostraPannelli(controllerTempisticheGate.getDashboard().getHome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(30, 35, 47, 30);
		add(lblimgfrecciaIndietro);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerTempisticheGate.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerTempisticheGate.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerTempisticheGate.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		scrollPaneTabellaGate = new JScrollPane();
		scrollPaneTabellaGate.setFont(controllerTempisticheGate.fontLabel);
		scrollPaneTabellaGate.setEnabled(false);
		scrollPaneTabellaGate.setBounds(30, 85, 318, 330);
		add(scrollPaneTabellaGate);

		tabellaGate = new JTable();
		tabellaGate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabellaGate.getSelectedRow();
				txtCodiceGate.setText(modelloTabellaGate.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modelloTabellaGate.getValueAt(t, 1).toString());
			}
		});
		modelloTabellaGate.setColumnIdentifiers(colonneTabellaGate);
		tabellaGate.setModel(modelloTabellaGate);
		scrollPaneTabellaGate.setViewportView(tabellaGate);

		scrollPaneTabellaUtilizzi = new JScrollPane();
		scrollPaneTabellaUtilizzi.setFont(controllerTempisticheGate.fontLabel);
		scrollPaneTabellaUtilizzi.setEnabled(false);
		scrollPaneTabellaUtilizzi.setBounds(358, 85, 702, 330);
		add(scrollPaneTabellaUtilizzi);

		tabellaUtilizzi = new JTable();
		modelloTabellaUtilizzi.setColumnIdentifiers(colonneTabellaUtilizzi);
		tabellaUtilizzi.setModel(modelloTabellaUtilizzi);
		scrollPaneTabellaUtilizzi.setViewportView(tabellaUtilizzi);

		lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(controllerTempisticheGate.fontLabel);
		lblNumeroPorta.setForeground(controllerTempisticheGate.coloreScritteTemaScuro);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(30, 493, 130, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerTempisticheGate.aggiungiGate();
				}
			}
		});
		txtNumeroPorta.setFont(controllerTempisticheGate.fontScritteGestioni);
		txtNumeroPorta.setForeground(controllerTempisticheGate.coloreScritteSuBiancoTemaScuro);
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(170, 493, 178, 20);
		add(txtNumeroPorta);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerTempisticheGate.fontLabel);
		lblCodiceGate.setForeground(controllerTempisticheGate.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 461, 130, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerTempisticheGate.aggiungiGate();
				}
			}
		});
		txtCodiceGate.setFont(controllerTempisticheGate.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerTempisticheGate.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(170, 462, 178, 20);
		add(txtCodiceGate);

		lblSvuota = new JLabel("");
		lblSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerTempisticheGate.svuotaCampiGestioneGate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(194, 556, 130, 36);
		add(lblSvuota);
		
		lblGiorno = new JLabel("");
		lblGiorno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGiorno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblGiorno.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblGiorno.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblGiorno.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblGiorno.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblGiorno.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblGiorno.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblGiorno.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblGiorno.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblGiorno.setIcon(new ImageIcon(img.svuota1()));
		lblGiorno.setBounds(868, 464, 130, 36);
		add(lblGiorno);
		
		lblSettimana = new JLabel("");
		lblSettimana.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSettimana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSettimana.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSettimana.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSettimana.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSettimana.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSettimana.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSettimana.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblSettimana.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSettimana.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblSettimana.setIcon(new ImageIcon(img.svuota1()));
		lblSettimana.setBounds(868, 510, 130, 36);
		add(lblSettimana);
		
		lblMese = new JLabel("");
		lblMese.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMese.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblMese.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblMese.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblMese.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblMese.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblMese.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblMese.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTempisticheGate.cambioTema()) {
					lblMese.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblMese.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblMese.setIcon(new ImageIcon(img.svuota1()));
		lblMese.setBounds(868, 556, 130, 36);
		add(lblMese);

		dataUtilizzo = new JDateChooser();
		dataUtilizzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}
			}
		});
		dataUtilizzo.setDateFormatString("dd/MM/yyyy");
		dataUtilizzo.setForeground(controllerTempisticheGate.coloreScritteSuBiancoTemaScuro);
		dataUtilizzo.setFont(controllerTempisticheGate.fontScritteGestioni);
		dataUtilizzo.setBounds(500, 461, 121, 20);
		add(dataUtilizzo);

		lblSelezionaData = new JLabel(
				"Seleziona la data per sapere l'utilizzo stimato ed effettivo del gate selezionato");
		lblSelezionaData.setBounds(368, 426, 372, 24);
		lblSelezionaData.setForeground(controllerTempisticheGate.coloreScritteTemaScuro);
		lblSelezionaData.setFont(controllerTempisticheGate.fontLabel);
		add(lblSelezionaData);
		
		lblCalcolaUtilizzo = new JLabel("Calcola utilizzo per:");
		lblCalcolaUtilizzo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcolaUtilizzo.setForeground(controllerTempisticheGate.coloreScritteTemaScuro);
		lblCalcolaUtilizzo.setFont(controllerTempisticheGate.fontLabel);
		lblCalcolaUtilizzo.setBounds(807, 426, 253, 24);
		add(lblCalcolaUtilizzo);
		
		

		caricaTabella();

	}

	// METODI
	public void caricaTabella() {
		try {
			this.ListaGate = controllerTempisticheGate.implementazioneGateDAO().stampaGate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modelloTabellaGate.setNumRows(0);
		for (Gate dato : this.ListaGate) {
			this.modelloTabellaGate.addRow(
					new Object[] { dato.getCodiceGate(), dato.getNumeroPorta(), dato.getTempoImbarcoStimato() });
		}
		tabellaGate.setModel(modelloTabellaGate);
	}

	private void ricerca() {
		DefaultTableModel table = (DefaultTableModel) tabellaGate.getModel();
		String ricerca = txtBarraRicerca.getText();
		TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
		tabellaGate.setRowSorter(trm);
		trm.setRowFilter(RowFilter.regexFilter(ricerca));
	}
}
