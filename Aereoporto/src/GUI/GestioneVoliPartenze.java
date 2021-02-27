package GUI;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Classi.VoloPartenze;
import Controller.Controller;
import Immagini.Immagini;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;

public class GestioneVoliPartenze extends JPanel {

	String colonne[] = { "Codice Volo Partenze", "Compagnia Aerea", "N°Gate", "Citta di Arrivo", "Data Partenza", "Orario Partenza", "Apertura Gate", "Chiusura Gate", "Numero Prenotazioni", "Ritardo" };
	Object[] row = new Object[11];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoliPartenze = new ArrayList<>();
	private Immagini img = new Immagini();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private JTextField txtCodiceVoloPartenze;
	private JDateChooser dateDataPartenza;
	private JTextField txtCodiceTratta;
	private JTextField txtCodiceGate;
	private JTextField txtOraPartenza;
	private JTextField txtMinutoPartenza;
	private JTextField txtNumeroPrenotazioni;
	private JTextField txtRitardo;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceVoloPartenze;
	private JLabel lblCodiceTratta;
	private JLabel lblDataPartenza;
	private JLabel lblOrarioPartenza;
	private JLabel lblDuePuntiPartenza;
	private JLabel lblGate;
	private JLabel lblNumeroPrenotazioni;
	private JLabel lblRitardo;

	private JComboBox<String> comboBoxNumeroPorta;
	private JComboBox<String> comboBoxCittaArrivo;
	
	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
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

	public JLabel getLblCodiceVoloPartenze() {
		return lblCodiceVoloPartenze;
	}

	public void setLblCodiceVoloPartenze(JLabel lblCodiceVoloPartenze) {
		this.lblCodiceVoloPartenze = lblCodiceVoloPartenze;
	}

	public JLabel getLblDataPartenza() {
		return lblDataPartenza;
	}

	public void setLblDataPartenza(JLabel lblDataPartenza) {
		this.lblDataPartenza = lblDataPartenza;
	}

	public JLabel getLblOraPartenza() {
		return lblOrarioPartenza;
	}

	public void setLblOraPartenza(JLabel lblOraPartenza) {
		this.lblOrarioPartenza = lblOraPartenza;
	}

	public JLabel getLblDuePuntiPartenza() {
		return lblDuePuntiPartenza;
	}

	public void setLblDuePuntiPartenza(JLabel lblDuePuntiPartenza) {
		this.lblDuePuntiPartenza = lblDuePuntiPartenza;
	}

	public JLabel getLblNumeroPrenoazioni() {
		return lblNumeroPrenotazioni;
	}

	public void setLblNumeroPrenoazioni(JLabel lblNumeroPrenoazioni) {
		this.lblNumeroPrenotazioni = lblNumeroPrenoazioni;
	}

	public JLabel getLblRitardo() {
		return lblRitardo;
	}

	public void setLblRitardo(JLabel lblRitardo) {
		this.lblRitardo = lblRitardo;
	}

	public JTextField getTxtCodiceVoloPartenze() {
		return txtCodiceVoloPartenze;
	}

	public void setTxtCodiceVoloPartenze(JTextField txtCodiceTratta) {
		this.txtCodiceVoloPartenze = txtCodiceTratta;
	}

	public JDateChooser getDateDataPartenza() {
		return dateDataPartenza;
	}

	public void setDateDataPartenza(JDateChooser dateDataPartenza) {
		this.dateDataPartenza = dateDataPartenza;
	}

	public JTextField getTxtOraPartenza() {
		return txtOraPartenza;
	}

	public void setTxtOraPartenza(JTextField txtOrarioPartenza) {
		this.txtOraPartenza = txtOrarioPartenza;
	}

	public JTextField getTxtMinutoPartenza() {
		return txtMinutoPartenza;
	}

	public void setTxtMinutoPartenza(JTextField txtMinutoPartenza) {
		this.txtMinutoPartenza = txtMinutoPartenza;
	}

	public JTextField getTxtNumeroPrenotazioni() {
		return txtNumeroPrenotazioni;
	}

	public void setTxtNumeroPrenotazioni(JTextField txtNumeroPrenotazioni) {
		this.txtNumeroPrenotazioni = txtNumeroPrenotazioni;
	}

	public JTextField getTxtRitardo() {
		return txtRitardo;
	}

	public void setTxtRitardo(JTextField txtRitardo) {
		this.txtRitardo = txtRitardo;
	}

	public JTextField getTxtCodiceGate() {
		return txtCodiceGate;
	}

	public void setTxtCodiceGate(JTextField txtCodiceGate) {
		this.txtCodiceGate = txtCodiceGate;
	}

	public JLabel getLblOrarioPartenza() {
		return lblOrarioPartenza;
	}

	public void setLblOrarioPartenza(JLabel lblOrarioPartenza) {
		this.lblOrarioPartenza = lblOrarioPartenza;
	}

	public JLabel getLblGate() {
		return lblGate;
	}

	public void setLblGate(JLabel lblGate) {
		this.lblGate = lblGate;
	}

	public JTextField getTxtCodiceTratta() {
		return txtCodiceTratta;
	}

	public void setTxtCodiceTratta(JTextField txtCodiceTratta) {
		this.txtCodiceTratta = txtCodiceTratta;
	}

	public JLabel getLblCodiceTratta() {
		return lblCodiceTratta;
	}

	public void setLblCodiceTratta(JLabel lblCodiceTratta) {
		this.lblCodiceTratta = lblCodiceTratta;
	}

	public JLabel getLblNumeroPrenotazioni() {
		return lblNumeroPrenotazioni;
	}

	public void setLblNumeroPrenotazioni(JLabel lblNumeroPrenotazioni) {
		this.lblNumeroPrenotazioni = lblNumeroPrenotazioni;
	}

	public JComboBox<String> getComboBoxNumeroPorta() {
		return comboBoxNumeroPorta;
	}

	public void setComboBoxNumeroPorta(JComboBox<String> comboBox) {
		this.comboBoxNumeroPorta = comboBox;
	}
	
	public JComboBox<String> getComboBoxCittaArrivo() {
		return comboBoxCittaArrivo;
	}

	public void setComboBoxCittaArrivo(JComboBox<String> comboBoxCittaArrivo) {
		this.comboBoxCittaArrivo = comboBoxCittaArrivo;
	}

	Controller controllerGestioneVoliPartenze;
	

	public GestioneVoliPartenze(Controller controller) {
		controllerGestioneVoliPartenze = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneVoliPartenze.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.setPannelloPrecedente(1);
				controllerGestioneVoliPartenze.mostraPannelli(controllerGestioneVoliPartenze.getDashboard().getHome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
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
		txtBarraRicerca.setBackground(controllerGestioneVoliPartenze.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
		txtBarraRicerca.setColumns(10);
		add(txtBarraRicerca);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 85, 1030, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGestioneVoliPartenze.eliminaVoloPartenze();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceVoloPartenze.setText(modello.getValueAt(t, 0).toString());				
				txtCodiceGate.setText(modello.getValueAt(t, 2).toString());
				txtCodiceTratta.setText(modello.getValueAt(t, 3).toString());
				txtNumeroPrenotazioni.setText(modello.getValueAt(t, 7).toString());
				txtRitardo.setText(modello.getValueAt(t, 8).toString());				
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);

		txtCodiceVoloPartenze = new JTextField();
		txtCodiceVoloPartenze.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtCodiceVoloPartenze.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtCodiceVoloPartenze.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtCodiceVoloPartenze.setColumns(10);
		txtCodiceVoloPartenze.setBounds(223, 438, 82, 20);
		add(txtCodiceVoloPartenze);

		lblCodiceVoloPartenze = new JLabel("Codice Volo Partenze");
		lblCodiceVoloPartenze.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloPartenze.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblCodiceVoloPartenze.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblCodiceVoloPartenze.setBounds(30, 438, 183, 20);
		add(lblCodiceVoloPartenze);

		lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblDataPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblDataPartenza.setBounds(409, 438, 117, 20);
		add(lblDataPartenza);

		dateDataPartenza = new JDateChooser();
		dateDataPartenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		dateDataPartenza.setDateFormatString("dd/MM/yyyy");
		dateDataPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		dateDataPartenza.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		dateDataPartenza.setBounds(545, 438, 133, 20);
		add(dateDataPartenza);

		lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblOrarioPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblOrarioPartenza.setBounds(409, 469, 117, 20);
		add(lblOrarioPartenza);

		txtOraPartenza = new JTextField();
		txtOraPartenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtOraPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtOraPartenza.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtOraPartenza.setColumns(10);
		txtOraPartenza.setBounds(545, 469, 30, 20);
		add(txtOraPartenza);

		txtMinutoPartenza = new JTextField();
		txtMinutoPartenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtMinutoPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtMinutoPartenza.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtMinutoPartenza.setColumns(10);
		txtMinutoPartenza.setBounds(599, 469, 30, 20);
		add(txtMinutoPartenza);

		lblDuePuntiPartenza = new JLabel(":");
		lblDuePuntiPartenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblDuePuntiPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblDuePuntiPartenza.setBounds(583, 472, 10, 14);
		add(lblDuePuntiPartenza);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.aggiungiVoloPartenze();
			}
		});
		btnAggiungi.setBounds(92, 596, 105, 23);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.modificaVoloPartenze();
			}
		});
		btnModifica.setBounds(290, 596, 105, 23);
		add(btnModifica);

		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.eliminaVoloPartenze();
			}
		});
		btnElimina.setBounds(488, 596, 105, 23);
		add(btnElimina);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.svuotaCampiGestioneVoloPartenze();
			}
		});
		btnSvuota.setBounds(686, 596, 105, 23);
		add(btnSvuota);

		lblNumeroPrenotazioni = new JLabel("Numero Prenotazioni");
		lblNumeroPrenotazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenotazioni.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblNumeroPrenotazioni.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblNumeroPrenotazioni.setBounds(694, 438, 162, 20);
		add(lblNumeroPrenotazioni);

		txtNumeroPrenotazioni = new JTextField();
		txtNumeroPrenotazioni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtNumeroPrenotazioni.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtNumeroPrenotazioni.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtNumeroPrenotazioni.setColumns(10);
		txtNumeroPrenotazioni.setBounds(866, 438, 80, 20);
		add(txtNumeroPrenotazioni);

		JButton btnCalcolaRitardo = new JButton("Calcola Ritardo");
		btnCalcolaRitardo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGestioneVoliPartenze.calcoloRitardo();
			}
		});
		btnCalcolaRitardo.setBounds(879, 596, 105, 23);
		add(btnCalcolaRitardo);

		lblRitardo = new JLabel("Ritardo");
		lblRitardo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRitardo.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblRitardo.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblRitardo.setBounds(694, 469, 162, 20);
		add(lblRitardo);

		txtRitardo = new JTextField();
		txtRitardo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtRitardo.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtRitardo.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtRitardo.setColumns(10);
		txtRitardo.setBounds(866, 469, 30, 20);
		add(txtRitardo);

		lblCodiceTratta = new JLabel("Codice Tratta");
		lblCodiceTratta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceTratta.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblCodiceTratta.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblCodiceTratta.setBounds(30, 500, 183, 20);
		add(lblCodiceTratta);

		txtCodiceTratta = new JTextField();
		txtCodiceTratta.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodiceTratta.setEditable(false);
		txtCodiceTratta.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtCodiceTratta.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtCodiceTratta.setColumns(10);
		txtCodiceTratta.setBounds(223, 500, 82, 20);
		add(txtCodiceTratta);

		lblGate = new JLabel("Gate");
		lblGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGate.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblGate.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblGate.setBounds(30, 469, 183, 20);
		add(lblGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.setEditable(false);
		txtCodiceGate.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(223, 469, 80, 20);
		add(txtCodiceGate);
		
		
		comboBoxNumeroPorta = new JComboBox<String>();
		comboBoxNumeroPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = controllerGestioneVoliPartenze.implementazioneGateDAO().stampaNumeroPortaInComboBox();
				txtCodiceGate.setText(map.get(comboBoxNumeroPorta.getSelectedItem().toString()));
			}
		});
		comboBoxNumeroPorta.setBounds(303, 469, 40, 20);
		add(comboBoxNumeroPorta);
		
		comboBoxCittaArrivo = new JComboBox<String>();
		comboBoxCittaArrivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = controllerGestioneVoliPartenze.implementazioneTrattaDAO().stampaCittaArrivoInComboBox();
				txtCodiceTratta.setText(map.get(comboBoxCittaArrivo.getSelectedItem().toString()));
			}
		});
		comboBoxCittaArrivo.setBounds(305, 500, 95, 20);
		add(comboBoxCittaArrivo);
		
		

		stampaComboBoxNumeroPorta();
		stampaComboBoxCittaArrivo();
		
		caricaTabella();
	}

	public void stampaComboBoxNumeroPorta() {
		HashMap<String, String> map = controllerGestioneVoliPartenze.implementazioneGateDAO().stampaNumeroPortaInComboBox();
		for(String s : map.keySet()) {
			comboBoxNumeroPorta.addItem(s);
		}
	}
	
	public void stampaComboBoxCittaArrivo() {
		HashMap<String, String> map = controllerGestioneVoliPartenze.implementazioneTrattaDAO().stampaCittaArrivoInComboBox();
		for(String s : map.keySet()) {
			comboBoxCittaArrivo.addItem(s);
			
		}
	}
	
	public void caricaTabella() {
		this.ListaVoliPartenze = controllerGestioneVoliPartenze.implementazioneVoloPartenzeDAO().stampaVoliPartenze();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaVoliPartenze) {
			this.modello.addRow(dato);
		}
		tabella.setModel(modello);
	}

	private void ricerca() {
		DefaultTableModel table = (DefaultTableModel) tabella.getModel();
		String ricerca = txtBarraRicerca.getText();
		TableRowSorter<DefaultTableModel> trm = new TableRowSorter<DefaultTableModel>(table);
		tabella.setRowSorter(trm);
		trm.setRowFilter(RowFilter.regexFilter(ricerca));
	}

	public String getDateDataPartenzaDateFormatString() {
		return dateDataPartenza.getDateFormatString();
	}

	public void setDateDataPartenzaDateFormatString(String dateFormatString) {
		dateDataPartenza.setDateFormatString(dateFormatString);
	}
}
