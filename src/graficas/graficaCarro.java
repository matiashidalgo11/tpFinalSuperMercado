package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Colecciones.ArregloProductos;
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

public class graficaCarro extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JPanel panel;
	private JButton btnNewButton;

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
	public graficaCarro(Supermercado mercado) 
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
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(261, 68, 1015, 620);
		scrollPane.setBackground(new Color(0,0,0,0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1015, 620));
		panel.setBackground(new Color(0,0,0,0));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		contentPane.add(scrollPane);
		
		columnaProductos(arreglo);
		
		fondo = new JLabel("");
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(graficaCarro.class.getResource("/img/Carro.png")));
		contentPane.add(fondo);
	}
	
	void columnaProductos(ArregloProductos productos)
	{
		JButton arregloBotones[] = new JButton[productos.cantidad()];
		int y = 40;
		int yPanel = 620;
		long id = 0;
		int i = 0;
		
		for(Producto aux : productos.getArreglo())
		{
			arregloBotones[i] = new JButton(aux.getNombre());
			arregloBotones[i].setHorizontalAlignment(SwingConstants.LEFT);
			arregloBotones[i].setFont(new Font("Calibri", Font.BOLD, 20));
			arregloBotones[i].setForeground(new Color(51, 102, 153));
			arregloBotones[i].setBounds(39, y, 838, 44);
			panel.add(arregloBotones[i]);
			y += 60;
			i++;
			
			if(i >= 9)
			{
				yPanel += 60;
				panel.setPreferredSize(new Dimension(1015, yPanel));
			}
		}
	}
}
