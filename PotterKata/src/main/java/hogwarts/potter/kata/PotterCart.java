package hogwarts.potter.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PotterCart {

	private static Map<Integer, Double> sDiscounts;
	static {
		Map<Integer, Double> discounts = new HashMap<>();
		discounts.put(1, 8.0);
		discounts.put(2, 2.0 * 8.0 * 0.95);
		discounts.put(3, 3.0 * 8.0 * 0.90);
		discounts.put(4, 4.0 * 8.0 * 0.80);
		discounts.put(5, 5.0 * 8.0 * 0.75);
		sDiscounts = Collections.unmodifiableMap(discounts);
	}

	private List<Set<Integer>> bookSets = new ArrayList<>();

	public void addBook(int bookId) {
		for (Set<Integer> bookSet : bookSets) {
			if (bookSet.contains(bookId)) {
				continue;
			}
			bookSet.add(bookId);
			return;
		}

		Set<Integer> bookSet = new HashSet<>();
		bookSet.add(bookId);
		bookSets.add(bookSet);
	}

	public Double getOverall() {
		optimizeSets();
		return calculateOverall();
	}

	private void optimizeSets() {
		// Execute a simple greedy optimization by searching for sets with 3
		// books and sets with 5 books and balance them.
		for (Set<Integer> beloWaterline : bookSets) {
			if (beloWaterline.size() != 3) {
				continue;
			}
			for (Set<Integer> overWaterline : bookSets) {
				// Skip the current lowFilledSet
				if (beloWaterline.equals(overWaterline)) {
					continue;
				}
				if (overWaterline.size() != 5) {
					continue;
				}

				// Find the book that is not in the set with three books
				// and move it over from the larger set.
				Iterator<Integer> overfilledSet = overWaterline.iterator();
				while (overfilledSet.hasNext()) {
					Integer bookId = overfilledSet.next();
					if (beloWaterline.contains(bookId)) {
						continue;
					}
					overfilledSet.remove();
					beloWaterline.add(bookId);
					break;
				}
				break;

			}
		}
	}

	private double calculateOverall() {
		double overall = 0;
		for (Set<Integer> bookSet : bookSets) {
			overall += sDiscounts.get(bookSet.size());
		}
		return overall;
	}
}
