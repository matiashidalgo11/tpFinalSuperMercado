package Excepciones;

public class SaldoInsuficiente extends Exception
{
	
	public SaldoInsuficiente()
	{
		super();
	}
	
	@Override
	public String getMessage()
	{
		return super.getMessage() + "\n ¡Saldo Insuficiente!";
	}

}
