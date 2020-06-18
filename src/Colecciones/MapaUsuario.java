package Colecciones;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Interfaces.IdMaximo;
import Objetos.Usuario;
import productos.Producto;

public class MapaUsuario extends MapaGenerico<Long, Usuario> implements IdMaximo{

	
	public MapaUsuario() {
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
			if(nombre.equals(aux.getUserName()))
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
			if(aux.getUserName().equals(nombre))
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

	@Override
	public Long getIdMasAlto() {
		
		long id = 1;
		
		Set<Entry<Long, Usuario>> set = super.getMapa().entrySet();
		Iterator<Entry<Long, Usuario>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long, Usuario> entrada = it.next();
			long aux = entrada.getKey();
			if(aux > id)
			{
				id = aux;
			}
			
		}
		
		return id;
	}

	
	
	

	
	
}
