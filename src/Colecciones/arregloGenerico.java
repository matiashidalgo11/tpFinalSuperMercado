package Colecciones;

import java.io.Serializable;
import java.util.ArrayList;

import Interfaces.IColeccion;

public class arregloGenerico<T> implements IColeccion<T>, Serializable {

	ArrayList<T> arreglo;
	
	public arregloGenerico() {
		arreglo = new ArrayList<T>();
	}
	
	

	@Override
	public boolean agregar(T dato) {
		
		return arreglo.add(dato);
	}

	@Override
	public boolean eliminar(T dato) {
		
		boolean resp = false;
		if(this.existencia(dato))
		{
			arreglo.remove(dato);
			resp = true;
		}
		
		return resp;
	}


	@Override
	public boolean existencia(T dato) {
		boolean resp = false;
		for(T aux : arreglo)
		{
			if(aux.equals(dato))
			{
				resp = true;
			}
		}
		
		return resp;
	}

	@Override
	public String listar() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("******Lista Arreglo******");
		if(arreglo.size() == 0)
		{
			builder.append("\n*VACIO*\n");
		}else
		{
			for(T aux : arreglo)
		{
			builder.append(aux);
		}
		}
		
		
		return builder.toString();
	}



	public ArrayList<T> getArreglo() {
		return arreglo;
	}



	public void setArreglo(ArrayList<T> arreglo) {
		this.arreglo = arreglo;
	}



	@Override
	public int cantidad() {
		
		return arreglo.size();
	}
	
	public void vaciar()
	{
		arreglo.clear();
	}

	
}
