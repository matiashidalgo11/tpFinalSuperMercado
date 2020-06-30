package graficasAdmin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class InformacionGeneral extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Create the panel.
	 */
	public InformacionGeneral() {

		initComponents();
	}
	private void initComponents() {
		
		setBounds(232, 11, 1042, 689);
		setLayout(null);
		
		
		lblNewLabel = new JLabel("Cantidad de Usuarios");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setBounds(50, 103, 330, 82);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad de Productos");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_1.setBounds(50, 274, 330, 82);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\"\"");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_2.setBounds(520, 274, 330, 82);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\"\"\"");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_3.setBounds(520, 103, 330, 82);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Ofertas Actuales");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_4.setBounds(50, 420, 330, 82);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\"\"");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel_5.setBounds(520, 420, 330, 82);
		add(lblNewLabel_5);
	}
}
