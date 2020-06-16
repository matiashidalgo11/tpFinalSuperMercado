package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Supermercado;
import Objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Cuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField fieldContraseña;
	private JLabel editarNombreUsuario;
	private JTextField fieldUsuario;
	private JLabel botonGuardar;
	private JLabel editarContraseña;
	private JLabel labelSaldo;
	private JLabel agregarDinero;
	private JTextField fieldIngresar;
	private JLabel lblNewLabel;
	int x, y;
	
//	public static void main(String[] args) 
//	{
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cuenta frame = new Cuenta();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public Cuenta(Supermercado mercado) 
	{
		
		Usuario user = mercado.getUsuarioEnSesion();
		
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
		
		JButton botonInicio = new JButton("");
		botonInicio.setVisible(true);
		botonInicio.setOpaque(false);
		botonInicio.setBorder(null);
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
				new Inicio().setVisible(true);
				setVisible(false);
			}
		});
		botonInicio.setContentAreaFilled(false);
		botonInicio.setBounds(50, 289, 196, 51);
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
		
		botonCarro.setContentAreaFilled(false);
		botonCarro.setBounds(50, 467, 196, 51);
		contentPane.add(botonCarro);
		
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
		
		
		fieldUsuario = new JTextField();
		fieldUsuario.setCaretColor(new Color(0, 0, 0));
		fieldUsuario.setBackground(new Color(255, 255, 255));
		fieldUsuario.setBorder(null);
		fieldUsuario.setOpaque(false);
		fieldUsuario.setEditable(false);
		fieldUsuario.setForeground(new Color(102, 102, 102));
		fieldUsuario.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldUsuario.setText(user.getNombre());
		fieldUsuario.setBounds(321, 121, 400, 29);
		contentPane.add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		fieldContraseña = new JPasswordField();
		fieldContraseña.setText(".......");
		fieldContraseña.setSelectionColor(new Color(51, 204, 255));
		fieldContraseña.setOpaque(false);
		fieldContraseña.setForeground(new Color(102, 102, 102));
		fieldContraseña.setFont(new Font("Calibri", Font.PLAIN, 24));
		fieldContraseña.setEditable(false);
		fieldContraseña.setColumns(10);
		fieldContraseña.setBorder(null);
		fieldContraseña.setBackground(Color.WHITE);
		fieldContraseña.setBounds(320, 224, 391, 30);
		contentPane.add(fieldContraseña);
		
		editarNombreUsuario = new JLabel("");
		editarNombreUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarNombreUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				fieldUsuario.setEditable(true);			
				fieldUsuario.selectAll();
			}
		});
		
		editarContraseña = new JLabel("");
		editarContraseña.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				fieldContraseña.setEditable(true);
				fieldContraseña.selectAll();
			}
		});
		editarContraseña.setBounds(742, 220, 38, 35);
		contentPane.add(editarContraseña);
		editarNombreUsuario.setBounds(743, 117, 38, 35);
		contentPane.add(editarNombreUsuario);
		
		botonGuardar = new JLabel("");
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				user.setNombre(fieldUsuario.getText());
				user.setPassword(fieldContraseña.getText());
			}
		});
		botonGuardar.setBounds(836, 634, 224, 34);
		contentPane.add(botonGuardar);
		
		user.setCartera(500);
		labelSaldo = new JLabel("");
		labelSaldo.setForeground(new Color(102, 102, 102));
		labelSaldo.setFont(new Font("Calibri", Font.PLAIN, 23));
		labelSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSaldo.setBounds(876, 419, 184, 41);
		String saldo = String.valueOf(user.getCartera());
		labelSaldo.setText(saldo);
		contentPane.add(labelSaldo);
		
		fieldIngresar = new JTextField();
		fieldIngresar.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldIngresar.setBorder(null);
		fieldIngresar.setOpaque(false);
		fieldIngresar.setBounds(843, 534, 268, 29);
		contentPane.add(fieldIngresar);
		fieldIngresar.setColumns(10);
		
		agregarDinero = new JLabel("");
		agregarDinero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				user.setCartera(user.getCartera() + Double.valueOf(fieldIngresar.getText()));
				labelSaldo.setText(String.valueOf(user.getCartera()));
				fieldIngresar.setText("");
			}
		});
		agregarDinero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarDinero.setBounds(1142, 526, 38, 36);
		contentPane.add(agregarDinero);

		
		JLabel Fondo = new JLabel("");
		Fondo.setForeground(new Color(0, 0, 0));
		Fondo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Fondo.setIcon(new ImageIcon(Cuenta.class.getResource("/img/Cuenta.png")));
		Fondo.setBounds(0, 0, 1294, 721);
		contentPane.add(Fondo);
	}
}
