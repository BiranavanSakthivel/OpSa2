package business;

import business.*;
import gui.FreizeitbaederView;
import javafx.stage.*;
import java.io.*;

public class FreizeitbaederControl{

	private static FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage){
		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederView	= new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
	}

	public static void schreibeFreizeitbaederInDatei(String typ){
		try{
			if("csv".equals(typ)){
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Die Freizeitbaeder wurden erfolgreich gespeichert");
			}
			else
				freizeitbaederView.zeigeInformationsfensterAn("Fehler ");
		}
		catch(IOException exc){
			freizeitbaederView.zeigeFehlermeldungAn("ERROR", "Exception beim der Speicherung");
		}
		catch(Exception exc){
			freizeitbaederView.zeigeFehlermeldungAn("ERROR","unbekannter Fehler");
		}
	}

}
