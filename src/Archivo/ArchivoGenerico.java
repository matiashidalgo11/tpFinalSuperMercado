package Archivo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;



import java.util.Set;

import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Interfaces.idInterface;
/**
 * 
 * Clase para gestionar Archivo, al ser Generica se puede volver a reutilizar 
 *
 * @param <K> es la Clave para agregar al Mapa
 * @param <T> es el Dato Principal que se utilizara en el Archivo
 * 
 * 
 * 
 */

public class ArchivoGenerico  <K ,T extends idInterface<K> > implements Serializable{
	
	File archivo;

	/**
	 * Constructor que crear el Archivo de no encontrarse
	 * 
	 * @param nombre del Archivo
	 */
	public ArchivoGenerico(String nombre) {
		
		archivo = new File(nombre);
		if(archivo.exists())
		{
			System.out.println("\nEl fichero ya existe.\n");
		}else
		{
			try {
				
				archivo.createNewFile();
				System.out.println("\nEl fichero fue creado\n");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("\nNo se pudo crear el Ficher\n");
			}
			
			
		}
		

		
	}
	
	/**
	 * Metodo que recibe un MapaGenerico y luego lo guarda en el Archivo
	 * 
	 * @param mapa
	 */
	public void guardar(MapaGenerico<K, T> mapa)
	{
		
		try {
			FileOutputStream out = new FileOutputStream(archivo);
			ObjectOutputStream obOut = new ObjectOutputStream(out);
			
			Set<Entry<K,T>> set = mapa.getMapa().entrySet();
			Iterator<Entry<K,T>> it = set.iterator();
			
			while(it.hasNext())
			{
				Entry<K,T> entrada = it.next();
				T objeto = entrada.getValue();
				obOut.writeObject(objeto);
			}
			
			
			obOut.close();
			out.close();
			System.out.println("\nSE GUARDO EL MAPA\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Recibe un Dato y luego lo guarda, si el archivo esta vacio crea una cabecera, si no lo Guarda SIN CABECERA
	 * 
	 * @param dato
	 */
	public void guardarUnidad(T dato)
	{
		ObjectOutputStream ob;
		try
		{
			if(archivo.length() == 0 )
			{
				ob = new ObjectOutputStream(new FileOutputStream(archivo));
				ob.writeObject(dato);

				System.out.println("\nSE GUARDO EN OBJECT\n");
			}else
			{
				ob = new MiObjectOutputStream(new FileOutputStream(archivo,true));
				ob.writeObject(dato);
				System.out.println("\nSE GUARDO EN MIOBJECT\n");
			}
			
			ob.close();
		}catch (IOException e) {
			System.out.println("\nERROR AL GUARDAR LA UNIDAD\n");
			
		}
		
	}
	

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}


	/**
	 * Metodo que retorna un MapaGenerico con los tipos de Datos Ya establecidos al instanciar esta Clase
	 * 
	 */
	public MapaGenerico<K, T> cargar()
	{
		MapaGenerico<K, T> resp = new MapaGenerico<K, T>();

		
		try {
			ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(archivo));
			T dato;
			K clave;
			while(true)
			{
				
				
				 
				dato = (T) obIn.readObject();;
				
				clave = dato.getId();
				System.out.println(resp.agregar(clave, dato));
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nARCHIVO FINALIZADO\n");
			
			return resp;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return resp;
	}
	
	/*
	
	
	public ArregloGenerico<T> returnArregloGenerico()
	{
		ArregloGenerico<T> resp = new ArregloGenerico<T>();

		
		try {
			
			FileInputStream in = new FileInputStream(archivo);
			ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(archivo));
			
	
			while(true)
			{
				
				
				T dato = (T) obIn.readObject();
				resp.agregar(dato);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nARCHIVO FINALIZADO\n");
			//e.printStackTrace();
			return resp;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return resp;
	}
	
	
	public void listar() {
		try {

			FileInputStream in = new FileInputStream(archivo);
			ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(archivo));

			while (true) {

				T readObject = ((T) obIn.readObject());
				T dato = readObject;
				System.out.println(dato.toString());

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nARCHIVO FINALIZADO\n");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*/
}
