package productos;

public class Snack extends Producto {

	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private long idCategoria; 
	private double cantidadG;
	
	public Snack() 
	{
		super();
		cantidadG = 0;
	}

	public Snack(String nombre, double precio, String marca, long stock,
			long idCategoria, double cantidadG) 
	{
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.cantidadG = cantidadG;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
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
		if (idCategoria != other.idCategoria)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double
				.doubleToLongBits(other.precio))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{	
		return super.toString() + "Cantidad: " + this.cantidadG + "\n";
	}
	
}
