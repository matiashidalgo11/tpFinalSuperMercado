package Excepciones;

import java.io.PrintStream;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CamposVacios extends Exception {

	String msg;
	JTextField userName;
	JPasswordField password;
	/**
	 * Ideas: HACER Visible iconos de que campo se encuentra vacio;
	 * @param msg
	 * @param userName
	 * @param password
	 */
	public CamposVacios(String msg, JTextField userName, JPasswordField password) {
		super(msg);
		this.msg = msg;
		this.userName = userName;
		this.password = password;
		llenarCampos();
		
		
	}
	
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("Campos Vacios: " + msg);
	}
	
	public void llenarCampos()
	{
		if(userName.getText().length() == 0 && password.getText().length() == 0)
		{
			userName.setText("Campo Vacio");
		}
		
	}
	
	
	
}
