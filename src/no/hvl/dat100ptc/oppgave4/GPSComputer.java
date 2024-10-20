package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	public double totalDistance() {

		double totalDistance = 0.0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			GPSPoint point1 = gpspoints[i];
			GPSPoint point2 = gpspoints[i + 1];

			totalDistance += GPSUtils.distance(point1, point2);
		}

		return totalDistance;

	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double point1 = gpspoints[i].getElevation();
			double point2 = gpspoints[i + 1].getElevation();

			if (point2 - point1 > 0) {
				elevation += point2 - point1;
			}

		}
		return elevation;
	}

	public int totalTime() {

		int totalTime = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			if (gpspoints[i + 1].getTime() > gpspoints[i].getTime()) {
				totalTime += gpspoints[i + 1].getTime() - gpspoints[i].getTime();
			}
		}

		return totalTime;
	}

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < speeds.length; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
		}

		return speeds;
	}

	public double maxSpeed() {

		double maxspeed = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			GPSPoint gpspoint1 = gpspoints[i];
			GPSPoint gpspoint2 = gpspoints[i + 1];
			double speed = GPSUtils.speed(gpspoint1, gpspoint2);
			if (speed > maxspeed) {
				maxspeed = speed;
			}

		}
		return maxspeed;

	}

	public double averageSpeed() {
	    double totalspeed = 0;

	    for (int i = 0; i < gpspoints.length - 1; i++) {
	        GPSPoint gpspoint1 = gpspoints[i];
	        GPSPoint gpspoint2 = gpspoints[i + 1];
	        double speed = GPSUtils.speed(gpspoint1, gpspoint2);
	        totalspeed += speed;
	    }

	    double averageSpeed = totalspeed / (gpspoints.length - 1);
	    return averageSpeed;
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		double speedmph = speed * MS;

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		// TODO
		throw new UnsupportedOperationException(TODO.method());

	}

}
