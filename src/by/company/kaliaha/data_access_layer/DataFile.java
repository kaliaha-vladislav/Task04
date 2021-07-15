package by.company.kaliaha.data_access_layer;

import java.io.FileWriter;
import java.util.ArrayList;

import by.company.kaliaha.airline.Airline;
import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.FileIsNotExited;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullAirlineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;
import by.company.kaliaha.util.file_parser.FileParser;


public class DataFile implements Data{
	private final static String FILE_NAME = "Airline.txt";
	private FileParser fileParser;

	public DataFile() {
		fileParser = new FileParser();
	}

	@Override
	public void upload(Airline airline) 
			throws FileIsNotExited, BodyTypeIsNotExistedException, IncorrectBodyLineException, 
				   NullArgumentParserException, NullAirlineException  {
		if(airline == null) {
			throw new NullAirlineException();
		}
		
		ArrayList<Aircraft> data = fileParser.getAircrafts(FILE_NAME);
		for(Aircraft aircraft : data) {
			if(aircraft != null) {
				airline.add(aircraft);
			}
		}	
	}
	
	@Override
	public void save(Airline airline) throws FileIsNotExited {
		try (FileWriter writer = new FileWriter(FILE_NAME);) {
			for (Aircraft aircraft : airline) {
				writer.write(fileParser.aircraftToString(aircraft) + "\n");
			}
		} catch(Exception e) {
			throw new FileIsNotExited(e.getMessage());
		}
	}
}