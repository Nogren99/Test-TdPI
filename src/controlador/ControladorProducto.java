package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.Local;

import vista.VentanaOperarioAdmin;
import vista.VentanaProducto;

public class ControladorProducto implements ActionListener, Observer{
	private Local modelo;
	private VentanaProducto vista;
	
	public ControladorProducto() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaProducto(); // arranca la vista
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
			ControladorProductoNuevo controladorNuevaProducto = new ControladorProductoNuevo();
		}
		else if (comando.equals("MODIFICAR")) {
			this.vista.esconder();
			ControladorProductoModificar controladorModificarProducto = new ControladorProductoModificar();
		}else if (comando.equals("ELIMINAR")) {
			this.vista.esconder();
			ControladorProductoEliminar controladorModificarProducto = new ControladorProductoEliminar();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
