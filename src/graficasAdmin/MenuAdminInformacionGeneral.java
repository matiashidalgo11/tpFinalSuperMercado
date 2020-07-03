package graficasAdmin;

import javax.swing.JPanel;

import Colecciones.MapaProductos;
import Objetos.Supermercado;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class MenuAdminInformacionGeneral extends JPanel {
	private JLabel lblCantidadProductos;
	private JLabel lblCantidadUusarios;
	private JLabel lblProductosEnOferta;
	private Supermercado datos;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public MenuAdminInformacionGeneral(Supermercado datos) {
		setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.controlLtHighlight, SystemColor.text, SystemColor.text, SystemColor.text));
		setBackground(SystemColor.text);

		this.datos = datos;
		initComponents();
		cargarInformacionGeneral(datos);
	}
	private void initComponents() {
	
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		lblCantidadProductos = new JLabel("" + datos.cantidadProductos());
		lblCantidadProductos.setFont(new Font("Calibri", Font.BOLD, 23));
		lblCantidadProductos.setBounds(414, 269, 80, 60);
		add(lblCantidadProductos);
		
		lblCantidadUusarios = new JLabel("" + datos.cantidadUsuarios());
		lblCantidadUusarios.setFont(new Font("Calibri", Font.BOLD, 23));
		lblCantidadUusarios.setBounds(414, 136, 80, 60);
		add(lblCantidadUusarios);
		
		lblProductosEnOferta = new JLabel("\"\"");
		lblProductosEnOferta.setFont(new Font("Calibri", Font.BOLD, 23));
		lblProductosEnOferta.setBounds(414, 401, 80, 60);
		add(lblProductosEnOferta);
		
		lblNewLabel_2 = new JLabel("Fondo");
		lblNewLabel_2.setIcon(new ImageIcon(MenuAdminInformacionGeneral.class.getResource("/img/Informacion General.png")));
		lblNewLabel_2.setBounds(-45, 29, 1042, 689);
		add(lblNewLabel_2);
	}
	
	
	public void cargarInformacionGeneral(Supermercado datos)
	{
		lblCantidadUusarios.setText("" + datos.cantidadUsuarios());
		lblCantidadProductos.setText("" + datos.cantidadProductos());
		MapaProductos mapa = datos.getListaCategorias().toMapaProductos();
		int cantidadProductosOferta = mapa.cantidadDeProductosEnOferta();
		lblProductosEnOferta.setText(""+cantidadProductosOferta);
		
	}
	
}
