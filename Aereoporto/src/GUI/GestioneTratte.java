package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

import Classi.CompagniaAerea;
import Classi.Tratta;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class GestioneTratte extends JPanel {

	String colonne[] = { "Codice Tratta", "Citta Partenza", "Citta Arrivo", "Nome Compagnia Aerea" };
	Tratta[] row = new Tratta[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	List<Tratta> ListaTratte = new ArrayList<Tratta>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceTratta;
	private JTextField txtCittaPartenza;
	private JTextField txtCittaArrivo;
	private JTextField txtCodiceCompagniaAerea;
	
	private JTable tabella;
	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblCompagniaAerea;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceTratta;
	private JLabel lblCittaPartenza;
	private JLabel lblCittaArrivo;
	
	private JLabel lblAggiungi;
	private JLabel lblModifica;
	private JLabel lblElimina;
	private JLabel lblSvuota;
	private JLabel lblRicaricaTabella;
	
	private JComboBox<String> comboBoxNomeCompagniaAerea;
	
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

	public JTextField getTxtCodiceCompagniaAerea() {
		return txtCodiceCompagniaAerea;
	}

	public void setTxtCodiceCompagniaAerea(JTextField txtCodiceCompagniaAerea) {
		this.txtCodiceCompagniaAerea = txtCodiceCompagniaAerea;
	}

	public JLabel getLblCompagniaAerea() {
		return lblCompagniaAerea;
	}

	public void setLblCompagniaAerea(JLabel lblCompagniaAerea) {
		this.lblCompagniaAerea = lblCompagniaAerea;
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

	public JComboBox<String> getComboBoxNomeCompagniaAerea() {
		return comboBoxNomeCompagniaAerea;
	}

	public void setComboBoxNomeCompagniaAerea(JComboBox<String> comboBoxNomeCompagniaAerea) {
		this.comboBoxNomeCompagniaAerea = comboBoxNomeCompagniaAerea;
	}

	public JLabel getLblRicaricaTabella() {
		return lblRicaricaTabella;
	}

	public void setLblRicaricaTabella(JLabel lblRicaricaTabella) {
		this.lblRicaricaTabella = lblRicaricaTabella;
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
				controllerGestioneTratte.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(), img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(), img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
		lblimgfrecciaIndietro.setBounds(25, 47, 30, 30);
		add(lblimgfrecciaIndietro);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerGestioneTratte.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 52, 141, 21);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(871, 47, 184, 30);
		add(lblBarraRicerca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(controllerGestioneTratte.bordi));
		scrollPane.setBounds(25, 85, 1030, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGestioneTratte.eliminaTratta();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceTratta.setText(modello.getValueAt(t, 0).toString());
				txtCittaPartenza.setText(modello.getValueAt(t, 1).toString());
				txtCittaArrivo.setText(modello.getValueAt(t, 2).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);

		txtCodiceTratta = new JTextField();
		txtCodiceTratta.setBorder(new LineBorder(controllerGestioneTratte.bordi));
		txtCodiceTratta.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodiceTratta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneTratte.aggiungiTratta();
				}
			}
		});
		txtCodiceTratta.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCodiceTratta.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCodiceTratta.setColumns(10);
		txtCodiceTratta.setBounds(233, 445, 133, 20);
		add(txtCodiceTratta);

		lblCodiceTratta = new JLabel("Codice Tratta");
		lblCodiceTratta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceTratta.setFont(controllerGestioneTratte.fontLabel);
		lblCodiceTratta.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCodiceTratta.setBounds(37, 445, 186, 20);
		add(lblCodiceTratta);

		lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setFont(controllerGestioneTratte.fontLabel);
		lblCittaPartenza.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCittaPartenza.setBounds(536, 445, 114, 20);
		add(lblCittaPartenza);

		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setBorder(new LineBorder(controllerGestioneTratte.bordi));
		txtCittaPartenza.setHorizontalAlignment(SwingConstants.LEFT);
		txtCittaPartenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneTratte.aggiungiTratta();
				}
			}
		});
		txtCittaPartenza.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCittaPartenza.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(660, 445, 133, 20);
		add(txtCittaPartenza);

		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setBorder(new LineBorder(controllerGestioneTratte.bordi));
		txtCittaArrivo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCittaArrivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneTratte.aggiungiTratta();
				}
			}
		});
		txtCittaArrivo.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCittaArrivo.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(660, 485, 133, 20);
		add(txtCittaArrivo);

		lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setFont(controllerGestioneTratte.fontLabel);
		lblCittaArrivo.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCittaArrivo.setBounds(536, 485, 114, 20);
		add(lblCittaArrivo);

		lblCompagniaAerea = new JLabel("Codice Compagnia Aerea");
		lblCompagniaAerea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompagniaAerea.setFont(controllerGestioneTratte.fontLabel);
		lblCompagniaAerea.setForeground(controllerGestioneTratte.coloreScritteTemaScuro);
		lblCompagniaAerea.setBounds(40, 485, 183, 20);
		add(lblCompagniaAerea);

		txtCodiceCompagniaAerea = new JTextField();
		txtCodiceCompagniaAerea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneTratte.aggiungiVoloPartenze();
				}
			}
		});
		txtCodiceCompagniaAerea.setForeground(controllerGestioneTratte.coloreScritteSuBiancoTemaScuro);
		txtCodiceCompagniaAerea.setFont(controllerGestioneTratte.fontScritteGestioni);
		txtCodiceCompagniaAerea.setEditable(false);
		txtCodiceCompagniaAerea.setColumns(10);
		txtCodiceCompagniaAerea.setBounds(233, 485, 0, 20);
		add(txtCodiceCompagniaAerea);

		comboBoxNomeCompagniaAerea = new JComboBox<String>();
		comboBoxNomeCompagniaAerea.setBorder(new LineBorder(controllerGestioneTratte.bordi));
		comboBoxNomeCompagniaAerea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> map = null;
				try {
					map = controllerGestioneTratte.implementazioneCompagniaAereaDAO()
							.stampaNomeCompagniaAereaInComboBox();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (comboBoxNomeCompagniaAerea.getSelectedIndex() == 0) {
                    txtCodiceTratta.setText("");
                } else {
                	txtCodiceCompagniaAerea.setText(map.get(comboBoxNomeCompagniaAerea.getSelectedItem().toString()));
                }
            }
        });
        comboBoxNomeCompagniaAerea.addItem("----------");
		comboBoxNomeCompagniaAerea.setBounds(243, 485, 95, 20);
		add(comboBoxNomeCompagniaAerea);
		
		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.aggiungiTratta();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblAggiungi, img.aggiungi2TemaChiaro(), img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblAggiungi, img.aggiungi3TemaChiaro(), img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
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
				controllerGestioneTratte.modificaTratta();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblModifica, img.modifica2TemaChiaro(), img.modifica2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblModifica, img.modifica3TemaChiaro(), img.modifica3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
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
				controllerGestioneTratte.eliminaTratta();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblElimina, img.elimina2TemaChiaro(), img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblElimina, img.elimina3TemaChiaro(), img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
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
				controllerGestioneTratte.svuotaCampiGestioneTratta();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblSvuota, img.svuota2TemaChiaro(), img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblSvuota, img.svuota3TemaChiaro(), img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
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
				controllerGestioneTratte.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(), img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(), img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneTratte.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
			}
		});
		lblRicaricaTabella.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicaricaTabella.setIcon(new ImageIcon(img.aggiorna1()));
		lblRicaricaTabella.setBounds(830, 47, 30, 30);
		add(lblRicaricaTabella);
		
		stampaComboBoxNomeCompagniaAerea();
		caricaTabella();
	}

	public void caricaTabella() {
		try {
			this.ListaTratte = controllerGestioneTratte.implementazioneTrattaDAO().stampaTratte();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (Tratta dato : this.ListaTratte) {
			this.modello.addRow(new Object[] {dato.getCodiceTratta(), dato.getCittaPartenza(), dato.getCittaArrivo(), dato.getCompagniaAerea().getCodiceCompagniaAerea()});
		}
		tabella.setModel(modello);
	}

	public void stampaComboBoxNomeCompagniaAerea() {
		HashMap<String, String> map = null;
		try {
			map = controllerGestioneTratte.implementazioneCompagniaAereaDAO()
					.stampaNomeCompagniaAereaInComboBox();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (String s : map.keySet()) {
			comboBoxNomeCompagniaAerea.addItem(s);
		}
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
		controllerGestioneTratte.rimuoviElementiComboBox(comboBoxNomeCompagniaAerea);
		stampaComboBoxNomeCompagniaAerea();
		comboBoxNomeCompagniaAerea.removeItemAt(0);
	}
}
