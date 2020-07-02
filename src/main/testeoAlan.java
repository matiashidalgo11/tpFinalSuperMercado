package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Colecciones.ArregloProductos;
import Colecciones.MapaCategoria;
import Colecciones.MapaUsuario;
import ColeccionesGenericas.MapaGenerico;
import Colecciones.MapaProductos;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Bebida;
import Productos.Lacteo;
import Productos.Producto;
import Productos.Snack;
import graficas.Inicio;

public class testeoAlan {

	public static void main(String[] args) {
		
//		Usuario mati = new Usuario("Matias", "1234");
//		Usuario alan = new Usuario("Alan", "1234");
//		
//		System.out.println(mati);
//		System.out.println(alan);
//		
//		Producto a = new Producto("PAPAS", 12, "lAYS", 2, 1);
//		Producto b = new Producto("COCA", 11, "COCA COLA", 5, 2);
//		
//		Carro carrito = new Carro();
//		carrito.agregar(a);
//		carrito.agregar(b);
//		
//		long clave = 1;
//		long clave2 = 2;
//		
//		Session sessionMati = new Session(mati, carrito);
//		System.out.println(sessionMati);
//		sessionMati.modificarNombre("Matias", "Pepe");
//		sessionMati.cargarCartera(100);
//		sessionMati.comprar();
//		System.out.println(mati.getHistorialCompra().listar());
//		
//		MapaProductos productos1 = new MapaProductos();
//		productos1.agregar(clave, a);
//		
//		MapaProductos productos2 = new MapaProductos();
//		productos2.agregar(clave2, b);
//		
//		MapaCategoria categorias = new MapaCategoria();
//		categorias.agregarCategoria(clave, productos1);
//		categorias.agregarCategoria(clave, productos2);
//		categorias.agregarCategoria(clave2, productos1);
//		categorias.agregarCategoria(clave2, productos2);
//		
//		System.out.println(categorias.listarCategorias());
		
		
//		Usuario alan = new Usuario("Alan", "123", 500, 1, null);
//		
//		
//		Producto coca = new Bebidas("Cola", 60, "Coca", 1, true, 2, "Dulce", false, false, 0);
//		Producto jugo = new Bebidas("Jugo", 30, "Cualquiera", 1, false, 2, "Dulce", false, false, 0);
//		Producto cerveza = new Bebidas("Cerveza", 100, "Quilmes", 1, false, 2, "Amargo", true, false, 0);
//		Producto agua = new Bebidas("Agua", 50, "Mineral", 1, false, 2, "Agua", false, false, 0);
//		
//		Producto papas = new Snack("Papas Frita", 70, "Lays", 1, 100, false, 0);
//		Producto palitos = new Snack("Palitos", 40, "Palitos", 1, 100, false, 0);	
//		
//		Producto leche = new Lacteo("Leche", 50, "LaSerenisima", 1, "Leche", false, 0);
//		
		Supermercado mercado = new Supermercado();
//		mercado.agregarProducto(coca);
//		mercado.agregarProducto(jugo);
//		mercado.agregarProducto(cerveza);
//		mercado.agregarProducto(agua);
//		mercado.agregarProducto(papas);
//		mercado.agregarProducto(palitos);
//		mercado.agregarProducto(leche);
		
//		mercado.guardarDatos();
		mercado.cargarDatos();
//		System.out.println(mercado.listarCategoriaEspecifica((long) 1));
		System.out.println(mercado.listarCategorias());
		new Inicio(mercado).setVisible(true);
//		mercado.agregarUsuario(alan);
//		mercado.iniciarSession(1);
//		
//		new Inicio(mercado).setVisible(true);;
		
//		System.out.println(mercado.listarUsuarios());
//		System.out.println(mercado.getNombreCategoria((long) 1));
		
//		mapUsuario mapaUsuario = new mapUsuario();
//		
//		mapaUsuario.agregar(alan.getId(), alan);
//		System.out.println(mapaUsuario.agregar(mati.getId(), mati));
//		System.out.println(mapaUsuario.listar());
	}

}
