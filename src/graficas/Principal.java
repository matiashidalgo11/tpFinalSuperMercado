package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Supermercado;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel Fondo;
	private JButton btnSalir;
	private JButton btnRegistro;
	private JButton btnIniciarSesion;
	private Supermercado superAux;

	
	
	public Supermercado getSuperAux() {
		return superAux;
	}

	public void setSuperAux(Supermercado superAux) {
		this.superAux = superAux;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado superAux = new Supermercado();
					Principal frame = new Principal(superAux);
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
	public Principal(Supermercado superAux) {
		
		this.superAux = superAux;
		initComponents();
		AccionesBotonesPrincipales();
		
	}
	private void initComponents() {
		
		configuracionGeneral();
		botonesPrincipalesCaracteristicas();
		Fondo();
	}
	
	public void configuracionGeneral()
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void botonesPrincipalesCaracteristicas()
	{

		//Salir boton
		btnSalir = new JButton("");
		btnSalir.setVisible(true);
		btnSalir.setOpaque(false);
		btnSalir.setBorder(null);
		
		//Totalmente Transparente
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnSalir.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnSalir.setBorder(null);
			}
		});
		btnSalir.setBounds(747, 481, 259, 48);
		contentPane.add(btnSalir);
		
		//IniciarSesion Boton
		btnIniciarSesion = new JButton("");
		btnIniciarSesion.setVisible(true);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setBorder(null);
		
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setBorderPainted(false);
		
		btnIniciarSesion.setBounds(747, 298, 259, 54);
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnIniciarSesion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnIniciarSesion.setBorder(null);
			}
		});
		contentPane.add(btnIniciarSesion);
		
		
		
		//Registro boton
		btnRegistro = new JButton("");
		btnRegistro.setVisible(true);
		btnRegistro.setOpaque(false);
		btnRegistro.setBorder(null);
		
		btnRegistro.setContentAreaFilled(false);
		btnRegistro.setBorderPainted(false);
		
		btnRegistro.setBounds(747, 384, 259, 54);
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnRegistro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btnRegistro.setBorder(null);
			}
		});
		contentPane.add(btnRegistro);
		
	}
	
	public void Fondo()
	{
		Fondo = new JLabel("");
		Fondo.setForeground(new Color(0, 0, 0));
		Fondo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Fondo.setIcon(new ImageIcon(Principal.class.getResource("/img/Principal.png")));
		Fondo.setBounds(0, 0, 1300, 750);
		contentPane.add(Fondo);
	}
	
	public void AccionesBotonesPrincipales()
	{
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(getSuperAux());
				registro.setVisible(true);
				dispose();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	
}

