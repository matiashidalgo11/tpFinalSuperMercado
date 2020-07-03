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
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MenuAdminProductos extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
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
		setBackground(SystemColor.text);
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
		panel.add(listaP,LISTAPRODUCTOS_REFERENCIA);
		panel.add(agregarP,AGREGARPRODUCTO_REFERENCIA);
		
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
		
		
		listaP.itemAgregarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seleccionTabla = listaP.table.getSelectedRow();
				long id = (long) listaP.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaCategorias().existeProducto(id))
				{
					Producto aux = datos.getListaCategorias().buscarProducto(id);
					
					try
					{
						String stockString = JOptionPane.showInputDialog("Introduzca Stock a sumar:");
						long stockSuma = Long.parseLong(stockString);
						
						aux.sumarStock(stockSuma);
						listaP.limpiarLista();
						listaP.cargarLista(datos);
						
						
						
					}catch(NumberFormatException num)
					{
						JOptionPane.showMessageDialog(null,"Ingrese una cantidad para sumar al Stock","Datos Invalidos",JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}
				
			}
		});
		
		listaP.itemActivarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int seleccionTabla = listaP.table.getSelectedRow();
				long id = (long) listaP.table.getValueAt(seleccionTabla, 0);

				if (datos.getListaCategorias().existeProducto(id)) {
					Producto aux = datos.getListaCategorias().buscarProducto(id);
					aux.invertirActivo();
					
					if(aux.isOferta())
					{
						if (aux.getPrecioOferta() == 0) {

							try {

								String precioOfertaString = JOptionPane.showInputDialog("Introduzca precio Oferta:");
								Double precioOferta = Double.parseDouble(precioOfertaString);
								aux.setPrecioOferta(precioOferta);
								

							} catch (NumberFormatException num) {
								JOptionPane.showMessageDialog(null, "Ingrese una cantidad para sumar al Stock",
										"Datos Invalidos", JOptionPane.ERROR_MESSAGE);
							}

						}else
						{
							
							JOptionPane.showMessageDialog(null, "Existe un Precio Oferta Cargado",
									"Producto en Oferta", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}else{
						
						JOptionPane.showMessageDialog(null, "Se Desactivo la Oferta del Producto",
								"Expiro Oferta", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					
					
					listaP.limpiarLista();
					listaP.cargarLista(datos);
				}
			}
		});
		
		listaP.agregarOfertaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int seleccionTabla = listaP.table.getSelectedRow();
				long id = (long) listaP.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaCategorias().existeProducto(id))
				{
					Producto aux = datos.getListaCategorias().buscarProducto(id);
					String marcaOferta = JOptionPane.showInputDialog("Introduzca Marca para crear Oferta:", aux.getMarca());
					
					if (datos.getListaCategorias().existeMarcar(marcaOferta)) {
						try {
						
							if(!(datos.getListaCategorias().marcaEnOferta(marcaOferta)))
							{

								String porcentajeString = JOptionPane.showInputDialog("Introduzca un Entero menor a 100, sera el Porcentaje de Descuento para la Oferta:");
								int porcentaje = Integer.parseInt(porcentajeString);
								datos.establecerOfertaPorMarca(marcaOferta, porcentaje);
		
							
						}else
						{
							//int resp = JOptionPane.showConfirmDialog(null, "Ya se encuentra la Marca en Oferta", "Oferta Existente", JOptionPane.);
							
							Object[] options = { "Cambiar Valor de Oferta", "Quitar Oferta Marca", "Cancelar" };
			                int eleccion = JOptionPane.showOptionDialog(null, "La Marca Ya se encuentra en Oferta", "Oferta Existente",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			                null, options, options[0]);
			                
			                if(eleccion == 0 )//Cambiar Valor de Oferta
			                {
			                	String porcentajeString = JOptionPane.showInputDialog("Introduzca un Entero menor a 100, sera el Nuevo Porcentaje de Descuento:");
								int porcentaje = Integer.parseInt(porcentajeString);
			                	datos.establecerOfertaPorMarca(marcaOferta, porcentaje);
			                	
			                }else if(eleccion == 1)//Quitar Oferta Marca
			                {
			                	datos.quitarOfertaPorMarca(marcaOferta);
			                	
			                }else if(eleccion == 2)//Cancelar
			                {
			                	//
			                }
			                
			                
			                
						}
						
						} catch (NumberFormatException num) {
								JOptionPane.showMessageDialog(null, "Ingrese un Valor Entero para el Porcentaje",
										"Datos Invalidos", JOptionPane.ERROR_MESSAGE);
						}
						
							//Actualizar Datos
							listaP.limpiarLista();
							listaP.cargarLista(datos);
						}

				}else
				{
					JOptionPane.showMessageDialog(panel, "Producto Inexistente");
				}
				
				
				
			}
			});
		
		
			listaP.quitarOfertaMarca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int seleccionTabla = listaP.table.getSelectedRow();
					long id = (long) listaP.table.getValueAt(seleccionTabla, 0);

					if (datos.getListaCategorias().existeProducto(id)) {
						Producto aux = datos.getListaCategorias().buscarProducto(id);
						String marcaOferta = JOptionPane.showInputDialog("Introduzca Marca para Quitar Oferta:",
								aux.getMarca());

						if (datos.getListaCategorias().existeMarcar(marcaOferta)) {
							

								if ((datos.getListaCategorias().marcaEnOferta(marcaOferta))) {

									int eleccion = JOptionPane.showConfirmDialog(null, "Desea quitar la Oferta ?",
											"Marca en Oferta", JOptionPane.YES_NO_OPTION);
									if (eleccion == JOptionPane.YES_OPTION) {
										
										datos.quitarOfertaPorMarca(marcaOferta);
										//Actualizar Datos
										listaP.limpiarLista();
										listaP.cargarLista(datos);
									}

								} else {
									
									JOptionPane.showMessageDialog(null, "La marca no se encuentra en Oferta",
											"Datos Invalidos", JOptionPane.ERROR_MESSAGE);
										
								}

						}

					} else {
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
