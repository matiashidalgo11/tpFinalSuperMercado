package Objetos;

import Colecciones.mapUsuario;
import Colecciones.mapaGenerico;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class Supermercado {

	private mapUsuario listaUsuarios;
	private MapaCategoria listaCategorias;
	private mapaGenerico<Long, Carro> listaCarritos;
	
	Session sesionActiva;
	
	public Supermercado(Usuario user, Carro carrito)
	{
		listaUsuarios = new mapUsuario();
		listaCategorias = new MapaCategoria();
		
		
	}
	
	public void iniciarSession(long id)
	{
		
		Usuario user = listaUsuarios.buscar(id);
		Carro carrito;
		
		if(listaCarritos.existencia(id))
		{
			carrito = listaCarritos.buscar(id);
			//implementar funcion para que actualice los datos del carrito con los del stock del producto
			sesionActiva = new Session(user, carrito);
			
		}else
		{
			sesionActiva = new Session(user);
		}
		
		
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
	
	//Problema para ver como saber si hay suficiente stock para comprar.
	public boolean comprarProductos()
	{
		boolean resp = false;
		if(this.inSession() && !sesionActiva.getCarrito().isEmpty())
		{
			resp = sesionActiva.comprar();
			
		}
		
		
		return resp;
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
	
	public void agregarProducto(Long idCategoria, MapaProductos nuevoMapa)
	{
		listaCategorias.agregar(idCategoria, nuevoMapa);
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
	
	public String listarCategoria()
	{
		return listaCategorias.listar();
	}
	
	public String listarCategoriaEspecifica(Long idCategoria)
	{
		return listaCategorias.listarCategoriaProducto(idCategoria);
	}
	
}
