package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaProductoNuevo extends JFrame implements IVista {
	private JButton btnCreacion;
	private JPanel panelCreacion;
	private JLabel lblInforme;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panelVolver;
	private JButton btnVolver;
	private JLabel lblStock;
	private JLabel lblNombre;
	private JLabel lblPCosto;
	private JLabel lblPVenta;
	private JTextField txtStock;
	private JTextField txtNombre;
	private JTextField txtPCosto;
	private JTextField txtPVenta;
	private ActionListener actionListener;

	public VentanaProductoNuevo() {
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		setBounds(100, 100, 800, 700);
		
		this.panel = new JPanel();
		getContentPane().add(this.panel);
		
		this.lblStock = new JLabel("Stock");
		this.panel.add(this.lblStock);
		
		this.txtStock = new JTextField();
		this.panel.add(this.txtStock);
		this.txtStock.setColumns(10);
		
		this.panel_1 = new JPanel();
		getContentPane().add(this.panel_1);
		
		this.lblNombre = new JLabel("Nombre");
		this.panel_1.add(this.lblNombre);
		
		this.txtNombre = new JTextField();
		this.txtNombre.setColumns(10);
		this.panel_1.add(this.txtNombre);
		
		this.panel_2 = new JPanel();
		getContentPane().add(this.panel_2);
		
		this.lblPCosto = new JLabel("Precio costo");
		this.panel_2.add(this.lblPCosto);
		
		this.txtPCosto = new JTextField();
		this.txtPCosto.setColumns(10);
		this.panel_2.add(this.txtPCosto);
		
		this.panel_3 = new JPanel();
		getContentPane().add(this.panel_3);
		
		this.lblPVenta = new JLabel("Precio Venta");
		this.panel_3.add(this.lblPVenta);
		
		this.txtPVenta = new JTextField();
		this.txtPVenta.setColumns(10);
		this.panel_3.add(this.txtPVenta);
		
		panelCreacion = new JPanel();
		getContentPane().add(panelCreacion);
		
		btnCreacion = new JButton("Creacion");
		panelCreacion.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		lblInforme = new JLabel("Se creo correctamente");
		panelCreacion.add(lblInforme);
		lblInforme.setVisible(false);
		
		this.panelVolver = new JPanel();
		getContentPane().add(this.panelVolver);
		
		this.btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		this.panelVolver.add(this.btnVolver);
		
		this.setVisible(true);
	}

	
	public int getStock() {
		int stock;
		try {
			stock = Integer.parseInt(this.txtStock.getText());	
		}catch (Exception exception){
			stock = -1;
		}
		return stock;
	}

	public String getNombre() {
		return this.txtNombre.getText();
	}
	public int getPCosto() {
		int costo;
		try {
			costo = Integer.parseInt(this.txtPCosto.getText());	
		}catch (Exception exception){
			costo = -1;
		}
		return costo;
	}
	public int getPVenta() {
		int venta;
		try {
			venta = Integer.parseInt(this.txtPVenta.getText());	
		}catch (Exception exception){
			venta = -1;
		}
		return venta;
	}
	
	public JLabel getLblInforme() {
		return lblInforme;
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		btnCreacion.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
}
