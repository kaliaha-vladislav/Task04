package by.company.kaliaha.airline;

import java.util.Comparator;
import java.util.Iterator;

import by.company.kaliaha.plane.Aircraft;

public abstract class Airline implements Iterable<Aircraft>{
	public abstract int size();
	public abstract Aircraft getPlane(int index);
	public abstract void swap(int index, int preIndex);
	
	public abstract boolean add(Aircraft plane);
	public abstract boolean remove(Aircraft plane);
	
	public abstract boolean sort();
	public abstract void sort(Comparator<Aircraft> comparator);
	
	public abstract boolean equals(Object obj);
	public abstract int hashCode();
	
	public abstract Iterator<Aircraft> iterator();
}