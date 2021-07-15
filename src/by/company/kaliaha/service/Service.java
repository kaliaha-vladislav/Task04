package by.company.kaliaha.service;

import java.util.ArrayList;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.data_access_layer.Data;
import by.company.kaliaha.data_access_layer.DataFile;
import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.air_freighter.AirFreighter;
import by.company.kaliaha.plane.passenger.PassengerAircraft;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.FileIsNotExited;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullAirlineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;


public class Service {
	private Data data;
	
	public Service()  {
		data = new DataFile();				
	}
	
	public void uploadData(Airline airline) 
			throws FileIsNotExited, BodyTypeIsNotExistedException, IncorrectBodyLineException, 
				   NullArgumentParserException, NullAirlineException {
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		data.upload(airline);
	}
	
	public void saveData(Airline airline) throws FileIsNotExited, NullAirlineException{
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		data.save(airline);
	}
	
	public int calculatePassengerCapacity(Airline airline) throws NullAirlineException {
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		int countPassengerCapacity = 0;
		for(Aircraft aircraft : airline) {
			if(aircraft instanceof PassengerAircraft) {
				countPassengerCapacity += ((PassengerAircraft)aircraft).getPassengerCapacity();
			}
		}
		return countPassengerCapacity;
	}
	
	public int calculateFreighterCapacity(Airline airline) throws NullAirlineException {
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		int countFreighterCapacity = 0;
		for(Aircraft aircraft : airline) {
			if(aircraft instanceof AirFreighter) {
				countFreighterCapacity += ((AirFreighter)aircraft).getFreighterCapacity();
			}
		}
		return countFreighterCapacity;
	}
	
	public ArrayList<Aircraft> findPlanesByFuelConsumptionBounds(Airline airline, int low, int heigh) throws NullAirlineException {
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		ArrayList<Aircraft> array = new ArrayList<Aircraft>();
		for(Aircraft plane : airline) {
			if(plane.getFuelConsumption() >= low && plane.getFuelConsumption() <= heigh) {
				array.add(plane);
				break;
			}
		}
		return array;
	}
}	