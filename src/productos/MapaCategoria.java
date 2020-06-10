package productos;

import Colecciones.mapaGenerico;

public class MapaCategoria {

	mapaGenerico<Long, MapaProductos> mapa;
	
	public MapaCategoria() 
	{
		mapa = new mapaGenerico<Long, MapaProductos>();
	}
	
	public void agregar(Long idCategoria, MapaProductos mapaNuevo )
	{
		mapa.agregar(idCategoria, mapaNuevo);
	}
	
	public void eliminar(Long idCategoria)
	{
		mapa.eliminar(idCategoria);
	}
	
	public boolean existencia(Long idCategoria)
	{
		return mapa.existencia(idCategoria);
	}
	
	public int cantidad()
	{
		return mapa.cantidad();
	}
	
	public String listar()
	{
		return mapa.listar();
	}
}
