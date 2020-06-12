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
		
		Producto a = new Producto("PAPAS", 12, "lAYS", 2, 1);
		Producto b = new Producto("COCA", 11, "COCA COLA", 5, 2);
		
		Carro carrito = new Carro();
		carrito.agregar(a);
		carrito.agregar(b);
		
		
		
		Producto c = new Producto(a);
		
		ArregloProductos arregloProductos = new ArregloProductos();
		
		System.out.println(arregloProductos.agregar(a));
		System.out.println(arregloProductos.agregar(b));
		System.out.println(arregloProductos.agregar(a));
		
		a.setNombre("MANI");
		System.out.println(a);
		System.out.println(arregloProductos.listar());
	}

}
