package Excepciones;



import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginIncorrecto extends Exception{
	
	private String msg;
	
	/**
	 * idea: mostrar iconos al lado del txt que marque en que campo se equivoco
	 * @param msg
	 * @param user
	 * @param password
	 */
	public LoginIncorrecto(String msg, JTextField user, JPasswordField password) {
		super(msg);
		this.msg = msg;
		user.setForeground(Color.RED);
		password.setText("");
	}
	
	
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
