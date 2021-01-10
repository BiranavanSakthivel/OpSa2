package business;

import java.io.*;
import java.util.ArrayList;

import creator.ConcreteCsvWriterCreator;
import creator.ConcreteTxtWriterCreator;
import creator.Creator;
import creator.Product;
import obs.Observable;
import obs.Observer;

public class FreizeitbaederModel implements Observable {

	ArrayList<Observer> observers = new ArrayList<Observer>();
	private static FreizeitbaederModel theInstance = null;
	public ArrayList<Freizeitbad> freizeitbad = new ArrayList<>();

	private FreizeitbaederModel() {
	}

	/*
	 * public void schreibeFreizeitbaederInCsvDatei() throws IOException { // Werfen
	 * einer IOException BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Freizeitbaeder.csv", true));
	 * aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */

	public void schreibeFreizeitbadInCsvDatei() throws IOException {
		Creator writerCreator = new ConcreteCsvWriterCreator();
		Product writer = writerCreator.factoryMethod();
		for (Freizeitbad fzb : this.freizeitbad)
			writer.fuegeInDateiHinzu(fzb);
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbadInTxtDatei() throws IOException {

		Creator writerCreater = new ConcreteTxtWriterCreator();
		Product writer = writerCreater.factoryMethod();
		for (Freizeitbad fzb : this.freizeitbad)
			writer.fuegeInDateiHinzu(fzb);
		writer.schliesseDatei();
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
	}

	public static FreizeitbaederModel getInstance() {
		if (theInstance == null) {
			theInstance = new FreizeitbaederModel();
			return theInstance;
		} else {
			return theInstance;
		}
	}

	/*
	 * public void setFreizeitbad(ArrayList<Freizeitbad> freizeitbad) {
	 * this.freizeitbad = freizeitbad; // setChanged(); notifyObservers(); }
	 */

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer o : this.observers) {
			o.update();
		}
	}
}
