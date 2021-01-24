package gui.guiSportstaetten;

import java.io.IOException;

import business.businessFreizeitbad.FreizeitbaederModel;
import javafx.stage.Stage;
import obs.Observer;

public class SportstaettenControl implements Observer {

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbaederInDatei(String typ){
		 try{
			 if("csv".equals(typ)){
				 this.freizeitbaederModel.schreibeFreizeitbadInCsvDatei();
				 this.sportstaettenView.zeigeInformationsfensterAn("Das Freizeitbad wurde erfolgreich in die CSV-Datei geschreiben.");
			 }
			 else if("txt".equals(typ)){
				 this.freizeitbaederModel.schreibeFreizeitbadInTxtDatei();
				 this.sportstaettenView.zeigeInformationsfensterAn("Das Freizeitbad wurde erfolgreich in die Text-Datei geschrieben.");
			 }
			 else {
				 this.sportstaettenView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			 }
		 }
		 catch(IOException exc){
			 this.sportstaettenView.zeigeFehlermeldungAn("I/O Fehler", "IOException beim Speichern");
		 }
		 catch(Exception exc){
			 this.sportstaettenView.zeigeFehlermeldungAn("Unbekannter Fehler", "Unbekannter Fehler beim Speichern");
		 }
	}

	@Override
	public void update() {

		this.sportstaettenView.zeigeFreizeitbadAn();

	}

}
