package graficasAdmin;

import javax.swing.JPanel;

import Objetos.Supermercado;

import javax.swing.JLabel;
import java.awt.Font;

public class InformacionGeneral extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCantidadProductos;
	private JLabel lblCantidadUusarios;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private Supermercado datos;

	/**
	 * Create the panel.
	 */
	public InformacionGeneral(Supermercado datos) {

		this.datos = datos;
		initComponents();
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
		
		lblNewLabel_4 = new JLabel("Ofertas Actuales");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(50, 420, 330, 82);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\"\"");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_5.setBounds(520, 420, 330, 82);
		add(lblNewLabel_5);
	}
	
	/*
	public void cargarInformacionGeneral(Supermercado datos)
	{
		lblCantidadUusarios.setText("" + datos.cantidadUsuarios());
		lblCantidadProductos.setText("" + datos.cantidadCategorias());
		
	}
	*/
}
