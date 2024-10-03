package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		//a)		
		int tIndex = timestr.indexOf("T");
		int firstColonIndex = timestr.indexOf(":");
		int secondColongIndex = timestr.indexOf(":" , firstColonIndex + 1);
		
		// bruk substring for å hente timer, minutter og sekunder
		String timer = timestr.substring(tIndex + 1, firstColonIndex);
		int hr = Integer.parseInt(timer);
		// bruk parseInt for å konverterer String til int
		String minutter = timestr.substring(firstColonIndex + 1, secondColongIndex);
		int min = Integer.parseInt(minutter);
		String sekunder = timestr.substring(secondColongIndex + 1, timestr.indexOf("."));
		int sec = Integer.parseInt(sekunder);

		// beregn total antall sekunder
		int total = (hr * 3600) + (min * 60) + sec;
		
		// returner antall sekunder
		return total;
		
		
		
		// TODO
		
		
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
