package Excepciones;

import java.io.PrintStream;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
