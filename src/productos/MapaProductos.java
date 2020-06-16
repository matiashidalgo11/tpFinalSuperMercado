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
}
