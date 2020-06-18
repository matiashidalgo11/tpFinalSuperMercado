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
		//Usuario a = new Usuario("Matias", "1234", "Matias", "Hidalgo", 21, (long)123456);
		Usuario b = new Usuario("Pepe", "4321", "Pepe", "Pipo", 15, (long)654321);
		
		
		ArchivoGenerico<Long, Usuario> archivoUsuario = new ArchivoGenerico<Long, Usuario>("Usuario.dat");
		archivoUsuario.guardarUnidad(b);
		System.out.println(archivoUsuario.getArchivo().length());
		ArregloGenerico<Usuario> arreglo = archivoUsuario.returnArregloGenerico();
		System.out.println(arreglo.listar());
	}
	
	

}
