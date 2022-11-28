package capaDeDatos;

import java.util.Calendar;


public class Pedido {
private static int nroID=0;
private int iDPedido;
private String fecha;
private int cantidad;
private Producto producto;

public Pedido(String fecha, int cantidad, Producto producto) {
	nroID++;
	this.iDPedido=nroID;
	this.fecha = fecha;
	this.cantidad = cantidad;
	this.producto = producto;
}

public int getiDPedido() {
	return iDPedido;
}


public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public Producto getProducto() {
	return producto;
}

public void setProducto(Producto producto) {
	this.producto = producto;
}

}
