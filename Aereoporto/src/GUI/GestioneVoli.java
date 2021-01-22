package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.*;

import java.awt.EventQueue;
import java.util.List;
import java.sql.*;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import Classi.CompagniaAerea;
import Classi.Gate;
import Classi.Volo;
import Controller.Controller;
import ImplementazioniPostrgresDAO.VoloImplementazionePostgresDAO;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;
import java.awt.Image;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import com.jgoodies.common.format.EmptyDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.toedter.components.JLocaleChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GestioneVoli extends JFrame {

	String colonne[] = {"Codice Volo", "Citta Partenza", "Citta Arrivo", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Numero Prenotazioni"};
	Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaVoli = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgCasa2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgCasa2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JLabel lblCittaPartenza = new JLabel("Citta Partenza");
	private JTextField txtCittaPartenza = new JTextField();
	private JTextField txtCodiceVolo;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;
	private JButton btnNewButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCittaArrivo;
	private JTextField txtCittaArrivo;
	private JLabel lblDataPartenza;
	private JLabel lblDataArrivo;
	private JLabel lblOrarioPartenza;
	private JLabel lblOrarioArrivo;
	private JLabel lblNumeroPrenotazioni;
	
	private JTextField txtNumeroPrenotazioni;
	private JDateChooser dateDataPartenza;
	private JDateChooser dateDataArrivo;
	private JButton btnCalcolaRitardo;
	
//	private JSpinner spinOrarioPartenza;
//	private JSpinner spinOrarioArrivo;
//	
//	@SuppressWarnings("deprecation")
//	Date orarioPartenza = new Date(00, 00, 00);
//	SpinnerDateModel smPartenza = new SpinnerDateModel(orarioPartenza, null, null, Calendar.HOUR_OF_DAY);
//	@SuppressWarnings("deprecation")
//	Date orarioArrivo = new Date(00, 00, 00);
//	SpinnerDateModel smArrivo = new SpinnerDateModel(orarioArrivo, null, null, Calendar.HOUR_OF_DAY);
	
	
	Controller controllerGestioneVoli;
	private JTextField txtOrarioPartenza;
	private JTextField txtOrarioArrivo;
	private JTextField txtPortaGate;
	private JLabel lblPortaGate;
	
	
	//GETTER E SETTER
	
	public Object[] getRow() {
		return row;
	}

	public void setRow(Object[] row) {
		this.row = row;
	}

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

	public JTextField getTxtCodiceVolo() {
		return txtCodiceVolo;
	}

	public void setTxtCodiceVolo(JTextField txtCodiceTratta) {
		this.txtCodiceVolo = txtCodiceTratta;
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
//	
//	public JSpinner getSpinOrarioPartenza() {
//		return spinOrarioPartenza;
//	}
//
//	public void setSpinOrarioPartenza(JSpinner spinOrarioPartenza) {
//		this.spinOrarioPartenza = spinOrarioPartenza;
//	}
//
//	public JSpinner getSpinOrarioArrivo() {
//		return spinOrarioArrivo;
//	}
//
//	public void setSpinOrarioArrivo(JSpinner spinOrarioArrivo) {
//		this.spinOrarioArrivo = spinOrarioArrivo;
//	}

	public JTextField getTxtNumeroPrenotazioni() {
		return txtNumeroPrenotazioni;
	}

	public void setTxtNumeroPrenotazioni(JTextField txtNumeroPrenotazioni) {
		this.txtNumeroPrenotazioni = txtNumeroPrenotazioni;
	}

	public JTextField getTxtPortaGate() {
		return txtPortaGate;
	}

	public void setTxtPortaGate(JTextField txtPortaGate) {
		this.txtPortaGate = txtPortaGate;
	}

	public JTextField getTxtCittaPartenza() {
		return txtCittaPartenza;
	}
	
	//CREAZIONE GUI
	public GestioneVoli(Controller controller) {
			
		controllerGestioneVoli=controller;
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			// Click sulla freccia in alto a sinistra
			@Override // chiusura finestra diretta se campi vuoti - chiusura finestra a richiesta se
						// campi pieni
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.tornaAMenuGestioneDaGestioneVoli();
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
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));
		lblimgfrecciaIndietro.setForeground(new Color(0, 0, 0));
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setBounds(10, 11, 37, 14);
		contentPane.add(lblimgfrecciaIndietro);
		
		JLabel lblCodiceVoli = new JLabel("Codice Volo");
		lblCodiceVoli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceVoli.setBounds(32, 209, 114, 20);
		contentPane.add(lblCodiceVoli);
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setBounds(32, 239, 114, 20);
		contentPane.add(lblCittaPartenza);
		
		txtCodiceVolo = new JTextField();
		txtCodiceVolo.setBounds(180, 209, 133, 20);
		contentPane.add(txtCodiceVolo);
		txtCodiceVolo.setColumns(10);
		txtCittaPartenza.setBounds(180, 240, 133, 20);
		contentPane.add(txtCittaPartenza);
		txtCittaPartenza.setColumns(10);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 124, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.eliminaVolo();
			}
		});
		contentPane.add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.aggiungiVolo();
			}
		});
		contentPane.add(btnAggiungi);
		
		modello.setColumnIdentifiers(colonne);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.svuotaCampiVolo();
			}
		});
		btnNewButton.setBounds(181, 116, 78, 39);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 35, 868, 465);
		contentPane.add(scrollPane);
				
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
				txtOrarioArrivo.setText(modello.getValueAt(t, 5).toString());
				txtOrarioPartenza.setText(modello.getValueAt(t, 6).toString());
				txtNumeroPrenotazioni.setText(modello.getValueAt(t, 7).toString());
			}
		});
		
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("svuota");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.svuotaCampiVolo();
			}
		});
		scrollPane.setViewportView(table);
		
		lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setBounds(32, 277, 114, 20);
		contentPane.add(lblCittaArrivo);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(180, 277, 133, 20);
		contentPane.add(txtCittaArrivo);
		
		lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setBounds(32, 319, 114, 20);
		contentPane.add(lblDataPartenza);
		
		lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setBounds(32, 357, 114, 20);
		contentPane.add(lblDataArrivo);
		
		lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setBounds(32, 399, 114, 20);
		contentPane.add(lblOrarioPartenza);
		
		lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setBounds(32, 439, 114, 20);
		contentPane.add(lblOrarioArrivo);
		
		lblNumeroPrenotazioni = new JLabel("Numero Prenotazioni");
		lblNumeroPrenotazioni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPrenotazioni.setBounds(32, 480, 114, 20);
		contentPane.add(lblNumeroPrenotazioni);
		
		txtNumeroPrenotazioni = new JTextField();
		txtNumeroPrenotazioni.setColumns(10);
		txtNumeroPrenotazioni.setBounds(180, 480, 133, 20);
		contentPane.add(txtNumeroPrenotazioni);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateDataPartenza.setBounds(180, 319, 133, 23);
		contentPane.add(dateDataPartenza);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setBounds(180, 357, 133, 23);
		contentPane.add(dateDataArrivo);
		
		btnCalcolaRitardo = new JButton("Calcola Ritardo");
		btnCalcolaRitardo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.calcoloRitardo();
			}
		});
		btnCalcolaRitardo.setBounds(95, 175, 133, 23);
		contentPane.add(btnCalcolaRitardo);
		
		txtOrarioPartenza = new JTextField();
		txtOrarioPartenza.setBounds(180, 399, 133, 20);
		contentPane.add(txtOrarioPartenza);
		txtOrarioPartenza.setColumns(10);
		
		txtOrarioArrivo = new JTextField();
		txtOrarioArrivo.setBounds(180, 439, 133, 20);
		contentPane.add(txtOrarioArrivo);
		txtOrarioArrivo.setColumns(10);
		
		txtPortaGate = new JTextField();
		txtPortaGate.setColumns(10);
		txtPortaGate.setBounds(180, 514, 133, 20);
		contentPane.add(txtPortaGate);
		
		lblPortaGate = new JLabel("Porta Gate");
		lblPortaGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPortaGate.setBounds(32, 514, 114, 20);
		contentPane.add(lblPortaGate);
		
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