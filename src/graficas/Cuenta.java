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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField fieldContraseñaGrafica;
	private JLabel editarNombreUsuario;
	private JTextField fieldUsuario;
	private JLabel botonGuardar;
	private JLabel editarContraseña;
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
	private JLabel labelPerfil;
	private JButton botonCerrarSesion;
	private JPasswordField fieldContraseñaReal;
	private JLabel labelCamposVacios;
	
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
		initComponents(mercado);
	}
	private void initComponents(Supermercado mercado) {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		
		Usuario user = mercado.getUsuarioEnSesion();
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,0,0,0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonCerrarSesion = new JButton("");
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				mercado.guardarDatos();
				dispose();
				new Principal(mercado).setVisible(true);
			}
		});
		botonCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				botonCerrarSesion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 102, 153)));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				botonCerrarSesion.setBorder(null);
			}
		});
		
		labelCamposVacios = new JLabel("Error! Hay campos vacios.");
		labelCamposVacios.setVisible(false);
		labelCamposVacios.setFont(new Font("Calibri", Font.BOLD, 20));
		labelCamposVacios.setForeground(Color.RED);
		labelCamposVacios.setBounds(836, 602, 279, 27);
		contentPane.add(labelCamposVacios);
		botonCerrarSesion.setContentAreaFilled(false);
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setOpaque(false);
		botonCerrarSesion.setBounds(81, 660, 129, 27);
		contentPane.add(botonCerrarSesion);
		
		
		labelPerfil = new JLabel(user.getUserName());
		labelPerfil.setForeground(Color.WHITE);
		labelPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		labelPerfil.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		labelPerfil.setBounds(38, 166, 208, 41);
		contentPane.add(labelPerfil);
		
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
		botonInicio.setBounds(49, 290, 196, 51);
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
		botonCarro.setBounds(44, 346, 196, 51);
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
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				dispose();
				new GraficaHistorial(mercado).setVisible(true);
			}
		});
		
		botonHistorial.setContentAreaFilled(false);
		botonHistorial.setBounds(48, 465, 196, 51);
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
		
		fieldContraseñaReal = new JPasswordField();
		fieldContraseñaReal.setText(user.getPassword());
		fieldContraseñaReal.setSelectionColor(new Color(51, 204, 255));
		fieldContraseñaReal.setOpaque(false);
		fieldContraseñaReal.setForeground(new Color(102, 102, 102));
		fieldContraseñaReal.setFont(new Font("Calibri", Font.PLAIN, 24));
		fieldContraseñaReal.setEditable(false);
		fieldContraseñaReal.setColumns(10);
		fieldContraseñaReal.setBorder(null);
		fieldContraseñaReal.setBackground(Color.WHITE);
		fieldContraseñaReal.setBounds(320, 224, 391, 30);
		contentPane.add(fieldContraseñaReal);
		
		fieldContraseñaGrafica = new JPasswordField();
		fieldContraseñaGrafica.setText(".......");
		fieldContraseñaGrafica.setSelectionColor(new Color(51, 204, 255));
		fieldContraseñaGrafica.setOpaque(false);
		fieldContraseñaGrafica.setForeground(new Color(102, 102, 102));
		fieldContraseñaGrafica.setFont(new Font("Calibri", Font.PLAIN, 24));
		fieldContraseñaGrafica.setEditable(false);
		fieldContraseñaGrafica.setColumns(10);
		fieldContraseñaGrafica.setBorder(null);
		fieldContraseñaGrafica.setBackground(Color.WHITE);
		fieldContraseñaGrafica.setBounds(320, 224, 391, 30);
		contentPane.add(fieldContraseñaGrafica);
		
		editarNombreUsuario = new JLabel("");
		editarNombreUsuario.setBounds(743, 117, 38, 35);
		editarNombreUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editarNombreUsuario.addMouseListener(new EditarField(fieldUsuario));
		contentPane.add(editarNombreUsuario);
		
		editarContraseña = new JLabel("");
		editarContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				fieldContraseñaGrafica.setVisible(false);
				fieldContraseñaReal.setVisible(true);
				fieldContraseñaReal.setEditable(true);
			}
		});
		editarContraseña.setBounds(742, 220, 38, 35);	
		editarContraseña.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(editarContraseña);
		
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
				if(!casillasVacias())
				{
					labelCamposVacios.setVisible(false);
					user.setUserName(fieldUsuario.getText());
					user.setPassword(fieldContraseñaReal.getText());
					user.setNombre(fieldNombre.getText());
					user.setApellido(fieldApellido.getText());
					user.setCartera(Double.valueOf(labelSaldo.getText()));
					user.setEdad(Integer.valueOf(fieldEdad.getText()));
					user.setTelefono(fieldTelefono.getText());
				}
				else
				{
					labelCamposVacios.setVisible(true);
				}
			}
		});
		botonGuardar.setBounds(836, 634, 224, 34);
		contentPane.add(botonGuardar);
		
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
		Fondo.setIcon(new ImageIcon(Cuenta.class.getResource("/img/Cuenta V2.png")));
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
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
		
	}
	
	boolean casillasVacias()
	{
		boolean verificar = false;
		if(fieldUsuario.getText().equals("") || fieldContraseñaReal.getText().equals("") || fieldNombre.getText().equals("")
				|| fieldApellido.getText().equals("") || fieldEdad.getText().equals("") || fieldTelefono.getText().equals("")
				|| labelSaldo.getText().equals(""))
		{
			verificar = true;
		}
		return verificar;
	}
}
