package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasNueva;
import vista.VentanaMozoNueva;
import vista.VentanaOperarioABMNuevo;
import vista.VentanaOperarioAdmin;

public class ControladorOperarioABMNuevo implements ActionListener, Observer{
	private Local modelo;
	private VentanaOperarioABMNuevo vista;
	
	public ControladorOperarioABMNuevo() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaOperarioABMNuevo(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		int cantHijos = 0;
		if (comando.equals("CREAR")) {
			GestionDePersonal.getInstance().altaOperario(this.vista.getTxtNombreyApellido().getText(),"zzz ",this.vista.getTxtNombreUsuario().getText(),this.vista.getTxtPassword().getText());
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioABM controladorOperarioABM = new ControladorOperarioABM();
		}
	}

}
