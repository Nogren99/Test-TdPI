package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;
import vista.VentanaMesas;
import vista.VentanaMesasEliminar;
import vista.VentanaMesasNueva;
import vista.VentanaMozoEliminar;
import vista.VentanaOperarioABMEliminar;
import vista.VentanaOperarioAdmin;
import vista.VentanaPromocionProductoEliminar;
import vista.VentanaPromocionTemporalEliminar;

public class ControladorPromocionTemporalEliminar implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionTemporalEliminar vista;
	
	public ControladorPromocionTemporalEliminar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionTemporalEliminar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PromocionTemporal promocionTemporal;
		String comando=e.getActionCommand();
		if (comando.equals("ELIMINAR")) {
			promocionTemporal = this.vista.getPromocionTemporalSeleccionada();
			MetodosFacturacion.getInstance().bajaPromocionTemporal(promocionTemporal);
			this.vista.removePromocionTemporal(promocionTemporal);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorPromocionTemporal controladorPromocionTemporal = new ControladorPromocionTemporal();
		}
	}

}
