package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		//a)		
		int secs;
		int hr, min, sec;
		
		//Bruker substring(beginning index, end index) for å finne rett plass.
		hr = Integer.parseInt(timestr.substring(11, 13));
		min = Integer.parseInt(timestr.substring(14, 16));
		sec = Integer.parseInt(timestr.substring(17, 19));

		// beregn total antall sekunder
		int total = (hr * 3600) + (min * 60) + sec;
		
		// returner antall sekunder
		return total;
		
		
		
		
		
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;
		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		return new GPSPoint(time, latitude, longitude, elevation);
		
		
	}
	
}
