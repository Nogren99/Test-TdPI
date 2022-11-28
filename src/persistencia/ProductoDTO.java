package persistencia;

public class ProductoDTO {

	private int id;
	private int stock;
	private String nombre;
	private float precioCosto;
	private float precioVenta;

	public ProductoDTO(int id, int stock, String nombre, float precioCosto, float precioVenta) {
		super();
		this.id = id; // revisar
		this.stock = stock;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
	}

	public ProductoDTO() {
		super();
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioCosto() {
		return precioCosto;
	}

	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", stock=" + stock + ", nombre=" + nombre + ", precioCosto=" + precioCosto
				+ ", precioVenta=" + precioVenta + "]";
	}

}
