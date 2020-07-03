package graficasAdmin;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Objetos.Supermercado;

public class MenuAdminOfertas extends JPanel {
	private Supermercado datos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public MenuAdminOfertas(Supermercado datos) {

		this.datos = datos;
		initComponents();
	}
	private void initComponents() {
	
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		lblNewLabel = new JLabel("Crear Oferta");
		lblNewLabel.setBounds(71, 44, 117, 27);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Productos ");
		lblNewLabel_1.setBounds(119, 223, 46, 14);
		add(lblNewLabel_1);
	}
	
	
	public void cargarInformacionGeneral(Supermercado datos)
	{
		
		
	}
}
