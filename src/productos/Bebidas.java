package productos;

public class Bebidas extends Producto{

	private String nombre;
	private double precio;
	private String marca;
	private long stock;
	private long idCategoria;
	private boolean gasificada;
	private double litros;
	private String gusto;
	private boolean alcohol;
	
	public Bebidas() 
	{
		super();
		gasificada = false;
		gusto = "";
		alcohol = false;
	}
	
	public Bebidas(String nombre, double precio, String marca, long stock, long idCategoria, 
			boolean gasificada, double litros, String gusto, boolean alcohol) 
	{
		super(nombre, precio, marca, stock, idCategoria);
		this.gasificada = gasificada;
		this.litros = litros;
		this.gusto = gusto;
		this.alcohol = alcohol;
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

	public boolean isGasificada() {
		return gasificada;
	}

	public void setGasificada(boolean gasificada) {
		this.gasificada = gasificada;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public String getGusto() {
		return gusto;
	}

	public void setGusto(String gusto) {
		this.gusto = gusto;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
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
		Bebidas other = (Bebidas) obj;
		if (alcohol != other.alcohol)
			return false;
		if (gasificada != other.gasificada)
			return false;
		if (gusto == null) {
			if (other.gusto != null)
				return false;
		} else if (!gusto.equals(other.gusto))
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		if (Double.doubleToLongBits(litros) != Double
				.doubleToLongBits(other.litros))
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
		return super.toString() + "Gasificada: " + this.gasificada + "\n" +
								  "Litros: " + this.litros + "\n" +
								  "Gusto: " + this.gusto + "\n" +
								  "Alcohol: " + this.alcohol + "\n";
	}
	
}
