package GUI;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import Immagini.Immagini;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class GestioneVoliArrivi extends JPanel {

	String colonne[] = { "Codice Volo Arrivi", "Citta di Partenza", "Data Arrivo", "Orario Arrivo" };
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

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceVoloArrivi;
	private JLabel lblCittaPartenza;
	private JLabel lblDataArrivo;
	private JLabel lblOrarioArrivo;
	private JLabel lblDuePuntiArrivo;

	private JLabel lblAggiungi;
	private JLabel lblModifica;
	private JLabel lblElimina;
	private JLabel lblSvuota;
	private JLabel lblMessaggioErrore;

	// GETTER E SETTER
	public JLabel getLblMessaggioErrore() {
		return lblMessaggioErrore;
	}

	public void setLblMessaggioErrore(JLabel lblMessaggioErrore) {
		this.lblMessaggioErrore = lblMessaggioErrore;
	}

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

	public JLabel getLblCodiceVoloArrivi() {
		return lblCodiceVoloArrivi;
	}

	public void setLblCodiceVoloArrivi(JLabel lblCodiceVoloArrivi) {
		this.lblCodiceVoloArrivi = lblCodiceVoloArrivi;
	}

	public JLabel getLblCittaPartenza() {
		return lblCittaPartenza;
	}

	public void setLblCittaPartenza(JLabel lblCittaPartenza) {
		this.lblCittaPartenza = lblCittaPartenza;
	}

	public JLabel getLblDataArrivo() {
		return lblDataArrivo;
	}

	public void setLblDataArrivo(JLabel lblDataArrivo) {
		this.lblDataArrivo = lblDataArrivo;
	}

	public JLabel getLblOraArrivo() {
		return lblOrarioArrivo;
	}

	public void setLblOraArrivo(JLabel lblOraArrivo) {
		this.lblOrarioArrivo = lblOraArrivo;
	}

	public JLabel getLblDuePuntiArrivo() {
		return lblDuePuntiArrivo;
	}

	public void setLblDuePuntiArrivo(JLabel lblDuePuntiArrivo) {
		this.lblDuePuntiArrivo = lblDuePuntiArrivo;
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

	public JLabel getLblAggiungi() {
		return lblAggiungi;
	}

	public void setLblAggiungi(JLabel lblAggiungi) {
		this.lblAggiungi = lblAggiungi;
	}

	public JLabel getLblModifica() {
		return lblModifica;
	}

	public void setLblModifica(JLabel lblModifica) {
		this.lblModifica = lblModifica;
	}

	public JLabel getLblElimina() {
		return lblElimina;
	}

	public void setLblElimina(JLabel lblElimina) {
		this.lblElimina = lblElimina;
	}

	public JLabel getLblSvuota() {
		return lblSvuota;
	}

	public void setLblSvuota(JLabel lblSvuota) {
		this.lblSvuota = lblSvuota;
	}

	Controller controllerGestioneVoliArrivi;

	public GestioneVoliArrivi(Controller controller) {
		controllerGestioneVoliArrivi = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneVoliArrivi.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
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
		txtBarraRicerca.setBackground(controllerGestioneVoliArrivi.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 40, 141, 20);
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
					controllerGestioneVoliArrivi.eliminaVoloArrivi();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceVoloArrivi.setText(modello.getValueAt(t, 0).toString());
				txtCittaPartenza.setText(modello.getValueAt(t, 1).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);

		txtCodiceVoloArrivi = new JTextField();
		txtCodiceVoloArrivi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliArrivi.aggiungiVoloArrivi();
				}
			}
		});
		txtCodiceVoloArrivi.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBiancoTemaScuro);
		txtCodiceVoloArrivi.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		txtCodiceVoloArrivi.setColumns(10);
		txtCodiceVoloArrivi.setBounds(240, 438, 133, 20);
		add(txtCodiceVoloArrivi);

		lblCodiceVoloArrivi = new JLabel("Codice Volo Arrivi");
		lblCodiceVoloArrivi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloArrivi.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblCodiceVoloArrivi.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblCodiceVoloArrivi.setBounds(30, 438, 200, 20);
		add(lblCodiceVoloArrivi);

		lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblCittaPartenza.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblCittaPartenza.setBounds(30, 475, 200, 20);
		add(lblCittaPartenza);

		txtCittaPartenza = new JTextField();
		txtCittaPartenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliArrivi.aggiungiVoloArrivi();
				}
			}
		});
		txtCittaPartenza.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBiancoTemaScuro);
		txtCittaPartenza.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(240, 475, 133, 20);
		add(txtCittaPartenza);

		lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblDataArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblDataArrivo.setBounds(479, 438, 200, 20);
		add(lblDataArrivo);

		dateDataArrivo = new JDateChooser();
		dateDataArrivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliArrivi.aggiungiVoloArrivi();
				}
			}
		});
		dateDataArrivo.setDateFormatString("dd/MM/yyyy");
		dateDataArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBiancoTemaScuro);
		dateDataArrivo.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		dateDataArrivo.setBounds(689, 438, 133, 20);
		add(dateDataArrivo);

		lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblOrarioArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblOrarioArrivo.setBounds(479, 475, 200, 20);
		add(lblOrarioArrivo);

		txtOraArrivo = new JTextField();
		txtOraArrivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliArrivi.aggiungiVoloArrivi();
				}
			}
		});
		txtOraArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBiancoTemaScuro);
		txtOraArrivo.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		txtOraArrivo.setColumns(10);
		txtOraArrivo.setBounds(689, 475, 30, 20);
		add(txtOraArrivo);

		txtMinutoArrivo = new JTextField();
		txtMinutoArrivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneVoliArrivi.aggiungiVoloArrivi();
				}
			}
		});
		txtMinutoArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteSuBiancoTemaScuro);
		txtMinutoArrivo.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
		txtMinutoArrivo.setColumns(10);
		txtMinutoArrivo.setBounds(743, 475, 30, 20);
		add(txtMinutoArrivo);

		lblDuePuntiArrivo = new JLabel(":");
		lblDuePuntiArrivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblDuePuntiArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblDuePuntiArrivo.setBounds(729, 478, 10, 14);
		add(lblDuePuntiArrivo);

		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.aggiungiVoloArrivi();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblAggiungi.setIcon(new ImageIcon(img.aggiungi3()));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));

			}

		});
		lblAggiungi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));
		lblAggiungi.setBounds(358, 569, 130, 36);
		add(lblAggiungi);

		lblModifica = new JLabel("");
		lblModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.modificaVoloArrivi();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblModifica.setIcon(new ImageIcon(img.modifica2()));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblModifica.setIcon(new ImageIcon(img.modifica1()));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblModifica.setIcon(new ImageIcon(img.modifica3()));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblModifica.setIcon(new ImageIcon(img.modifica2()));

			}
		});
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setIcon(new ImageIcon(img.modifica1()));
		lblModifica.setBounds(114, 569, 130, 36);
		add(lblModifica);

		lblElimina = new JLabel("");
		lblElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.eliminaVoloArrivi();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblElimina.setIcon(new ImageIcon(img.elimina2()));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblElimina.setIcon(new ImageIcon(img.elimina1()));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblElimina.setIcon(new ImageIcon(img.elimina3()));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblElimina.setIcon(new ImageIcon(img.elimina2()));

			}
		});
		lblElimina.setHorizontalAlignment(SwingConstants.CENTER);
		lblElimina.setIcon(new ImageIcon(img.elimina1()));
		lblElimina.setBounds(846, 569, 130, 36);
		add(lblElimina);

		lblSvuota = new JLabel("");
		lblSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliArrivi.svuotaCampiGestioneVoloPartenze();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSvuota.setIcon(new ImageIcon(img.svuota2()));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSvuota.setIcon(new ImageIcon(img.svuota1()));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				lblSvuota.setIcon(new ImageIcon(img.svuota3()));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lblSvuota.setIcon(new ImageIcon(img.svuota2()));

			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(602, 569, 130, 36);
		add(lblSvuota);

		lblMessaggioErrore = new JLabel("");
		lblMessaggioErrore.setForeground(controllerGestioneVoliArrivi.coloreScritturaAllertaTemaScuro);
		lblMessaggioErrore.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblMessaggioErrore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioErrore.setBounds(223, 24, 633, 14);
		add(lblMessaggioErrore);

		caricaTabella();
	}

	public void caricaTabella() {
		this.ListaVoliArrivi = controllerGestioneVoliArrivi.implementazioneVoloArriviDAO().stampaVoliArrivi();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaVoliArrivi) {
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
