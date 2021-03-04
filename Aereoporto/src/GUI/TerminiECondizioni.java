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
	JLabel lblAnnulla;

	public JLabel getLblAnnulla() {
		return lblAnnulla;
	}

	public void setLblAnnulla(JLabel lblAnnulla) {
		this.lblAnnulla = lblAnnulla;
	}

	Controller controllerTerminiECondizioni;
	
	JScrollPane scrollPane;
	JTextArea txtArea;

	public TerminiECondizioni(Controller controller) {
		controllerTerminiECondizioni = controller;

		setBounds(100, 100, 450, 642);
		setModal(true);
		setFocusable(true);
		setUndecorated(true);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblAnnulla = new JLabel("");
		lblAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controllerTerminiECondizioni.annullaTerminiECondizioni();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if (controllerTerminiECondizioni.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2()));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (controllerTerminiECondizioni.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro1TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro1()));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (controllerTerminiECondizioni.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro3TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro3()));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (controllerTerminiECondizioni.cambioTema()) {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2TemaChiaro()));
				} else {
					lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro2()));
				}
			}
		});
		lblAnnulla.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnulla.setIcon(new ImageIcon(img.tornaIndietro1()));
		lblAnnulla.setBounds(65, 592, 319, 36);
		contentPanel.add(lblAnnulla);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 430, 566);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setText("Termini e Condizioni\r\nIl presente documento riporta i termini e le condizioni generali sulla base \r\ndei quali viene offerto agli utenti l'uso dell'applicazione Airport Management \r\nche offre Gestione di uno scalo aeroportuale.\r\n1. Definizioni\r\nPer consentire una completa comprensione e accettazione dei presenti\r\ntermini \re condizioni, seguenti termini, al singolare e al plurale, avranno il \r\nsignificato di \r\nseguito indicato:\r\n- Titolari: Luigi De Marco, Manuel Buonanno.\r\n- Applicazione: l'applicazione Airport Management\r\n- Utente: qualunque soggetto che accede e utilizza l'Applicazione\r\n- Condizioni: il presente contratto che disciplina i rapporti tra il Titolare e \r\ngliUtenti,\r\n2. Ambito di applicazione delle Condizioni\r\nL'uso dell'Applicazione comporta l'accettazione delle Condizioni da parte\r\ndell'Utente. \r\nQualora l'Utente non intenda accettare le Condizioni e/o qualsiasi altra \r\nnota, avviso\r legale, informativa pubblicati 0 ivi richiamati non potr\u00E0 utilizzare\r\nl'Applicazione n\u00E9 i \rrelativi servizi.\r\nLe Condizioni possono essere modificate in ogni momento. Eventuali\r\nmodifiche saranno \rin vigore dal momento della loro pubblicazione \r\nsull'Applicazione.\r Prima di utilizzare l'applicazione, l'Utente \u00E8 tenuto a\r\nleggere attentamente le Condizioni \r e a salvarle 0 stamparle per future\r\nconsultazioni. \rIl Titolare si riserva il diritto di variare a propria discrezione,\r\nin qualunque momento,l'interfaccia grafica dell'Applicazione, \r\ni Contenuti e la loro organizzazione, nonch\u00E9 ogni \raltro aspetto che\r\ncaratterizza la funzionalit\u00E0 e la gestione dell'Applicazione, \r\ncomunicando all'Utente, ove occorrenti, e relative istruzioni.\r\n3. Licenza Creative Commons\r\n| Contenuti e/o i materiali disponibili sull'Applicazione sono messi a \r\ndisposizione sulla base del termini della presente licenza\" Creative \r\nCommons Public Licenze CC BY 4.0 IT* (di seguito *Licenza').\r\nI Contenuti e/o i materiali disponibili sull'Applicazione sono protetti dal \r\ndiritto \rd'autore, dagli altri diritti attribuiti dalla legge sul diritto d'autore \r\n(diritti connessi, diritti sulle banche dati, etc.) e/o dalle altre leggi applicabili.\r\nOgni utilizzazione dei contenuti e/o \rdei materiali disponibili \r\nsull'Applicazione che non sia autorizzata al sensi della Licenza \re/o delle \r\naltre leggi applicabili \u00E8 proibita. Il Titolare concede all'Utente i diritti di\r\nseguito elencati a condizione che lo stesso accetti \rdi rispettare i termini e \r\nle condizioni della Licenza.\r Il Titolare consente all'Utente di riprodurre, \r\ndistribuire, comunicare al pubblico, \rrappresentare, eseguire, recitare, \r\ntrasformare Contenuti e/o materiali disponibili sull'Applicazione con \r\nqualsiasi mezzo e formato, per qualsiasi fine, anche commerciale, \r\na condizione che l'Utente riconosca la paternit\u00E0 dell'opera al Titolare e \r\nfornisca un link \ralla licenza e indichi se sono state effettuate delle \r\nmodifiche.\r\n4. Esclusione della garanzia\r\nL'Applicazione viene fornita \"cos\u00EC come \u00E8\" e \"come \u00E8 disponibile e il \r\nTitolare non\r fornisce alcuna garanzia esplicita 0 implicita in relazione \r\nall'Applicazione, n\u00E9 fornisce alcuna garanzia che l'Applicazione potr\u00E0 \r\nsoddisfare le esigenze degli Utenti 0 che non \ravr\u00E0 mal interruzioni 0 \r\nsar\u00E0 priva di errori o che sar\u00E0 priva di virus 0 bug.\r Il Titolare si adoperer\u00E0\r\nper assicurare che l'Applicazione sia disponibile ininterrottamente\r 24 ore\r\nal giorno, ma non potr\u00E0 in alcun modo essere ritenuto responsabile se, \r\nper \rqualsiasi motivo, l'Applicazione non fosse accessibile e/o operativa in \r\nqualsiasi momento \ro per qualsiasi periodo.\r L'accesso all'Applicazione pu\u00F2\r\nessere sospeso temporaneamente e senza preavviso \r\nin caso di guasto del sistema, manutenzione, riparazioni o per ragioni del\r\ntutto estranee\r alla volont\u00E0 del Titolare 0 per eventi di forza maggiore.\r\n5. Limitazione della Responsabilit\u00E0\r\nIl Titolare non potr\u00E0 ritenersi responsabile verso l'Utente, salvo il caso di\r\ndolo 0 colpa \r grave, per disservizi o malfunzionamenti connessi all'utilizzo\r\ndella rete internet al di \r fuori del controlla proprio o di suoi fornitori.\r\nIl Titolare non sar\u00E0 inoltre  responsabile in merito a danni, perdite e costi\r\nsubiti dall'Utente\r a seguito \r\ndella mancata esecuzione del contratto per cause a lui non imputabili Il \r\nTitolare non assume alcuna responsabilit\u00E0 per l'eventuale uso fraudolento\r\ne illecito \rche possa essere fatto da parte di terzi delle carte di credito e a\r\nltri mezzi di pagamento.\r\nIl Titolare non sar\u00E0 responsabile per:\r\n- eventuali perdite di opportunit\u00E0 commerciale e qualsiasi altra perdita, anche \r\nindiretta, eventualmente subita dall'Utente che non siano conseguenza diretta della violazione\r\n del contratto da parte del Titolare - errato 0 inidoneo utilizzo dell'Applicazione\r\nda parte degli Utenti o di terzi. In nessun caso il Titolare potr\u00E0 essere ritenuto responsabile per \r\nuna somma superiore al doppio del costo pagato dall'Utente.\r\nIl Titolare non potr\u00E0 essere considerato responsabile per il mancato o ritardato adempimento \r\ndelle proprie obbligazioni, per circostanze al di fuori del controllo ragionevole del Titolare dovute \r\nad eventi di forza maggiore 0, comunque, ad eventi imprevisti ed imprevedibili e, comunque,\r\n indipendenti dalla sua volont\u00E0.\r\nL'adempimento delle obbligazioni da parte del Titolare si intender\u00E0 sospeso per il periodo \r\nin cui si verificano eventi di forza maggiore. Il Titolare compir\u00E0 qualsiasi atto in suo \r\npotere al fine di individuare soluzioni che consentano il corretto adempimento delle \r\nproprie obbligazioni nonostante la persistenza di eventi forza maggiore. Collegamento a \r\nsiti di terzi L'Applicazione potrebbe contenere collegamenti a siti/applicazioni di terzi. \r\nIl Titolare non esercita alcun controllo su di essi e, pertanto, non \u00E8 in alcun modo \r\nresponsabile per i contenuti di questi siti/applicazioni.\r\nAlcuni di questi collegamenti potrebbero rinviare a siti/applicazioni di terzi che\r\nforniscono servizi attraverso l'Applicazione. In\r\nquesti casi, ai singoli servizi si applicheranno le condizioni generali per l'uso del \r\nsito/applicazione e per la fruizione del servizio predisposte dai terzi, rispetto alle quali il \r\nTitolare non assume alcuna responsabilit\u00E0.\r\nPrivacy \r\nLa tutela e il trattamento dei dati personali avverranno in conformit\u00E0 all'Informativa \r\nPrivacy che pu\u00F2 essere consultata alla pagina. Legge applicabile e foro competente. \r\nLe Condizioni sono soggette alla legge italiana. Per ogni controversia relativa all\u2019 applicazione,\r\n esecuzione e interpretazione delle presenti Condizioni \u00E8 competente il foro \r\ndel luogo in cui ha sede il Titolare.\r");
		scrollPane.setViewportView(txtArea);

		controllerTerminiECondizioni.centramentoJDialog(this);

	}
}
