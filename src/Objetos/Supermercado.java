package Objetos;

import Archivo.ArchivoGenerico;
import Colecciones.arregloGenerico;
import Colecciones.mapUsuario;
import Colecciones.mapaGenerico;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class Supermercado {

	private mapUsuario listaUsuarios;
	private MapaCategoria listaCategorias;
	private mapaGenerico<Long, Carro> listaCarritos;
	
	private ArchivoGenerico<Long, Usuario> archivoUsuario;
	private ArchivoGenerico<Long, Producto> archivoProducto;
	private ArchivoGenerico<Long, Carro> archivoCarro;
	//Hay que implementarles las interfaces Serializable y idPrincipal para poder persistirlos en un archivo;
	
	
	
	Session sesionActiva;
	
	public Supermercado()
	{
		inicializarMapas();
		inicializarArchivos();
		sesionActiva = null;
		cargarDatos();
		
		System.out.println(listaUsuarios.listar());
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
				actualizarCarro(carrito);
				sesionActiva = new Session(user, carrito);

			} else {
				sesionActiva = new Session(user);
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
	 * Recibe el carro actual del usuario que esta en session y luego lo actualiza acorde a la cantidad de Stock y de productos se encuentran en la ListaCategorias
	 * @param carrito 
	 * podria retornar la cantidad de productos que se quitaron
	 */
	private void actualizarCarro(Carro carrito)
	{
		
		Producto productoListado;
		arregloGenerico<Long> idDeEliminados = new arregloGenerico<Long>();
		
		//Recorre todos los productos del carrito
		for (Producto productoCarrito : carrito.getArreglo().getArreglo()) {
			
		//Verifica si existe el Producto que se encuentra en el carrito dentro de la Lista Principal de Productos, si no es el caso lo elimina. En cambio si es el caso verifica que el stock este sincronizado con la cantidad De Stock disponible
			if (listaCategorias.existeProducto(productoCarrito.getIdCategoria(), productoCarrito.getIdProducto())) {
				
				productoListado = listaCategorias.buscarProducto(productoCarrito.getIdCategoria(), productoCarrito.getIdProducto());
				int stockNube = igualacion((int) productoListado.getStock(), (int) productoCarrito.getStock());
				if (stockNube < 0 && productoListado.getStock() > 0) {
					
					productoCarrito.restarStock(stockNube * -1);

				}

			} else {
				
				System.out.println(productoCarrito.getIdProducto());
				idDeEliminados.agregar(productoCarrito.getIdProducto());

			}

					
		}
		
		for(Long id : idDeEliminados.getArreglo())
		{
			carrito.quitar(id);
		}
		
		


	}
	
	/**
	 * Compara un numero con otro
	 * @param modelo es el principal
	 * @param imitador es el numero que va a querer copiar al modelo
	 * @return  Si es 0 es que son iguales.
	 *  	    Si el numero es mayor a 0 son los numeros que le faltan al Imitador para copiar a Modelo.
	 *  	    Si es menor que 0 son los numeros que se le tienen que restar a Imitador para igualar a Modelo.
	 * 	 */
	private int igualacion(int modelo, int imitador)
	{
		int cantidad = 0;
		
		if(modelo > imitador)
		{
			while(imitador + cantidad != modelo)
			{
				cantidad++;
			}
		}else if(modelo < imitador)
		{
			
			while(imitador - cantidad != modelo)
			{
				cantidad++;
			}
			
			cantidad = cantidad * -1;
		}
		
		
		return cantidad;
	}

	
	public void agregarUsuario(Usuario user)
	{
		listaUsuarios.agregar(user.getId(), user);
	}
	
	public void eliminarUsuario(Usuario user)
	{
		listaUsuarios.eliminar(user.getId());
	}
	
	public boolean existeUsuario(Usuario user)
	{
		return listaUsuarios.existencia(user.getId());
	}
	
	public Usuario buscarUsuario(Usuario user)
	{
		return listaUsuarios.buscar(user.getId());
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
	
	public void agregarProducto(Long idCategoria, Producto producto)
	{
		MapaProductos nuevoMapa = new MapaProductos();
		nuevoMapa.agregar(producto.getIdProducto(), producto);
		listaCategorias.agregarCategoria(idCategoria, nuevoMapa);
	}
	
	public void eliminarProducto(Long idCategoria, Long idProducto)
	{
		listaCategorias.eliminarProducto(idCategoria, idProducto);
	}
	
	public void existeProducto(Long idCategoria, Long idProducto)
	{
		listaCategorias.existeProducto(idCategoria, idProducto);
	}
	
	public Producto buscarProducto(Long idCategoria, Long idProducto)
	{
		return listaCategorias.buscarProducto(idCategoria, idProducto);
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
		return listaCategorias.listarCategorias();
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
	 * La funcion cargara todos los mapas desde el archivo;(Los mapas deberian estar inicializados)
	 */
	public void cargarDatos()
	{
		if(listaUsuarios != null)
		{
			listaUsuarios.setMapa(archivoUsuario.cargar().getMapa());
			System.out.println("\n SE CARGO LISTAUSUARIOS\n");
		}else
		{
			System.out.println("\nERROR LISTAUSUARIOS\n");
		}
		
		if(listaCarritos != null)
		{
			listaCarritos.setMapa(archivoCarro.cargar().getMapa());
			System.out.println("\n SE CARGO LISTACARRITOS \n");
		}else
		{
			System.out.println("\nERROR LISTACARRITOS\n");
		}
		
		
		//arregloGenerico<Producto> arregloProducto = archivoProducto.returnArregloGenerico();
		//FALTA UNA FUNCION PARA PASAR TODOS LOS PRODUCTOS DEL ARREGLO AL MAPA
		
		
	}
	
	/**
	 * La funcion guardara todos los mapas en su estado actual a sus archivos correspondientes;
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
			archivoCarro.guardar(listaCarritos);
			System.out.println("\n SE GUARDO LISTACARRITOS \n");
		}else
		{
			System.out.println("\nERROR LISTACARRITOS\n");
		}
	}
	
	/**
	 * Funcion que inicializa todos los Archivos del Programa
	 */
	public void inicializarArchivos()
	{
		archivoUsuario = new ArchivoGenerico<Long, Usuario>("Usuario.dat");
		archivoProducto = new ArchivoGenerico<Long, Producto>("Producto.dat");
		archivoCarro = new ArchivoGenerico<Long, Carro>("Carro.dat");
		
	}
	
	/**
	 * Inicializa los mapas principales de la clase
	 */
	public void inicializarMapas()
	{
		listaUsuarios = new mapUsuario();
		listaCategorias = new MapaCategoria();
		listaCarritos = new mapaGenerico<Long, Carro>();
	}
	
}
