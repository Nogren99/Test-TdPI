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
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaOperarioABMEliminar extends JFrame implements IVista {
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Operario> listOperarios;
	private JPanel panelMozos;
	private JButton btnEliminar;
	private DefaultListModel <Operario> operarios= new DefaultListModel<Operario>();

	public VentanaOperarioABMEliminar() {
		
		operarios.addAll(Local.getInstance().getOperarios());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelMozos = new JPanel();
		panelMozos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMozos);
		
		listOperarios = new JList<Operario>();
		listOperarios.setModel(operarios);
		panelMozos.add(listOperarios);
		
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
	
	public void addMozo(Operario operario) {
		operarios.addElement(operario); 
		this.validate(); 
	}
	
	public void removeMozo(Operario operario) {
		operarios.removeElement(operario);
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
	
	public Operario getOperarioSeleccionada() {
		return this.listOperarios.getSelectedValue();
	}
}
