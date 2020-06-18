package Objetos;



import java.io.Serializable;

import Colecciones.ArregloGenerico;
import Interfaces.idInterface;

/**
 *Falta Implementar un Historial Compra
 * @author Matias
 * @version 0.0.1
 * 
 * 
 */

	
public class Usuario implements idInterface<Long>, Serializable{
	
	public static long generadorId = 1;
	
	
	private long id;
	private String userName;
	private String password;
	private double cartera;
	private ArregloGenerico<DetalleCompra> historialCompra;
	private String nombre;
	private String apellido;
	private int edad;
	private long telefono;

	
	
	public Usuario(String userName, String password, String nombre, String apellido, int edad, long telefono) {
		
		this.userName = userName;
		this.password = password;
		this.cartera = 0;
		this.id = generadorId++;
		historialCompra = new ArregloGenerico<DetalleCompra>();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
	}
	
	/**
	 *	Constructor para clonar objeto.
	 * 
	 */
	public Usuario(String userName, String password, double cartera, long id, ArregloGenerico<DetalleCompra> historialCompra, String nombre, String apellido, int edad, long telefono) {
		
		this.userName = userName;
		this.password = password;
		this.cartera = cartera;
		this.id = id;
		this.historialCompra = historialCompra;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
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
		if(aux.getUserName() == this.getUserName())
		{
			resp = true;
		}
			
		return resp;
	}

	private long getId() {
		return id;
	}
	
	private void setId(long id) {
		this.id = id;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String nombre) {
		this.userName = nombre;
	}
	
	private String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	public double getCartera() {
		return cartera;
	}
	
	public void setCartera(double cartera) {
		this.cartera = cartera;
	}
	
	public ArregloGenerico<DetalleCompra> getHistorialCompra() {
		return historialCompra;
	}

	public void setHistorialCompra(ArregloGenerico<DetalleCompra> historialCompra) {
		this.historialCompra = historialCompra;
	}
	
	@Override
	public String toString() {
		
		return  "\n" +
				"idUsuario " + id + "\n" +
				"Nombre:   " + userName + "\n" +
				"Password: " + password + "\n" + 
				"Cartera:  " + cartera + "\n" +
				"Informacion Personal: " + this.nombre + " " + this.apellido + " " + this.edad + "\n";
	}
	
	public void sumarCartera(double suma)
	{
		this.cartera = this.cartera + suma;
	}
	
	public void restarCartera(double resta)
	{
		if(resta <= this.cartera)
		{
			this.cartera = this.cartera- resta;
		}else
		{
			System.out.println("\nNo hay dinero suficiente\n");
		}
	}

	@Override
	public Long getIdPrincipal() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * Funcion para que solo se modifique el password sabiendo el actual, solo se ingresa el password en el constructor
	 * 
	 * @param actual password actual ingresado por interface
	 * @param nuevo password nuevo ingresado por interface
	 * @return si se cambio correctamente
	 */
	public boolean cambiarPassword(String actual, String nuevo)
	{
		boolean resp = false;
		if(actual.equals(getPassword()))
		{
			setPassword(nuevo);
			resp = true;
		}
		
		return resp;
	}

}
