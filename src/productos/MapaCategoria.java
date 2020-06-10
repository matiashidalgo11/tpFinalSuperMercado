package productos;

import java.util.Iterator;
import java.util.Map.Entry;

import Colecciones.mapaGenerico;

public class MapaCategoria {

	mapaGenerico<Long, MapaProductos> mapa;
	
	public MapaCategoria() 
	{
		mapa = new mapaGenerico<Long, MapaProductos>();
	}
	
	public void agregar(Long idCategoria, MapaProductos mapaNuevo )
	{
		if(existencia(idCategoria))
		{
			MapaProductos nuevo = mapa.obtenerDato(idCategoria);
			Iterator<Entry<Long, Producto>> it = nuevo.getIterator();
			while(it.hasNext())
			{
				Entry<Long, Producto> entrada = it.next();
				nuevo.agregar(entrada.getKey(), entrada.getValue());
			}
		} else {
			
			mapa.agregar(idCategoria, mapaNuevo);
		}
	}
	
	public void eliminar(Long idCategoria)
	{
		mapa.eliminar(idCategoria);
	}
	
	public boolean existencia(Long idCategoria)
	{
		return mapa.existencia(idCategoria);
	}
	
	public int cantidad()
	{
		return mapa.cantidad();
	}
	
	public String listar()
	{
		return mapa.listar();
	}
	
	public MapaProductos buscar(Long idCategoria)
	{
		return mapa.buscar(idCategoria);
	}
	
	public Iterator getIterator()
	{
		return mapa.getIterator();
	}
}
