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
import vista.VentanaOperarioABMModificar;
import vista.VentanaOperarioAdmin;

public class ControladorOperarioABMModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaOperarioABMModificar vista;
	
	public ControladorOperarioABMModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaOperarioABMModificar(); // arranca la vista
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
		if (comando.equals("GUARDAR")) {
			operario = this.vista.getOperarioSeleccionada();
			if (this.vista.getTxtUsuario().equals("") && !this.vista.getTxtPassword().equals("")) {
				GestionDePersonal.getInstance().modificaOperario(operario, "password", this.vista.getTxtPassword().getText());
				this.vista.actualizaLista();
			}else if (!this.vista.getTxtUsuario().equals("") && this.vista.getTxtPassword().equals("")) {
				GestionDePersonal.getInstance().modificaOperario(operario, "nombreUsuario", this.vista.getTxtUsuario().getText());
				this.vista.actualizaLista();
			}
			else if (this.vista.getTxtUsuario().equals("") && this.vista.getTxtPassword().equals("")) {
				GestionDePersonal.getInstance().modificaOperario(operario, "password", this.vista.getTxtPassword().getText());
				GestionDePersonal.getInstance().modificaOperario(operario, "nombreUsuario", this.vista.getTxtUsuario().getText());
				this.vista.actualizaLista();
			}
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioABM controladorOperarioABM = new ControladorOperarioABM();
		}
	}

}
