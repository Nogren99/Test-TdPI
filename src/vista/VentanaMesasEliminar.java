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
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaMesasEliminar extends JFrame implements IVista {
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Mesa> listMesas;
	private JPanel panelMesas;
	private JButton btnEliminar;
	private DefaultListModel <Mesa> mesas= new DefaultListModel<Mesa>();

	public VentanaMesasEliminar() {
		
		mesas.addAll(Local.getInstance().getMesas());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelMesas = new JPanel();
		panelMesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMesas);
		
		listMesas = new JList<Mesa>();
		listMesas.setModel(mesas);
		panelMesas.add(listMesas);
		
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
	
	public void addMesa(Mesa mesa) {
		mesas.addElement(mesa); 
		this.validate(); 
	}
	
	public void removeMesa(Mesa mesa) {
		mesas.removeElement(mesa);
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
	
	public Mesa getMesaSeleccionada() {
		return this.listMesas.getSelectedValue();
	}
}
