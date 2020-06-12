package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Colecciones.ArregloProductos;
import Colecciones.mapUsuario;
import Colecciones.mapaGenerico;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Usuario;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class testeoAlan {

	public static void main(String[] args) {
		
		Usuario mati = new Usuario("Matias", "1234");
		Usuario alan = new Usuario("Alan", "1234");
		
		System.out.println(mati);
		System.out.println(alan);
		
		Producto a = new Producto("PAPAS", 12, "lAYS", 2, 1);
		Producto b = new Producto("COCA", 11, "COCA COLA", 5, 2);
		
		Carro carrito = new Carro();
		carrito.agregar(a);
		carrito.agregar(b);
		
		long clave = 1;
		long clave2 = 2;
		
		Session sessionMati = new Session(mati, carrito);
		System.out.println(sessionMati);
		sessionMati.modificarNombre("Matias", "Pepe");
		sessionMati.cargarCartera(100);
		sessionMati.comprar();
		System.out.println(mati.getHistorialCompra().listar());
		
		MapaProductos productos1 = new MapaProductos();
		productos1.agregar(clave, a);
		
		MapaProductos productos2 = new MapaProductos();
		productos2.agregar(clave2, b);
		
		MapaCategoria categorias = new MapaCategoria();
		categorias.agregarCategoria(clave, productos1);
		categorias.agregarCategoria(clave, productos2);
		categorias.agregarCategoria(clave2, productos1);
		categorias.agregarCategoria(clave2, productos2);
		
		System.out.println(categorias.listarCategorias());
		
//		mapUsuario mapaUsuario = new mapUsuario();
//		
//		mapaUsuario.agregar(alan.getId(), alan);
//		System.out.println(mapaUsuario.agregar(mati.getId(), mati));
//		System.out.println(mapaUsuario.listar());
	}

}
