package Colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Interfaces.IdMaximo;

import java.util.Set;

import org.json.JSONArray;

import Objetos.Carro;
import Objetos.Usuario;
import Productos.Producto;

/**
 * 
 * Mapa de Carros, donde hereda de MapaGenerico con los datos definidos como Clave Long y Dato principal Carro, ademas extiende de la Interface IdMaximo, para encontrar el mayor Id
 *
 */
public class MapaCarro extends MapaGenerico<Long, Carro> implements IdMaximo {

	
	public MapaCarro() {
		super();
	}
	
	/**
	 * Recorrer el Mapa y si encuentra un Carro que no tiene ningun Producto adentro, lo agrega a un arreglo para luego de recorrer el Mapa Eliminarlo...
	 * 
	 * @return La cantidad de Carros que se Borraron
	 */
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
	
	public JSONArray toJsonArray()
	{
		//elimino los carros vacios
		eliminarCarrosVacios();
		JSONArray jsonArray = new JSONArray();
		
		Set<Entry<Long,Carro>> set = this.getMapa().entrySet();
		Iterator<Entry<Long,Carro>> it = set.iterator();
		
		while(it.hasNext())
		{
			Entry<Long,Carro> entrada = it.next();
			Carro aux = entrada.getValue();
			jsonArray.put(aux.toJson());
			
		}
		
		
		return jsonArray;
	}
	
	
}
