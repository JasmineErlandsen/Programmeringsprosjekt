package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		// konstruktør, oppretter tabellen med new
		gpspoints = new GPSPoint[antall];
		this.antall = 0;

	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			
			inserted = true;
			return inserted;
		}else {
			return inserted;
		}
		
		// TODO

	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		// Konverterer verdiene i parametre fra String til int og double
		int tid = Integer.parseInt(time);
		double lat = Double.parseDouble(latitude);
		double lon = Double.parseDouble(longitude);
		double hoyde =Double.parseDouble(elevation);
		
		

	}

	public void print() {
		for (int i = 0; i < antall; i++);
		
		System.out.println("====== GPS Data - START ======");
		System.out.println(insertGPS);
		System.out.println("====== GPS Data - SLUTT ======");
		
	}
}
