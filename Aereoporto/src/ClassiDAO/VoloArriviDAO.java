package ClassiDAO;

import java.util.ArrayList;

public interface VoloArriviDAO {

public ArrayList<Object[]> stampaVoliArrivi();
	
	public boolean cancellaVoloArrivi(Object voloArrivi);

	boolean modificaVoloArrivi(Object voloArrivi);

	boolean aggiungiVoloArrivi(Object voloArrivi);
}
