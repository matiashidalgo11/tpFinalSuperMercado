package graficasAdmin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Colecciones.MapaProductos;
import Objetos.Supermercado;
import Objetos.Usuario;
import Productos.Producto;

public class SubMenuListaProductos extends JPanel {

	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	public JTable table;
	private JPopupMenu popupMenu;
	public JMenuItem itemEliminar;
	public JMenuItem itemModificar;
	public JMenuItem itemAgregarStock;
	public JMenu ofertasMenu;
	public JMenuItem itemActivarOferta;
	public JMenuItem agregarOfertaMarca;
	public JMenuItem quitarOfertaMarca;
	
	private Supermercado datos;

	/**
	 * Create the panel.
	 */
	public SubMenuListaProductos(Supermercado datos) {
		this.datos = datos;
		initComponents();
	}
	
	private void initComponents()
	{
		setBounds(159, 90, 724, 588);
		setLayout(null);
		modeloTabla = new DefaultTableModel();
		
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("PrecioActual");
		modeloTabla.addColumn("Marca");
		modeloTabla.addColumn("Stock");
		modeloTabla.addColumn("Categoria");
		modeloTabla.addColumn("Oferta");
	
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
		
		/**
		 * Jpopu Completo para Editar
		 */
		popupMenu = new JPopupMenu();
		
		itemEliminar = new JMenuItem("Eliminar");
		itemModificar = new JMenuItem("Modificar");
		itemAgregarStock = new JMenuItem("Sumar Stock");
		
		ofertasMenu = new JMenu("Ofertas");
		itemActivarOferta = new JMenuItem("Activar/Desactivar Oferta Producto");
		agregarOfertaMarca = new JMenuItem("Agregar Oferta Marca");
		quitarOfertaMarca = new JMenuItem("Quitar Oferta Marca");
		ofertasMenu.add(itemActivarOferta);
		ofertasMenu.add(agregarOfertaMarca);
		ofertasMenu.add(quitarOfertaMarca);
		
		popupMenu.add(ofertasMenu);
		popupMenu.add(itemAgregarStock);
		popupMenu.add(itemEliminar);
		popupMenu.add(itemModificar);
		
		
		table.setComponentPopupMenu(popupMenu);
	}
	
	public Object[] productoToObjecto(Producto p)
	{
		Object[] resp = new Object[] {p.getId(),p.getNombre(),p.getPrecioActual(),p.getMarca(),p.getStock(),p.getNombreCategoria(), p.isOferta()};
		return resp;
	}
	
	public void limpiarLista()
	{
		modeloTabla.setRowCount(0);
	}
	
	public void cargarLista(Supermercado datos)
	{
		MapaProductos todo = datos.getListaCategorias().toMapaProductos();
		Set<Entry<Long,Producto>> set = todo.getMapa().entrySet();
		Iterator<Entry<Long,Producto>> it = set.iterator();
		while(it.hasNext())
		{
			Entry<Long,Producto> entrada = it.next();
			Producto aux = entrada.getValue();
			Object[] dato = this.productoToObjecto(aux);
			modeloTabla.addRow(dato);
		}
		
	}
	
	
	

}
