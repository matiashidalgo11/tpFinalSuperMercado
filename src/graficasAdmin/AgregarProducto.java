package graficasAdmin;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Excepciones.CamposVacios;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AgregarProducto extends JPanel {
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
	JComboBox cmbCategoria;
	private DefaultComboBoxModel<String> modeloBoxCategoria;
	private JPanel panelAtributos;
	JButton btnAgregar;
	private JButton btnLimpiarCampos;
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
	public JComboBox cmbTipoLacteo;
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
	public static String GOLOSINAS_REFERENCIA = "Golosinas";
	public static String LACTEOS_REFERENCIA = "Lacteos";
	public static String LIMPIEZA_REFERENCIA = "Limpieza";
	public static String PERFUMERIA_REFERENCIA = "Perfumeria";
	public static String SNACK_REFERENCIA = "Snack";
	public final ButtonGroup grupoGasificada = new ButtonGroup();
	public final ButtonGroup grupoAlcohol = new ButtonGroup();
	private JLabel errorNombre;
	private JLabel errorMarca;
	private JLabel errorPrecio;
	private JLabel errorStockInicial;
	private JLabel lblNewLabel_15;
	public JTextField textDescripcionGolosina;

	/**
	 * Create the panel.
	 */
	public AgregarProducto() {

		initComponents();
		mostrarPanelAtributoComboBox();
		accionLimpiarCampos();
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
		lblNewLabel.setBounds(86, 46, 269, 50);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(86, 107, 269, 50);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_2.setBounds(86, 168, 269, 50);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Stock Inicial");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_3.setBounds(86, 229, 269, 50);
		panel.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombre.setBounds(365, 46, 269, 50);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(365, 107, 269, 50);
		panel.add(txtPrecio);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtMarca.setColumns(10);
		txtMarca.setBounds(365, 168, 269, 50);
		panel.add(txtMarca);
		
		txtStockInicial = new JTextField();
		txtStockInicial.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtStockInicial.setColumns(10);
		txtStockInicial.setBounds(365, 229, 269, 50);
		panel.add(txtStockInicial);
		
		lblNewLabel_4 = new JLabel("Categoria");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(86, 290, 269, 29);
		panel.add(lblNewLabel_4);
		
		cmbCategoria = new JComboBox();
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
		cmbCategoria.setBounds(365, 290, 269, 29);
		panel.add(cmbCategoria);;
		
		panelAtributos = new JPanel();
		panelAtributos.setBounds(86, 330, 548, 165);
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
		grupoGasificada.add(rdbtnSiGasificada);
		rdbtnSiGasificada.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnSiGasificada.setBounds(277, 14, 56, 23);
		Bebidas.add(rdbtnSiGasificada);
		
		rdbtnNoGasificada = new JRadioButton("No");
		grupoGasificada.add(rdbtnNoGasificada);
		rdbtnNoGasificada.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnNoGasificada.setBounds(335, 14, 70, 23);
		Bebidas.add(rdbtnNoGasificada);
		
		rdbtnNoAlcohol = new JRadioButton("No");
		grupoAlcohol.add(rdbtnNoAlcohol);
		rdbtnNoAlcohol.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnNoAlcohol.setBounds(333, 128, 72, 23);
		Bebidas.add(rdbtnNoAlcohol);
		
		rdbtnSiAlcohol = new JRadioButton("Si");
		grupoAlcohol.add(rdbtnSiAlcohol);
		rdbtnSiAlcohol.setFont(new Font("Calibri", Font.BOLD, 20));
		rdbtnSiAlcohol.setBounds(275, 127, 56, 23);
		Bebidas.add(rdbtnSiAlcohol);
		
		textLitros = new JTextField();
		textLitros.setFont(new Font("Calibri", Font.PLAIN, 19));
		textLitros.setBounds(277, 51, 128, 24);
		Bebidas.add(textLitros);
		textLitros.setColumns(10);
		
		textGusto = new JTextField();
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
		
		cmbTipoLacteo = new JComboBox();
		cmbTipoLacteo.setFont(new Font("Calibri", Font.PLAIN, 23));
		cmbTipoLacteo.setBounds(269, 14, 269, 29);
		Lacteos.add(cmbTipoLacteo);
		
		Limpieza = new JPanel();
		panelAtributos.add(Limpieza, LIMPIEZA_REFERENCIA);
		Limpieza.setLayout(null);
		
		lblNewLabel_11 = new JLabel("Descripcion");
		lblNewLabel_11.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_11.setBounds(10, 58, 249, 29);
		Limpieza.add(lblNewLabel_11);
		
		textDescripcionLimpieza = new JTextField();
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
		textPesoGrm.setBounds(158, 46, 86, 29);
		Snack.add(textPesoGrm);
		textPesoGrm.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Gramos");
		lblNewLabel_14.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_14.setBounds(254, 46, 138, 29);
		Snack.add(lblNewLabel_14);
		
		
		
		btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(245, 506, 155, 43);
		panel.add(btnAgregar);
		
		btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiarCampos.setBounds(526, 516, 108, 23);
		panel.add(btnLimpiarCampos);
		
		errorNombre = new JLabel("");
		errorNombre.setIcon(new ImageIcon(AgregarProducto.class.getResource("/img/Error.png")));
		errorNombre.setBounds(667, 46, 30, 29);
		errorNombre.setVisible(false);
		panel.add(errorNombre);
		
		errorMarca = new JLabel("");
		errorMarca.setIcon(new ImageIcon(AgregarProducto.class.getResource("/img/Error.png")));
		errorMarca.setBounds(667, 168, 30, 29);
		errorMarca.setVisible(false);
		panel.add(errorMarca);
		
		errorPrecio = new JLabel("");
		errorPrecio.setIcon(new ImageIcon(AgregarProducto.class.getResource("/img/Error.png")));
		errorPrecio.setBounds(667, 107, 30, 29);
		errorPrecio.setVisible(false);
		panel.add(errorPrecio);
		
		errorStockInicial = new JLabel("");
		errorStockInicial.setIcon(new ImageIcon(AgregarProducto.class.getResource("/img/Error.png")));
		errorStockInicial.setBounds(667, 229, 30, 29);
		errorStockInicial.setVisible(false);
		panel.add(errorStockInicial);
		
		
	}
	
	public void mostrarPanelAtributoComboBox()
	{
		cmbCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbCategoria.getSelectedItem().equals(BEBIDAS_REFERENCIA))
				{
					controlPanelAtributo.show(panelAtributos, BEBIDAS_REFERENCIA);
					
				}else if(cmbCategoria.getSelectedItem().equals(CONGELADO_REFERENCIA))
				{
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
	
	public void accionLimpiarCampos()
	{
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
			}
		});
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
	}
	
	public int contarCamposVacios()
	{
		int contador = 0;
		
		if(txtNombre.getText().isEmpty())
		{
			contador++;
			errorNombre.setVisible(true);
		}
		if(txtMarca.getText().isEmpty())
		{
			contador++;
			errorMarca.setVisible(true);
		}
		if(txtPrecio.getText().isEmpty())
		{
			contador++;
			errorPrecio.setVisible(true);
		}
		if(txtStockInicial.getText().isEmpty())
		{
			contador++;
			errorStockInicial.setVisible(true);
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
			//
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
				|| txtPrecio.getText().isEmpty() || txtStockInicial.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());

		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.BEBIDAS_REFERENCIA) && (textGusto.getText().isEmpty() || textLitros.getText().isEmpty())) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.CONGELADO_REFERENCIA) && textPesoCongelado.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.GOLOSINAS_REFERENCIA) && (textUnidades.getText().isEmpty() || textDescripcionGolosina.getText().isEmpty())) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.LIMPIEZA_REFERENCIA) && textDescripcionLimpieza.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.PERFUMERIA_REFERENCIA) && textFragancia.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		} else

		if (cmbCategoria.getSelectedItem().equals(AgregarProducto.SNACK_REFERENCIA) && textPesoGrm.getText().isEmpty()) {
			throw new CamposVacios("Formulario sin LLENAR completamente", contarCamposVacios());
		}
	}
}
