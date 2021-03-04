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
				if (controllerGestioneUtenti.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
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
		lblEmail.setBounds(358, 450, 133, 20);
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
		txtEmail.setBounds(529, 450, 133, 20);
		txtEmail.setColumns(10);
		add(txtEmail);

		lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(controllerGestioneUtenti.fontLabel);
		lblPassword.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		lblPassword.setBounds(358, 482, 133, 20);
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
		txtPassword.setBounds(529, 482, 133, 20);
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
		
		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.aggiungiUtente();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));
				}
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
				controllerGestioneUtenti.modificaUtente();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica3TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
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
				controllerGestioneUtenti.eliminaUtente();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina2TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina3TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina2TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina2()));
				}
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
				controllerGestioneUtenti.svuotaCampiGestioneUtenti();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneUtenti.cambioTema()) {
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
