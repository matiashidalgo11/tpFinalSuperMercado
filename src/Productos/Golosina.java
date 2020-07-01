package Productos;

import org.json.JSONObject;

public class Golosina extends Producto{

	private int cantidad;
	public static long ID_CATEGORIA_GOLOSINA = 5;
	
	public Golosina() 
	{
		super();
		cantidad = 0;
	}

	public Golosina(String nombre, double precio, String marca, long stock, int cantidad, boolean oferta, double precioOferta) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_GOLOSINA, oferta, precioOferta);
		this.cantidad = cantidad;
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
		objeto.put("Cantidad", this.cantidad);
		return objeto;
	}
}
