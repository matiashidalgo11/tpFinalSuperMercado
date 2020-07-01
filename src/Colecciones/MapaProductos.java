package Colecciones;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

import ColeccionesGenericas.MapaGenerico;
import Interfaces.IdMaximo;
import Productos.Producto;

public class MapaProductos extends MapaGenerico<Long, Producto> implements IdMaximo{

	public MapaProductos()
	{
		super();
	}
	
	public String getNombreProducto(int i)
	{
		Producto nuevo = buscar((long)i);
		return nuevo.getNombre();
	}
	
	public String getNombreCategoria()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		String nombre = null;
		
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			nombre = entrada.getValue().getNombreCategoria();
		}
		
		return nombre;
	}
	
	public Long getIdMasAlto()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		long id = 1;
		
		while(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			if(entrada.getValue().getId() > id)
			{
				id = entrada.getValue().getId();
			}
		}
		
		return id;
	}
	
	public Long getPrimerId()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		long id = 0;
		
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			if(entrada.getValue().getId() > id)
			{
				id = entrada.getValue().getId();
			}
		}
		
		return id;
	}
}
