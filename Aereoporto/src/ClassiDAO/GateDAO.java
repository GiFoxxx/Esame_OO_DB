package ClassiDAO;

import java.util.ArrayList;

public interface GateDAO {
	

	public ArrayList<Object[]> stampaGate();

	public boolean aggiugniGate(Object gate);

	public boolean cancellaGate(Object gate);

	public boolean modificaGate(Object gate);


}
