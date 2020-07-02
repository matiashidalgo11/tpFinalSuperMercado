package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Colecciones.MapaProductos;
import Objetos.Supermercado;
import Productos.Producto;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class DetallesProducto extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JLabel nombreProducto;
	private JTextPane detalles;
	private JButton botonVolver;
	private JButton botonAgregar;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonAgregar = new JButton("");
		botonAgregar.setContentAreaFilled(false);
		botonAgregar.setOpaque(false);
		botonAgregar.setBounds(321, 613, 263, 46);
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
		botonVolver.setBounds(950, 614, 127, 45);
		contentPane.add(botonVolver);
		
		detalles = new JTextPane();
		detalles.setOpaque(false);
		detalles.setForeground(new Color(51, 102, 153));
		detalles.setFont(new Font("Calibri", Font.BOLD, 25));
		detalles.setBounds(329, 205, 736, 353);
		detalles.setText(producto.toString());
		detalles.setEditable(false);
		contentPane.add(detalles);
		
		nombreProducto = new JLabel("");
		nombreProducto.setForeground(new Color(51, 102, 153));
		nombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nombreProducto.setBounds(574, 71, 364, 49);
		nombreProducto.setText(producto.getNombre());
		contentPane.add(nombreProducto);
		
		fondo = new JLabel("");
		fondo.setIgnoreRepaint(true);
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIcon(new ImageIcon(DetallesProducto.class.getResource("/img/DetallesProducto.png")));
		contentPane.add(fondo);
	}
}
