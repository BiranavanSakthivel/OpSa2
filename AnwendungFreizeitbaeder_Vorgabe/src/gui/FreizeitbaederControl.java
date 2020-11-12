package gui;

import javafx.stage.*;
import java.io.*;

import business.FreizeitbaederModel;

public class FreizeitbaederControl{

	private static FreizeitbaederView freizeitbaederView;
	private static FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage){
		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederView	= new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
	}

	public static void schreibeFreizeitbaederInDatei(String typ){
		try{
			if("csv".equals(typ)){
				freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Die Freizeitbaeder wurden erfolgreich gespeichert");
			}
			else
				freizeitbaederView.zeigeInformationsfensterAn("Fehler ");
		}
		catch(IOException exc){
			freizeitbaederView.zeigeFehlermeldungAn("Fehler", "Exception beim der Speicherung");
		}
		catch(Exception exc){
			freizeitbaederView.zeigeFehlermeldungAn("Fehler","unbekannter Fehler");
		}
	}

}
