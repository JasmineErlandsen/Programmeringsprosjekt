package no.hvl.dat100ptc.oppgave3;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for(double d : da) {
			if (d < min) {
				min = d;
			}
			
			
		}
		
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] lat = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			lat[i] = gpspoints[i].getLatitude();
			
			
		}
		return lat;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[] lon = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			lon[i] = gpspoints[i].getLongitude();
		}
		
		return lon; 

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double phi1 = latitude1;
		double phi2 = latitude2;
		double deltaphi = latitude2 - latitude1;
		double deltadelta = longitude2 - longitude1;
		
		double a = compute_a(phi1, phi2, deltaphi, deltadelta);
		double c = compute_c(a);
		
		d = R * c;

		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		double a = Math.pow(Math.sin(deltaphi / 2), 2) + (Math.cos(phi1) * Math.cos(phi2) * (Math.pow(Math.sin(deltadelta / 2), 2)));

		return a; 

	}

	private static double compute_c(double a) {

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return c;

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		
		secs = time2 - time1;
		
		if(secs <= 0) {
			return 0;
		}
		
		speed = distance(gpspoint1, gpspoint2) / secs;
		
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		int hr = secs / 3600;
		String hrstr = " ";
		if ( hr < 10){
			hrstr += "0" + hr;
		} else {
			hrstr += hr;
		}

		int min = (secs % 3600) / 60;
		String minstr = "";
		if ( min < 10){
			minstr = "0" + min;
		} else {
			minstr += min;
		}

		int sec = secs % 60;
		String secstr = "";
		if ( sec < 10){
			secstr = "0" + sec;
		} else {
			secstr += sec;
		}
		
		timestr = " " + hrstr + TIMESEP + minstr + TIMESEP + secstr;

		return timestr;
		
	}
	
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";

		double a = (d * 100) + 0.5;
		int b = (int)(a);
		double c = b / 100.0;
		String cstr = "";
		cstr += c; 
		
		
		for (int i = 0; i < TEXTWIDTH - cstr.length(); i++){
			str += " ";
		}

		str += cstr;

		return str;
	}
}
