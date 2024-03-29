package ClassiDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import Classi.CodaDiImbarco;
import Classi.Gate;

public interface GateDAO {
	
	public List<Gate> stampaGate() throws SQLException;
	
	public List<Gate> stampaGateCodeImbarco() throws SQLException ;
	
	public int aggiungiGate(Gate gt) throws SQLException;

	public int aggiungiGateInCodaDiImbarco(Gate gt, CodaDiImbarco codaImbarco) throws SQLException;

	public int cancellaGate(Gate gt) throws SQLException;
	
	public int cancellaGateInCodaDiImbarco(Gate gt, CodaDiImbarco codaImbarco) throws SQLException;

	public int modificaGate(Gate gt) throws SQLException;
	
	public HashMap<String, String> stampaNumeroPortaInComboBox() throws SQLException;
	
	public List<Gate> stampaUtilizzoGiornaliero(Gate gt, Timestamp dataUtilizzo) throws SQLException;
	
	public List<Gate> stampaUtilizzoSettimanale(Gate gt, Timestamp dataUtilizzo) throws SQLException;
	
	public List<Gate> stampaUtilizzoMensile(Gate gt, Timestamp dataUtilizzo) throws SQLException;
}
