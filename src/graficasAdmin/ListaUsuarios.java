package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Objetos.Supermercado;
import Objetos.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Component;

public class ListaUsuarios extends JPanel {
	
	public DefaultTableModel modeloTabla;
	public JScrollPane scrollPane;
	public JTable table;
	public JPopupMenu popupMenu;
	public JMenuItem itemEliminar;
	public JMenuItem itemActivar;
	public Supermercado datos;
	/**
	 * Create the panel.
	 */
	public ListaUsuarios(Supermercado datos) {
		this.datos = datos;
		initComponents();
	}
	private void initComponents() {
		
		
		setBounds(159, 90, 724, 588);
		setLayout(null);
		modeloTabla = new DefaultTableModel();
		
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Usuario");
		modeloTabla.addColumn("Password");
		modeloTabla.addColumn("Cartera");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Telefono");
		modeloTabla.addColumn("Edad");
		modeloTabla.addColumn("Cant Compras");
		modeloTabla.addColumn("Activo");
		
		cargarLista(datos);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 704, 566);
		add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAlignmentX(Component.LEFT_ALIGNMENT);
		table.setSelectionForeground(Color.CYAN);
		table.setRowMargin(40);
		table.setRowHeight(40);
		table.setIntercellSpacing(new Dimension(0, -8));
		table.setToolTipText("");
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Calibri", Font.BOLD, 23));
		table.setShowVerticalLines(false);
		table.setBorder(null);
		table.setModel(modeloTabla);
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();
		itemEliminar = new JMenuItem("Eliminar");
		itemActivar = new JMenuItem("Activar/Desactivar");
		popupMenu.add(itemActivar);
		popupMenu.add(itemEliminar);
		table.setComponentPopupMenu(popupMenu);
		
		
	}
	
	public Object[] usuarioToObject(Usuario us)
	{
		Object[] objeto = new Object[] {us.getId(),us.getUserName(), us.getPassword(), us.getCartera(), us.getNombre(),us.getApellido(),us.getTelefono(),us.getEdad(), us.getHistorialCompra().cantidad(), us.isActivo()};
		
		return objeto;
	}
	
	public void cargarLista(Supermercado datos)
	{
		Set<Entry<Long,Usuario>> set = datos.getListaUsuarios().getMapa().entrySet();
		Iterator<Entry<Long,Usuario>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long,Usuario> entrada = it.next();
			Usuario aux = entrada.getValue();
			Object[] dato = this.usuarioToObject(aux);
			modeloTabla.addRow(dato);
		}
		
	}
	
	public void limpiarLista()
	{
		modeloTabla.setRowCount(0);
	}
	
	
	

}



