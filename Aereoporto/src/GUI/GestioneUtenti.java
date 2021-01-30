package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GestioneUtenti extends JPanel {

	String colonne[] = { "Nome", "Cognome", "Email", "Password" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();
	private Immagini img = new Immagini();

	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;

	// GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JTextField getTxtCognome() {
		return txtCognome;
	}

	public void setTxtCognome(JTextField txtCognome) {
		this.txtCognome = txtCognome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
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

	Controller controllerGestioneUtenti;

	public GestioneUtenti(Controller controller) {
		controllerGestioneUtenti = controller;

		setBounds(0, 0, 894, 625);
		setBackground(controllerGestioneUtenti.sfondo);
		setLayout(null);

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.mostraPannelli(controllerGestioneUtenti.getDashboard().getHome());
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
		
		JLabel lblRicerca = new JLabel("");
		lblRicerca.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicerca.setIcon(new ImageIcon(img.ricerca()));
		lblRicerca.setBounds(840, 36, 27, 27);
		add(lblRicerca);

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setForeground(controllerGestioneUtenti.coloreScritteSuBianco);
		txtBarraRicerca.setFont(controllerGestioneUtenti.fontScritte);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(704, 42, 135, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		JLabel lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(693, 35, 180, 30);
		add(lblBarraRicerca);

		JLabel lblNome = new JLabel("nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(controllerGestioneUtenti.fontScritte);
		lblNome.setForeground(controllerGestioneUtenti.coloreScritte);
		lblNome.setBounds(44, 451, 133, 20);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setForeground(controllerGestioneUtenti.coloreScritteSuBianco);
		txtNome.setFont(controllerGestioneUtenti.fontScritte);
		txtNome.setBounds(215, 451, 133, 20);
		txtNome.setColumns(10);
		add(txtNome);

		JLabel lblCognome = new JLabel("cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(controllerGestioneUtenti.fontScritte);
		lblCognome.setForeground(controllerGestioneUtenti.coloreScritte);
		lblCognome.setBounds(44, 482, 133, 20);
		add(lblCognome);

		txtCognome = new JTextField();
		txtCognome.setForeground(controllerGestioneUtenti.coloreScritteSuBianco);
		txtCognome.setFont(controllerGestioneUtenti.fontScritte);
		txtCognome.setBounds(215, 482, 133, 20);
		txtCognome.setColumns(10);
		add(txtCognome);

		JLabel lblEmail = new JLabel("email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(controllerGestioneUtenti.fontScritte);
		lblEmail.setForeground(controllerGestioneUtenti.coloreScritte);
		lblEmail.setBounds(44, 514, 133, 20);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(controllerGestioneUtenti.coloreScritteSuBianco);
		txtEmail.setFont(controllerGestioneUtenti.fontScritte);
		txtEmail.setBounds(215, 514, 133, 20);
		txtEmail.setColumns(10);
		add(txtEmail);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(controllerGestioneUtenti.fontScritte);
		lblPassword.setForeground(controllerGestioneUtenti.coloreScritte);
		lblPassword.setBounds(44, 546, 133, 20);
		add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setForeground(controllerGestioneUtenti.coloreScritteSuBianco);
		txtPassword.setFont(controllerGestioneUtenti.fontScritte);
		txtPassword.setBounds(215, 546, 133, 20);
		txtPassword.setColumns(10);
		add(txtPassword);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 85, 850, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = tabella.getSelectedRow();
				txtNome.setText(modello.getValueAt(t, 0).toString());
				txtCognome.setText(modello.getValueAt(t, 1).toString());
				txtEmail.setText(modello.getValueAt(t, 2).toString());
				txtPassword.setText(modello.getValueAt(t, 3).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		tabella.setModel(modello);

		scrollPane.setViewportView(tabella);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.aggiungiUtente();
			}
		});
		btnAggiungi.setBounds(693, 451, 113, 20);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.modificaUtente();
			}
		});
		btnModifica.setBounds(693, 482, 113, 20);
		add(btnModifica);

		JButton btnElimina = new JButton("elimina");
		btnElimina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.eliminaUtente();
			}
		});
		btnElimina.setBounds(693, 514, 113, 20);
		add(btnElimina);

		JButton btnSvuota = new JButton("svuota");
		btnSvuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.svuotaCampiGestioneUtenti();
			}
		});
		btnSvuota.setBounds(693, 546, 113, 20);
		add(btnSvuota);
		
		caricamento();
	}

	public void caricamento() {
		this.ListaUtenti = controllerGestioneUtenti.implementazioneUtenteDAO().stampaUtenti();
		modello.setNumRows(0);
		for (Object[] dato : this.ListaUtenti) {
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
