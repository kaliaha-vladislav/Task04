package by.company.kaliaha.util.aircraft_parser;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.plane.air_freighter.AirFreighter;
import by.company.kaliaha.plane.air_freighter.AirFreighterInstance;
import by.company.kaliaha.plane.detail.Engine;
import by.company.kaliaha.plane.detail.body.AircraftBody;
import by.company.kaliaha.plane.detail.body.freighter.AirFreighterBodyInstance;
import by.company.kaliaha.plane.detail.body.passenger.PassengerAircraftBodyInstance;
import by.company.kaliaha.plane.passenger.PassengerAircraft;
import by.company.kaliaha.plane.passenger.PassengerAircraftInstance;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.IncorrectEngineLineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;

public class StringAircraftParser implements AircraftParser {
	private static final String ENGINE_SEPARATOR = "Engine: ";
	private static final String BODY_SEPARATOR = "Body: ";
	private static final String BODY_TYPE_PASSENGER = "Passenger";
	private static final String BODY_TYPE_FREIGHTER = "Freighter";
	private static final String SEPARATOR = ", ";

	public StringAircraftParser() {}

	public String getEngineSeparator() {
		return ENGINE_SEPARATOR;
	}

	public String getBodySeparator() {
		return BODY_SEPARATOR;
	}

	public Aircraft parseAircraft(String model, String body, String engine)
			throws NullArgumentParserException, BodyTypeIsNotExistedException, IncorrectBodyLineException {
		if (model == null || body == null || engine == null) {
			throw new NullArgumentParserException("Argument in parsetAircraft can not be null");
		}

		AircraftBody bodyInstance = parseAircraftBody(body);
		Engine engineInstance = parseEngine(engine);

		Aircraft aircraft = createInstance(model, bodyInstance, engineInstance);

		return aircraft;
	}

	private AircraftBody parseAircraftBody(String line)
			throws BodyTypeIsNotExistedException, IncorrectBodyLineException {
		int end = 0;
		if (!line.contains(BODY_SEPARATOR) || (end = line.indexOf(SEPARATOR)) == -1) {
			throw new IncorrectBodyLineException("Incorrect body line(Incorrect structure)");
		}

		int start = line.indexOf(' ') + 1;
		String type = line.substring(start, end);

		int start2 = line.indexOf(' ', start) + 1;
		String number = line.substring(start2);

		return invokeToBody(type, number);
	}

	private AircraftBody invokeToBody(String type, String number)
			throws BodyTypeIsNotExistedException, IncorrectBodyLineException {
		if (!isNumber(number)) {
			throw new IncorrectBodyLineException("Incorrect body line(Incorrect number)");
		}

		AircraftBody body = null;
		if (type.equals(BODY_TYPE_PASSENGER)) {
			body = new PassengerAircraftBodyInstance(Integer.valueOf(number));
		} else if (type.equals(BODY_TYPE_FREIGHTER)) {
			body = new AirFreighterBodyInstance(Integer.valueOf(number));
		} else {
			throw new BodyTypeIsNotExistedException();
		}
		return body;
	}
	
	private boolean isNumber(String string) {
		boolean isNumber = true;
		for (int index = 0; index < string.length(); ++index) {
			if (!Character.isDigit(string.charAt(index))) {
				isNumber = false;
				break;
			}
		}
		return isNumber;
	}

	private Engine parseEngine(String line) throws BodyTypeIsNotExistedException, IncorrectBodyLineException {
		int end = 0;
		if (!line.contains(ENGINE_SEPARATOR) || (end = line.indexOf(SEPARATOR)) == -1) {
			new IncorrectEngineLineException("Incorrect engine line(Incorrect structure)");
		}

		int start = line.indexOf(' ');
		String model = line.substring(start + 1, end);

		int end2 = line.indexOf(SEPARATOR, end + 1);
		int start2 = line.indexOf(' ', start + 1);
		String fuelConsumption = line.substring(start2 + 1, end2);

		int start3 = line.indexOf(' ', start2 + 1);
		String speed = line.substring(start3 + 1);

		return invokeToEngine(model, fuelConsumption, speed);
	}
	
	private Engine invokeToEngine(String model, String fuelConsumption, String speed)
			throws BodyTypeIsNotExistedException, IncorrectBodyLineException {
		if (!isNumber(fuelConsumption) || !isNumber(speed)) {
			throw new IncorrectBodyLineException("Incorrect engine line(Incorrect number)");
		}

		return new Engine(model, Integer.valueOf(fuelConsumption), Integer.valueOf(speed));
	}

	private Aircraft createInstance(String modelInstance, AircraftBody bodyInstance, Engine engineInstance) {
		Aircraft aircraft = null;
		if (bodyInstance instanceof PassengerAircraftBodyInstance) {
			aircraft = new PassengerAircraftInstance(modelInstance, bodyInstance, engineInstance);
		} else if (bodyInstance instanceof AirFreighterBodyInstance) {
			aircraft = new AirFreighterInstance(modelInstance, bodyInstance, engineInstance);
		}
		return aircraft;
	}

	public String aircraftToString(Aircraft aircraft) {
		StringBuilder builder = new StringBuilder();
		builder.append(aircraft.getModel() + "\n");
		builder.append(ENGINE_SEPARATOR + aircraft.getEngineModel() + SEPARATOR);
		builder.append(aircraft.getFuelConsumption() + SEPARATOR);
		builder.append(aircraft.getMaxSpeed() + "\n");
		if (aircraft instanceof PassengerAircraft) {
			PassengerAircraft pAircraft = (PassengerAircraft) aircraft;
			builder.append(BODY_SEPARATOR + pAircraft.getBodyType() + SEPARATOR);
			builder.append(pAircraft.getPassengerCapacity());
		} else if (aircraft instanceof AirFreighter) {
			AirFreighter fAircraft = (AirFreighter) aircraft;
			builder.append(BODY_SEPARATOR + fAircraft.getBodyType() + SEPARATOR);
			builder.append(fAircraft.getFreighterCapacity());
		}
		return builder.toString();
	}
}