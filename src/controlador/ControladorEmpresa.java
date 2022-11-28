package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import vista.VentanaEmpresa;
import vista.VentanaLogin;

public class ControladorEmpresa implements ActionListener, Observer {
	private Local modelo;
	private VentanaEmpresa vista;
	
	
	
	public ControladorEmpresa() {
		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaEmpresa(); // arranca la vista
		this.vista.setActionListener(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		float sueldo=0;
		if(comando.equals("CONFIRMAR")) {
			sueldo=Float.parseFloat(this.vista.getTxtSueldo().getText());
			if (this.vista.getTxtNombreEmpresa().equals("") && !this.vista.getTxtSueldo().equals("")) {
				Local.getInstance().setNombreLocal(this.vista.getTxtNombreEmpresa().getText());
			}else if (!this.vista.getTxtNombreEmpresa().equals("") && this.vista.getTxtSueldo().equals("")) {
				Local.getInstance().setSueldo(sueldo);
			}
			else if (this.vista.getTxtNombreEmpresa().equals("") && this.vista.getTxtSueldo().equals("")) {
				Local.getInstance().setNombreLocal(this.vista.getTxtNombreEmpresa().getText());
				Local.getInstance().setSueldo(sueldo);
			}
			
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperarioAdmin controladorOperarioadmin = new ControladorOperarioAdmin();
		}
		
	}

}
