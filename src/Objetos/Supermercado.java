package Objetos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Archivo.ArchivoGenerico;
import Colecciones.MapaUsuario;
import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Interfaces.idInterface;
import Productos.Producto;
import Colecciones.MapaCarro;
import Colecciones.MapaCategoria;
import Colecciones.MapaProductos;

public class Supermercado {

	private MapaUsuario listaUsuarios;
	private MapaCategoria listaCategorias;
	private MapaCarro listaCarritos;
	
	private ArchivoGenerico<Long, Usuario> archivoUsuario;
	private ArchivoGenerico<Long, Producto> archivoProducto;
	private ArchivoGenerico<Long, Carro> archivoCarro;
	//Hay que implementarles las interfaces Serializable y idPrincipal para poder persistirlos en un archivo;
	
	
	
	Session sesionActiva;
	
	public Supermercado()
	{
		inicializarArchivos();
		inicializarMapas();
		sesionActiva = null;
		cargarDatos();
		
		System.out.println(listaUsuarios.listar());
		System.out.println(listaCategorias.cantidad());
		System.out.println(listaCategorias.listar());
		//Hay que cargar los mapas despues de crear los archivos de Producto y Carro
		
	}
	
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
	
	public boolean inSession()
	{
		boolean resp = false;
		if(sesionActiva != null)
		{
			resp = true;
		}
		
		return resp;
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
				  this.guardarUnidad(user);
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
	
	public boolean agregarProducto(Producto producto)
	{
		return listaCategorias.agregarProducto(producto);
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
	 * La funcion cargara todos los mapas desde el archivo;(Los mapas deberian estar inicializados). La idea es utilizarla solo al principio del programa.
	 */
	public void cargarDatos()
	{
		if(listaUsuarios != null)
		{
			//this.listaUsuarios.vaciar(); limpiar el mapa si esta lleno pero puede borrar datos que no se guardaror
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
			mapaToListaProductos();
			Producto.generadorId = listaCategorias.getIdMasAlto() + 1;//Busca el id mas alto, para cuando se cree un nuevo Producto comience a partir del id Mas alto
			System.out.println("\n SE CARGO LISTAPRODUCTOS");
		}
		
	
		
		
	}
	
	/**
	 * La funcion guardara todos los mapas en su estado actual a sus archivos correspondientes. La idea es utilizarla al final del Programa
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
			archivoProducto.guardar(listaProductosToMap());
			System.out.println("\n SE GUARDO LISTAPRODUCTOS");
		}
	}
	
	/**
	 * Funcion que guarde dependiendo del dato una Unidad de Usuario, Producto o Carro. Es para que si el programa esta mucho tiempo abierto, se mantenga con el archivo lo mas actualizada posible sin tener que ir guardando y cargando todo de una
	 */
	private void guardarUnidad(Object dato)
	{
		if(dato instanceof Usuario)
		{
			Usuario aux = (Usuario)dato;
			//borrar
			System.out.println("\nEL USUARIO QUE SE GUARDA EN EL ARCHIVO ES : " + aux);
			archivoUsuario.guardarUnidad(aux);
			System.out.println("\n Se guardo exitosamente \n");
			
		}else if(dato instanceof Producto)
		{
			Producto aux = (Producto) dato;
			archivoProducto.guardarUnidad(aux);
			
		}else if (dato instanceof Carro)
		{
			Carro aux = (Carro) dato;
			archivoCarro.guardarUnidad(aux);
		}else
		{
			System.out.println("EL Dato no corresponde a un Archivo disponible");
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
	
	//Funcion deberia estar en MapaProductos, recibier por parametro la listaCategoria
	public MapaProductos listaProductosToMap()
	{
		MapaProductos productos = new MapaProductos();
		Iterator<Entry<Long, MapaProductos>> it = listaCategorias.getIterator(); //Obtengo el iterator del mapa de categorias cargado actualmente
		
		while(it.hasNext())
		{
			Entry<Long, MapaProductos> entrada = it.next();
			Iterator<Entry<Long, Producto>> it2 = entrada.getValue().getIterator(); //Obtengo cada Mapa de Productos de cada categoria
			
			while(it2.hasNext()) //Obtengo el iterator de cada Mapa de Productos
			{
				Entry<Long, Producto> entrada2 = it2.next();
				productos.agregar(entrada2.getKey(), entrada2.getValue()); //Guardando cada producto de todas las categorias en un unico Mapa de Productos
			}
		}
		
		return productos; //Retorno el Mapa con todos los Productos
	}
	
	
	public MapaCategoria mapaToListaProductos()
	{
		HashMap<Long, Producto> mapax = archivoProducto.cargar().getMapa(); //Obtengo el mapa con todos los productos del archivo
		Set<Entry<Long, Producto>> set = mapax.entrySet();
		Iterator<Entry<Long, Producto>> it = set.iterator(); //Obtengo el iterator del mapa
		
		MapaCategoria mapa = new MapaCategoria();
		
		while(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			Producto nuevo = entrada.getValue(); //Obtengo cada producto para tener su atributo de idCategoria.
			agregarProducto(entrada.getValue()); //Guardo cada producto en la categoria que le corresponde
		}
		
		return mapa;
	}
	
	
	


	
}
