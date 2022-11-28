package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeDatos.Operario;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;
import vista.VentanaLogin;
import vista.VentanaOperario;
import vista.VentanaPedido;

@SuppressWarnings("deprecation")
public class ControladorPedido implements ActionListener, Observer {
	private Local modelo;
	private Mesa mesa;
	private Operario operario = null;
	private int tipoUsuario = 0; // 0 = operario, 1 = operarioAdmin;
	private VentanaPedido vista;

	public ControladorPedido(Mesa mesa) {

		this.mesa= mesa;
		
		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPedido(); // arranca la vista
		this.vista.setActionListener(this);

	}

	@Override
	public void update(Observable o, Object arg) { //escucha al modelo
	    	if (o != this.modelo)
	    	    throw new InvalidParameterException();
	  	}

	//pre condiciones:
	//ActCommand: ACEPTAR -> El producto existe y esta en la lista de productos
	//ActCommand: VOLVER -> No tiene
	@Override
	public void actionPerformed(ActionEvent e) { // escucha la vista
		int cantidad;
		Pedido pedido;
		Comanda comanda;
		Producto producto;
		String comando = e.getActionCommand();
		if (comando.equals("ACEPTAR")) {
			cantidad = this.vista.getCantidad();
			if (cantidad > 0) { //valido cantidad 
				producto = this.vista.getProductoSeleccionado();
				if (producto != null){ //valido que haya elegido un producto
					
					pedido = MetodosFacturacion.getInstance().altaPedido(new GregorianCalendar().toString(), cantidad, producto);
					if (pedido != null) { //si se puede crear un pedido con ese producto
						comanda = Local.getInstance().getComandaByMesa(mesa);
						if (comanda == null) { // si la mesa no tiene comanda, la abre y pone el nuevo pedido
							comanda = MetodosFacturacion.getInstance().altaComanda(mesa,pedido);
						}
						else { //sino añade el pedido
							MetodosFacturacion.getInstance().modificacionComanda(comanda, pedido, true); //true gregar y false eliminar
						}
						this.vista.esconder();
						ControladorOperario controladorOperario = new ControladorOperario();					
					
					}
				}
			}
		}
		else if(comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperario controladorOperario = new ControladorOperario();
		}
	}

	public VentanaPedido getVista() {
		return vista;
	}
}
