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

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.PromocionProducto;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaPromocionProductoEliminar extends JFrame implements IVista {
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<PromocionProducto> listPromocionProducto;
	private JPanel panelMozos;
	private JButton btnEliminar;
	private DefaultListModel <PromocionProducto> PromocionesProducto= new DefaultListModel<PromocionProducto>();

	public VentanaPromocionProductoEliminar() {
		
		PromocionesProducto.addAll(Local.getInstance().getPromocionesProductos());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelMozos = new JPanel();
		panelMozos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PromocionProducto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMozos);
		
		listPromocionProducto = new JList<PromocionProducto>();
		listPromocionProducto.setModel(PromocionesProducto);
		panelMozos.add(listPromocionProducto);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		
		btnEliminar = new JButton("Eliminar");
		panelVolver.add(btnEliminar);
		btnEliminar.setActionCommand("ELIMINAR");
		
		btnVolver = new JButton("Volver");
		panelVolver.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		btnEliminar.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}
	
	public void addPromocionProducto(PromocionProducto promocionProducto) {
		PromocionesProducto.addElement(promocionProducto); 
		this.validate(); 
	}
	
	public void removePromocionProducto(PromocionProducto promocionProducto) {
		PromocionesProducto.removeElement(promocionProducto);
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
		return this.listPromocionProducto.getSelectedValue();
	}
}
