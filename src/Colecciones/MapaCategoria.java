package Colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import ColeccionesGenericas.MapaGenerico;

import java.util.Set;

import Interfaces.IdMaximo;
import Productos.Producto;

public class MapaCategoria extends MapaGenerico<Long, MapaProductos> implements IdMaximo{
	
	public MapaCategoria() 
	{
		super();
	}
	
	public void agregarCategoria(Long idCategoria, MapaProductos mapaNuevo )
	{
		if(existencia(idCategoria))
		{
			MapaProductos nuevo = new MapaProductos();
			try {
				nuevo = buscar(idCategoria);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
			
			Iterator<Entry<Long, Producto>> it = mapaNuevo.getIterator();
			while(it.hasNext())
			{
				Entry<Long, Producto> entrada = it.next();
				nuevo.agregar(entrada.getKey(), entrada.getValue());
			}
		} else {
			
			agregar(idCategoria, mapaNuevo);
		}
	}
	
	public boolean agregarProducto(Producto p)
	{
		MapaProductos aux;
		boolean resp = false;
		if(!existeProducto(p.getId()))
		{
			if(existencia(p.getIdCategoria()))
			{
				aux = buscar(p.getIdCategoria());
				resp = aux.agregar(p.getId(), p);
			}else
			{
				aux = new MapaProductos();
				aux.agregar(p.getId(), p);
				resp = super.agregar(p.getIdCategoria(), aux);
			}
		}
		
		
		return resp;
	}
	
	public boolean eliminarProducto(Long idProducto)
	{
		boolean resp = false;
		Producto aux;
		MapaProductos localizacion;
		if(existeProducto(idProducto))
		{
			aux = buscarProducto(idProducto);
			localizacion = this.buscar(aux.getIdCategoria());
			resp = localizacion.eliminar(aux.getId());
			
		}
		
		return resp;
	}
	
	public boolean existeProducto(Long idProducto)
	{
		boolean resp = false;
		MapaProductos aux;
		Set<Entry<Long,MapaProductos>> set = this.getMapa().entrySet();
		Iterator<Entry<Long,MapaProductos>> it = set.iterator();
		while(it.hasNext() && resp == false)
		{
			Entry<Long,MapaProductos> entrada = it.next();
			aux = entrada.getValue();
			resp = aux.existencia(idProducto);
		}
		
		return resp;
	}
	
	public Producto buscarProducto(Long idProducto) throws NullPointerException
	{
		Producto resp = null;
		boolean corte = false;
		MapaProductos aux;
		if(existeProducto(idProducto))
		{
			
			Set<Entry<Long,MapaProductos>> set = this.getMapa().entrySet();
			Iterator<Entry<Long,MapaProductos>> it = set.iterator();
			while(it.hasNext() && corte == false)
			{
				Entry<Long,MapaProductos> entrada = it.next();
				aux = entrada.getValue();
				
				if(aux.existencia(idProducto))
				{
					resp = aux.buscar(idProducto);
					corte = true;
				}
				
			}
		}else
		{
			throw new NullPointerException();
		}
		
		return resp;
	}
	
	
	public String listar()
	{
		StringBuilder builder = new StringBuilder();
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			builder.append(entrada.getValue().listar() + "\n");
		}
		
		return builder.toString();
	}
	
	public String listarCategoriaProducto(Long idCategoria)
	{
		MapaProductos nuevo = new MapaProductos(); 
		
		try{
			nuevo = buscar(idCategoria);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		return nuevo.listar();
	}
	
	public String getNombreCategoria(Long idCategoria)
	{
		MapaProductos mapa = buscar(idCategoria);
		Iterator<Entry<Long, Producto>> it = mapa.getIterator();
		String nombre = "";
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			nombre = entrada.getValue().getNombreCategoria();
		}
		
		return nombre;
	}
	
	public MapaProductos getCategoriaPorNombre(String nombre)
	{
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		MapaProductos mapaRetorno = null;
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			if(nombre.equals(entrada.getValue().getNombreCategoria()))
			{
				mapaRetorno = entrada.getValue();
			}
		}
		
		return mapaRetorno;
	}
	
	public Long getIdMasAlto()
	{
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		long id = 1;
		
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			if(entrada.getValue().getIdMasAlto() > id)
			{
				id = entrada.getValue().getIdMasAlto();
			}
		}
		
		return id;
	}
	
	/**
	 * Metodo que crea un Mapa unico con todos los Productos
	 * @return
	 */
	public MapaProductos toMapaProductos()
	{
		MapaProductos resp = new MapaProductos();
		MapaProductos aux ;
		Set<Entry<Long,MapaProductos>> set = super.getMapa().entrySet();
		Iterator<Entry<Long,MapaProductos>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long,MapaProductos> entrada = it.next();
			aux = entrada.getValue();
			
			Set<Entry<Long,Producto>> setP = aux.getMapa().entrySet();
			Iterator<Entry<Long,Producto>> itP = setP.iterator();
			while(it.hasNext())
			{
				Entry<Long,Producto> entradaP = itP.next();
				Producto dato = entradaP.getValue();
				System.out.println(dato);
				resp.agregar(dato.getId(), dato);
				
			}
			
		}
		
		return resp;
	}
	/**
	 * Recibe un Mapa de Productos y lo carga por categoria
	 * @return
	 */
	public static MapaCategoria mapaToListaProductos(HashMap<Long,Producto> mapaDelArchivo)
	{
		MapaCategoria resp = new MapaCategoria();
		//HashMap<Long, Producto> mapax = archivoProducto.cargar().getMapa(); //Obtengo el mapa con todos los productos del archivo
		Set<Entry<Long, Producto>> set = mapaDelArchivo.entrySet();
		Iterator<Entry<Long, Producto>> it = set.iterator(); //Obtengo el iterator del mapa
		
		while(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			Producto nuevo = entrada.getValue(); //Obtengo cada producto para tener su atributo de idCategoria.
			resp.agregarProducto(nuevo); //Guardo cada producto en la categoria que le corresponde
		}
		
		return resp;
	}
}
