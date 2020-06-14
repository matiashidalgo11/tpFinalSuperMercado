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

		Producto a = new Producto("PAPAS", 12, "lAYS", 2, 1);
		Producto b = new Producto("COCA", 11, "COCA COLA", 5, 1);
		Producto c = new Producto("PEPSI", 10, "PEPSICORP", 5, 1);
		b.setIdCategoria(1);
		c.setIdCategoria(1);
		MapaCategoria listaProductos = new MapaCategoria();
		MapaProductos gaseosa = new MapaProductos();
		gaseosa.agregar(b.getIdProducto(), b);
		gaseosa.agregar(c.getIdProducto(), c);
		
	
		
		long clave = 1;
		listaProductos.agregar(clave, gaseosa);
		
		Carro carrito = new Carro();
		for(int i = 0; i < 10; i++)
		{
			carrito.agregar(a);
			carrito.agregar(b);
			carrito.agregar(c);
		}
		
		//System.out.println(listaProductos.buscarProducto((long)1, b.getIdProducto()));
		System.out.println(listaProductos.existeProducto((long) 2 , b.getIdProducto()));
		
		
		/*System.out.println(carrito.listar());
		actualizarCarro(carrito, listaProductos);
		System.out.println(carrito.listar());
		*/
		
		
	}
	
	public static void actualizarCarro(Carro carrito, MapaCategoria listaProductos)
	{
		Producto productoListado;

		for (Producto productoCarrito : carrito.getArreglo().getArreglo()) {
			// Si no existe mas el producto poner condicion;
			System.out.println(productoCarrito);
			if (listaProductos.existeProducto(productoCarrito.getIdCategoria(), productoCarrito.getIdProducto())) {
				
				productoListado = listaProductos.buscarProducto(productoCarrito.getIdCategoria(), productoCarrito.getIdProducto());
				int stockNube = igualacion((int) productoListado.getStock(), (int) productoCarrito.getStock());
				if (stockNube < 0 && productoListado.getStock() > 0) {
					long cantidadTotal = productoCarrito.restarStock(stockNube);
				}

			} else {

				carrito.quitar(productoCarrito.getIdProducto());

			}

					
		}


	}
	
	public static int igualacion(int modelo, int imitador)
	{
		int cantidad = 0;
		
		if(modelo > imitador)
		{
			while(imitador + cantidad != modelo)
			{
				cantidad++;
			}
		}else if(modelo < imitador)
		{
			
			while(imitador - cantidad != modelo)
			{
				cantidad++;
			}
			
			cantidad = cantidad * -1;
		}
		
		
		return cantidad;
	}


}
