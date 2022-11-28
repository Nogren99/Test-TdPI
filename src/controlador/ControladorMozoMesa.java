package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.AsignacionDiaria;
import capaDeNegocios.Local;
import vista.VentanaMozoMesa;
import vista.VentanaPromocionTemporalNuevo;

public class ControladorMozoMesa implements ActionListener, Observer {
	private Local modelo;
	private VentanaMozoMesa vista;

	public ControladorMozoMesa() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);

		this.vista = new VentanaMozoMesa(); // arranca la vista
		this.vista.setActionListener(this);

	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("CREAR")) {
			Local.getInstance().getAsignacionDiaria().add(
					new AsignacionDiaria(this.vista.getListaMozoSeleccionada(), this.vista.getListaMesaSeleccionada()));
			this.vista.removeMesa(this.vista.getListaMesaSeleccionada());
		} else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioAdmin = new ControladorOperarioAdmin();

		}
	}

}
