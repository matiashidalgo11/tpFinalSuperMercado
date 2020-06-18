package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Archivo.ArchivoGenerico;
import Colecciones.ArregloProductos;
import Colecciones.ArregloGenerico;
import Colecciones.MapaUsuario;
import Colecciones.MapaGenerico;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import productos.Bebidas;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;

public class testeoMati {

	public static void main(String[] args) {

		
		/*
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
		*/
		/*
		ArchivoGenerico<Long,Usuario> archivoUsuario = new ArchivoGenerico<Long,Usuario>("Usuario.dat");
		
		
		mapaGenerico<Long, Usuario> mapaUsuario = new mapaGenerico<Long, Usuario>();
		mapaUsuario.agregar(a.getIdPrincipal(), a);
		mapaUsuario.agregar(b.getIdPrincipal(), b);
		mapaUsuario.agregar(c.getIdPrincipal(), c);
		
		//System.out.println(mapaUsuario.listar());
		
		archivoUsuario.guardar(mapaUsuario);
		
		*/
		
		
		
		
		Supermercado toledo = new Supermercado();
		Usuario aux = new Usuario("Matias11", "Matias11", "Matias", "Hidalgo", 21, 123456789);
		System.out.println(aux);
		System.out.println(Usuario.generadorId);
		//System.out.println(toledo.agregarUsuario(aux));
		
		
		
		
		
		
		
		
		
	}
	
	

}
