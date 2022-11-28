package capaDeDatos;

public class RelacionMesaMozo {
	private Mesa mesa;
	private Mozo mozo;

	public RelacionMesaMozo(Mesa mesa, Mozo mozo) {
		super();
		this.mesa = mesa;
		this.mozo = mozo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

}
