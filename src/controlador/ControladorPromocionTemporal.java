package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeDatos.PromocionProducto;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaOperarioAdmin;
import vista.VentanaPromocionProducto;
import vista.VentanaPromocionTemporal;

public class ControladorPromocionTemporal implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionTemporal vista;
	
	public ControladorPromocionTemporal() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionTemporal(); // arranca la vista
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
			ControladorPromocionTemporalNuevo controladorPromocionTemporalNueva = new ControladorPromocionTemporalNuevo();
		}
		else if (comando.equals("MODIFICAR")) {
			this.vista.esconder();
			ControladorPromocionTemporalModificar controladorPromocionTemporalModificar = new ControladorPromocionTemporalModificar();
		}else if (comando.equals("ELIMINAR")) {
			this.vista.esconder();
			ControladorPromocionTemporalEliminar controladorPromocionTemporalModificar = new ControladorPromocionTemporalEliminar();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
