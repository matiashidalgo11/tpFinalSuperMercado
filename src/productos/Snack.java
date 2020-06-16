package productos;

public class Snack extends Producto {

	private double cantidadG;
	
	public Snack() 
	{
		super();
		cantidadG = 0;
	}

	public Snack(String nombre, double precio, String marca, long stock,
			long idCategoria, double cantidadG) 
	{
		super(nombre, precio, marca, stock, idCategoria);
		this.cantidadG = cantidadG;
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
}
