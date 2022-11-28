package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.Local;

import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class VentanaPromocionProductosNuevo extends JFrame implements IVista {
	private JButton btnCreacion;
	private JButton btnVolver;
	private JPanel panelCreacion;
	private JPanel panel2;
	private JLabel lblProducto;
	private JLabel lblDiaSemana;
	private JTextField txtDiaSemana;
	private JLabel lbl2X1;
	private JLabel lblEstado;
	private JButton btnEstadoActivo;
	private JButton btnEstadoInactivo;
	
	


	private JPanel panelEstadoActivo;
	private JPanel panelEstadoInactivo;
	private JPanel panel_3;
	private JPanel panel_4;
	private JList <Producto>listProductos;
	private DefaultListModel <Producto> productos= new DefaultListModel<Producto>();
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblAplica;
	private JLabel lblNewLabel;
	private JTextField txtCantMinimaDescuento;
	private JLabel lblNewLabel_1;
	private JTextField txtPorcentaje;
	private JPanel panel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;

	public VentanaPromocionProductosNuevo() {
		
		productos.addAll(Local.getInstance().getProductos());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelCreacion = new JPanel();
		getContentPane().add(panelCreacion);
		panelCreacion.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblProducto = new JLabel("Producto:");
		panelCreacion.add(lblProducto);
		
		listProductos = new JList<Producto>();
		listProductos.setModel(productos);
		panelCreacion.add(listProductos);
		
		panel_1 = new JPanel();
		panelCreacion.add(panel_1);
		
		lblDiaSemana = new JLabel("Dia de la semana:");
		panelCreacion.add(lblDiaSemana);
		
		txtDiaSemana = new JTextField();
		panelCreacion.add(txtDiaSemana);
		txtDiaSemana.setColumns(10);
		
		panel_2 = new JPanel();
		panelCreacion.add(panel_2);
		
		lbl2X1 = new JLabel("Aplica 2x1");
		panelCreacion.add(lbl2X1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Si");
		panelCreacion.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setActionCommand("SI 2X1");
		
		rdbtnNewRadioButton_3 = new JRadioButton("No");
		panelCreacion.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setActionCommand("NO 2X1");
		
		panel2 = new JPanel();
		getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(3, 3, 0, 0));
		
		panel_3 = new JPanel();
		panel2.add(panel_3);
		
		lblAplica = new JLabel("Aplica descuento por cantidad:");
		panel_3.add(lblAplica);
		
		rdbtnNewRadioButton = new JRadioButton("Si");
		panel_3.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setActionCommand("SI CANTIDAD");
		
		rdbtnNewRadioButton_1 = new JRadioButton("No");
		panel_3.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setActionCommand("NO CANTIDAD");
		
		panel_4 = new JPanel();
		panel2.add(panel_4);
		
		lblNewLabel = new JLabel("Cantidad Minima para el descuento");
		panel_4.add(lblNewLabel);
		
		txtCantMinimaDescuento = new JTextField();
		panel_4.add(txtCantMinimaDescuento);
		txtCantMinimaDescuento.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Porcentaje");
		panel_4.add(lblNewLabel_1);
		
		txtPorcentaje = new JTextField();
		panel_4.add(txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		panel = new JPanel();
		panel2.add(panel);
		
		btnCreacion = new JButton("Creación");
		panel.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}


	public JTextField getTxtNombreUsuario() {
		return txtDiaSemana;
	}


	public JTextField getTextField() {
		return txtCantMinimaDescuento;
	}


	public JTextField getTextField_1() {
		return txtPorcentaje;
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		rdbtnNewRadioButton.addActionListener(actionListener);
		rdbtnNewRadioButton_1.addActionListener(actionListener);
		rdbtnNewRadioButton_2.addActionListener(actionListener);
		rdbtnNewRadioButton_3.addActionListener(actionListener);
		btnCreacion.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
	

	public void actualizaLista() {
		this.validate();
	}
	
	public Producto getProductoSeleccionada() {
		return this.listProductos.getSelectedValue();
	}


	public JTextField getTxtDiaSemana() {
		return txtDiaSemana;
	}


	public JTextField getTxtCantMinimaDescuento() {
		return txtCantMinimaDescuento;
	}


	public JTextField getTxtPorcentaje() {
		return txtPorcentaje;
	}
	
	

}
	
