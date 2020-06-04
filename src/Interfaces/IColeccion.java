package Interfaces;

public interface IColeccion<T> {
	
	public boolean agregar(T dato);
	public boolean eliminar(long id);
	public T buscar(long id);
	public boolean existencia(long id);
	public String listar();

}
