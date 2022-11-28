package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMozos;
import vista.VentanaOperarioABM;
import vista.VentanaOperarioAdmin;

public class ControladorOperarioABM implements ActionListener, Observer{
	private Local modelo;
	private VentanaOperarioABM vista;
	
	public ControladorOperarioABM() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaOperarioABM(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if (comando.equals("NUEVA")) {
			this.vista.esconder();
			ControladorOperarioABMNuevo controladorOperarioNuevo = new ControladorOperarioABMNuevo();
		}
		else if (comando.equals("MODIFICAR")) {
			this.vista.esconder();
			ControladorOperarioABMModificar controladorOperarioABMModificar = new ControladorOperarioABMModificar();
		}else if (comando.equals("ELIMINAR")) {
			this.vista.esconder();
			ControladorOperarioABMEliminar controladorOperarioABMEliminar = new ControladorOperarioABMEliminar();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
