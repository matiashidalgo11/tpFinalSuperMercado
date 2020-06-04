package Colecciones;

import java.util.ArrayList;

import Interfaces.IColeccion;

public class arregloGenerico<T> implements IColeccion<T> {

	ArrayList<T> arreglo;
	
	public arregloGenerico() {
		arreglo = new ArrayList<T>();
	}
	
	

	@Override
	public boolean agregar(T dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T buscar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existencia(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
