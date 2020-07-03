package Excepciones;

/**
 * 
 * Excepcion lanzada cuando el UserName ya se encuentra en uso, se utilizaria en los registros de Usuario
 *
 */
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
