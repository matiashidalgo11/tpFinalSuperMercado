package graficas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Excepciones.CamposVacios;
import Excepciones.LoginAdmin;
import Excepciones.LoginIncorrecto;
import Objetos.Supermercado;
import Objetos.Usuario;
import graficasAdmin.AdminMenuPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JLabel Fondo;
	private JTextField txtNombreUser;
	private JPasswordField txtPassword;
	private JButton btnIniciar;
	private Supermercado superAux;
	
	private static String ADMIN_NAME = "admin";
	private static String ADMIN_PASSWORD = "1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado aux = new Supermercado();
					InicioSesion frame = new InicioSesion(aux);
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
	public InicioSesion(Supermercado superAux) {
		this.superAux = superAux;
		initComponents();
		accionesBotones();
		
	}
	
	private void initComponents() {
		configuracionGeneral();
		configuracionTxt();
		configuracionBotones();
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
		Fondo.setIcon(new ImageIcon(Principal.class.getResource("/img/Inicio Sesion.png")));
		Fondo.setBounds(0, 0, 1300, 750);
		contentPane.add(Fondo);
	}
	
	public void configuracionTxt()
	{
		txtNombreUser = new JTextField();
		txtNombreUser.setDisabledTextColor(Color.GRAY);
		txtNombreUser.setOpaque(false);
		txtNombreUser.setForeground(Color.GRAY);
		txtNombreUser.setFont(new Font("Calibri", Font.PLAIN, 23));
		txtNombreUser.setEditable(true);
		txtNombreUser.setColumns(10);
		txtNombreUser.setCaretColor(Color.BLACK);
		txtNombreUser.setBorder(null);
		txtNombreUser.setBackground(Color.WHITE);
		txtNombreUser.setBounds(554, 216, 224, 35);
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
		txtPassword.setBounds(554, 336, 224, 35);
		contentPane.add(txtPassword);
	}

	public void configuracionBotones() {

		// Siguiente boton
		btnIniciar = new JButton("");
		btnIniciar.setVisible(true);
		btnIniciar.setOpaque(false);
		btnIniciar.setBorder(null);

		// Totalmente Transparente
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBorderPainted(false);

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciar.setBorder(null);
			}
		});

		btnIniciar.setBounds(509, 414, 159, 48);
		contentPane.add(btnIniciar);
	}
	
	public void accionesBotones()
	{
		//Incompleto
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					
					if (txtNombreUser.getText().length() == 0 || txtPassword.getText().length() == 0) {
						
						int vacios  = contarCamposVacios();
						throw new CamposVacios("Faltan Llenar los Campos",vacios);
						
					
					}else if(txtNombreUser.getText().equals(ADMIN_NAME) && txtPassword.getText().equals(ADMIN_PASSWORD))
					{
						throw new LoginAdmin();
						
					}else if(!superAux.existeUsuario(txtNombreUser.getText()))
					{
						throw new LoginIncorrecto("El usuario no existe", txtNombreUser, txtPassword);
					}else 
					{
						Usuario aux = superAux.buscarUsuario(txtNombreUser.getText());
						
						if(!aux.getPassword().equals(txtPassword.getText()))
						{
							throw new LoginIncorrecto("Password", txtPassword);
						}else
						{
							superAux.iniciarSession(aux.getId());
							Inicio iniciar = new Inicio(superAux);
							iniciar.setVisible(true);
							dispose();
						}
					}

				} catch (CamposVacios c) {
					System.out.println(c.getMessage());
	
					
				} catch (LoginIncorrecto e1) {
					e1.printStackTrace();
					
				} catch (LoginAdmin e1) {
					
					e1.printStackTrace();
					AdminMenuPrincipal nuevo = new AdminMenuPrincipal(superAux);
					nuevo.setVisible(true);
					dispose();
					
				}

			}
				
			
		});
		
		
		
		
	}
	
	public int contarCamposVacios()
	{
		int resp = 0;
		if(txtNombreUser.getText().isEmpty())
		{
			resp++;
		}
		if(txtPassword.getText().isEmpty())
		{
			resp++;
		}
		return resp;
	}
	
	
}
