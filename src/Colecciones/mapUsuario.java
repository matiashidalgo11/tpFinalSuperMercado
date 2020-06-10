package Colecciones;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Objetos.Usuario;

public class mapUsuario extends mapaGenerico<Long, Usuario> {

	
	public mapUsuario() {
		super();
	}
	
	public boolean existencia(String nombre)
	{
		boolean resp = false;
		Set <Entry<Long, Usuario>> set = super.getMapa().entrySet(); 
		Iterator<Entry<Long, Usuario>> it = set.iterator();
		
		while(it.hasNext() && !resp)
		{
			Entry<Long, Usuario> entrada = it.next();
			Usuario aux = entrada.getValue();
			if(nombre.equals(aux.getNombre()))
			{
				resp = true;
			}
		}
		
		return resp;
	}
	
	public Usuario buscar (String nombre) throws NullPointerException
	{
		Usuario resp = null;
		Set<Entry<Long, Usuario>> set = super.getMapa().entrySet();
		Iterator<Entry<Long, Usuario>> it = set.iterator();
		while(it.hasNext() && resp == null)
		{
			Entry<Long, Usuario> entrada = it.next();
			Usuario aux = entrada.getValue();
			if(aux.getNombre().equals(nombre))
			{
				resp = aux;
			}
			
		}
		
		if(resp == null)
		{
			throw new NullPointerException();
		}
		
		return resp;
	}

	
	
	

	
	
}
