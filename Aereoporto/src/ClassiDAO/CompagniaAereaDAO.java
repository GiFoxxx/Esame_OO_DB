package ClassiDAO;

import java.util.ArrayList;

public interface CompagniaAereaDAO {
	
	public ArrayList<Object[]> stampaCompagnieAeree();

	public boolean aggiungiCompagniaAerea(Object compagniaAerea);

	public boolean cancellaCompagniaAerea(Object compagniaAerea);

	public boolean modificaCompagniaAerea(Object compagniaAerea);
}
