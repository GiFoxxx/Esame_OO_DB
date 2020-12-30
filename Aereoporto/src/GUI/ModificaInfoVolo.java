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

import javax.swing.JButton;

public class ModificaInfoVolo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Controller controllerModInfoVolo;

	public ModificaInfoVolo(Controller controller) {
		controllerModInfoVolo = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		table.setBounds(24, 103, 438, 160);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Aggiungi tratta");
		btnNewButton.setBounds(52, 14, 122, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifica tratta");
		btnNewButton_1.setBounds(220, 16, 122, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Elimina tratta");
		btnNewButton_2.setBounds(372, 14, 122, 33);
		contentPane.add(btnNewButton_2);
	}
}
