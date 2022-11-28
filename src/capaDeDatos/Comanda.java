package capaDeDatos;

import java.util.ArrayList;

public class Comanda {
private static int nroID=0;
private int iDComanda;
private Mesa mesa;
private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
private boolean estado;

public Comanda(Mesa mesa, Pedido pedido, boolean estado) {
	nroID++;
	this.iDComanda=nroID;
	this.mesa = mesa;
	this.listaPedidos.add(pedido);
	this.estado = estado;
}

public int getiDComanda() {
	return iDComanda;
}

public Mesa getMesa() {
	return mesa;
}
public void setMesa(Mesa mesa) {
	this.mesa = mesa;
}
public ArrayList<Pedido> getListaPedidos() {
	return listaPedidos;
}
public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
	this.listaPedidos = listaPedidos;
}

public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}


}
