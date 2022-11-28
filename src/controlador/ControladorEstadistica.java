package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mozo;
import capaDeNegocios.Local;
import vista.VentanaEstadistica;
import vista.VentanaMesas;

public class ControladorEstadistica implements ActionListener, Observer {
	private Local modelo;
	private VentanaEstadistica vista;

	public ControladorEstadistica() {
		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);

		this.vista = new VentanaEstadistica(); // arranca la vista
		this.vista.setActionListener(this);

			this.vista.setMaxPromedio(Local.getInstance().getMozoMaxPromedio());
			this.vista.setMinPromedio(Local.getInstance().getMozoMinPromedio());
			this.vista.setMaxVentas(Local.getInstance().getMozoMaxVentas());
			this.vista.setMinVentas(Local.getInstance().getMozoMinVentas());
			
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioAdmin = new ControladorOperarioAdmin();
		}		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
