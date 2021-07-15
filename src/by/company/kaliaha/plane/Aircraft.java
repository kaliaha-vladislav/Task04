package by.company.kaliaha.plane;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.plane.detail.Engine;

public abstract class Aircraft implements Comparable<Aircraft>{
	private static int idInstance;
	
	static {
		idInstance = 0;
	}
	
	private int id;
	private String model;
	private Engine engine;
	private Airline airline;

	public Aircraft(String model, Engine engine) {
		id = ++idInstance;
		this.model = model;
		this.engine = engine;
	}
	
	public int getId() {
		return id;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getEngineModel() {
		return engine.getModel();
	}
	
	public int getFuelConsumption() {
		return engine.getFuelConsumption();
	}
	
	public int getMaxSpeed() {
		return engine.getMaxSpeed();
	}
	
	public boolean setAirline(Airline airline) {
		boolean isSet = false;
		if(this.airline == null) {
			isSet = true;
			this.airline = airline;
		}
		return isSet;
	}
	
	public int compareTo(Aircraft other) {		
		String thisModel = this.getModel();
		String otherModel = other.getModel();
		int difference = thisModel.length()-otherModel.length();
		return comapareHelp(difference);
	}
	
	private int comapareHelp(int difference) {
		int result = 0;
		
		if (difference > 0) {
			result = 1;
		} else if (difference < 0) {
			result = -1;
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Aircraft other = (Aircraft) obj;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	public abstract String toString();
}