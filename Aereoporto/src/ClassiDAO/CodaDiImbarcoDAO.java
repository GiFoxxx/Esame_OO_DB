package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classi.CodaDiImbarco;

public interface CodaDiImbarcoDAO {

	public List<CodaDiImbarco> stampaCodaDiImbarco() throws SQLException;

	HashMap<String, String> stampaCodaDiImbarcoInComboBox() throws SQLException;

	
	
	
	
	
	
}


