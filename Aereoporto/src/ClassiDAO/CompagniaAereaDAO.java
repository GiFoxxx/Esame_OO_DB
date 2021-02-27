package ClassiDAO;

import java.util.ArrayList;
import java.util.HashMap;

public interface CompagniaAereaDAO {
	
	public ArrayList<Object[]> stampaCompagnieAeree();

	public boolean aggiungiCompagniaAerea(Object compagniaAerea);

	public boolean cancellaCompagniaAerea(Object compagniaAerea);

	public boolean modificaCompagniaAerea(Object compagniaAerea);

	HashMap<String, String> stampaNomeCompagniaAereaInComboBox();
}
