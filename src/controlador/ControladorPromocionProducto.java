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

public class ControladorPromocionProducto implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionProducto vista;
	
	public ControladorPromocionProducto() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionProducto(); // arranca la vista
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
			ControladorPromocionProductoNuevo controladorPromocionProductoNueva = new ControladorPromocionProductoNuevo();
		}
		else if (comando.equals("MODIFICAR")) {
			this.vista.esconder();
			ControladorPromocionProductoModificar controladorPromocionProductoModificar = new ControladorPromocionProductoModificar();
		}else if (comando.equals("ELIMINAR")) {
			this.vista.esconder();
			ControladorPromocionProductoEliminar controladorPromocionProductoModificar = new ControladorPromocionProductoEliminar();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
	}

}
