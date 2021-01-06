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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaInformazioneVolo extends JFrame {
	
	private Image imgsfondoModificaInformazioneVolo = new ImageIcon(Accesso.class.getResource("immaginiModificaInformazioneVolo/imgsfondoModificaInformazioneVolo.jpg")).getImage().getScaledInstance(900, 585,Image.SCALE_SMOOTH);


	private JPanel contentPane;
	private JTable table;
	
	Controller controllerModInfoVolo;
	private JTextField txtTitolo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public ModificaInformazioneVolo(Controller controller) {
		controllerModInfoVolo = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblX = new JLabel("X");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.addMouseListener(new MouseAdapter() {
			@Override // sulla x per chiudere il programma passo sopra e metto il rosso
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override // dalla x per chiudere il programma tolgo da sopra e rimetto il bianco
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}

			@Override // clicco sulla X e chiudo il programma
			public void mouseClicked(MouseEvent e) {
				ModificaInformazioneVolo.this.dispose();
			}
		});
		lblX.setBounds(868, 0, 32, 30);
		contentPane.add(lblX);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Arial", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(142, 532, 178, 30);
		contentPane.add(textField_5);
		
		JLabel lblCodiceVolo = new JLabel("Codice volo");
		lblCodiceVolo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodiceVolo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodiceVolo.setBounds(28, 540, 93, 14);
		contentPane.add(lblCodiceVolo);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Arial", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(142, 413, 178, 30);
		contentPane.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Arial", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(142, 350, 178, 30);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Arial", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(142, 292, 178, 30);
		contentPane.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(142, 476, 178, 30);
		contentPane.add(textField_4);
		
		textField = new JTextField();
		textField.setBounds(142, 229, 178, 30);
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
		
		JButton btnAggiungiVolo = new JButton("Aggiungi volo");
		btnAggiungiVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAggiungiVolo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAggiungiVolo.setBounds(170, 77, 150, 40);
		contentPane.add(btnAggiungiVolo);
		
		JButton btnModificaVolo = new JButton("Modifica volo");
		btnModificaVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificaVolo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnModificaVolo.setBounds(10, 119, 150, 40);
		contentPane.add(btnModificaVolo);
		
		JButton btnEliminaVolo = new JButton("Elimina volo");
		btnEliminaVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminaVolo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminaVolo.setBounds(170, 119, 150, 40);
		contentPane.add(btnEliminaVolo);
		
		JButton btnStampaVolo = new JButton("Stampa volo");
		btnStampaVolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStampaVolo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnStampaVolo.setBounds(10, 77, 150, 40);
		contentPane.add(btnStampaVolo);
		
		JLabel lblimgsfondoModificaInformazioneVolo = new JLabel("");
		lblimgsfondoModificaInformazioneVolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgsfondoModificaInformazioneVolo.setIcon(new ImageIcon(imgsfondoModificaInformazioneVolo));
		lblimgsfondoModificaInformazioneVolo.setBounds(0, 65, 900, 585);
		contentPane.add(lblimgsfondoModificaInformazioneVolo);
	}
}
