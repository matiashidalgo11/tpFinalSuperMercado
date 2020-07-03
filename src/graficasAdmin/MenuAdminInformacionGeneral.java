package graficasAdmin;

import javax.swing.JPanel;

import Colecciones.MapaProductos;
import Objetos.Supermercado;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class MenuAdminInformacionGeneral extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCantidadProductos;
	private JLabel lblCantidadUusarios;
	private JLabel lblNewLabel_4;
	private JLabel lblProductosEnOferta;
	private Supermercado datos;

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

	
		lblNewLabel = new JLabel("Cantidad de Usuarios");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(50, 103, 330, 82);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad de Productos");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(50, 274, 330, 82);
		add(lblNewLabel_1);
		
		lblCantidadProductos = new JLabel("" + datos.cantidadProductos());
		lblCantidadProductos.setFont(new Font("Calibri", Font.BOLD, 23));
		lblCantidadProductos.setBounds(520, 274, 330, 82);
		add(lblCantidadProductos);
		
		lblCantidadUusarios = new JLabel("" + datos.cantidadUsuarios());
		lblCantidadUusarios.setFont(new Font("Calibri", Font.BOLD, 23));
		lblCantidadUusarios.setBounds(520, 103, 330, 82);
		add(lblCantidadUusarios);
		
		lblNewLabel_4 = new JLabel("Productos en Oferta");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(50, 420, 330, 82);
		add(lblNewLabel_4);
		
		lblProductosEnOferta = new JLabel("\"\"");
		lblProductosEnOferta.setFont(new Font("Calibri", Font.BOLD, 23));
		lblProductosEnOferta.setBounds(520, 420, 330, 82);
		add(lblProductosEnOferta);
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
