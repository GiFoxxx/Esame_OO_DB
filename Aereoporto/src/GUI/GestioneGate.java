package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class GestioneGate extends JPanel {

	String colonne[] = { "Codice Gate", "Numero Porta","Tempo Di Imbarco Stimato"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	ArrayList<String> ListaCodaDiImbarco = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;


	private JTable tabella;
	private JTextField txtBarraRicerca;

	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNumeroPorta;
	private JLabel lblCodiceGate;
	private JLabel lblTempoImbarcoStimato;
	
	private JLabel lblAggiungi;
	private JLabel lblModifica;
	private JLabel lblElimina;
	private JLabel lblSvuota;

	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
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

	public JLabel getLblNumeroPorta() {
		return lblNumeroPorta;
	}

	public void setLblNumeroPorta(JLabel lblNumeroPorta) {
		this.lblNumeroPorta = lblNumeroPorta;
	}

	public JLabel getLblCodiceGate() {
		return lblCodiceGate;
	}

	public void setLblCodiceGate(JLabel lblCodiceGate) {
		this.lblCodiceGate = lblCodiceGate;
	}

	public JTextField getTxtCodiceGate() {
		return txtCodiceGate;
	}

	public void setTxtCodiceGate(JTextField txtCodiceGate) {
		this.txtCodiceGate = txtCodiceGate;
	}

	public JTextField getTxtNumeroPorta() {
		return txtNumeroPorta;
	}

	public void setTxtNumeroPorta(JTextField txtNumeroPorta) {
		this.txtNumeroPorta = txtNumeroPorta;
	}

	public JTable getTabella() {
		return tabella;
	}

	public void setTabella(JTable table) {
		this.tabella = table;
	}

	public JLabel getLblTempoImbarcoStimato() {
		return lblTempoImbarcoStimato;
	}

	public void setLblTempoImbarcoStimato(JLabel lblTempoImbarcoStimato) {
		this.lblTempoImbarcoStimato = lblTempoImbarcoStimato;
	}

	public JTextField getTxtTempoImbarcoStimato() {
		return txtTempoImbarcoStimato;
	}

	public void setTxtTempoImbarcoStimato(JTextField txtTempoImbarcoStimato) {
		this.txtTempoImbarcoStimato = txtTempoImbarcoStimato;
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

	Controller controllerGestioneGate;
	private JTextField txtTempoImbarcoStimato;
	

	public GestioneGate(Controller controller) {
		controllerGestioneGate = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneGate.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.setPannelloPrecedente(1);
				controllerGestioneGate.mostraPannelli(controllerGestioneGate.getDashboard().getHome());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
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
		txtBarraRicerca.setBackground(controllerGestioneGate.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneGate.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(controllerGestioneGate.fontLabel);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(30, 85, 1030, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGestioneGate.eliminaGate();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceGate.setText(modello.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modello.getValueAt(t, 1).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);
		scrollPane.setViewportView(tabella);

		lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(controllerGestioneGate.fontLabel);
		lblNumeroPorta.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(30, 493, 204, 20);
		add(lblNumeroPorta);

		txtNumeroPorta = new JTextField();
		txtNumeroPorta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneGate.aggiungiGate();
				}
			}
		});
		txtNumeroPorta.setFont(controllerGestioneGate.fontScritteGestioni);
		txtNumeroPorta.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(244, 493, 180, 20);
		add(txtNumeroPorta);

		lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setFont(controllerGestioneGate.fontLabel);
		lblCodiceGate.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblCodiceGate.setBounds(30, 461, 204, 20);
		add(lblCodiceGate);

		txtCodiceGate = new JTextField();
		txtCodiceGate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneGate.aggiungiGate();
				}
			}
		});
		txtCodiceGate.setFont(controllerGestioneGate.fontScritteGestioni);
		txtCodiceGate.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(244, 461, 180, 20);
		add(txtCodiceGate);
		
		txtTempoImbarcoStimato = new JTextField();
		txtTempoImbarcoStimato.setForeground(controllerGestioneGate.coloreScritteSuBiancoTemaScuro);
		txtTempoImbarcoStimato.setFont(controllerGestioneGate.fontScritteGestioni);
		txtTempoImbarcoStimato.setColumns(10);
		txtTempoImbarcoStimato.setBounds(244, 527, 180, 20);
		add(txtTempoImbarcoStimato);
		
		lblTempoImbarcoStimato = new JLabel("Tempo di Imbarco Stimato");
		lblTempoImbarcoStimato.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempoImbarcoStimato.setForeground(controllerGestioneGate.coloreScritteTemaScuro);
		lblTempoImbarcoStimato.setFont(controllerGestioneGate.fontLabel);
		lblTempoImbarcoStimato.setBounds(30, 527, 204, 20);
		add(lblTempoImbarcoStimato);
		
		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGate();

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
				controllerGestioneGate.modificaGate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica3TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
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
				controllerGestioneGate.eliminaGate();
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
				controllerGestioneGate.svuotaCampiGestioneGate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneGate.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}
		});
		lblSvuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSvuota.setIcon(new ImageIcon(img.svuota1()));
		lblSvuota.setBounds(602, 569, 130, 36);
		add(lblSvuota);
		
		caricaTabella();

	}

	// METODI
	public void caricaTabella() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGate();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaGate) {
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
