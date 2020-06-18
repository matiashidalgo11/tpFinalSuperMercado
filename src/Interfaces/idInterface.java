package Interfaces;

/**
 * 
 * @author Matias
 *	Interface que sirve para agregarle un comportamiento y una similitud a Objetos que contengan un identificador(Id), asi Si se quiere crear un MapaGenerico el Objeto Generico implementaria esta interface y asi se puede obtener el id de dicho Objeto
 * @param <K>
 */
public interface idInterface <K> {

	public K getIdPrincipal();
	
}
