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


		
		Supermercado toledo = new Supermercado();

		Usuario a = new Usuario("MatiasGamer", "1234", "Matias", "Hidalgo", 21, "123456");
		Usuario b = new Usuario("PepeGamer", "123", "Pepe", "Pepito", 21, "45235874");
		
		//toledo.agregarUsuario(a);
		
		Producto pa = new Bebidas("Coca cola", 100, "Coca Cola Company", 10, true, 2.25, "Cola", false);
		Producto pb = new Congelado("Pollo", 100, "Doleto", 100, 1.25);
		Producto pc = new Golosina("Kinder Sorpresa", 150, "Kinder Infantil", 100, 1);
		
		toledo.agregarProducto(pa);
		toledo.agregarProducto(pb);
		toledo.agregarProducto(pc);
		
		//toledo.guardarDatos();
	
	
		
		/**
		 * Error cuando guardar Productos de distinta categoria;
		 */
		
		
		
		
		

	}
	
	

}
