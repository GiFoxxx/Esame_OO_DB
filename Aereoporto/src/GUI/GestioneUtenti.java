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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Amministrazione.Utente;
import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import javax.swing.SwingConstants;

public class GestioneUtenti extends JPanel {

	String colonne[] = { "Nome", "Cognome", "Email", "Password" };
	Utente[] row = new Utente[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	List<Utente> ListaUtenti = new ArrayList<Utente>();
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
	private JLabel lblRicaricaTabella;
	
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

	public Utente[] getRow() {
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
				controllerGestioneUtenti.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro2TemaChiaro(), img.frecciaIndietro2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro3TemaChiaro(), img.frecciaIndietro3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblimgfrecciaIndietro, img.frecciaIndietro1TemaChiaro(), img.frecciaIndietro1());
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
		txtBarraRicerca.setBackground(controllerGestioneUtenti.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneUtenti.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneUtenti.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 52, 141, 21);
		add(txtBarraRicerca);
		txtBarraRicerca.setColumns(10);

		lblBarraRicerca = new JLabel("");
		lblBarraRicerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraRicerca.setIcon(new ImageIcon(img.barraRicerca()));
		lblBarraRicerca.setBounds(871, 47, 184, 30);
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
		scrollPane.setBounds(25, 85, 1030, 330);
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
				controllerGestioneUtenti.cambioImmagineTema(lblAggiungi, img.aggiungi2TemaChiaro(), img.aggiungi2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblAggiungi, img.aggiungi3TemaChiaro(), img.aggiungi3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblAggiungi, img.aggiungi1TemaChiaro(), img.aggiungi1());
			
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
				controllerGestioneUtenti.cambioImmagineTema(lblModifica, img.modifica2TemaChiaro(), img.modifica2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblModifica, img.modifica3TemaChiaro(), img.modifica3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblModifica, img.modifica1TemaChiaro(), img.modifica1());
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
				controllerGestioneUtenti.cambioImmagineTema(lblElimina, img.elimina2TemaChiaro(), img.elimina2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblElimina, img.elimina3TemaChiaro(), img.elimina3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblElimina, img.elimina1TemaChiaro(), img.elimina1());
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
				controllerGestioneUtenti.cambioImmagineTema(lblSvuota, img.svuota2TemaChiaro(), img.svuota2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblSvuota, img.svuota3TemaChiaro(), img.svuota3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblSvuota, img.svuota1TemaChiaro(), img.svuota1());
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
				controllerGestioneUtenti.cambioImmagineTema(lblRicaricaTabella, img.aggiorna2TemaChiaro(), img.aggiorna2());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblRicaricaTabella, img.aggiorna3TemaChiaro(), img.aggiorna3());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				controllerGestioneUtenti.cambioImmagineTema(lblRicaricaTabella, img.aggiorna1TemaChiaro(), img.aggiorna1());
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
			this.ListaUtenti = controllerGestioneUtenti.implementazioneUtenteDAO().stampaUtenti();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (Utente dato : this.ListaUtenti) {
			modello.addRow(new Object[] {dato.getNome(), dato.getCognome(), dato.getEmail(), dato.getPassword()});
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
