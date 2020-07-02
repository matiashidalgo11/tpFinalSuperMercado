package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JToolBar;

import Objetos.Supermercado;
import Objetos.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import Excepciones.CamposVacios;
import Excepciones.UsuarioExistente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class UsuariosMenu extends JPanel {

	public DefaultListModel<Usuario> modeloLista = new DefaultListModel<Usuario>();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public JButton btnAgregarUsuario;
	public JButton btnListaUsuarios;
	private Supermercado datos;
	
	public static String LISTA_USUARIOS_REF = "listaUsuarios";
	public static String AGREGAR_USUARIO_REF = "agregarUsuario";
	
	public ListaUsuarios listaUs;
	public AgregarUsuario agregarUs;
	/**
	 * Create the panel.
	 */
	public UsuariosMenu(Supermercado datos) {
		this.datos = datos;
		initComponents();
	}
	private void initComponents() {
		
		listaUs = new ListaUsuarios(datos);
		agregarUs = new AgregarUsuario(datos);
		agregarUsuario();

		
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(159, 90, 724, 588);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(listaUs, LISTA_USUARIOS_REF);
		panel.add(agregarUs, AGREGAR_USUARIO_REF);
		
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(893, 286, 149, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 286, 149, 14);
		add(lblNewLabel_1);
		
		btnAgregarUsuario = new JButton("Agregar Usuario");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel, AGREGAR_USUARIO_REF);
			}
		});
		btnAgregarUsuario.setBounds(159, 21, 362, 58);
		add(btnAgregarUsuario);
		
		btnListaUsuarios = new JButton("Lista Usuarios");
		btnListaUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//listaUs.updateUI();
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel, LISTA_USUARIOS_REF);
			}
		});
		btnListaUsuarios.setBounds(521, 21, 362, 58);
		add(btnListaUsuarios);
	}
	
	public void agregarUsuario()
	{
		agregarUs.btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (agregarUs.txtUserName.getText().isEmpty() || agregarUs.txtPassword.getText().isEmpty()
							|| agregarUs.txtNombre.getText().isEmpty() || agregarUs.txtApellido.getText().isEmpty()
							|| agregarUs.txtTelefono.getText().isEmpty()) {
						
						int cant = agregarUs.contadorCamposVacios();
						throw new CamposVacios("Formulario sin LLENAR completamente", cant);
						
					}else if(datos.getListaUsuarios().existencia(agregarUs.txtUserName.getText()))
					{
						throw new UsuarioExistente(agregarUs.txtUserName.getText());
					}else
					{
						int edad = (int) agregarUs.cmbEdad.getSelectedItem();
						Usuario nuevo = new Usuario(agregarUs.txtUserName.getText(), agregarUs.txtPassword.getText(), agregarUs.txtNombre.getText(), agregarUs.txtApellido.getText(), edad, agregarUs.txtTelefono.getText());
						nuevo.setActivo(agregarUs.chckbxActivo.isSelected());
						
						if(datos.agregarUsuario(nuevo))
						{
							JOptionPane.showMessageDialog(panel, "Se agrego el Usuario Correctamente");
							listaUs.limpiarLista();
							listaUs.cargarLista(datos);
							agregarUs.limpiarCampos();
												}
						
					}

				} catch (CamposVacios ex) {
					ex.printStackTrace();
				} catch(UsuarioExistente rep)
				{
					rep.printStackTrace();
					agregarUs.txtUserName.setText("");
				}
					
					
			}
		});
	}
	
	
	
	
}
