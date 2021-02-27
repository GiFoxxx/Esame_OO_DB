package ClassiDAO;

import java.util.ArrayList;
import java.util.HashMap;

public interface TrattaDAO {
	
	public ArrayList<Object[]> stampaTratte();
	
	public boolean cancellaTratta(Object tratta);
	
	public boolean modificaTratta(Object tratta);
	
	public boolean aggiungiTratta(Object tratta);

	HashMap<String, String> stampaCittaArrivoInComboBox();

}
