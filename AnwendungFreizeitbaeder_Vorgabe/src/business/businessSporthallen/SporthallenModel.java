package business.businessSporthallen;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import business.businessFreizeitbad.Freizeitbad;
import business.businessFreizeitbad.FreizeitbaederModel;
import creator.ConcreteCsvWriterCreator;
import creator.ConcreteTxtWriterCreator;
import creator.Creator;
import creator.Product;
import ownUtil.PlausiException;

public class SporthallenModel {
	private static Sporthalle freizeitbad = null;
	private static Sporthalle freizeitbaederModel = null;
	
	private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	
	private static final SporthallenModel sporthalleModel = new SporthallenModel();

	public Sporthalle getFreizeitbad() {
		return this.freizeitbad;
	}

	static SporthallenModel theInstance = null;

	public static SporthallenModel getInstance() {
		/*
		if (theInstance == null) {
			theInstance = new SporthallenModel();
			return theInstance;
		} else {
			return theInstance;
		}
		*/
		return sporthalleModel;
	}
	
	public ArrayList<Sporthalle> getSporthallen(){
		return this.sporthallen;
	}

	public SporthallenModel() {

	}

	public void setFreizeitbad(Sporthalle freizeitbad) {
		this.freizeitbad = freizeitbad;

	}

	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthallen = ergebnis;
	}

	
	public void schreibeFreizeitbadInCsvDatei() throws IOException {
		Creator writerCreator = new ConcreteCsvWriterCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
	}

	public void schreibeFreizeitbadInTxtDatei() throws IOException {

		Creator writerCreater = new ConcreteTxtWriterCreator();
		Product writer = writerCreater.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);

	}

	public Sporthalle leseSporthalleAusCsvDatei() throws IOException, Exception {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthalle.csv"));
		String[] zeile = ein.readLine().split(";");
		Sporthalle ergebnis = new Sporthalle(zeile[0], zeile[1], zeile[2]);
		return ergebnis;
	}

}
