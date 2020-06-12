package productos;

import java.util.Iterator;
import java.util.Map.Entry;

import Colecciones.mapaGenerico;

public class MapaCategoria extends mapaGenerico<Long, MapaProductos>{

//	mapaGenerico<Long, MapaProductos> mapa;
	
	public MapaCategoria() 
	{
		super();
	}
	
	public void agregarCategoria(Long idCategoria, MapaProductos mapaNuevo )
	{
		if(existencia(idCategoria))
		{
			MapaProductos nuevo = buscar(idCategoria);
			Iterator<Entry<Long, Producto>> it = nuevo.getIterator();
			while(it.hasNext())
			{
				Entry<Long, Producto> entrada = it.next();
				nuevo.agregar(entrada.getKey(), entrada.getValue());
			}
		} else {
			
			agregar(idCategoria, mapaNuevo);
		}
	}
	
	public boolean existencia(Long idCategoria)
	{
		return existencia(idCategoria);
	}
	
	public void eliminarProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = buscar(idCategoria);
		nuevo.eliminar(idProducto);
		
	}
	
	public boolean existeProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = buscar(idCategoria);
		return nuevo.existencia(idProducto);
	}
	
	public Producto buscarProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = buscar(idCategoria);
		return nuevo.buscar(idProducto);
	}
	
	public String listarCategoriaProducto(Long idCategoria)
	{
		MapaProductos nuevo = buscar(idCategoria);
		return nuevo.listar();
	}
}
