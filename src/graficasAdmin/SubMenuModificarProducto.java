package graficasAdmin;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Excepciones.CamposVacios;
import Productos.Bebida;
import Productos.Congelado;
import Productos.Golosina;
import Productos.Lacteo;
import Productos.Limpieza;
import Productos.Perfumeria;
import Productos.Producto;
import Productos.Snack;

public class SubMenuModificarProducto extends JPanel {

	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	 JTextField txtNombre;
	 JTextField txtPrecio;
	 JTextField txtMarca;
	 JTextField txtStockInicial;
	private JLabel lblNewLabel_4;
	JComboBox<String> cmbCategoria;
	private DefaultComboBoxModel<String> modeloBoxCategoria;
	private JPanel panelAtributos;
	JButton btnSalir;
	private JPanel Bebidas;
	private JLabel Gasificada;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	public JRadioButton rdbtnSiGasificada;
	public JRadioButton rdbtnNoGasificada;
	public JRadioButton rdbtnNoAlcohol;
	public JRadioButton rdbtnSiAlcohol;
	JTextField textLitros;
	JTextField textGusto;
	private JPanel Congelado;
	private JLabel lblNewLabel_5;
	JTextField textPesoCongelado;
	private JPanel Golisinas;
	private JLabel lblNewLabel_9;
	JTextField textUnidades;
	private JPanel Lacteos;
	private JLabel lblNewLabel_10;
	public JTextField textTipoLacteo;
	private JPanel Limpieza;
	private JLabel lblNewLabel_11;
	JTextField textDescripcionLimpieza;
	private JPanel Perfumeria;
	private JLabel lblNewLabel_12;
	JTextField textFragancia;
	private JPanel Snack;
	private JLabel lblNewLabel_13;
	JTextField textPesoGrm;
	private JLabel lblNewLabel_14;
	private CardLayout controlPanelAtributo = new CardLayout();

	
	public static String BEBIDAS_REFERENCIA = "Bebida";
	public static String CONGELADO_REFERENCIA = "Congelado";
	public static String GOLOSINAS_REFERENCIA = "Golosina";
	public static String LACTEOS_REFERENCIA = "Lacteo";
	public static String LIMPIEZA_REFERENCIA = "Limpieza";
	public static String PERFUMERIA_REFERENCIA = "Perfumeria";
	public static String SNACK_REFERENCIA = "Snack";
	public final ButtonGroup grupoGasificada = new ButtonGroup();
	public final ButtonGroup grupoAlcohol = new ButtonGroup();
	private JLabel lblNewLabel_15;
	public JTextField textDescripcionGolosina;
	public Producto dato;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtPrecioOferta;
	private JCheckBox chckbxActivarOferta;
	private JButton btnEditarNombre;
	private JButton btnEditarMarca;
	private JButton btnEditarStockInicial;
	private JButton btnEditarPrecio;
	private JButton btnEditarOferta;
	private JButton btnEditarPrecioOferta;
	private JButton btnEditarAtributoCategoria;

	/**
	 * Create the panel.
	 */
	public SubMenuModificarProducto(Producto dato) {

		this.dato = dato;
		initComponents();
		llenarComponentesConElDato();
		accionLimpiarCampos();
		accionesBotonesEditar();
	}
	
	private void initComponents() {
		
		setBounds(159, 90, 724, 588);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 724, 588);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(86, 11, 269, 50);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(86, 194, 269, 29);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_16 = new JLabel("Activar Oferta");
		lblNewLabel_16.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_16.setBounds(86, 234, 216, 29);
		panel.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("PrecioOferta");
		lblNewLabel_17.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_17.setBounds(86, 278, 269, 29);
		panel.add(lblNewLabel_17);
		
		txtPrecioOferta = new JTextField(""+ dato.getPrecioOferta());
		txtPrecioOferta.setEnabled(false);
		txtPrecioOferta.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtPrecioOferta.setBounds(365, 278, 139, 29);
		panel.add(txtPrecioOferta);
		
		chckbxActivarOferta = new JCheckBox();
		chckbxActivarOferta.setEnabled(false);
		chckbxActivarOferta.setSelected(dato.isOferta());
		chckbxActivarOferta.setBounds(365, 240, 97, 23);
		panel.add(chckbxActivarOferta);
		
		lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_2.setBounds(86, 72, 269, 50);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Stock Inicial");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_3.setBounds(86, 133, 269, 50);
		panel.add(lblNewLabel_3);
		
		
		txtNombre = new JTextField(dato.getNombre());
		txtNombre.setEnabled(false);
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombre.setBounds(365, 12, 269, 50);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		

		txtPrecio = new JTextField(""+dato.getPrecio());
		txtPrecio.setEnabled(false);
		txtPrecio.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(365, 191, 269, 29);
		panel.add(txtPrecio);
		
		txtMarca = new JTextField(dato.getMarca());
		txtMarca.setEnabled(false);
		txtMarca.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtMarca.setColumns(10);
		txtMarca.setBounds(365, 73, 269, 50);
		panel.add(txtMarca);
		
		txtStockInicial = new JTextField(""+dato.getStock());
		txtStockInicial.setEnabled(false);
		txtStockInicial.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtStockInicial.setColumns(10);
		txtStockInicial.setBounds(365, 130, 269, 50);
		panel.add(txtStockInicial);
		
		lblNewLabel_4 = new JLabel("Categoria");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(86, 318, 269, 29);
		panel.add(lblNewLabel_4);
		
		cmbCategoria = new JComboBox<String>();
		cmbCategoria.setEnabled(false);
		modeloBoxCategoria = new DefaultComboBoxModel<String>();
		modeloBoxCategoria.addElement(BEBIDAS_REFERENCIA);
		modeloBoxCategoria.addElement(CONGELADO_REFERENCIA);
		modeloBoxCategoria.addElement(GOLOSINAS_REFERENCIA );
		modeloBoxCategoria.addElement(LACTEOS_REFERENCIA );
		modeloBoxCategoria.addElement(LIMPIEZA_REFERENCIA );
		modeloBoxCategoria.addElement(PERFUMERIA_REFERENCIA );
		modeloBoxCategoria.addElement(SNACK_REFERENCIA );
		cmbCategoria.setModel(modeloBoxCategoria);
		cmbCategoria.setFont(new Font("Calibri", Font.PLAIN, 23));
		cmbCategoria.setBounds(366, 318, 269, 29);
		
		cmbCategoria.setSelectedItem(dato.getNombreCategoria());
		panel.add(cmbCategoria);;
		
		
		panelAtributos = new JPanel();
		panelAtributos.setBounds(86, 358, 548, 165);
		panel.add(panelAtributos);
		panelAtributos.setLayout(controlPanelAtributo);
		
		Bebidas = new JPanel();
		panelAtributos.add(Bebidas, BEBIDAS_REFERENCIA);
		Bebidas.setLayout(null);
		
		Gasificada = new JLabel("Gasificada");
		Gasificada.setBounds(10, 11, 261, 29);
		Gasificada.setFont(new Font("Calibri", Font.BOLD, 20));
		Bebidas.add(Gasificada);
		
		lblNewLabel_6 = new JLabel("Litros");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_6.setBounds(10, 51, 261, 29);
		Bebidas.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Gusto");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 91, 261, 29);
		Bebidas.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Alcohol");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_8.setBounds(10, 125, 261, 29);
		Bebidas.add(lblNewLabel_8);
		
		rdbtnSiGasificada = new JRadioButton("Si");
		rdbtnSiGasificada.setEnabled(false);
		grupoGasificada.add(rdbtnSiGasificada);
		rdbtnSiGasificada.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnSiGasificada.setBounds(277, 14, 56, 23);
		Bebidas.add(rdbtnSiGasificada);
		
		rdbtnNoGasificada = new JRadioButton("No");
		rdbtnNoGasificada.setEnabled(false);
		grupoGasificada.add(rdbtnNoGasificada);
		rdbtnNoGasificada.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnNoGasificada.setBounds(335, 14, 70, 23);
		Bebidas.add(rdbtnNoGasificada);
		
		rdbtnNoAlcohol = new JRadioButton("No");
		rdbtnNoAlcohol.setEnabled(false);
		grupoAlcohol.add(rdbtnNoAlcohol);
		rdbtnNoAlcohol.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnNoAlcohol.setBounds(333, 128, 72, 23);
		Bebidas.add(rdbtnNoAlcohol);
		
		rdbtnSiAlcohol = new JRadioButton("Si");
		rdbtnSiAlcohol.setEnabled(false);
		grupoAlcohol.add(rdbtnSiAlcohol);
		rdbtnSiAlcohol.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnSiAlcohol.setBounds(275, 127, 56, 23);
		Bebidas.add(rdbtnSiAlcohol);
		
		textLitros = new JTextField();
		textLitros.setEnabled(false);
		textLitros.setFont(new Font("Calibri", Font.PLAIN, 19));
		textLitros.setBounds(277, 51, 128, 24);
		Bebidas.add(textLitros);
		textLitros.setColumns(10);
		
		textGusto = new JTextField();
		textGusto.setEnabled(false);
		textGusto.setFont(new Font("Calibri", Font.PLAIN, 19));
		textGusto.setBounds(277, 91, 128, 24);
		Bebidas.add(textGusto);
		textGusto.setColumns(10);
		
		Congelado = new JPanel();
		panelAtributos.add(Congelado, CONGELADO_REFERENCIA);
		Congelado.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Peso");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 54, 259, 29);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		Congelado.add(lblNewLabel_5);
		
		textPesoCongelado = new JTextField();
		textPesoCongelado.setEnabled(false);
		textPesoCongelado.setFont(new Font("Calibri", Font.PLAIN, 23));
		textPesoCongelado.setColumns(10);
		textPesoCongelado.setBounds(279, 54, 128, 29);
		Congelado.add(textPesoCongelado);
		
		Golisinas = new JPanel();
		panelAtributos.add(Golisinas, GOLOSINAS_REFERENCIA);
		Golisinas.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Unidades");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_9.setBounds(10, 59, 259, 29);
		Golisinas.add(lblNewLabel_9);
		
		textUnidades = new JTextField();
		textUnidades.setEnabled(false);
		textUnidades.setFont(new Font("Calibri", Font.PLAIN, 23));
		textUnidades.setColumns(10);
		textUnidades.setBounds(279, 57, 78, 32);
		Golisinas.add(textUnidades);
		
		lblNewLabel_15 = new JLabel("Descripcion");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_15.setBounds(10, 99, 259, 29);
		Golisinas.add(lblNewLabel_15);
		
		textDescripcionGolosina = new JTextField();
		textDescripcionGolosina.setEnabled(false);
		textDescripcionGolosina.setFont(new Font("Calibri", Font.PLAIN, 23));
		textDescripcionGolosina.setColumns(10);
		textDescripcionGolosina.setBounds(279, 100, 228, 32);
		Golisinas.add(textDescripcionGolosina);
		
		Lacteos = new JPanel();
		panelAtributos.add(Lacteos, LACTEOS_REFERENCIA);
		Lacteos.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Tipo");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_10.setBounds(10, 11, 249, 29);
		Lacteos.add(lblNewLabel_10);
		
		textTipoLacteo = new JTextField();
		textTipoLacteo.setEnabled(false);
		textTipoLacteo.setFont(new Font("Calibri", Font.PLAIN, 23));
		textTipoLacteo.setBounds(269, 14, 269, 29);
		Lacteos.add(textTipoLacteo);
		
		Limpieza = new JPanel();
		panelAtributos.add(Limpieza, LIMPIEZA_REFERENCIA);
		Limpieza.setLayout(null);
		
		lblNewLabel_11 = new JLabel("Descripcion");
		lblNewLabel_11.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_11.setBounds(10, 58, 249, 29);
		Limpieza.add(lblNewLabel_11);
		
		textDescripcionLimpieza = new JTextField();
		textDescripcionLimpieza.setEnabled(false);
		textDescripcionLimpieza.setBounds(269, 58, 269, 29);
		Limpieza.add(textDescripcionLimpieza);
		textDescripcionLimpieza.setColumns(10);
		
		Perfumeria = new JPanel();
		panelAtributos.add(Perfumeria, PERFUMERIA_REFERENCIA);
		Perfumeria.setLayout(null);
		
		lblNewLabel_12 = new JLabel("Fragancia");
		lblNewLabel_12.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_12.setBounds(10, 50, 232, 29);
		Perfumeria.add(lblNewLabel_12);
		
		textFragancia = new JTextField();
		textFragancia.setEnabled(false);
		textFragancia.setBounds(252, 50, 286, 29);
		Perfumeria.add(textFragancia);
		textFragancia.setColumns(10);
		
		Snack = new JPanel();
		panelAtributos.add(Snack, SNACK_REFERENCIA);
		Snack.setLayout(null);
		
		lblNewLabel_13 = new JLabel("Peso");
		lblNewLabel_13.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_13.setBounds(10, 46, 138, 29);
		Snack.add(lblNewLabel_13);
		
		textPesoGrm = new JTextField();
		textPesoGrm.setEnabled(false);
		textPesoGrm.setBounds(158, 46, 86, 29);
		Snack.add(textPesoGrm);
		textPesoGrm.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Gramos");
		lblNewLabel_14.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_14.setBounds(254, 46, 138, 29);
		Snack.add(lblNewLabel_14);
		
		
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(239, 534, 155, 23);
		panel.add(btnSalir);
		
		btnEditarNombre = new JButton("New button");
		btnEditarNombre.setBounds(668, 25, 35, 23);
		panel.add(btnEditarNombre);
		
		btnEditarMarca = new JButton("New button");
		btnEditarMarca.setBounds(668, 86, 35, 23);
		panel.add(btnEditarMarca);
		
		btnEditarStockInicial = new JButton("New button");
		btnEditarStockInicial.setBounds(668, 133, 35, 23);
		panel.add(btnEditarStockInicial);
		
		btnEditarPrecio = new JButton("New button");
		btnEditarPrecio.setBounds(668, 191, 35, 23);
		panel.add(btnEditarPrecio);
		
		btnEditarOferta = new JButton("New button");
		btnEditarOferta.setBounds(668, 237, 35, 23);
		panel.add(btnEditarOferta);
		
		btnEditarPrecioOferta = new JButton("New button");
		btnEditarPrecioOferta.setBounds(668, 281, 35, 23);
		panel.add(btnEditarPrecioOferta);
		
		btnEditarAtributoCategoria = new JButton("New button");
		btnEditarAtributoCategoria.setBounds(644, 359, 35, 23);
		panel.add(btnEditarAtributoCategoria);

		
		
	}

	public void llenarComponentesConElDato()
	{
		if(cmbCategoria.getSelectedItem().equals(BEBIDAS_REFERENCIA))
		{
			Bebida camuflaje = (Bebida) dato;
			
			llenarCamposGasificadaAlcohol(camuflaje.isGasificada(), camuflaje.isAlcohol());
			textLitros.setText(""+camuflaje.getLitros());
			textGusto.setText(camuflaje.getGusto());
			
			controlPanelAtributo.show(panelAtributos, BEBIDAS_REFERENCIA); 
			
		}else if(cmbCategoria.getSelectedItem().equals(CONGELADO_REFERENCIA))
		{
			
			Congelado camuflaje = (Congelado) dato;
			
			textPesoCongelado.setText("" + camuflaje.getPeso());
			
			controlPanelAtributo.show(panelAtributos, CONGELADO_REFERENCIA);
			
		}else if(cmbCategoria.getSelectedItem().equals(GOLOSINAS_REFERENCIA))
		{
			
			Golosina camuflaje = (Golosina) dato;
			
			textDescripcionGolosina.setText(camuflaje.getDescripcion());
			textUnidades.setText(""+camuflaje.getCantidad());

			controlPanelAtributo.show(panelAtributos, GOLOSINAS_REFERENCIA);
		}
		else if(cmbCategoria.getSelectedItem().equals(LACTEOS_REFERENCIA))
		{
			
			Lacteo camuflaje = (Lacteo) dato;
			
			textTipoLacteo.setText(camuflaje.getTipo());
			
			controlPanelAtributo.show(panelAtributos, LACTEOS_REFERENCIA);
		}
		else if(cmbCategoria.getSelectedItem().equals(LIMPIEZA_REFERENCIA))
		{
			Limpieza camuflaje = (Limpieza) dato;
			
			textDescripcionLimpieza.setText(camuflaje.getTipo());
			
			controlPanelAtributo.show(panelAtributos, LIMPIEZA_REFERENCIA);
		}
		else if(cmbCategoria.getSelectedItem().equals(PERFUMERIA_REFERENCIA))
		{
			Perfumeria camuflaje = (Perfumeria) dato;
			
			textFragancia.setText(camuflaje.getTipoFragancia());
			
			controlPanelAtributo.show(panelAtributos, PERFUMERIA_REFERENCIA);
		}
		else if(cmbCategoria.getSelectedItem().equals(SNACK_REFERENCIA))
		{
			Snack camuflaje = (Snack) dato;
			
			//Atributo descripcion
			textPesoGrm.setText(""+camuflaje.getCantidadG());
			
			controlPanelAtributo.show(panelAtributos, SNACK_REFERENCIA);
		}
	}
	
	public void accionLimpiarCampos()
	{
	}
	
	public void limpiarCampos()
	{
		String nulo = "";
		txtMarca.setText(nulo);
		txtNombre.setText(nulo);
		txtPrecio.setText(nulo);
		txtStockInicial.setText(nulo);
		textDescripcionLimpieza.setText(nulo);
		textFragancia.setText(nulo);
		textGusto.setText(nulo);
		textLitros.setText(nulo);
		textPesoCongelado.setText(nulo);
		textPesoGrm.setText(nulo);
		textUnidades.setText(nulo);
		textTipoLacteo.setText(nulo);
	}
	
	public int contarCamposVacios()
	{
		int contador = 0;
		
		if(txtNombre.getText().isEmpty())
		{
			contador++;
			//errorNombre.setVisible(true);
		}
		if(txtMarca.getText().isEmpty())
		{
			contador++;
			//errorMarca.setVisible(true);
		}
		if(txtPrecio.getText().isEmpty())
		{
			contador++;
			//errorPrecio.setVisible(true);
		}
		if(txtStockInicial.getText().isEmpty())
		{
			contador++;
			//errorStockInicial.setVisible(true);
		}
		
		
		if(cmbCategoria.getSelectedItem().equals(BEBIDAS_REFERENCIA))
		{
			if(textGusto.getText().isEmpty())
			{
				contador++;
			}
			if(textLitros.getText().isEmpty())
			{
				contador++;
			}
			
		}else if(cmbCategoria.getSelectedItem().equals(CONGELADO_REFERENCIA))
		{
			if(textPesoCongelado.getText().isEmpty())
			{
				contador++;
			}
			
		}else if(cmbCategoria.getSelectedItem().equals(GOLOSINAS_REFERENCIA))
		{
			if(textUnidades.getText().isEmpty())
			{
				contador++;
			}
			if(textDescripcionGolosina.getText().isEmpty())
			{
				contador++;
			}
		}
		else if(cmbCategoria.getSelectedItem().equals(LACTEOS_REFERENCIA))
		{
			if(textTipoLacteo.getText().isEmpty())
			{
				contador++;
			}
		}
		else if(cmbCategoria.getSelectedItem().equals(LIMPIEZA_REFERENCIA))
		{
			if(textDescripcionLimpieza.getText().isEmpty())
			{
				contador++;
			}
		}
		else if(cmbCategoria.getSelectedItem().equals(PERFUMERIA_REFERENCIA))
		{
			if(textFragancia.getText().isEmpty())
			{
				contador++;
			}
		}
		else if(cmbCategoria.getSelectedItem().equals(SNACK_REFERENCIA))
		{
			if(textPesoGrm.getText().isEmpty())
			{
				contador++;
			}
		}
		

		return contador;
	}
	
	public boolean grupoGasificadaResp()
	{
		boolean resp;
		if(grupoGasificada.isSelected(rdbtnSiGasificada.getModel()))
		{
			resp = true;
		}else
		{
			resp = false;
		}
		
		return resp;
	}
	
	public boolean grupoAlcoholResp()
	{
		boolean resp;
		if(grupoAlcohol.isSelected(rdbtnSiAlcohol.getModel()))
		{
			resp = true;
		}else
		{
			resp = false;
		}
		
		return resp;
	}
	
	public void verificacionDeCampos() throws CamposVacios
	{
		if (txtNombre.getText().isEmpty() || txtMarca.getText().isEmpty()
				|| txtPrecio.getText().isEmpty() || txtStockInicial.getText().isEmpty() || (chckbxActivarOferta.isSelected() && txtPrecioOferta.getText().isEmpty())) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());

		} else

		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.BEBIDAS_REFERENCIA) && (textGusto.getText().isEmpty() || textLitros.getText().isEmpty())) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.CONGELADO_REFERENCIA) && textPesoCongelado.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.GOLOSINAS_REFERENCIA) && (textUnidades.getText().isEmpty() || textDescripcionGolosina.getText().isEmpty())) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else
			
			if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.LACTEOS_REFERENCIA) && (textTipoLacteo.getText().isEmpty()))
			{
				throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		}else
		
		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.LIMPIEZA_REFERENCIA) && textDescripcionLimpieza.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.PERFUMERIA_REFERENCIA) && textFragancia.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.SNACK_REFERENCIA) && textPesoGrm.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		}
	}
	
	
	private void llenarCamposGasificadaAlcohol(boolean isGasificada, boolean isAlcohol)
	{
		if(isGasificada)
		{
			grupoGasificada.setSelected(rdbtnSiGasificada.getModel(), true);
			
		}else
		{
			grupoGasificada.setSelected(rdbtnNoGasificada.getModel(), true);
		}
		
		if(isAlcohol)
		{
			grupoAlcohol.setSelected(rdbtnSiAlcohol.getModel(), true);
		}else
		{
			grupoAlcohol.setSelected(rdbtnNoAlcohol.getModel(),true);
		}
	}
	
	private void accionesBotonesEditar() 
	{
		
		btnEditarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
					
					if(txtNombre.isEnabled())
					{
						if(txtNombre.getText().isEmpty())
						{
							throw new CamposVacios("Nombre Vacio", 1);
						}else
						{
							dato.setNombre(txtNombre.getText());
							txtNombre.setEnabled(false);
						}
							
					}else
					{
						txtNombre.setEnabled(true);
					}
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
				}
				
				
			}
		});
		
		btnEditarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
					if(txtMarca.isEnabled())
					{
						if(txtMarca.getText().isEmpty())
						{
							throw new CamposVacios("Marca Vacio", 1);
						}else
						{
							dato.setMarca(txtMarca.getText());
							txtMarca.setEnabled(false);
						}
							
					}else
					{
						txtMarca.setEnabled(true);
					}
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
				}
			}
		});
		
		btnEditarStockInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{
					
					if(txtStockInicial.isEnabled())
					{
						if(txtStockInicial.getText().isEmpty())
						{
							throw new CamposVacios("Stock Inicial Vacio", 1);
						}else
						{
							dato.setNombre(txtStockInicial.getText());
							txtStockInicial.setEnabled(false);
						}
							
					}else
					{
						txtStockInicial.setEnabled(true);
					}
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
				}
				
				
			}
		});
		
		btnEditarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try
				{
					
					if(txtPrecio.isEnabled())
					{
						if(txtPrecio.getText().isEmpty())
						{
							throw new CamposVacios("Precio Vacio", 1);
						}else
						{
							Double precio = Double.parseDouble(txtPrecio.getText());
							dato.setPrecio(precio);
							txtPrecio.setEnabled(false);
						}
							
					}else
					{
						txtPrecio.setEnabled(true);
					}
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
				}
			}
		});
		
		btnEditarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					if(chckbxActivarOferta.isEnabled())
					{	
							dato.setOferta(chckbxActivarOferta.isSelected());
							txtPrecio.setEnabled(false);
							
					}else
					{
						txtPrecio.setEnabled(true);
					}
				
			
			}
			
		});
		
		btnEditarPrecioOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					if(txtPrecioOferta.isEnabled())
					{
						if(txtPrecioOferta.getText().isEmpty())
						{
							throw new CamposVacios("Precio Oferta Vacio", 1);
						}else
						{
							Double precio = Double.parseDouble(txtPrecioOferta.getText());
							dato.setPrecioOferta(precio);
							txtPrecioOferta.setEnabled(false);
						}
							
					}else
					{
						txtPrecioOferta.setEnabled(true);
					}
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
				}
				
			}
		});
		
		
		//Analiza el atributo de CadaPanel
		btnEditarAtributoCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					verificacionDeCampos();
					
					if(cmbCategoria.getSelectedItem().equals(BEBIDAS_REFERENCIA))
					{
						if(textGusto.isEnabled())
						{
							
						Bebida camuflaje = (Bebida) dato;
						camuflaje.setGasificada(grupoGasificadaResp());
						camuflaje.setAlcohol(grupoAlcoholResp());
						
						Double litros = Double.parseDouble(textLitros.getText());
						camuflaje.setLitros(litros);
						camuflaje.setGusto(textGusto.getText());
						
						textGusto.setEnabled(false);
						textLitros.setEnabled(false);
						rdbtnNoAlcohol.setEnabled(false);
						rdbtnSiAlcohol.setEnabled(false);
						rdbtnNoGasificada.setEnabled(false);
						rdbtnSiGasificada.setEnabled(false);
						
						}else
						{
							textGusto.setEnabled(true);
							textLitros.setEnabled(true);
							rdbtnNoAlcohol.setEnabled(true);
							rdbtnSiAlcohol.setEnabled(true);
							rdbtnNoGasificada.setEnabled(true);
							rdbtnSiGasificada.setEnabled(true);
							
						}
						
						
						
						
					}else if(cmbCategoria.getSelectedItem().equals(CONGELADO_REFERENCIA))
					{
						
						if(textPesoCongelado.isEnabled())
						{
							Congelado camuflaje = (Congelado) dato;
							Double peso = Double.parseDouble(textPesoCongelado.getText());
							camuflaje.setPeso(peso);
							
							textPesoCongelado.setEnabled(false);
						}else
						{
							textPesoCongelado.setEnabled(true);
						}
						
						
						
	
						
					}else if(cmbCategoria.getSelectedItem().equals(GOLOSINAS_REFERENCIA))
					{
						
						
						
						if(textUnidades.isEnabled())
						{
							Golosina camuflaje = (Golosina) dato;
							int unidades = Integer.parseInt(textUnidades.getText());
							camuflaje.setCantidad(unidades);
							camuflaje.setDescripcion(textDescripcionGolosina.getText());
							
							textUnidades.setEnabled(false);
							textDescripcionGolosina.setEnabled(false);
							
						}else
						{
							textUnidades.setEnabled(true);
							textDescripcionGolosina.setEnabled(true);
						}
							
					}
					else if(cmbCategoria.getSelectedItem().equals(LACTEOS_REFERENCIA))
					{
						
						
						
						if(textTipoLacteo.isEnabled())
						{
							Lacteo camuflaje = (Lacteo) dato;
							camuflaje.setTipo(textTipoLacteo.getText());
							
							textTipoLacteo.setEnabled(false);
							
						}else
						{
							textTipoLacteo.setEnabled(true);
						}
						
					}
					else if(cmbCategoria.getSelectedItem().equals(LIMPIEZA_REFERENCIA))
					{
						
						
						if(textDescripcionLimpieza.isEnabled())
						{
							Limpieza camuflaje = (Limpieza) dato;
							camuflaje.setTipo(textDescripcionLimpieza.getText());
							
							textDescripcionLimpieza.setEnabled(false);
						}else
						{
							textDescripcionLimpieza.setEnabled(false);
						}
						

					}
					else if(cmbCategoria.getSelectedItem().equals(PERFUMERIA_REFERENCIA))
					{
						if(textFragancia.isEnabled())
						{
							Perfumeria camuflaje = (Perfumeria) dato;
							camuflaje.setTipoFragancia(textFragancia.getText());
							
							textFragancia.setEnabled(false);
						}else
						{
							textFragancia.setEnabled(true);
						}
						
						
					}
					else if(cmbCategoria.getSelectedItem().equals(SNACK_REFERENCIA))
					{
						if(textPesoGrm.isEnabled())
						{
							Snack camuflaje = (Snack) dato;
							Double cantidad = Double.parseDouble(textPesoGrm.getText());
							camuflaje.setCantidadG(cantidad);
							
							textPesoGrm.setEnabled(false);
						}else
						{
							textPesoGrm.setEnabled(true);
						}
						
					}
					
				}catch(CamposVacios msg)
				{
					msg.printStackTrace();
					JOptionPane optionPane = new JOptionPane(msg.getMessage(), JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("Campos Vacios");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
				
				
			}
		});
	
	}
	
	/*
	public void mostrarPanelAtributoComboBox()
	{
		cmbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbCategoria.getSelectedItem().equals(BEBIDAS_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, BEBIDAS_REFERENCIA);
					
				}else if(cmbCategoria.getSelectedItem().equals(CONGELADO_REFERENCIA))
				{
					System.out.println("ENTRO A cONGELADO");
					controlPanelAtributo.show(panelAtributos, CONGELADO_REFERENCIA);
					
				}else if(cmbCategoria.getSelectedItem().equals(GOLOSINAS_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, GOLOSINAS_REFERENCIA);
				}
				else if(cmbCategoria.getSelectedItem().equals(LACTEOS_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, LACTEOS_REFERENCIA);
				}
				else if(cmbCategoria.getSelectedItem().equals(LIMPIEZA_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, LIMPIEZA_REFERENCIA);
				}
				else if(cmbCategoria.getSelectedItem().equals(PERFUMERIA_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, PERFUMERIA_REFERENCIA);
				}
				else if(cmbCategoria.getSelectedItem().equals(SNACK_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, SNACK_REFERENCIA);
				}
			}
		});
	}
	*/
	
	/*public Producto crearProducto() throws NullPointerException
	{
		Producto nuevo = null;
		
		if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.BEBIDAS_REFERENCIA))
		{
			double litros = Double.parseDouble(textLitros.getText());
			nuevo = new Bebida(grupoGasificadaResp(), litros, textGusto.getText(), grupoAlcoholResp());
			
		}else if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.CONGELADO_REFERENCIA))
		{
			double peso = Double.parseDouble(textPesoCongelado.getText());
			nuevo = new Congelado(peso);
			
		}else if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.GOLOSINAS_REFERENCIA))
		{
			int unidades = Integer.parseInt(textUnidades.getText());
			nuevo = new Golosina(unidades, textDescripcionGolosina.getText());
		}
		else if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.LACTEOS_REFERENCIA))
		{
			
			nuevo = new Lacteo(textTipoLacteo.getText());
		}
		else if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.LIMPIEZA_REFERENCIA))
		{
			
			nuevo = new Limpieza(textDescripcionLimpieza.getText());
		}
		else if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.PERFUMERIA_REFERENCIA))
		{
			
			nuevo = new Perfumeria(textFragancia.getText());
		}
		else  if(cmbCategoria.getSelectedItem().equals(SubMenuAgregarProducto.SNACK_REFERENCIA)){
				double pesoGramos = Double.parseDouble(textPesoGrm.getText());
				nuevo = new Snack(pesoGramos);
		}else
			{
					throw new NullPointerException();	
			}
			
		
		//Agregar categoria Descripcion a Productos ?)
		
		//Se termina de Construir el Producto
		double precio = Double.parseDouble(txtPrecio.getText());
		long stock = Long.parseLong(txtStockInicial.getText());
		nuevo.setNombre(txtNombre.getText());
		nuevo.setPrecio(precio);
		nuevo.setMarca(txtMarca.getText());
		nuevo.setStock(stock);
		
		return nuevo;
	}
	*/
	
	
	
}

