package bonn.kata;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	
	

	private ArrayList<Medicine> medicines = new ArrayList<Medicine>();

	public void addPerscription(String name, int interval, int supplyInDays) {
		
		medicines.add(new Medicine(name, new Perscription(interval, supplyInDays)));
		
	}

	public List<Medicine> getMedicines() {
		
		return medicines;
	}
}
