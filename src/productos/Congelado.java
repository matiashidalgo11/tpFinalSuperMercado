package productos;

public class Congelado extends Producto{

	private double peso;
	
	public Congelado() {
		super();
		peso = 0;
	}

	public Congelado(String nombre, double precio, String marca, long stock,
			long idCategoria, double peso) {
		super(nombre, precio, marca, stock, idCategoria);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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
		Congelado other = (Congelado) obj;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "Peso: " + this.peso + "\n";
	}
	
}
