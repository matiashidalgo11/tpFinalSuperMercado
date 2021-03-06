package Objetos;

import Productos.Producto;
/**
 * Clase que une un Usuario con un Carro, dependiendo del dinero que tenga en la Cartera el Usuario podra comprar o no lo que se encuentra en el Carrito. 
 * 
 *
 */
public class Session {
	
	private Usuario user;
	private Carro carrito;
	
	
	/**
	 * Si existiera un carro ya guardado en el sistema con su misma id lo agregaria a la Session del usuario
	 * 
	 */
	public Session(Usuario user, Carro carrito) {
		
		this.user = user;
		this.carrito = carrito;
		
	}
	/**
	 * Crea una Session con un Usuario ya creado pero con un Carro Vacio
	 * @param user
	 */
	public Session(Usuario user)
	{
		this.user = user;
		this.carrito = new Carro(user.getId());
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
	
	/**
	 * Funcion Principal que tiene en cuenta el dinero en la Cartera del Usuario, y el monto total del Carrito, luego se resta el dinero de la cartera, y se agrega el detalle de compra al Usuario
	 * 
	 * @return si se hizo efectiva la compra (true) o no (false)
	 */
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Usuario en sesion: " + user.getUserName() + "\n" + 
				"Unidades en carro: " + carrito.cantidadProductos() + "\n";
	}
	
}
