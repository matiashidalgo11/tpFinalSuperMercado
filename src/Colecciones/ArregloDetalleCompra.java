package Colecciones;

import org.json.JSONArray;

import ColeccionesGenericas.ArregloGenerico;
import Objetos.DetalleCompra;

/**
 * Clase que hereda de ArregloGenerico pero con el Dato Principal DetalleCompra establecido
 * 
 *
 */
public class ArregloDetalleCompra extends ArregloGenerico<DetalleCompra> {

	/**
	 * Convierte todo el contenido del Arreglo DetalleCompra a un JsonArray
	 * 
	 */
	public JSONArray toJsonArray()
	{
		JSONArray jsonArray = new JSONArray();
		
		for(DetalleCompra aux : this.getArreglo())
		{
			jsonArray.put(aux.toJson());
		}
		
				
		return jsonArray;		
	}
	
}
