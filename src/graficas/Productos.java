package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import Colecciones.MapaProductos;
import ColeccionesGenericas.ArregloGenerico;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Producto;
import graficas.Inicio.Pulsando;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Productos extends JFrame {

	private JPanel contentPane;
	private int x, y;
	private JLabel labelPerfil;
	private JButton botonCerrarSesion;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Productos frame = new Productos();
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
	public Productos(Supermercado mercado, MapaProductos productos) {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		
		Usuario user = mercado.getUsuarioEnSesion();
		
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
		
		JLabel labelMover = new JLabel("");
		labelMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		labelMover.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x + e.getX() - x, getLocation().y + e.getY() - y);
			}
		});
		labelMover.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		labelMover.setBounds(45, 14, 1233, 35);
		contentPane.add(labelMover);
		
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
		contentPane.setLayout(null);
		botonInicio.setBounds(49, 290, 196, 51);
		contentPane.add(botonInicio);
		
		JButton botonCarro = new JButton("");
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
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				new GraficaCarro(mercado).setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(50, 348, 196, 51);
		contentPane.add(botonCarro);

		JButton botonCuenta = new JButton("");
		botonCuenta.setVisible(true);
		botonCuenta.setOpaque(false);
		botonCuenta.setBorder(null);
		botonCuenta.addMouseListener(new MouseAdapter() {
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
		botonCuenta.setBounds(51, 408, 196, 51);
		contentPane.add(botonCuenta);
		
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
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				new GraficaHistorial(mercado).setVisible(true);
			}
		});
		
		botonHistorial.setContentAreaFilled(false);
		botonHistorial.setBounds(52, 463, 196, 51);
		contentPane.add(botonHistorial);
		
		
		JPanel panel = new JPanel();
		panel.setIgnoreRepaint(true);
		panel.setBorder(null);
		panel.setBounds(255, 58, 1017, 627);
		panel.setLayout(null);
		contentPane.add(panel);
		
		System.out.println(productos.listar());
		
		crearMatrizBotones(panel, productos, mercado);		
		
		JLabel fondo = new JLabel("");
		fondo.setIgnoreRepaint(true);
		fondo.setBounds(0, 0, 1294, 721);
		fondo.setIcon(new ImageIcon(Productos.class.getResource("/img/Productos V2.png")));
		contentPane.add(fondo);
	}
	
	void crearMatrizBotones(JPanel panel, MapaProductos productos, Supermercado mercado)
	{
		int x = 150;
		int y = 61;
		long idAltoLong = productos.getIdMasAlto();
		int idAlto = (int) idAltoLong;
		int bajar = 0;
		JButton arreglo[] = new JButton[idAlto+1];
		int primerId = Long.valueOf(productos.getPrimerId()).intValue();
		Producto aux = null;
		
		for(int i = primerId ; i <= idAlto; i++)
		{
			aux = productos.getProductoPorNombre(productos.getNombreProducto(i));
			
			if(aux.getStock() > 0)
			{
				arreglo[i] = new JButton(aux.getNombre());
				arreglo[i].setBounds(x, y, 316, 67);
				arreglo[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				arreglo[i].setForeground(new Color(255, 255, 255));
				arreglo[i].setBackground(new Color(0, 102, 255));
				arreglo[i].setBorder(UIManager.getBorder("CheckBox.border"));
				arreglo[i].setActionCommand(aux.getNombre());
				arreglo[i].addActionListener(new Pulsando(arreglo[i], productos, mercado));
				panel.add(arreglo[i]);
				x += 316 + 20;
				
				bajar++;
				if(bajar == 2) 
				{
					x = 150;
					y += 67 + 20;
				}
			}		
		}	
	}
	
	class Pulsando implements ActionListener{
		
		MapaProductos productos;
		JButton button;
		Supermercado mercado;
		
		public Pulsando(JButton button, MapaProductos productos, Supermercado mercado) {
			
			this.button = button;
			this.productos = productos;
			this.mercado = mercado;
		}
		
		public void actionPerformed(ActionEvent e) {
	        String actionCommand = ((JButton) e.getSource()).getActionCommand();
	        Producto seleccionado = productos.getProductoPorNombre(actionCommand);
	        setVisible(false);
	        new DetallesProducto(mercado, productos, seleccionado).setVisible(true);
	    }
		
	}
}
