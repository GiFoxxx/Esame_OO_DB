package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class ModificaInformazioniVolo extends JFrame {
	
	private Image imgsfondoMenuGestione = new ImageIcon(Accesso.class.getResource("immaginiMenuGestione/imgsfondoMenuGestione.jpg")).getImage().getScaledInstance(900, 650,Image.SCALE_SMOOTH);


	private JPanel contentPane;
	private JTable table;
	
	Controller controllerModInfoVolo;
	private JTextField txtTitolo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public ModificaInformazioniVolo(Controller controller) {
		controllerModInfoVolo = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Arial", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(142, 418, 178, 30);
		contentPane.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Arial", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(142, 344, 178, 30);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Arial", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(146, 285, 178, 30);
		contentPane.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(146, 481, 178, 30);
		contentPane.add(textField_4);
		
		textField = new JTextField();
		textField.setBounds(146, 234, 178, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrarioArrivo = new JLabel("Orario arrivo");
		lblOrarioArrivo.setFont(new Font("Arial", Font.BOLD, 12));
		lblOrarioArrivo.setBounds(28, 484, 93, 14);
		contentPane.add(lblOrarioArrivo);
		
		JLabel lblOrarioPartenza = new JLabel("Orario partenza");
		lblOrarioPartenza.setFont(new Font("Arial", Font.BOLD, 12));
		lblOrarioPartenza.setBounds(28, 421, 93, 14);
		contentPane.add(lblOrarioPartenza);
		
		JLabel lblGate = new JLabel("Gate");
		lblGate.setFont(new Font("Arial", Font.BOLD, 12));
		lblGate.setBounds(28, 358, 69, 14);
		contentPane.add(lblGate);
		
		JLabel lblCittaArrivo = new JLabel("Citt\u00E0 arrivo");
		lblCittaArrivo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCittaArrivo.setBounds(28, 300, 69, 14);
		contentPane.add(lblCittaArrivo);
		
		JLabel lblCittaPartenza = new JLabel("Citt\u00E0 partenza");
		lblCittaPartenza.setFont(new Font("Arial", Font.BOLD, 12));
		lblCittaPartenza.setBounds(28, 237, 93, 14);
		contentPane.add(lblCittaPartenza);
		
		txtTitolo = new JTextField();
		txtTitolo.setBackground(new Color(70, 130, 180));
		txtTitolo.setText("AMMINISTRAZONE");
		txtTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitolo.setFont(new Font("Arial", Font.BOLD, 39));
		txtTitolo.setEditable(false);
		txtTitolo.setBounds(0, 0, 900, 66);
		contentPane.add(txtTitolo);
		txtTitolo.setColumns(10);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Data partenza", "Orario partenza", "Citt\u00E0 arrivo", "Citt\u00E0 Partenza", "Volo"
			}
		));
		table.setBounds(330, 77, 560, 562);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Aggiungi volo");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(170, 77, 150, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifica volo");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 119, 150, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Elimina volo");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBounds(170, 119, 150, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stampa volo");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_3.setBounds(10, 77, 150, 40);
		contentPane.add(btnNewButton_3);
		
		JLabel lblimgsfondoMenuGestione = new JLabel("");
		lblimgsfondoMenuGestione.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgsfondoMenuGestione.setIcon(new ImageIcon(imgsfondoMenuGestione));
		lblimgsfondoMenuGestione.setBounds(0, 0, 900, 650);
		contentPane.add(lblimgsfondoMenuGestione);
	}
}
