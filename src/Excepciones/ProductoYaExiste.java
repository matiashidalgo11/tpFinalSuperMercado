package Excepciones;

public class ProductoYaExiste extends Exception
{

	public ProductoYaExiste()
	{
		super();
	}
	
	@Override
	public String getMessage()
	{
		return super.getMessage() + "\n El producto que ha intentado ingresar ya existe.";
	}
}
