package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Supermercado;
import productos.MapaProductos;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Productos extends JFrame {

	private JPanel contentPane;
	int x, y;
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
		labelMover.setBounds(43, 30, 1233, 35);
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
				new Inicio(mercado).setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		botonInicio.setBounds(52, 302, 196, 51);
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
		});
		contentPane.setLayout(null);
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(53, 363, 196, 51);
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
				new Cuenta(mercado).setVisible(true);
				setVisible(false);
			}
		});
		botonCuenta.setContentAreaFilled(false);
		botonCuenta.setBounds(53, 421, 196, 51);
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
		});
		
		botonHistorial.setContentAreaFilled(false);
		botonHistorial.setBounds(55, 480, 196, 51);
		contentPane.add(botonHistorial);
		
		
		
		
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIcon(new ImageIcon(Productos.class.getResource("/img/Productos.png")));
		contentPane.add(fondo);
	}

}
