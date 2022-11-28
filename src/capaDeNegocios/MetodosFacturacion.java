package capaDeNegocios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import capaDeDatos.Comanda;
import capaDeDatos.Factura;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;

public class MetodosFacturacion {

	private static MetodosFacturacion instance = null;

	private MetodosFacturacion() {
	}// constructor
	
	/**
	 * @return instancia de este SubSingleton para separar los metodos
	 */
	public static MetodosFacturacion getInstance() {
		if (MetodosFacturacion.instance == null)
			MetodosFacturacion.instance = new MetodosFacturacion();
		return MetodosFacturacion.instance;
	}

	/**
	 * Se crea la promocion de un producto de la lista de productos y se agrega a lista de productos del sistema. 
	 * diaProm deberia ser un dia de la semana. cantidadMinima deberia ser mayor a 0.
	 * descCantMin deberia ser mayor a 0.
	 * 
	 * @param producto: Parametro de tipo Producto que representa producto del cual se hara promocion.
	 * @param diaProm: Parametro de tipo String que indica el dia de la semana que es valida la promocion.
	 * @param dosXuno: Parametro de tipo boolean que indica si la promocion incluye 2x1.
	 * @param descuentoCantMin: Parametro de tipo boolean que indica si la promocion incluye descuento de acuerdo a una cantidad minima.
	 * @param cantidadMinima: Parametro de tipo entero que indica la cantidad minima a partir de la cual se aplica la promocion.
	 * @param descCantMin: Parametro de tipo float que indica el porcentaje de descuento por cantidad minima.
	 * @param activa: Parametro de tipo boolean que indica si la promocion se encuentra activa o no.
	 */
	public void altaPromocionProducto(Producto producto, String diaProm, boolean dosXuno, boolean descuentoCantMin,
			int cantidadMinima, float descCantMin, boolean activa) {
		PromocionProducto aux = new PromocionProducto(producto, diaProm, dosXuno, descuentoCantMin, cantidadMinima,
				descCantMin, activa);
		Local.getInstance().getPromocionesProductos().add(aux);
	}
	
	/**
	 * Se elimina la promocion de la lista de promociones de producto. Si promocion no esta en la lista, no hace nada.
	 * 
	 * @param prom: Parametro de tipo PromocionProducto a eliminar de la lista.
	 */
	public void bajaPromocionProducto(PromocionProducto prom) {
		Local.getInstance().getPromocionesProductos().remove(prom);
	}

	/**
	 * Se modifican todos los parametros de la promocion de producto pasada por parametro.
	 * diaProm deberia ser un dia de la semana. cantidadMinima deberia ser mayor a 0.
	 * descCantMin deberia ser mayor a 0.
	 * 
	 * @param prom: Parametro de tipo Promocion que representa la promocion del cual se modificaran los atributos.
	 * @param diaProm: Parametro de tipo String que indica el dia de la semana que es valida la promocion.
	 * @param dosXuno: Parametro de tipo boolean que indica si la promocion incluye 2x1.
	 * @param descuentoCantMin: Parametro de tipo boolean que indica si la promocion incluye descuento de acuerdo a una cantidad minima.
	 * @param porcentajeCantMin: Parametro de tipo Float que indica el porcentaje de descuento que se aplica a promociones tipo descuentoCantMin
	 * @param cantidadMinima: Parametro de tipo entero que indica la cantidad minima a partir de la cual se aplica la promocion.
	 * @param activa: Parametro de tipo boolean que indica si la promocion se encuentra activa o no.
	 */
	public void modificacionPromocionProducto(PromocionProducto prom, String diaProm, boolean dosXuno,
			boolean descuentoCantMin, float porcentajeCantMin, int cantidadMinima, boolean activa) {
		prom.setDiaProm(diaProm);
		prom.setDosXuno(dosXuno);
		prom.setDescuentoCantMin(descuentoCantMin);
		prom.setCantidadMinima(cantidadMinima);
		prom.setPorcentajeDescCantMin(porcentajeCantMin);
		prom.setActiva(activa);
	}

	/**
	 * Se crea y da de alta una nueva promocion temporal a la lista de promociones temporales. 
	 * porcentajeDesc deberia ser mayor a 0
	 * diasDePromo deberia indicar los dias de la semana.
	 * activa deberia ser true o false.
	 * acumulable deberia ser true o false.
	 * 
	 * @param nombre: parametro de tipo String que indica el nombre de la nueva promocion temporal.
	 * @param formaPago: parametro de tipo String que indica forma de pago.
	 * @param porcentajeDesc: parametro de tipo entero que indica porcentaje de descuento.
	 * @param diasDePromo: parametro de tipo String que indica dias de promocion.
	 * @param activa: parametro de tipo Boolean que indica si promocion esta activa o no.
	 * @param acumulable: parametro de tipo boolean que indica si es acumulable con otras promociones.
	 */
	public void altaPromocionTemporal(String nombre, String formaPago, int porcentajeDesc, String diasDePromo,
			boolean activa, boolean acumulable) {
		PromocionTemporal aux = new PromocionTemporal(nombre, formaPago, porcentajeDesc, diasDePromo, activa,
				acumulable);
		Local.getInstance().getPromocionesTemporales().add(aux);
	}
	
	/**
	 * Se elimina una promocion temporal de la lista de promociones temporales. 
	 * 
	 * @param prom: Parametro de tipo PromocionTemporal a eliminar.
	 */
	public void bajaPromocionTemporal(PromocionTemporal prom) {
		Local.getInstance().getPromocionesTemporales().remove(prom);
	}

	/**
	 * Se modifican todos los parametros de la promocion temporal pasada por parametro.
	 * porcentajeDesc deberia ser mayor a 0
	 * diasDePromo deberia indicar los dias de la semana.
	 * activa deberia ser true o false.
	 * acumulable deberia ser true o false.
	 * 
	 * @param nombre: parametro de tipo String que indica el nombre de la nueva promocion temporal.
	 * @param formaPago: parametro de tipo String que indica forma de pago.
	 * @param porcentajeDesc: parametro de tipo entero que indica porcentaje de descuento.
	 * @param diasDePromo: parametro de tipo String que indica dias de promocion.
	 * @param activa: parametro de tipo Boolean que indica si promocion esta activa o no.
	 * @param acumulable: parametro de tipo boolean que indica si es acumulable con otras promociones.
	 */
	public void modificacionPromocionTemporal(PromocionTemporal prom, String nombre, String formaPago,
			int porcentajeDesc, String diasDePromo, boolean activa, boolean acumulable) {
		prom.setNombre(nombre);
		prom.setFormaPago(formaPago);
		prom.setPorcentajeDesc(porcentajeDesc);
		prom.setDiasDePromo(diasDePromo);
		prom.setActiva(activa);
		prom.setAcumulable(acumulable);
	}

	/**
	 * Se genera una factura. Se pasa como parametro la comanda a cerrar a partir de la cual se calculara el total de la factura y a mesa a cambiar de estado. Se indica el metodo de pago, fecha y dia de la semana.
	 * A partir de la lista de pedidos de la comanda se calcula el total. De la lista de pedidos se obtienen los productos.
	 * Se verifica que los productos se encuentren o no en la lista de promociones temporales y/o en la lista de promociones de producto.
	 * A traves de la mesa de la comanda se obtiene el mozo asignado a la misma. Al mozo se le actualiza el acumulado y se le aumenta en 1 la cantidad de mesas atendidas.
	 * 
	 * <b>Pre: </b> comanda != null<br>
	 * @param fecha: Parametro de tipo Calendar que indica la fecha del sistema.
	 * @param diaSemana: Parametro de tipo String que indica el dia de la semana que se emitio la factura.
	 * @param comanda: Parametro de tipo comanda que indica la comanda a cerrar y a partir de la cual se obtendran los datos para cerrar la factura.
	 * @param metodoDePago: Parametro de tipo String que indica el metodo de pago de la factura.
	 * @return Factura generada
	 */
	public Factura generacionDeFactura(Calendar fecha, String diaSemana, Comanda comanda, String metodoDePago) {
		Factura aux;
		float tot = 0, min, valor;
		Producto auxproducto;
		Mozo mozo;
		ArrayList<PromocionProducto> promsProducto = new ArrayList<PromocionProducto>();
		ArrayList<PromocionTemporal> promsTemp = new ArrayList<PromocionTemporal>();
		int i = 0, j = 0, bandera = -1, cantmin;
		for (i = 0; i < Local.getInstance().getPromocionesTemporales().size(); i++) {
			if (Local.getInstance().getPromocionesTemporales().get(i).getFormaPago().equalsIgnoreCase(metodoDePago)
					&& Local.getInstance().getPromocionesTemporales().get(i).isActiva()
					&& Local.getInstance().getPromocionesTemporales().get(i).getDiasDePromo().equals(fecha)) {
				bandera = i;
				promsTemp.add(Local.getInstance().getPromocionesTemporales().get(i));
			}
		}
		for (i = 0; i < comanda.getListaPedidos().size(); i++) {
			auxproducto = comanda.getListaPedidos().get(i).getProducto();
			while (j < Local.getInstance().getPromocionesProductos().size()
					&& !Local.getInstance().getPromocionesProductos().get(j).getProducto().equals(auxproducto))// busco
																												// la
																												// del
																												// producto
				j++;
			if (j < Local.getInstance().getPromocionesProductos().size()
					&& Local.getInstance().getPromocionesProductos().get(j).getDiaProm().equalsIgnoreCase(diaSemana)
					&& Local.getInstance().getPromocionesProductos().get(j).isActiva() == true) { // no hay oferta
																									// disponible
				if (Local.getInstance().getPromocionesProductos().get(j).isDosXuno()) { // si se aplica 2x1
					if (comanda.getListaPedidos().get(i).getCantidad() == 2
							|| comanda.getListaPedidos().get(i).getCantidad() == 1)
						tot += auxproducto.getPrecioVenta();
					else if (comanda.getListaPedidos().get(i).getCantidad() % 2 == 0)
						tot += comanda.getListaPedidos().get(i).getCantidad() * auxproducto.getPrecioVenta() / 2;
					else
						tot += (comanda.getListaPedidos().get(i).getCantidad() - 1) * auxproducto.getPrecioVenta() / 2
								+ auxproducto.getPrecioVenta();
					promsProducto.add(Local.getInstance().getPromocionesProductos().get(j));
				} else if (Local.getInstance().getPromocionesProductos().get(j).isDescuentoCantMin()) {// si hay
																										// descuento por
																										// cantidad
																										// minima
					min = Local.getInstance().getPromocionesProductos().get(j).getCantidadMinima();
					if (comanda.getListaPedidos().get(i).getCantidad() > min) {
						valor = comanda.getListaPedidos().get(i).getCantidad() * auxproducto.getPrecioVenta();
						valor = valor - valor
								* Local.getInstance().getPromocionesProductos().get(j).getPorcentajeDescCantMin() / 100;
						tot += valor;
						promsProducto.add(Local.getInstance().getPromocionesProductos().get(j));
					}
				} else
					tot += comanda.getListaPedidos().get(i).getCantidad() * auxproducto.getPrecioVenta();
			} else
				tot += comanda.getListaPedidos().get(i).getCantidad() * auxproducto.getPrecioVenta();
		} // hasta aca es la promo producto
		if (bandera > -1) {
			tot = tot - tot * Local.getInstance().getPromocionesTemporales().get(bandera).getPorcentajeDesc() / 100;
		}
		mozo = Local.getInstance().getMozoByMesa(comanda.getMesa());
		mozo.setAcumulados(mozo.getAcumulados() + tot);
		mozo.setMesasAtentidas(mozo.getMesasAtentidas() + 1);
		return aux = new Factura(fecha, comanda.getMesa(), comanda.getListaPedidos(), tot, metodoDePago, promsTemp,
				promsProducto);
	}

	
	/**
	 * Se crea y da de alta un pedido a la lista de pedidos si la cantidad pedida de ese producto esta disponible.
	 * Se actualiza el stock del producto pedido.
	 * 
	 * <b>Pre: </b> producto != null<br>
	 * <b>Pre: </b> cantidad > 0<br>
	 * @param hoy: Parametro de tipo String convertido de un GregorianCalendar.
	 * @param cantidad: Parametro de tipo int que representa la cantidad del producto pedido
	 * @param producto: Parametro de tipo Producto que representa el producto pedido
	 * @return el nuevo pedido o null en caso de que no haya stock suficiente.
	 */
	public Pedido altaPedido(String hoy, int cantidad, Producto producto) {
		Pedido nuevo = null;
		if (producto.getStock() - cantidad >= 0) {
			producto.setStock(producto.getStock() - cantidad);
			nuevo = new Pedido(hoy, cantidad, producto);
		}
		return nuevo;
	}

	/**
	 * Se da de baja un pedido de la lista de pedidos de una comanda.
	 * @param comanda: Parametro de tipo comanda de la cual se da de baja el pedido.
	 * @param pedido: Parametro de tipo pedido que indica pedido que se da de baja de la lista de una comanda.
	 */
	public void bajaPedido(Comanda comanda, Pedido pedido) {
		comanda.getListaPedidos().remove(pedido);
	}

	/**
	 * Se crea y se da de alta una nueva comanda como activa en la lista de comandas del local.

	 * 
	 * <b>Pre: </b> mesa != null<br>
	 * <b>Pre: </b> pedido != null<br>
	 *
	 * @param mesa: Parametro de tipo Mesa a la cual se le asignara la comanda.
	 * @param pedido: Parametro de tipo Pedido que indica pedido inicial de la comanda.
	 * @return nueva instancia de Comanda 
	 */
	public Comanda altaComanda(Mesa mesa, Pedido pedido) {
		Comanda nuevo = new Comanda(mesa, pedido, true);
		mesa.setEstado("Ocupada");
		Local.getInstance().getComandas().add(nuevo);
		return nuevo;
	}
	
	/**
	 * Se da de baja la comanda y se da de baja la comanda
	 * 
	 * @param comanda distinto de null 
	 * @param metodoDePago distinto de null
	 * @return factura generada
	 */
	public Factura bajaComanda(Comanda comanda, String metodoDePago) {

		Calendar ahora = new GregorianCalendar();
		String diaSemana = Local.getInstance().getDiaSemana(ahora.DAY_OF_WEEK);

		Local.getInstance().getComandas().remove(comanda);

		return generacionDeFactura(ahora, diaSemana, comanda, metodoDePago);
	}

	
	/**
	 * Se agrega o se remueve un pedido de la lista de pedidos de la comanda.
	 * <b>Pre: </b> comanda != null<br>
	 * <b>Pre: </b> pedido != null<br>
	 * @param comanda: Parametro de tipo Comanda que representa la comanda de la cual se actualizara la lista de pedidos.
	 * @param pedido: Parametro de tipo Pedido que representa el pedido a dar de alta o baja de la lista de pedidos de la comanda.
	 * @param agregar: Parametro de tipo boolean que representa accion a realizar.
	 */
	public void modificacionComanda(Comanda comanda, Pedido pedido, boolean agregar) {
		int pos = Local.getInstance().getComandas().indexOf(comanda);
		if (agregar)
			Local.getInstance().getComandas().get(pos).getListaPedidos().add(pedido);
		else
			Local.getInstance().getComandas().get(pos).getListaPedidos().remove(pedido);
	}
}