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
import vista.VentanaMesasEliminar;
import vista.VentanaMesasNueva;
import vista.VentanaMozoEliminar;
import vista.VentanaOperarioABMEliminar;
import vista.VentanaOperarioAdmin;

public class ControladorOperarioABMEliminar implements ActionListener, Observer{
	private Local modelo;
	private VentanaOperarioABMEliminar vista;
	
	public ControladorOperarioABMEliminar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaOperarioABMEliminar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Operario operario;
		String comando=e.getActionCommand();
		if (comando.equals("ELIMINAR")) {
			operario = this.vista.getOperarioSeleccionada();
			GestionDePersonal.getInstance().bajaOperario(operario);
			this.vista.removeMozo(operario);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorMozo controladorMozo = new ControladorMozo();
		}
	}

}
