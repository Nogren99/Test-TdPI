package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import capaDeDatos.Factura;
import capaDeDatos.Mesa;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class VentanaOperario extends JFrame implements IVista{

	private ActionListener actionListener;
	private JButton btnAdmin;
	private JList<Factura> listFaturas;
	private JButton btnNuevoPedido;
	private JPanel panelIzquierdaAbajo;
	private JList<Mesa> listMesas;
	private JPanel panelFacturas;
	private JPanel panelMesasDisponibles;
	private JPanel panelCerrarComanda;
	private JPanel panelNuevoPedido;
	private JButton btnCerrarComanda;
	private JPanel panelAdministrador;
	private DefaultListModel<Factura> facturas = new DefaultListModel<Factura>(); //modelo del arrayList 
	private DefaultListModel<Mesa> mesas = new DefaultListModel<Mesa>();
	private DefaultListModel<String> metodosDePago = new DefaultListModel<String>();
	private JList<String> listMetodoPago;
	private JPanel panel;

	public void setActionListener(ActionListener actionListener) {
		this.btnNuevoPedido.addActionListener(actionListener);
		this.btnCerrarComanda.addActionListener(actionListener);
		this.btnAdmin.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	/**
	 * Create the frame.
	 */
	public VentanaOperario(boolean esAdmin) {
		
		mesas.addAll(Local.getInstance().getMesas());
		facturas.addAll(Local.getInstance().getFacturas());
		metodosDePago.addAll(Local.getInstance().getFormasDePago());
		
		setBounds(100, 100, 800, 700);
		
		getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		panelMesasDisponibles = new JPanel();
		panelMesasDisponibles.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mesas Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMesasDisponibles);
		
		listMesas = new JList<Mesa>();
		listMesas.setToolTipText("");
		listMesas.setModel(mesas);
		panelMesasDisponibles.add(listMesas);
		
		panelFacturas = new JPanel();
		panelFacturas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Facturas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelFacturas);
		
		listFaturas = new JList<Factura>();
		listFaturas.setVisibleRowCount(18);
		listFaturas.setModel(facturas);
		panelFacturas.add(listFaturas);
		
		panelNuevoPedido = new JPanel();
		getContentPane().add(panelNuevoPedido);
		
		btnNuevoPedido = new JButton("Nuevo Pedido");
		panelNuevoPedido.add(btnNuevoPedido);
		btnNuevoPedido.setActionCommand("NUEVO PEDIDO");
		
		panelIzquierdaAbajo = new JPanel();
		getContentPane().add(panelIzquierdaAbajo);
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 0, 0, 0));
		
		panelCerrarComanda = new JPanel();
		panelIzquierdaAbajo.add(panelCerrarComanda);
		
		this.listMetodoPago = new JList<String>();
		this.listMetodoPago.setModel(metodosDePago);
		this.panelCerrarComanda.add(this.listMetodoPago);
		
		panelAdministrador = new JPanel();
		panelIzquierdaAbajo.add(panelAdministrador);
		
		btnCerrarComanda = new JButton("Cerrar Comanda");
		this.panelAdministrador.add(this.btnCerrarComanda);
		btnCerrarComanda.setActionCommand("CERRAR COMANDA");
		
		this.panel = new JPanel();
		this.panelIzquierdaAbajo.add(this.panel);
		
		btnAdmin = new JButton("Administrador");
		this.panel.add(this.btnAdmin);
		btnAdmin.setActionCommand("ADMINISTRADOR");
		this.btnAdmin.setEnabled(esAdmin); // si no es admin no muestra el boton administrador
		
		this.setVisible(true);
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
	
	public void recargar() {
		this.validate();
	}
	
	public void addFactura(Factura factura) {
		facturas.addElement(factura);
		this.validate();//hace un refresh de la interfaz, para que aparezca el nuevo item
	}
	
	public void addMesa(Mesa mesa) {
		mesas.addElement(mesa); 
		this.validate(); 
	}
	
	public void addMetodoPago(String metodoPago) {
		metodosDePago.addElement(metodoPago); 
		this.validate(); 
	}
	
	public void removeFactura(Factura factura) {
		facturas.removeElement(factura);
		this.validate();
	}
	
	public void removeMesa(Mesa mesa) {
		mesas.removeElement(mesa);
		this.validate();
	}
	
	public Factura getFacturaSeleccionada() {
		return this.listFaturas.getSelectedValue();
	}

	public Mesa getMesaSeleccionada() {
		return this.listMesas.getSelectedValue();
	}

	public String getMetodoDePagoSeleccionado() {
		return this.listMetodoPago.getSelectedValue();
	}
	
	public Component getBtnAdmin() {
		return this.btnAdmin;
	}
}
