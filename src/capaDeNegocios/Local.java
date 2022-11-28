package capaDeNegocios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Observable;

import capaDeDatos.AsignacionDiaria;
import capaDeDatos.Comanda;
import capaDeDatos.Factura;
import capaDeDatos.LocalDatos;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import controlador.ControladorLogin;
import persistencia.IPersistencia;
import persistencia.LocalDTO;
import persistencia.PersistenciaXML;
import persistencia.UtilLocal;

/**
<b>inv: </b> <br>
* formasDePago != null <br>
* mesas != null <br>
* mozos != null <br>
* facturas != null <br>
* promocionesProductos != null <br>
* promocionesTemporales != null <br>
* operarios != null <br>
* operarioAdministrador != null <br>
* operarioAdministrador nunca es vacío <br>
* comandas != null <br>
* productos != null <br>
* asignacionDiaria != null <br>
*/
@SuppressWarnings("deprecation")
public class Local extends Observable {
	private static Local instance = null;
	public static final int prefijoOperario = 10000;
	public static final int prefijoMozo = 20000;
	public static final int prefijoMesa = 30000;
	public static final int prefijoProducto = 40000;

	private boolean admin; // indica si quien logeo es admin o no
	private String nombreLocal;
	private float sueldo;
	private LocalDatos localdatos;
	private OperarioAdministrador operarioAdministrador;
	private ArrayList<String> formasDePago = new ArrayList<String>();
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	private ArrayList<PromocionProducto> promocionesProductos = new ArrayList<PromocionProducto>();
	private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<PromocionTemporal>();
	private ArrayList<Operario> operarios = new ArrayList<Operario>();
	private ArrayList<Comanda> comandas = new ArrayList<Comanda>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private ArrayList<AsignacionDiaria> asignacionDiaria = new ArrayList<AsignacionDiaria>();
	private GestionDePersonal zonaPersonal;
	private MetodosFacturacion zonaFacturacion;
	private ConfiguracionDeSistema zonaConfSistema;

	
	/**
	 * Constructor Del local, es un singleton
	 */
	private Local() {
		this.nombreLocal = "Local1";
		this.sueldo = 999;
		this.admin = false;
		this.formasDePago.add("Efectivo");
		this.formasDePago.add("Debito");
		this.formasDePago.add("MercadoPago");
		this.formasDePago.add("Cuenta DNI");
		operarioAdministrador = new OperarioAdministrador(0, "ADMIN", "01/05/2000", "ADMIN", "ADMIN1234");
		this.zonaFacturacion = MetodosFacturacion.getInstance();
		this.zonaConfSistema = ConfiguracionDeSistema.getInstance();
		this.zonaPersonal = GestionDePersonal.getInstance();
	}

	/**
	 * @return Retorna una relacion Mesa_Mozo
	 */
	
	public ArrayList<AsignacionDiaria> getAsignacionDiaria() {
		return asignacionDiaria;
	}
	/**
	 * @return Se instancia el singleton, retorna siempre el Local
	 */
	public static Local getInstance() { // Singelton
		if (instance == null)
			instance = new Local();
		return instance;
	}
	
	public static void elimInstance() {
		if(instance!=null){
			instance= null;
		}
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public ArrayList<Mozo> getMozos() {
		return mozos;
	}

	public ArrayList<Operario> getOperarios() {
		return operarios;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean esAdmin) {
		this.admin = esAdmin;
	}

	
	
	/**
	 * Obtiene una comanda de la lista de comandas a partir de la mesa.
	 * <b>Pre: </b> mesa != null<br>
	 * @param mesa no puede ser null
	 * @return comanda asociada a la mesa
	 */
	public Comanda getComandaByMesa(Mesa mesa) {
		Comanda comanda = null;
		int i = 0;
		while (i < comandas.size() && !(comandas.get(i).getMesa().equals(mesa)))
			i++;
		if (i < comandas.size()) {
			comanda = comandas.get(i);
		}
		return comanda;
	}
	

	/**
	 * Obtiene un mozo de la lista de asignaciones diaria a partir de la mesa asignada.
	 * <b>Pre: </b> mesa != null<br>
	 * @param mesa no puede ser null
	 * @return mozo que tiene asignada la mesa
	 */
	public Mozo getMozoByMesa(Mesa mesa) {
		Mozo mozo= null;
		int i = 0;
		while (i < asignacionDiaria.size() && !(asignacionDiaria.get(i).getMesa().equals(mesa)))
			i++;
		if (i < asignacionDiaria.size()) {
			mozo = asignacionDiaria.get(i).getMozo();
		}
		return mozo;
	}
	
	
	/**
	 * Obtiene el mozo de la lista de mozos que tiene el maximo acumulado de ventas.
	 * @return mozo que tiene maximo acumulado de ventas
	 */
	public Mozo getMozoMaxVentas() {
		float max = -1;
		Mozo mozo= null;
		for (Mozo mozoActual :mozos) {
			if (mozoActual.getAcumulados() > max) {
				max = mozoActual.getAcumulados();
				mozo = mozoActual;
			}
		}
		if (mozo.getAcumulados() == 0) {
			mozo = null;
		}
		return mozo;
	}

	
	/**
	 * Obtiene el mozo de la lista de mozos que tiene el minimo acumulado de ventas.
	 * @return mozo que tiene minimo acumulado de ventas
	 */
	public Mozo getMozoMinVentas() {
		float min = 99999;
		Mozo mozo= null;
		for (Mozo mozoActual :mozos) {
			if (mozoActual.getAcumulados() < min) {
				min = mozoActual.getAcumulados();
				mozo = mozoActual;
			}
		}
		if (mozo.getAcumulados() == 0) {
			mozo = null;
		}
		return mozo;
	}
	
	
	
	/**
	 * Obtiene el mozo de la lista de mozos que tiene el maximo promedio de ventas por mesas atendidas.
	 * @return el mozo con el promedio maximo
	 */
	public Mozo getMozoMaxPromedio() {
		float max = -1;
		Mozo mozo= null;
		for (Mozo mozoActual :mozos) {
			if ((mozoActual.getAcumulados()/mozoActual.getMesasAtentidas()) > max) {
				max = (mozoActual.getAcumulados()/mozoActual.getMesasAtentidas());
				mozo = mozoActual;
			}
		}
		return mozo;
	}

	/**
	 * Obtiene el mozo de la lista de mozos que tiene el minimo promedio de ventas por mesas atendidas.
	 * @return el mozo con el promedio minimo
	 */
	public Mozo getMozoMinPromedio() {
		float min = 99999;
		Mozo mozo= null;
		for (Mozo mozoActual :mozos) {
			if (mozoActual.getAcumulados()/mozoActual.getMesasAtentidas() < min) {
				min = mozoActual.getAcumulados();
				mozo = mozoActual;
			}
		}
		return mozo;
	}
	
	/**
	 * A traves del nombre de usuario y password se verifica que se encuentre registrado como operario administrador o si se encuentra registrado en la lista de operarios.
	 * Si los datos son validos y no pertenece a ninguno de los dos tipos de operarios, no hace nada.
	 * Si es operario administrador settea atributo booleano admin de clase Local en true.
	 * @param nombreUsuario: Parametro de tipo String que representa el nombre de usuario.
	 * @param password: Parametro de tipo String que representa la contrasenia del usuario.
	 */
	public void login(String nombreUsuario, String password) {
		this.setChanged();

		int i = 0;
		if (operarioAdministrador.getNombreUsuario().equals(nombreUsuario)) {
			if (operarioAdministrador.getPassword().equals(password)) {
				this.admin = true;
				this.notifyObservers("LOGIN CORRECTO");
			} else {
				this.notifyObservers("PASSWORD INCORRECTO");
			}
		} else {
			while (i < operarios.size() && !(operarios.get(i).getNombreUsuario().equals(nombreUsuario)))
				i++;
			if (i < operarios.size()) {

				if (operarios.get(i).getPassword().equals(password)) {
					this.notifyObservers("LOGIN CORRECTO");
				} else {
					this.notifyObservers("PASSWORD INCORRECTO");
				}
			} else {
				this.notifyObservers("USER INCORRECTO");
			}
		}
	}


	public String getDiaSemana(int numero) {
		String dia;
		switch (numero) {
		case 1: {
			dia = "Domingo";
			break;
		}
		case 2: {
			dia = "Lunes";
			break;
		}
		case 3: {
			dia = "Martes";
			break;
		}
		case 4: {
			dia = "Miercoles";
			break;
		}
		case 5: {
			dia = "Jueves";
			break;
		}
		case 6: {
			dia = "Viernes";
			break;
		}
		case 7: {
			dia = "Sabado";
			break;
		}
		default:
			dia = "";
		}
		return dia;
	}

	public ArrayList<PromocionProducto> getPromocionesProductos() {
		return promocionesProductos;
	}

	public ArrayList<PromocionTemporal> getPromocionesTemporales() {
		return promocionesTemporales;
	}

	public ArrayList<Comanda> getComandas() {
		return comandas;
	}

	public ArrayList<String> getFormasDePago() {
		return formasDePago;
	}
	
	public void guardarLocal(String nombreArchivo) {
		IPersistencia persistencia = new PersistenciaXML();
		try {
			persistencia.abrirOutput(nombreArchivo);
			System.out.println(nombreArchivo + " creado.");
			LocalDTO localDTO = UtilLocal.LocalDTOFromLocal();
			persistencia.escribir(localDTO);
			System.out.println("Exito al grabar.");
			persistencia.cerrarOutput();
			System.out.println("Exito al cerrar.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarLocal(String nombreArchivo) {
		IPersistencia persistencia = new PersistenciaXML();
		try {
			persistencia.abrirInput(nombreArchivo);
			System.out.println(nombreArchivo + " abierto.");
			LocalDTO localDTO = (LocalDTO) persistencia.leer();
			UtilLocal.LocalFromLocalDTO(localDTO);
			System.out.println("Exito al leer.");
			persistencia.cerrarInput();
			System.out.println("Exito al cerrar.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(asignacionDiaria, comandas, facturas, formasDePago, localdatos, mesas, mozos, nombreLocal,
				operarios, productos, promocionesProductos, promocionesTemporales, sueldo, zonaConfSistema,
				zonaFacturacion, zonaPersonal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(asignacionDiaria, other.asignacionDiaria) && Objects.equals(comandas, other.comandas)
				&& Objects.equals(facturas, other.facturas) && Objects.equals(formasDePago, other.formasDePago)
				&& Objects.equals(localdatos, other.localdatos) && Objects.equals(mesas, other.mesas)
				&& Objects.equals(mozos, other.mozos) && Objects.equals(nombreLocal, other.nombreLocal)
				&& Objects.equals(operarios, other.operarios) && Objects.equals(productos, other.productos)
				&& Objects.equals(promocionesProductos, other.promocionesProductos)
				&& Objects.equals(promocionesTemporales, other.promocionesTemporales)
				&& Float.floatToIntBits(sueldo) == Float.floatToIntBits(other.sueldo)
				&& Objects.equals(zonaConfSistema, other.zonaConfSistema)
				&& Objects.equals(zonaFacturacion, other.zonaFacturacion)
				&& Objects.equals(zonaPersonal, other.zonaPersonal);
	}
}