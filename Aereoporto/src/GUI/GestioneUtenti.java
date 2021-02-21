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
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblEmail;
	private JLabel lblPassword;

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

	public JLabel getLblCognome() {
		return lblCognome;
	}

	public void setLblCognome(JLabel lblCognome) {
		this.lblCognome = lblCognome;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
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

		setBounds(0, 0, 1090, 642);
		setBackground(controllerGestioneUtenti.sfondoTemaScuro);
		setLayout(null);

		lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.setPannelloPrecedente(1);
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

		txtBarraRicerca = new JTextField();
		txtBarraRicerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ricerca();
			}
		});
		txtBarraRicerca.setBackground(controllerGestioneUtenti.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 40, 141, 20);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(876, 38, 184, 25);
		add(lblBarraRicerca);

		lblNome = new JLabel("nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(controllerGestioneUtenti.fontLabel);
		lblNome.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		lblNome.setBounds(44, 451, 133, 20);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneUtenti.aggiungiUtente();
				}
			}
		});
		txtNome.setForeground(controllerGestioneUtenti.coloreScritteSuBiancoTemaScuro);
		txtNome.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtNome.setBounds(215, 451, 133, 20);
		txtNome.setColumns(10);
		add(txtNome);

		lblCognome = new JLabel("cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(controllerGestioneUtenti.fontLabel);
		lblCognome.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		lblCognome.setBounds(44, 482, 133, 20);
		add(lblCognome);

		txtCognome = new JTextField();
		txtCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneUtenti.aggiungiUtente();
				}
			}
		});
		txtCognome.setForeground(controllerGestioneUtenti.coloreScritteSuBiancoTemaScuro);
		txtCognome.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtCognome.setBounds(215, 482, 133, 20);
		txtCognome.setColumns(10);
		add(txtCognome);

		lblEmail = new JLabel("email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(controllerGestioneUtenti.fontLabel);
		lblEmail.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		lblEmail.setBounds(44, 514, 133, 20);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneUtenti.aggiungiUtente();
				}
			}
		});
		txtEmail.setForeground(controllerGestioneUtenti.coloreScritteSuBiancoTemaScuro);
		txtEmail.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtEmail.setBounds(215, 514, 133, 20);
		txtEmail.setColumns(10);
		add(txtEmail);

		lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(controllerGestioneUtenti.fontLabel);
		lblPassword.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		lblPassword.setBounds(44, 546, 133, 20);
		add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoInvio) {
				if (EventoInvio.getKeyCode() == KeyEvent.VK_ENTER) {
					controllerGestioneUtenti.aggiungiUtente();
				}
			}
		});
		txtPassword.setForeground(controllerGestioneUtenti.coloreScritteSuBiancoTemaScuro);
		txtPassword.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtPassword.setBounds(215, 546, 133, 20);
		txtPassword.setColumns(10);
		add(txtPassword);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 85, 1030, 330);
		add(scrollPane);

		tabella = new JTable();
		tabella.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent EventoDelete) {
				if (EventoDelete.getKeyCode() == KeyEvent.VK_DELETE) {
					controllerGestioneUtenti.eliminaUtente();
				}
			}
		});
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
		
		caricaTabella();
	}

	public void caricaTabella() {
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
