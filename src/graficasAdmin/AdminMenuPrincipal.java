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

import Objetos.Supermercado;
import Objetos.Usuario;
import graficas.Inicio;
import graficas.Principal;

import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

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
	private JLabel Fondo;
	private Supermercado datos;
	
	public static String USERMENU_REFERENCIA = "userMenu";
	private UsuariosMenu userMenu;

	public static String INFOGENERAL_REFERENCIA = "informacionGeneral";
	private InformacionGeneral infoG;
	
	
	public static String PRODUCTOSMENU_REFERENCIA= "productosMenu";
	private ProductosMenuAdmin productosMenu ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado datos = new Supermercado();
					AdminMenuPrincipal frame = new AdminMenuPrincipal(datos);
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
	public AdminMenuPrincipal(Supermercado datos) {
		this.datos = datos;
		initComponents();
		accionesBotonesPrincipales();
	}
	private void initComponents() {
		
		userMenu = new UsuariosMenu(datos);
		infoG = new InformacionGeneral(datos);
		productosMenu = new ProductosMenuAdmin();
		
		setUndecorated(true);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750); //Tamaño por defecto del JFrame
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(37, 11, 212, 689);
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
		
		btnCerrarSesion = new JButton("");
		btnCerrarSesion.setOpaque(false);
		btnCerrarSesion.setBackground(new Color(0,0,0,0));
		//btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setIcon(new ImageIcon(AdminMenuPrincipal.class.getResource("/img/Boton Cerrar Sesion.png")));
		btnCerrarSesion.setBounds(33, 628, 127, 35);
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
		scrollPane.setBounds(259, 11, 1042, 689);
		contentPane.add(scrollPane);
		
		subMenu = new JPanel();
		scrollPane.setViewportView(subMenu);
		control = new CardLayout();
		subMenu.setLayout(control);
		userMenu.listaUs.table.setLocation(10, 11);
		subMenu.add(infoG,INFOGENERAL_REFERENCIA);
		subMenu.add(userMenu,USERMENU_REFERENCIA);
		subMenu.add(productosMenu,PRODUCTOSMENU_REFERENCIA);
		
		Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Inicio.class.getResource("/img/Fondo Solo.png")));
		Fondo.setBounds(0, 0, 1294, 721); //Tamaño por defecto del fondo 
		contentPane.add(Fondo);
		
		revalidate();
		
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
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.cerrarSesion();
				Principal p = new Principal(datos);
				p.setVisible(true);
				dispose();
			}
		});
	}
	
	
}
