package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

import Excepciones.CamposVacios;
import Excepciones.UsuarioExistente;
import Objetos.Supermercado;
import Objetos.Usuario;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarUsuario extends JPanel {
	
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblContrase;
	private JLabel lblNombre;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	public JTextField txtUserName;
	public JTextField txtPassword;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtTelefono;
	public JComboBox cmbEdad;
	public JButton btnAgregar;
	private JLabel lblNewLabel_1;
	
	public JCheckBox chckbxActivo;
	public JLabel errorPassword;
	public JLabel errorNombre;
	public JLabel errorApellido;
	public JLabel errorTelefono;
	public JLabel errorUserName;
	public JPanel panel;
	public JButton btnLimpiarCampos;

	/**
	 * Create the panel.
	 */
	public AgregarUsuario() {
		initComponents();
		accionBtnLimpiar();
	}
	private void initComponents() {
		
		setBounds(159, 90, 724, 588);
		setLayout(null);
		
		lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(24, 68, 259, 46);
		add(lblNewLabel);
		
		lblContrase = new JLabel("Contrase\u00F1a");
		lblContrase.setFont(new Font("Calibri", Font.BOLD, 23));
		lblContrase.setBounds(24, 133, 259, 46);
		add(lblContrase);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNombre.setBounds(24, 202, 259, 46);
		add(lblNombre);
		
		lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_3.setBounds(24, 274, 259, 46);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(24, 343, 259, 46);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_5.setBounds(24, 412, 259, 46);
		add(lblNewLabel_5);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtUserName.setBounds(322, 68, 259, 46);
		add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtPassword.setColumns(10);
		txtPassword.setBounds(322, 133, 259, 46);
		add(txtPassword);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombre.setColumns(10);
		txtNombre.setBounds(322, 202, 259, 46);
		add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtApellido.setColumns(10);
		txtApellido.setBounds(322, 274, 259, 46);
		add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();
				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}

			}
		});
		
		txtTelefono.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(322, 343, 259, 46);
		add(txtTelefono);
		
		cmbEdad = new JComboBox();
		cmbEdad.setBounds(515, 412, 66, 46);
		for(int i = 18; i < 80; i++)
		{
			cmbEdad.addItem(i);
		}
		
		add(cmbEdad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Calibri", Font.BOLD, 23));
		btnAgregar.setBounds(259, 531, 160, 46);
		add(btnAgregar);
		
		chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(515, 475, 66, 28);
		add(chckbxActivo);
		
		errorUserName = new JLabel("");
		errorUserName.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/img/Error.png")));
		errorUserName.setBounds(606, 68, 37, 41);
		errorUserName.setVisible(false);
		add(errorUserName);
		
		errorPassword = new JLabel("");
		errorPassword.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/img/Error.png")));
		errorPassword.setBounds(606, 138, 37, 41);
		errorPassword.setVisible(false);
		add(errorPassword);
		
		errorNombre = new JLabel("");
		errorNombre.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/img/Error.png")));
		errorNombre.setBounds(606, 207, 37, 41);
		errorNombre.setVisible(false);
		add(errorNombre);
		
		errorApellido = new JLabel("");
		errorApellido.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/img/Error.png")));
		errorApellido.setBounds(606, 279, 37, 41);
		errorApellido.setVisible(false);
		add(errorApellido);
		
		errorTelefono = new JLabel("");
		errorTelefono.setIcon(new ImageIcon(AgregarUsuario.class.getResource("/img/Error.png")));
		errorTelefono.setBounds(606, 348, 37, 41);
		errorTelefono.setVisible(false);
		add(errorTelefono);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 724, 588);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setBounds(295, 11, 97, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnLimpiarCampos = new JButton("LimpiarCampos");
		btnLimpiarCampos.setBounds(468, 536, 89, 23);
		panel.add(btnLimpiarCampos);
		
	}
	
	
	public void limpiarCampos()
	{
		
		txtUserName.setText("");
		txtPassword.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		chckbxActivo.setSelected(false);
		cmbEdad.setSelectedIndex(0);
		errorUserName.setVisible(false);
		errorPassword.setVisible(false);
		errorNombre.setVisible(false);
		errorApellido.setVisible(false);
		errorTelefono.setVisible(false);
		
	}
	
	
	public void accionBtnLimpiar()
	{
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}
	
	public int contadorCamposVacios()
	{
		int contador = 0;
		if (txtUserName.getText().isEmpty()) {
			errorUserName.setVisible(true);
			contador++;
		}

		if (txtPassword.getText().isEmpty()) {
			errorPassword.setVisible(true);
			contador++;
		}

		if (txtNombre.getText().isEmpty()) {
			errorNombre.setVisible(true);
			contador++;

		}

		if (txtApellido.getText().isEmpty()) {
			errorApellido.setVisible(true);
			contador++;
		}

		if (txtTelefono.getText().isEmpty()) {
			errorTelefono.setVisible(true);
			contador++;
		}

		return contador;
	}
}
