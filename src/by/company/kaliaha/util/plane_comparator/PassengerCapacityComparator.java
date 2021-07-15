package by.company.kaliaha.util.plane_comparator;

import java.util.Comparator;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.passenger.PassengerAircraft;


public class PassengerCapacityComparator implements Comparator<Aircraft> {
	@Override
	public int compare(Aircraft first, Aircraft second) {
		int result = 0;
		if (first instanceof PassengerAircraft && second instanceof PassengerAircraft) {
			result = helpToCompare((PassengerAircraft)first, (PassengerAircraft)second);
		}
		return result;
	}

	private int helpToCompare(PassengerAircraft first, PassengerAircraft second) {
		int result = 0;
		if (first.getPassengerCapacity() > second.getPassengerCapacity()) {
			result = 1;
		} else if (first.getPassengerCapacity() < second.getPassengerCapacity()) {
			result = -1;
		}
		return result;	
	}
}