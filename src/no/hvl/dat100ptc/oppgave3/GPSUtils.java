package no.hvl.dat100ptc.oppgave3;

import no.hvl.dat100ptc.TODO;
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
		int i = 0;
		
		for(GPSPoint d : gpspoints) {
			lat[i] = d.getLatitude();
			i++;
			
		}
		return lat;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		double[] lon = new double[gpspoints.length];
		int i = 0;
		
		for(GPSPoint d : gpspoints) {
			lon[i] = d.getLongitude();
			i++;
		}
		
		return lon; 

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLongitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		
		double deltalat = Math.toRadians(latitude2 - latitude1);
		double deltalon = Math.toRadians(longitude2 - longitude1);

		d = R * compute_c(compute_a(latitude1, latitude2, deltalat, deltalon));

		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		double a;

		a = Math.pow(Math.sin(deltaphi / 2), 2) + (Math.cos(phi1) * Math.cos(phi2) * (Math.pow(Math.sin(deltadelta / 2), 2)));

		return a; 

	}

	private static double compute_c(double a) {

		double c;

		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return c;

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		
		secs = (time2 - time1) * 3600;
		
		speed = distance(gpspoint1, gpspoint2) / secs;
		
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO 
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO
		
	}
}
