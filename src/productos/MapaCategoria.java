package productos;

import java.util.Iterator;
import java.util.Map.Entry;

import Colecciones.mapaGenerico;

public class MapaCategoria extends mapaGenerico<Long, MapaProductos>{
	
	public MapaCategoria() 
	{
		super();
	}
	
	public void agregarCategoria(Long idCategoria, MapaProductos mapaNuevo )
	{
		if(existencia(idCategoria))
		{
			MapaProductos nuevo = new MapaProductos();
			try {
				nuevo = buscar(idCategoria);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
			
			Iterator<Entry<Long, Producto>> it = mapaNuevo.getIterator();
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
		return super.existencia(idCategoria);
	}
	
	public void eliminarProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = new MapaProductos();
		
		try{
			nuevo = buscar(idCategoria);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		nuevo.eliminar(idProducto);
		
	}
	
	public boolean existeProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = new MapaProductos(); 
		
		try{
			nuevo = buscar(idCategoria);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return nuevo.existencia(idProducto);
	}
	
	public Producto buscarProducto(Long idCategoria, Long idProducto)
	{
		MapaProductos nuevo = new MapaProductos(); 
		Producto producto = new Producto();
		
		try{
			nuevo = buscar(idCategoria);
			producto = nuevo.buscar(idProducto);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return producto;
	}
	
	public String listarCategorias()
	{
		StringBuilder builder = new StringBuilder();
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			builder.append(entrada.getValue().listar() + "\n");
		}
		
		return builder.toString();
	}
	
	public String listarCategoriaProducto(Long idCategoria)
	{
		MapaProductos nuevo = new MapaProductos(); 
		
		try{
			nuevo = buscar(idCategoria);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return nuevo.listar();
	}
}
