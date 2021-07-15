package by.company.kaliaha.util.aircraft_parser;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;

public interface AircraftParser {
	public String getEngineSeparator();
	public String getBodySeparator();
	public Aircraft parseAircraft(String model, String body, String engine) throws  BodyTypeIsNotExistedException, IncorrectBodyLineException, NullArgumentParserException;
	public String aircraftToString(Aircraft aircraft);
}