package Productos;

import org.json.JSONObject;

public class Snack extends Producto {

	private double cantidadG;
	public static long ID_CATEGORIA_SNACK = 1;
	
	public static String CLAVE_CANTIDADG = "claveCantidadSnack";
	
	public Snack() 
	{
		super();
		cantidadG = 0;
	}

	public Snack(String nombre, double precio, String marca, long stock, double cantidadG, boolean oferta, double precioOferta) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_SNACK, oferta, precioOferta);
		this.cantidadG = cantidadG;
	}

	public Snack(Snack dato)
	{
		super(dato);
		this.cantidadG = dato.getCantidadG();
	}

	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	public Snack(double cantidadG) {
		super(ID_CATEGORIA_SNACK);
		this.cantidadG = cantidadG;
	}
	
	/**
	 * Constructor para Json
	 * 
	 */
	public Snack(JSONObject objeto)
	{
		super(objeto);
		if(objeto.has(CLAVE_CANTIDADG))
		{
			this.cantidadG = objeto.getDouble(CLAVE_CANTIDADG);
		}
	}

	public double getCantidadG() {
		return cantidadG;
	}

	public void setCantidadG(double cantidadG) {
		this.cantidadG = cantidadG;
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
		Snack other = (Snack) obj;
		if (Double.doubleToLongBits(cantidadG) != Double
				.doubleToLongBits(other.cantidadG))
			return false;
		return true;
	}

	@Override
	public String toString()
	{	
		return super.toString() + "Cantidad: " + this.cantidadG + "\n";
	}
	
	@Override
	public String getNombreCategoria()
	{
		return "Snack";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put("Gramos", this.cantidadG);
		return objeto;
	}
}
