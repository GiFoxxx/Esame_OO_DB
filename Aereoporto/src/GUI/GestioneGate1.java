package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class GestioneGate1 extends JPanel {
	
	private Image imgfrecciaIndietro1 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image imgfrecciaIndietro2 = new ImageIcon(Registrazione.class.getResource("immaginiRegistrazione/imgfrecciaIndietro2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);
	
	String colonne[] = {"Codice Gate", "Numero Porta", "Tempo Inizio Imbarco", "Tempo Fine Imbarco"};
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaGate = new ArrayList<>();
	
	private JTextField txtCodiceGate;
	private JTextField txtNumeroPorta;
	private JTextField txtInizioImbarco;
	private JTextField txtFineImbarco;
	private JTable table;
	
	//GETTER E SETTER	
	public DefaultTableModel getModello() {
		return modello;
	}

	public void setModello(DefaultTableModel modello) {
		this.modello = modello;
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

	public JTextField getTxtInizioImbarco() {
		return txtInizioImbarco;
	}

	public void setTxtInizioImbarco(JTextField txtInizioImbarco) {
		this.txtInizioImbarco = txtInizioImbarco;
	}

	public JTextField getTxtFineImbarco() {
		return txtFineImbarco;
	}

	public void setTxtFineImbarco(JTextField txtFineImbarco) {
		this.txtFineImbarco = txtFineImbarco;
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
	
	Controller controllerGestioneGate;
	

	public GestioneGate1(Controller controller) {
		controllerGestioneGate = controller;
		
		setBounds(0, 0, 894, 625);
		setBackground(new Color(54,57,63));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 46, 831, 329);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtCodiceGate.setText(modello.getValueAt(t, 0).toString());
				txtNumeroPorta.setText(modello.getValueAt(t, 1).toString());
				txtInizioImbarco.setText(modello.getValueAt(t, 2).toString());
				txtFineImbarco.setText(modello.getValueAt(t, 3).toString());
			}
		});
		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);
		scrollPane.setViewportView(table);
		
		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.mostraPannelli(controllerGestioneGate.getDashboard().getHome());
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
		
		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.eliminaGate();
			}
		});
		btnElimina.setBounds(763, 493, 89, 23);
		add(btnElimina);
		
		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.aggiungiGate();
			}
		});
		btnAggiungi.setBounds(763, 425, 89, 23);
		add(btnAggiungi);
		
		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.modificaGate();
			}
		});
		btnModifica.setBounds(763, 459, 89, 23);
		add(btnModifica);
		
		JButton btnSvuota = new JButton("svuota");
		btnSvuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneGate.svuotaCampiGate();
			}
		});
		btnSvuota.setBounds(763, 527, 89, 23);
		add(btnSvuota);
		
		JLabel lblNumeroPorta = new JLabel("Numero Porta");
		lblNumeroPorta.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumeroPorta.setForeground(scritte);
		lblNumeroPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroPorta.setBounds(10, 427, 114, 20);
		add(lblNumeroPorta);
		
		txtNumeroPorta = new JTextField();
		txtNumeroPorta.setFont(new Font("Arial", Font.BOLD, 12));
		txtNumeroPorta.setColumns(10);
		txtNumeroPorta.setBounds(158, 427, 133, 20);
		add(txtNumeroPorta);
		
		JLabel lblInizioImbarco = new JLabel("Inizio Imbarco");
		lblInizioImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		lblInizioImbarco.setForeground(scritte);
		lblInizioImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInizioImbarco.setBounds(10, 460, 114, 20);
		add(lblInizioImbarco);
		
		txtInizioImbarco = new JTextField();
		txtInizioImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		txtInizioImbarco.setColumns(10);
		txtInizioImbarco.setBounds(158, 460, 133, 20);
		add(txtInizioImbarco);
		
		JLabel lblFineImbarco = new JLabel("Fine Imbarco");
		lblFineImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		lblFineImbarco.setForeground(scritte);
		lblFineImbarco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFineImbarco.setBounds(10, 494, 114, 20);
		add(lblFineImbarco);
		
		txtFineImbarco = new JTextField();
		txtFineImbarco.setFont(new Font("Arial", Font.BOLD, 12));
		txtFineImbarco.setColumns(10);
		txtFineImbarco.setBounds(158, 494, 133, 20);
		add(txtFineImbarco);
		
		JLabel lblCodiceGate = new JLabel("Codice Gate");
		lblCodiceGate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodiceGate.setForeground(new Color(141, 142, 146));
		lblCodiceGate.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodiceGate.setBounds(10, 395, 114, 20);
		add(lblCodiceGate);
		
		txtCodiceGate = new JTextField();
		txtCodiceGate.setFont(new Font("Arial", Font.BOLD, 12));
		txtCodiceGate.setColumns(10);
		txtCodiceGate.setBounds(158, 395, 133, 20);
		add(txtCodiceGate);
		
		
		caricamento();
		
	}

	//METODI
	public void  caricamento() {
		this.ListaGate = controllerGestioneGate.implementazioneGateDAO().stampaGate();
		modello.setNumRows(0);
		for(Object [] dato : this.ListaGate) {
			this.modello.addRow(dato);
		}
		table.setModel(modello);
	}
}
