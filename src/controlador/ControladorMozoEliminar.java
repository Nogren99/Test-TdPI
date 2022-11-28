package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasEliminar;
import vista.VentanaMesasNueva;
import vista.VentanaMozoEliminar;
import vista.VentanaOperarioAdmin;

public class ControladorMozoEliminar implements ActionListener, Observer{
	private Local modelo;
	private VentanaMozoEliminar vista;
	
	public ControladorMozoEliminar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaMozoEliminar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mozo mozo;
		String comando=e.getActionCommand();
		if (comando.equals("ELIMINAR")) {
			mozo = this.vista.getMozoSeleccionada();
			GestionDePersonal.getInstance().bajaMozo(mozo);
			this.vista.removeMozo(mozo);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorMozo controladorMozo = new ControladorMozo();
		}
	}

}
