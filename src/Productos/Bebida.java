package Productos;

import org.json.JSONObject;

public class Bebida extends Producto{

	private boolean gasificada;
	private double litros;
	private String gusto;
	private boolean alcohol;
	
	public static long ID_CATEGORIA_BEBIDAS = 7;
	
	//Referencia Json
	public static String CLAVE_GASIFICADA = "gasificada";
	public static String CLAVE_LITROS = "litros";
	public static String CLAVE_GUSTO = "gustoBebida";
	public static String CLAVE_ALCOHOL = "alcohol";
	
	public Bebida() 
	{
		super();
		gasificada = false;
		litros = 0;
		gusto = "";
		alcohol = false;
	}
	
	public Bebida(String nombre, double precio, String marca, long stock,boolean gasificada, double litros, String gusto, boolean alcohol, boolean oferta, double precioOferta) 
	{
		super(nombre, precio, marca, stock, ID_CATEGORIA_BEBIDAS, oferta, precioOferta);
		this.gasificada = gasificada;
		this.litros = litros;
		this.gusto = gusto;
		this.alcohol = alcohol;
	}
	
	/**
	 * Constructor para clonar
	 * @param b
	 */
	public Bebida(Bebida b)
	{
		super(b);
		this.gasificada = b.isGasificada();
		this.litros = b.getLitros();
		this.gusto = b.getGusto();
		this.alcohol = b.isAlcohol();
	}
	
	/**
	 * Constructor para Parte Grafica
	 * 
	 */
	public Bebida(boolean gasificada, double litros, String gusto, boolean alcohol) {
		super(ID_CATEGORIA_BEBIDAS);
		this.gasificada = gasificada;
		this.litros = litros;
		this.gusto = gusto;
		this.alcohol = alcohol;
	}
	
	
	/**
	 * 
	 * Constructor para Json
	 */
	public Bebida(JSONObject objeto)
	{
		super(objeto);
		
		if(objeto.has(CLAVE_GUSTO))
		{
			gasificada = objeto.getBoolean(CLAVE_GASIFICADA);
			litros = objeto.getDouble(CLAVE_LITROS);
			gusto = objeto.getString(CLAVE_GUSTO);
			alcohol = objeto.getBoolean(CLAVE_ALCOHOL);
		}
		
		
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
		Bebida other = (Bebida) obj;
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
	
	@Override
	public String getNombreCategoria()
	{
		return "Bebida";
	}
	
	public JSONObject toJson()
	{
		JSONObject objeto = super.toJson();
		objeto.put(CLAVE_GASIFICADA, this.gasificada);
		objeto.put(CLAVE_LITROS, this.litros);
		objeto.put(CLAVE_GUSTO, this.gusto);
		objeto.put(CLAVE_ALCOHOL, this.alcohol);
		return objeto;
	}
}
