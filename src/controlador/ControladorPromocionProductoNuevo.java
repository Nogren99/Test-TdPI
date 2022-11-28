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

public class ControladorPromocionProductoNuevo implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionProductosNuevo vista;
	private boolean dosx1;
	private boolean descuentoxcantidad;
	
	public ControladorPromocionProductoNuevo() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionProductosNuevo(); // arranca la vista
		this.vista.setActionListener(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		Producto producto;
		float porcentaje=0;
		int cantminima=0;
		producto=this.vista.getProductoSeleccionada();
		if (comando.equals("SI CANTIDAD"))
			descuentoxcantidad=true;
		else if(comando.equals("NO CANTIDAD"))
			descuentoxcantidad=false;
		else if(comando.equals("SI 2X1"))
			dosx1=true;
		else if(comando.equals("NO 2X1"))
				dosx1=false;
		else if (comando.equals("CREAR")) {
			porcentaje=Float.parseFloat(this.vista.getTxtPorcentaje().getText());
			cantminima=Integer.parseInt(this.vista.getTxtCantMinimaDescuento().getText());
			MetodosFacturacion.getInstance().altaPromocionProducto(producto,this.vista.getTxtDiaSemana().getText(),dosx1,descuentoxcantidad,cantminima,porcentaje,true);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorPromocionProducto controladorPromocionProducto = new ControladorPromocionProducto();
		}
	}

}
