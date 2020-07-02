package graficasAdmin;

import java.awt.CardLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MenuAdminOfertas extends JPanel {

	private JPanel panel;
	private CardLayout controlProductoMenu = new CardLayout();
	/**
	 * Create the panel.
	 */
	public MenuAdminOfertas() {

		initComponents();
	}
	private void initComponents() {
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(159, 90, 724, 588);
		add(panel);
		panel.setLayout(controlProductoMenu );
	}

}
