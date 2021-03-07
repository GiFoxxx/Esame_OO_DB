package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

import Amministrazione.Utente;
import Classi.CompagniaAerea;
import Controller.Controller;
import Immagini.Immagini;

import javax.swing.JButton;

public class GestioneCompagnieAeree extends JPanel {

	String colonne[] = { "Codice Compagnia aerea", "Nome" };
	CompagniaAerea[] row = new CompagniaAerea[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	List<CompagniaAerea> ListaCompagnieAeree = new ArrayList<CompagniaAerea>();
	private Immagini img = new Immagini();

	private JTextField txtCodiceCompagniaAerea;
	private JTextField txtNome;
	private JScrollPane scrollPane;
	private JTable tabella;
	private JTextField txtBarraRicerca;
	
	private JLabel lblimgfrecciaIndietro;
	private JLabel lblBarraRicerca;
	private JLabel lblNome;
	private JLabel lblCodiceCompagniaAerea;
	
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
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3TemaChiaro()));
				} else {
					lblimgfrecciaIndietro.setIcon(new ImageIcon(img.frecciaIndietro3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
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
		txtBarraRicerca.setBackground(controllerGestioneCompagnieAeree.escoPannelloTemaScuro);
		txtBarraRicerca.setForeground(controllerGestioneCompagnieAeree.coloreScritteTemaScuro);
		txtBarraRicerca.setFont(controllerGestioneCompagnieAeree.fontScritteGestioni);
		txtBarraRicerca.setBorder(null);
		txtBarraRicerca.setBounds(888, 41, 141, 20);
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

		lblAggiungi = new JLabel("");
		lblAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneCompagnieAeree.aggiungiCompagniaAerea();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3TemaChiaro()));
				} else {
					lblAggiungi.setIcon(new ImageIcon(img.aggiungi3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
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
				controllerGestioneCompagnieAeree.modificaCompagniaAerea();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica2TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica1TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblModifica.setIcon(new ImageIcon(img.modifica3TemaChiaro()));
				} else {
					lblModifica.setIcon(new ImageIcon(img.modifica3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
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
				controllerGestioneCompagnieAeree.eliminaCompagniaAerea();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina2TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina1TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblElimina.setIcon(new ImageIcon(img.elimina3TemaChiaro()));
				} else {
					lblElimina.setIcon(new ImageIcon(img.elimina3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
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
				controllerGestioneCompagnieAeree.svuotaCampiGestioneCompagniaAerea();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota2TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota2()));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota1TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota1()));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
					lblSvuota.setIcon(new ImageIcon(img.svuota3TemaChiaro()));
				} else {
					lblSvuota.setIcon(new ImageIcon(img.svuota3()));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerGestioneCompagnieAeree.cambioTema()) {
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
		try {
			this.ListaCompagnieAeree = controllerGestioneCompagnieAeree.implementazioneCompagniaAereaDAO()
					.stampaCompagnieAeree();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		modello.setNumRows(0);
		for (CompagniaAerea dato : this.ListaCompagnieAeree) {
			this.modello.addRow(new Object[] {dato.getCodiceCompagniaAerea(), dato.getNome()});
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
