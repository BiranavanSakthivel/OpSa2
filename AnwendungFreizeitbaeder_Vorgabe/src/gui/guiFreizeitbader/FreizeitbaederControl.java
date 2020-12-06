package gui.guiFreizeitbader;

import javafx.stage.*;
import java.io.*;

import business.FreizeitbaederModel;
import obs.Observer;


public class FreizeitbaederControl implements Observer{

	private static FreizeitbaederView freizeitbaederView;
	private static FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.freizeitbaederModel.addObserver(this);
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
	}

	public static void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbadInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Die Freizeitbaeder wurden erfolgreich gespeichert");
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbadInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde in TXT gespeichert!");
			} else
				freizeitbaederView.zeigeInformationsfensterAn("Fehler ");
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungAn("Fehler", "Exception beim der Speicherung");
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungAn("Fehler", "unbekannter Fehler");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.freizeitbaederView.zeigeFreizeitbaederAn();
	}

}
