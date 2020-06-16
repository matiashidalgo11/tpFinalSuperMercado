package productos;

public class Limpieza extends Producto{

	private String tipo;
	
	public Limpieza() 
	{
		super();
		tipo = "";
	}

	public Limpieza(String nombre, double precio, String marca, long stock,
			long idCategoria, String tipo) 
	{
		super(nombre, precio, marca, stock, idCategoria);
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
}
