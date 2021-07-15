package by.company.kaliaha.runner;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.airline.BelarusAirline;
import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.air_freighter.AirFreighterInstance;
import by.company.kaliaha.plane.detail.Engine;
import by.company.kaliaha.plane.detail.body.AircraftBody;
import by.company.kaliaha.plane.detail.body.freighter.AirFreighterBodyInstance;
import by.company.kaliaha.plane.detail.body.passenger.PassengerAircraftBodyInstance;
import by.company.kaliaha.plane.passenger.PassengerAircraftInstance;
import by.company.kaliaha.service.Service;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.FileIsNotExited;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullAirlineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;
import by.company.kaliaha.util.plane_comparator.AircraftComparatorBuilder;
import by.company.kaliaha.util.plane_comparator.FreinghterCapacityComparator;

public class Runner {
	public static void main(String[] args) 
			throws FileIsNotExited, BodyTypeIsNotExistedException, IncorrectBodyLineException, NullArgumentParserException, NullAirlineException {
		Airline airline = new BelarusAirline();
		//Airline airline = createAirline();
		Service service = new Service();
		service.uploadData(airline);
		AircraftBody freighterBody = new AirFreighterBodyInstance(60_000);
		Engine engine2 = new Engine("FE50", 3_000, 784);
		Aircraft aircraft3 = new AirFreighterInstance("Boeing-747", freighterBody, engine2);
		airline.add(aircraft3);
		System.out.println(airline.toString());
		airline.remove(aircraft3);
		System.out.println(airline.toString());
		//service.saveData(airline);
	}

	public static void main1() 
			throws FileIsNotExited, BodyTypeIsNotExistedException, IncorrectBodyLineException, NullArgumentParserException, NullAirlineException {
		Airline airline = new BelarusAirline();
		//Airline airline = createAirline();
		Service service = new Service();
		service.uploadData(airline);
		
		//AircraftBody freighterBody = new AirFreighterBodyInstance(60_000);
		//Engine engine2 = new Engine("FE50", 3_000, 784);
		//Aircraft aircraft3 = new AirFreighterInstance("Boeing-747", freighterBody, engine2);
		//airline.addAircraft(aircraft3);
		
		System.out.println(airline.toString());
		System.out.println(service.calculatePassengerCapacity(airline));
		System.out.println(service.calculateFreighterCapacity(airline));
		System.out.println(service.findPlanesByFuelConsumptionBounds(airline, 8000, 13000).toString());
		
		service.saveData(airline);
	}
	
	public static Airline createAirline()  throws FileIsNotExited {
		AircraftBody passengerBody = new PassengerAircraftBodyInstance(450);
		AircraftBody freighterBody = new AirFreighterBodyInstance(60_000);

		Engine engine1 = new Engine("BF90", 12_000, 999);
		Engine engine2 = new Engine("FE50", 8_000, 784);
		Engine engine3 = new Engine("BF90CM", 15_000, 1300);

		Aircraft aircraft1 = new PassengerAircraftInstance("Boeing-747", passengerBody, engine1);
		Aircraft aircraft2 = new AirFreighterInstance("Boeing-747", freighterBody, engine1);
		Aircraft aircraft3 = new AirFreighterInstance("Boeing-747", freighterBody, engine3);
		Aircraft aircraft4 = new PassengerAircraftInstance("Boeing-747", passengerBody, engine2);

		Airline airline = new BelarusAirline();
		airline.add(aircraft1);
		airline.add(aircraft2);
		airline.add(aircraft3);
		airline.add(aircraft4);

		System.out.println(airline.toString());

		AircraftComparatorBuilder comparator = new AircraftComparatorBuilder(new FreinghterCapacityComparator());
		comparator.compareByFuelConsumption();
		//airline.sort(comparator.build());
		System.out.println(airline.toString());


		return airline;
	}

}