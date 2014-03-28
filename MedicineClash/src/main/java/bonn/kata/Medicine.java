package bonn.kata;

public class Medicine {

	private final String name;
	private final Perscription perscription;

	public Medicine(String name, Perscription perscription) {
		this.name = name;
		this.perscription = perscription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((perscription == null) ? 0 : perscription.hashCode());
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
		Medicine other = (Medicine) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perscription == null) {
			if (other.perscription != null)
				return false;
		} else if (!perscription.equals(other.perscription))
			return false;
		return true;
	}
}
