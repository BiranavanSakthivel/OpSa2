package creator;

import java.io.*;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends Product {

	private BufferedWriter aus;

	public ConcreteCsvWriterProduct() throws IOException {
		aus = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
	}

	public void fuegeZeileHinzu(Object obj) throws IOException {

		aus.write(((Freizeitbad) obj).gibFreizeitbadZurueck(';'));
		aus.close();

	}

}
