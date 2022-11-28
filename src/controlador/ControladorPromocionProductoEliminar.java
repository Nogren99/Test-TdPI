package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.PromocionProducto;
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

public class ControladorPromocionProductoEliminar implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionProductoEliminar vista;
	
	public ControladorPromocionProductoEliminar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionProductoEliminar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PromocionProducto promocionProducto;
		String comando=e.getActionCommand();
		if (comando.equals("ELIMINAR")) {
			promocionProducto = this.vista.getPromocionProductoSeleccionada();
			MetodosFacturacion.getInstance().bajaPromocionProducto(promocionProducto);
			this.vista.removePromocionProducto(promocionProducto);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorPromocionProducto controladorPromocionProducto = new ControladorPromocionProducto();
		}
	}

}
