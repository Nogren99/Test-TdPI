package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaOperarioAdmin extends JFrame implements IVista, MouseListener{

	private ActionListener actionListener;
	private JButton btnArrancarDia;
	private JButton btnMozoMesa;
	private JButton btnEstadisticas;
	private JButton btnConfigEmpresa;
	private JButton btnOperarios;
	private JButton btnMesas;
	private JButton btnProductos;
	private JButton btnMozos;
	private JButton btnPromocionProducto;
	private JButton btnPromocionTemporal;
	private JPanel panelVacio;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JPanel panelArrancaDia;
	private JPanel panelMozo_Mesa;
	private JPanel panelVerEstadisticas;
	private JPanel panelConfigEmpresa;
	private JPanel panelOperarios;
	private JPanel panelMesas;
	private JPanel panelProductos;
	private JPanel panelMozos;
	private JPanel panelPromocionProducto;
	private JPanel panelPromocionTemporal;
	private JButton btnPersistir;

	public void setActionListener(ActionListener actionListener) {
		this.btnArrancarDia.addActionListener(actionListener);
		this.btnConfigEmpresa.addActionListener(actionListener);
		this.btnEstadisticas.addActionListener(actionListener);
		this.btnMesas.addActionListener(actionListener);
		this.btnMozoMesa.addActionListener(actionListener);
		this.btnMozos.addActionListener(actionListener);
		this.btnOperarios.addActionListener(actionListener);
		this.btnProductos.addActionListener(actionListener);
		this.btnPromocionProducto.addActionListener(actionListener);
		this.btnPromocionTemporal.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.btnPersistir.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	/**
	 * Create the frame.
	 */
	public VentanaOperarioAdmin() {
		getContentPane().setLayout(new GridLayout(6, 2, 0, 0));
		setBounds(100, 100, 800, 700);
		
		panelArrancaDia = new JPanel();
		getContentPane().add(panelArrancaDia);
		
		btnArrancarDia = new JButton("Arrancar Día");
		btnArrancarDia.addMouseListener(this);
		this.btnArrancarDia.setActionCommand("ARRANCAR DIA");
		panelArrancaDia.add(btnArrancarDia);
		
		panelMozo_Mesa = new JPanel();
		getContentPane().add(panelMozo_Mesa);
		
		btnMozoMesa = new JButton("Asignar Mozo a Mesa");
		btnMozoMesa.addMouseListener(this);
		this.btnMozoMesa.setActionCommand("MOZOMESA");
		btnMozoMesa.setEnabled(false);
		panelMozo_Mesa.add(btnMozoMesa);
		
		panelVerEstadisticas = new JPanel();
		getContentPane().add(panelVerEstadisticas);
		
		btnEstadisticas = new JButton("Ver Estadistias");
		btnEstadisticas.addMouseListener(this);
		this.btnEstadisticas.setActionCommand("VER ESTADISTICAS");
		panelVerEstadisticas.add(btnEstadisticas);
		
		panelConfigEmpresa = new JPanel();
		getContentPane().add(panelConfigEmpresa);
		
		btnConfigEmpresa = new JButton("Configurar Empresa");
		btnConfigEmpresa.addMouseListener(this);
		this.btnConfigEmpresa.setActionCommand("CONFIGURAR EMPRESA");
		panelConfigEmpresa.add(btnConfigEmpresa);
		
		panelOperarios = new JPanel();
		getContentPane().add(panelOperarios);
		
		btnOperarios = new JButton("Operarios");
		btnOperarios.addMouseListener(this);
		this.btnOperarios.setActionCommand("OPERARIOSABM");
		panelOperarios.add(btnOperarios);
		
		panelMesas = new JPanel();
		getContentPane().add(panelMesas);
		
		btnMesas = new JButton("Mesas");
		btnMesas.addMouseListener(this);
		this.btnMesas.setActionCommand("MESAS");
		panelMesas.add(btnMesas);
		
		panelProductos = new JPanel();
		getContentPane().add(panelProductos);
		
		btnProductos = new JButton("Productos");
		btnProductos.addMouseListener(this);
		this.btnProductos.setActionCommand("PRODUCTOS");
		panelProductos.add(btnProductos);
		
		panelMozos = new JPanel();
		getContentPane().add(panelMozos);
		
		btnMozos = new JButton("Mozos");
		btnMozos.addMouseListener(this);
		this.btnMozos.setActionCommand("MOZOS");
		panelMozos.add(btnMozos);
		
		panelPromocionProducto = new JPanel();
		getContentPane().add(panelPromocionProducto);
		
		btnPromocionProducto = new JButton("Promoción Producto");
		btnPromocionProducto.addMouseListener(this);
		this.btnPromocionProducto.setActionCommand("PROMOCION PRODUCTO");
		panelPromocionProducto.add(btnPromocionProducto);
		
		panelPromocionTemporal = new JPanel();
		getContentPane().add(panelPromocionTemporal);
		
		btnPromocionTemporal = new JButton("Promocion Temporal");
		btnPromocionTemporal.addMouseListener(this);
		this.btnPromocionTemporal.setActionCommand("PROMOCION TEMPORAL");
		panelPromocionTemporal.add(btnPromocionTemporal);
		
		panelVacio = new JPanel();
		getContentPane().add(panelVacio);
		
		this.btnPersistir = new JButton("Persistir");
		this.btnPersistir.setActionCommand("PERSISTIR");
		this.panelVacio.add(this.btnPersistir);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		
		btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(this);
		this.btnVolver.setActionCommand("VOLVER");
		panelVolver.add(btnVolver);
		
		this.setVisible(true);
	}


	public JButton getBtnMozoMesa() {
		return btnMozoMesa;
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
