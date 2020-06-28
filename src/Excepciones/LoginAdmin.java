package Excepciones;

public class LoginAdmin extends Exception {
	
	public LoginAdmin() {
		super();
	}
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("\nSe ha iniciado modo Administrador\n");
	}

}
