package by.company.kaliaha.plane.detail.body.passenger;

import by.company.kaliaha.plane.detail.body.AircraftBody;

public abstract class PassengerAircraftBody extends AircraftBody{
	private int passengerCapacity;
	private static final String TYPE = "Passenger";
	
	public PassengerAircraftBody(int passengerCapacity) {
		super(TYPE);
		this.passengerCapacity = passengerCapacity;
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + passengerCapacity;
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
		PassengerAircraftBody other = (PassengerAircraftBody) obj;
		if (passengerCapacity != other.passengerCapacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerAircraftBody [passengerCapacity=" + passengerCapacity + "]";
	}
}