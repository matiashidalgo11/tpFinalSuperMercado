package Interfaces;

public interface IColeccion<T> {
	
	public boolean agregar(T dato);
	public boolean eliminar(T dato);
	public boolean existencia(T dato);
	public String listar();

}
