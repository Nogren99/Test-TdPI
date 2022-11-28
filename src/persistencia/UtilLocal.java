package persistencia;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;

public class UtilLocal {

	public static void LocalFromLocalDTO(LocalDTO localDTO) {
		
		for (MesaDTO mesa :localDTO.getMesas())
			Local.getInstance().getMesas().add(MesaFromMesaDTO(mesa));
		for (MozoDTO mozo :localDTO.getMozos())
			Local.getInstance().getMozos().add(MozoFromMozoDTO(mozo));
		for (OperarioDTO operario :localDTO.getOperarios())
			Local.getInstance().getOperarios().add(OperarioFromOperarioDTO(operario));
		for (ProductoDTO producto :localDTO.getProductos())
			Local.getInstance().getProductos().add(ProductoFromProductoDTO(producto));
		for (PromocionProductoDTO promocionProducto:localDTO.getPromocionesProductos())
			Local.getInstance().getPromocionesProductos().add(PromocionProductoFromPromocionProductoDTO(promocionProducto));
		for (PromocionTemporalDTO promocionTemporal:localDTO.getPromocionesTemporales())
			Local.getInstance().getPromocionesTemporales().add(PromocionTemporalFromPromocionTemporalDTO(promocionTemporal));
		
	}

	public static LocalDTO LocalDTOFromLocal() {
		LocalDTO localDTO = new LocalDTO();
		for (Mesa mesa :Local.getInstance().getMesas())
			localDTO.getMesas().add(MesaDTOFromMesa(mesa));
		for (Mozo mozo :Local.getInstance().getMozos())
			localDTO.getMozos().add(MozoDTOFromMozo(mozo));
		for (Operario operario :Local.getInstance().getOperarios())
			localDTO.getOperarios().add(OperarioDTOFromOperario(operario));
		for (Producto producto :Local.getInstance().getProductos())
			localDTO.getProductos().add(ProductoDTOFromProducto(producto));
		for (PromocionProducto promocionProducto:Local.getInstance().getPromocionesProductos())
			localDTO.getPromocionesProductos().add(PromocionProductoDTOFromPromocionProducto(promocionProducto));
		for (PromocionTemporal promocionTemporal:Local.getInstance().getPromocionesTemporales())
			localDTO.getPromocionesTemporales().add(PromocionTemporalDTOFromPromocionTemporal(promocionTemporal));
		
		return localDTO;
	
	}
	
	public static Mesa MesaFromMesaDTO(MesaDTO mesaDTO) {
		Mesa mesa = new Mesa(mesaDTO.getId());
		mesa.setComensales(mesaDTO.getComensales());
		mesa.setEstado(mesaDTO.getEstado());
		return mesa;
		
	}

	public static MesaDTO MesaDTOFromMesa(Mesa mesa) {
		MesaDTO mesaDTO = new MesaDTO(mesa.getId());
		mesaDTO.setComensales(mesa.getComensales());
		mesaDTO.setEstado(mesa.getEstado());
		return mesaDTO;	
	
	}
	
	public static Mozo MozoFromMozoDTO(MozoDTO mozoDTO) {
		int id = mozoDTO.getId();
		String nombreApellido = mozoDTO.getNombreApellido();
		String nacimiento = mozoDTO.getNacimiento();
		int cantHijos = mozoDTO.getCantHijos();
		return new Mozo(id, nombreApellido, nacimiento, cantHijos);
	
		
	}

	public static MozoDTO MozoDTOFromMozo(Mozo mozo) {
		int id = mozo.getId();
		String nombreApellido = mozo.getNombreApellido();
		String nacimiento = mozo.getNacimiento();
		int cantHijos = mozo.getCantHijos();
		return new MozoDTO(id, nombreApellido, nacimiento, cantHijos);
	
	}
	
	public static Operario OperarioFromOperarioDTO(OperarioDTO operarioDTO) {
		int id = operarioDTO.getId();
		String nombreApellido = operarioDTO.getNombreApellido();
		String nacimiento = operarioDTO.getNacimiento();
		String nombreUsuario = operarioDTO.getNombreApellido();
		String password = operarioDTO.getPassword();
		return new Operario(id, nombreApellido, nacimiento, nombreUsuario, password);	
	
	}

	public static OperarioDTO OperarioDTOFromOperario(Operario operario) {
		int id = operario.getId();
		String nombreApellido = operario.getNombreApellido();
		String nacimiento = operario.getNacimiento();
		String nombreUsuario = operario.getNombreApellido();
		String password = operario.getPassword();
		return new OperarioDTO(id, nombreApellido, nacimiento, nombreUsuario, password);	
	
	}
	
	public static Producto ProductoFromProductoDTO(ProductoDTO productoDTO) {
		int id = productoDTO.getId();
		int stock = productoDTO.getStock();
		String nombre = productoDTO.getNombre();
		float precioCosto = productoDTO.getPrecioCosto();
		float precioVenta = productoDTO.getPrecioVenta();
		return new Producto(id, stock, nombre, precioCosto, precioVenta);
		
	}

	public static ProductoDTO ProductoDTOFromProducto(Producto producto) {
		int id = producto.getId();
		int stock = producto.getStock();
		String nombre = producto.getNombre();
		float precioCosto = producto.getPrecioCosto();
		float precioVenta = producto.getPrecioVenta();
		return new ProductoDTO(id, stock, nombre, precioCosto, precioVenta);	
	
	}
	public static PromocionProducto PromocionProductoFromPromocionProductoDTO(PromocionProductoDTO promocionProductoDTO) {
		Producto producto = ProductoFromProductoDTO(promocionProductoDTO.getProducto());
		String diaProm = promocionProductoDTO.getDiaProm();
		boolean dosXuno = promocionProductoDTO.isDosXuno();
		boolean descuentoCantMin = promocionProductoDTO.isDescuentoCantMin();
		int cantidadMinima = promocionProductoDTO.getCantidadMinima();
		float descCantMin = promocionProductoDTO.getCantidadMinima();
		boolean activa = promocionProductoDTO.isActiva();
		return new PromocionProducto(producto, diaProm, dosXuno, descuentoCantMin, cantidadMinima, descCantMin, activa);	
	
		
	}

	public static PromocionProductoDTO PromocionProductoDTOFromPromocionProducto(PromocionProducto promocionProducto) {
		ProductoDTO producto = ProductoDTOFromProducto(promocionProducto.getProducto());
		String diaProm = promocionProducto.getDiaProm();
		boolean dosXuno = promocionProducto.isDosXuno();
		boolean descuentoCantMin = promocionProducto.isDescuentoCantMin();
		int cantidadMinima = promocionProducto.getCantidadMinima();
		float descCantMin = promocionProducto.getCantidadMinima();
		boolean activa = promocionProducto.isActiva();
		return new PromocionProductoDTO(producto, diaProm, dosXuno, descuentoCantMin, cantidadMinima, descCantMin, activa);	
	
	}
	
	public static PromocionTemporal PromocionTemporalFromPromocionTemporalDTO(PromocionTemporalDTO promocionTemporalDTO) {
		String nombre = promocionTemporalDTO.getNombre();
		String formaPago = promocionTemporalDTO.getFormaPago();
		int porcentajeDesc = promocionTemporalDTO.getPorcentajeDesc();
		String diasDePromo = promocionTemporalDTO.getDiasDePromo();
		boolean activa = promocionTemporalDTO.isActiva();
		boolean acumulable = promocionTemporalDTO.isAcumulable();
		return new PromocionTemporal(nombre, formaPago, porcentajeDesc, diasDePromo, activa, acumulable);
	}

	public static PromocionTemporalDTO PromocionTemporalDTOFromPromocionTemporal(PromocionTemporal promocionTemporal) {
		
		String nombre = promocionTemporal.getNombre();
		String fomraPago = promocionTemporal.getFormaPago();
		String diasDePromo = promocionTemporal.getDiasDePromo();
		int porcentajeDesc = promocionTemporal.getPorcentajeDesc();
		boolean activa = promocionTemporal.isActiva();
		boolean acumulable = promocionTemporal.isAcumulable();
		return new PromocionTemporalDTO(nombre, fomraPago, porcentajeDesc, diasDePromo, activa, acumulable );	
	
	}
}
