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
	
	/**
	 * Esta funcion agregar al mapa solo si el Id y el userName son distintos
	 * @param user
	 * @return si se agrego (true) o no (false)
	 */
	public boolean agregarUsuario(Usuario user)
	{
		boolean resp = false;
		if(!(super.existencia(user.getIdPrincipal())))
		{
			if(!(existencia(user.getUserName())))
			{
				resp = super.agregar(user.getIdPrincipal(), user);

			}
		}
		
		return resp;
	}
	
	public boolean existencia(String userName)
	{
		boolean resp = false;
		Set <Entry<Long, Usuario>> set = super.getMapa().entrySet(); 
		Iterator<Entry<Long, Usuario>> it = set.iterator();
		
		while(it.hasNext() && !resp)
		{
			Entry<Long, Usuario> entrada = it.next();
			Usuario aux = entrada.getValue();
			if(userName.equals(aux.getUserName()))
			{
				resp = true;
			}
		}
		
		return resp;
	}
	
	public Usuario buscar (String userName) throws NullPointerException
	{
		Usuario resp = null;
		Set<Entry<Long, Usuario>> set = super.getMapa().entrySet();
		Iterator<Entry<Long, Usuario>> it = set.iterator();
		while(it.hasNext() && resp == null)
		{
			Entry<Long, Usuario> entrada = it.next();
			Usuario aux = entrada.getValue();
			if(aux.getUserName().equals(userName))
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
		
		long id = 0;
		
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
