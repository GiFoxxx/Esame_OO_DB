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
import Classi.Tratta;
import Controller.Controller;
import ImplementazioniPostrgresDAO.TrattaImplementazionePostgresDAO;

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

public class GestioneTratte extends JFrame {

	String colonne[] = {"Codice Tratta", "Citta Partenza", "Citta Arrivo", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaTratte = new ArrayList<>();
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	private JLabel lblCittaPartenza = new JLabel("Citta Partenza");
	private JTextField txtCittaPartenza = new JTextField();
	private JTextField txtCodiceTratta;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiungi;
	
	private JButton btnSvuota;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCittaArrivo;
	private JTextField txtCittaArrivo;
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
	
	
	Controller controllerGestioneTratte;
	private JDateChooser dateDataPartenza;
	private JDateChooser dateDataArrivo;
	private JTextField txtOrarioPartenza;
	private JTextField txtOrarioArrivo;
	private JLabel lblOrarioArrivo;
	private JLabel lblOrarioPartenza;
	private JLabel lblDataArrivo;
	private JLabel lblDataPartenza;
	
	
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

	public JTextField getTxtCodiceTratta() {
		return txtCodiceTratta;
	}

	public void setTxtCodiceTratta(JTextField txtCodiceTratta) {
		this.txtCodiceTratta = txtCodiceTratta;
	}

	public JTextField getTxtCittaArrivo() {
		return txtCittaArrivo;
	}

	public void setTxtCittaArrivo(JTextField txtCittaArrivo) {
		this.txtCittaArrivo = txtCittaArrivo;
	}

	public JTextField getTxtCittaPartenza() {
		return txtCittaPartenza;
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

	public void setTxtOrarioPartenza(JTextField txtfldOrarioPartenza) {
		this.txtOrarioPartenza = txtfldOrarioPartenza;
	}

	public JTextField getTxtOrarioArrivo() {
		return txtOrarioArrivo;
	}

	public void setTxtOrarioArrivo(JTextField txtfldOrarioArrivo) {
		this.txtOrarioArrivo = txtfldOrarioArrivo;
	}

	public void setTxtCittaPartenza(JTextField txtCittaPartenza) {
		this.txtCittaPartenza = txtCittaPartenza;
	}

	//CREAZIONE GUI
	public GestioneTratte(Controller controller) {
			
		controllerGestioneTratte=controller;
		
		setBounds(0, 0, 904, 635);
		setVisible(false);
		getContentPane().setLayout(null);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			// Click sulla freccia in alto a sinistra
			@Override // chiusura finestra diretta se campi vuoti - chiusura finestra a richiesta se
						// campi pieni
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneTratte.tornaAMenuGestioneDaGestioneTratte();
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 35, 544, 427);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				
				txtCodiceTratta.setText(modello.getValueAt(t, 0).toString());
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
			}
		});
		table.setModel(modello);
		
		scrollPane.setViewportView(table);
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setIcon(new ImageIcon(imgfrecciaIndietro1));
		lblimgfrecciaIndietro.setForeground(new Color(0, 0, 0));
		lblimgfrecciaIndietro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setBounds(10, 11, 37, 14);
		getContentPane().add(lblimgfrecciaIndietro);
		
		JLabel lblCodiceTratta = new JLabel("Codice Tratta");
		lblCodiceTratta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceTratta.setBounds(32, 209, 114, 20);
		getContentPane().add(lblCodiceTratta);
		lblCittaPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaPartenza.setBounds(32, 239, 114, 20);
		getContentPane().add(lblCittaPartenza);
		
		txtCodiceTratta = new JTextField();
		txtCodiceTratta.setBounds(180, 209, 133, 20);
		getContentPane().add(txtCodiceTratta);
		txtCodiceTratta.setColumns(10);
		txtCittaPartenza.setBounds(180, 240, 133, 20);
		getContentPane().add(txtCittaPartenza);
		txtCittaPartenza.setColumns(10);
		
		btnModifica = new JButton("modifica");
		btnModifica.setBounds(32, 124, 89, 23);
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.modificaTratta();
			}
		});
		getContentPane().add(btnModifica);
		
		btnElimina = new JButton("elimina");
		btnElimina.setBounds(44, 80, 89, 23);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.eliminaTratta();
			}
		});
		getContentPane().add(btnElimina);
		
		btnAggiungi = new JButton("aggiungi");
		btnAggiungi.setBounds(156, 80, 89, 23);
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.aggiungiTratta();
			}
		});
		getContentPane().add(btnAggiungi);
		
		modello.setColumnIdentifiers(colonne);
		
		btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneTratte.svuotaCampiTratta();
			}
		});
		btnSvuota.setBounds(181, 116, 78, 39);
		getContentPane().add(btnSvuota);
		
		modello.setColumnIdentifiers(colonne);
		
		lblCittaArrivo = new JLabel("Citta Arrivo");
		lblCittaArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCittaArrivo.setBounds(32, 277, 114, 20);
		getContentPane().add(lblCittaArrivo);
		
		txtCittaArrivo = new JTextField();
		txtCittaArrivo.setColumns(10);
		txtCittaArrivo.setBounds(180, 277, 133, 20);
		getContentPane().add(txtCittaArrivo);
		
		btnCalcolaRitardo = new JButton("Calcola Ritardo");
		btnCalcolaRitardo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				controllerGestioneVoli.calcoloRitardo();
			}
		});
		btnCalcolaRitardo.setBounds(95, 175, 133, 23);
		getContentPane().add(btnCalcolaRitardo);
		
		dateDataPartenza = new JDateChooser();
		dateDataPartenza.setBounds(179, 312, 133, 23);
		getContentPane().add(dateDataPartenza);
		
		dateDataArrivo = new JDateChooser();
		dateDataArrivo.setBounds(179, 350, 133, 23);
		getContentPane().add(dateDataArrivo);
		
		txtOrarioPartenza = new JTextField();
		txtOrarioPartenza.setColumns(10);
		txtOrarioPartenza.setBounds(179, 392, 133, 20);
		getContentPane().add(txtOrarioPartenza);
		
		txtOrarioArrivo = new JTextField();
		txtOrarioArrivo.setColumns(10);
		txtOrarioArrivo.setBounds(179, 432, 133, 20);
		getContentPane().add(txtOrarioArrivo);
		
		lblOrarioArrivo = new JLabel("Orario Arrivo");
		lblOrarioArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioArrivo.setBounds(31, 432, 114, 20);
		getContentPane().add(lblOrarioArrivo);
		
		lblOrarioPartenza = new JLabel("Orario Partenza");
		lblOrarioPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrarioPartenza.setBounds(31, 392, 114, 20);
		getContentPane().add(lblOrarioPartenza);
		
		lblDataArrivo = new JLabel("Data Arrivo");
		lblDataArrivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataArrivo.setBounds(31, 350, 114, 20);
		getContentPane().add(lblDataArrivo);
		
		lblDataPartenza = new JLabel("Data Partenza");
		lblDataPartenza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataPartenza.setBounds(31, 312, 114, 20);
		getContentPane().add(lblDataPartenza);
		
		caricamento();
	}

	
	public void  caricamento() {
		this.ListaTratte = controllerGestioneTratte.implementazioneTrattaDAO().stampaTratte();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaTratte) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);		
	}
}