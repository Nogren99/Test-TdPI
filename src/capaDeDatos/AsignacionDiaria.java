package capaDeDatos;

public class AsignacionDiaria {
	private Mozo mozo;
	private Mesa mesa;
	
	
	
	public AsignacionDiaria(Mozo mozo, Mesa mesa) {
		super();
		this.mozo = mozo;
		this.mesa = mesa;
	}
	public Mozo getMozo() {
		return mozo;
	}
	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	
	
}
