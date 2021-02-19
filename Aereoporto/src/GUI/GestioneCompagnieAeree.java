package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JButton;

public class GestioneCompagnieAeree extends JPanel {

	String colonne[] = { "Codice Compagnia aerea", "Nome" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaCompagnieAeree = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceCompagniaAerea;
	private JTextField txtNome;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblRicerca;
	private JLabel lblBarraRicerca;
	private JLabel lblNome;
	private JLabel lblCodiceCompagniaAerea;

	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
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

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblCodiceCompagniaAerea() {
		return lblCodiceCompagniaAerea;
	}

	public void setLblCodiceCompagniaAerea(JLabel lblCodiceCompagniaAerea) {
		this.lblCodiceCompagniaAerea = lblCodiceCompagniaAerea;
	}

	public JTextField getTxtCodiceCompagniaAerea() {
		return txtCodiceCompagniaAerea;
	}

	public void setTxtCodiceCompagniaAerea(JTextField txtCodiceCompagniaAerea) {
		this.txtCodiceCompagniaAerea = txtCodiceCompagniaAerea;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
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

	Controller controllerGestioneCompagnieAeree;
	

	public GestioneCompagnieAeree(Controller controller) {
		controllerGestioneCompagnieAeree = controller;

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneCompagnieAeree.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.setPannelloPrecedente(1);
				controllerGestioneCompagnieAeree.mostraPannelli(controllerGestioneCompagnieAeree.getDashboard().getHome());
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
		txtBarraRicerca.setBackground(controllerGestioneCompagnieAeree.coloreScritteTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBiancoTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneCompagnieAeree.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 40, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

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
					controllerGestioneCompagnieAeree.eliminaCompagniaAerea();
				}
			}
		});
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtCodiceCompagniaAerea.setText(modello.getValueAt(t, 0).toString());
				txtNome.setText(modello.getValueAt(t, 1).toString());
			}
		});

		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);

		scrollPane.setViewportView(tabella);

		txtCodiceCompagniaAerea = new JTextField();
		txtCodiceCompagniaAerea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();
				}
			}
		});
		txtCodiceCompagniaAerea.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBiancoTemaScuro);
		txtCodiceCompagniaAerea.setFont(controllerGestioneCompagnieAeree.fontScritteGestioni);
		txtCodiceCompagniaAerea.setColumns(10);
		txtCodiceCompagniaAerea.setBounds(304, 459, 133, 20);
		add(txtCodiceCompagniaAerea);

		lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(controllerGestioneCompagnieAeree.coloreScritteTemaScuro);
		lblNome.setFont(controllerGestioneCompagnieAeree.fontLabel);
		lblNome.setBounds(53, 490, 221, 20);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();
				}
			}
		});
		txtNome.setForeground(controllerGestioneCompagnieAeree.coloreScritteSuBiancoTemaScuro);
		txtNome.setFont(controllerGestioneCompagnieAeree.fontScritteGestioni);
		txtNome.setColumns(10);
		txtNome.setBounds(304, 490, 133, 20);
		add(txtNome);

		lblCodiceCompagniaAerea = new JLabel("Codice Compagnia Aerea");
		lblCodiceCompagniaAerea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceCompagniaAerea.setForeground(controllerGestioneCompagnieAeree.coloreScritteTemaScuro);
		lblCodiceCompagniaAerea.setFont(controllerGestioneCompagnieAeree.fontLabel);
		lblCodiceCompagniaAerea.setBounds(53, 459, 221, 20);
		add(lblCodiceCompagniaAerea);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();
			}
		});
		btnAggiungi.setBounds(705, 459, 113, 20);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.modificaCompagniaAerea();
			}
		});
		btnModifica.setBounds(705, 490, 113, 20);
		add(btnModifica);

		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.eliminaCompagniaAerea();
			}
		});
		btnElimina.setBounds(705, 522, 113, 20);
		add(btnElimina);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.svuotaCampiGestioneCompagniaAerea();
			}
		});
		btnSvuota.setBounds(705, 554, 113, 20);
		add(btnSvuota);

		caricaTabella();
	}

	public void caricaTabella() {
		this.ListaCompagnieAeree = controllerGestioneCompagnieAeree.implementazioneCompagniaAereaDAO()
				.stampaCompagnieAeree();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaCompagnieAeree) {
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
