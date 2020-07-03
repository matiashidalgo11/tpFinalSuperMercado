package Objetos;

import java.io.Serializable;

import org.json.JSONObject;

import Colecciones.ArregloProductos;
import Colecciones.MapaCategoria;
import ColeccionesGenericas.ArregloGenerico;
import Interfaces.JsonFunciones;
import Interfaces.idInterface;
import Productos.Producto;

/**
 * 
 * 
 * Clase que contiene un ArregloProductos, y el Id al cual pertence a un Usuario que lo este Utilizando.
 * 
 * 
 * 
 */
public class Carro implements Serializable, idInterface<Long>, JsonFunciones{
	
	private double total;
	private ArregloProductos arreglo;
	private long idCarro;
	
	/**
	 * Identificador unico para saber que es una Clase Carro para el JsonObject
	 */
	public static String CLAVE_ID = "idCarro";
	public static String CLAVE_ARREGLOPRODUCTOS = "arregloProductos";
	public static String CLAVE_TOTAL = "montoTotal";
	
	public Carro(ArregloProductos arreglo, long id) {
		
		this.arreglo = arreglo;
		this.total = arreglo.sumaTotal();
		this.idCarro = id;
	}

	public Carro(long id) {
		arreglo = new ArregloProductos();
		this.total = 0;
		this.idCarro = id;
	}
	

	/**
	 * 
	 * Agrega un producto si el Stock de dicho Producto es mayor a 0, en caso contrario retorna False y no se agrega
	 * 	 
	 */
	public boolean agregar(Producto p)
	{
		boolean rta = false;
		if(p.getStock() > 0 )
		{	
			arreglo.agregar(p);
			this.total += p.getPrecio();
			rta = true;
		}
		
		return rta;
	}
	
	public boolean quitar(long id)
	{
		boolean rta = false;
		if(arreglo.existencia(id))
		{
			Producto aux = arreglo.buscar(id);
			arreglo.eliminar(aux);
			this.total = arreglo.sumaTotal();
			rta = true;
		}
		return rta;
	}
	
	

	public double sumaTotalCarro()
	{
		return arreglo.sumaTotal();
	}
	
	public int cantidadProductos()
	{
		return arreglo.cantidad();
	}

	/**
	 * La funcion crea un DetalleCompra basado en el arregloProducto, solo si el arreglo contiene algun Producto
	 * 
	 * @return una Objeto DetalleCompra
	 * 
	 */
	public DetalleCompra generarDetllaCompra() throws NullPointerException
	{
		DetalleCompra resp = null;
		
		if(arreglo.cantidad() > 0)
		{
			resp = new DetalleCompra(arreglo);
		}else
		{
			throw new NullPointerException();
		}
		
		
		return resp;
	}
	
	/**
	 * Vacia el Arreglo y establece el total a 0
	 */
	public void limpiarCarrito()
	{
		this.total = 0;
		this.arreglo.vaciar();
	}
	
	public String listar()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Informacion Carrito");
		if(arreglo.cantidad() > 0)
		{
			builder.append(arreglo.listar());
			builder.append(total);
		}else
		{
			builder.append("\nVACIO\n");
		}
		
		
		return builder.toString();
	}
	
	public ArregloProductos getArreglo() {
		return arreglo;
	}

	public void setArreglo(ArregloProductos arreglo) {
		this.arreglo = arreglo;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public boolean isEmpty()
	{
		boolean resp = false;
		if(arreglo.cantidad() == 0)
		{
			resp = true;
		}
		
		return resp;
	}

	@Override
	public Long getId() {
		
		return this.idCarro;
	}
	
	@Override
	public void setId(Long id) {
		this.idCarro = id;
		
	}
	
	@Override
	public String toString() {
		
		return "\nCarro de User id " + this.idCarro + "\n" +  
				"Cantidad Productos: " + this.cantidadProductos() + "\n" + 
				"Total: " + this.total + "\n";
	}
	

	/**
	 * Recibe el carro actual del usuario que esta en session y luego lo actualiza acorde a la cantidad de Stock y de productos se encuentran en la ListaCategorias que recibe por parametro
	 * @param carrito
	 * @param listaCategorias 
	 * 
	 * podria retornar la cantidad de productos que se quitaron(?)
	 */
	public static void actualizarCarro(Carro carrito, MapaCategoria listaCategorias)
	{
		
		Producto productoListado;
		ArregloGenerico<Long> idDeEliminados = new ArregloGenerico<Long>();
		
		//Recorre todos los productos del carrito
		for (Producto productoCarrito : carrito.getArreglo().getArreglo()) {
			
		//Verifica si existe el Producto que se encuentra en el carrito dentro de la Lista Principal de Productos, si no es el caso lo elimina. En cambio si es el caso verifica que el stock este sincronizado con la cantidad De Stock disponible
			if (listaCategorias.existeProducto(productoCarrito.getId())) {
				
				productoListado = listaCategorias.buscarProducto( productoCarrito.getId());
				int stockNube = igualacion((int) productoListado.getStock(), (int) productoCarrito.getStock());
				if (stockNube < 0 && productoListado.getStock() > 0) {
					
					productoCarrito.restarStock(stockNube * -1);

				}

			} else {
				
				System.out.println(productoCarrito.getId());
				idDeEliminados.agregar(productoCarrito.getId());

			}

					
		}
		
		for(Long id : idDeEliminados.getArreglo())
		{
			carrito.quitar(id);
		}
		

	}
	
	//***************************Funciones Auxiliar**************************************//
	
	/**
	 * Compara un numero con otro
	 * @param modelo es el principal
	 * @param imitador es el numero que va a querer copiar al modelo
	 * @return  Si es 0 es que son iguales.
	 *  	    Si el numero es mayor a 0 son los numeros que le faltan al Imitador para copiar a Modelo.
	 *  	    Si es menor que 0 son los numeros que se le tienen que restar a Imitador para igualar a Modelo.
	 * 	 */
	private static int igualacion(int modelo, int imitador)
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

	
	@Override
	public JSONObject toJson() {
		
		JSONObject resp = new JSONObject();
		
		resp.put(CLAVE_ID, this.getId());
		resp.put(CLAVE_TOTAL, this.getTotal());
		resp.put(CLAVE_ARREGLOPRODUCTOS, this.getArreglo().toJsonArray());
		
		return resp;
	}

	

	
	
}
