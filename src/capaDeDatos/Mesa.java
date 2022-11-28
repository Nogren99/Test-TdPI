package capaDeDatos;

public class Mesa {

	private int id = 0;
	private int comensales;
	private String estado; // revisar

	public Mesa(int id) {
		super();
		this.id = id; // revisar
		this.comensales = 0;
		this.estado = "Libre"; //"Libre", "Ocupada"
	}

	public int getId() {
		return id;
	}

	public int getComensales() {
		return comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", comensales=" + comensales + ", estado=" + estado + "]";
	}

	
	
}
