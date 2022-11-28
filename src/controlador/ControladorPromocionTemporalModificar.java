package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;
import vista.VentanaMesas;
import vista.VentanaMesasNueva;
import vista.VentanaMozoNueva;
import vista.VentanaOperarioABMNuevo;
import vista.VentanaOperarioAdmin;
import vista.VentanaPromocionProductosNuevo;
import vista.VentanaPromocionTemporalModificar;
import vista.VentanaPromocionTemporalNuevo;

public class ControladorPromocionTemporalModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionTemporalModificar vista;
	private boolean dosx1;
	private boolean descuentoxcantidad;
	
	public ControladorPromocionTemporalModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionTemporalModificar(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		String formaDePago;
		int porcentaje=0;
		boolean activa=true;
		boolean acumulable=true;
		formaDePago=this.vista.getProductoSeleccionada();
		if (comando.equals("CREAR")) {
			porcentaje=Integer.parseInt(this.vista.getTxtPorcentajedesc().getText());
			if (this.vista.getTxtEstado().getText().equalsIgnoreCase("si") )
				activa=true;
			else
				activa=false;
			if (this.vista.getTxtAcumulable().getText().equalsIgnoreCase("si") )
					acumulable=true;
				else
					acumulable=false;
			MetodosFacturacion.getInstance().modificacionPromocionTemporal(this.vista.getListPromocionTemporal(),this.vista.getTxtNombre().getText(),formaDePago,porcentaje,this.vista.getTxtDiaPromo().getText(),activa,acumulable);
			this.vista.actualizaLista();
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorPromocionTemporal controladorPromocionProducto = new ControladorPromocionTemporal();
		}
	}

}
