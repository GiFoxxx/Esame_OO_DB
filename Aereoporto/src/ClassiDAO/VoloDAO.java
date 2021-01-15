package ClassiDAO;

import java.util.ArrayList;

public interface VoloDAO {
	
	public ArrayList<Object[]> stampaVoli();
	
	public boolean cancellaVolo(Object volo);

	boolean modificaVolo(Object volo);

	boolean aggiungiVolo(Object volo);
}
