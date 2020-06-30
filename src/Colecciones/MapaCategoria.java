package Colecciones;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Interfaces.IdMaximo;
import Productos.Producto;

public class MapaCategoria extends MapaGenerico<Long, MapaProductos> implements IdMaximo{
	
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
	
	public boolean eliminarProducto(Long idProducto)
	{
		boolean resp = false;
		Producto aux;
		MapaProductos localizacion;
		if(existeProducto(idProducto))
		{
			aux = buscarProducto(idProducto);
			localizacion = this.buscar(aux.getIdCategoria());
			resp = localizacion.eliminar(aux.getId());
			
		}
		
		return resp;
	}
	
	public boolean existeProducto(Long idProducto)
	{
		boolean resp = false;
		MapaProductos aux;
		Set<Entry<Long,MapaProductos>> set = this.getMapa().entrySet();
		Iterator<Entry<Long,MapaProductos>> it = set.iterator();
		while(it.hasNext() && resp == false)
		{
			Entry<Long,MapaProductos> entrada = it.next();
			aux = entrada.getValue();
			resp = aux.existencia(idProducto);
		}
		
		return resp;
	}
	
	public Producto buscarProducto(Long idProducto) throws NullPointerException
	{
		Producto resp = null;
		boolean corte = false;
		MapaProductos aux;
		if(existeProducto(idProducto))
		{
			
			Set<Entry<Long,MapaProductos>> set = this.getMapa().entrySet();
			Iterator<Entry<Long,MapaProductos>> it = set.iterator();
			while(it.hasNext() && corte == false)
			{
				Entry<Long,MapaProductos> entrada = it.next();
				aux = entrada.getValue();
				
				if(aux.existencia(idProducto))
				{
					resp = aux.buscar(idProducto);
					corte = true;
				}
				
			}
		}else
		{
			throw new NullPointerException();
		}
		
		return resp;
	}
	
	/*
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
	*/
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
	
	public String getNombreCategoria(Long idCategoria)
	{
		MapaProductos mapa = buscar(idCategoria);
		Iterator<Entry<Long, Producto>> it = mapa.getIterator();
		String nombre = "";
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			nombre = entrada.getValue().getNombreCategoria();
		}
		
		return nombre;
	}
	
	public MapaProductos getCategoriaPorNombre(String nombre)
	{
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		MapaProductos mapaRetorno = null;
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			if(nombre.equals(entrada.getValue().getNombreCategoria()))
			{
				mapaRetorno = entrada.getValue();
			}
		}
		
		return mapaRetorno;
	}
	
	public Long getIdMasAlto()
	{
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		long id = 1;
		
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			if(entrada.getValue().getIdMasAlto() > id)
			{
				id = entrada.getValue().getIdMasAlto();
			}
		}
		
		return id;
	}
}
