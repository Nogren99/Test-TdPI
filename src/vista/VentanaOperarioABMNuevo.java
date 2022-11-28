package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaOperarioABMNuevo extends JFrame implements IVista {
	private JButton btnCreacion;
	private JButton btnVolver;
	private JPanel panelCreacion;
	private JPanel panel2;
	private JLabel lblNombre;
	private JTextField txtNombreyApellido;
	private JLabel lblNombreUsuario;
	private JTextField txtNombreUsuario;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblEstado;
	private JButton btnEstadoActivo;
	private JButton btnEstadoInactivo;
	private JPanel panel;
	
	


	private JPanel panelEstadoActivo;
	private JPanel panelEstadoInactivo;
	private JPanel panel_3;
	private JPanel panel_4;

	public VentanaOperarioABMNuevo() {
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
		
		lblNombreUsuario = new JLabel("Nombre de Usuario:");
		panelCreacion.add(lblNombreUsuario);
		
		txtNombreUsuario = new JTextField();
		panelCreacion.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		lblPassword = new JLabel("Contraseña: ");
		panelCreacion.add(lblPassword);
		
		txtPassword = new JTextField();
		panelCreacion.add(txtPassword);
		txtPassword.setColumns(10);
		
		panel2 = new JPanel();
		getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_3 = new JPanel();
		panel2.add(panel_3);
		
		btnCreacion = new JButton("Creación");
		panel_3.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		panel = new JPanel();
		panel2.add(panel);
		
		panel_4 = new JPanel();
		panel2.add(panel_4);
		
		btnVolver = new JButton("Volver");
		panel_4.add(btnVolver);
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
	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}


	public JTextField getTxtPassword() {
		return txtPassword;
	}
}
	
