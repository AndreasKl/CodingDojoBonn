package bonn.kata;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

public class ClashDetector {

	public static Set<DateTime> clash(Patient patient, String medicine) {
		HashSet<DateTime> clashes = new HashSet<DateTime>();
		if (patient.getMedicines().size() > 0) {
			clashes.add(new DateTime());
		}
		return clashes;
	}

}
