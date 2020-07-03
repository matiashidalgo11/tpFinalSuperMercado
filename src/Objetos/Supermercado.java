package Objetos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Set;

import Archivo.ArchivoGenerico;
import Colecciones.MapaUsuario;
import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Excepciones.ProductoYaExiste;
import Interfaces.idInterface;
import Productos.Producto;
import Colecciones.MapaCarro;
import Colecciones.MapaCategoria;
import Colecciones.MapaProductos;
/**
 * 
 * Clase Principal del Programa, contiene los atributos necesarios para Cargarse a si misma(Archivos, Json). La informacion la carga en las Listas instanciadas.
 *
 */
public class Supermercado {

	private MapaUsuario listaUsuarios;
	private MapaCategoria listaCategorias;
	private MapaCarro listaCarritos;
	
	private ArchivoGenerico<Long, Usuario> archivoUsuario;
	private ArchivoGenerico<Long, Producto> archivoProducto;
	private ArchivoGenerico<Long, Carro> archivoCarro;

	//Clave para Json
	public static String CLAVE_LISTAUSUARIOS = "listaUsuarios";
	public static String CLAVE_LISTACATEGORIAS = "listaCategorias";
	public static String CLAVE_LISTACARRITOS = "listaCarritos";
	
	
	private Session sesionActiva;
	
	public Supermercado()
	{
		inicializarArchivos();
		inicializarMapas();
		sesionActiva = null;
		cargarDatos();
		
		System.out.println(listaUsuarios.listar());
		System.out.println(listaCategorias.listar());
		System.out.println(listaCarritos.listar());
	
	}
	
	
	public Supermercado(JSONObject objeto)
	{
		inicializarMapas();
		if(objeto.has(CLAVE_LISTACARRITOS) && objeto.has(CLAVE_LISTACATEGORIAS) && objeto.has(CLAVE_LISTAUSUARIOS))
		{
			JSONArray arrayJUsuarios = objeto.getJSONArray(CLAVE_LISTAUSUARIOS);
			
			for(int i = 0; i < arrayJUsuarios.length(); i++)
			{
				Usuario aux = arrayJUsuarios.get(i); 
			}

			JSONArray arrayJCarro = objeto.getJSONArray(CLAVE_LISTACARRITOS);
			
			JSONArray arrayJProducto = objeto.getJSONArray(CLAVE_LISTACATEGORIAS);
			
		}
	}
	
	/**
	 * Metodo que inicializa sesionActiva, dependiendo si el id se encuentra en ListaUsuarios
	 * 
	 * @param id
	 * @return True si se Inicio el atributo sesionActivo, en caso contrario retorna False
	 */
	public boolean iniciarSession(long id)
	{
		Usuario user;
		Carro carrito;

		
		if (listaUsuarios.existencia(id)) {
			
			user = listaUsuarios.buscar(id);

			if (listaCarritos.existencia(id)) {
				
				carrito = listaCarritos.buscar(id);
				Carro.actualizarCarro(carrito, listaCategorias);
				sesionActiva = new Session(user, carrito);

			} else {
				
				sesionActiva = new Session(user);
				long clave = sesionActiva.getCarrito().getId();
				listaCarritos.agregar(clave, sesionActiva.getCarrito());
			}
			
		}
		
		
		return inSession();
	}
	
	/**
	 * Metodo que indica si inSession se encuentra "Activo"
	 * @return
	 */
	public boolean inSession()
	{
		boolean resp = false;
		if(sesionActiva != null)
		{
			resp = true;
		}
		
		return resp;
	}
	
	/*
	 * Si se esta en Sesion, pasa a null el atributo. Luego se guardan todos los datos;
	 * 
	 */
	public void cerrarSesion()
	{

		if(inSession())
		{	
			this.sesionActiva = null;
		}
		
		this.guardarDatos();
	}
	
	
	
	public void establecerOferta(Producto producto, double precioOferta)
	{
		listaCategorias.establecerOferta(producto, precioOferta);
		
	}
	
	public void establecerOfertaPorMarca(String marca, int porcentaje)
	{
		listaCategorias.establecerOfertaPorMarca(marca, porcentaje);
	}
	
	public void quitarOferta(Producto producto)
	{
		listaCategorias.quitarOferta(producto);
	}
	
	public void quitarOfertaPorMarca(String marca)
	{
		listaCategorias.quitarOfertaPorMarca(marca);
	}
	
	
	public boolean comprarProductos()
	{
		boolean resp = false;
		
		if(this.inSession() && !sesionActiva.getCarrito().isEmpty())
		{
			resp = sesionActiva.comprar();
			
		}
		
		return resp;
	}
	
	
	/**
	 * Agrega un Usuario al mapa y tambien lo agrega al Archivo
	 * 
	 * @param user
	 * @return
	 */
	public boolean agregarUsuario(Usuario user)
	{
		boolean resp = false;
		if(user != null)
		{
			 resp = listaUsuarios.agregarUsuario(user);
			 
			 if(resp == true)
			 {
				  archivoUsuario.guardarUnidad(user);
			 }	

		}
		return resp;
	}
	
	public void eliminarUsuario(Usuario user)
	{
		listaUsuarios.eliminar(user.getId());
	}
	
	public boolean existeUsuario(Usuario user)
	{
		return listaUsuarios.existencia(user.getId());
	}
	
	public boolean existeUsuario(String userName)
	{
		return listaUsuarios.existencia(userName);
	}
	
	public Usuario buscarUsuario(Usuario user)
	{
		return listaUsuarios.buscar(user.getId());
	}
	
	public Usuario buscarUsuario(String userName)
	{
		return listaUsuarios.buscar(userName);
	}
	
	public void vaciarListaUsuarios()
	{
		listaUsuarios.vaciar();
	}
	
	public int cantidadUsuarios()
	{
		return listaUsuarios.cantidad();
	}
	
	public String listarUsuarios()
	{
		return listaUsuarios.listar();
	}
	
	public boolean agregarProducto(Producto p) throws ProductoYaExiste
	{
		boolean resp = false;
		if(p != null)
		{
			resp = listaCategorias.agregarProducto(p);
		
		}
		
		return resp;
	}
	
	public void eliminarProducto(Long idProducto)
	{
		listaCategorias.eliminarProducto(idProducto);
	}
	
	public void existeProducto( Long idProducto)
	{
		listaCategorias.existeProducto(idProducto);
	}
	
	public Producto buscarProducto(Long idProducto)
	{
		return listaCategorias.buscarProducto(idProducto);
	}
	
	public void vaciarListaCategoria()
	{
		listaCategorias.vaciar();
	}
	
	public int cantidadCategorias()
	{
		return listaCategorias.cantidad();
	}
	
	public int cantidadProductos()
	{
		return listaCategorias.cantidadProductos();
	}
	
	public int getidCategoriaMasAlta()
	{
		long id = listaCategorias.getIdMasAlto();
		int idConvertida = (int) id;
		return idConvertida;
	}
	
	public String listarCategorias()
	{
		return listaCategorias.listar();
	}
	
	public String listarCategoriaEspecifica(Long idCategoria)
	{
		return listaCategorias.listarCategoriaProducto(idCategoria);
	}
	
	public Usuario getUsuarioEnSesion()
	{
		return sesionActiva.getUser();
	}
	
	public String getNombreCategoria(Long idCategoria)
	{
		return listaCategorias.getNombreCategoria(idCategoria);
	}
	
	public MapaProductos getCategoriaPorNombre(String nombre)
	{
		return listaCategorias.getCategoriaPorNombre(nombre);
	}

	public Session getSesionActiva() {
		return sesionActiva;
	}
	
	
	/**
	 * La funcion cargara todos los mapas desde el archivo;(Los mapas deberian estar inicializados). La idea es utilizarla solo al PRINCIPIO del programa.
	 */
	public void cargarDatos()
	{
		if(listaUsuarios != null)
		{

			listaUsuarios.setMapa(archivoUsuario.cargar().getMapa());
			System.out.println("\n EL ID MAS ALTO DE LISTAUSUARIOS ES: " + listaUsuarios.getIdMasAlto());
			Usuario.generadorId = listaUsuarios.getIdMasAlto();//Busca el id mas alto, para cuando se cree un nuevo Usuario comience a partir del id Mas alto
			System.out.println("\n SE CARGO LISTAUSUARIOS\n");
		}else
		{
			System.out.println("\nERROR LISTAUSUARIOS\n");
		}
		
		if(listaCarritos != null)
		{
			//this.listaCarritos.vaciar();
			listaCarritos.setMapa(archivoCarro.cargar().getMapa());
			
			System.out.println("\n SE CARGO LISTACARRITOS \n");
		}else
		{
			System.out.println("\nERROR LISTACARRITOS\n");
		}
		
		if(listaCategorias != null)
		{
			try
			{
				listaCategorias = MapaCategoria.mapaToListaProductos(archivoProducto.cargar().getMapa());
				Producto.generadorId = listaCategorias.getIdMasAlto() + 1;//Busca el id mas alto, para cuando se cree un nuevo Producto comience a partir del id Mas alto
				System.out.println("\n SE CARGO LISTAPRODUCTOS");
			}
			catch(ProductoYaExiste e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}
	
	/**
	 * La funcion guardara todos los mapas en su estado actual a sus archivos correspondientes. La idea es utilizarla al FINAL del Programa
	 */
	public void guardarDatos()
	{
		if(listaUsuarios != null)
		{
			archivoUsuario.guardar(listaUsuarios);
			System.out.println("\n SE GUARDO LISTAUSUARIOS\n");
		}else
		{
			System.out.println("\nERROR LISTAUSUARIOS\n");
		}
		
		if(listaCarritos != null)
		{
			listaCarritos.eliminarCarrosVacios();
			archivoCarro.guardar(listaCarritos);
			System.out.println("\n SE GUARDO LISTACARRITOS \n");
		}else
		{
			System.out.println("\nERROR LISTACARRITOS\n");
		}
		
		if(listaCategorias != null)
		{

			MapaGenerico<Long, Producto> aux = (MapaGenerico<Long, Producto>)listaCategorias.toMapaProductos();
			archivoProducto.guardar(aux);
			System.out.println("\n SE GUARDO LISTAPRODUCTOS");
		}
	}
	

	/**
	 * Funcion que inicializa todos los Archivos del Programa
	 */
	private void inicializarArchivos()
	{
		archivoUsuario = new ArchivoGenerico<Long, Usuario>("Usuario.dat");
		archivoProducto = new ArchivoGenerico<Long, Producto>("Producto.dat");
		archivoCarro = new ArchivoGenerico<Long, Carro>("Carro.dat");
		
	}
	
	/**
	 * Inicializa los mapas principales de la clase
	 */
	private void inicializarMapas()
	{
		listaUsuarios = new MapaUsuario();
		listaCategorias = new MapaCategoria();
		listaCarritos = new MapaCarro();
	}
	
	
	
	public MapaUsuario getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(MapaUsuario listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public MapaCategoria getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(MapaCategoria listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public MapaCarro getListaCarritos() {
		return listaCarritos;
	}

	public void setListaCarritos(MapaCarro listaCarritos) {
		this.listaCarritos = listaCarritos;
	}

	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put(CLAVE_LISTAUSUARIOS, listaUsuarios.toJsonArray());
		jsonObject.put(CLAVE_LISTACARRITOS, listaCarritos.toJsonArray());
		jsonObject.put(CLAVE_LISTACATEGORIAS, listaCategorias.toJsonArray());
			
		return jsonObject;
	}
	
	
	
	


	
}
