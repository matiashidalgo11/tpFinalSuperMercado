package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Colecciones.ArregloDetalleCompra;
import Colecciones.ArregloProductos;
import Objetos.Carro;
import Objetos.DetalleCompra;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Producto;
import graficas.GraficaCarro.Pulsando;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class GraficaHistorial extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JLabel labelPerfil;
	private JScrollPane scrollPane;
	private JPanel panel;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(265, 58, 1016, 629);
		scrollPane.setBackground(new Color(0,0,0,0));
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(0,0,0,0));
		scrollPane.setViewportView(panel);
		
		labelPerfil = new JLabel(user.getUserName());
		labelPerfil.setForeground(Color.WHITE);
		labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerfil.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		labelPerfil.setBounds(38, 166, 208, 41);
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
		botonInicio.setBounds(53, 288, 196, 51);
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
		botonCarro.setBounds(48, 347, 196, 51);
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
		botonCuenta.setBounds(46, 406, 196, 51);
		contentPane.add(botonCuenta);
		
		
		fondo = new JLabel("");
		fondo.setBounds(10, 11, 1294, 721);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaHistorial.class.getResource("/img/Historial V2.png")));
		contentPane.add(fondo);
	}
	
//	void columnaProductos(ArregloDetalleCompra historial)
//	{
//		JLabel arregloBotones[] = new JLabel[historial.cantidad()];
//		int y = 40;
//		int yPanel = 620;
//		long id = 0;
//		int i = 0;
//		DetalleCompra detalles = historial.getArreglo().
//		
//		
//		for(Producto aux : historial.getArreglo())
//		{
//			arregloBotones[i] = new JLabel();
//			arregloBotones[i].setHorizontalAlignment(SwingConstants.LEFT);
//			arregloBotones[i].setFont(new Font("Calibri", Font.BOLD, 20));
//			arregloBotones[i].setForeground(new Color(51, 102, 153));
//			arregloBotones[i].setBounds(39, y, 838, 44);
//			panel.add(arregloBotones[i]);
//			y += 60;
//			i++;
//			
//			if(i >= 7)
//			{
//				yPanel += 60;
//				panel.setPreferredSize(new Dimension(1015, yPanel));
//			}
//		}
//	}
}
