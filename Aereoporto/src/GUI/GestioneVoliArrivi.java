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

import com.toedter.calendar.JDateChooser;

import Classi.VoloArrivi;
import Controller.Controller;
import Immagini.Immagini;
import javax.swing.border.LineBorder;

public class GestioneVoliArrivi extends JPanel {
	Immagini img = new Immagini();

	String colonne[] = { "Codice Volo Arrivi", "Citta di Partenza", "Data e Orario Arrivo" };
	VoloArrivi[] row = new VoloArrivi[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	List<VoloArrivi> ListaVoliArrivi = new ArrayList<VoloArrivi>();

	private JTextField txtCodiceVoloArrivi;
	private JTextField txtCittaPartenza;
	private JTextField txtOraArrivo;
	private JTextField txtMinutoArrivo;
	private JTextField txtBarraRicerca;

	private JDateChooser dateDataArrivo;

	private JScrollPane scrollPane;

	private JTable tabella;

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
	private JLabel lblRicaricaTabella;
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

	public JLabel getLblRicaricaTabella() {
		return lblRicaricaTabella;
	}

	public void setLblRicaricaTabella(JLabel lblRicaricaTabella) {
		this.lblRicaricaTabella = lblRicaricaTabella;
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
				controllerGestioneVoliArrivi.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(),
						img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(),
						img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(),
						img.frecciaIndietro1());
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
		txtBarraRicerca.setBackground(controllerGestioneVoliArrivi.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneVoliArrivi.fontScritteGestioni);
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
		scrollPane.setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		txtCodiceVoloArrivi.setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		txtCodiceVoloArrivi.setBounds(170, 437, 75, 22);
		add(txtCodiceVoloArrivi);

		lblCodiceVoloArrivi = new JLabel("Codice Volo Arrivi");
		lblCodiceVoloArrivi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoloArrivi.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblCodiceVoloArrivi.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblCodiceVoloArrivi.setBounds(30, 438, 130, 20);
		add(lblCodiceVoloArrivi);

		lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblCittaPartenza.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblCittaPartenza.setBounds(30, 475, 130, 20);
		add(lblCittaPartenza);

		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		txtCittaPartenza.setBounds(170, 474, 133, 22);
		add(txtCittaPartenza);

		lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblDataArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblDataArrivo.setBounds(329, 438, 91, 20);
		add(lblDataArrivo);

		dateDataArrivo = new JDateChooser();
		dateDataArrivo.getCalendarButton().setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		dateDataArrivo.setBounds(430, 437, 133, 22);
		add(dateDataArrivo);

		lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblOrarioArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblOrarioArrivo.setBounds(329, 475, 91, 20);
		add(lblOrarioArrivo);

		txtOraArrivo = new JTextField();
		txtOraArrivo.setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		txtOraArrivo.setBounds(430, 474, 30, 22);
		add(txtOraArrivo);

		txtMinutoArrivo = new JTextField();
		txtMinutoArrivo.setBorder(new LineBorder(controllerGestioneVoliArrivi.bordiTemaScuro));
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
		txtMinutoArrivo.setBounds(488, 474, 30, 22);
		add(txtMinutoArrivo);

		lblDuePuntiArrivo = new JLabel(":");
		lblDuePuntiArrivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuePuntiArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblDuePuntiArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblDuePuntiArrivo.setBounds(470, 478, 10, 14);
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
				controllerGestioneVoliArrivi.cambioImmagineTema(lblAggiungi, img.aggiungi2TemaChiaro(),
						img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblAggiungi, img.aggiungi3TemaChiaro(),
						img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(),
						img.aggiungi1());
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
				controllerGestioneVoliArrivi.cambioImmagineTema(lblModifica, img.modifica2TemaChiaro(),
						img.modifica2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(),
						img.modifica1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblModifica, img.modifica3TemaChiaro(),
						img.modifica3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(),
						img.modifica1());
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
				controllerGestioneVoliArrivi.cambioImmagineTema(lblElimina, img.elimina2TemaChiaro(), img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblElimina, img.elimina3TemaChiaro(), img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
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
				controllerGestioneVoliArrivi.svuotaCampiGestioneVoloArrivi();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblSvuota, img.svuota2TemaChiaro(), img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblSvuota, img.svuota3TemaChiaro(), img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(602, 569, 130, 36);
		add(lblSvuota);

		lblRicaricaTabella = new JLabel("");
		lblRicaricaTabella.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRicaricaTabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aggiorna();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(),
						img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
						img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(),
						img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliArrivi.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(),
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
			this.ListaVoliArrivi = controllerGestioneVoliArrivi.implementazioneVoloArriviDAO().stampaVoliArrivi();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (VoloArrivi dato : this.ListaVoliArrivi) {
			this.modello.addRow(
					new Object[] { dato.getCodiceVoloArrivi(), dato.getCittaPartenza(), dato.getDataOrarioPartenza() });
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
