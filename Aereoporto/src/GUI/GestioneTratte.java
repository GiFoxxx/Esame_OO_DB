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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class GestioneTratte extends JPanel {
	
	String colonne[] = {"Codice Tratta", "Citta Partenza", "Citta Arrivo", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaTratte = new ArrayList<>();
	private Immagini img = new Immagini();
	
	private JTextField txtCodiceTratta;
	private JTextField txtCittaPartenza;
	private JTextField txtCittaArrivo;
	private JDateChooser dateDataPartenza;
	private JDateChooser dateDataArrivo;
	private JTextField txtOrarioPartenza;
	private JTextField txtOrarioArrivo;
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
	
	public JTextField getTxtCodiceTratta() {
		return txtCodiceTratta;
	}

	public void setTxtCodiceTratta(JTextField txtCodiceTratta) {
		this.txtCodiceTratta = txtCodiceTratta;
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

	Controller controllerGestioneTratte;

	public GestioneTratte(Controller controller) {
		controllerGestioneTratte = controller;
		
		setBounds(0, 0, 1090, 634);
		setBackground(controllerGestioneTratte.sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.mostraPannelli(controllerGestioneTratte.getDashboard().getHome());
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
		txtBarraRicerca.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneTratte.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(704, 42, 135, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(693, 35, 180, 30);
		add(lblBarraRicerca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 85, 850, 330);
		add(scrollPane);
		
		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceTratta.setText(modello.getValueAt(t, 0).toString());
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
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);
		
		txtCodiceTratta = new JTextField();
		txtCodiceTratta.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtCodiceTratta.setFont(controllerGestioneTratte.fontScritte);
		txtCodiceTratta.setColumns(10);
		txtCodiceTratta.setBounds(173, 444, 133, 20);
		add(txtCodiceTratta);
		
		JLabel lblCodiceTratta = new JLabel("Codice Tratta");
		lblCodiceTratta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceTratta.setFont(controllerGestioneTratte.fontScritte);
		lblCodiceTratta.setForeground(controllerGestioneTratte.coloreScritte);
		lblCodiceTratta.setBounds(25, 444, 114, 20);
		add(lblCodiceTratta);
		
		JLabel lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneTratte.fontScritte);
		lblCittaPartenza.setForeground(controllerGestioneTratte.coloreScritte);
		lblCittaPartenza.setBounds(25, 474, 114, 20);
		add(lblCittaPartenza);
		
		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtCittaPartenza.setFont(controllerGestioneTratte.fontScritte);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(173, 475, 133, 20);
		add(txtCittaPartenza);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtCittaArrivo.setFont(controllerGestioneTratte.fontScritte);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(173, 505, 133, 20);
		add(txtCittaArrivo);
		
		JLabel lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneTratte.fontScritte);
		lblCittaArrivo.setForeground(controllerGestioneTratte.coloreScritte);
		lblCittaArrivo.setBounds(25, 504, 114, 20);
		add(lblCittaArrivo);
		
		JLabel lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneTratte.fontScritte);
		lblDataPartenza.setForeground(controllerGestioneTratte.coloreScritte);
		lblDataPartenza.setBounds(344, 444, 114, 20);
		add(lblDataPartenza);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setFont(controllerGestioneTratte.fontScritte);
		dateDataPartenza.setFont(controllerGestioneTratte.fontScritte);
		dateDataPartenza.setBounds(492, 444, 133, 23);
		add(dateDataPartenza);
		
		JLabel lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setFont(controllerGestioneTratte.fontScritte);
		lblDataArrivo.setForeground(controllerGestioneTratte.coloreScritte);
		lblDataArrivo.setBounds(344, 482, 114, 20);
		add(lblDataArrivo);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setFont(controllerGestioneTratte.fontScritte);
		dateDataArrivo.setFont(controllerGestioneTratte.fontScritte);
		dateDataArrivo.setBounds(492, 482, 133, 23);
		add(dateDataArrivo);
		
		JLabel lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setFont(controllerGestioneTratte.fontScritte);
		lblOrarioPartenza.setForeground(controllerGestioneTratte.coloreScritte);
		lblOrarioPartenza.setBounds(344, 524, 114, 20);
		add(lblOrarioPartenza);
		
		txtOrarioPartenza = new JTextField();
		txtOrarioPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtOrarioPartenza.setFont(controllerGestioneTratte.fontScritte);
		txtOrarioPartenza.setColumns(10);
		txtOrarioPartenza.setBounds(492, 524, 133, 20);
		add(txtOrarioPartenza);
		
		JLabel lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setFont(controllerGestioneTratte.fontScritte);
		lblOrarioArrivo.setForeground(controllerGestioneTratte.coloreScritte);
		lblOrarioArrivo.setBounds(344, 564, 114, 20);
		add(lblOrarioArrivo);
		
		txtOrarioArrivo = new JTextField();
		txtOrarioArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBianco);
		txtOrarioArrivo.setFont(controllerGestioneTratte.fontScritte);
		txtOrarioArrivo.setColumns(10);
		txtOrarioArrivo.setBounds(492, 564, 133, 20);
		add(txtOrarioArrivo);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.aggiungiTratta();
			}
		});
		btnAggiungi.setBounds(767, 444, 89, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.modificaTratta();
			}
		});
		btnModifica.setBounds(767, 478, 89, 23);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.eliminaTratta();
			}
		});
		btnElimina.setBounds(767, 512, 89, 23);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.svuotaCampiTratta();
			}
		});
		btnSvuota.setBounds(767, 546, 89, 23);
		add(btnSvuota);
		
		caricaTabella();
	}
	
	public void  caricaTabella() {
		this.ListaTratte = controllerGestioneTratte.implementazioneTrattaDAO().stampaTratte();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaTratte) {
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
