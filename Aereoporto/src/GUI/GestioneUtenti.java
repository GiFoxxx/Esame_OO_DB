package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GestioneUtenti extends JPanel {



	Color sfondo = new Color(54, 57, 63);
	Color scritte = new Color(141, 142, 146);

	String colonne[] = { "Nome", "Cognome", "Email", "Password" };
	final Object[] row = new Object[4];
	DefaultTableModel modello = new DefaultTableModel(colonne, 0);
	ArrayList<Object[]> ListaUtenti = new ArrayList<>();

	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JScrollPane scrollPane;
	private JTable table;

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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Object[] getRow() {
		return row;
	}

	Controller controllerGestioneUtenti;

	public GestioneUtenti(Controller controller) {
		controllerGestioneUtenti = controller;

		setBounds(0, 0, 894, 625);
		setBackground(sfondo);
		setLayout(null);

		JLabel lblimgfrecciaIndietro = new JLabel("");
		lblimgfrecciaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.mostraPannelli(controllerGestioneUtenti.getDashboard().getHome());
			}
		});
		lblimgfrecciaIndietro.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgfrecciaIndietro.setForeground(Color.BLACK);
		lblimgfrecciaIndietro.setFont(new Font("Arial", Font.BOLD, 11));
		lblimgfrecciaIndietro.setBorder(null);
		lblimgfrecciaIndietro.setBackground(new Color(70, 130, 180));
		lblimgfrecciaIndietro.setBounds(21, 21, 37, 14);
		add(lblimgfrecciaIndietro);

		JLabel lblNome = new JLabel("nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		lblNome.setBounds(44, 451, 133, 20);
		add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(215, 451, 133, 20);
		txtNome.setColumns(10);
		add(txtNome);

		JLabel lblCognome = new JLabel("cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCognome.setFont(new Font("Arial", Font.BOLD, 14));
		lblCognome.setBounds(44, 482, 133, 20);
		add(lblCognome);

		txtCognome = new JTextField();
		txtCognome.setBounds(215, 482, 133, 20);
		txtCognome.setColumns(10);
		add(txtCognome);

		JLabel lblEmail = new JLabel("email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(44, 514, 133, 20);
		add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(215, 514, 133, 20);
		txtEmail.setColumns(10);
		add(txtEmail);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(44, 546, 133, 20);
		add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(215, 546, 133, 20);
		txtPassword.setColumns(10);
		add(txtPassword);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 46, 850, 330);
		add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t = table.getSelectedRow();
				txtNome.setText(modello.getValueAt(t, 0).toString());
				txtCognome.setText(modello.getValueAt(t, 1).toString());
				txtEmail.setText(modello.getValueAt(t, 2).toString());
				txtPassword.setText(modello.getValueAt(t, 3).toString());
			}
		});

		modello.setColumnIdentifiers(colonne);
		table.setModel(modello);

		scrollPane.setViewportView(table);

		JButton btnAggiungi = new JButton("aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.aggiungiUtente();
			}
		});
		btnAggiungi.setBounds(693, 451, 113, 20);
		add(btnAggiungi);

		JButton btnModifica = new JButton("modifica");
		btnModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.modificaUtente();
			}
		});
		btnModifica.setBounds(693, 482, 113, 20);
		add(btnModifica);

		JButton btnElimina = new JButton("elimina");
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerGestioneUtenti.eliminaUtente();
			}
		});
		btnElimina.setBounds(693, 514, 113, 20);
		add(btnElimina);

		JButton btnSvuota = new JButton("svuota");
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
		table.setModel(modello);
	}

}
