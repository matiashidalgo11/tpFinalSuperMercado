package productos;

public class Bebidas extends Producto{

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
		if (!super.equals(obj))
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
		if (Double.doubleToLongBits(litros) != Double
				.doubleToLongBits(other.litros))
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
