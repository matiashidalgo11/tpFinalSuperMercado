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

public class MenuAdminUsuarios extends JPanel {

	public DefaultListModel<Usuario> modeloLista = new DefaultListModel<Usuario>();
	private JPanel panel;
	public JButton btnAgregarUsuario;
	public JButton btnListaUsuarios;
	private Supermercado datos;
	
	public static String LISTA_USUARIOS_REF = "listaUsuarios";
	public static String AGREGAR_USUARIO_REF = "agregarUsuario";
	
	public SubMenuListaUsuarios listaUs;
	public SubMenuAgregarUsuario agregarUs;
	/**
	 * Create the panel.
	 */
	public MenuAdminUsuarios(Supermercado datos) {
		this.datos = datos;
		initComponents();
	}
	private void initComponents() {
		
		listaUs = new SubMenuListaUsuarios(datos);
		JpopuMenuAcciones();
		agregarUs = new SubMenuAgregarUsuario();
		agregarUsuario();

		
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(159, 90, 724, 588);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(listaUs, LISTA_USUARIOS_REF);
		panel.add(agregarUs, AGREGAR_USUARIO_REF);
		
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
	
	public void JpopuMenuAcciones()
	{
		listaUs.itemActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seleccionTabla = listaUs.table.getSelectedRow();
				long id = (long) listaUs.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaUsuarios().existencia(id))
				{
					Usuario aux = datos.getListaUsuarios().buscar(id);
					int valor = JOptionPane.showConfirmDialog(panel, "Desea cambiar el valor de Activo ?", "Activar", 2);
					if(valor == 0)
					{
						aux.invertirActivo();
						listaUs.limpiarLista();
						listaUs.cargarLista(datos);
					}
				}
				
			}
		});
		
		listaUs.itemEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				int seleccionTabla = listaUs.table.getSelectedRow();
				long id = (long) listaUs.table.getValueAt(seleccionTabla, 0);
				
				if(datos.getListaUsuarios().existencia(id))
				{
					Usuario aux = datos.getListaUsuarios().buscar(id);
					int valor = JOptionPane.showConfirmDialog(panel, "Desea Eliminar el Usuario ?", "Eliminar", 2);
					if(valor == 0)
					{
						datos.eliminarUsuario(aux);
						listaUs.limpiarLista();
						listaUs.cargarLista(datos);
					}
				}
				
			
			}
		});
	}
	
	
}
