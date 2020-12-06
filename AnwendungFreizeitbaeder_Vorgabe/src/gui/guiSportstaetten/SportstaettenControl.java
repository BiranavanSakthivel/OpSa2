package gui.guiSportstaetten;

import business.FreizeitbaederModel;
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

	@Override
	public void update() {

		this.sportstaettenView.zeigeFreizeitbadAn();

	}

}
