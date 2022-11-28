package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeNegocios.Local;
import main.Main_MIKEL_TOBIAS;
import vista.VentanaLogin;
import vista.VentanaOperario;
import vista.VentanaOperarioAdmin;

@SuppressWarnings("deprecation")
public class ControladorOperarioAdmin implements ActionListener, Observer {
	private Local modelo;
	private Operario operario = null;
	private int tipoUsuario = 0; // 0 = operario, 1 = operarioAdmin;
	private VentanaOperarioAdmin vista;

	public ControladorOperarioAdmin() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaOperarioAdmin(); // arranca la vista
		this.vista.setActionListener(this);

	}

	@Override
	public void update(Observable o, Object arg) { //escucha al modelo
	    	if (o != this.modelo)
	    	    throw new InvalidParameterException();
	    	
	  	}

	@Override
	public void actionPerformed(ActionEvent e) { // escucha la vista
		String comando=e.getActionCommand();
		if(comando.equals("ARRANCAR DIA")) {
			this.vista.getBtnMozoMesa().setEnabled(true);
		}
		else if(comando.equals("MOZOMESA")) {
			this.vista.esconder();
			ControladorMozoMesa controladorMozoMesa= new ControladorMozoMesa();
		}
		else if (comando.equals("VER ESTADISTICAS")) {
			this.vista.esconder();
			ControladorEstadistica controladorEstadistica= new ControladorEstadistica();
		}
		else if (comando.equals("CONFIGURAR EMPRESA")) {
			this.vista.esconder();
			ControladorEmpresa controladorEmpresa= new ControladorEmpresa();
		}
		else if (comando.equals("OPERARIOSABM")) {
			this.vista.esconder();
			ControladorOperarioABM controladorOperariosABM= new ControladorOperarioABM();
		}
		else if (comando.equals("MESAS")) {
			this.vista.esconder();
			ControladorMesas controladorMesas= new ControladorMesas();
		}
		else if (comando.equals("PRODUCTOS")) {
			this.vista.esconder();
			ControladorProducto controladorProducto = new ControladorProducto();
		}
		else if(comando.equals("MOZOS")) {
			this.vista.esconder();
			ControladorMozo controladorMozos = new ControladorMozo();
		}
		else if (comando.equals("PROMOCION PRODUCTO")) {
			this.vista.esconder();
			ControladorPromocionProducto controladorPromocionProducto = new ControladorPromocionProducto();
		}
		else if (comando.equals("PROMOCION TEMPORAL")) {
			this.vista.esconder();
			ControladorPromocionTemporal controladorPromocionTemporal = new ControladorPromocionTemporal();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorOperario controladorOperario = new ControladorOperario();
		}
		else if (comando.equals("PERSISTIR")) {
			Local.getInstance().guardarLocal(Main_MIKEL_TOBIAS.nombreArchivo);
		}

	}
}
