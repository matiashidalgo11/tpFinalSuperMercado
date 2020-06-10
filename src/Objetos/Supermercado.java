package Objetos;

import Colecciones.mapUsuario;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class Supermercado {

	private mapUsuario listaUsuarios;
	private MapaCategoria listaCategorias;
	private MapaProductos listaProductos;
	
	public Supermercado(Usuario user, Carro carrito)
	{
		listaUsuarios = new mapUsuario();
		listaCategorias = new MapaCategoria();
		listaProductos = new MapaProductos();
		
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
	
	public void agregarProducto(Producto nuevo, Long idCategoria)
	{
		listaProductos.agregar(nuevo.getIdProducto(), nuevo);
		listaCategorias.agregar(idCategoria, listaProductos);
	}
	
}
