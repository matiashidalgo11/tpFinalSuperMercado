package productos;

import Colecciones.mapaGenerico;

public class MapaProductos {

	mapaGenerico<Long, Producto> mapa;
	
	public MapaProductos() 
	{
		mapa = new mapaGenerico<Long, Producto>();
	}
	
	public void agregar(Long idProducto, Producto productoNuevo) 
	{
		mapa.agregar(idProducto, productoNuevo);
	}
	
	public void eliminar(Long idProducto) 
	{	
		mapa.eliminar(idProducto);
	}
	
	public boolean existencia(Long idProducto) 
	{
		return mapa.existencia(idProducto);
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
