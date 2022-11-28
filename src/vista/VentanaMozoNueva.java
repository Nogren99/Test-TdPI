package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaMozoNueva extends JFrame implements IVista {
	private JButton btnCreacion;
	private JButton btnVolver;
	private JPanel panelCreacion;
	private JPanel panelVolver;
	private JLabel lblNombre;
	private JTextField txtNombreyApellido;
	private JLabel lblNacimiento;
	private JTextField txtNacimiento;
	private JLabel lblCantHijos;
	private JTextField txtCantHijos;

	public VentanaMozoNueva() {
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		setBounds(100, 100, 800, 700);
		panelCreacion = new JPanel();
		getContentPane().add(panelCreacion);
		panelCreacion.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNombre = new JLabel("Nombre y Apellido:");
		panelCreacion.add(lblNombre);
		
		txtNombreyApellido = new JTextField();
		panelCreacion.add(txtNombreyApellido);
		txtNombreyApellido.setColumns(10);
		
		lblNacimiento = new JLabel("Fecha Nacimiento:");
		panelCreacion.add(lblNacimiento);
		
		txtNacimiento = new JTextField();
		panelCreacion.add(txtNacimiento);
		txtNacimiento.setColumns(10);
		
		lblCantHijos = new JLabel("Cantidad de Hijos:");
		panelCreacion.add(lblCantHijos);
		
		txtCantHijos = new JTextField();
		panelCreacion.add(txtCantHijos);
		txtCantHijos.setColumns(10);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		
		btnCreacion = new JButton("Creación");
		panelVolver.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		btnVolver = new JButton("Volver");
		panelVolver.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
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


	public JTextField getTxtNombreyApellido() {
		return txtNombreyApellido;
	}


	public JTextField getTxtNacimiento() {
		return txtNacimiento;
	}


	public JTextField getTxtCantHijos() {
		return txtCantHijos;
	}
}
