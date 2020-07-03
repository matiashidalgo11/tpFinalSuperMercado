package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Colecciones.MapaProductos;
import Objetos.Carro;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Producto;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class DetallesProducto extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JLabel nombreProducto;
	private JTextPane detalles;
	private JButton botonVolver;
	private JButton botonAgregar;
	private JLabel labelPerfil;
	private JButton botonCerrarSesion;
	private JLabel labelSinStock;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetallesProducto frame = new DetallesProducto();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	
	public DetallesProducto(Supermercado mercado, MapaProductos mapaProductos, Producto producto) 
	{
		initComponents(mercado, mapaProductos, producto);
	}
	
	private void initComponents(Supermercado mercado, MapaProductos mapaProductos, Producto producto) 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		
		Usuario user = mercado.getUsuarioEnSesion();
		Session activa = mercado.getSesionActiva();
		Carro carrito = activa.getCarrito();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonCerrarSesion = new JButton("");
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mercado.guardarDatos();
				dispose();
				new Principal(mercado).setVisible(true);
			}
		});
		botonCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				botonCerrarSesion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 102, 153)));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonCerrarSesion.setBorder(null);
			}
		});
		
		labelSinStock = new JLabel("NO HAY MAS STOCK DISPONIBLE!");
		labelSinStock.setVisible(false);
		labelSinStock.setForeground(Color.RED);
		labelSinStock.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelSinStock.setBounds(319, 652, 381, 45);
		contentPane.add(labelSinStock);
		botonCerrarSesion.setContentAreaFilled(false);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setOpaque(false);
		botonCerrarSesion.setBounds(81, 660, 129, 27);
		contentPane.add(botonCerrarSesion);
		
		labelPerfil = new JLabel(user.getUserName());
		labelPerfil.setForeground(Color.WHITE);
		labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerfil.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		labelPerfil.setBounds(38, 166, 208, 41);
		contentPane.add(labelPerfil);
		
		JButton botonInicio = new JButton("");
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new Inicio(mercado).setVisible(true);
			}
		});
		botonInicio.setContentAreaFilled(false);
		botonInicio.setBorder(null);
		botonInicio.setVisible(true);
		botonInicio.setOpaque(false);
		botonInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonInicio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonInicio.setBorder(null);
			}
		});
		contentPane.setLayout(null);
		botonInicio.setBounds(49, 290, 196, 51);
		contentPane.add(botonInicio);
		
		JButton botonCarro = new JButton("");
		botonCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new GraficaCarro(mercado).setVisible(true);
			}
		});
		botonCarro.setVisible(true);
		botonCarro.setOpaque(false);
		botonCarro.setBorder(null);
		botonCarro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonCarro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonCarro.setBorder(null);
			}
		});
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(44, 346, 196, 51);
		contentPane.add(botonCarro);

		JButton botonCuenta = new JButton("");
		botonCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new Cuenta(mercado).setVisible(true);
			}
		});
		botonCuenta.setVisible(true);
		botonCuenta.setOpaque(false);
		botonCuenta.setBorder(null);
		botonCuenta.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonCuenta.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonCuenta.setBorder(null);
			}
		});
		botonCuenta.setContentAreaFilled(false);
		botonCuenta.setBounds(50, 406, 196, 51);
		contentPane.add(botonCuenta);
		
		JButton botonHistorial = new JButton("");
		botonHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				new GraficaHistorial(mercado).setVisible(true);
			}
		});
		botonHistorial.setVisible(true);
		botonHistorial.setOpaque(false);
		botonHistorial.setBorder(null);
		botonHistorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonHistorial.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonHistorial.setBorder(null);
			}
		});
		
		botonHistorial.setContentAreaFilled(false);
		botonHistorial.setBounds(48, 465, 196, 51);
		contentPane.add(botonHistorial);
		
		
		
		botonAgregar = new JButton("");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(producto.getStock() > 0)
				{
					labelSinStock.setVisible(true);
					carrito.agregar(producto);
					producto.restarStock(1);
					detalles.setText(producto.toString());
				}
				else
				{
					labelSinStock.setVisible(true);
				}
				
				
			}
		});
		botonAgregar.setContentAreaFilled(false);
		botonAgregar.setOpaque(false);
		botonAgregar.setBounds(315, 598, 263, 46);
		contentPane.add(botonAgregar);
		
		botonVolver = new JButton("");
		botonVolver.setBorder(null);
		botonVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonVolver.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				setVisible(false);
				new Productos(mercado, mapaProductos).setVisible(true);;
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonVolver.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 102, 153)));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonVolver.setBorder(null);
			}
		});
		
		botonVolver.setContentAreaFilled(false);
		botonVolver.setOpaque(false);
		botonVolver.setBounds(944, 599, 127, 45);
		contentPane.add(botonVolver);
		
		detalles = new JTextPane();
		detalles.setOpaque(false);
		detalles.setForeground(new Color(51, 102, 153));
		detalles.setFont(new Font("Calibri", Font.BOLD, 25));
		detalles.setBounds(323, 190, 736, 353);
		detalles.setText(producto.toString());
		detalles.setEditable(false);
		contentPane.add(detalles);
		
		nombreProducto = new JLabel("");
		nombreProducto.setForeground(new Color(51, 102, 153));
		nombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nombreProducto.setBounds(568, 56, 364, 49);
		nombreProducto.setText(producto.getNombre());
		contentPane.add(nombreProducto);
		
		fondo = new JLabel("");
		fondo.setIgnoreRepaint(true);
		fondo.setBounds(0, 0, 1294, 721);
		fondo.setIcon(new ImageIcon(DetallesProducto.class.getResource("/img/DetallesProducto V2.png")));
		contentPane.add(fondo);
	}
}
