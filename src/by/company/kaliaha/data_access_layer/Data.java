package by.company.kaliaha.data_access_layer;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.FileIsNotExited;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullAirlineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;

public interface Data {
	public void upload(Airline airline) throws FileIsNotExited, BodyTypeIsNotExistedException, 
											   IncorrectBodyLineException, NullArgumentParserException, NullAirlineException;
	public void save(Airline airline) throws FileIsNotExited;
}
