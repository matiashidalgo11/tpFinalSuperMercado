package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Cuenta extends JFrame {

	private JPanel contentPane;
	private Usuario prueba = new Usuario("Alan", "123", 0, 1, null);
	private JPasswordField fieldContrase�a;
	private JLabel editarNombreUsuario;
	private JTextField fieldUsuario;
	private JLabel botonGuardar;
	private JLabel editarContrase�a;
	private JLabel labelSaldo;
	private JLabel agregarDinero;
	private JTextField fieldIngresar;
	private JLabel lblNewLabel;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuenta frame = new Cuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Cuenta() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		setBackground(new Color(0,0,0,0));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		fieldUsuario.setText("Alan");
		fieldUsuario.setBounds(321, 121, 400, 29);
		contentPane.add(fieldUsuario);
		fieldUsuario.setColumns(10);
		
		fieldContrase�a = new JPasswordField();
		fieldContrase�a.setText(".......");
		fieldContrase�a.setSelectionColor(new Color(51, 204, 255));
		fieldContrase�a.setOpaque(false);
		fieldContrase�a.setForeground(new Color(102, 102, 102));
		fieldContrase�a.setFont(new Font("Calibri", Font.PLAIN, 24));
		fieldContrase�a.setEditable(false);
		fieldContrase�a.setColumns(10);
		fieldContrase�a.setBorder(null);
		fieldContrase�a.setBackground(Color.WHITE);
		fieldContrase�a.setBounds(320, 224, 391, 30);
		contentPane.add(fieldContrase�a);
		
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
		
		editarContrase�a = new JLabel("");
		editarContrase�a.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarContrase�a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				fieldContrase�a.setEditable(true);
				fieldContrase�a.selectAll();
			}
		});
		editarContrase�a.setBounds(742, 220, 38, 35);
		contentPane.add(editarContrase�a);
		editarNombreUsuario.setBounds(743, 117, 38, 35);
		contentPane.add(editarNombreUsuario);
		
		botonGuardar = new JLabel("");
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				prueba.setNombre(fieldUsuario.getText());
				prueba.setPassword(fieldContrase�a.getText());
			}
		});
		botonGuardar.setBounds(836, 634, 224, 34);
		contentPane.add(botonGuardar);
		
		prueba.setCartera(500);
		labelSaldo = new JLabel("");
		labelSaldo.setForeground(new Color(102, 102, 102));
		labelSaldo.setFont(new Font("Calibri", Font.PLAIN, 23));
		labelSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		labelSaldo.setBounds(876, 419, 184, 41);
		String saldo = String.valueOf(prueba.getCartera());
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
				prueba.setCartera(prueba.getCartera() + Double.valueOf(fieldIngresar.getText()));
				labelSaldo.setText(String.valueOf(prueba.getCartera()));
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
