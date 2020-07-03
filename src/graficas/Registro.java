package graficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Supermercado;
import Objetos.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JLabel Fondo;
	private JButton btnSiguiente;
	//Configurar imagen para agregar boton
	private JButton btnCancelar;
	private JTextField txtNombreUser;
	private JPasswordField txtPassword;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private Supermercado superAux;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	
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
					Registro frame = new Registro(superAux);
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
	public Registro(Supermercado superAux) {
		
		this.superAux = superAux;
		initComponents();
		accionesBotones();
		
	}
	private void initComponents() {
		
		configuracionGeneral();
		configuracionBotones();
		configuracionTxt();
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
	
	public void Fondo()
	{
		
		Fondo = new JLabel("");
		Fondo.setForeground(new Color(0, 0, 0));
		Fondo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Fondo.setIcon(new ImageIcon(Principal.class.getResource("/img/Registro V2.png")));
		Fondo.setBounds(0, 0, 1300, 750);
		contentPane.add(Fondo);
	}
	
	public void configuracionBotones() {
		
		// Siguiente boton
		btnSiguiente = new JButton("");
		btnSiguiente.setVisible(true);
		btnSiguiente.setOpaque(false);
		btnSiguiente.setBorder(null);

		// Totalmente Transparente
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorderPainted(false);

		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSiguiente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSiguiente.setBorder(null);
			}
		});

		// Cancelar boton
		btnCancelar = new JButton("");
		btnCancelar.setVisible(true);
		btnCancelar.setOpaque(false);
		btnCancelar.setBorder(null);

		// Totalmente Transparente
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setBorder(null);
			}
		});
		btnCancelar.setBounds(867, 636, 221, 43);
		contentPane.add(btnCancelar);

		btnSiguiente.setBounds(554, 636, 221, 43);
		contentPane.add(btnSiguiente);

	}
	
	public void configuracionTxt()
	{
		txtNombreUser = new JTextField();
		txtNombreUser.setOpaque(false);
		txtNombreUser.setForeground(new Color(102, 102, 102));
		txtNombreUser.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombreUser.setEditable(true);
		txtNombreUser.setColumns(10);
		txtNombreUser.setCaretColor(Color.BLACK);
		txtNombreUser.setBorder(null);
		txtNombreUser.setBackground(Color.WHITE);
		txtNombreUser.setBounds(554, 99, 622, 35);
		contentPane.add(txtNombreUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setSelectionColor(new Color(51, 204, 255));
		txtPassword.setOpaque(false);
		txtPassword.setForeground(new Color(102, 102, 102));
		txtPassword.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtPassword.setEditable(true);
		txtPassword.setColumns(10);
		txtPassword.setBorder(null);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(554, 193, 623, 35);
		contentPane.add(txtPassword);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setForeground(new Color(102, 102, 102));
		txtNombre.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombre.setEditable(true);
		txtNombre.setColumns(10);
		txtNombre.setCaretColor(Color.BLACK);
		txtNombre.setBorder(null);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(554, 287, 623, 35);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setOpaque(false);
		txtApellido.setForeground(new Color(102, 102, 102));
		txtApellido.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtApellido.setEditable(true);
		txtApellido.setColumns(10);
		txtApellido.setCaretColor(Color.BLACK);
		txtApellido.setBorder(null);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(554, 382, 623, 35);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setForeground(new Color(102, 102, 102));
		txtTelefono.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtTelefono.setEditable(true);
		txtTelefono.setColumns(10);
		txtTelefono.setCaretColor(Color.BLACK);
		txtTelefono.setBorder(null);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(554, 566, 622, 35);
		contentPane.add(txtTelefono);
		
		txtEdad = new JTextField();
		txtEdad.setOpaque(false);
		txtEdad.setForeground(new Color(102, 102, 102));
		txtEdad.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtEdad.setEditable(true);
		txtEdad.setColumns(10);
		txtEdad.setCaretColor(Color.BLACK);
		txtEdad.setBorder(null);
		txtEdad.setBackground(Color.WHITE);
		txtEdad.setBounds(554, 481, 400, 29);
		contentPane.add(txtEdad);
		
	}
	
	//Agrega excepciones
	public void accionesBotones()
	{
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal(getSuperAux());
				principal.setVisible(true);
				dispose();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Desarrollar accion de registro
				if(superAux.existeUsuario(txtNombreUser.getText()))
				{
					System.out.println("EXISTE USUARIO");
					
				}else if(txtNombreUser.getText().equals(txtNombre.getText()))
				{
					System.out.println("No se puede colocar el Mismo nombre para Usuario y nombre");
				}else
				{	
					Usuario nuevo = new Usuario(txtNombreUser.getText(), txtPassword.getText(), txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtEdad.getText()), txtTelefono.getText());
					superAux.agregarUsuario(nuevo);
					Principal p = new Principal(superAux);
					p.setVisible(true);
					dispose();
				}
				
				
			}
		});
	}

}
