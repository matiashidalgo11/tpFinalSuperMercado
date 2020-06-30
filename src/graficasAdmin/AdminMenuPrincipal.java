package graficasAdmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Objetos.Usuario;

import javax.swing.JScrollPane;
import java.awt.CardLayout;

public class AdminMenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnUsuarios;
	private JButton btnAdministrarProductos;
	private JButton btnAdministrarOfertas;
	private JButton btnCerrarSesion;
	private JButton btnInformacionGeneral;
	private JLabel lblImagenAdmin;
	private JScrollPane scrollPane;
	private JPanel subMenu;
	private CardLayout control;
	
	public static String USERMENU_REFERENCIA = "userMenu";
	private UsuariosMenu userMenu = new UsuariosMenu();

	public static String INFOGENERAL_REFERENCIA = "informacionGeneral";
	private InformacionGeneral infoG = new InformacionGeneral();
	
	
	public static String PRODUCTOSMENU_REFERENCIA= "productosMenu";
	private ProductosMenuAdmin productosMenu = new ProductosMenuAdmin();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuPrincipal frame = new AdminMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMenuPrincipal() {
		initComponents();
		accionesBotonesPrincipales();
	}
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 212, 689);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnUsuarios = new JButton("Administrar Usuarios");
		btnUsuarios.setBounds(5, 218, 200, 102);
		panel.add(btnUsuarios);
		
		btnAdministrarProductos = new JButton("Administrar Productos");
		btnAdministrarProductos.setBounds(5, 331, 200, 102);
		panel.add(btnAdministrarProductos);
		
		btnAdministrarOfertas = new JButton("Administrar Ofertas");
		btnAdministrarOfertas.setBounds(5, 444, 200, 102);
		panel.add(btnAdministrarOfertas);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(40, 608, 120, 70);
		panel.add(btnCerrarSesion);
		
		lblImagenAdmin = new JLabel("Imagen");
		lblImagenAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagenAdmin.setForeground(Color.BLACK);
		lblImagenAdmin.setBackground(Color.GREEN);
		lblImagenAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenAdmin.setBounds(40, 29, 120, 70);
		panel.add(lblImagenAdmin);
		
		btnInformacionGeneral = new JButton("Informacion General");
		btnInformacionGeneral.setBounds(5, 184, 200, 23);
		panel.add(btnInformacionGeneral);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 11, 1042, 689);
		contentPane.add(scrollPane);
		
		subMenu = new JPanel();
		scrollPane.setViewportView(subMenu);
		control = new CardLayout();
		subMenu.setLayout(control);
		userMenu.listaUs.table.setLocation(10, 11);
		subMenu.add(infoG,INFOGENERAL_REFERENCIA);
		subMenu.add(userMenu,USERMENU_REFERENCIA);
		subMenu.add(productosMenu,PRODUCTOSMENU_REFERENCIA);
		
		
		ArrayList<Usuario> arreglo = cargarArreglo();
		for(int i = 0; i < 10 ; i++)
		{
			cargarTabla(arreglo);
		}
		
		revalidate();
		
	}
	
	
	public void cargarTabla(ArrayList<Usuario> usuarios)
	{
		for(Usuario aux : usuarios)
		{
			Object[] transformado = transformarObjecto(aux);
			userMenu.listaUs.modeloTabla.addRow(transformado);
		}
		
	}
	
	public Object[] transformarObjecto(Usuario us)
	{
		Object[] objeto = new Object[] {us.getId(),us.getUserName(), us.getPassword(), us.getCartera(), us.getNombre(),us.getApellido(),us.getTelefono(),us.getEdad(), 1};
		
		return objeto;
	}
	
	public ArrayList<Usuario> cargarArreglo()
	{
		ArrayList<Usuario> arreglo = new ArrayList<Usuario>();
		
		Usuario a = new  Usuario("Matias11HP", "1234s", "Matias", "Hidalgo", 21, "123456");
		Usuario b = new Usuario("SkyTrix", "marat", "Ivan", "Hidalgo", 21, "1345546");
		Usuario c = new Usuario("Chap", "dasda", "Renzo", "Mirabella", 20, "5465");
		arreglo.add(a);
		arreglo.add(b);
		arreglo.add(c);
		
		
		return arreglo;
	}
	
	public void accionesBotonesPrincipales()
	{
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.show(subMenu, USERMENU_REFERENCIA);
			}
		});
		
		btnInformacionGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.show(subMenu, INFOGENERAL_REFERENCIA);
			}
		});
		
		btnAdministrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.show(subMenu, PRODUCTOSMENU_REFERENCIA);
			}
		});
	}
}
