package capaDeDatos;

public class PromocionTemporal {
private static int nroID;
private int iDPromTemp;
private String nombre;
private String formaPago;
private int porcentajeDesc;
private String diasDePromo;
private boolean activa;
private boolean acumulable;

public PromocionTemporal(String nombre, String formaPago, int porcentajeDesc, String diasDePromo, boolean activa,
		boolean acumulable) {
	nroID++;
	this.iDPromTemp=nroID;
	this.nombre = nombre;	
	this.formaPago = formaPago;
	this.porcentajeDesc = porcentajeDesc;
	this.diasDePromo = diasDePromo;
	this.activa = activa;
	this.acumulable = acumulable;
}
public int getiDPromTemp() {
	return iDPromTemp;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getFormaPago() {
	return formaPago;
}
public void setFormaPago(String formaPago) {
	this.formaPago = formaPago;
}
public int getPorcentajeDesc() {
	return porcentajeDesc;
}
public void setPorcentajeDesc(int porcentajeDesc) {
	this.porcentajeDesc = porcentajeDesc;
}
public String getDiasDePromo() {
	return diasDePromo;
}
public void setDiasDePromo(String diasDePromo) {
	this.diasDePromo = diasDePromo;
}
public boolean isActiva() {
	return activa;
}
public void setActiva(boolean activa) {
	this.activa = activa;
}
public boolean isAcumulable() {
	return acumulable;
}
public void setAcumulable(boolean acumulable) {
	this.acumulable = acumulable;
}



}
