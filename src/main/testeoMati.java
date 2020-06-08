package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Colecciones.ArregloProductos;
import Objetos.DetalleCompra;
import productos.Producto;

public class testeoMati {

	public static void main(String[] args) {

		/*
		LocalTime horaActual = LocalTime.now();
		System.out.println(horaActual);
		LocalDate fechaActual = LocalDate.now();
		System.out.println(fechaActual);
		String conversor =  fechaActual.toString();
		System.out.println(conversor);
		LocalDateTime fecharHoraActual = LocalDateTime.now();
		System.out.println(fecharHoraActual);
		*/
		
		ArregloProductos arreglo = new ArregloProductos();

		Producto a = new Producto("Papas", 12, "Lays", 12, 1);
		Producto b = new Producto("Paerw", 11, "sada", 5, 2);
		arreglo.agregar(a);
		arreglo.agregar(b);
		
		DetalleCompra detalleA = new DetalleCompra(arreglo);
		DetalleCompra detalleAigual = detalleA;
		DetalleCompra detalleB = new DetalleCompra(arreglo);
		
		System.out.println(detalleA.equals(detalleB));
		
		
		
	}

}
