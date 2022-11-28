package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import vista.VentanaMesas;
import vista.VentanaMesasNueva;
import vista.VentanaMozoNueva;
import vista.VentanaOperarioAdmin;

public class ControladorMozoNuevo implements ActionListener, Observer{
	private Local modelo;
	private VentanaMozoNueva vista;
	
	public ControladorMozoNuevo() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaMozoNueva(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		int cantHijos = 0;
		if (comando.equals("CREAR")) {
			try{
				cantHijos=Integer.parseInt(this.vista.getTxtCantHijos().getText());
			}
			catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
			GestionDePersonal.getInstance().altaMozo(this.vista.getTxtNombreyApellido().getText(),this.vista.getTxtNacimiento().getText(),cantHijos);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorMozo controladorMozo = new ControladorMozo();
		}
	}

}
