package creator;

import java.io.IOException;
import java.util.ArrayList;

import business.businessFreizeitbad.Freizeitbad;

public abstract class Product {

	// public abstract void fuegeZeileHinzu(Object obj) throws IOException;
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;

	public abstract void schliesseDatei() throws IOException;
}
