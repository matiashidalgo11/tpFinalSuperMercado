package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Carro;
import Objetos.Supermercado;
import Objetos.Usuario;
import productos.Bebidas;
import productos.Lacteo;
import productos.MapaCategoria;
import productos.MapaProductos;
import productos.Snack;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class Inicio extends JFrame {

	private JPanel contentPane;
	int x;
	int y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		
		Usuario alan = new Usuario("Alan", "123", 500, 1, null);
		
		Bebidas coca = new Bebidas("Cola", 60, "Coca", 1, 1, true, 2, "Dulce", false);
		Bebidas jugo = new Bebidas("Jugo", 30, "Cualquiera", 1, 1, false, 2, "Dulce", false);
		Bebidas cerveza = new Bebidas("Cerveza", 100, "Quilmes", 1, 1, false, 2, "Amargo", true);
		Bebidas agua = new Bebidas("Agua", 50, "Mineral", 1, 1, false, 2, "Agua", false);
		
		Snack papas = new Snack("Papas Frita", 70, "Lays", 1, 2, 100);
		Snack palitos = new Snack("Palitos", 40, "Palitos", 1, 2, 100);	
		
		Lacteo leche = new Lacteo("Leche", 50, "LaSerenisima", 1, 3, "Leche");
		
		MapaProductos lacteos = new MapaProductos();
		lacteos.agregar(leche.getIdCategoria(), leche);
		
		MapaProductos snacks = new MapaProductos();
		snacks.agregar(papas.getIdProducto(), papas);
		snacks.agregar(palitos.getIdProducto(), palitos);
		
		MapaProductos bebidas = new MapaProductos();
		bebidas.agregar(coca.getIdProducto(), coca);
		bebidas.agregar(jugo.getIdProducto(), jugo);
		bebidas.agregar(cerveza.getIdProducto(), cerveza);
		bebidas.agregar(agua.getIdProducto(), agua);
		
		MapaCategoria categorias = new MapaCategoria();
		categorias.agregar((long) 1, bebidas);
		categorias.agregar((long) 2, snacks);
		categorias.agregar((long) 3, lacteos);
		
		Carro carrito = new Carro();
		
		Supermercado mercado = new Supermercado(alan, carrito);
		mercado.agregarProducto((long) 1, bebidas);
		mercado.agregarProducto((long) 2, snacks);
		mercado.agregarProducto((long) 3, lacteos);
		
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
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
		labelMover.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		labelMover.setBounds(32, 11, 1233, 35);
		contentPane.add(labelMover);
		
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
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(50, 467, 196, 51);
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
		botonCuenta.setBounds(50, 407, 196, 51);
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
		botonHistorial.setBounds(50, 347, 196, 51);
		contentPane.add(botonHistorial);
		
		JPanel panel = new JPanel();
		panel.setBounds(254, 40, 1017, 641);
		contentPane.add(panel);
		panel.setLayout(null);

		crearMatrizBotones(panel, mercado);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Inicio.class.getResource("/img/Inicio.png")));
		Fondo.setBounds(0, 0, 1294, 721);
		contentPane.add(Fondo);
	}
	
	static void crearMatrizBotones(JPanel panel, Supermercado mercado)
	{
		int x = 54;
		int y = 52;
		JButton arreglo[] = new JButton[mercado.cantidadCategorias()];
		for(int i = 0; i < mercado.cantidadCategorias(); i++)
		{
			arreglo[i] = new JButton(mercado.getNombreCategoria((long) i + 1));
			arreglo[i].setBounds(x, y, 192, 40);
			panel.add(arreglo[i]);
			x += 192 + 20;
			
			if(i == 4) 
			{
				x = 54;
				y += 40 + 20;
			}
		}	
	}
	
}
