package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.Controller;

public class GestioneVoli extends JPanel {

	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	String colonne[] = {"Codice Volo", "Citta Partenza", "Citta Arrivo", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Numero Prenotazioni"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoli = new ArrayList<>();
	
	private JTextField txtCodiceVolo;
	private JTextField txtCittaPartenza;
	private JTextField txtCittaArrivo;
	private JDateChooser dateDataPartenza;
	private JDateChooser dateDataArrivo;
	private JTextField txtOrarioPartenza;
	private JTextField txtOrarioArrivo;
	private JTextField txtNumeroPrenotazioni;
	private JTable table;
	
	//GETTER E SETTER
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Object[] getRow() {
		return row;
	}
	
	public JTextField getTxtCodiceVolo() {
		return txtCodiceVolo;
	}

	public void setTxtCodiceVolo(JTextField txtCodiceTratta) {
		this.txtCodiceVolo = txtCodiceTratta;
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

	public JDateChooser getDateDataPartenza() {
		return dateDataPartenza;
	}

	public void setDateDataPartenza(JDateChooser dateDataPartenza) {
		this.dateDataPartenza = dateDataPartenza;
	}

	public JDateChooser getDateDataArrivo() {
		return dateDataArrivo;
	}

	public void setDateDataArrivo(JDateChooser dateDataArrivo) {
		this.dateDataArrivo = dateDataArrivo;
	}

	public JTextField getTxtOrarioPartenza() {
		return txtOrarioPartenza;
	}

	public void setTxtOrarioPartenza(JTextField txtOrarioPartenza) {
		this.txtOrarioPartenza = txtOrarioPartenza;
	}

	public JTextField getTxtOrarioArrivo() {
		return txtOrarioArrivo;
	}

	public void setTxtOrarioArrivo(JTextField txtOrarioArrivo) {
		this.txtOrarioArrivo = txtOrarioArrivo;
	}

	public JTextField getTxtNumeroPrenotazioni() {
		return txtNumeroPrenotazioni;
	}

	public void setTxtNumeroPrenotazioni(JTextField txtNumeroPrenotazioni) {
		this.txtNumeroPrenotazioni = txtNumeroPrenotazioni;
	}

	Controller controllerGestioneVoli;
	
	public GestioneVoli(Controller controller) {
		controllerGestioneVoli= controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.mostraPannelli(controllerGestioneVoli.getDashboard().getHome());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro2));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));

			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setBounds(21, 21, 37, 14);
		add(lblimgfrecciaIndietro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 46, 850, 330);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtCodiceVolo.setText(modello.getValueAt(t, 0).toString());
				txtCittaPartenza.setText(modello.getValueAt(t, 1).toString());
				txtCittaArrivo.setText(modello.getValueAt(t, 2).toString());
				try {
					java.util.Date datePartenza = new SimpleDateFormat("dd-MM-yyyy").parse((String) modello.getValueAt(t,3));
					dateDataPartenza.setDate(datePartenza);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					java.util.Date dateArrivo = new SimpleDateFormat("dd-MM-yyyy").parse((String) modello.getValueAt(t,4));
					dateDataArrivo.setDate(dateArrivo);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				txtOrarioPartenza.setText(modello.getValueAt(t, 5).toString());
				txtOrarioArrivo.setText(modello.getValueAt(t, 6).toString());
				txtNumeroPrenotazioni.setText(modello.getValueAt(t, 7).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);
		scrollPane.setViewportView(table);
		
		txtCodiceVolo = new JTextField();
		txtCodiceVolo.setColumns(10);
		txtCodiceVolo.setBounds(169, 402, 133, 20);
		add(txtCodiceVolo);
		
		JLabel lblCodiceVolo = new JLabel("Codice Volo");
		lblCodiceVolo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVolo.setForeground(scritte);
		lblCodiceVolo.setBounds(21, 402, 114, 20);
		add(lblCodiceVolo);
		
		JLabel lblCittaPartenza = new JLabel("Citta Partenza");
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setForeground(scritte);
		lblCittaPartenza.setBounds(21, 439, 114, 20);
		add(lblCittaPartenza);
		
		txtCittaPartenza = new JTextField();
		txtCittaPartenza.setColumns(10);
		txtCittaPartenza.setBounds(169, 440, 133, 20);
		add(txtCittaPartenza);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(169, 482, 133, 20);
		add(txtCittaArrivo);
		
		JLabel lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setForeground(scritte);
		lblCittaArrivo.setBounds(21, 481, 114, 20);
		add(lblCittaArrivo);
		
		JLabel lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setForeground(scritte);
		lblDataPartenza.setBounds(340, 402, 114, 20);
		add(lblDataPartenza);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setBounds(488, 402, 133, 23);
		add(dateDataPartenza);
		
		JLabel lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setForeground(scritte);
		lblDataArrivo.setBounds(340, 440, 114, 20);
		add(lblDataArrivo);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setBounds(488, 440, 133, 23);
		add(dateDataArrivo);
		
		JLabel lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setForeground(scritte);
		lblOrarioPartenza.setBounds(340, 482, 114, 20);
		add(lblOrarioPartenza);
		
		txtOrarioPartenza = new JTextField();
		txtOrarioPartenza.setColumns(10);
		txtOrarioPartenza.setBounds(488, 482, 133, 20);
		add(txtOrarioPartenza);
		
		JLabel lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setForeground(scritte);
		lblOrarioArrivo.setBounds(340, 522, 114, 20);
		add(lblOrarioArrivo);
		
		txtOrarioArrivo = new JTextField();
		txtOrarioArrivo.setColumns(10);
		txtOrarioArrivo.setBounds(488, 522, 133, 20);
		add(txtOrarioArrivo);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.aggiungiVolo();
			}
		});
		btnAggiungi.setBounds(763, 402, 89, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.modificaVolo();
			}
		});
		btnModifica.setBounds(763, 436, 89, 23);
		add(btnModifica);
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.eliminaVolo();
			}
		});
		btnElimina.setBounds(763, 470, 89, 23);
		add(btnElimina);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneVoli.svuotaCampiVolo();
			}
		});
		btnSvuota.setBounds(763, 504, 89, 23);
		add(btnSvuota);
		
		JLabel lblNumeroPrenoazioni = new JLabel("Numero Prenoazioni");
		lblNumeroPrenoazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenoazioni.setForeground(scritte);
		lblNumeroPrenoazioni.setBounds(21, 521, 114, 20);
		add(lblNumeroPrenoazioni);
		
		txtNumeroPrenotazioni = new JTextField();
		txtNumeroPrenotazioni.setColumns(10);
		txtNumeroPrenotazioni.setBounds(169, 522, 133, 20);
		add(txtNumeroPrenotazioni);
		
		caricamento();
	}
	
	public void  caricamento() {
		this.ListaVoli = controllerGestioneVoli.implementazioneVoloDAO().stampaVoli();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaVoli) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);		
	}

}
