package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JToolBar;

import Objetos.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
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
	
	
	public static String LISTA_USUARIOS_REF = "listaUsuarios";
	public static String AGREGAR_USUARIO_REF = "agregarUsuario";
	
	public ListaUsuarios listaUs;
	public AgregarUsuario agregarUs;
	/**
	 * Create the panel.
	 */
	public UsuariosMenu() {

		initComponents();
	}
	private void initComponents() {
		
		listaUs = new ListaUsuarios();
		agregarUs = new AgregarUsuario();
		
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
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel, LISTA_USUARIOS_REF);
			}
		});
		btnListaUsuarios.setBounds(521, 21, 362, 58);
		add(btnListaUsuarios);
	}
}
