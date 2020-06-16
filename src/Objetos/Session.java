package Objetos;

import productos.Producto;

public class Session {
	
	private Usuario user;
	private Carro carrito;
	
	/**
	 * Desarrollar esta clase, guardar o no el carro una vez que se cierre sesion y tenga productos adentro del carro
	 * 
	 */
	
	public Session(Usuario user, Carro carrito) {
		
		this.user = user;
		this.carrito = carrito;
		
	}
	
	public Session(Usuario user)
	{
		this.user = user;
		this.carrito = new Carro();
	}
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Carro getCarrito() {
		return carrito;
	}
	public void setCarrito(Carro carrito) {
		this.carrito = carrito;
	}
	
	
	public boolean comprar() 
	{
			
		boolean resp = false;
		double montoCarrito = carrito.sumaTotalCarro();
		double dineroDisponible = user.getCartera();
		
		if(montoCarrito <= dineroDisponible)
		{
			DetalleCompra detalle = carrito.generarDetllaCompra();
			user.restarCartera(montoCarrito);
			user.getHistorialCompra().agregar(detalle);
			resp = true;
		}
		
		return resp;
	}
	
	public boolean agregarAlCarro(Producto p)
	{
		return carrito.agregar(p);
	}
	
	public boolean quitarDelCarro(long id)
	{
		return carrito.quitar(id);
	}
	
	public void cargarCartera(double carga)
	{
		user.sumarCartera(carga);
	}

	public boolean modificarPassword(String actual, String nuevo)
	{
		return user.cambiarPassword(actual, nuevo);
	}
	
	public boolean modificarNombre(String actual, String nuevo)
	{
		boolean resp = false;
		if(actual.equals(user.getNombre()))
		{
			user.setNombre(nuevo);
			resp = true;
		}
		
		return resp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Usuario en sesion: " + user.getNombre() + "\n" + 
				"Unidades en carro: " + carrito.cantidadProductos() + "\n";
	}
	
}
