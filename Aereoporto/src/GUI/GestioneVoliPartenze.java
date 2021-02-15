package GUI;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import Immagini.Immagini;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GestioneVoliPartenze extends JPanel {

	String colonne[] = {"Codice Volo Partenze", "Citta di Arrivo", "Data Partenza", "Ora Partenza", "Minuto Partenza" , "Numero Prenotazioni", "Ritardo", };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoliPartenze = new ArrayList<>();
	private Immagini img = new Immagini();
	
	private JTextField txtCodiceVoloPartenze;
	private JTextField txtCittaArrivo;
	private JDateChooser dateDataPartenza;
	private JTextField txtOraPartenza;
	private JTextField txtMinutoPartenza;
	private JTextField txtNumeroPrenotazioni;
	private JTextField txtRitardo;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;
	
	
	//GETTER E SETTER
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
	
	public JTextField getTxtCodiceVoloPartenze() {
		return txtCodiceVoloPartenze;
	}

	public void setTxtCodiceVoloPartenze(JTextField txtCodiceTratta) {
		this.txtCodiceVoloPartenze = txtCodiceTratta;
	}

	public JTextField getTxtCittaArrivo() {
		return txtCittaArrivo;
	}

	public void setTxtCittaArrivo(JTextField txtCittaArrivo) {
		this.txtCittaArrivo = txtCittaArrivo;
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

	Controller controllerGestioneVoliPartenze;
	
	
	
	public GestioneVoliPartenze(Controller controller) {
		controllerGestioneVoliPartenze= controller;
		
		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneVoliPartenze.sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
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
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(30, 35, 47, 30);
		add(lblimgfrecciaIndietro);
		
		JLabel lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca()));
		lblRicerca.setBounds(1027, 36, 27, 27);
		add(lblRicerca);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(891, 42, 135, 20);
		txtBarraRicerca.setColumns(10);
		add(txtBarraRicerca);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(880, 35, 180, 30);
		add(lblBarraRicerca);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 85, 1030, 330);
		add(scrollPane);
		
		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceVoloPartenze.setText(modello.getValueAt(t, 0).toString());
				txtCittaArrivo.setText(modello.getValueAt(t, 1).toString());
				try {
					java.util.Date datePartenza = new SimpleDateFormat("dd/MM/yyyy").parse((String) modello.getValueAt(t,2));
					dateDataPartenza.setDate(datePartenza);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				txtOraPartenza.setText(modello.getValueAt(t, 3).toString());
				txtMinutoPartenza.setText(modello.getValueAt(t, 4).toString());
				txtNumeroPrenotazioni.setText(modello.getValueAt(t, 5).toString());
				txtRitardo.setText(modello.getValueAt(t, 6).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);
		
		txtCodiceVoloPartenze = new JTextField();
		txtCodiceVoloPartenze.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtCodiceVoloPartenze.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtCodiceVoloPartenze.setColumns(10);
		txtCodiceVoloPartenze.setBounds(240, 438, 133, 20);
		add(txtCodiceVoloPartenze);
		
		JLabel lblCodiceVoloPartenze = new JLabel("Codice Volo Partenze");
		lblCodiceVoloPartenze.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloPartenze.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblCodiceVoloPartenze.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblCodiceVoloPartenze.setBounds(30, 438, 200, 20);
		add(lblCodiceVoloPartenze);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtCittaArrivo.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(240, 469, 133, 20);
		add(txtCittaArrivo);
		
		JLabel lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblCittaArrivo.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblCittaArrivo.setBounds(30, 469, 200, 20);
		add(lblCittaArrivo);
		
		JLabel lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblDataPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblDataPartenza.setBounds(383, 438, 117, 20);
		add(lblDataPartenza);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setDateFormatString("dd/MM/yyyy");
		dateDataPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		dateDataPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		dateDataPartenza.setBounds(519, 438, 133, 20);
		add(dateDataPartenza);
		
		JLabel lblOraPartenza = new JLabel("Ora Partenza");
		lblOraPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOraPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblOraPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblOraPartenza.setBounds(383, 469, 117, 20);
		add(lblOraPartenza);
		
		txtOraPartenza = new JTextField();
		txtOraPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtOraPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtOraPartenza.setColumns(10);
		txtOraPartenza.setBounds(519, 469, 30, 20);
		add(txtOraPartenza);
		
		JLabel lblMinutoPartenza = new JLabel("Minuto Partenza");
		lblMinutoPartenza.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutoPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblMinutoPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblMinutoPartenza.setBounds(613, 469, 117, 20);
		add(lblMinutoPartenza);
		
		txtMinutoPartenza = new JTextField();
		txtMinutoPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtMinutoPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtMinutoPartenza.setColumns(10);
		txtMinutoPartenza.setBounds(573, 469, 30, 20);
		add(txtMinutoPartenza);
		
		JLabel lblDuePuntiPartenza = new JLabel(":");
		lblDuePuntiPartenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblDuePuntiPartenza.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblDuePuntiPartenza.setBounds(557, 472, 10, 14);
		add(lblDuePuntiPartenza);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.aggiungiVoloPartenze();
			}
		});
		btnAggiungi.setBounds(98, 517, 105, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.modificaVoloPartenze();
			}
		});
		btnModifica.setBounds(296, 517, 105, 23);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.eliminaVoloPartenze();
			}
		});
		btnElimina.setBounds(494, 517, 105, 23);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.svuotaCampiVoloPartenze();
			}
		});
		btnSvuota.setBounds(692, 517, 105, 23);
		add(btnSvuota);
		
		JLabel lblNumeroPrenoazioni = new JLabel("Numero Prenoazioni");
		lblNumeroPrenoazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenoazioni.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblNumeroPrenoazioni.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblNumeroPrenoazioni.setBounds(711, 438, 200, 20);
		add(lblNumeroPrenoazioni);
		
		txtNumeroPrenotazioni = new JTextField();
		txtNumeroPrenotazioni.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtNumeroPrenotazioni.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtNumeroPrenotazioni.setColumns(10);
		txtNumeroPrenotazioni.setBounds(921, 438, 133, 20);
		add(txtNumeroPrenotazioni);
		
		JButton btnCalcolaRitardo = new JButton("Calcola Ritardo");
		btnCalcolaRitardo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGestioneVoliPartenze.calcoloRitardo();
			}
		});
		btnCalcolaRitardo.setBounds(885, 517, 105, 23);
		add(btnCalcolaRitardo);
		
		JLabel lblRitardo = new JLabel("Ritardo");
		lblRitardo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRitardo.setForeground(controllerGestioneVoliPartenze.coloreScritte);
		lblRitardo.setFont(controllerGestioneVoliPartenze.fontScritte);
		lblRitardo.setBounds(810, 469, 101, 20);
		add(lblRitardo);
		
		txtRitardo = new JTextField();
		txtRitardo.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBianco);
		txtRitardo.setFont(controllerGestioneVoliPartenze.fontScritte);
		txtRitardo.setColumns(10);
		txtRitardo.setBounds(921, 469, 30, 20);
		add(txtRitardo);
		
		
		
		caricaTabella();
	}
	
	public void  caricaTabella() {
		this.ListaVoliPartenze = controllerGestioneVoliPartenze.implementazioneVoloPartenzeDAO().stampaVoliPartenze();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaVoliPartenze) {
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
