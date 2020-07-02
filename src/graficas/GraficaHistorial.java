package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Supermercado;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GraficaHistorial extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;

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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

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
		fondo.setBounds(0, 0, 1294, 721);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaHistorial.class.getResource("/img/Historial.png")));
		contentPane.add(fondo);
	}

}
