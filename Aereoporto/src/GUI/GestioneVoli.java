package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

public class GestioneVoli extends JPanel {

	String colonne[] = {"Codice Volo", "Citta Partenza", "Citta Arrivo", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Numero Prenotazioni"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoli = new ArrayList<>();
	private Immagini img = new Immagini();
	
	private JTextField txtCodiceVolo;
	private JTextField txtCittaPartenza;
	private JTextField txtCittaArrivo;
	private JDateChooser dateDataPartenza;
	private JDateChooser dateDataArrivo;
	private JTextField txtOrarioPartenza;
	private JTextField txtOrarioArrivo;
	private JTextField txtNumeroPrenotazioni;
	JScrollPane scrollPane;
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
	
	public JTextField getTxtCodiceVolo() {
		return txtCodiceVolo;
	}

	public void setTxtCodiceVolo(JTextField txtCodiceTratta) {
		this.txtCodiceVolo = txtCodiceTratta;
	}

	public JTextField getTxtCittaPartenza() {
		return txtCittaPartenza;
	}

	public void setTxtCittaPartenza(JTextField txtCittaPartenza) {
		this.txtCittaPartenza = txtCittaPartenza;
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

	public JDateChooser getDateDataArrivo() {
		return dateDataArrivo;
	}

	public void setDateDataArrivo(JDateChooser dateDataArrivo) {
		this.dateDataArrivo = dateDataArrivo;
	}

	public JTextField getTxtOrarioPartenza() {
		return txtOrarioPartenza;
	}

	public void setTxtOrarioPartenza(JTextField txtOrarioPartenza) {
		this.txtOrarioPartenza = txtOrarioPartenza;
	}

	public JTextField getTxtOrarioArrivo() {
		return txtOrarioArrivo;
	}

	public void setTxtOrarioArrivo(JTextField txtOrarioArrivo) {
		this.txtOrarioArrivo = txtOrarioArrivo;
	}

	public JTextField getTxtNumeroPrenotazioni() {
		return txtNumeroPrenotazioni;
	}

	public void setTxtNumeroPrenotazioni(JTextField txtNumeroPrenotazioni) {
		this.txtNumeroPrenotazioni = txtNumeroPrenotazioni;
	}

	Controller controllerGestioneVoli;
	
	public GestioneVoli(Controller controller) {
		controllerGestioneVoli= controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(controllerGestioneVoli.sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.mostraPannelli(controllerGestioneVoli.getDashboard().getHome());
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
		lblimgfrecciaIndietro.setBounds(25, 35, 47, 30);
		add(lblimgfrecciaIndietro);
		
		JLabel lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca()));
		lblRicerca.setBounds(840, 36, 27, 27);
		add(lblRicerca);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setForeground(controllerGestioneVoli.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneVoli.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(704, 42, 135, 20);
		txtBarraRicerca.setColumns(10);
		add(txtBarraRicerca);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(693, 35, 180, 30);
		add(lblBarraRicerca);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 85, 850, 330);
		add(scrollPane);
		
		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceVolo.setText(modello.getValueAt(t, 0).toString());
				txtCittaPartenza.setText(modello.getValueAt(t, 1).toString());
				txtCittaArrivo.setText(modello.getValueAt(t, 2).toString());
				try {
					java.util.Date datePartenza = new SimpleDateFormat("dd-MM-yyyy").parse((String) modello.getValueAt(t,3));
					dateDataPartenza.setDate(datePartenza);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					java.util.Date dateArrivo = new SimpleDateFormat("dd-MM-yyyy").parse((String) modello.getValueAt(t,4));
					dateDataArrivo.setDate(dateArrivo);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				txtOrarioPartenza.setText(modello.getValueAt(t, 5).toString());
				txtOrarioArrivo.setText(modello.getValueAt(t, 6).toString());
				txtNumeroPrenotazioni.setText(modello.getValueAt(t, 7).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);
		
		txtCodiceVolo = new JTextField();
		txtCodiceVolo.setForeground(controllerGestioneVoli.coloreScritte);
		txtCodiceVolo.setFont(controllerGestioneVoli.fontScritte);
		txtCodiceVolo.setColumns(10);
		txtCodiceVolo.setBounds(173, 439, 133, 20);
		add(txtCodiceVolo);
		
		JLabel lblCodiceVolo = new JLabel("Codice Volo");
		lblCodiceVolo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVolo.setFont(controllerGestioneVoli.fontScritte);
		lblCodiceVolo.setForeground(controllerGestioneVoli.coloreScritte);
		lblCodiceVolo.setBounds(25, 439, 114, 20);
		add(lblCodiceVolo);
		
		JLabel lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVolo.setFont(controllerGestioneVoli.fontScritte);
		lblCittaPartenza.setForeground(controllerGestioneVoli.coloreScritte);
		lblCittaPartenza.setBounds(25, 476, 114, 20);
		add(lblCittaPartenza);
		
		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setForeground(controllerGestioneVoli.coloreScritte);
		txtCittaPartenza.setFont(controllerGestioneVoli.fontScritte);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(173, 477, 133, 20);
		add(txtCittaPartenza);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setForeground(controllerGestioneVoli.coloreScritte);
		txtCittaArrivo.setFont(controllerGestioneVoli.fontScritte);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(173, 519, 133, 20);
		add(txtCittaArrivo);
		
		JLabel lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneVoli.fontScritte);
		lblCittaArrivo.setForeground(controllerGestioneVoli.coloreScritte);
		lblCittaArrivo.setBounds(25, 518, 114, 20);
		add(lblCittaArrivo);
		
		JLabel lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneVoli.fontScritte);
		lblDataPartenza.setForeground(controllerGestioneVoli.coloreScritte);
		lblDataPartenza.setBounds(344, 439, 114, 20);
		add(lblDataPartenza);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setFont(controllerGestioneVoli.fontScritte);
		dateDataPartenza.setFont(controllerGestioneVoli.fontScritte);
		dateDataPartenza.setBounds(492, 439, 133, 23);
		add(dateDataPartenza);
		
		JLabel lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);		
		lblDataArrivo.setFont(controllerGestioneVoli.fontScritte);
		lblDataArrivo.setForeground(controllerGestioneVoli.coloreScritte);
		lblDataArrivo.setBounds(344, 477, 114, 20);
		add(lblDataArrivo);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setFont(controllerGestioneVoli.fontScritte);
		dateDataArrivo.setFont(controllerGestioneVoli.fontScritte);
		dateDataArrivo.setBounds(492, 477, 133, 23);
		add(dateDataArrivo);
		
		JLabel lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setFont(controllerGestioneVoli.fontScritte);
		lblOrarioPartenza.setForeground(controllerGestioneVoli.coloreScritte);
		lblOrarioPartenza.setBounds(344, 519, 114, 20);
		add(lblOrarioPartenza);
		
		txtOrarioPartenza = new JTextField();
		txtOrarioPartenza.setForeground(controllerGestioneVoli.coloreScritte);
		txtOrarioPartenza.setFont(controllerGestioneVoli.fontScritte);
		txtOrarioPartenza.setColumns(10);
		txtOrarioPartenza.setBounds(492, 519, 133, 20);
		add(txtOrarioPartenza);
		
		JLabel lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setFont(controllerGestioneVoli.fontScritte);
		lblOrarioArrivo.setForeground(controllerGestioneVoli.coloreScritte);
		lblOrarioArrivo.setBounds(344, 559, 114, 20);
		add(lblOrarioArrivo);
		
		txtOrarioArrivo = new JTextField();
		txtOrarioArrivo.setForeground(controllerGestioneVoli.coloreScritte);
		txtOrarioArrivo.setFont(controllerGestioneVoli.fontScritte);
		txtOrarioArrivo.setColumns(10);
		txtOrarioArrivo.setBounds(492, 559, 133, 20);
		add(txtOrarioArrivo);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.aggiungiVolo();
			}
		});
		btnAggiungi.setBounds(767, 439, 89, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.modificaVolo();
			}
		});
		btnModifica.setBounds(767, 473, 89, 23);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.eliminaVolo();
			}
		});
		btnElimina.setBounds(767, 507, 89, 23);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.svuotaCampiVolo();
			}
		});
		btnSvuota.setBounds(767, 541, 89, 23);
		add(btnSvuota);
		
		JLabel lblNumeroPrenoazioni = new JLabel("Numero Prenoazioni");
		lblNumeroPrenoazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenoazioni.setFont(controllerGestioneVoli.fontScritte);
		lblNumeroPrenoazioni.setForeground(controllerGestioneVoli.coloreScritte);
		lblNumeroPrenoazioni.setBounds(25, 558, 114, 20);
		add(lblNumeroPrenoazioni);
		
		txtNumeroPrenotazioni = new JTextField();
		txtNumeroPrenotazioni.setForeground(controllerGestioneVoli.coloreScritte);
		txtNumeroPrenotazioni.setFont(controllerGestioneVoli.fontScritte);
		txtNumeroPrenotazioni.setColumns(10);
		txtNumeroPrenotazioni.setBounds(173, 559, 133, 20);
		add(txtNumeroPrenotazioni);
		
		caricaTabella();
	}
	
	public void  caricaTabella() {
		this.ListaVoli = controllerGestioneVoli.implementazioneVoloDAO().stampaVoli();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaVoli) {
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

}
