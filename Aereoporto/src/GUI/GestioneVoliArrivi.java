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
import javax.swing.JComboBox;

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
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblCodiceVoloArrivi;
	private JLabel lblCittaPartenza;
	private JLabel lblDataArrivo;
	private JLabel lblOraArrivo;
	private JLabel lblMinutoArrivo;
	private JLabel lblDuePuntiArrivo;
	
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

	Controller controllerGestioneVoliArrivi;
	
	
	
	public GestioneVoliArrivi(Controller controller) {
		controllerGestioneVoliArrivi= controller;
		
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
		
		lblOraArrivo = new JLabel("Ora Arrivo");
		lblOraArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOraArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblOraArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblOraArrivo.setBounds(479, 475, 200, 20);
		add(lblOraArrivo);
		
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
		
		lblMinutoArrivo = new JLabel("Minuto Arrivo");
		lblMinutoArrivo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutoArrivo.setForeground(controllerGestioneVoliArrivi.coloreScritteTemaScuro);
		lblMinutoArrivo.setFont(controllerGestioneVoliArrivi.fontLabel);
		lblMinutoArrivo.setBounds(780, 475, 101, 20);
		add(lblMinutoArrivo);
		
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
				controllerGestioneVoliArrivi.svuotaCampiGestioneVoloPartenze();
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
