package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaOperarioAdmin;

public class ControladorMesas implements ActionListener, Observer{
	private Local modelo;
	private VentanaMesas vista;
	
	public ControladorMesas() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaMesas(); // arranca la vista
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
			ControladorMesasNueva controladorNuevaMesa = new ControladorMesasNueva();
		}
		else if (comando.equals("MODIFICAR")) {
			this.vista.esconder();
			ControladorMesasModificar controladorModificarMesa = new ControladorMesasModificar();
		}else if (comando.equals("ELIMINAR")) {
			this.vista.esconder();
			ControladorMesasEliminar controladorModificarMesa = new ControladorMesasEliminar();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
