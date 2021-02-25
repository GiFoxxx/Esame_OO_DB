package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Immagini.Immagini;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class TerminiECondizioni extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Immagini img = new Immagini();
	private JLabel lblAnnulla;

	Controller controllerTerminiECondizioni;

	public TerminiECondizioni(Controller controller) {
		controllerTerminiECondizioni = controller;

		setBounds(100, 100, 450, 650);
		setModal(true);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 567);
		contentPanel.add(scrollPane);
		
		JTextArea txtTerminiECondizioni = new JTextArea();
		txtTerminiECondizioni.setEditable(false);
		scrollPane.setViewportView(txtTerminiECondizioni);
		txtTerminiECondizioni.setText(
				"Termini e Condizioni\r\nIl presente documento riporta i termini e le condizioni generali sulla base dei quali viene offerto agli utenti l'uso dell'applicazione Airport Management che offre Gestione di uno scalo aeroportuale.\r\n1. Definizioni\r\nPer consentire una completa comprensione e accettazione dei presenti termini e condizioni, seguenti termini, al singolare e al plurale, avranno il significato di seguito indicato:\r\n- Titolari: Luigi De Marco, Manuel Buonanno.\r\n- Applicazione: l'applicazione Airport Management\r\n- Utente: qualunque soggetto che accede e utilizza l'Applicazione\r\n- Condizioni: il presente contratto che disciplina i rapporti tra il Titolare e gli Utenti,\r\n2. Ambito di applicazione delle Condizioni\r\nL'uso dell'Applicazione comporta l'accettazione delle Condizioni da parte dell'Utente. Qualora l'Utente non intenda accettare le Condizioni e/o qualsiasi altra nota, avviso legale, informativa pubblicati 0 ivi richiamati non potr\u00E0 utilizzare l'Applicazione n\u00E9 i relativi servizi. Le Condizioni possono essere modificate in ogni momento. Eventuali modifiche saranno in vigore dal momento della loro pubblicazione sull'Applicazione, Prima di utilizzare l'applicazione, l'Utente \u00E8 tenuto a leggere attentamente le Condizioni e a salvarle 0 stamparle per future consultazioni. Il Titolare si riserva il diritto di variare a propria discrezione, in qualunque momento, l'interfaccia grafica dell'Applicazione, i Contenuti e la loro organizzazione, nonch\u00E9 ogni altro aspetto che caratterizza la funzionalit\u00E0 e la gestione dell'Applicazione, comunicando all'Utente, ove occorrenti, e relative istruzioni.\r\n3. Licenza Creative Commons\r\n| Contenuti e/o i materiali disponibili sull'Applicazione sono messi a disposizione sulla base del termini della presente licenza\" Creative Commons Public Licenze CC BY 4.0 IT* (di seguito *Licenza'). | Contenuti e/o i materiali disponibili sull'Applicazione sono protetti dal diritto d'autore, dagli altri diritti attribuiti dalla legge sul diritto d'autore (diritti connessi, diritti sulle banche dati, etc.) e/o dalle altre leggi applicabili. Ogni utilizzazione dei contenuti e/o dei materiali disponibili sull'Applicazione che non sia autorizzata al sensi della Licenza e/o delle altre leggi applicabili \u00E8 proibita Il Titolare concede all'Utente i diritti di seguito elencati a condizione che lo stesso accetti di rispettare i termini e le condizioni della Licenza.\r\nIl Titolare consente all'Utente di riprodurre, distribuire, comunicare al pubblico, rappresentare, eseguire, recitare, trasformare Contenuti e/o materiali disponibili sull'Applicazione con qualsiasi mezzo e formato, per qualsiasi fine, anche commerciale, a condizione che l'Utente riconosca la paternit\u00E0 dell'opera al Titolare e fornisca un link alla licenza e indichi se sono state effettuate delle modifiche.\r\n4. Esclusione della garanzia\r\nL'Applicazione viene fornita \"cos\u00EC come \u00E8\" e \"come \u00E8 disponibile e il Titolare non fornisce alcuna garanzia esplicita 0 implicita in relazione all'Applicazione, n\u00E9 fornisce alcuna garanzia che l'Applicazione potr\u00E0 soddisfare le esigenze degli Utenti 0 che non avr\u00E0 mal interruzioni 0 sar\u00E0 priva di errori o che sar\u00E0 priva di virus 0 bug.\r\n\r\nIl Titolare si adoperer\u00E0 per assicurare che l'Applicazione sia disponibile ininterrottamente 24 ore al giorno, ma non potr\u00E0 in alcun modo essere ritenuto responsabile se, per qualsiasi motivo, l'Applicazione non fosse accessibile e/o operativa in qualsiasi momento o per qualsiasi periodo. L'accesso all'Applicazione pu\u00F2 essere sospeso temporaneamente e senza preavviso in caso di guasto del sistema, manutenzione, riparazioni o per ragioni del tutto estranee alla volont\u00E0 del Titolare 0 per eventi di forza maggiore.\r\n5. Limitazione della Responsabilit\u00E0\r\nIl Titolare non potr\u00E0 ritenersi responsabile verso l'Utente, salvo il caso di dolo 0 colpa grave, per disservizi o malfunzionamenti connessi all'utilizzo della rete internet al di fuori del controlla proprio o di suoi fornitori.\r\nIl Titolare non sar\u00E0 inoltre responsabile in merito a danni, perdite e costi subiti dall'Utente a seguito della mancata esecuzione del contratto per cause a lui non imputabili Il Titolare non assume alcuna responsabilit\u00E0 per l'eventuale uso fraudolento e illecito che possa essere fatto da parte di terzi delle carte di credito e altri mezzi di pagamento.\r\nIl Titolare non sar\u00E0 responsabile per:\r\n- eventuali perdite di opportunit\u00E0 commerciale e qualsiasi altra perdita, anche indiretta, eventualmente subita dall'Utente che non siano conseguenza diretta della violazione del contratto da parte del Titolare - errato 0 inidoneo utilizzo dell'Applicazione da parte degli Utenti o di terzi. In nessun caso il Titolare potr\u00E0 essere ritenuto responsabile per una somma superiore al doppio del costo pagato dall'Utente.\r\nIl Titolare non potr\u00E0 essere considerato responsabile per il mancato o ritardato adempimento delle proprie obbligazioni, per circostanze al di fuori del controllo ragionevole del Titolare dovute ad eventi di forza maggiore 0, comunque, ad eventi imprevisti ed imprevedibili e, comunque, indipendenti dalla sua volont\u00E0.\r\nL'adempimento delle obbligazioni da parte del Titolare si intender\u00E0 sospeso per il periodo in cui si verificano eventi di forza maggiore. Il Titolare compir\u00E0 qualsiasi atto in suo potere al fine di individuare soluzioni che consentano il corretto adempimento delle proprie obbligazioni nonostante la persistenza di eventi forza maggiore. Collegamento a siti di terzi L'Applicazione potrebbe contenere collegamenti a siti/applicazioni di terzi. Il Titolare non esercita alcun controllo su di essi e, pertanto, non \u00E8 in alcun modo responsabile per i contenuti di questi siti/applicazioni. Alcuni di questi collegamenti potrebbero rinviare a siti/applicazioni di terzi che forniscono servizi attraverso l'Applicazione. In\r\nquesti casi, ai singoli servizi si applicheranno le condizioni generali per l'uso del sito/applicazione e per la fruizione del servizio predisposte dai terzi, rispetto alle quali il Titolare non assume alcuna responsabilit\u00E0.\r\nPrivacy \r\nLa tutela e il trattamento dei dati personali avverranno in conformit\u00E0 all'Informativa Privacy che pu\u00F2 essere consultata alla pagina. Legge applicabile e foro competente. Le Condizioni sono soggette alla legge italiana. Per ogni controversia relativa all\u2019 applicazione, esecuzione e interpretazione delle presenti Condizioni \u00E8 competente il foro del luogo in cui ha sede il Titolare.\r\n\u2003\r\n");
		
		lblAnnulla = new JLabel("");
		lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerTerminiECondizioni.annullaTerminiECondizioni();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2()));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro1()));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro3()));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2()));
			}
		});
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro1()));
		lblAnnulla.setBounds(57, 598, 321, 41);
		contentPanel.add(lblAnnulla);

		controllerTerminiECondizioni.centramentoJDialog(this);

	}
}
