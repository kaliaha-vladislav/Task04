package by.company.kaliaha.util.plane_comparator;

import java.util.Comparator;

import by.company.kaliaha.plane.Aircraft;

public class AircraftNameComparator implements Comparator<Aircraft>{
	@Override
	public int compare(Aircraft first, Aircraft second) {		
		String thisModel = first.getModel();
		String otherModel = second.getModel();
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
}