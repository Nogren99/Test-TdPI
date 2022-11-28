package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;

import vista.VentanaProductoModificar;

import vista.VentanaOperarioAdmin;

public class ControladorProductoModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaProductoModificar vista;
	
	public ControladorProductoModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaProductoModificar(); // arranca la vista
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
		Producto producto;
		String comando=e.getActionCommand();
		
		if (comando.equals("ACEPTAR")) {
			producto = this.vista.getProductoSeleccionado();
			if (producto != null) {
				nombre = this.vista.getNombre();
				stock = this.vista.getStock();
				PCosto = this.vista.getPCosto();
				PVenta = this.vista.getPVenta();
				if (!nombre.equals(""))
					producto.setNombre(nombre);
				if (stock > 0)
					producto.setStock(stock);
				if (PCosto > 0)
					producto.setPrecioCosto(PCosto);
				if (PVenta > 0)
					producto.setPrecioVenta(PVenta);
			}
			
			this.vista.actualizaLista();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorProducto controladorProducto = new ControladorProducto();	
		}
	}

}
