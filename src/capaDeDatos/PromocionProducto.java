	package capaDeDatos;

public class PromocionProducto {
private static int nroProm=0;
private int iDPromProd;
private Producto producto;
private String diaProm;
private boolean dosXuno;
private boolean descuentoCantMin;
private int cantidadMinima;
private float porcentajeDescCantMin;
private boolean activa;

public PromocionProducto( Producto producto, String diaProm, boolean dosXuno, boolean descuentoCantMin, int cantidadMinima,
		float descCantMin, boolean activa) {
	nroProm++;
	this.iDPromProd = nroProm;
	this.producto = producto;
	this.diaProm = diaProm;
	this.dosXuno = dosXuno;
	this.descuentoCantMin = descuentoCantMin;
	this.cantidadMinima=cantidadMinima;
	this.porcentajeDescCantMin = descCantMin;
	this.activa = activa;
}

public int getCantidadMinima() {
	return cantidadMinima;
}

public void setCantidadMinima(int cantidadMinima) {
	this.cantidadMinima = cantidadMinima;
}

public int getiDProduc() {
	return iDPromProd;
}


public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}

public String getDiaProm() {
	return diaProm;
}

public void setDiaProm(String diaProm) {
	this.diaProm = diaProm;
}

public boolean isDosXuno() {
	return dosXuno;
}

public void setDosXuno(boolean dosXuno) {
	this.dosXuno = dosXuno;
}

public boolean isDescuentoCantMin() {
	return descuentoCantMin;
}

public void setDescuentoCantMin(boolean decCantMin) {
	this.descuentoCantMin = decCantMin;
}

public float getPorcentajeDescCantMin() {
	return porcentajeDescCantMin;
}

public void setPorcentajeDescCantMin(float decCantMin) {
	this.porcentajeDescCantMin = decCantMin;
}

public boolean isActiva() {
	return activa;
}

public void setActiva(boolean activa) {
	this.activa = activa;
}




}
