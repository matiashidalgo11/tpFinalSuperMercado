package productos;

public class Golosina extends Producto{

	private int cantidad;
	
	public Golosina() 
	{
		super();
		cantidad = 0;
	}

	public Golosina(String nombre, double precio, String marca, long stock,
			long idCategoria, int cantidad) 
	{
		super(nombre, precio, marca, stock, idCategoria);
		this.cantidad = cantidad;
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
	
}
