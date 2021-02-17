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
	private JTextField txtOraPartenza;
	private JTextField txtOraArrivo;
	private JTextField txtMinutoPartenza;
	private JTextField txtMinutoArrivo;
	private JTable tabella;
	private JTextField txtBarraRicerca;
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblRicerca;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceTratta;
	private JLabel lblCittaPartenza;
	private JLabel lblCittaArrivo;
	private JLabel lblDataPartenza;
	private JLabel lblDataArrivo;
	private JLabel lblOraPartenza;
	private JLabel lblDuePuntiPartenza;
	private JLabel lblMinutoPartenza;
	private JLabel lblMinutoArrivo;
	private JLabel lblDuePuntiArrivo;
	private JLabel lblOraArrivo;
	
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

	public JLabel getLblRicerca() {
		return lblRicerca;
	}

	public void setLblRicerca(JLabel lblRicerca) {
		this.lblRicerca = lblRicerca;
	}

	public JLabel getLblBarraRicerca() {
		return lblBarraRicerca;
	}

	public void setLblBarraRicerca(JLabel lblBarraRicerca) {
		this.lblBarraRicerca = lblBarraRicerca;
	}

	public JLabel getLblCodiceTratta() {
		return lblCodiceTratta;
	}

	public void setLblCodiceTratta(JLabel lblCodiceTratta) {
		this.lblCodiceTratta = lblCodiceTratta;
	}

	public JLabel getLblCittaPartenza() {
		return lblCittaPartenza;
	}

	public void setLblCittaPartenza(JLabel lblCittaPartenza) {
		this.lblCittaPartenza = lblCittaPartenza;
	}

	public JLabel getLblCittaArrivo() {
		return lblCittaArrivo;
	}

	public void setLblCittaArrivo(JLabel lblCittaArrivo) {
		this.lblCittaArrivo = lblCittaArrivo;
	}

	public JLabel getLblDataPartenza() {
		return lblDataPartenza;
	}

	public void setLblDataPartenza(JLabel lblDataPartenza) {
		this.lblDataPartenza = lblDataPartenza;
	}

	public JLabel getLblDataArrivo() {
		return lblDataArrivo;
	}

	public void setLblDataArrivo(JLabel lblDataArrivo) {
		this.lblDataArrivo = lblDataArrivo;
	}

	public JLabel getLblOraPartenza() {
		return lblOraPartenza;
	}

	public void setLblOraPartenza(JLabel lblOraPartenza) {
		this.lblOraPartenza = lblOraPartenza;
	}

	public JLabel getLblDuePuntiPartenza() {
		return lblDuePuntiPartenza;
	}

	public void setLblDuePuntiPartenza(JLabel lblDuePuntiPartenza) {
		this.lblDuePuntiPartenza = lblDuePuntiPartenza;
	}

	public JLabel getLblMinutoPartenza() {
		return lblMinutoPartenza;
	}

	public void setLblMinutoPartenza(JLabel lblMinutoPartenza) {
		this.lblMinutoPartenza = lblMinutoPartenza;
	}

	public JLabel getLblMinutoArrivo() {
		return lblMinutoArrivo;
	}

	public void setLblMinutoArrivo(JLabel lblMinutoArrivo) {
		this.lblMinutoArrivo = lblMinutoArrivo;
	}

	public JLabel getLblDuePuntiArrivo() {
		return lblDuePuntiArrivo;
	}

	public void setLblDuePuntiArrivo(JLabel lblDuePuntiArrivo) {
		this.lblDuePuntiArrivo = lblDuePuntiArrivo;
	}

	public JLabel getLblOraArrivo() {
		return lblOraArrivo;
	}

	public void setLblOraArrivo(JLabel lblOraArrivo) {
		this.lblOraArrivo = lblOraArrivo;
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
	
	public JTextField getTxtOraPartenza() {
		return txtOraPartenza;
	}

	public void setTxtOraPartenza(JTextField txtOrarioPartenza) {
		this.txtOraPartenza = txtOrarioPartenza;
	}

	public JTextField getTxtOraArrivo() {
		return txtOraArrivo;
	}

	public void setTxtOraArrivo(JTextField txtOrarioArrivo) {
		this.txtOraArrivo = txtOrarioArrivo;
	}

	public JTextField getTxtMinutoPartenza() {
		return txtMinutoPartenza;
	}

	public void setTxtMinutoPartenza(JTextField txtMinutoPartenza) {
		this.txtMinutoPartenza = txtMinutoPartenza;
	}

	public JTextField getTxtMinutoArrivo() {
		return txtMinutoArrivo;
	}

	public void setTxtMinutoArrivo(JTextField txtMinutoArrivo) {
		this.txtMinutoArrivo = txtMinutoArrivo;
	}

	public JDateChooser getDateDataArrivo() {
		return dateDataArrivo;
	}

	public void setDateDataArrivo(JDateChooser dateDataArrivo) {
		this.dateDataArrivo = dateDataArrivo;
	}


	Controller controllerGestioneTratte;
	

	public GestioneTratte(Controller controller) {
		controllerGestioneTratte = controller;
		
		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneTratte.sfondoTemaScuro);
		setLayout(null);
		
		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.setPannelloPrecedente(1);
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
		
		lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca()));
		lblRicerca.setBounds(1031, 39, 23, 23);
		add(lblRicerca);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 40, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 85, 1030, 330);
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
				txtOraPartenza.setText(modello.getValueAt(t, 5).toString());
				txtOraArrivo.setText(modello.getValueAt(t, 6).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);
		
		txtCodiceTratta = new JTextField();
		txtCodiceTratta.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCodiceTratta.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCodiceTratta.setColumns(10);
		txtCodiceTratta.setBounds(173, 444, 133, 20);
		add(txtCodiceTratta);
		
		lblCodiceTratta = new JLabel("Codice Tratta");
		lblCodiceTratta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceTratta.setFont(controllerGestioneTratte.fontLabel);
		lblCodiceTratta.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCodiceTratta.setBounds(25, 444, 114, 20);
		add(lblCodiceTratta);
		
		lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblCittaPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCittaPartenza.setBounds(25, 474, 114, 20);
		add(lblCittaPartenza);
		
		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCittaPartenza.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(173, 475, 133, 20);
		add(txtCittaPartenza);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCittaArrivo.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(173, 505, 133, 20);
		add(txtCittaArrivo);
		
		lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblCittaArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCittaArrivo.setBounds(25, 504, 114, 20);
		add(lblCittaArrivo);
		
		lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblDataPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblDataPartenza.setBounds(344, 444, 114, 20);
		add(lblDataPartenza);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setFont(controllerGestioneTratte.fontScritteGestioni);
		dateDataPartenza.setBounds(492, 444, 133, 23);
		add(dateDataPartenza);
		
		lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblDataArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblDataArrivo.setBounds(344, 482, 114, 20);
		add(lblDataArrivo);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setFont(controllerGestioneTratte.fontScritteGestioni);
		dateDataArrivo.setBounds(492, 482, 133, 23);
		add(dateDataArrivo);
		
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
				controllerGestioneTratte.svuotaCampiGestioneTratta();
			}
		});
		btnSvuota.setBounds(767, 546, 89, 23);
		add(btnSvuota);
		
		lblOraPartenza = new JLabel("Ora Partenza");
		lblOraPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOraPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblOraPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblOraPartenza.setBounds(344, 516, 114, 20);
		add(lblOraPartenza);
		
		txtOraPartenza = new JTextField();
		txtOraPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtOraPartenza.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtOraPartenza.setColumns(10);
		txtOraPartenza.setBounds(492, 516, 27, 20);
		add(txtOraPartenza);
		
		lblDuePuntiPartenza = new JLabel(":");
		lblDuePuntiPartenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblDuePuntiPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblDuePuntiPartenza.setBounds(523, 519, 10, 14);
		add(lblDuePuntiPartenza);
		
		txtOraArrivo = new JTextField();
		txtOraArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtOraArrivo.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtOraArrivo.setColumns(10);
		txtOraArrivo.setBounds(537, 516, 27, 20);
		add(txtOraArrivo);
		
		lblMinutoPartenza = new JLabel("Minuto Partenza");
		lblMinutoPartenza.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutoPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblMinutoPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblMinutoPartenza.setBounds(574, 516, 114, 20);
		add(lblMinutoPartenza);
		
		lblMinutoArrivo = new JLabel("Minuto Arrivo");
		lblMinutoArrivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutoArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblMinutoArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblMinutoArrivo.setBounds(574, 556, 114, 20);
		add(lblMinutoArrivo);
		
		txtMinutoPartenza = new JTextField();
		txtMinutoPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtMinutoPartenza.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtMinutoPartenza.setColumns(10);
		txtMinutoPartenza.setBounds(537, 556, 27, 20);
		add(txtMinutoPartenza);
		
		lblDuePuntiArrivo = new JLabel(":");
		lblDuePuntiArrivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblDuePuntiArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblDuePuntiArrivo.setBounds(523, 559, 10, 14);
		add(lblDuePuntiArrivo);
		
		txtMinutoArrivo = new JTextField();
		txtMinutoArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtMinutoArrivo.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtMinutoArrivo.setColumns(10);
		txtMinutoArrivo.setBounds(492, 556, 27, 20);
		add(txtMinutoArrivo);
		
		lblOraArrivo = new JLabel("Ora Arrivo");
		lblOraArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOraArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblOraArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblOraArrivo.setBounds(344, 556, 114, 20);
		add(lblOraArrivo);
		
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
