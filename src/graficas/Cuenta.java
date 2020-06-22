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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Cuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField fieldContrase�a;
	private JLabel editarNombreUsuario;
	private JTextField fieldUsuario;
	private JLabel botonGuardar;
	private JLabel editarContrase�a;
	private JLabel labelSaldo;
	private JLabel agregarDinero;
	private JTextField fieldIngresar;
	private JLabel lblNewLabel;
	int x, y;
	private JTextField fieldNombre;
	private JTextField fieldApellido;
	private JTextField fieldEdad;
	private JTextField fieldTelefono;
	private JLabel editarNombre;
	private JLabel editarApellido;
	private JLabel editarEdad;
	private JLabel editarTelefono;
	
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
		
		Usuario user = new Usuario("AlanGmer", "123", "Alan", "Perez", 22, "123456");
		
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
				new Inicio(mercado).setVisible(true);
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
		
		fieldTelefono = new JTextField();
		fieldTelefono.setText("Alan");
		fieldTelefono.setOpaque(false);
		fieldTelefono.setForeground(new Color(102, 102, 102));
		fieldTelefono.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldTelefono.setEditable(false);
		fieldTelefono.setColumns(10);
		fieldTelefono.setCaretColor(Color.BLACK);
		fieldTelefono.setBorder(null);
		fieldTelefono.setBackground(Color.WHITE);
		fieldTelefono.setBounds(317, 641, 400, 29);
		fieldTelefono.setText(user.getTelefono());
		contentPane.add(fieldTelefono);
		
		fieldEdad = new JTextField();
		fieldEdad.setText("Alan");
		fieldEdad.setOpaque(false);
		fieldEdad.setForeground(new Color(102, 102, 102));
		fieldEdad.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldEdad.setEditable(false);
		fieldEdad.setColumns(10);
		fieldEdad.setCaretColor(Color.BLACK);
		fieldEdad.setBorder(null);
		fieldEdad.setBackground(Color.WHITE);
		fieldEdad.setBounds(317, 538, 400, 29);
		fieldEdad.setText(String.valueOf(user.getEdad()));
		contentPane.add(fieldEdad);
		
		fieldApellido = new JTextField();
		fieldApellido.setText("Alan");
		fieldApellido.setOpaque(false);
		fieldApellido.setForeground(new Color(102, 102, 102));
		fieldApellido.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldApellido.setEditable(false);
		fieldApellido.setColumns(10);
		fieldApellido.setCaretColor(Color.BLACK);
		fieldApellido.setBorder(null);
		fieldApellido.setBackground(Color.WHITE);
		fieldApellido.setBounds(318, 435, 400, 29);
		fieldApellido.setText(user.getApellido());
		contentPane.add(fieldApellido);
		
		fieldNombre = new JTextField();
		fieldNombre.setOpaque(false);
		fieldNombre.setForeground(new Color(102, 102, 102));
		fieldNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldNombre.setEditable(false);
		fieldNombre.setColumns(10);
		fieldNombre.setCaretColor(Color.BLACK);
		fieldNombre.setBorder(null);
		fieldNombre.setBackground(Color.WHITE);
		fieldNombre.setBounds(318, 334, 400, 29);
		fieldNombre.setText(user.getNombre());
		contentPane.add(fieldNombre);
		
		
		fieldUsuario = new JTextField();
		fieldUsuario.setCaretColor(new Color(0, 0, 0));
		fieldUsuario.setBackground(new Color(255, 255, 255));
		fieldUsuario.setBorder(null);
		fieldUsuario.setOpaque(false);
		fieldUsuario.setEditable(false);
		fieldUsuario.setForeground(new Color(102, 102, 102));
		fieldUsuario.setFont(new Font("Calibri", Font.PLAIN, 23));
		fieldUsuario.setText(user.getUserName());
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
		editarNombreUsuario.setBounds(743, 117, 38, 35);
		editarNombreUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarNombreUsuario.addMouseListener(new EditarField(fieldUsuario));
		contentPane.add(editarNombreUsuario);
		
		editarContrase�a = new JLabel("");
		editarContrase�a.setBounds(742, 220, 38, 35);	
		editarContrase�a.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarContrase�a.addMouseListener(new EditarField(fieldContrase�a));
		contentPane.add(editarContrase�a);
		
		editarNombre = new JLabel("");
		editarNombre.setBounds(742, 327, 38, 35);
		editarNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarNombre.addMouseListener(new EditarField(fieldNombre));
		contentPane.add(editarNombre);
		
		editarApellido = new JLabel("");
		editarApellido.setBounds(742, 431, 38, 35);
		editarApellido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarApellido.addMouseListener(new EditarField(fieldApellido));
		contentPane.add(editarApellido);
		
		editarEdad = new JLabel("");
		editarEdad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarEdad.setBounds(742, 535, 38, 35);
		editarEdad.addMouseListener(new EditarField(fieldEdad));
		contentPane.add(editarEdad);
		
		editarTelefono = new JLabel("");
		editarTelefono.setBounds(742, 636, 38, 35);
		editarTelefono.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarTelefono.addMouseListener(new EditarField(fieldTelefono));
		contentPane.add(editarTelefono);
		
		botonGuardar = new JLabel("");
		botonGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				user.setUserName(fieldUsuario.getText());
				user.setPassword(fieldContrase�a.getText());
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
	
	class EditarField implements MouseListener
	{

		JTextField fieldEditar;
		
		public EditarField(JTextField fieldEditar)
		{
			this.fieldEditar = fieldEditar;
		}
		
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			fieldEditar.setEditable(true);			
			fieldEditar.selectAll();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
}
