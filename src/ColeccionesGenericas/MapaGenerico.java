package ColeccionesGenericas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Interfaces.IColeccion;

public  class MapaGenerico<K,T>  {

	private HashMap<K, T> mapa;
	
	public MapaGenerico() {
		mapa = new HashMap<K,T>();
	}
	
	public HashMap<K, T> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<K, T> mapa) {
		this.mapa = mapa;
	}

	public String listar() {
		StringBuilder builder = new StringBuilder();

		builder.append("\n*****Contenido*****\n");
		
		if (mapa.size() == 0) {
			builder.append("\n       VACIO\n");
		} else {
			Set<Entry<K, T>> set = mapa.entrySet();
			Iterator<Entry<K, T>> it = set.iterator();
			while (it.hasNext()) {
				Entry<K, T> entrada = it.next();
				T aux = entrada.getValue();
				builder.append(aux);
			}
		}

		return builder.toString();
		
	}
	
	public int cantidad()
	{
		return mapa.size();
	}
	
	public boolean agregar(K clave, T dato)
	{
		boolean resp = false;
		
		if(!existencia(clave))
		{
			mapa.put(clave, dato);
			resp = true;
		}
		
		return resp;
	}
	
	public boolean eliminar(K clave)
	{
		boolean resp = false;
		
		if(existencia(clave))
		{
			mapa.remove(clave);
			resp = true;
		}
		
		return resp;
	}
	
	public boolean existencia(K clave)
	{
		return mapa.containsKey(clave);
	}
	
	public T buscar(K clave) throws NullPointerException
	{
		T resp = mapa.get(clave);
		
		if(resp == null)
		{
			throw new NullPointerException();
		}
		
		return resp;
	}

	public void vaciar()
	{
		mapa.clear();
	}
	
	public Iterator getIterator()
	{
		Set<Entry<K,T>> set = mapa.entrySet();
		Iterator<Entry<K,T>> it = set.iterator();
		return it;
	}
}
