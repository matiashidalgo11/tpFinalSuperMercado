package Colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Interfaces.IdMaximo;

import java.util.Set;

import Objetos.Carro;
import Objetos.Usuario;
import Productos.Producto;

public class MapaCarro extends MapaGenerico<Long, Carro> implements IdMaximo {

	
	public MapaCarro() {
		super();
	}
	
	public int eliminarCarrosVacios()
	{
		int cant = 0;
		HashMap<Long, Carro> hm = super.getMapa();
		Set<Entry<Long, Carro>> set = hm.entrySet();
		Iterator<Entry<Long, Carro>> it = set.iterator();
		ArregloGenerico<Long> listaIdEliminar = new ArregloGenerico<Long>();
		while(it.hasNext())
		{
			Entry<Long, Carro> entrada = it.next();
			Carro aux = entrada.getValue();
			if(aux.cantidadProductos() == 0)
			{
				listaIdEliminar.agregar(aux.getId());
			}
			
		}
		
		for(long id : listaIdEliminar.getArreglo())
		{
			super.eliminar(id);
			cant++;
		}
		
		
		return cant;
	}

	@Override
	public Long getIdMasAlto() {
		
		long id = 0;
		
		Set<Entry<Long, Carro>> set = super.getMapa().entrySet();
		Iterator<Entry<Long, Carro>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long, Carro> entrada = it.next();
			long aux = entrada.getKey();
			if(aux > id)
			{
				id = aux;
			}
			
		}
		
		return id;

	}
	
	
}
