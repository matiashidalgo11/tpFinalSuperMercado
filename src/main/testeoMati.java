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
import Productos.*;
import Objetos.*;

public class testeoMati {

	public static void main(String[] args) {


		
		

		/*
		
		
		//toledo.agregarUsuario(a);
		
		Producto pa = new Bebidas("Coca cola", 100, "Coca Cola Company", 10, true, 2.25, "Cola", false, false, 0);
		Producto pb = new Congelado("Pollo", 100, "Doleto", 100, 1.25, false, 0);
		Producto pc = new Golosina("Kinder Sorpresa", 150, "Kinder Infantil", 100, 1, false, 0);
		*/
		/*
		toledo.agregarProducto(pa);
		toledo.agregarProducto(pb);
		toledo.agregarProducto(pc);
		*/
		//toledo.guardarDatos();
		//toledo.agregarUsuario(a);
		//toledo.agregarUsuario(b);
	
		
		/**
		 * Error cuando guardar Productos de distinta categoria;
		 */
		/*
		Producto coca = new Bebidas("Cola", 60, "Coca", 1, true, 2, "Dulce", false, false, 0);
		coca.setId((long)1);
		
		toledo.getSesionActiva().agregarAlCarro(coca);
		toledo.getSesionActiva().cargarCartera(100);
		toledo.comprarProductos();
		toledo.guardarDatos();
		*/
		//toledo.iniciarSession((long)1);
		//System.out.println(toledo.getSesionActiva().getUser().getHistorialCompra().listar());
		
		Usuario a = new Usuario("MatiasGamer", "1234", "Matias", "Hidalgo", 21, "123456");
		Usuario b = new Usuario("PepeGamer", "123", "Pepe", "Pepito", 21, "45235874");
		Producto coca = new Bebida("Cola", 60, "Coca", 1, true, 2, "Dulce", false, false, 0);
		Producto jugo = new Bebida("Jugo", 30, "Cualquiera", 1, false, 2, "Dulce", false, false, 0);
		Producto cerveza = new Bebida("Cerveza", 100, "Quilmes", 1, false, 2, "Amargo", true, false, 0);
		Producto agua = new Bebida("Agua", 50, "Mineral", 1, false, 2, "Agua", false, false, 0);
		Producto papas = new Snack("Papas Frita", 70, "Lays", 1, 100, false, 0);
		Producto palitos = new Snack("Palitos", 40, "Palitos", 1, 100, false, 0);	
		Producto leche = new Lacteo("Leche", 50, "LaSerenisima", 1, "Leche", false, 0);
		
		//Supermercado mercado = new Supermercado();
		//mercado.agregarUsuario(a);
		//mercado.agregarUsuario(b);
		/*		
		mercado.agregarProducto(coca);
		mercado.agregarProducto(jugo);
		mercado.agregarProducto(cerveza);
		mercado.agregarProducto(agua);
		mercado.agregarProducto(papas);
		mercado.agregarProducto(palitos);
		mercado.agregarProducto(leche);
		
		mercado.guardarDatos();
		
		
		
*/
		int porcentaje = 75;
		double porciento = (double) porcentaje / 100;
		System.out.println(porciento);
		
	}
	
	

}
