package GUI;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classi.VoloPartenze;
import Controller.Controller;
import Immagini.Immagini;
import javax.swing.border.LineBorder;

public class RegistroVoliPartenze extends JPanel {
	Immagini img = new Immagini();

	String colonne[] = { "Cod. Voli Part.", "Comp. Aerea", "N°Gate", "Citta di Arrivo", "Data e Orario Partenza",
			"Apertura Gate", "Chiusura Gate", "N° Prenotazioni", "Status Imbarco", "Status Volo" };
	VoloPartenze[] row = new VoloPartenze[11];
	DefaultTableModel modello = new DefaultTableModel(new Object[][] {},
			new String[] { "Cod. Voli Part.", "Comp. Aerea", "N\u00B0Gate", "Citta di Arrivo", "Data e Orario Partenza",
					"Apertura Gate", "Chiusura Gate", "N\u00B0 Prenotazioni", "Status Imbarco", "Status Volo" });
	List<VoloPartenze> ListaVoliPartenze = new ArrayList<>();

	private JTextField txtBarraRicerca;
	private JScrollPane scrollPane;

	private JTable tabella;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblRicaricaTabella;

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

	public JLabel getLblRicaricaTabella() {
		return lblRicaricaTabella;
	}

	public void setLblRicaricaTabella(JLabel lblRicaricaTabella) {
		this.lblRicaricaTabella = lblRicaricaTabella;
	}

	Controller controllerRegistroVoliPartenza;

	public RegistroVoliPartenze(Controller controller) {
		controllerRegistroVoliPartenza = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerRegistroVoliPartenza.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerRegistroVoliPartenza.setPannelloPrecedente(9);
				controllerRegistroVoliPartenza
						.mostraPannelli(controllerRegistroVoliPartenza.getDashboard().getGestioneVoliPartenze());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblimgfrecciaIndietro,
						img.frecciaIndietro2TemaChiaro(), img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblimgfrecciaIndietro,
						img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblimgfrecciaIndietro,
						img.frecciaIndietro3TemaChiaro(), img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblimgfrecciaIndietro,
						img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(30, 47, 30, 30);
		add(lblimgfrecciaIndietro);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerRegistroVoliPartenza.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerRegistroVoliPartenza.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerRegistroVoliPartenza.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 52, 141, 21);
		txtBarraRicerca.setColumns(10);
		add(txtBarraRicerca);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 47, 184, 30);
		add(lblBarraRicerca);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(controllerRegistroVoliPartenza.bordiTemaScuro));
		scrollPane.setBounds(30, 85, 1030, 530);
		add(scrollPane);

		tabella = new JTable();
		tabella.setRowSelectionAllowed(false);
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		tabella.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabella.getColumnModel().getColumn(0).setMinWidth(60);
		tabella.getColumnModel().getColumn(0).setMaxWidth(110);
		tabella.getColumnModel().getColumn(1).setPreferredWidth(90);
		tabella.getColumnModel().getColumn(1).setMinWidth(70);
		tabella.getColumnModel().getColumn(1).setMaxWidth(100);
		tabella.getColumnModel().getColumn(2).setPreferredWidth(50);
		tabella.getColumnModel().getColumn(2).setMinWidth(30);
		tabella.getColumnModel().getColumn(2).setMaxWidth(60);
		tabella.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabella.getColumnModel().getColumn(3).setMinWidth(80);
		tabella.getColumnModel().getColumn(3).setMaxWidth(110);
		tabella.getColumnModel().getColumn(4).setPreferredWidth(150);
		tabella.getColumnModel().getColumn(4).setMinWidth(100);
		tabella.getColumnModel().getColumn(4).setMaxWidth(200);
		tabella.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabella.getColumnModel().getColumn(5).setMinWidth(90);
		tabella.getColumnModel().getColumn(5).setMaxWidth(120);
		tabella.getColumnModel().getColumn(6).setPreferredWidth(110);
		tabella.getColumnModel().getColumn(6).setMinWidth(90);
		tabella.getColumnModel().getColumn(6).setMaxWidth(120);
		tabella.getColumnModel().getColumn(7).setPreferredWidth(120);
		tabella.getColumnModel().getColumn(7).setMinWidth(50);
		tabella.getColumnModel().getColumn(7).setMaxWidth(130);
		tabella.getColumnModel().getColumn(8).setPreferredWidth(110);
		tabella.getColumnModel().getColumn(8).setMinWidth(90);
		tabella.getColumnModel().getColumn(8).setMaxWidth(120);
		tabella.getColumnModel().getColumn(9).setPreferredWidth(110);
		tabella.getColumnModel().getColumn(9).setMinWidth(90);
		tabella.getColumnModel().getColumn(9).setMaxWidth(120);
		scrollPane.setViewportView(tabella);

		lblRicaricaTabella = new JLabel("");
		lblRicaricaTabella.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRicaricaTabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aggiorna();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(),
						img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(),
						img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerRegistroVoliPartenza.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}
		});
		lblRicaricaTabella.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicaricaTabella.setIcon(new ImageIcon(img.aggiorna1()));
		lblRicaricaTabella.setBounds(830, 47, 30, 30);
		add(lblRicaricaTabella);

		caricaTabella();
	}

	public void caricaTabella() {
		try {
			this.ListaVoliPartenze = controllerRegistroVoliPartenza.implementazioneVoloPartenzeDAO()
					.stampaRegistroVoliPartenze();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (VoloPartenze dato : this.ListaVoliPartenze) {
			this.modello.addRow(new Object[] { dato.getCodiceVoloPartenze(), dato.getCompAerea().getNome(),
					dato.getGt().getNumeroPorta(), dato.getTrt().getCittaArrivo(), dato.getDataOrarioPartenza(),
					dato.getAperturaGate(), dato.getChiusuraGate(), dato.getNumeroPrenotazioni(),
					dato.getStatusImbarco(), dato.getStatusVolo() });
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

	private void aggiorna() {
		caricaTabella();
	}

}
