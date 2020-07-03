package Interfaces;

/**
 * 
 * Interface generica que contiene comportamientos basicos para las Colecciones
 *
 * 
 */
public interface IColeccion<T> {
	
	public boolean agregar(T dato);
	public boolean eliminar(T dato);
	public boolean existencia(T dato);
	public String listar();
	public int cantidad();

}
