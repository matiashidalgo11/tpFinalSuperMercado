package main;

import Objetos.Supermercado;
import graficas.Principal;

public class testeoAlan {

	public static void main(String[] args) {
		
		Supermercado mercado = new Supermercado();

		mercado.cargarDatos();

		new Principal(mercado).setVisible(true);

	}

}
