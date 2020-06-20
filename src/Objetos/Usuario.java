package Objetos;



import java.io.Serializable;

import Colecciones.ArregloGenerico;
import Interfaces.idInterface;

/**

 * @author Matias
 * @version 0.0.1
 * 
 * 
 */

	
public class Usuario implements idInterface<Long>, Serializable{
	
	/**
	 * Identificador unico para saber que es una Clase Usuario
	 */
	private static final long serialVersionUID = 1L;


	public static long generadorId = 0;
	
	
	private long id;
	private String userName;
	private String password;
	private double cartera;
	private ArregloGenerico<DetalleCompra> historialCompra;
	private String nombre;
	private String apellido;
	private int edad;
	private String telefono;

	
	
	public Usuario(String userName, String password, String nombre, String apellido, int edad, String telefono) {
		
		this.userName = userName;
		this.password = password;
		this.cartera = 0;
		this.id = generadorId + (long)1;
		historialCompra = new ArregloGenerico<DetalleCompra>();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
		
		this.generadorId ++;
	}
	


	/**
	 *	Constructor para clonar objeto.
	 * 
	 */
	public Usuario(String userName, String password, double cartera, long id, ArregloGenerico<DetalleCompra> historialCompra, String nombre, String apellido, int edad, String telefono) {
		
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
	
	
	public Usuario() {
		this.userName = "";
		this.password = "";
		this.cartera = 0;
		this.id = 0;
		this.historialCompra = null;
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.telefono = "";
	}
	

	@Override
	public int hashCode() {
		
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		
		if(!(obj instanceof Usuario))
		{
			return false;
		}else
		{
			Usuario aux = (Usuario) obj;
			if(aux.getUserName() == this.getUserName())
			{
			resp = true;
			}
		}
			
		return resp;
	}

	
	
	@Override
	public String toString() {
		
		return  "\n" +
				"idUsuario " + id + "\n" +
				"Nombre:   " + userName + "\n" +
				"Password: " + password + "\n" + 
				"Cartera:  " + cartera + "\n" +
				"Informacion Personal: " + this.nombre + " " + this.apellido + " " + this.edad +" " +this.telefono +"\n";
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
		return this.getId();
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



	public static long getGeneradorId() {
		return generadorId;
	}



	public static void setGeneradorId(long generadorId) {
		Usuario.generadorId = generadorId;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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



	public ArregloGenerico<DetalleCompra> getHistorialCompra() {
		return historialCompra;
	}



	public void setHistorialCompra(ArregloGenerico<DetalleCompra> historialCompra) {
		this.historialCompra = historialCompra;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
