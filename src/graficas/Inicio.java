package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Colecciones.MapaCategoria;
import Colecciones.MapaProductos;
import Objetos.Carro;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Bebida;
import Productos.Lacteo;
import Productos.Snack;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class Inicio extends JFrame {

	private JPanel contentPane;
	int x;
	int y;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Inicio frame = new Inicio();
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
	public Inicio(Supermercado mercado) {
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750); //Tamaño por defecto del JFrame
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,0,0,0));
		
		
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
		
		JButton botonSalir = new JButton("X");
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonSalir.setBackground(new Color(192, 192, 192));
		botonSalir.setForeground(new Color(0, 0, 0));
		botonSalir.setBounds(1194, 14, 46, 26);
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				botonSalir.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonSalir.setBackground(new Color(192, 192, 192));
			}
		});
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		contentPane.add(botonSalir);
		labelMover.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		labelMover.setBounds(32, 11, 1233, 35);
		contentPane.add(labelMover);
		
		
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
		botonHistorial.setBounds(50, 467, 196, 51);
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
				new Cuenta(mercado).setVisible(true);
				setVisible(false);
			}
		});
		botonCuenta.setContentAreaFilled(false);
		botonCuenta.setBounds(50, 407, 196, 51);
		contentPane.add(botonCuenta);
		
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
				new graficaCarro(mercado).setVisible(true);
			}
		});
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(50, 347, 196, 51);
		contentPane.add(botonCarro);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setOpaque(false);
		panel.setBounds(254, 40, 1017, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		crearMatrizBotones(panel, mercado);

		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Inicio.class.getResource("/img/Inicio.png")));
		Fondo.setBounds(0, 0, 1294, 721); //Tamaño por defecto del fondo 
		contentPane.add(Fondo);
	}
	
	void crearMatrizBotones(JPanel panel, Supermercado mercado)
	{
		int x = 150;
		int y = 61;
		int bajar = 0;
		JButton arreglo[] = new JButton[mercado.getidCategoriaMasAlta()];
		
		for(int i = 0; i < mercado.getidCategoriaMasAlta(); i++)
		{
			try
			{
				arreglo[i] = new JButton(mercado.getNombreCategoria((long) i + 1) + "s");
				arreglo[i].setBounds(x, y, 316, 67);
				arreglo[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
				arreglo[i].setForeground(new Color(255, 255, 255));
				arreglo[i].setBackground(new Color(0, 102, 255));
				arreglo[i].setBorder(UIManager.getBorder("CheckBox.border"));
				arreglo[i].setActionCommand(mercado.getNombreCategoria((long) i + 1));
				arreglo[i].addActionListener(new Pulsando(arreglo[i], mercado));
				panel.add(arreglo[i]);
				
				x += 316 + 20;
				
				bajar++;
				
				if(bajar == 2) 
				{
					x = 150;
					y += 67 + 20;
				}
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
		}	
	}
	
	class Pulsando implements ActionListener{
		
		Supermercado mercado;
		JButton button;
		
		public Pulsando(JButton button, Supermercado mercado) {
			
			this.button = button;
			this.mercado = mercado;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
	        String actionCommand = ((JButton) e.getSource()).getActionCommand();
	        MapaProductos productos = mercado.getCategoriaPorNombre(actionCommand);
	        setVisible(false);
	        new Productos(mercado, productos).setVisible(true);
	    }
		
	}
}
