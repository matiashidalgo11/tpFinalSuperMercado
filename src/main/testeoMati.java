package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Archivo.ArchivoGenerico;
import Colecciones.ArregloProductos;
import Colecciones.MapaCategoria;
import Colecciones.MapaUsuario;
import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Colecciones.MapaProductos;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Bebidas;
import Productos.Producto;

public class testeoMati {

	public static void main(String[] args) {

		
		
		
		/*
		MapaUsuario mapaUsuario = new MapaUsuario();
		Usuario a = new Usuario("Matias", "Matias", "Matias", "Matias", 12, 23154);
		
		Usuario a2 = new Usuario("HIDALGO", "HIDALGO", "Matias", "Matias", 12, 23154);
		
		System.out.println(a);
		System.out.println("\n");
		System.out.println(a2);
		System.out.println("\n");
		
		System.out.println(mapaUsuario.agregarUsuario(a));
		System.out.println(mapaUsuario.agregarUsuario(a2));
		
		System.out.println(mapaUsuario.listar());
		*/
		
		
		//Supermercado toledo = new Supermercado();
		/*
		System.out.println("\n EL USUARIO QUE SE AGREGAR A SUPERMERCADOO ES: ");
		
		System.out.println(a);
		System.out.println(toledo.agregarUsuario(a));
		*/
		Usuario a = new Usuario("MatiasGamer", "1234", "Matias", "Hidalgo", 21, "123456");
		Usuario b = new Usuario("PepeGamer", "123", "Pepe", "Pepito", 21, "45235874");
		
		
//		ArchivoGenerico<Long, Usuario> archivoUsuario = new ArchivoGenerico<Long, Usuario>("Usuario.dat");
//		archivoUsuario.guardarUnidad(a);
//		archivoUsuario.guardarUnidad(b);
//		System.out.println(archivoUsuario.getArchivo().length());
//		ArregloGenerico<Usuario> arreglo = archivoUsuario.returnArregloGenerico();
//		System.out.println(arreglo.listar());
		
		Supermercado mercado = new Supermercado();
//		System.out.println(mercado.listarUsuarios());
	}
	
	

}
