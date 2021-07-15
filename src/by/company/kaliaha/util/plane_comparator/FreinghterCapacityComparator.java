package by.company.kaliaha.util.plane_comparator;

import java.util.Comparator;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.air_freighter.AirFreighter;

public class FreinghterCapacityComparator implements Comparator<Aircraft> {
	@Override
	public int compare(Aircraft first, Aircraft second) {
		int result = 0;
		if(first instanceof AirFreighter && second instanceof AirFreighter) {
			int firstCarryingCapacity = ((AirFreighter)first).getFreighterCapacity();
			int secondCarryingCapacity = ((AirFreighter)second).getFreighterCapacity();
			
			if (firstCarryingCapacity > secondCarryingCapacity) {
				result = 1;
			} else if (firstCarryingCapacity < secondCarryingCapacity) {
				result = -1;
			}
		}
		return result;	
	}
}