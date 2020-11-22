package creator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

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
	public void fuegeZeileHinzu(Object obj) throws IOException {

		aus.write(((Freizeitbad) obj).gibFreizeitbadZurueck(' '));
		aus.close();
	}
}
