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
import java.awt.Font;

/**
 * 
 * MenuPrinciapl del Administrador
 *
 */
public class AdminMenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAdministrarUsuarios;
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
	private MenuAdminUsuarios userMenu;

	public static String INFOGENERAL_REFERENCIA = "informacionGeneral";
	private MenuAdminInformacionGeneral infoG;
	

	public static String PRODUCTOSMENU_REFERENCIA= "productosMenu";
	private MenuAdminProductos productosMenu ;
	
	
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
		
		userMenu = new MenuAdminUsuarios(datos);
		infoG = new MenuAdminInformacionGeneral(datos);
		productosMenu = new MenuAdminProductos(datos);

		
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
		panel.setBounds(29, 11, 229, 689);
		panel.setBackground(new Color(0,0,0,0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnAdministrarUsuarios = new JButton("Administrar Usuarios");
		
		//Configuracion para Boton Invisible
				btnAdministrarUsuarios.setVisible(true);
				btnAdministrarUsuarios.setOpaque(false);
				btnAdministrarUsuarios.setContentAreaFilled(false);
		
		btnAdministrarUsuarios.setForeground(Color.WHITE);
		btnAdministrarUsuarios.setFont(new Font("Calibri", Font.ITALIC, 19));
		btnAdministrarUsuarios.setBounds(5, 298, 207, 83);
		btnAdministrarUsuarios.setBackground(Color.WHITE);
		panel.add(btnAdministrarUsuarios);
		
		btnAdministrarProductos = new JButton("Administrar Productos");
		
		//Configuracion para Boton Invisible
		btnAdministrarProductos.setVisible(true);
		btnAdministrarProductos.setOpaque(false);
		btnAdministrarProductos.setContentAreaFilled(false);
		
		btnAdministrarProductos.setBackground(new Color(0,0,0,0));
		btnAdministrarProductos.setForeground(Color.WHITE);
		btnAdministrarProductos.setOpaque(false);
		
		btnAdministrarProductos.setFont(new Font("Calibri", Font.ITALIC, 19));
		btnAdministrarProductos.setBounds(5, 423, 207, 83);
		panel.add(btnAdministrarProductos);
		

		btnCerrarSesion = new JButton("");
		
		//Configuracion para Boton Invisible
				btnCerrarSesion.setVisible(true);
				btnCerrarSesion.setOpaque(false);
				btnCerrarSesion.setContentAreaFilled(false);
		
		btnCerrarSesion.setBackground(new Color(0,0,0,0));
		btnCerrarSesion.setIcon(new ImageIcon(AdminMenuPrincipal.class.getResource("/img/Boton Cerrar Sesion.png")));
		btnCerrarSesion.setBounds(37, 628, 139, 35);
		panel.add(btnCerrarSesion);
		
		lblImagenAdmin = new JLabel("");
		lblImagenAdmin.setIcon(new ImageIcon(AdminMenuPrincipal.class.getResource("/img/Logo Admin.png")));
		lblImagenAdmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagenAdmin.setForeground(Color.BLACK);
		lblImagenAdmin.setBackground(Color.GREEN);
		lblImagenAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenAdmin.setBounds(21, 11, 155, 162);
		panel.add(lblImagenAdmin);
		
		btnInformacionGeneral = new JButton("Informacion General");
		btnInformacionGeneral.setForeground(Color.WHITE);
		//Configuracion para Boton Invisible
		btnInformacionGeneral.setVisible(true);
		btnInformacionGeneral.setOpaque(false);
		btnInformacionGeneral.setContentAreaFilled(false);
		
		btnInformacionGeneral.setBackground(Color.WHITE);
		btnInformacionGeneral.setFont(new Font("Calibri", Font.ITALIC, 19));
		btnInformacionGeneral.setBounds(5, 218, 207, 51);
		panel.add(btnInformacionGeneral);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.GREEN);
		scrollPane.setBounds(259, 25, 1002, 675);
		contentPane.add(scrollPane);
		
		subMenu = new JPanel();
		subMenu.setBackground(Color.WHITE);
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
		btnAdministrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.show(subMenu, USERMENU_REFERENCIA);
			}
		});
		
		btnInformacionGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoG.cargarInformacionGeneral(datos);
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
