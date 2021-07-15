package by.company.kaliaha.plane.detail.body.freighter;

import by.company.kaliaha.plane.detail.body.AircraftBody;

public abstract class AirFreighterBody extends AircraftBody{
	private int freighteCapacity;
	private static final String TYPE = "Freighter";
	
	public AirFreighterBody(int freighteCapacity) {
		super(TYPE);
		this.freighteCapacity = freighteCapacity;
	}
	
	public int getFreighteCapacity() {
		return freighteCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + freighteCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirFreighterBody other = (AirFreighterBody) obj;
		if (freighteCapacity != other.freighteCapacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AirFreighterBody [freighteCapacity=" + freighteCapacity + "]";
	}
}