package Excepciones;

public class UsuarioExistente  extends Exception{

	private String userName;
	
	public UsuarioExistente(String userName) {
		super();
		this.userName = userName;
	}
	
	
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		System.out.println("El nombre de Usuario: "+ this.userName + " no se encuentra disponible \n" );
	}
}
