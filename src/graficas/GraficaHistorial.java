package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Supermercado;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		initComponents();
	}
	
	private void initComponents() 
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
		
		fondo = new JLabel("");
		fondo.setBounds(5, 5, 1290, 740);
		fondo.setIgnoreRepaint(true);
		fondo.setIcon(new ImageIcon(GraficaHistorial.class.getResource("/img/Historial.png")));
		contentPane.add(fondo);
	}

}
