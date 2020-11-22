package creator;

import java.io.IOException;

public class ConcreteCsvWriterCreator extends Creator {

	public Product factoryMethod() throws IOException {

		return new ConcreteCsvWriterProduct();
	}

}
