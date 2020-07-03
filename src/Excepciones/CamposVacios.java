package Excepciones;

import java.io.PrintStream;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * Excepcion creada para lanzarce cuando algun campo de la Parte Grafica se encuentra Vacio y se debe de Llenar
 *
 */
public class CamposVacios extends Exception {

	String msg;
	int cantidad;
	/**
	 * Ideas: HACER Visible iconos de que campo se encuentra vacio;
	 * @param msg
	 * @param userName
	 * @param password
	 */
	public CamposVacios(String msg, int cantidad) {
		super(msg);
		this.msg = msg;
		this.cantidad = cantidad;

		
	}
	
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("Cantidad de Campos Vacios: "+ this.cantidad + "\n" + msg);
	}
	
	
	
	
	
	
}
