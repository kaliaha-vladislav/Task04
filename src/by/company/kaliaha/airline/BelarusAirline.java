package by.company.kaliaha.airline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.util.Sorter;

public class BelarusAirline extends Airline {
	private ArrayList<Aircraft> planes;
	private Sorter sorter;
	
	public BelarusAirline() {
		planes = new ArrayList<Aircraft>();
		sorter = new Sorter();
	}

	@Override
	public boolean add(Aircraft aircraft) {
		boolean isAdded = false;
		if(aircraft != null && aircraft.setAirline(this)) {
			planes.add(aircraft);
			isAdded = true;			
		}	
		return isAdded;
	}

	@Override
	public boolean remove(Aircraft aircraft) {
		boolean isRemoved = false;
		if(aircraft != null) {
			for(Aircraft currentAircraft : this) {
				if(currentAircraft.getId() == aircraft.getId()) {
					planes.remove(currentAircraft);
					isRemoved = true;
					break;
				}
			}
		}
		return isRemoved;
	}

	@Override
	public int size() {
		return planes.size();
	}

	@Override
	public Aircraft getPlane(int index) {
		return isInBounds(index) ? null : planes.get(index);
	}
	
	private boolean isInBounds(int index) {
		return (index < 0 || index > planes.size()) ? false : true;
	}

	@Override
	public boolean sort() {		
		return sorter.sort(this);
	}
	
	public void sort(Comparator<Aircraft> comparator) {		
		planes.sort(comparator);
	}
	
	public void swap(int maxIndex, int minIndex) {
		if(isInBounds(maxIndex) && isInBounds(minIndex)) {
			Aircraft tmp = planes.get(maxIndex);
			planes.set(maxIndex, planes.get(minIndex));
			planes.set(minIndex, tmp);
		}
	}
	
	@Override
	public Iterator<Aircraft> iterator() {
		Iterator<Aircraft> iterator = new Iterator<Aircraft>() {
			private int currentIndex = 0;
			
			@Override
			public boolean hasNext() {			
				return currentIndex++ < planes.size();
			}

			@Override
			public Aircraft next() {
				return planes.get(currentIndex - 1);
			}
			
			@Override
			public void remove() {
				planes.remove(currentIndex - 1);
			}
		};
		return iterator;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planes == null) ? 0 : planes.hashCode());
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
		BelarusAirline other = (BelarusAirline) obj;
		if (planes == null) {
			if (other.planes != null)
				return false;
		} else if (!planes.equals(other.planes))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" contains the following items:\n");
		for(Aircraft plane : planes) {
			sb.append("  "+ plane.toString() + "\n");
		}
		return sb.toString();
	}
}