package capaDeDatos;

import java.util.ArrayList;
import java.util.Calendar;

public class Factura {
	private static int nroID = 0;
	private int iDFactura;
	private Calendar fecha;
	private Mesa mesa;
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private float total;
	private String metodoPago;
	private ArrayList<PromocionTemporal> totPromocionesTemp = new ArrayList<PromocionTemporal>();
	private ArrayList<PromocionProducto> totPromocionesProd = new ArrayList<PromocionProducto>();

	public Factura(Calendar fecha, Mesa mesa, ArrayList<Pedido> listaPedidos, float total, String metodoPago,
			ArrayList<PromocionTemporal> totPromocionesTemp, ArrayList<PromocionProducto> totPromocionesProd) {
		nroID++;
		this.iDFactura = nroID;
		this.fecha = fecha;
		this.mesa = mesa;
		for (int i = 0; i < listaPedidos.size(); i++) {
			this.getListaProductos().add(listaPedidos.get(i).getProducto());
		}
		this.total = total;
		this.metodoPago = metodoPago;
		this.totPromocionesTemp = totPromocionesTemp;
		this.totPromocionesProd = totPromocionesProd;
	}

	@Override
	public String toString() {
		return "Factura [iD=" + iDFactura + ", mesa=" + mesa.getId() + ", metodoPago=" + metodoPago + "||"+ totPromocionesTemp + "||"+ totPromocionesProd;
	}

	public int getiDFactura() {
		return iDFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public ArrayList<PromocionTemporal> getTotPromocionesTemp() {
		return totPromocionesTemp;
	}

	public void setTotPromocionesTemp(ArrayList<PromocionTemporal> totPromocionesTemp) {
		this.totPromocionesTemp = totPromocionesTemp;
	}

	public ArrayList<PromocionProducto> getTotPromocionesProd() {
		return totPromocionesProd;
	}

	public void setTotPromocionesProd(ArrayList<PromocionProducto> totPromocionesProd) {
		this.totPromocionesProd = totPromocionesProd;
	}

}
