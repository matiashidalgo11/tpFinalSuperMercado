package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import Colecciones.ArregloProductos;
import Colecciones.MapaUsuario;
import Colecciones.MapaGenerico;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import graficas.Inicio;
import productos.Bebidas;
import productos.Lacteo;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Producto;
import productos.Snack;

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
//		Bebidas coca = new Bebidas("Cola", 60, "Coca", 1, 1, true, 2, "Dulce", false);
//		Bebidas jugo = new Bebidas("Jugo", 30, "Cualquiera", 1, 1, false, 2, "Dulce", false);
//		Bebidas cerveza = new Bebidas("Cerveza", 100, "Quilmes", 1, 1, false, 2, "Amargo", true);
//		Bebidas agua = new Bebidas("Agua", 50, "Mineral", 1, 1, false, 2, "Agua", false);
//		
//		Snack papas = new Snack("Papas Frita", 70, "Lays", 1, 2, 100);
//		Snack palitos = new Snack("Palitos", 40, "Palitos", 1, 2, 100);	
//		
//		Lacteo leche = new Lacteo("Leche", 50, "LaSerenisima", 1, 3, "Leche");
		
		Supermercado mercado = new Supermercado();
//		mercado.agregarProducto(coca.getIdCategoria(), coca);
//		mercado.agregarProducto(jugo.getIdCategoria(), jugo);
//		mercado.agregarProducto(cerveza.getIdCategoria(), cerveza);
//		mercado.agregarProducto(agua.getIdCategoria(), agua);
//		mercado.agregarProducto(papas.getIdCategoria(), papas);
//		mercado.agregarProducto(palitos.getIdCategoria(), palitos);
//		mercado.agregarProducto(leche.getIdCategoria(), leche);
		
//		mercado.guardarDatos();
		mercado.cargarDatos();
//		System.out.println(mercado.listarCategoriaEspecifica((long) 1));
//		System.out.println(mercado.listarCategorias());
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
