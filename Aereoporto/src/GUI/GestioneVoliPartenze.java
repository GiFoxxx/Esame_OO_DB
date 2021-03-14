package GUI;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

import Classi.VoloPartenze;
import Controller.Controller;
import Immagini.Immagini;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class GestioneVoliPartenze extends JPanel {

	String colonne[] = { "Cod. Voli Part.", "Comp. Aerea", "N°Gate", "Citta di Arrivo", "Data e Orario Partenza",
			"Apertura Gate", "Chiusura Gate", "N° Prenotazioni", "Status Imbarco", "Status Volo" };
	VoloPartenze[] row = new VoloPartenze[11];
	DefaultTableModel modello = new DefaultTableModel(new Object[][] {},
			new String[] { "Cod. Voli Part.", "Comp. Aerea", "N\u00B0Gate", "Citta di Arrivo",
					"Data e Orario Partenza", "Apertura Gate", "Chiusura Gate", "N\u00B0 Prenotazioni",
					"Status Imbarco", "Status Volo" });
	List<VoloPartenze> ListaVoliPartenze = new ArrayList<>();
	private Immagini img = new Immagini();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private JTextField txtCodiceVoloPartenze;
	private JDateChooser dateDataPartenza;
	private JTextField txtCodiceTratta;
	private JTextField txtCodiceGate;
	private JTextField txtOraPartenza;
	private JTextField txtMinutoPartenza;
	private JTextField txtNumeroPrenotazioni;
	private JTextField txtStatus;
	private JTextField txtTempoDiImbarcoEffettivo;
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
	private JLabel lblTempoDiImbarcoEffettivo;
	private JLabel lblStatus;

	private JLabel lblAggiungi;
	private JLabel lblModifica;
	private JLabel lblElimina;
	private JLabel lblSvuota;
	private JLabel lblRicaricaTabella;
	private JLabel lblMessaggioErrore;

	private JComboBox<String> comboBoxStatus;
	private JComboBox<String> comboBoxNumeroPorta;
	private JComboBox<String> comboBoxCittaArrivo;

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

	public JTextField getTxtTempoDiImbarcoEffettivo() {
		return txtTempoDiImbarcoEffettivo;
	}

	public void setTxtTempoDiImbarcoEffettivo(JTextField txtTempoDiImbarcoEffettivo) {
		this.txtTempoDiImbarcoEffettivo = txtTempoDiImbarcoEffettivo;
	}

	public JLabel getLblTempoDiImbarcoEffettivo() {
		return lblTempoDiImbarcoEffettivo;
	}

	public void setLblTempoDiImbarcoEffettivo(JLabel lblTempoDiImbarcoEffettivo) {
		this.lblTempoDiImbarcoEffettivo = lblTempoDiImbarcoEffettivo;
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

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public void setLblStatus(JLabel lblStatus) {
		this.lblStatus = lblStatus;
	}

	public JComboBox<String> getComboBoxStatus() {
		return comboBoxStatus;
	}

	public void setComboBoxStatus(JComboBox<String> comboBoxStatus) {
		this.comboBoxStatus = comboBoxStatus;
	}

	public JTextField getTxtStatus() {
		return txtStatus;
	}

	public void setTxtStatus(JTextField txtStatus) {
		this.txtStatus = txtStatus;
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
				controllerGestioneVoliPartenze.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(), img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(), img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
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
		txtBarraRicerca.setBackground(controllerGestioneVoliPartenze.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
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
			}
		});
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
		lblDataPartenza.setBounds(351, 438, 184, 20);
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
		lblOrarioPartenza.setBounds(351, 469, 184, 20);
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
		txtCodiceTratta.setBounds(223, 500, 0, 20);
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
		txtCodiceGate.setBounds(223, 469, 0, 20);
		add(txtCodiceGate);

		comboBoxNumeroPorta = new JComboBox<String>();
		comboBoxNumeroPorta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGestioneVoliPartenze.implementazioneGateDAO().stampaNumeroPortaInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (comboBoxNumeroPorta.getSelectedIndex() == 0) {
                    txtCodiceGate.setText("");
                } else {
                    txtCodiceGate.setText(map.get(comboBoxNumeroPorta.getSelectedItem().toString()));
                }
            }
        });
        comboBoxNumeroPorta.addItem("---");
		comboBoxNumeroPorta.setBounds(223, 469, 40, 20);
		add(comboBoxNumeroPorta);

		comboBoxCittaArrivo = new JComboBox<String>();
		comboBoxCittaArrivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGestioneVoliPartenze.implementazioneTrattaDAO().stampaCittaArrivoInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (comboBoxCittaArrivo.getSelectedIndex() == 0) {
                    txtCodiceTratta.setText("");
                } else {
                    txtCodiceTratta.setText(map.get(comboBoxCittaArrivo.getSelectedItem().toString()));
                }
            }
        });
        comboBoxCittaArrivo.addItem("----------");
		comboBoxCittaArrivo.setBounds(223, 500, 95, 20);
		add(comboBoxCittaArrivo);

		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoliPartenze.aggiungiVoloPartenze();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblAggiungi, img.aggiungi2TemaChiaro(), img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblAggiungi, img.aggiungi3TemaChiaro(), img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
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
				if (getTxtMinutoPartenza().getText().length() <= 0) {
					controllerGestioneVoliPartenze.modificaStatusVoloPartenze();
				} else {
					controllerGestioneVoliPartenze.modificaVoloPartenze();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblModifica, img.modifica2TemaChiaro(), img.modifica2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblModifica, img.modifica3TemaChiaro(), img.modifica3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
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
				controllerGestioneVoliPartenze.eliminaVoloPartenze();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblElimina, img.elimina2TemaChiaro(), img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblElimina, img.elimina3TemaChiaro(), img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
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
				controllerGestioneVoliPartenze.svuotaCampiGestioneVoloPartenze();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblSvuota, img.svuota2TemaChiaro(), img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblSvuota, img.svuota3TemaChiaro(), img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
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
				caricaTabella();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(), img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(), img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneVoliPartenze.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
			}
		});
		lblRicaricaTabella.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicaricaTabella.setIcon(new ImageIcon(img.aggiorna1()));
		lblRicaricaTabella.setBounds(830, 47, 30, 30);
		add(lblRicaricaTabella);

		lblMessaggioErrore = new JLabel("");
		lblMessaggioErrore.setForeground(controllerGestioneVoliPartenze.coloreScritturaAllertaTemaScuro);
		lblMessaggioErrore.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblMessaggioErrore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessaggioErrore.setBounds(223, 24, 633, 14);
		add(lblMessaggioErrore);

		lblStatus = new JLabel("Status Volo");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblStatus.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblStatus.setBounds(694, 469, 162, 20);
		add(lblStatus);

		txtStatus = new JTextField();
		txtStatus.setHorizontalAlignment(SwingConstants.LEFT);
		txtStatus.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtStatus.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(866, 469, 0, 20);
		add(txtStatus);

		comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBoxStatus.getSelectedIndex()) {
                case 0:
                    txtStatus.setText("");
                    break;
                case 1:
                    txtStatus.setText("In programma");
                    break;
                case 2:
                    txtStatus.setText("In preparazione");
                    break;
                case 3:
                    txtStatus.setText("In partenza");
                    break;
                case 4:
                    txtStatus.setText("In ritardo");
                    break;
                default:
                    txtStatus.setText("In programma");
                    break;
                }
            }
        });
        comboBoxStatus.addItem("----------");
		comboBoxStatus.addItem("In programma");
		comboBoxStatus.addItem("In preparazione");
		comboBoxStatus.addItem("In partenza");
		comboBoxStatus.addItem("In ritardo");
		comboBoxStatus.setBounds(866, 469, 123, 20);
		add(comboBoxStatus);

		lblTempoDiImbarcoEffettivo = new JLabel("Tempo Di Imbarco Effettivo");
		lblTempoDiImbarcoEffettivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempoDiImbarcoEffettivo.setForeground(controllerGestioneVoliPartenze.coloreScritteTemaScuro);
		lblTempoDiImbarcoEffettivo.setFont(controllerGestioneVoliPartenze.fontLabel);
		lblTempoDiImbarcoEffettivo.setBounds(352, 500, 184, 20);
		add(lblTempoDiImbarcoEffettivo);

		txtTempoDiImbarcoEffettivo = new JTextField();
		txtTempoDiImbarcoEffettivo.setForeground(controllerGestioneVoliPartenze.coloreScritteSuBiancoTemaScuro);
		txtTempoDiImbarcoEffettivo.setFont(controllerGestioneVoliPartenze.fontScritteGestioni);
		txtTempoDiImbarcoEffettivo.setColumns(10);
		txtTempoDiImbarcoEffettivo.setBounds(545, 500, 48, 20);
		add(txtTempoDiImbarcoEffettivo);

		stampaComboBoxNumeroPorta();
		stampaComboBoxCittaArrivo();

		caricaTabella();
	}

	public void stampaComboBoxNumeroPorta() {
		HashMap<String, String> map = null;
		try {
			map = controllerGestioneVoliPartenze.implementazioneGateDAO().stampaNumeroPortaInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String s : map.keySet()) {
			comboBoxNumeroPorta.addItem(s);
		}
	}

	public void stampaComboBoxCittaArrivo() {
		HashMap<String, String> map = null;
		try {
			map = controllerGestioneVoliPartenze.implementazioneTrattaDAO().stampaCittaArrivoInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (String s : map.keySet()) {
			comboBoxCittaArrivo.addItem(s);
		}
	}

	public void caricaTabella() {
		try {
			this.ListaVoliPartenze = controllerGestioneVoliPartenze.implementazioneVoloPartenzeDAO()
					.stampaVoliPartenze();
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

	public String getDateDataPartenzaDateFormatString() {
		return dateDataPartenza.getDateFormatString();
	}

	public void setDateDataPartenzaDateFormatString(String dateFormatString) {
		dateDataPartenza.setDateFormatString(dateFormatString);
	}
}
