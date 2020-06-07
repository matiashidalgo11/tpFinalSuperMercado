package Objetos;

public  class Producto {
	
	public static long conteoGeneral = 0;
	
	private long idProducto;
	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private long idCategoria;
	
	
	
	
	public Producto(String nombre, double precio, String marca, long stock, long idCategoria) {
		
		this.idProducto = conteoGeneral++;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.idCategoria = idCategoria;
	}
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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
	public String toString() {
		return  "IdProducto: " + idProducto + "\n" + 
				"Nombre:     " + nombre + "\n" + 
				"Precio:     " + precio + "\n" + 
				"Marca:      " + marca + "\n" + 
				"Stock:      " + stock + "\n"
				;
	}
	
	
	

}
