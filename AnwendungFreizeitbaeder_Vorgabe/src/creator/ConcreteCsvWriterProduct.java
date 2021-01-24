package creator;

import java.io.*;
import java.io.IOException;

import business.businessFreizeitbad.Freizeitbad;

public class ConcreteCsvWriterProduct extends Product {

	private BufferedWriter aus;

	public ConcreteCsvWriterProduct() throws IOException {
		aus = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
	}

	public void fuegeZeileHinzu(Object obj) throws IOException {

		aus.write(((Freizeitbad) obj).gibFreizeitbadZurueck(';'));
		aus.close();

	}

	public void fuegeInDateiHinzu(Object object) throws IOException {

		aus.write("Daten des Freizeitbads\n");
		aus.write("Name des Freizeitbads:\t\t\t\t\t" + ((Freizeitbad) object).getName() + "\n");
		aus.write("Öffnungszeit des Freizeitbads:\t\t\t\t" + ((Freizeitbad) object).getGeoeffnetVon() + " - "
				+ ((Freizeitbad) object).getGeoeffnetBis() + "\n");
		aus.write("Beckenlänge des Freizeitbads:\t\t\t\t" + ((Freizeitbad) object).getBeckenlaenge() + "\n");
		aus.write("Wassertemperatur des Freizeitbads:\t\t\t\t" + ((Freizeitbad) object).getTemperatur());
		aus.write("\n\n");

	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
