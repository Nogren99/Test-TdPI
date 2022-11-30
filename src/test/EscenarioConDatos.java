package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mesa;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;

public class EscenarioConDatos {
	Local local = Local.getInstance();
	
	public Local getLocal() {
		return local;
	}

	@Before
	public void setUp() throws Exception {
		local=Local.getInstance();
		Mesa mesa1= new Mesa(0);
		Mesa mesa2= new Mesa(2);
		Producto producto=new Producto(0,255,"Agua Mineral", 50, 250);
		Producto producto2=new Producto(1,300,"Cerveza Quilmes",49,500);
		local.getMesas().add(mesa1);
		local.getMesas().add(mesa2);
		local.getProductos().add(producto);
		local.getProductos().add(producto2);
		//ConfiguracionDeSistema config=ConfiguracionDeSistema.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		local.getMesas().clear();
		local.getOperarios().clear();
		local.getProductos().clear();
		local.getMozos().clear();
	}



}
