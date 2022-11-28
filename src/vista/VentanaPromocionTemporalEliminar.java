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
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaPromocionTemporalEliminar extends JFrame implements IVista {
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<PromocionTemporal> listPromocionTemporal;
	private JPanel panelPromocionesTemporales;
	private JButton btnEliminar;
	private DefaultListModel <PromocionTemporal> PromocionesTemporales= new DefaultListModel<PromocionTemporal>();

	public VentanaPromocionTemporalEliminar() {
		
		PromocionesTemporales.addAll(Local.getInstance().getPromocionesTemporales());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelPromocionesTemporales = new JPanel();
		panelPromocionesTemporales.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "PromocionTemporal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelPromocionesTemporales);
		
		listPromocionTemporal = new JList<PromocionTemporal>();
		listPromocionTemporal.setModel(PromocionesTemporales);
		panelPromocionesTemporales.add(listPromocionTemporal);
		
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
	
	public void addPromocionTemporal(PromocionTemporal promocionTemporal) {
		PromocionesTemporales.addElement(promocionTemporal); 
		this.validate(); 
	}
	
	public void removePromocionTemporal(PromocionTemporal promocionTemporal) {
		PromocionesTemporales.removeElement(promocionTemporal);
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
	
	public PromocionTemporal getPromocionTemporalSeleccionada() {
		return this.listPromocionTemporal.getSelectedValue();
	}
}
