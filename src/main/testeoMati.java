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
import Productos.Congelado;
import Productos.Golosina;
import Productos.Producto;

public class testeoMati {

	public static void main(String[] args) {


		
		//Supermercado toledo = new Supermercado();

		Usuario a = new Usuario("MatiasGamer", "1234", "Matias", "Hidalgo", 21, "123456");
		Usuario b = new Usuario("PepeGamer", "123", "Pepe", "Pepito", 21, "45235874");
		
		//toledo.agregarUsuario(a);
		
		Producto pa = new Bebidas("Coca cola", 100, "Coca Cola Company", 10, true, 2.25, "Cola", false);
		Producto pb = new Congelado("Pollo", 100, "Doleto", 100, 1.25);
		Producto pc = new Golosina("Kinder Sorpresa", 150, "Kinder Infantil", 100, 1);
		
		
		/*
		System.out.println(toledo.agregarProducto(pa));
		System.out.println(toledo.agregarProducto(pb));
		System.out.println(toledo.agregarProducto(pc));
		System.out.println(toledo.agregarProducto(pa));
		*/
		
		/*
		MapaProductos mapaPro = new MapaProductos();
		
		mapaPro.agregar(pa.getId(), pa);
		mapaPro.agregar(pb.getId(), pb);
		mapaPro.agregar(pc.getId(), pc);
		MapaCategoria mapaCa = new MapaCategoria();
		mapaCa = MapaCategoria.mapaToListaProductos(mapaPro.getMapa());
		//System.out.println(mapaCa.listar());
		*/
		
		/**
		 * Error cuando guardar Productos de distinta categoria;
		 */
		ArchivoGenerico<Long, Producto> archivoProducto = new ArchivoGenerico<Long, Producto>("ProductoTest.dat");
		//archivoProducto.guardarUnidad((Producto)pa);
		//archivoProducto.guardarUnidad((Producto)pb);
		//archivoProducto.guardarUnidad(pc);
		System.out.println(archivoProducto.cargar().listar());
		
		
		/*
		ArchivoGenerico<Long,Usuario> archivoUsuario= new ArchivoGenerico<Long, Usuario>("Usuario.dat");
		archivoUsuario.guardarUnidad(a);
		archivoUsuario.guardarUnidad(b);
		System.out.println(archivoUsuario.cargar().listar());
		*/
		/*
		MapaProductos mapaTodo = new MapaProductos();
		mapaTodo.setMapa(archivoProducto.cargar().getMapa());
		
		MapaCategoria mapaCategor = MapaCategoria.mapaToListaProductos(mapaTodo.getMapa());
		System.out.println(mapaCategor.listar());
		*/

	}
	
	

}
