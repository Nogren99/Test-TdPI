package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasModificar;
import vista.VentanaMesasNueva;
import vista.VentanaMozoModificar;
import vista.VentanaOperarioAdmin;

public class ControladorMozoModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaMozoModificar vista;
	
	public ControladorMozoModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaMozoModificar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mozo mozo;
		int cantHijos=0;
		String comando=e.getActionCommand();
		if (comando.equals("GUARDAR")) {
			mozo = this.vista.getMozoSeleccionada();
			try{
				cantHijos=Integer.parseInt(this.vista.getTxtHijos().getText());
			}
			catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
			GestionDePersonal.getInstance().modificaMozo(mozo, "cantHijos", cantHijos);
			this.vista.actualizaLista();
		}
		else if (comando.equals("ACTIVO")) {
			mozo = this.vista.getMozoSeleccionada();
			GestionDePersonal.getInstance().modificaMozo(mozo, "estado", "Activo");// en el null va la que consigo cliqueando de la lista
			this.vista.actualizaLista();
		}
		else if (comando.equals("DE FRANCO")) {
			mozo = this.vista.getMozoSeleccionada();
			GestionDePersonal.getInstance().modificaMozo(mozo, "estado", "De Franco");
			this.vista.actualizaLista();	
		}
		else if (comando.equals("AUSENTE")) {
			mozo = this.vista.getMozoSeleccionada();
			GestionDePersonal.getInstance().modificaMozo(mozo, "estado", "Ausente");
			this.vista.actualizaLista();	
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorMozo controladorMozo = new ControladorMozo();
		}
	}

}
