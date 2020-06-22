package productos;

import java.util.Iterator;
import java.util.Map.Entry;

import Colecciones.MapaGenerico;
import Interfaces.IdMaximo;

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
			if(entrada.getValue().getIdProducto() > id)
			{
				id = entrada.getValue().getIdProducto();
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
			if(entrada.getValue().getIdProducto() > id)
			{
				id = entrada.getValue().getIdProducto();
			}
		}
		
		return id;
	}
}
