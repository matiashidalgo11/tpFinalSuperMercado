package Objetos;

/**
 *Falta Implementar un Historial Compra
 * @author Matias
 * @version 0.0.1
 * 
 * 
 */

	
public class Usuario {
	
	private static long generadorId = 0;
	
	
	private long id;
	private String nombre;
	private String password;
	private double cartera;
	

	
	
	public Usuario(String nombre, String password) {
		
		this.nombre = nombre;
		this.password = password;
		this.cartera = 0;
		this.id = generadorId++;
	}
	
	@Override
	public int hashCode() {
		
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		
		if(!(obj instanceof Usuario))
		{
			return false;
		}
		
		Usuario aux = (Usuario) obj;
		if(aux.getNombre() == this.getNombre())
		{
			resp = true;
		}
			
		return resp;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getCartera() {
		return cartera;
	}
	public void setCartera(double cartera) {
		this.cartera = cartera;
	}
	
	@Override
	public String toString() {
		
		return  "\n" +
				"idUsuario " + id + "\n" +
				"Nombre:   " + nombre + "\n" +
				"Password: " + password + "\n" + 
				"Cartera:  " + cartera + "\n" ;
	}
	

}
