package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classi.CodaDiImbarco;

public interface CodaDiImbarcoDAO {

	public List<CodaDiImbarco> stampaCodaDiImbarco() throws SQLException;
	
	public int aggiungiCodaDiImbarco(CodaDiImbarco cdi) throws SQLException;
	
	public int cancellaCodaDiImbarco(CodaDiImbarco cdi) throws SQLException;
	
	public int modificaCodaDiImbarco(CodaDiImbarco cdi) throws SQLException;

	public HashMap<String, String> stampaCodaDiImbarcoInComboBox() throws SQLException;

	
	
	
	
	
	
}


