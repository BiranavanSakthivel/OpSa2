package business;

import java.io.*;

import creator.ConcreteCsvWriterCreator;
import creator.ConcreteTxtWriterCreator;
import creator.Creator;
import creator.Product;

public class FreizeitbaederModel {

	public Freizeitbad freizeitbad;

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		// Werfen einer IOException
		BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();
	}

	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void schreibeFreizeitbadInCsvDatei() throws IOException {
		Creator writerCreator = new ConcreteCsvWriterCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeZeileHinzu(this.freizeitbad);
	}

	public void schreibeFreizeitbadInTxtDatei() throws IOException {

		Creator writerCreater = new ConcreteTxtWriterCreator();
		Product writer = writerCreater.factoryMethod();
		writer.fuegeZeileHinzu(this.freizeitbad);

	}
}
