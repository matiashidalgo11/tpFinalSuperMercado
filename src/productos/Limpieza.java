package productos;

public class Limpieza {

	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private long idCategoria;
	private String tipo;
	
	public Limpieza() 
	{
		super();
		tipo = "";
	}

	public Limpieza(String nombre, double precio, String marca, long stock,
			long idCategoria, String tipo) 
	{
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.tipo = tipo;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Limpieza other = (Limpieza) obj;
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
	
}