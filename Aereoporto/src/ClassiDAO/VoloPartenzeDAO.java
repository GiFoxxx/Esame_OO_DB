package ClassiDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classi.VoloPartenze;

public interface VoloPartenzeDAO {
	
	public List<VoloPartenze> stampaVoliPartenze() throws SQLException;
	
	public int inserisciVoloPartenze(VoloPartenze voloPartenze) throws SQLException;
	
	public int cancellaVoloPartenze(VoloPartenze voloPartenze) throws SQLException;

	public int modificaVoloPartenze(VoloPartenze voloPartenze) throws SQLException;
	
	public int modificaStatusVoloPartenze(VoloPartenze voloPartenze) throws SQLException;
	
	public String risultatoStatusImbarco(VoloPartenze voloPartenze) throws SQLException;
}
