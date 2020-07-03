package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import Colecciones.ArregloDetalleCompra;
import Colecciones.ArregloProductos;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Session;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Producto;
import graficas.GraficaCarro.Pulsando;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class GraficaHistorial extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JLabel labelPerfil;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton botonCerrarSesion;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GraficaHistorial frame = new GraficaHistorial();
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
	public GraficaHistorial(Supermercado mercado) 
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
		Session activa = mercado.getSesionActiva();
		
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
		botonCerrarSesion.setContentAreaFilled(false);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setOpaque(false);
		botonCerrarSesion.setBounds(81, 660, 129, 27);
		contentPane.add(botonCerrarSesion);
				
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1015, 620));
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(254, 45, 1016, 629);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(panel);
		contentPane.add(scrollPane);
		
		
		labelPerfil = new JLabel(user.getUserName());
		labelPerfil.setForeground(Color.WHITE);
		labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerfil.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		labelPerfil.setBounds(37, 167, 208, 41);
		contentPane.add(labelPerfil);
		

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
		botonInicio.setBounds(52, 289, 196, 51);
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
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(47, 348, 196, 51);
		contentPane.add(botonCarro);

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
		botonCuenta.setBounds(45, 407, 196, 51);
		contentPane.add(botonCuenta);
		
		columnaProductos(user.getHistorialCompra());
		scrollPane.getViewport().setViewPosition( new Point(0, 0) );
		
		fondo = new JLabel("");
		fondo.setBounds(0, 0, 1294, 721);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaHistorial.class.getResource("/img/Historial V2.png")));
		contentPane.add(fondo);
	}
	
	void columnaProductos(ArregloDetalleCompra historial)
	{
		JTextPane arregloLabel[] = new JTextPane[historial.cantidad()];
		int y = 40;
		int yPanel = 620;
		long id = 0;
		int i = 0;
		ArrayList<DetalleCompra> detalles = historial.getArreglo();
		
		
		for(DetalleCompra aux : detalles)
		{
			arregloLabel[i] = new JTextPane();
			arregloLabel[i].setText(aux.toString());
			arregloLabel[i].setFont(new Font("Calibri", Font.BOLD, 20));
			arregloLabel[i].setForeground(new Color(51, 102, 153));
			arregloLabel[i].setBackground(new Color(0,0,0,0));
			arregloLabel[i].setBounds(39, y, 838, 300);
			panel.add(arregloLabel[i]);
			y += 300;
			i++;
			
			if(i >= 1)
			{
				yPanel += 300;
				panel.setPreferredSize(new Dimension(1015, yPanel));
			}	
			
			scrollPane.getViewport().setViewPosition( new Point(0, 0) );
		}
	}
}
