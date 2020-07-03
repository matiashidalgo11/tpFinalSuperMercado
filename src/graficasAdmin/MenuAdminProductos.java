package graficasAdmin;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Excepciones.CamposVacios;
import Excepciones.ProductoYaExiste;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Bebida;
import Productos.Congelado;
import Productos.Golosina;
import Productos.Lacteo;
import Productos.Limpieza;
import Productos.Perfumeria;
import Productos.Producto;
import Productos.Snack;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MenuAdminProductos extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAgregarProducto;
	private JButton btnListaProductos;
	public CardLayout controlProductoMenu = new CardLayout();
	private Supermercado datos;
	
	public static String AGREGARPRODUCTO_REFERENCIA = "agregarProducto";
	public SubMenuAgregarProducto agregarP;
	
	public static String LISTAPRODUCTOS_REFERENCIA = "listaProductos";
	public SubMenuListaProductos listaP;
	
	public static String MODIFICARPRODUCTO_REFERENCIA = "modificarProducto";
	public SubMenuModificarProducto modificarP;
	
	
	/**
	 * Create the panel.
	 */
	public MenuAdminProductos(Supermercado datos) {
		this.datos = datos;
		initComponents();
		accionesBotones();
		agregarProducto();
	}

	private void initComponents() {

		listaP = new SubMenuListaProductos(datos);
		jpopuMenuAccionesListaProductos();
		agregarP = new SubMenuAgregarProducto();
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
	
	public void agregarProducto()
	{
		agregarP.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
						agregarP.verificacionDeCampos();
						Producto nuevo = agregarP.crearProducto();
						
						if(datos.agregarProducto(nuevo))
						{
							JOptionPane.showMessageDialog(panel, "Se agrego el Producto Correctamente");
							listaP.limpiarLista();
							listaP.cargarLista(datos);
							agregarP.limpiarCampos();
							
						}else
						{
							JOptionPane.showMessageDialog(panel, "No se agrego el Producto");
						}

				} catch (CamposVacios cam) {
					cam.printStackTrace();
				} catch (ProductoYaExiste e1) {
					e1.printStackTrace();
				}

		
			}
		});
	}
	
	public void jpopuMenuAccionesListaProductos()
	{
		listaP.itemEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				int seleccionTabla = listaP.table.getSelectedRow();
				long id = (long) listaP.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaCategorias().existeProducto(id))
				{
					Producto aux = datos.getListaCategorias().buscarProducto(id);
					int valor = JOptionPane.showConfirmDialog(panel, "Desea Eliminar el Producto ?", "Eliminar", 2);
					if(valor == 0)
					{
						datos.eliminarProducto(id);
						listaP.limpiarLista();
						listaP.cargarLista(datos);
					}
				}
				
			
			}
		});
		
		
		listaP.itemModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int seleccionTabla = listaP.table.getSelectedRow();
				long id = (long) listaP.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaCategorias().existeProducto(id))
				{
					Producto aux = datos.getListaCategorias().buscarProducto(id);
					modificarP = new SubMenuModificarProducto(aux);
					itemMenuModificarProductoSalirAccion();
					panel.add(modificarP,MODIFICARPRODUCTO_REFERENCIA);
					controlProductoMenu.show(panel, MODIFICARPRODUCTO_REFERENCIA);
	
				}else
				{
					JOptionPane.showMessageDialog(panel, "Producto Inexistente");
				}
				
				
				
			}
			});
		
		
			
	
		
	
	
	}
	
	/**
	 * Funcion que le agrega la Accion de actualizar los datos a la hora de salir de Modificar Producto
	 */
	private void itemMenuModificarProductoSalirAccion()
	{
		modificarP.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seleccion = JOptionPane.showConfirmDialog(null, "Finalizar Modificaciones ? ", "Modificar Producto", JOptionPane.YES_NO_OPTION);
				if (seleccion == JOptionPane.YES_OPTION) {
				    
					listaP.limpiarLista();
					listaP.cargarLista(datos);
					agregarP.limpiarCampos();
				    controlProductoMenu.show(panel, LISTAPRODUCTOS_REFERENCIA);
				    
				} 
				
				
			}
		});
	}
	
	
	
	
	
	
	
	
}
