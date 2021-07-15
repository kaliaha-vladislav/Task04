package by.company.kaliaha.plane.air_freighter;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.detail.Engine;
import by.company.kaliaha.plane.detail.body.AircraftBody;
import by.company.kaliaha.plane.detail.body.freighter.AirFreighterBody;

public abstract class AirFreighter extends Aircraft{
	private AirFreighterBody body;
	
	public AirFreighter(String model, AircraftBody body, Engine engine) {
		super(model, engine);
		this.body = (AirFreighterBody)body;
	}
	
	public String getBodyType() {
		return body.getType();
	}
	
	public int getFreighterCapacity() {
		return body.getFreighteCapacity();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((body == null) ? 0 : body.hashCode());
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
		AirFreighter other = (AirFreighter) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		sb.append(super.getModel());
		sb.append("[id: " + super.getId() + ",");
		sb.append(" Freighter capacity: " + body.getFreighteCapacity() + ",");
		sb.append(" Engine: " + super.getEngineModel() + ",");
		sb.append(" fuel consumption: " + super.getFuelConsumption() + ",");
		sb.append(" max speed: " + super.getMaxSpeed() + "]");
		return sb.toString();
	}
}