package Archivo;

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

import Colecciones.ArregloGenerico;
import Colecciones.MapaGenerico;
import Interfaces.idInterface;
/**
 * 
 * @author Matias
 *
 * @param <K> es la Clave para agregar al Mapa
 * @param <T> es el Dato Principal que se utilizara en el Archivo
 * 
 * 
 * La interface idInterface hace que cualquier objeto que la implemente tenga el metodo getIdPrincipal, para luego utilizarlo como clave, faltan mas testeos
 */

public class ArchivoGenerico <K ,T extends idInterface<K> > {
	
	File archivo;

	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		
	}
	
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
			
			out.close();
			obOut.close();
			System.out.println("\nSE GUARDO EL MAPA\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void agregarUnidad(T dato)
	{

		ObjectOutputStream in;
		
		try
		{
			if(archivo.length() == 0)
			{
				in = new ObjectOutputStream(new FileOutputStream(archivo, true));
			}else
			{
				in = new MiObjectOutputStream(new FileOutputStream(archivo, true));
			}
			 
			in.writeObject(dato);
			
		}catch (IOException e) {
			
		}
		
	}
	
	public MapaGenerico<K, T> cargar()
	{
		MapaGenerico<K, T> resp = new MapaGenerico<K, T>();

		
		try {
			
			FileInputStream in = new FileInputStream(archivo);
			ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(archivo));
			T dato;
			K clave;
			while(true)
			{
				
				
				dato = (T) obIn.readObject();
				clave = dato.getIdPrincipal();
				
				resp.agregar(clave, dato);
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
	
	public ArregloGenerico<T> returnArregloGenerico()
	{
		ArregloGenerico<T> resp = new ArregloGenerico<T>();

		
		try {
			
			FileInputStream in = new FileInputStream(archivo);
			ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(archivo));
			T dato;
	
			while(true)
			{
				
				
				dato = (T) obIn.readObject();

				
				resp.agregar(dato);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nARCHIVO FINALIZADO\n");
			e.printStackTrace();
			return resp;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return resp;
	}

}
