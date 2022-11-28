package persistencia;

import java.util.ArrayList;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;

public class LocalDTO {
	private ArrayList<MesaDTO> mesas = new ArrayList<MesaDTO>();
	private ArrayList<MozoDTO> mozos = new ArrayList<MozoDTO>();
	private ArrayList<OperarioDTO> operarios = new ArrayList<OperarioDTO>();
	private ArrayList<ProductoDTO> productos = new ArrayList<ProductoDTO>();
	private ArrayList<PromocionProductoDTO> promocionesProductos = new ArrayList<PromocionProductoDTO>();
	private ArrayList<PromocionTemporalDTO> promocionesTemporales = new ArrayList<PromocionTemporalDTO>();

	public LocalDTO() {
	}

	public ArrayList<MesaDTO> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<MesaDTO> mesas) {
		this.mesas = mesas;
	}

	public ArrayList<MozoDTO> getMozos() {
		return mozos;
	}

	public void setMozos(ArrayList<MozoDTO> mozos) {
		this.mozos = mozos;
	}

	public ArrayList<OperarioDTO> getOperarios() {
		return operarios;
	}

	public void setOperarios(ArrayList<OperarioDTO> operarios) {
		this.operarios = operarios;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

	public ArrayList<PromocionProductoDTO> getPromocionesProductos() {
		return promocionesProductos;
	}

	public void setPromocionesProductos(ArrayList<PromocionProductoDTO> promocionesProductos) {
		this.promocionesProductos = promocionesProductos;
	}

	public ArrayList<PromocionTemporalDTO> getPromocionesTemporales() {
		return promocionesTemporales;
	}

	public void setPromocionesTemporales(ArrayList<PromocionTemporalDTO> promocionesTemporales) {
		this.promocionesTemporales = promocionesTemporales;
	}
	
	
}
