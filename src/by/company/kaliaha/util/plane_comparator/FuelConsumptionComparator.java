package by.company.kaliaha.util.plane_comparator;

import java.util.Comparator;

import by.company.kaliaha.plane.Aircraft;

public class FuelConsumptionComparator implements Comparator<Aircraft> {
	@Override
	public int compare(Aircraft first, Aircraft second) {
		int result = 0;
		int firstFuelConsumption = first.getFuelConsumption();
		int secondFuelConsumption = second.getFuelConsumption();
		
		if (firstFuelConsumption > secondFuelConsumption) {
			result = 1;
		} else if (firstFuelConsumption < secondFuelConsumption) {
			result = -1;
		}
		return result;	
	}
}