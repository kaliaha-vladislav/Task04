package by.company.kaliaha.util.file_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import by.company.kaliaha.plane.Aircraft;
import by.company.kaliaha.util.aircraft_parser.AircraftParser;
import by.company.kaliaha.util.aircraft_parser.StringAircraftParser;
import by.company.kaliaha.util.exception.BodyTypeIsNotExistedException;
import by.company.kaliaha.util.exception.FileIsNotExited;
import by.company.kaliaha.util.exception.IncorrectBodyLineException;
import by.company.kaliaha.util.exception.NullArgumentParserException;

public class FileParser {
	private String engine;
	private String body;
	AircraftParser aircraftParser;

	public FileParser() {
		aircraftParser = new StringAircraftParser();
		engine = aircraftParser.getEngineSeparator();
		body = aircraftParser.getBodySeparator();
	}
	
	public ArrayList<Aircraft> getAircrafts(String fileName) 
			throws FileIsNotExited, BodyTypeIsNotExistedException, IncorrectBodyLineException, NullArgumentParserException {
		ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
		
		ArrayList<String> data = getDataFromFile(fileName);
		for (int index = 0; index + 2 < data.size(); index += 3) {
			String model = data.get(index);
			String engine = data.get(index + 1);
			String body = data.get(index + 2);
			
			Aircraft aircraft = aircraftParser.parseAircraft(model, body, engine);
			if(aircraft != null) {
				aircrafts.add(aircraft);
			}			
		}
		return aircrafts;
	}

	private ArrayList<String> getDataFromFile(String fileName) throws FileIsNotExited {
		ArrayList<String> data = uploadData(fileName);
		int dataSize = data.size();
		for (int index = 0; index + 2 < dataSize; index += 3) {
			while(index + 2 < dataSize) {
				String currentModel = data.get(index);
				String currentEngine = data.get(index + 1);
				String currentBody = data.get(index + 2);
				if (currentModel != null && isEngineString(currentEngine) && isBodyString(currentBody)) {						
					break;
				}
				data.remove(index);
				dataSize = data.size();
			}
		}
		return data;
	}
	
	private boolean isEngineString(String currentEngine) {
		return currentEngine.length() >= engine.length() && engine.equals(currentEngine.substring(0, engine.length()));
	}
	
	private boolean isBodyString(String currentBody) {
		return currentBody.length() >= body.length() && body.equals(currentBody.substring(0, body.length()));
	}

	private ArrayList<String> uploadData(String fileName) throws FileIsNotExited {
		ArrayList<String> data = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line = null;
			data = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				if (!line.equals("")) {
					data.add(line);
				}

			}
		} catch (Exception e) {
			throw new FileIsNotExited(e.getMessage());
		}
		return data;
	}
	
	public String aircraftToString(Aircraft aircraft) {
		return aircraftParser.aircraftToString(aircraft);
	}
}