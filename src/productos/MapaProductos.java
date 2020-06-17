package productos;

import java.util.Iterator;
import java.util.Map.Entry;

import Colecciones.mapaGenerico;

public class MapaProductos extends mapaGenerico<Long, Producto> {

	public MapaProductos()
	{
		super();
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
		long id = 0;
		
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
}
