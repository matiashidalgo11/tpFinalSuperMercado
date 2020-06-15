package productos;

public  class Producto {
	
	public static long conteoGeneral = 1;
	
	private long idProducto;
	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private long idCategoria;	
	
	public Producto() 
	{
		idProducto = 0;
		nombre = "";
		precio = 0;
		marca = "";
		stock = 0;
		idCategoria = 0;
	}
	
	public Producto(String nombre, double precio, String marca, long stock, long idCategoria) 
	{	
		this.idProducto = conteoGeneral++;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.idCategoria = idCategoria;
	}
	
	public Producto(Producto aux)
	{
		this.idProducto = aux.idProducto;
		this.nombre = aux.nombre;
		this.precio = aux.precio;
		this.marca = aux.marca;
		this.stock = aux.stock;
		this.idCategoria = aux.idCategoria;
		
	}
	
	public long getIdProducto() {
		return idProducto;
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

	@Override
	public String toString() 
	{
		return  "\nIdProducto: " + idProducto + "\n" + 
				"Nombre:     " + nombre + "\n" + 
				"Precio:     " + precio + "\n" + 
				"Marca:      " + marca + "\n" + 
				"Stock:      " + stock + "\n"
				;
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
		Producto other = (Producto) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (idProducto != other.idProducto)
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
	
	/**
	 * 
	 * @param cant es la cantidad de Stock que se va a sumar al total
	 * @return la cantidad de Stock luego de la operacion
	 */
	public long sumarStock(long cant)
	{
		this.stock += cant;
		
		return this.getStock();
	}
	
	/**
	 * 
	 * @param cant es la cantidad de stock que se va a restar al total
	 * @return la cantidad de Stock luego de la operacion
	 */
	public long restarStock(long cant)
	{
		if(this.stock >= cant)
		{
			this.stock = this.stock - cant;
		}else
		{
			System.out.println("\nNo hay suficiente Stock\n");
		}
		
		return this.getStock();
	}
	
	

}
