package graficasAdmin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Productos.Producto;

public class ListaProductos extends JPanel {

	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem itemEliminar;
	private JMenuItem itemActivar;
	private JMenuItem itemModificar;
	private JMenuItem itemAgregarStock;

	/**
	 * Create the panel.
	 */
	public ListaProductos() {
		setBounds(159, 90, 724, 588);
		setLayout(null);
		modeloTabla = new DefaultTableModel();
		
		modeloTabla.addColumn("Id");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("Marca");
		modeloTabla.addColumn("Stock");
		modeloTabla.addColumn("Categoria");
		
		Object[] a = new Object[] {"1","Pepe",100,"Nike",100,"Ropa"};
		modeloTabla.addRow(a);
		
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
		itemModificar = new JMenuItem("Modificar");
		itemAgregarStock = new JMenuItem("Sumar Stock");
		popupMenu.add(itemActivar);
		popupMenu.add(itemEliminar);
		popupMenu.add(itemModificar);
		popupMenu.add(itemAgregarStock);
		table.setComponentPopupMenu(popupMenu);
	}
	
	public Object[] ProductoToObjecto(Producto p)
	{
		Object[] resp = new Object[] {p.getId(),p.getNombre(),p.getPrecio(),p.getMarca(),p.getStock(),p.getNombreCategoria()};
		return resp;
	}
	
	
	
	

}
