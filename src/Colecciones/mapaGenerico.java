package Colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Interfaces.IColeccion;

public abstract class mapaGenerico<K,T> implements IColeccion<T> {

	private HashMap<K, T> mapa;
	
	public mapaGenerico() {
		mapa = new HashMap<K,T>();
	}
	
	public HashMap<K, T> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<K, T> mapa) {
		this.mapa = mapa;
	}

	public String listar()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n*****Contenido*****\n");
		Set<Entry<K,T>> set = mapa.entrySet();
		Iterator<Entry<K,T>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<K,T> entrada = it.next();
			T aux = entrada.getValue();
			builder.append(aux);
		}
		
		return builder.toString();
		
	}
	
	public int cantidad()
	{
		return mapa.size();
	}
	
	

}
