package ClassiDAO;

import java.sql.SQLException;
import java.util.List;

import Classi.CompagniaAerea;
import Classi.VoloArrivi;

public interface VoloArriviDAO {
	
	public List<VoloArrivi> stampaVoliArrivi() throws SQLException;

	public int aggiungiVoloArrivi(VoloArrivi vlArr) throws SQLException;

	public int cancellaVoloArrivi(VoloArrivi vlArr) throws SQLException;
	
	public int modificaVoloArrivi(VoloArrivi vlArr) throws SQLException;
	
	
	
}
