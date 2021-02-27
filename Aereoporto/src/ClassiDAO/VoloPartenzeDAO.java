package ClassiDAO;

import java.util.ArrayList;

import Classi.VoloPartenze;

public interface VoloPartenzeDAO {
	
	public ArrayList<Object[]> stampaVoliPartenze();
	
	public boolean cancellaVoloPartenze(Object voloPartenze);

	boolean modificaVoloPartenze(Object voloPartenze);

	boolean aggiungiVoloPartenze(Object voloPartenze);
}
