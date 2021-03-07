package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classi.Tratta;

public interface TrattaDAO {
	
	public List<Tratta> stampaTratte() throws SQLException;
	
	public int aggiungiTratta(Tratta trt) throws SQLException;
	
	public int cancellaTratta(Tratta trt) throws SQLException;
	
	public int modificaTratta(Tratta trt) throws SQLException;

	public HashMap<String, String> stampaCittaArrivoInComboBox() throws SQLException;

}
