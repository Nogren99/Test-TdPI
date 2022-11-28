/**
 * 
 */
package capaDeNegocios;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Producto;

/**
 * @author tobia
 *
 */
public class ConfiguracionDeSistema {

	private static ConfiguracionDeSistema instance = null;

	private ConfiguracionDeSistema() {
	}

	/**
	 * @return instancia de este SubSingleton para separar los metodos
	 */
	public static ConfiguracionDeSistema getInstance() { // Singelton
		if (instance == null)
			instance = new ConfiguracionDeSistema();
		return instance;
	}

	/**
	 * Se da de alta una mesa en la lista de mesas del sistema. Si la lista de mesas
	 * del sistema esta vacia se le agrega como id al producto el prefijo de mesas
	 * del local. Si la lista tiene al menos 1 mesa, se le suma 1 al id de la ultima
	 * mesa de la lista.
	 * 
	 */
	public void altaMesa() {
		int id;
		Mesa mesa;
		ArrayList<Mesa> mesas = Local.getInstance().getMesas();
		if (mesas.isEmpty()) {
			id = Local.prefijoMesa;
		} else {
			id = mesas.get(mesas.size() - 1).getId() + 1;
		}
		mesa = new Mesa(id);
		Local.getInstance().getMesas().add(mesa);
	}

	/**
	 * Se elimina una mesa pasada por parametro de la lista de mesas
	 * 
	 * @param mesa: Parametro de tipo mesa a eliminar
	 */
	public void bajaMesa(Mesa mesa) {
		Local.getInstance().getMesas().remove(mesa);
	}

	/**
	 * 
	 * Se modifica una mesa de acuerdo a la accion especificada y se settea con
	 * parámetro valor. Accion permitida es "comensales", en otro caso, no hace
	 * nada. Valor debería ser un entero mayor a cero.
	 * 
	 * @param mesa:   Parametro de tipo mesa a modificar
	 * @param accion: Parametro tipo String que indica tipo de modificacion de mesa
	 *                a realizar.
	 * @param valor:  Parametro tipo entero que indica la cantidad de comensales de
	 *                la mesa a settear.
	 */
	public void modificaMesa(Mesa mesa, String accion, int valor) {
		switch (accion) {
		case "comensales":
			mesa.setComensales(valor);
			break;
		default:
			// Raise exception;
		}
	}

	/**
	 * 
	 * Se modifica el estado de una mesa y se settea con el valor pasado por
	 * parametro. La accion debería ser estado, en otro caso.
	 * 
	 * @param mesa:   Parametro de tipo mesa distinto de null
	 * @param accion: Parametro tipo String que indica tipo de modificacion de mesa
	 *                a realizar.
	 * @param valor:  Parametro tipo entero que indica la cantidad de comensales de
	 *                la mesa a settear.
	 */
	public void modificaMesa(Mesa mesa, String accion, String valor) {
		switch (accion) {
		case "estado":
			mesa.setEstado(valor);
			break;
		default:
			// Raise exception;
		}
	}

	/**
	 * Se da de alta un producto en la lista de productos del sistema. Si la lista
	 * de productos del sistema esta vacia se le agrega como id al producto el
	 * prefijo de producto del local. Si la lista tiene al menos 1 producto, se le
	 * suma 1 al id del ultimo producto de la lista.
	 * 
	 * @param stock:       Parametro de tipo entero que representa el stock inicial
	 *                     del producto
	 * @param nombre:      Parametro de tipo string que representa el nombre del
	 *                     producto.
	 * @param precioCosto: Parametro de tipo float que representa el precio de costo
	 *                     del producto.
	 * @param precioVenta: Parametro de tipo float que representa el precio de venta
	 *                     del producto.
	 */
	public void altaProducto(int stock, String nombre, float precioCosto, float precioVenta) {
		int id;
		Producto producto;
		ArrayList<Producto> productos = Local.getInstance().getProductos();
		if (productos.isEmpty()) {
			id = Local.prefijoProducto;
		} else {
			id = productos.get(productos.size() - 1).getId() + 1;
		}
		producto = new Producto(id, stock, nombre, precioCosto, precioVenta);
		Local.getInstance().getProductos().add(producto);
	}

	/**
	 * Se elimina un producto pasado por parametro de la lista de productos.
	 * 
	 * @param producto: Parametro de tipo producto a eliminar.
	 */
	public void bajaProductos(Producto producto) {
		Local.getInstance().getProductos().remove(producto);
	}

	/**
	 * Se modifica el stock de un producto pasado por parametro. La accion debería
	 * ser stock. valor debería ser un valor mayor o igual a 0.
	 * 
	 * @param producto: Parametro de tipo Producto a modificar.
	 * @param accion:   Parametro de tipo string que indica atributo a modificar.
	 * @param valor:    Parametro de tipo entero que indica el valor del atributo a
	 *                  modificar.
	 */
	public void modificaProducto(Producto producto, String accion, int valor) {
		switch (accion) {
		case "stock":
			producto.setStock(valor);
			break;
		default:
			// Raise exception;
		}
	}

	/**
	 * Se modifican el nombre del producto pasado por parametro. La accion deberia
	 * ser nombre, en otro caso, no hace nada. valor debería ser distinto de null.
	 * 
	 * @param producto: Parametro de tipo Producto a modificar.
	 * @param accion:   Parametro de tipo string que indica atributo a modificar.
	 * @param valor:    Parametro de tipo String que indica el valor del atributo a
	 *                  modificar.
	 */
	public void modificaProducto(Producto producto, String accion, String valor) {
		switch (accion) {
		case "nombre":
			producto.setNombre(valor);
			break;
		default:
			// Raise exception;
		}
	}

	/**
	 * Se modifican los precios del producto pasado por parametro. La accion debería
	 * ser precioCosto o precioVenta. valor deberia ser mayor a 0.
	 * 
	 * @param producto: Parametro de tipo Producto a modificar.
	 * @param accion:   Parametro de tipo string que indica atributo a modificar.
	 * @param valor:    Parametro de tipo float que indica el valor del atributo a
	 *                  modificar.
	 */
	public void modificaProducto(Producto producto, String accion, float valor) {
		switch (accion) {
		case "precioCosto":
			producto.setPrecioCosto(valor);
			break;
		case "precioVenta":
			producto.setPrecioVenta(valor);
			break;
		default:
			// Raise exception;
		}
	}

}
