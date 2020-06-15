package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Colecciones.ArregloProductos;
import Colecciones.arregloGenerico;
import Colecciones.mapUsuario;
import Colecciones.mapaGenerico;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Usuario;
import productos.Bebidas;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class testeoMati {

	public static void main(String[] args) {

		Producto a = new Producto("PAPAS", 12, "lAYS", 2, (long)2);
		Producto b = new Producto("COCA", 11, "COCA COLA", 0, (long)1);
		Producto c = new Producto("PEPSI", 10, "PEPSICORP", 1, (long)1);


		
		MapaCategoria listaProductos = new MapaCategoria();
		MapaProductos gaseosa = new MapaProductos();
		gaseosa.agregar(b.getIdProducto(), b);
		gaseosa.agregar(c.getIdProducto(), c);
	
		long clave = 1;
		listaProductos.agregar(clave, gaseosa);
		
		Carro carrito = new Carro();
		for(int i = 0; i < 5; i++)
		{
			carrito.agregar(a);
			carrito.agregar(b);
			carrito.agregar(c);
		}
		
		
		
		//System.out.println(listaProductos.existeProducto(clave, (long)0));
		
		
		System.out.println(carrito.listar());
		System.out.println("\n**************************\n");
		System.out.println(listaProductos.listarCategorias());
		
		//System.out.println("\nSTOCK ACTUALIZADO\n");
		
		
		System.out.println(carrito.listar());
		
		
		
	}
	
	

}
