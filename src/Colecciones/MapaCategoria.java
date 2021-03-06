package Colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import ColeccionesGenericas.MapaGenerico;
import Excepciones.ProductoYaExiste;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import Interfaces.IdMaximo;
import Productos.Bebida;
import Productos.Congelado;
import Productos.Golosina;
import Productos.Lacteo;
import Productos.Limpieza;
import Productos.Perfumeria;
import Productos.Producto;
import Productos.Snack;

public class MapaCategoria extends MapaGenerico<Long, MapaProductos> implements IdMaximo{
	
	public MapaCategoria() 
	{
		super();
	}
	
	/**
	 * Agrega una categoria al mapa de categorias.
	 * @param idCategoria
	 * @param mapaNuevo
	 */
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
	
	/**
	 * Agrega un producto al supermercado. En caso de que pertenezca a una categoria ya existente, la agrega a esa categoria. Caso contrario, crea la categoria y agrega el producto
	 * @param p
	 * @return
	 * @throws ProductoYaExiste
	 */
	public boolean agregarProducto(Producto p) throws ProductoYaExiste
	{
		MapaProductos aux;
		boolean resp = false;
		if(!existeProducto(p.getId()))
		{
			if(existencia(p.getIdCategoria()))
			{
				aux = buscar(p.getIdCategoria());
				
				if(!aux.compararProductos(p))
				{
					resp = aux.agregar(p.getId(), p);
				}
				else
				{
					throw new ProductoYaExiste();
				}
				
			}else
			{
				aux = new MapaProductos();
				aux.agregar(p.getId(), p);
				resp = super.agregar(p.getIdCategoria(), aux);
			}
			
	}
		
		
		return resp;
	}
	
	
	/**
	 * Elimina un producto del supermercado mediante la id de este.
	 * @param idProducto
	 * @return
	 */
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
	
	
	
	/**
	 * En caso de que el producto ya se encuentre dentro del supermercado, esta funcion retornara un true. Caso contrario, retornara un false.
	 * @param idProducto
	 * @return boolean
	 */
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
	
	/**
	 * Esta funcion busca un producto dentro del supermercado.
	 * @param idProducto
	 * @return Producto
	 * @throws NullPointerException
	 */
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
	
	/**
	 * Lista una categoria en especifico
	 * @param idCategoria
	 * @return String
	 */
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
	
	/**
	 * Obtiene el nombre de una categoria dependiendo de su id.
	 * @param idCategoria
	 * @return String
	 */
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
	
	/**
	 * Obtiene una categoria dependiente de su nombre.
	 * @param nombre
	 * @return MapaProductos
	 */
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
	
	
	 /**
	  * Obtiene el id mas alto
	  * @return Long
	  */
	public Long getIdMasAlto()
	{
		Iterator<Entry<Long, MapaProductos>> it = getIterator();
		long id = 1;
		
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			if(entrada.getKey() > id)
			{
				id = entrada.getKey();
			}
		}
		
		return id;
	}
	
	/**
	 * Obtengo la cantidad de productos que hay en el supermercado
	 * @return int
	 */
	public int cantidadProductos()
	{
		int cantidad = 0;
		Set<Entry<Long,MapaProductos>> set = super.getMapa().entrySet();
		Iterator<Entry<Long,MapaProductos>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long,MapaProductos> entrada = it.next();
			MapaProductos aux = entrada.getValue();
			cantidad += aux.cantidad();
		}
		
		
		return cantidad;
	}
	
	
	/**
	 * Metodo que crea un Mapa unico con todos los Productos
	 * @return MapaProductos con todos los Productos del MapaCategoria
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
			while(itP.hasNext())
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
	 * Establece una oferta al producto recibido por parametro
	 * @param producto
	 * @param precioOferta
	 */
	public void establecerOferta(Producto producto, double precioOferta)
	{
		Producto oferta = buscarProducto(producto.getId());
		oferta.setOferta(true);
		oferta.setPrecioOferta(precioOferta);
	}
	
	/**
	 * Elimina la oferta del producto recibido por parametro
	 * @param producto
	 */
	public void quitarOferta(Producto producto)
	{
		Producto oferta = buscarProducto(producto.getId());
		oferta.setOferta(false);
	}
	
	
	public boolean establecerOferta(long id, double precioOferta)
	{
		boolean resp = false;
		if(this.existeProducto(id))
		{
			Producto oferta = buscarProducto(id);
			oferta.setOferta(true);
			oferta.setPrecioOferta(precioOferta);
			resp = true;
		}
		return resp;
	}
	
	public boolean quitarOferta(long id)
	{
		boolean resp = false;
		if(this.existeProducto(id))
		{
			Producto oferta = buscarProducto(id);
			oferta.setOferta(false);
			resp = true;
		}
		return resp;
	}
	
	
	/**
	 * Funcion en la busca si existe una Marca en el MapaCategorias
	 * 
	 * @param marcaProducto el nombre de la Marca a buscar
	 * @return false si no existe, true si existe
	 */
	public boolean existeMarcar(String marcaProducto)
	{
		boolean resp =  false;
		Iterator<Entry<String, MapaProductos>> itCategorias = super.getIterator(); //Obtengo el iterator del mapa de categorias
		
		while(itCategorias.hasNext() && resp == false) 
		{
			Entry<String, MapaProductos> entradaCategoria = itCategorias.next();
			Iterator<Entry<String, Producto>> itProducto = entradaCategoria.getValue().getIterator(); //Obtengo el iterator de cada categoria
			
			while(itProducto.hasNext() && resp == false) //Recorro la categoria
			{
				Entry<String, Producto> entradaProducto = itProducto.next();
				Producto aux = entradaProducto.getValue(); //Obtengo cada producto de la categoria
				
				if(aux.getMarca().equals(marcaProducto)) //Si la marca del producto actual es igual a la que se busca
				{
					resp = true;
				}
			}
		}
		
		return resp;
	}
	
	
	public boolean marcaEnOferta(String marcaProducto)
	{
		boolean resp =  true;
		Iterator<Entry<String, MapaProductos>> itCategorias = super.getIterator(); //Obtengo el iterator del mapa de categorias

		while(itCategorias.hasNext() && resp == true) 
		{
			Entry<String, MapaProductos> entradaCategoria = itCategorias.next();
			Iterator<Entry<String, Producto>> itProducto = entradaCategoria.getValue().getIterator(); //Obtengo el iterator de cada categoria
			
			while(itProducto.hasNext() && resp == true) //Recorro la categoria
			{
				Entry<String, Producto> entradaProducto = itProducto.next();
				Producto aux = entradaProducto.getValue(); //Obtengo cada producto de la categoria
				
				if(aux.getMarca().equals(marcaProducto)) //Si la marca del producto actual es igual a la que se busca, se establece el precio de oferta
				{
					if(!(aux.isOferta()))
					{
						resp = false;
					}
				}
			}
		}
		
		return resp;
	}
	
	/**
	 * Establece una oferta a todos los productos de la marca recibida por parametro
	 * @param marcaProducto
	 * @return
	 */
	public void establecerOfertaPorMarca(String marca, int porcentaje)
	{
		Iterator<Entry<String, MapaProductos>> itCategorias = super.getIterator(); //Obtengo el iterator del mapa de categorias
		double porcentajeDouble = (double) porcentaje / 100;
		
		while(itCategorias.hasNext()) 
		{
			Entry<String, MapaProductos> entradaCategoria = itCategorias.next();
			Iterator<Entry<String, Producto>> itProducto = entradaCategoria.getValue().getIterator(); //Obtengo el iterator de cada categoria
			
			while(itProducto.hasNext()) //Recorro la categoria
			{
				Entry<String, Producto> entradaProducto = itProducto.next();
				Producto aux = entradaProducto.getValue(); //Obtengo cada producto de la categoria
				
				if(aux.getMarca().equals(marca)) //Si la marca del producto actual es igual a la que se busca, se establece el precio de oferta
				{
					aux.setOferta(true);
					double valorPrecioOferta = aux.getPrecio() - (aux.getPrecio() * porcentajeDouble);
					aux.setPrecioOferta(valorPrecioOferta); //Establezco 
				}
			}
		}
	}
	
	/**
	 * Elimina las ofertas a todos los productos de la marca recibida por parametro
	 * @param marcaProducto
	 * @return
	 */
	public void quitarOfertaPorMarca(String marca)
	{
		Iterator<Entry<String, MapaProductos>> itCategorias = super.getIterator(); //Obtengo el iterator del mapa de categorias
		
		while(itCategorias.hasNext()) 
		{
			Entry<String, MapaProductos> entradaCategoria = itCategorias.next();
			Iterator<Entry<String, Producto>> itProducto = entradaCategoria.getValue().getIterator(); //Obtengo el iterator de cada categoria
			
			while(itProducto.hasNext()) //Recorro la categoria
			{
				Entry<String, Producto> entradaProducto = itProducto.next();
				Producto aux = entradaProducto.getValue(); //Obtengo cada producto de la categoria
				
				if(aux.getMarca().equals(marca)) //Si la marca del producto actual es igual a la que se busca, se quita la oferta.
				{
					aux.setOferta(false); 
				}
			}
		}
	}
	
	
	/**
	 * Recibe un Mapa de Productos y lo carga por categoria
	 * @return
	 * @throws ProductoYaExiste 
	 */
	public static MapaCategoria mapaToListaProductos(HashMap<Long,Producto> mapaDelArchivo) throws ProductoYaExiste
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
	
	public JSONArray toJsonArray()
	{
		JSONArray arreglo = new JSONArray();
		MapaProductos productos = toMapaProductos();
		Iterator<Entry<String, Producto>> it = productos.getIterator();
		while(it.hasNext())
		{
			Entry<String, Producto> entrada = it.next();
			arreglo.put(entrada.getValue().toJson());
		}
		
		return arreglo;
	}
	
	
	public static Producto instanciarJson(JSONObject objeto)
	{
		Producto aux = null;
		try
		{
			
			if(objeto.has(Bebida.CLAVE_GUSTO))
			{
				aux = new Bebida(objeto);
			}else if(objeto.has(Congelado.CLAVE_PESO))
			{
				aux = new Congelado(objeto);
			}else if(objeto.has(Golosina.CLAVE_DESCRIPCION))
			{
				aux = new Golosina(objeto);
			}else if(objeto.has(Lacteo.CLAVE_TIPO))
			{
				aux = new Lacteo(objeto);
			}else if(objeto.has(Limpieza.CLAVE_TIPO))
			{
				aux = new Limpieza(objeto);
			}else if(objeto.has(Perfumeria.CLAVE_TIPOFRAGANCIA))
			{
				aux = new Perfumeria(objeto);
			}else if(objeto.has(Snack.CLAVE_CANTIDADG))
			{
				aux = new Snack(objeto);
			}else
			{
				throw new NullPointerException();
			}
			
		}catch(NullPointerException nu)
		{
			nu.printStackTrace();
		}
		
		
		return aux;
	}
	
}
