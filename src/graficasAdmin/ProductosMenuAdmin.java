package graficasAdmin;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ProductosMenuAdmin extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAgregarProducto;
	private JButton btnListaProductos;
	public CardLayout controlProductoMenu = new CardLayout();
	
	public static String AGREGARPRODUCTO_REFERENCIA = "agregarProducto";
	public AgregarProducto agregarP = new AgregarProducto();
	
	public static String LISTAPRODUCTOS_REFERENCIA = "listaProductos";
	public ListaProductos listaP = new ListaProductos();
	/**
	 * Create the panel.
	 */
	public ProductosMenuAdmin() {

		initComponents();
		accionesBotones();
	}
	private void initComponents() {

		
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(159, 90, 724, 588);
		add(panel);
		panel.setLayout(controlProductoMenu);
		panel.add(agregarP,AGREGARPRODUCTO_REFERENCIA);
		panel.add(listaP,LISTAPRODUCTOS_REFERENCIA);
		
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(893, 286, 149, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 286, 149, 14);
		add(lblNewLabel_1);
		
		btnAgregarProducto = new JButton("Agregar Producto");
		
		
		
		btnAgregarProducto.setBounds(159, 21, 362, 58);
		add(btnAgregarProducto);
		
		btnListaProductos = new JButton("Lista Productos");
		
		
		btnListaProductos.setBounds(521, 21, 362, 58);
		add(btnListaProductos);
	}
	
	public void accionesBotones()
	{
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlProductoMenu.show(panel, AGREGARPRODUCTO_REFERENCIA);
			}
		});
		
		btnListaProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlProductoMenu.show(panel, LISTAPRODUCTOS_REFERENCIA);
			}
		});
	}
}
