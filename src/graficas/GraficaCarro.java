package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Colecciones.ArregloDetalleCompra;
import Colecciones.ArregloProductos;
import Colecciones.MapaProductos;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Bebida;
import Productos.Lacteo;
import Productos.Producto;
import Productos.Snack;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import Objetos.Carro;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class GraficaCarro extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel labelTotal;
	private JLabel precioTotal;
	private JButton botonComprar;
	private JLabel labelInsuficiente;
	private JLabel labelCompraExitosa;
	private JLabel labelCarritoVacio;
	private JLabel labelPerfil;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					graficaCarro frame = new graficaCarro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GraficaCarro(Supermercado mercado) 
	{
		initComponents(mercado);
	}
	
	
	private void initComponents(Supermercado mercado) 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		
		Usuario user = mercado.getUsuarioEnSesion();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelPerfil = new JLabel(user.getUserName());
		labelPerfil.setForeground(Color.WHITE);
		labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerfil.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		labelPerfil.setBounds(38, 166, 208, 41);
		contentPane.add(labelPerfil);
		
		labelInsuficiente = new JLabel("¡SALDO INSUFICIENTE!");
		labelInsuficiente.setVisible(false);
		labelInsuficiente.setFont(new Font("Calibri", Font.BOLD, 23));
		labelInsuficiente.setForeground(new Color(255, 0, 0));
		labelInsuficiente.setBounds(321, 651, 424, 42);
		contentPane.add(labelInsuficiente);
		
		labelCompraExitosa = new JLabel("¡COMPRA EXITOSA!");
		labelCompraExitosa.setVisible(false);
		labelCompraExitosa.setFont(new Font("Calibri", Font.BOLD, 23));
		labelCompraExitosa.setForeground(Color.GREEN);
		labelCompraExitosa.setBounds(321, 651, 424, 42);
		contentPane.add(labelCompraExitosa);
		
		labelCarritoVacio = new JLabel("¡EL CARRITO ESTA VACIO!");
		labelCarritoVacio.setVisible(false);
		labelCarritoVacio.setFont(new Font("Calibri", Font.BOLD, 23));
		labelCarritoVacio.setForeground(Color.black);
		labelCarritoVacio.setBounds(321, 651, 424, 42);
		contentPane.add(labelCarritoVacio);
		
		JButton botonHistorial = new JButton("");
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
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
				new GraficaHistorial(mercado).setVisible(true);
			}
		});
		
		JButton botonInicio = new JButton("");
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
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
				new Inicio(mercado).setVisible(true);
			}
		});
		botonInicio.setBounds(48, 287, 196, 51);
		contentPane.add(botonInicio);
		
		botonHistorial.setContentAreaFilled(false);
		botonHistorial.setBounds(50, 465, 196, 51);
		contentPane.add(botonHistorial);

		JButton botonCuenta = new JButton("");
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
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
				new Cuenta(mercado).setVisible(true);
			}
		});
		botonCuenta.setContentAreaFilled(false);
		botonCuenta.setBounds(47, 405, 196, 51);
		contentPane.add(botonCuenta);
		
		Session activa = mercado.getSesionActiva();
		Carro carrito = activa.getCarrito();	
		ArregloProductos arreglo = carrito.getArreglo();
		
		precioTotal = new JLabel("");
		precioTotal.setBounds(911, 652, 69, 38);
		String total = "$" + String.valueOf(carrito.getTotal());
		
		botonComprar = new JButton("");
		botonComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonComprar.setBorder(null);
		botonComprar.setContentAreaFilled(false);
		botonComprar.setOpaque(false);
		botonComprar.setBounds(1013, 651, 165, 38);
		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(carrito.isEmpty())
				{
					labelInsuficiente.setVisible(false);
					labelCompraExitosa.setVisible(false);
					labelCarritoVacio.setVisible(true);
				}
				else if(user.getCartera() >= carrito.getTotal())
				{
					labelCarritoVacio.setVisible(false);
					labelInsuficiente.setVisible(false);
					labelCompraExitosa.setVisible(true);
					activa.comprar();
					carrito.limpiarCarrito();
					precioTotal.setText("$" + String.valueOf(carrito.getTotal()));
				}
				else
				{
					labelCompraExitosa.setVisible(false);
					labelCarritoVacio.setVisible(false);
					labelInsuficiente.setVisible(true);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonComprar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 102, 153)));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonComprar.setBorder(null);
			}
		});
		contentPane.add(botonComprar);
		precioTotal.setText(total);
		contentPane.add(precioTotal);
		precioTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		labelTotal = new JLabel("Total");
		labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelTotal.setBounds(849, 652, 69, 38);
		contentPane.add(labelTotal);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(272, 107, 992, 522);
		scrollPane.setBackground(new Color(0,0,0,0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1015, 620));
		panel.setBackground(new Color(0,0,0,0));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		contentPane.add(scrollPane);
		
		columnaProductos(arreglo, carrito, precioTotal);
		
		fondo = new JLabel("");
		fondo.setBounds(0, 0, 1294, 721);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaCarro.class.getResource("/img/Carro V3.png")));
		contentPane.add(fondo);
	}
	
	/**
	 * Crea una columna grafica de botones con los productos que tenemos en el carrito
	 * @param productos
	 * @param carrito
	 * @param precioTotal
	 */
	void columnaProductos(ArregloProductos productos, Carro carrito, JLabel precioTotal)
	{
		JButton arregloBotones[] = new JButton[productos.cantidad()];
		int y = 40;
		int yPanel = 620;
		long id = 0;
		int i = 0;
		
		for(Producto aux : productos.getArreglo())
		{
			arregloBotones[i] = new JButton(aux.getNombre() + "      $" + aux.getPrecio());
			arregloBotones[i].setHorizontalAlignment(SwingConstants.LEFT);
			arregloBotones[i].setFont(new Font("Calibri", Font.BOLD, 20));
			arregloBotones[i].setForeground(new Color(51, 102, 153));
			arregloBotones[i].setBounds(39, y, 838, 44);
			arregloBotones[i].setActionCommand(aux.getNombre());
			arregloBotones[i].addActionListener(new Pulsando(arregloBotones[i], productos, carrito, precioTotal));
			panel.add(arregloBotones[i]);
			y += 60;
			i++;
			
			if(i >= 7)
			{
				yPanel += 60;
				panel.setPreferredSize(new Dimension(1015, yPanel));
			}
		}
	}
	
	//Clase que le da comportamiento a los botones de productos del carrito.
	class Pulsando implements ActionListener{
		
		ArregloProductos arreglo;
		JButton button;
		Carro carrito;
		JLabel precioTotal;
		
		public Pulsando(JButton button, ArregloProductos arreglo, Carro carrito, JLabel precioTotal) {
			
			this.button = button;
			this.arreglo = arreglo;
			this.carrito = carrito;
			this.precioTotal = precioTotal;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
	        String actionCommand = ((JButton) e.getSource()).getActionCommand();
	        ArrayList<Producto> productos = arreglo.getArreglo();
	        Producto nuevo = null;
	        
	        for(Producto aux : productos)
	        {
	        	if(aux.getNombre().equals(actionCommand))
	        	{
	        		nuevo = aux;
	        	}
	        }

	        carrito.quitar(nuevo.getId()); //TODO Eliminar del carrito y que aparezca el nuevo total
	        button.setEnabled(false);
	        String nuevoTotal = "$" + String.valueOf(carrito.getTotal());
	        precioTotal.setText(nuevoTotal);
	        
	    }
		
	}
}
