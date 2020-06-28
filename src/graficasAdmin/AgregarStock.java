package graficasAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Objetos.Supermercado;
import graficas.Principal;

public class AgregarStock extends JFrame {

	private JPanel contentPane;
	private Supermercado datos;
	private JLabel Fondo;
	private JButton btnAgregarProducto;
	private JButton btnEliminarProducto;
	private JButton btnModificarProducto;
	private JButton btnAgregarUsuario;
	private JButton btnEliminarUsuario;
	private JButton btnCrearOferta;
	private JButton btnCerrarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado aux = new Supermercado();
					AgregarStock frame = new AgregarStock(aux);
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
	public AgregarStock(Supermercado superAux) {
		
		datos = superAux;
		initComponents();
	}
	
	private void initComponents() {

		configuracionGeneral();
		configuracionBotones();
		accionesBotonesMenu();
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
	}
	
	public void Fondo()
	{
		contentPane.setLayout(null);
		
		Fondo = new JLabel("");
		Fondo.setBounds(0, 0, 1300, 750);
		Fondo.setForeground(new Color(0, 0, 0));
		Fondo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Fondo.setIcon(new ImageIcon(Principal.class.getResource("/img/Agregar Stock.png")));
		contentPane.add(Fondo);
		
	
	}
	
	public void configuracionBotones()
	{

				btnAgregarProducto = new JButton("CANCELAR");
				btnAgregarProducto.setVisible(true);
				btnAgregarProducto.setOpaque(false);
				btnAgregarProducto.setBorder(null);


				btnAgregarProducto.setContentAreaFilled(false);
				btnAgregarProducto.setBorderPainted(false);

				btnAgregarProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnAgregarProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnAgregarProducto.setBorder(null);
					}
				});
				btnAgregarProducto.setBounds(32, 275, 221, 43);
				contentPane.add(btnAgregarProducto);
				

				btnEliminarProducto = new JButton("CANCELAR");
				btnEliminarProducto.setVisible(true);
				btnEliminarProducto.setOpaque(false);
				btnEliminarProducto.setBorder(null);

				// Totalmente Transparente
				btnEliminarProducto.setContentAreaFilled(false);
				btnEliminarProducto.setBorderPainted(false);

				btnEliminarProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnEliminarProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnEliminarProducto.setBorder(null);
					}
				});
				btnEliminarProducto.setBounds(32, 316, 221, 43);
				contentPane.add(btnEliminarProducto);

				btnModificarProducto = new JButton("CANCELAR");
				btnModificarProducto.setVisible(true);
				btnModificarProducto.setOpaque(false);
				btnModificarProducto.setBorder(null);

				// Totalmente Transparente
				btnModificarProducto.setContentAreaFilled(false);
				btnModificarProducto.setBorderPainted(false);

				btnModificarProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnModificarProducto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnModificarProducto.setBorder(null);
					}
				});
				btnModificarProducto.setBounds(32, 406, 221, 43);
				contentPane.add(btnModificarProducto);
				

				btnAgregarUsuario = new JButton("CANCELAR");
				btnAgregarUsuario.setVisible(true);
				btnAgregarUsuario.setOpaque(false);
				btnAgregarUsuario.setBorder(null);

				// Totalmente Transparente
				btnAgregarUsuario.setContentAreaFilled(false);
				btnAgregarUsuario.setBorderPainted(false);

				btnAgregarUsuario.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnAgregarUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnAgregarUsuario.setBorder(null);
					}
				});
				btnAgregarUsuario.setBounds(32, 448, 221, 43);
				contentPane.add(btnAgregarUsuario);
				

				btnEliminarUsuario = new JButton("CANCELAR");
				btnEliminarUsuario.setVisible(true);
				btnEliminarUsuario.setOpaque(false);
				btnEliminarUsuario.setBorder(null);

				// Totalmente Transparente
				btnEliminarUsuario.setContentAreaFilled(false);
				btnEliminarUsuario.setBorderPainted(false);

				btnEliminarUsuario.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnEliminarUsuario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnEliminarUsuario.setBorder(null);
					}
				});
				btnEliminarUsuario.setBounds(32, 490, 221, 43);
				contentPane.add(btnEliminarUsuario);
				

				btnCrearOferta = new JButton("CANCELAR");
				btnCrearOferta.setVisible(true);
				btnCrearOferta.setOpaque(false);
				btnCrearOferta.setBorder(null);

				// Totalmente Transparente
				btnCrearOferta.setContentAreaFilled(false);
				btnCrearOferta.setBorderPainted(false);

				btnCrearOferta.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCrearOferta.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnCrearOferta.setBorder(null);
					}
				});
				btnCrearOferta.setBounds(32, 532, 221, 43);
				contentPane.add(btnCrearOferta);

				// Cancelar boton
				btnCerrarSesion = new JButton("CANCELAR");
				btnCerrarSesion.setVisible(true);
				btnCerrarSesion.setOpaque(false);
				btnCerrarSesion.setBorder(null);

				// Totalmente Transparente
				btnCerrarSesion.setContentAreaFilled(false);
				btnCerrarSesion.setBorderPainted(false);

				btnCerrarSesion.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCerrarSesion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnCerrarSesion.setBorder(null);
					}
				});
				btnCerrarSesion.setBounds(80, 675, 131, 27);
				contentPane.add(btnCerrarSesion);


				
	}
	
	public void accionesBotonesMenu()
	{
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProducto aux= new AgregarProducto(datos);
				dispose();
				aux.setVisible(true);
			}
		});
		
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto aux = new EliminarProducto(datos);
				dispose();
				aux.setVisible(true);
				
			}
		});
		

		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProducto aux = new ModificarProducto(datos);
				dispose();
				aux.setVisible(true);
				
			}
		});
		
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarUsuario aux = new AgregarUsuario(datos);
				dispose();
				aux.setVisible(true);
			}
		});
		
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarUsuario aux = new EliminarUsuario(datos);
				dispose();
				aux.setVisible(true);
			}
		});
		
		btnCrearOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearOferta aux = new CrearOferta(datos);
				dispose();
				aux.setVisible(true);
			}
		});
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.guardarDatos();
				Principal aux = new Principal(datos);
				dispose();
				aux.setVisible(true);
			}
		});
		
	}

}
