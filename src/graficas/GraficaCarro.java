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
import javax.swing.border.EmptyBorder;

import Colecciones.ArregloProductos;
import Colecciones.MapaProductos;
import Objetos.Session;
import Objetos.Supermercado;
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
//		Session activa = mercado.getSesionActiva();
//		Carro carrito = activa.getCarrito();
		
		//****************************** Prueba *********************************//
		Carro prueba = new Carro(1);
		Producto coca = new Bebida("Cola", 60, "Coca", 1, true, 2, "Dulce", false, false, 0);
		Producto jugo = new Bebida("Jugo", 30, "Cualquiera", 1, false, 2, "Dulce", false, false, 0);
		Producto cerveza = new Bebida("Cerveza", 100, "Quilmes", 1, false, 2, "Amargo", true, false, 0);
		Producto agua = new Bebida("Agua", 50, "Mineral", 1, false, 2, "Agua", false, false, 0);
		
		Producto papas = new Snack("Papas Frita", 70, "Lays", 1, 100, false, 0);
		Producto palitos = new Snack("Palitos", 40, "Palitos", 1, 100, false, 0);	
	
		Producto leche = new Lacteo("Leche", 50, "LaSerenisima", 1, "Leche", false, 0);
		
		prueba.agregar(coca);
		prueba.agregar(jugo);
		prueba.agregar(cerveza);
		prueba.agregar(agua);
		prueba.agregar(papas);
		prueba.agregar(palitos);
		prueba.agregar(leche);
		
		ArregloProductos arreglo = prueba.getArreglo();
		//*******************************************************************//
		
		contentPane.setLayout(null);
		
		precioTotal = new JLabel("");
		precioTotal.setBounds(397, 666, 69, 38);
		String total = "$" + String.valueOf(prueba.getTotal());
		
		botonComprar = new JButton("");
		botonComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonComprar.setBorder(null);
		botonComprar.setContentAreaFilled(false);
		botonComprar.setOpaque(false);
		botonComprar.setBounds(1018, 666, 165, 38);
		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				new GraficaHistorial(mercado).setVisible(true);
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
		labelTotal.setBounds(335, 666, 69, 38);
		contentPane.add(labelTotal);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(277, 122, 992, 522);
		scrollPane.setBackground(new Color(0,0,0,0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1015, 620));
		panel.setBackground(new Color(0,0,0,0));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		contentPane.add(scrollPane);
		
		columnaProductos(arreglo, prueba, precioTotal);
		
		fondo = new JLabel("");
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaCarro.class.getResource("/img/Carro V2.png")));
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
