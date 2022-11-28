package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Comanda;
import capaDeDatos.Factura;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;
import vista.VentanaLogin;
import vista.VentanaOperario;

@SuppressWarnings("deprecation")
public class ControladorOperario implements ActionListener, Observer {
	private Local modelo;
	private VentanaOperario vista;
	private boolean esAdmin;

	public ControladorOperario() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);

		this.esAdmin = Local.getInstance().getAdmin();

		this.vista = new VentanaOperario(esAdmin); // arranca la vista
		this.vista.setActionListener(this);
	}

	@Override
	public void update(Observable o, Object arg) { // escucha al modelo
		if (o != this.modelo)
			throw new InvalidParameterException();
	}

	// precondicion:no hay
	//
	@Override
	public void actionPerformed(ActionEvent e) { // escucha la vista
		Mozo mozo;
		Mesa mesa;
		Comanda comanda;
		String metodoPago;
		Factura factura;
		String comando = e.getActionCommand();
		if (comando.equals("ADMINISTRADOR")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioAdmin = new ControladorOperarioAdmin();
		} else if (comando.equals("CERRAR COMANDA")) {
			metodoPago = this.vista.getMetodoDePagoSeleccionado();
			if (metodoPago != null) { // necesita un metodo de pago
				mesa = this.vista.getMesaSeleccionada();
				if (mesa != null) { // necesita una mesa
					comanda = Local.getInstance().getComandaByMesa(mesa);
					if (comanda != null) { // necesita una comanda
						mozo = Local.getInstance().getMozoByMesa(comanda.getMesa());
						if (mozo != null) { // necesita un mozo
							factura = MetodosFacturacion.getInstance().bajaComanda(comanda, metodoPago);
							this.vista.addFactura(factura);
							this.vista.recargar();
						}
					}
				}
			}
		} else if (comando.equals("NUEVO PEDIDO")) {
			mesa = this.vista.getMesaSeleccionada();
			if (mesa != null) {
				this.vista.esconder();
				ControladorPedido controladorPedido = new ControladorPedido(mesa);
			}
		}
	}

	public VentanaOperario getVista() {
		return vista;
	}
}
