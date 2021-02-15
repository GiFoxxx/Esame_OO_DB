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

public class GestioneVoliArrivi extends JPanel {

	String colonne[] = {"Codice Volo Arrivi", "Citta di Partenza",  "Data Arrivo", "Orario Arrivo", "Minuto Arrivo"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoliArrivi = new ArrayList<>();
	private Immagini img = new Immagini();
	
	private JTextField txtCodiceVoloArrivi;
	private JTextField txtCittaPartenza;
	private JDateChooser dateDataArrivo;
	private JTextField txtOraArrivo;
	private JTextField txtMinutoArrivo;
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
	
	public JTextField getTxtCodiceVoloArrivi() {
		return txtCodiceVoloArrivi;
	}

	public void setTxtCodiceVoloArrivi(JTextField txtCodiceTratta) {
		this.txtCodiceVoloArrivi = txtCodiceTratta;
	}

	public JTextField getTxtCittaPartenza() {
		return txtCittaPartenza;
	}

	public void setTxtCittaPartenza(JTextField txtCittaPartenza) {
		this.txtCittaPartenza = txtCittaPartenza;
	}

	public JDateChooser getDateDataArrivo() {
		return dateDataArrivo;
	}

	public void setDateDataArrivo(JDateChooser dateDataArrivo) {
		this.dateDataArrivo = dateDataArrivo;
	}

	public JTextField getTxtOraArrivo() {
		return txtOraArrivo;
	}

	public void setTxtOraArrivo(JTextField txtOrarioArrivo) {
		this.txtOraArrivo = txtOrarioArrivo;
	}

	public JTextField getTxtMinutoArrivo() {
		return txtMinutoArrivo;
	}

	public void setTxtMinutoArrivo(JTextField txtMinutoArrivo) {
		this.txtMinutoArrivo = txtMinutoArrivo;
	}

	Controller controllerGestioneVoliArrivi;
	
	
	
	public GestioneVoliArrivi(Controller controller) {
		controllerGestioneVoliArrivi= controller;
		
		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneVoliArrivi.sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.setPannelloPrecedente(1);
				controllerGestioneVoliArrivi.mostraPannelli(controllerGestioneVoliArrivi.getDashboard().getHome());
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
		txtBarraRicerca.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneVoliArrivi.fontScritte);
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
				txtCodiceVoloArrivi.setText(modello.getValueAt(t, 0).toString());
				txtCittaPartenza.setText(modello.getValueAt(t, 1).toString());
				try {
					java.util.Date dateArrivo = new SimpleDateFormat("dd/MM/yyyy").parse((String) modello.getValueAt(t,2));
					dateDataArrivo.setDate(dateArrivo);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				txtOraArrivo.setText(modello.getValueAt(t, 3).toString());
				txtMinutoArrivo.setText(modello.getValueAt(t, 4).toString());
				
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);
		
		txtCodiceVoloArrivi = new JTextField();
		txtCodiceVoloArrivi.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		txtCodiceVoloArrivi.setFont(controllerGestioneVoliArrivi.fontScritte);
		txtCodiceVoloArrivi.setColumns(10);
		txtCodiceVoloArrivi.setBounds(240, 438, 133, 20);
		add(txtCodiceVoloArrivi);
		
		JLabel lblCodiceVoloArrivi = new JLabel("Codice Volo Arrivi");
		lblCodiceVoloArrivi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloArrivi.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblCodiceVoloArrivi.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblCodiceVoloArrivi.setBounds(30, 438, 200, 20);
		add(lblCodiceVoloArrivi);
		
		JLabel lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblCittaPartenza.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblCittaPartenza.setBounds(30, 475, 200, 20);
		add(lblCittaPartenza);
		
		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		txtCittaPartenza.setFont(controllerGestioneVoliArrivi.fontScritte);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(240, 475, 133, 20);
		add(txtCittaPartenza);
		
		JLabel lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);		
		lblDataArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblDataArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblDataArrivo.setBounds(479, 438, 200, 20);
		add(lblDataArrivo);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setDateFormatString("dd/MM/yyyy");
		dateDataArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		dateDataArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		dateDataArrivo.setBounds(689, 438, 133, 20);
		add(dateDataArrivo);
		
		JLabel lblOraArrivo = new JLabel("Ora Arrivo");
		lblOraArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOraArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblOraArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblOraArrivo.setBounds(479, 475, 200, 20);
		add(lblOraArrivo);
		
		txtOraArrivo = new JTextField();
		txtOraArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		txtOraArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		txtOraArrivo.setColumns(10);
		txtOraArrivo.setBounds(689, 475, 30, 20);
		add(txtOraArrivo);
		
		JLabel lblMinutoArrivo = new JLabel("Minuto Arrivo");
		lblMinutoArrivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutoArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblMinutoArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblMinutoArrivo.setBounds(780, 475, 101, 20);
		add(lblMinutoArrivo);
		
		txtMinutoArrivo = new JTextField();
		txtMinutoArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBianco);
		txtMinutoArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		txtMinutoArrivo.setColumns(10);
		txtMinutoArrivo.setBounds(743, 475, 30, 20);
		add(txtMinutoArrivo);
		
		JLabel lblDuePuntiArrivo = new JLabel(":");
		lblDuePuntiArrivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritte);
		lblDuePuntiArrivo.setFont(controllerGestioneVoliArrivi.fontScritte);
		lblDuePuntiArrivo.setBounds(729, 478, 10, 14);
		add(lblDuePuntiArrivo);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.aggiungiVoloArrivi();
			}
		});
		btnAggiungi.setBounds(96, 532, 100, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.modificaVoloArrivi();
			}
		});
		btnModifica.setBounds(292, 532, 100, 23);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.eliminaVoloArrivi();
			}
		});
		btnElimina.setBounds(488, 532, 100, 23);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.svuotaCampiVoloPartenze();
			}
		});
		btnSvuota.setBounds(684, 532, 100, 23);
		add(btnSvuota);
		
		JButton btnCalcolaRitardo = new JButton("Calcola Ritardo");
		btnCalcolaRitardo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerGestioneVoliArrivi.calcoloRitardo();
			}
		});
		btnCalcolaRitardo.setBounds(880, 532, 110, 23);
		add(btnCalcolaRitardo);
				
		caricaTabella();
	}
	
	public void  caricaTabella() {
		this.ListaVoliArrivi = controllerGestioneVoliArrivi.implementazioneVoloArriviDAO().stampaVoliArrivi();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaVoliArrivi) {
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
