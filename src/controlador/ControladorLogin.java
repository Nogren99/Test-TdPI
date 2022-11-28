package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.Local;
import vista.VentanaLogin;

@SuppressWarnings("deprecation")
public class ControladorLogin implements ActionListener, Observer {
	private Local modelo;
	private Operario operario = null;
	private int tipoUsuario = 0; // 0 = operario, 1 = operarioAdmin;
	private VentanaLogin vista;

	public ControladorLogin() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaLogin(); // arranca la vista
		this.vista.setActionListener(this);

	}

	@Override
	public void update(Observable o, Object arg) { //escucha al modelo
	    	if (o != this.modelo)
	    	    throw new InvalidParameterException();
	    	
	    	if (arg.toString().contentEquals("LOGIN CORRECTO"))
	    	{
	    	    this.vista.esconder();
	    		ControladorOperario controladorOperario= new ControladorOperario();
	    	}
	    	else if (arg.toString().contentEquals("USER INCORRECTO"))
	    	{
	    	    this.vista.getLblErrorUsuario().setVisible(true);
	    	}else if(arg.toString().contentEquals("PASSWORD INCORRECTO")){
	    		this.vista.getLblErrorPassword().setVisible(true);
	    	}	
	}

	@Override
	public void actionPerformed(ActionEvent e) { // escucha la vista
		String comando = e.getActionCommand();
		if (comando == "LOGIN") {
			Local.getInstance().login(vista.getTxtUsuario().getText(), vista.getTxtPassword().getText());
		}

	}

	public Operario getOperario() {
		return operario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public VentanaLogin getVista() {
		return vista;
	}
	
}
