package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;
import vista.VentanaProducto;
import vista.VentanaProductoEliminar;
import vista.VentanaOperarioAdmin;

public class ControladorProductoEliminar implements ActionListener, Observer{
	private Local modelo;
	private VentanaProductoEliminar vista;
	
	public ControladorProductoEliminar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaProductoEliminar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Producto producto;
		String comando=e.getActionCommand();
		if (comando.equals("ELIMINAR")) {
			producto = this.vista.getProductoSeleccionado();
			ConfiguracionDeSistema.getInstance().bajaProductos(producto);
			this.vista.removeProducto(producto);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorProducto controladorProducto = new ControladorProducto();
		}
	}

}
