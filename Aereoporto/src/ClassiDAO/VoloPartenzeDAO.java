package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classi.VoloPartenze;

public interface VoloPartenzeDAO {
	
//	public List<VoloPartenze> getAllVoloPartenze() throws SQLException;
	public int inserisciVoloPartenze(VoloPartenze voloPartenze) throws SQLException;
	
//	public ArrayList<Object[]> stampaVoliPartenze();
	
	public int cancellaVoloPartenze(VoloPartenze voloPartenze) throws SQLException;

	public int modificaVoloPartenze(VoloPartenze voloPartenze) throws SQLException;

//	boolean aggiungiVoloPartenze(Object voloPartenze);

//	boolean modificaStatusVoloPartenze(Object voloPartenze);

}
