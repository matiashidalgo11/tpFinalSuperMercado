package Objetos;



import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONObject;

import Colecciones.ArregloDetalleCompra;
import ColeccionesGenericas.ArregloGenerico;
import Interfaces.JsonFunciones;
import Interfaces.idInterface;

/**
 * 
 * Clase Usuario
 * 
 */
public class Usuario implements idInterface<Long>, Serializable, JsonFunciones{
	
	/**
	 * Identificador unico para saber que es una Clase Usuario
	 */
	private static final long serialVersionUID = 1L;


	public static long generadorId = 0;
	
	
	private long id;
	private String userName;
	private String password;
	private double cartera;
	private ArregloDetalleCompra historialCompra;
	private String nombre;
	private String apellido;
	private int edad;
	private String telefono;
	private boolean activo;
	
	//Referencias para construir el JSON
	
	public static String CLAVE_ID = "idUsuario";
	public static String CLAVE_USERNAME = "userName";
	public static String CLAVE_PASSWORD = "password";
	public static String CLAVE_CARTERA = "cartera";
	public static String CLAVE_HISTORIALCOMPRA = "historialCompra";
	public static String CLAVE_NOMBRE = "nombre";
	public static String CLAVE_APELLIDO = "apellido";
	public static String CLAVE_EDAD = "edad";
	public static String CLAVE_TELEFONO = "telefono";
	public static String CLAVE_ACTIVO = "activo";
	
	
	public Usuario(String userName, String password, String nombre, String apellido, int edad, String telefono) {
		
		this.userName = userName;
		this.password = password;
		this.cartera = 0;
		this.id = generadorId + (long) 1;
		historialCompra = new ArregloDetalleCompra();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
		this.activo = true;
		
		this.generadorId ++;
	}
	


	/**
	 *	Constructor para clonar objeto.
	 * 
	 */
	public Usuario(String userName, String password, double cartera, long id, ArregloDetalleCompra historialCompra, String nombre, String apellido, int edad, String telefono, boolean activo) {
		
		this.userName = userName;
		this.password = password;
		this.cartera = cartera;
		this.id = id;
		this.historialCompra = historialCompra;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
		this.activo = activo;
	}
	
	/**
	 * Constructor para Json
	 */
	public Usuario(JSONObject json)
	{
		JSONArray arrayJDetalleCompra;
		JSONObject detalleJson;
		DetalleCompra aux;
		
		if(json.has(CLAVE_ID))
		{
			this.id = json.getLong(CLAVE_ID);
			this.userName = json.getString(CLAVE_USERNAME);
			this.password = json.getString(CLAVE_PASSWORD);
			this.cartera = json.getDouble(CLAVE_CARTERA);
			this.nombre = json.getString(CLAVE_NOMBRE);
			this.apellido = json.getString(CLAVE_APELLIDO);
			this.edad = json.getInt(CLAVE_EDAD);
			this.telefono = json.getString(CLAVE_TELEFONO);
			this.activo = json.getBoolean(CLAVE_ACTIVO);
			historialCompra = new ArregloDetalleCompra();
			arrayJDetalleCompra = json.getJSONArray(CLAVE_HISTORIALCOMPRA);
			
			for(int i = 0; i < arrayJDetalleCompra.length(); i++ )
			{
				detalleJson = arrayJDetalleCompra.getJSONObject(i);
				aux  = new DetalleCompra(detalleJson);
				historialCompra.agregar(aux);
			}
			
		}

	}
	
	
	public Usuario() {
		this.userName = "";
		this.password = "";
		this.cartera = 0;
		this.id = 0;
		this.historialCompra = null;
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.telefono = "";
		this.activo = false;
	}
	

	@Override
	public int hashCode() {
		
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		
		if(!(obj instanceof Usuario))
		{
			return false;
		}else
		{
			Usuario aux = (Usuario) obj;
			if(aux.getUserName() == this.getUserName())
			{
			resp = true;
			}
		}
			
		return resp;
	}

	
	
	@Override
	public String toString() {
		
		return  "\n" +
				"idUsuario " + id + "\n" +
				"Nombre:   " + userName + "\n" +
				"Password: " + password + "\n" + 
				"Cartera:  " + cartera + "\n" +
				"Informacion Personal: " + this.nombre + " " + this.apellido + " " + this.edad +" " +this.telefono +"\n";
	}
	
	public void sumarCartera(double suma)
	{
		this.cartera = this.cartera + suma;
	}
	
	public void restarCartera(double resta)
	{
		if(resta <= this.cartera)
		{
			this.cartera = this.cartera- resta;
		}else
		{
			System.out.println("\nNo hay dinero suficiente\n");
		}
	}


	public static long getGeneradorId() {
		return generadorId;
	}

	@Override
	public Long getId() {
		return id;
	}
	

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public static void setGeneradorId(long generadorId) {
		Usuario.generadorId = generadorId;
	}

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public double getCartera() {
		return cartera;
	}



	public void setCartera(double cartera) {
		this.cartera = cartera;
	}



	public ArregloDetalleCompra getHistorialCompra() {
		return historialCompra;
	}



	public void setHistorialCompra(ArregloDetalleCompra historialCompra) {
		this.historialCompra = historialCompra;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void invertirActivo()
	{
		if(this.activo == true)
		{
			this.activo = false;
		}else
		{
			this.activo = true;
		}
	}



	@Override
	public JSONObject toJson() {
		
		JSONObject resp = new JSONObject();
		
		resp.put(CLAVE_ACTIVO, this.isActivo());
		resp.put(CLAVE_CARTERA, this.getCartera());
		resp.put(CLAVE_HISTORIALCOMPRA, this.getHistorialCompra().toJsonArray());
		resp.put(CLAVE_ID, this.getId());
		resp.put(CLAVE_NOMBRE, this.getNombre());
		resp.put(CLAVE_APELLIDO, this.getApellido());
		resp.put(CLAVE_PASSWORD, this.getPassword());
		resp.put(CLAVE_TELEFONO, this.getTelefono());
		resp.put(CLAVE_USERNAME, this.getUserName());
		
		
		return resp;
	}






	
	
}
