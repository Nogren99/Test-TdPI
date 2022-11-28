package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasNueva;
import vista.VentanaOperarioAdmin;
import vista.VentanaProductoNuevo;

public class ControladorProductoNuevo implements ActionListener, Observer {
	private Local modelo;
	private VentanaProductoNuevo vista;

	public ControladorProductoNuevo() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);

		this.vista = new VentanaProductoNuevo(); // arranca la vista
		this.vista.setActionListener(this);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre;
		int stock;
		int PCosto;
		int PVenta;
		String comando = e.getActionCommand();
		if (comando.equals("CREAR")) {
			
				nombre = this.vista.getNombre();
				stock = this.vista.getStock();
				PCosto = this.vista.getPCosto();
				PVenta = this.vista.getPVenta();
				if (!nombre.equals("")) {
					if (stock > 0) {
						if (PCosto > 0) {
							if (PVenta > 0) {
								ConfiguracionDeSistema.getInstance().altaProducto(stock, nombre, PCosto, PVenta);
								this.vista.getLblInforme().setVisible(true);
							}
						}
					}
				}
			} else if (comando.equals("VOLVER")) {
				this.vista.esconder();
				ControladorProducto controladorProducto = new ControladorProducto();
			}
		}
	

}
