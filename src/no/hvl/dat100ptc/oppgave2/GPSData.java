package no.hvl.dat100ptc.oppgave2;

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

	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		// Konverterer verdiene i parametre fra String til int og double
		int tid = Integer.parseInt(time);
		double lat = Double.parseDouble(latitude);
		double lon = Double.parseDouble(longitude);
		double hoyde = Double.parseDouble(elevation);
		
		gpspoint = new GPSPoint(tid, lat, lon, hoyde);
		return insertGPS(gpspoint);

	}

	public void print() {
		
		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i < antall; i++) {
			System.out.println(gpspoints[i].toString());
		}
		System.out.println("====== GPS Data - SLUTT ======");
		
	}
}
