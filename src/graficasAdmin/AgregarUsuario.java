package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

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
	public JTextField textNombre;
	public JTextField txtApellido;
	public JTextField txtTelefono;
	public JComboBox cmbEdad;
	public JButton btnAgregar;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public AgregarUsuario() {

		initComponents();
	}
	private void initComponents() {
		
		setBounds(159, 90, 724, 588);
		setLayout(null);
		
		lblNewLabel = new JLabel("Nombre Usuario");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(24, 104, 259, 46);
		add(lblNewLabel);
		
		lblContrase = new JLabel("Contrase\u00F1a");
		lblContrase.setFont(new Font("Calibri", Font.BOLD, 23));
		lblContrase.setBounds(24, 169, 259, 46);
		add(lblContrase);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNombre.setBounds(24, 238, 259, 46);
		add(lblNombre);
		
		lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_3.setBounds(24, 310, 259, 46);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(24, 379, 259, 46);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_5.setBounds(24, 448, 259, 46);
		add(lblNewLabel_5);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtUserName.setBounds(322, 104, 259, 46);
		add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtPassword.setColumns(10);
		txtPassword.setBounds(322, 169, 259, 46);
		add(txtPassword);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		textNombre.setColumns(10);
		textNombre.setBounds(322, 238, 259, 46);
		add(textNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtApellido.setColumns(10);
		txtApellido.setBounds(322, 310, 259, 46);
		add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(322, 379, 259, 46);
		add(txtTelefono);
		
		cmbEdad = new JComboBox();
		cmbEdad.setBounds(515, 448, 66, 46);
		for(int i = 18; i < 80; i++)
		{
			cmbEdad.addItem(i);
		}
		
		add(cmbEdad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Calibri", Font.BOLD, 23));
		btnAgregar.setBounds(259, 531, 160, 46);
		add(btnAgregar);
		
		lblNewLabel_1 = new JLabel("Imagen");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(295, 11, 97, 28);
		add(lblNewLabel_1);
	}

}
