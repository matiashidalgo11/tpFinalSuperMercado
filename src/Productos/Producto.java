package Productos;

import java.io.Serializable;

import org.json.JSONObject;

import Interfaces.JsonFunciones;
import Interfaces.idInterface;

public abstract class Producto implements Serializable, idInterface<Long>, JsonFunciones{
	
	/**
	 * 
	 */


	public static long generadorId = 0;
	
	private long id;
	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private boolean oferta;
	private double precioOferta;
	private long idCategoria;	
	
	public static String CLAVE_NOMBRE = "Nombre";
	public static String CLAVE_PRECIO = "Precio";
	public static String CLAVE_MARCA = "Marca";
	public static String CLAVE_STOCK = "Stock";
	public static String CLAVE_OFERTA = "Oferta";
	public static String CLAVE_PRECIOOFERTA = "Precio Oferta";
	public static String CLAVE_ID = "Id Producto";
	public static String CLAVE_IDCATEGORIA = "ID Categoria";
	

	public Producto() 
	{
		id = 0;
		nombre = "";
		precio = 0;
		marca = "";
		stock = 0;
		idCategoria = 0;
		oferta = false;
		precioOferta = 0;
	}
	
	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	public Producto(long idCategoria) 
	{
		id = generadorId++;
		nombre = "";
		precio = 0;
		marca = "";
		stock = 0;
		this.idCategoria = idCategoria;
		oferta = false;
		precioOferta = 0;
		

	}
	
	/**
	 * 
	 * Constructor con Json
	 */
	public Producto(JSONObject objeto)
	{
		if(objeto.has(CLAVE_ID))
		{
			id = objeto.getLong(CLAVE_ID);
			nombre = objeto.getString(CLAVE_NOMBRE);
			precio = objeto.getDouble(CLAVE_PRECIO);
			marca = objeto.getString(CLAVE_MARCA);
			stock = objeto.getLong(CLAVE_STOCK);
			idCategoria = objeto.getLong(CLAVE_IDCATEGORIA);
			oferta = objeto.getBoolean(CLAVE_OFERTA);
			precioOferta = objeto.getDouble(CLAVE_PRECIOOFERTA);
		}
		
	}
	
	public Producto(String nombre, double precio, String marca, long stock, long idCategoria, boolean oferta, double precioOferta) 
	{	
		this.id = generadorId++;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.oferta = oferta;
		this.precioOferta = precioOferta;
	}
	
	public Producto(Producto aux)
	{
		this.id = aux.id;
		this.nombre = aux.nombre;
		this.precio = aux.precio;
		this.marca = aux.marca;
		this.stock = aux.stock;
		this.idCategoria = aux.idCategoria;
		this.oferta = aux.oferta;
		this.precioOferta = aux.precioOferta;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public long getStock() {
		return stock;
	}
	
	public void setStock(long stock) {
		this.stock = stock;
	}
	
	public long getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public boolean isOferta() {
		return oferta;
	}
	
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	
	public double getPrecioOferta() {
		return precioOferta;
	}
	
	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}

	@Override
	public String toString() 
	{
		String sinOferta = "\nIdProducto: " + id + "\n" + 
				"Nombre:     " + nombre + "\n" + 
				"Precio:     $" + precio + "\n" + 
				"Marca:      " + marca + "\n" + 
				"Stock:      " + stock + "\n"
				;
		String conOferta = "\nIdProducto: " + id + "\n" + 
				"Nombre:     " + nombre + "\n" + 
				"PRECIO EN OFERTA!!! " + "\n" +
				"Antes:     $" + precio + "\n" + 
				"Ahora:     $" + precioOferta + "\n" + 
				"Marca:      " + marca + "\n" + 
				"Stock:      " + stock + "\n"
				;
				
		if(this.oferta)
		{
			return conOferta;
		}
		else
		{
			return sinOferta;
		}
	}	
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	/**
	 * 
	 * @param cant es la cantidad de Stock que se va a sumar al total
	 * @return la cantidad de Stock luego de la operacion
	 */
	public long sumarStock(long cant)
	{
		this.stock += cant;
		
		return this.getStock();
	}
	
	/**
	 * 
	 * @param cant es la cantidad de stock que se va a restar al total
	 * @return la cantidad de Stock luego de la operacion
	 */
	public long restarStock(long cant)
	{
		if(this.stock >= cant)
		{
			this.stock = this.stock - cant;
		}else
		{
			System.out.println("\nNo hay suficiente Stock\n");
		}
		
		return this.getStock();
	}
	
	public String getNombreCategoria()
	{
		return "Producto";
	}
	
	/**
	 * La funcion se fija si el producto esta en oferta y en base a la respuesta devuelve el precioOferta o el Precio normal
	 * 
	 * @return devuelve el Precio que tiene actualmente para el Comprador
	 */
	public double getPrecioActual() {
	
		double precioActual ;
	
		if(this.isOferta())
		{
			precioActual = this.getPrecioOferta();
		}else
		{
			precioActual = this.getPrecio();
		}
		
		return precioActual;
	}
	
	public void invertirActivo()
	{
		if(this.oferta == true)
		{
			this.oferta = false;
		}else
		{
			this.oferta = true;
		}
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = new JSONObject();
		objeto.put(CLAVE_NOMBRE, this.nombre);
		objeto.put(CLAVE_PRECIO, this.precio);
		objeto.put(CLAVE_MARCA, this.marca);
		objeto.put(CLAVE_STOCK, this.stock);
		objeto.put(CLAVE_OFERTA, this.oferta);
		objeto.put(CLAVE_PRECIOOFERTA, this.precioOferta);
		objeto.put(CLAVE_ID, this.id);
		objeto.put(CLAVE_IDCATEGORIA, this.idCategoria);
		return objeto;
	}
	
	
}
