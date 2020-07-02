package Productos;

import org.json.JSONObject;

public class Limpieza extends Producto{

	private String tipo;
	public static long ID_CATEGORIA_LIMPIEZA = 3;
	
	public Limpieza() 
	{
		super();
		tipo = "";
	}

	public Limpieza(String nombre, double precio, String marca, long stock, String tipo, boolean oferta, double precioOferta) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_LIMPIEZA, oferta, precioOferta);
		this.tipo = tipo;
	}

	/**
	 * Constructor para Clonar
	 * @param dato
	 */
	public Limpieza(Limpieza dato)
	{
		super(dato);
		this.tipo = dato.getTipo();
	}
	
	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	public Limpieza(String tipo) {
		super(ID_CATEGORIA_LIMPIEZA);
		this.tipo = tipo;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		Limpieza other = (Limpieza) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "Tipo: " + this.tipo + "\n";
	}
	
	@Override
	public String getNombreCategoria()
	{
		return "Limpieza";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put("Tipo", this.tipo);
		return objeto;
	}
}
