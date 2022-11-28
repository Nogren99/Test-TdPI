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
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaMozoEliminar extends JFrame implements IVista {
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Mozo> listMozos;
	private JPanel panelMozos;
	private JButton btnEliminar;
	private DefaultListModel <Mozo> mozos= new DefaultListModel<Mozo>();

	public VentanaMozoEliminar() {
		
		mozos.addAll(Local.getInstance().getMozos());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelMozos = new JPanel();
		panelMozos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMozos);
		
		listMozos = new JList<Mozo>();
		listMozos.setModel(mozos);
		panelMozos.add(listMozos);
		
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
	
	public void addMozo(Mozo mozo) {
		mozos.addElement(mozo); 
		this.validate(); 
	}
	
	public void removeMozo(Mozo mesa) {
		mozos.removeElement(mesa);
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
	
	public Mozo getMozoSeleccionada() {
		return this.listMozos.getSelectedValue();
	}
}
