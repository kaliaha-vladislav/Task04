package by.company.kaliaha.plane.detail;

public class Engine {
	private String model;
	private int fuelConsumption;
	private int maxSpeed;

	public Engine(String model, int fuelConsumption, int maxSpeed) {
		this.model = model;
		this.fuelConsumption = fuelConsumption;
		this.maxSpeed = maxSpeed;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getFuelConsumption() {
		return fuelConsumption;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fuelConsumption;
		result = prime * result + maxSpeed;
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
		Engine other = (Engine) obj;
		if (fuelConsumption != other.fuelConsumption)
			return false;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Engine [model=" + model + ", fuelConsumption=" + fuelConsumption + ", maxSpeed=" + maxSpeed + "]";
	}
}