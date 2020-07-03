package Archivo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
* Esta clase lo que hace es sobreEscribir la funcion writeStreamHeader a la hora de escribir en un archivo, asi cada vez que se escriba en algun archivo no cree cabezeras y no produzca errores
* @author Matias
*
*/
public class MiObjectOutputStream extends ObjectOutputStream {
	 //Sobrescribimos el método que crea la cabecera
  protected void writeStreamHeader() throws IOException{
      // No hacer nada.
  }

  //Constructores
  public MiObjectOutputStream () throws IOException{
      super();
  }
  public MiObjectOutputStream(OutputStream out) throws IOException{
              super(out);
      }
}
