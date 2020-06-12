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

public class testeoMati {

	public static void main(String[] args) {

		Usuario mati = new Usuario("Matias", "1234");
		Usuario alan = new Usuario("Alan", "1234");
		
		System.out.println(mati);
		System.out.println(alan);
		
		/*Producto a = new Producto("PAPAS", 12, "lAYS", 2, 1);
		Producto b = new Producto("COCA", 11, "COCA COLA", 5, 2);
		
		Carro carrito = new Carro();
		carrito.agregar(a);
		carrito.agregar(b);
		
		Session sessionMati = new Session(mati, carrito);
		System.out.println(sessionMati);
		sessionMati.modificarNombre("Matias", "Pepe");
		sessionMati.cargarCartera(100);
		sessionMati.comprar();
		System.out.println(mati.getHistorialCompra().listar());
		*/
		mapUsuario mapaUsuario = new mapUsuario();
		
		mapaUsuario.agregar(alan.getId(), alan);
		System.out.println(mapaUsuario.agregar(mati.getId(), mati));
		System.out.println(mapaUsuario.listar());
	}

}
