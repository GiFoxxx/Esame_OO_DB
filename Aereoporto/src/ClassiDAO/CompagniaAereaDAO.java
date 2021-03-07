package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classi.CompagniaAerea;

public interface CompagniaAereaDAO {
	
	public List<CompagniaAerea> stampaCompagnieAeree() throws SQLException;

	public int aggiungiCompagniaAerea(CompagniaAerea compAerea) throws SQLException;

	public int cancellaCompagniaAerea(CompagniaAerea compAerea) throws SQLException;
	
	public int modificaCompagniaAerea(CompagniaAerea compAerea) throws SQLException;
	
	public HashMap<String, String> stampaNomeCompagniaAereaInComboBox() throws SQLException;
}
