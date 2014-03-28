package bonn.kata;

public class Perscription {

	private final int interval;
	private final int supplyInDays;

	public Perscription(int interval, int supplyInDays) {
		this.interval = interval;
		this.supplyInDays = supplyInDays;
	}

	public int getInterval() {
		return interval;
	}

	public int getSupplyInDays() {
		return supplyInDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + interval;
		result = prime * result + supplyInDays;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perscription other = (Perscription) obj;
		if (interval != other.interval)
			return false;
		if (supplyInDays != other.supplyInDays)
			return false;
		return true;
	}
}
