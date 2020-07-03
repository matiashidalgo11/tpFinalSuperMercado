package Productos;

import org.json.JSONObject;

public class Golosina extends Producto{

	private int cantidad;
	private String descripcion;
	
	public static long ID_CATEGORIA_GOLOSINA = 5;
	
	public static String CLAVE_CANTIDAD = "cantidad";
	public static String CLAVE_DESCRIPCION = "descripcionGolosina";
	
	public Golosina() 
	{
		super();
		cantidad = 0;
	}

	public Golosina(String nombre, double precio, String marca, long stock, int cantidad, boolean oferta, double precioOferta, String descripcion) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_GOLOSINA, oferta, precioOferta);
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	/**
	 * Constructor para Clonar
	 * @param dato
	 */
	public Golosina(Golosina dato)
	{
		super(dato);
		this.cantidad = dato.getCantidad();
	}
	
	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	
	public Golosina(int cantidad, String descripcion) {
		super(ID_CATEGORIA_GOLOSINA);
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	/**
	 * Constructor para Json
	 * 
	 */
	public Golosina(JSONObject objeto)
	{
		super(objeto);
		if(objeto.has(CLAVE_DESCRIPCION))
		{
			this.cantidad = objeto.getInt(CLAVE_CANTIDAD);
			this.descripcion = objeto.getString(CLAVE_DESCRIPCION);
		}
				
		
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Golosina other = (Golosina) obj;
		if (cantidad != other.cantidad)
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "Cantidad: " + this.cantidad + "\n";
	}
	
	@Override
	public String getNombreCategoria()
	{
		return "Golosina";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put(CLAVE_CANTIDAD, this.cantidad);
		objeto.put(CLAVE_DESCRIPCION, this.descripcion);
		return objeto;
	}
}
