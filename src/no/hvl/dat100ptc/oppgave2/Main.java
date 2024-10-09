package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {
		//kaller convertmetoden
		GPSPoint g = GPSDataConverter.convert("2017-08-13T08:52:26.000Z", "60.385390", "5.217217", "61.9");
		System.out.println(g); //skriver det ut
		
		System.out.println();

		// Lager to GPS punkter
		GPSPoint g1 = GPSDataConverter.convert("2017-08-13T08:52:26.000Z", "60.385390", "5.217217", "7.0");
		GPSPoint g2 = GPSDataConverter.convert("2017-08-13T08:53:00.000Z", "60.385588", "5.217857", "11.1");

		// Lager ny GPS tabell med plass til to punkter
		GPSData gpsdata = new GPSData(2);
		
		// Bruker insertGPS metoden for å legge til punktene i tabellen
		gpsdata.insertGPS(g1);
		gpsdata.insertGPS(g2);

		// Bruker print metoden for å skrive ut punktene i tabellen
		gpsdata.print();

		System.out.println();
	}
}
