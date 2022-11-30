package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
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
		Operario operario=new Operario(0, "Jose", "22/06/1978", "Meolans", "QWERTY1234");
		Mozo mozo = new Mozo(0, "Walter White", "07/09/1958", 1);
		local.getMesas().add(mesa1);
		local.getMesas().add(mesa2);
		local.getProductos().add(producto);
		local.getProductos().add(producto2);
		local.getOperarios().add(operario);
		local.getMozos().add(mozo);
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
