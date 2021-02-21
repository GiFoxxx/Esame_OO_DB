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
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import Immagini.Immagini;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GestioneVoliPartenze extends JPanel {

	String colonne[] = { "Codice Volo Partenze", "Citta di Arrivo", "Data Partenza", "Ora Partenza", "Minuto Partenza", "Ora arrivo", "Minuto arrivo",
			"Numero Prenotazioni", "Ritardo"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoliPartenze = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceVoloPartenze;
	private JTextField txtCittaArrivo;
	private JDateChooser dateDataPartenza;
	private JTextField txtOraPartenza;
	private JTextField txtMinutoPartenza;
	private JTextField txtOraArrivo;
	private JTextField txtMinutoArrivo;
	private JTextField txtNumeroPrenotazioni;
	private JTextField txtRitardo;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceVoloPartenze;
	private JLabel lblCittaArrivo;
	private JLabel lblDataPartenza;
	private JLabel lblOrarioPartenza;
	private JLabel lblOraArrivo;
	private JLabel lblMinutoArrivo;
	private JLabel lblDuePuntiPartenza;
	private JLabel lblNumeroPrenoazioni;
	private JLabel lblRitardo;

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
		return lblNumeroPrenoazioni;
	}

	public void setLblNumeroPrenoazioni(JLabel lblNumeroPrenoazioni) {
		this.lblNumeroPrenoazioni = lblNumeroPrenoazioni;
	}

	public JLabel getLblRitardo() {
		return lblRitardo;
	}
	
	public JLabel getLblOraArrivo() {
		return lblOraArrivo;
	}

	public void setLblOraArrivo(JLabel lblOraArrivo) {
		this.lblOraArrivo = lblOraArrivo;
	}

	public JLabel getLblMinutoArrivo() {
		return lblMinutoArrivo;
	}

	public void setLblMinutoArrivo(JLabel lblMinutoArrivo) {
		this.lblMinutoArrivo = lblMinutoArrivo;
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

	public JTextField getTxtOraArrivo() {
		return txtOraArrivo;
	}

	public void setTxtOraArrivo(JTextField txtOraArrivo) {
		this.txtOraArrivo = txtOraArrivo;
	}

	public JTextField getTxtMinutoArrivo() {
		return txtMinutoArrivo;
	}

	public void setTxtMinutoArrivo(JTextField txtMinutoArrivo) {
		this.txtMinutoArrivo = txtMinutoArrivo;
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
				txtCittaArrivo.setText(modello.getValueAt(t, 1).toString());
				try {
					java.util.Date datePartenza = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) modello.getValueAt(t, 2));
					dateDataPartenza.setDate(datePartenza);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				txtOraPartenza.setText(modello.getValueAt(t, 3).toString());
				txtMinutoPartenza.setText(modello.getValueAt(t, 4).toString());
				txtOraArrivo.setText(modello.getValueAt(t, 5).toString());
				txtMinutoArrivo.setText(modello.getValueAt(t, 6).toString());
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
		txtCodiceVoloPartenze.setBounds(240, 438, 133, 20);
		add(txtCodiceVoloPartenze);

		lblCodiceVoloPartenze = new JLabel("Codice Volo Partenze");
		lblCodiceVoloPartenze.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloPartenze.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblCodiceVoloPartenze.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblCodiceVoloPartenze.setBounds(30, 438, 200, 20);
		add(lblCodiceVoloPartenze);

		txtCittaArrivo = new JTextField();
		txtCittaArrivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliPartenze.aggiungiVoloPartenze();
				}
			}
		});
		txtCittaArrivo.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtCittaArrivo.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(240, 469, 133, 20);
		add(txtCittaArrivo);

		lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblCittaArrivo.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblCittaArrivo.setBounds(30, 469, 200, 20);
		add(lblCittaArrivo);

		lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblDataPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblDataPartenza.setBounds(383, 438, 117, 20);
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
		dateDataPartenza.setBounds(519, 438, 133, 20);
		add(dateDataPartenza);

		lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblOrarioPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblOrarioPartenza.setBounds(383, 469, 117, 20);
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
		txtOraPartenza.setBounds(519, 469, 30, 20);
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
		txtMinutoPartenza.setBounds(573, 469, 30, 20);
		add(txtMinutoPartenza);

		lblDuePuntiPartenza = new JLabel(":");
		lblDuePuntiPartenza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiPartenza.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblDuePuntiPartenza.setFont(controllerGestioneVoliPartenze.fontLabel);
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
				controllerGestioneVoliPartenze.svuotaCampiGestioneVoloPartenze();
			}
		});
		btnSvuota.setBounds(692, 517, 105, 23);
		add(btnSvuota);

		lblNumeroPrenoazioni = new JLabel("Numero Prenoazioni");
		lblNumeroPrenoazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenoazioni.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblNumeroPrenoazioni.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblNumeroPrenoazioni.setBounds(711, 438, 200, 20);
		add(lblNumeroPrenoazioni);

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

		lblRitardo = new JLabel("Ritardo");
		lblRitardo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRitardo.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblRitardo.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblRitardo.setBounds(810, 469, 101, 20);
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
		txtRitardo.setBounds(921, 469, 30, 20);
		add(txtRitardo);

		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setBounds(810, 35, 47, 30);
		add(lblNewLabel);
		
		txtOraArrivo = new JTextField();
		txtOraArrivo.setBounds(301, 570, 30, 20);
		add(txtOraArrivo);
		txtOraArrivo.setColumns(10);
		
		txtMinutoArrivo = new JTextField();
		txtMinutoArrivo.setBounds(343, 570, 30, 20);
		add(txtMinutoArrivo);
		txtMinutoArrivo.setColumns(10);
		
		JLabel lblOrarioArrivo = new JLabel("Orario arrivo");
		lblOrarioArrivo.setBounds(228, 574, 63, 14);
		add(lblOrarioArrivo);

		caricaTabella();
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
