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
import javax.swing.text.JTextComponent;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class VentanaPromocionProductosModificar extends JFrame implements IVista{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<PromocionProducto> listOperarios;
	private JPanel panelMesas;
	private DefaultListModel <PromocionProducto> promocionProducto= new DefaultListModel<PromocionProducto>();
	private JButton btnGuardar;
	private JLabel lblProducto;
	private JList<Producto> listProductos;
	private DefaultListModel <Producto> productos= new DefaultListModel<Producto>();
	private JLabel lblDiaSemana;
	private JTextField txtDiaSemana;
	private JLabel lbl2X1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblAplica;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblNewLabel;
	private JTextField txtCantidadMinimaDescuento;
	private JLabel lblNewLabel_1;
	private JTextField txtPorcentaje;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	/**
	 * 
	 */
	public VentanaPromocionProductosModificar() {
		
		promocionProducto.addAll(Local.getInstance().getPromocionesProductos());
		productos.addAll(Local.getInstance().getProductos());
		
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		setBounds(100, 100, 800, 700);
		panelMesas = new JPanel();
		panelMesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PromocionProductos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMesas);
		
		listOperarios = new JList<PromocionProducto>();
		listOperarios.setModel(promocionProducto);
		panelMesas.add(listOperarios);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		panelVolver.setLayout(new GridLayout(7, 3, 0, 0));
		
		lblProducto = new JLabel("Producto:");
		panelVolver.add(lblProducto);
		
		listProductos = new JList<Producto>();
		listProductos.setModel(productos);
		panelVolver.add(listProductos);
		
		panel = new JPanel();
		panelVolver.add(panel);
		
		lblDiaSemana = new JLabel("Dia de la semana:");
		panelVolver.add(lblDiaSemana);
		
		txtDiaSemana = new JTextField();
		txtDiaSemana.setColumns(10);
		panelVolver.add(txtDiaSemana);
		
		panel_1 = new JPanel();
		panelVolver.add(panel_1);
		
		lbl2X1 = new JLabel("Aplica 2x1");
		panelVolver.add(lbl2X1);
		
		rdbtnNewRadioButton = new JRadioButton("Si");
		rdbtnNewRadioButton.setActionCommand("SI 2X1");
		panelVolver.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setActionCommand("NO 2X1");
		panelVolver.add(rdbtnNewRadioButton_1);
		
		lblAplica = new JLabel("Aplica descuento por cantidad:");
		panelVolver.add(lblAplica);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Si");
		rdbtnNewRadioButton_2.setActionCommand("SI CANTIDAD");
		panelVolver.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("No");
		rdbtnNewRadioButton_3.setActionCommand("NO CANTIDAD");
		panelVolver.add(rdbtnNewRadioButton_3);
		
		lblNewLabel = new JLabel("Cantidad Minima para el descuento");
		panelVolver.add(lblNewLabel);
		
		txtCantidadMinimaDescuento = new JTextField();
		txtCantidadMinimaDescuento.setColumns(10);
		panelVolver.add(txtCantidadMinimaDescuento);
		
		panel_2 = new JPanel();
		panelVolver.add(panel_2);
		
		lblNewLabel_1 = new JLabel("Porcentaje");
		panelVolver.add(lblNewLabel_1);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setColumns(10);
		panelVolver.add(txtPorcentaje);
		
		panel_3 = new JPanel();
		panelVolver.add(panel_3);
		
		btnGuardar = new JButton("Guardar");
		panelVolver.add(btnGuardar);
		btnGuardar.setActionCommand("GUARDAR");
		
		panel_4 = new JPanel();
		panelVolver.add(panel_4);
		
		btnVolver = new JButton("Volver");
		panelVolver.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		
		this.setVisible(true);
	}


	public JTextField getTxtDiaSemana() {
		return txtDiaSemana;
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		btnGuardar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
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


	public PromocionProducto getPromocionProductoSeleccionada() {
		return this.listOperarios.getSelectedValue();
	}
	public Producto getProductoSeleccionada() {
		return this.listProductos.getSelectedValue();
	}


	public JTextField getTxtCantidadMinimaDescuento() {
		return txtCantidadMinimaDescuento;
	}


	public JTextField getTxtPorcentaje() {
		return txtPorcentaje;
	}




}
