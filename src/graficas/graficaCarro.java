package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Session;
import Objetos.Supermercado;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import Objetos.Carro;

public class graficaCarro extends JFrame {

	private JPanel contentPane;
	private JLabel fondo;
	private JTextPane textPane;

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
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setOpaque(false);
		textPane.setEditable(false);
		textPane.setBounds(260, 55, 1016, 639);
		Session activa = mercado.getSesionActiva();
		Carro carrito = activa.getCarrito();
		textPane.setText(carrito.listar());
		contentPane.add(textPane);
		
		fondo = new JLabel("");
		fondo.setIgnoreRepaint(true);
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIcon(new ImageIcon(graficaCarro.class.getResource("/img/Carro.png")));
		contentPane.add(fondo);
	}
}
