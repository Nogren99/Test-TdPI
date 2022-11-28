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

public class VentanaOperarioABMModificar extends JFrame implements IVista {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Operario> listOperarios;
	private JLabel lblPassword;
	private JPanel panelMesas;
	private DefaultListModel <Operario> operarios= new DefaultListModel<Operario>();
	private JLabel lblNombreUsuario;
	private JTextField txtUsuario;
	private JPanel panelVacio2;
	private JPanel panelVacio6;
	private JPanel panelVacio7;
	private JPanel panelVacio9;
	private JButton btnGuardar;
	private JTextField txtPassword;
	private JPanel panel;

	public VentanaOperarioABMModificar() {
		
		operarios.addAll(Local.getInstance().getOperarios());
		setBounds(100, 100, 800, 700);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		panelMesas = new JPanel();
		panelMesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Operarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMesas);
		
		listOperarios = new JList<Operario>();
		listOperarios.setModel(operarios);
		panelMesas.add(listOperarios);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		panelVolver.setLayout(new GridLayout(4, 5, 0, 0));
		
		lblNombreUsuario = new JLabel("Nombre Usuario:");
		panelVolver.add(lblNombreUsuario);
		
		txtUsuario = new JTextField();
		panelVolver.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		panelVacio2 = new JPanel();
		panelVolver.add(panelVacio2);
		
		lblPassword = new JLabel("Password:");
		panelVolver.add(lblPassword);
		
		txtPassword = new JTextField();
		panelVolver.add(txtPassword);
		txtPassword.setColumns(10);
		
		panelVacio6 = new JPanel();
		panelVolver.add(panelVacio6);
		
		panelVacio7 = new JPanel();
		panelVolver.add(panelVacio7);
		
		btnGuardar = new JButton("Guardar");
		panelVacio7.add(btnGuardar);
		btnGuardar.setActionCommand("GUARDAR");
		
		panelVacio9 = new JPanel();
		panelVolver.add(panelVacio9);
		
		panel = new JPanel();
		panelVolver.add(panel);
		
		btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		
		this.setVisible(true);
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


	public Operario getOperarioSeleccionada() {
		return this.listOperarios.getSelectedValue();
	}


	public JTextField getTxtUsuario() {
		return txtUsuario;
	}


	public JTextField getTxtPassword() {
		return txtPassword;
	}

}
