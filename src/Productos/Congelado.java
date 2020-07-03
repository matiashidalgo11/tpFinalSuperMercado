package Productos;

import org.json.JSONObject;

public class Congelado extends Producto{

	private double peso;
	
	public static long ID_CATEGORIA_CONGELADO = 6;
	
	public static String CLAVE_PESO = "pesoCongelado";
	
	public Congelado() {
		super();
		peso = 0;
	}

	public Congelado(String nombre, double precio, String marca, long stock, double peso, boolean oferta, double precioOferta) {
		super(nombre, precio, marca, stock, ID_CATEGORIA_CONGELADO, oferta, precioOferta);
		this.peso = peso;
	}
	
	/**
	 * Constructor para Clonar
	 * @param dato
	 */
	public Congelado(Congelado dato)
	{
		super(dato);
		this.peso = dato.getPeso();
	}
	
	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	public Congelado(double peso) {
		super(ID_CATEGORIA_CONGELADO);
		this.peso = peso;
	}

	/*
	 * Constructor Json
	 * 
	 */
	public Congelado(JSONObject objeto)
	{
		super(objeto);
		if(objeto.has(CLAVE_PESO))
		{
			this.peso = objeto.getDouble(CLAVE_PESO);
		}
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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
		Congelado other = (Congelado) obj;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "Peso: " + this.peso + "\n";
	}
	
	@Override
	public String getNombreCategoria()
	{
		return "Congelado";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put(CLAVE_PESO, this.peso);
		return objeto;
	}
}
