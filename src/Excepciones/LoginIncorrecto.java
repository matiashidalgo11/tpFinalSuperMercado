package Excepciones;



import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 
 * Excepcion que se lanza cuando algun campo del Login es incorrecto
 *
 */
public class LoginIncorrecto extends Exception{
	
	private String msg;
	
	/**
	 * 
	 *	Recibe un mensaje para imprimir por pantalla, el campo de Usuario y password. Borra lo que
	 *se encuentra adentro del campo password y cambia el color de las letras del campo User, para advertir
	 *que el Usuario es incorrecto.
	 *
	 *
	 *
	 */
	public LoginIncorrecto(String msg, JTextField user, JPasswordField password) {
		super(msg);
		this.msg = msg;
		user.setForeground(Color.RED);
		password.setText("");
	}
	
	/**
	 * Constructor para cuando el Usuario se encuentra en la base de datos, pero el password ingresado es el
	 * incorrecto.
	 * 
	 * 
	 */
	public LoginIncorrecto(String msg, JPasswordField password) {
		super(msg);
		this.msg = msg;
		password.setText("");
	}
	
	

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("Incorrecto " + msg);
	}
	
}
