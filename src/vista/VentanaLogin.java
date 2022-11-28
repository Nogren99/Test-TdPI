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
public class VentanaLogin extends JFrame implements IVista, MouseListener{

	private ActionListener actionListener;

	private JTextField txtUsuario;
	private JButton btnIngreso;
	private JPanel panelGeneral;
	private JPanel panelUsuario;
	private JLabel lblUsuario;
	private JPanel panelTxtUsuario;
	private JPanel panelPassword;
	private JLabel lblPassword;
	private JPanel panelBoton;
	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JPanel panelTxtPassword; 
	private JPanel panelErrorUsuario;
	private JPanel panelErrorPassword;
	private JLabel lblErrorUsuario;
	private JLabel lblErrorPassword;

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelGeneral = new JPanel();
		contentPane.add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new GridLayout(0, 1, 0, 0));

		panelUsuario = new JPanel();
		panelGeneral.add(panelUsuario);

		lblUsuario = new JLabel(" Usuario:");
		panelUsuario.add(lblUsuario);

		panelTxtUsuario = new JPanel();
		panelGeneral.add(panelTxtUsuario);

		txtUsuario = new JTextField();
		panelTxtUsuario.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		this.panelErrorUsuario = new JPanel();
		this.panelGeneral.add(this.panelErrorUsuario);
		
		this.lblErrorUsuario = new JLabel("Error Usuario");
		this.lblErrorUsuario.setVisible(false);
		this.lblErrorUsuario.setForeground(Color.RED);
		this.panelErrorUsuario.add(this.lblErrorUsuario);

		panelPassword = new JPanel();
		panelGeneral.add(panelPassword);

		lblPassword = new JLabel("Contraseña:");
		panelPassword.add(lblPassword);
		
		this.panelTxtPassword = new JPanel();
		this.panelGeneral.add(this.panelTxtPassword);
		
		this.txtPassword = new JPasswordField();
		this.txtPassword.setColumns(10);
		this.panelTxtPassword.add(this.txtPassword);
		
		this.panelErrorPassword = new JPanel();
		this.panelGeneral.add(this.panelErrorPassword);
		
		this.lblErrorPassword = new JLabel("Error Contraseña");
		this.lblErrorPassword.setVisible(false);
		this.lblErrorPassword.setForeground(Color.RED);
		
		this.panelErrorPassword.add(this.lblErrorPassword);

		panelBoton = new JPanel();
		panelGeneral.add(panelBoton);

		btnIngreso = new JButton("Ingreso");
		this.btnIngreso.addMouseListener(this);
		btnIngreso.setVerticalAlignment(SwingConstants.TOP);
		panelBoton.add(btnIngreso);
		lblErrorUsuario.setName("labelErrorUsuario");
		lblErrorPassword.setName("labelErrorContrasenia");
		btnIngreso.setName("botonIngreso");
		txtPassword.setName("textPassword");
		txtUsuario.setName("textUsuario");
		this.setVisible(true);
	}


	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}


	public JButton getBtnIngreso() {
		return btnIngreso;
	}

	public JPanel getPanelGeneral() {
		return panelGeneral;
	}

	public JPanel getPanelUsuario() {
		return panelUsuario;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public JPanel getPanelTxtUsuario() {
		return panelTxtUsuario;
	}

	public JPanel getPanelPassword() {
		return panelPassword;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JPanel getPanelBoton() {
		return panelBoton;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JPanel getPanelTxtPassword() {
		return panelTxtPassword;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPanel getPanelErrorUsuario() {
		return panelErrorUsuario;
	}

	public JPanel getPanelErrorPassword() {
		return panelErrorPassword;
	}

	public JLabel getLblErrorUsuario() {
		return lblErrorUsuario;
	}

	public JLabel getLblErrorPassword() {
		return lblErrorPassword;
	}

	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	@SuppressWarnings("deprecation")
	public void mouseReleased(MouseEvent e) {
		ActionEvent evento;
		String comando;
		String nombreUsuario = "";
		String password = "";
		JButton boton = (JButton) e.getSource();
		try {
			nombreUsuario = this.txtUsuario.getText();
			password = this.txtPassword.getText();
		} catch (Exception exception) {
		}
		if (!nombreUsuario.equals("") && !password.equals("")){
			comando = "LOGIN";
			evento = new ActionEvent(boton,0,comando);
			this.actionListener.actionPerformed(evento); //el action listener va a ser la referencia l controlador
		}
	} 
}
