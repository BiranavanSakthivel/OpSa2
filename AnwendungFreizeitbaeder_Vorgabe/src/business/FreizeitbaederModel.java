package business;

import java.io.*;

public class FreizeitbaederModel{

  public Freizeitbad freizeitbad;

  public void schreibeFreizeitbaederInCsvDatei() throws IOException{
    // Werfen einer IOException
    BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
    aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
    aus.close();
  }

  public Freizeitbad getFreizeitbad(){
    return freizeitbad;
  }

}
