package graficasAdmin;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Excepciones.CamposVacios;
import Excepciones.ProductoYaExiste;
import Objetos.Supermercado;
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

public class ProductosMenuAdmin extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAgregarProducto;
	private JButton btnListaProductos;
	public CardLayout controlProductoMenu = new CardLayout();
	private Supermercado datos;
	
	public static String AGREGARPRODUCTO_REFERENCIA = "agregarProducto";
	public AgregarProducto agregarP;
	
	public static String LISTAPRODUCTOS_REFERENCIA = "listaProductos";
	public ListaProductos listaP;
	/**
	 * Create the panel.
	 */
	public ProductosMenuAdmin(Supermercado datos) {
		this.datos = datos;
		initComponents();
		accionesBotones();
		agregarProducto();
	}
	private void initComponents() {

		listaP = new ListaProductos(datos);
		agregarP = new AgregarProducto();
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
						//Si encuentra algun campo Vacio lanza la Excepcion
						agregarP.verificacionDeCampos();
					
						Producto nuevo = null;
						
						if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.BEBIDAS_REFERENCIA))
						{
							double litros = Double.parseDouble(agregarP.textLitros.getText());
							nuevo = new Bebida(agregarP.grupoGasificadaResp(), litros, agregarP.textGusto.getText(), agregarP.grupoAlcoholResp());
							
						}else if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.CONGELADO_REFERENCIA))
						{
							double peso = Double.parseDouble(agregarP.textPesoCongelado.getText());
							nuevo = new Congelado(peso);
							
						}else if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.GOLOSINAS_REFERENCIA))
						{
							int unidades = Integer.parseInt(agregarP.textUnidades.getText());
							nuevo = new Golosina(unidades, agregarP.textDescripcionGolosina.getText());
						}
						else if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.LACTEOS_REFERENCIA))
						{
							//Llenar el comboBox con los Tipos de Lacteo
							String tipo = (String) agregarP.cmbTipoLacteo.getSelectedItem();
							nuevo = new Lacteo(tipo);
						}
						else if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.LIMPIEZA_REFERENCIA))
						{
							
							nuevo = new Limpieza(agregarP.textDescripcionLimpieza.getText());
						}
						else if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.PERFUMERIA_REFERENCIA))
						{
							
							nuevo = new Perfumeria(agregarP.textFragancia.getText());
						}
						else 
						      if(agregarP.cmbCategoria.getSelectedItem().equals(AgregarProducto.SNACK_REFERENCIA)){
								double pesoGramos = Double.parseDouble(agregarP.textPesoGrm.getText());
								nuevo = new Snack(pesoGramos);
									}
							
						
						//Agregar categoria Descripcion a Productos ?)
						
						//Se termina de Construir el Producto
						double precio = Double.parseDouble(agregarP.txtPrecio.getText());
						long stock = Long.parseLong(agregarP.txtStockInicial.getText());
						nuevo.setNombre(agregarP.txtNombre.getText());
						nuevo.setPrecio(precio);
						nuevo.setMarca(agregarP.txtMarca.getText());
						nuevo.setStock(stock);
						
						
						//Se agregar a la clase Principal Supermercado
						if(datos.agregarProducto(nuevo))
						{
							JOptionPane.showMessageDialog(panel, "Se agrego el Producto Correctamente");
							listaP.limpiarLista();
							listaP.cargarLista(datos);
							agregarP.limpiarCampos();
							
						}else
						{
							JOptionPane.showMessageDialog(panel, "No se agrego el Producto Correctamente");
						}
						
						
						
						
						
					

				} catch (CamposVacios cam) {
					cam.printStackTrace();
				} catch (ProductoYaExiste e1) {
					e1.printStackTrace();
				}

					//Ningun campo Vacio	//Desarrollar Modularizacion
						
					
				
			}
		});
	}
	
	
	
	
}
