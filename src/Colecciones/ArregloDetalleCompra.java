package Colecciones;

import org.json.JSONArray;

import ColeccionesGenericas.ArregloGenerico;
import Objetos.DetalleCompra;

public class ArregloDetalleCompra extends ArregloGenerico<DetalleCompra> {

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
