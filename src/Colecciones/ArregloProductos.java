package Colecciones;

import java.util.ArrayList;

import org.json.JSONArray;

import ColeccionesGenericas.ArregloGenerico;
import Productos.*;


/**
 * 
 * 
 * Clase en la cual contiene un arreglo de productos, donde si se quiere agregar el mismo Producto solo va a sumar el Stock;
 */
public class ArregloProductos extends ArregloGenerico<Producto> {


	public ArregloProductos() {
		super();
	}
	
	/**
	 * Funcion que Recibe un Producto, si el Producto existe solo Suma el stock +1, si no existe EL PRODUCTO SE CLONA y se cambia el stock a 1;
	 */
	@Override
	public boolean agregar(Producto dato) {
		Producto aux;
		boolean resp = false;
		
		if(this.existencia(dato.getId()))
		{
			aux = this.buscar(dato.getId());
			aux.sumarStock(1);
			
		}else
		{
			aux = clonarProductoCategoria(dato);
			aux.setStock(1);
			resp = arreglo.add(aux);
		}
		
		return resp;
	}
	
	
	public boolean eliminar(long id)
	{
		boolean resp = false;
		
		if(this.existencia(id))
		{
			Producto  aux = this.buscar(id);
			super.eliminar(aux);
			resp = true;
		}
		
		
		return resp;
	}
	
	public boolean existencia(long id)
	{
		boolean resp = false;
	
		for(Producto aux : super.getArreglo())
		{
			if(aux.getId() == id)
			{
				resp = true;
			}
		}
		
		return resp;
	}
	
	public Producto buscar(long id) throws NullPointerException
	{
		Producto resp = null;
		
		for(Producto aux : arreglo)
		{
			if(aux.getId() == id)
			{
				resp = aux;
			}
		}
		
		if(resp == null)
		{
			throw new NullPointerException();
		}
		
		return resp;
	}
	
	/**
	 * Metodo que recorrer todo el Arreglo de Productos y acumula el precioActual (Varia si esta en oferta o no el Precio)
	 * @return La suma total del Arreglo
	 */
	public double sumaTotal()
	{
		double resp = 0;
		
		for(Producto aux : super.getArreglo())
		{
			resp += aux.getPrecioActual();
		}
		
		return resp;
	}

	/**
	 * Metodo para clonar un Producto dependiendo de la Categoria, y asi poder pasar uno nuevo al Arreglo del Carrito
	 * 
	 * @param dato
	 * @return
	 */
	private static  Producto clonarProductoCategoria(Producto dato)
	{
		Producto resp = null;
		
		if(dato instanceof Bebida)
		{
			Bebida aux =(Bebida) dato;
			resp = new Bebida(aux);
		}else if(dato instanceof Congelado)
		{
			Congelado aux = (Congelado) dato;
			resp = new Congelado(aux);
		}else if(dato instanceof Golosina)
		{
			Golosina aux = (Golosina) dato;
			resp = new Golosina(aux);
			
		}else if(dato instanceof Lacteo)
		{
			Lacteo aux = (Lacteo) dato;
			resp = new Lacteo(aux);
			
		}else if(dato instanceof Limpieza)
		{
			Limpieza aux = (Limpieza) dato;
			resp = new Limpieza(aux);
			
		}else if(dato instanceof Perfumeria)
		{
			Perfumeria aux = (Perfumeria) dato;
			resp = new Perfumeria(aux);
			
		}else if(dato instanceof Snack)
		{
			Snack aux = (Snack) dato;
			resp = new Snack(aux);
		}
		
		return resp;
	}
	
	public JSONArray toJsonArray()
	{
		JSONArray jsonArray = new JSONArray();
		
		for(Producto aux : this.getArreglo())
		{
			jsonArray.put(aux.toJson());
		}
		
		
		return jsonArray;
	}
	
	public Producto getProductoPorNombre(String nombre) 
	{
		ArrayList<Producto> arreglo = getArreglo();
		Producto retorno = null;
		
		for(Producto aux : arreglo)
		{
			if(aux.getNombre().equals(nombre))
			{
				retorno = aux;
			}
		}
		
		return retorno;
	}
 }
