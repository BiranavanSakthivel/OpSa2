package creator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.businessFreizeitbad.Freizeitbad;

public class ConcretetxtWriterProduct extends Product {

	BufferedWriter aus;

	public ConcretetxtWriterProduct() {
		try {
			aus = new BufferedWriter(new FileWriter("Freizeitbad.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
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

	/*
	 * public void schreibeArtikel(ArrayList<Freizeitbad> artikel) throws
	 * IOException{ BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Artikel.txt")); aus.write(artikel.size() + ""); aus.newLine();
	 * 
	 * for(Freizeitbad art : artikel){ aus.write(art.getArtikelnummer());
	 * aus.newLine(); aus.write(art.getArtikelname()); aus.newLine();
	 * aus.write(art.getBasispreis() + ""); aus.newLine(); } aus.close(); }
	 * 
	 * /*
	 * 
	 * @Override public void fuegeZeileHinzu(Object obj) throws IOException {
	 * aus.write(((Freizeitbad) obj).gibFreizeitbadZurueck(' ')); aus.close(); }
	 */
}
