package productos;

public class Perfumeria extends Producto {

	private String tipoFragancia;
	
	public Perfumeria() 
	{
		super();
		tipoFragancia = "";
	}

	public Perfumeria(String nombre, double precio, String marca, long stock,
			long idCategoria, String tipoFragancia) 
	{
		super(nombre, precio, marca, stock, idCategoria);
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
	
	
}
