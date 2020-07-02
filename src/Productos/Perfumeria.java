package Productos;

import org.json.JSONObject;

public class Perfumeria extends Producto {

	private String tipoFragancia;
	public static long ID_CATEGORIA_PERFUMERIA = 2;
	
	public Perfumeria() 
	{
		super();
		tipoFragancia = "";
	}

	public Perfumeria(String nombre, double precio, String marca, long stock, String tipoFragancia, boolean oferta, double precioOferta) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_PERFUMERIA, oferta, precioOferta);
		this.tipoFragancia = tipoFragancia;
	}

	public Perfumeria(Perfumeria dato)
	{
		super(dato);
		this.tipoFragancia = dato.tipoFragancia;
	}
	
	/**
	 * Constructor para Parte Grafica
	 *
	 */
	public Perfumeria(String tipoFragancia) {
		super(ID_CATEGORIA_PERFUMERIA);
		this.tipoFragancia = tipoFragancia;
	}

	public String getTipoFragancia() {
		return tipoFragancia;
	}

	public void setTipoFragancia(String tipoFragancia) {
		this.tipoFragancia = tipoFragancia;
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
		Perfumeria other = (Perfumeria) obj;
		if (tipoFragancia == null) {
			if (other.tipoFragancia != null)
				return false;
		} else if (!tipoFragancia.equals(other.tipoFragancia))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "Tipo de fragancia: " + this.tipoFragancia + "\n";
	}
	
	@Override
	public String getNombreCategoria()
	{
		return "Perfumeria";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put("Tipo Fragancia", this.tipoFragancia);
		return objeto;
	}
}
