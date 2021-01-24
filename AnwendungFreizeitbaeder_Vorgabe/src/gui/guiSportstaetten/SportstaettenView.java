package gui.guiSportstaetten;

import java.util.Iterator;

import business.businessFreizeitbad.Freizeitbad;
//import business.Freizeitbad;
import business.businessFreizeitbad.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView {

	private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthalleModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	Font font = new Font("Arial", 24);

	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitb�der");
	private Label lblAnzeigeSportstaetten = new Label("Anzeige Sporthallen");

	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private TextArea txtAnzeigeSportstaetten = new TextArea();

	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	private Button btnAnzeigeSporthallen = new Button("Csv- Import und Anzeige");

	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportstaettenControl, Stage primaryStage,
			FreizeitbaederModel freizeitbaederModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportst�tten");
		primaryStage.show();
		// Hier ergaenzen
		this.sportstaettenControl = sportstaettenControl;
		this.freizeitbaederModel = freizeitbaederModel;

		this.initKomponentenFreizeitbaeder();
		this.initListener();

	}

	private void initKomponentenFreizeitbaeder() {
		// Label
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);
	}

	private void initListener() {
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbadAn();
			}
		});
	}

	
	void zeigeFreizeitbadAn() {
		if (freizeitbaederModel.getFreizeitbad() != null) {
			// txtAnzeigeFreizeitbaeder.setText(freizeitbaederModel.getFreizeitbad().gibFreizeitbadZurueck('
			// '));
			StringBuffer text = new StringBuffer();
			for (Freizeitbad fzb : this.freizeitbaederModel.getFreizeitbad()) {
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
			}
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}
	
	
	void zeigeSporthalleAn() throws PlausiException {
		try {
			sporthalleModel.leseSporthallenAusCsvDatei();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if (sporthalleModel.getSporthallen().size()>0) {
			StringBuffer buffer = new StringBuffer();
			for (Sporthalle sphalle : sporthalleModel.getSporthallen()) {
				buffer.append(sphalle.gibSporthalleZurueck(' ')+"\n");
			}
			this.txtAnzeigeSportstaetten.setText(buffer.toString());
		} else {
			zeigeInformationsfensterAn("Fehler, keine Sporthalle importiert.");
		}
		
	}
	
	

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(fehlertyp + "Fehler").zeigeMeldungsfensterAn();
	}
}
