package by.company.kaliaha.util;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.plane.Aircraft;

public class Sorter {
	public boolean sort(Airline airline) {
		boolean needIteration = true;
		while (needIteration) {
			needIteration = doIteration(airline);
		}
		return true;
	}
	
	private boolean doIteration(Airline airline) {
		boolean needIteration = false;
		for (int index = 1; index < airline.size(); ++index) {
			Aircraft current = airline.getPlane(index);
			Aircraft preCurrent = airline.getPlane(index - 1);
			if (current.compareTo(preCurrent) < 0) {
				airline.swap(index, index - 1);
				needIteration = true;
			}
		}
		return needIteration;
	}
}