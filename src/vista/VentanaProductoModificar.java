package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import capaDeDatos.Producto;
import capaDeDatos.Producto;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class VentanaProductoModificar extends JFrame implements IVista {
	/**
	 * 
	 */
	private ActionListener actionListener;
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Producto> listProductos;
	private JLabel lblPVenta;
	private JButton btnAceptar;
	private JPanel panelProductos;
	private DefaultListModel <Producto> productos= new DefaultListModel<Producto>();
	private JLabel lblPCosto;
	private JLabel lblNombre;
	private JLabel lblStock;
	private JTextField txtStock;
	private JTextField txtPCosto;
	private JTextField txtPVenta;
	private JTextField txtNombre;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;

	public VentanaProductoModificar() {
		
		productos.addAll(Local.getInstance().getProductos());
		
		setBounds(100, 100, 800, 700);
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		panelProductos = new JPanel();
		panelProductos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelProductos);
		
		listProductos = new JList<Producto>();
		listProductos.setModel(productos);
		panelProductos.add(listProductos);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		this.panelVolver.setLayout(new GridLayout(5, 2, 0, 0));
		
		this.panel_9 = new JPanel();
		this.panelVolver.add(this.panel_9);
		
		this.lblNombre = new JLabel("Nombre");
		this.panel_9.add(this.lblNombre);
		
		this.panel_8 = new JPanel();
		this.panelVolver.add(this.panel_8);
		
		this.txtNombre = new JTextField();
		this.panel_8.add(this.txtNombre);
		this.txtNombre.setColumns(10);
		
		this.panel_7 = new JPanel();
		this.panelVolver.add(this.panel_7);
		
		this.lblStock = new JLabel("Stock");
		this.panel_7.add(this.lblStock);
		
		this.panel_6 = new JPanel();
		this.panelVolver.add(this.panel_6);
		
		this.txtStock = new JTextField();
		this.panel_6.add(this.txtStock);
		this.txtStock.setColumns(10);
		
		this.panel_5 = new JPanel();
		this.panelVolver.add(this.panel_5);
		
		this.lblPCosto = new JLabel("Precio Costo");
		this.panel_5.add(this.lblPCosto);
		
		this.panel_4 = new JPanel();
		this.panelVolver.add(this.panel_4);
		
		this.txtPCosto = new JTextField();
		this.panel_4.add(this.txtPCosto);
		this.txtPCosto.setColumns(10);
		
		this.panel_3 = new JPanel();
		this.panelVolver.add(this.panel_3);
		
		lblPVenta = new JLabel("Precio Venta");
		this.panel_3.add(this.lblPVenta);
		
		this.panel_2 = new JPanel();
		this.panelVolver.add(this.panel_2);
		
		this.txtPVenta = new JTextField();
		this.panel_2.add(this.txtPVenta);
		this.txtPVenta.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.panelVolver.add(this.panel_1);
		
		btnAceptar = new JButton("Aceptar");
		this.panel_1.add(this.btnAceptar);
		btnAceptar.setActionCommand("ACEPTAR");
		
		this.panel = new JPanel();
		this.panelVolver.add(this.panel);
		
		
		btnVolver = new JButton("Volver");
		this.panel.add(this.btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		btnAceptar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;	
	}

	public void actualizaLista() {
		this.validate();
	}
	
	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
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
	
	public Producto getProductoSeleccionado() {
		return this.listProductos.getSelectedValue();
	}

}
