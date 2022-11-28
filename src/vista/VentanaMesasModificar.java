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

public class VentanaMesasModificar extends JFrame implements IVista {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Mesa> listMesas;
	private JLabel lblEstado;
	private JButton btnActivo;
	private JButton btnInactivo;
	private JPanel panelMesas;
	private DefaultListModel <Mesa> mesas= new DefaultListModel<Mesa>();
	private ActionListener actionListener;

	public VentanaMesasModificar() {
		
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
		
		lblEstado = new JLabel("Estado:");
		panelVolver.add(lblEstado);
		
		btnActivo = new JButton("Libre");
		btnActivo.setActionCommand("LIBRE");
		panelVolver.add(btnActivo);
		
		
		btnInactivo = new JButton("Ocupado");
		btnInactivo.setActionCommand("OCUPADO");
		panelVolver.add(btnInactivo);
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panelVolver.add(btnVolver);
		
		
		this.setVisible(true);
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		btnActivo.addActionListener(actionListener);
		btnInactivo.addActionListener(actionListener);
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


	public Mesa getMesaSeleccionada() {
		return this.listMesas.getSelectedValue();
	}
}
