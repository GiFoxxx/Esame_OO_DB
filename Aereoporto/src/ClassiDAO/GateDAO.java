package ClassiDAO;

import java.util.ArrayList;
import java.util.HashMap;

public interface GateDAO {
	

	public ArrayList<Object[]> stampaGateCodeImbarco();

	public boolean aggiungiGate(Object gate);

	public boolean cancellaGate(Object gate);

	public boolean modificaGate(Object gate);

	HashMap<String, String> stampaNumeroPortaInComboBox();

	ArrayList<Object[]> stampaGate();

	public boolean aggiungiGateInCodaDiImbarcoGate(Object gate, Object codaImbarco);


}
