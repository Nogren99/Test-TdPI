package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;
import vista.VentanaMesas;
import vista.VentanaMesasModificar;
import vista.VentanaMesasNueva;
import vista.VentanaMozoModificar;
import vista.VentanaOperarioABMModificar;
import vista.VentanaOperarioAdmin;
import vista.VentanaPromocionProductosModificar;
import vista.VentanaPromocionProductosNuevo;

public class ControladorPromocionProductoModificar implements ActionListener, Observer{
	private Local modelo;
	private VentanaPromocionProductosModificar vista;
	private boolean dosx1;
	private boolean descuentoxcantidad;
	
	public ControladorPromocionProductoModificar() {

		this.modelo = Local.getInstance(); // arranca el modelo
		this.modelo.addObserver(this);
		
		this.vista = new VentanaPromocionProductosModificar(); // arranca la vista
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
		PromocionProducto promocionProducto;
		float porcentaje=0;
		int cantminima=0;
		producto=this.vista.getProductoSeleccionada();
		promocionProducto = this.vista.getPromocionProductoSeleccionada();
		if (comando.equals("SI CANTIDAD"))
			descuentoxcantidad=true;
		else if(comando.equals("NO CANTIDAD"))
			descuentoxcantidad=false;
		else if(comando.equals("SI 2X1"))
			dosx1=true;
		else if(comando.equals("NO 2X1"))
				dosx1=false;
		else if (comando.equals("GUARDAR")) {
			porcentaje=Float.parseFloat(this.vista.getTxtPorcentaje().getText());
			cantminima=Integer.parseInt(this.vista.getTxtCantidadMinimaDescuento().getText());
			MetodosFacturacion.getInstance().modificacionPromocionProducto(promocionProducto,this.vista.getTxtDiaSemana().getText(),dosx1,descuentoxcantidad,porcentaje,cantminima,true);
		}
		else if (comando.equals("VOLVER")) {
			this.vista.esconder();
			ControladorPromocionProducto controladorPromocionProducto = new ControladorPromocionProducto();
		}
	}

}
