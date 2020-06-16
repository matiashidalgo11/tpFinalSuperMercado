package Objetos;



import java.io.Serializable;

import Colecciones.arregloGenerico;
import Interfaces.idInterface;

/**
 *Falta Implementar un Historial Compra
 * @author Matias
 * @version 0.0.1
 * 
 * 
 */

	
public class Usuario implements idInterface<Long>, Serializable{
	
	private static long generadorId = 1;
	
	
	private long id;
	private String nombre;
	private String password;
	private double cartera;
	private arregloGenerico<DetalleCompra> historialCompra;

	
	
	public Usuario(String nombre, String password) {
		
		this.nombre = nombre;
		this.password = password;
		this.cartera = 0;
		this.id = generadorId++;
		historialCompra = new arregloGenerico<DetalleCompra>();
	}
	
	public Usuario(String nombre, String password, double cartera, long id, arregloGenerico<DetalleCompra> historialCompra) {
		
		this.nombre = nombre;
		this.password = password;
		this.cartera = cartera;
		this.id = id;
		this.historialCompra = historialCompra;
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
	
	public arregloGenerico<DetalleCompra> getHistorialCompra() {
		return historialCompra;
	}

	public void setHistorialCompra(arregloGenerico<DetalleCompra> historialCompra) {
		this.historialCompra = historialCompra;
	}
	
	@Override
	public String toString() {
		
		return  "\n" +
				"idUsuario " + id + "\n" +
				"Nombre:   " + nombre + "\n" +
				"Password: " + password + "\n" + 
				"Cartera:  " + cartera + "\n" ;
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
		return id;
	}

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
