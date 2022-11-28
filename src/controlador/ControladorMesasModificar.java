package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasModificar;
import vista.VentanaMesasNueva;
import vista.VentanaOperarioAdmin;

public class ControladorMesasModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaMesasModificar vista;
	
	public ControladorMesasModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaMesasModificar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mesa mesa;
		String comando=e.getActionCommand();
		if (comando.equals("LIBRE")) {
			mesa = this.vista.getMesaSeleccionada();
			ConfiguracionDeSistema.getInstance().modificaMesa(mesa, "estado", "Libre");// en el null va la que consigo cliqueando de la lista
			this.vista.actualizaLista();
		}
		else if (comando.equals("OCUPADO")) {
			mesa = this.vista.getMesaSeleccionada();
			ConfiguracionDeSistema.getInstance().modificaMesa(mesa, "estado", "Ocupado");
			this.vista.actualizaLista();	
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorMesas controladorMesas = new ControladorMesas();
		}
	}

}
