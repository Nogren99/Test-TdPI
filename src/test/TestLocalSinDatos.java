package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeNegocios.Local;

public class TestLocalSinDatos {
	private Local local;
	private EscenarioSinDatos E2 = new EscenarioSinDatos();

	@Before
	public void setUp() throws Exception {
		//this.local = Local.getInstance();	
		this.E2.setUp();
		this.local=this.E2.getLocal();
	}

	@After
	public void tearDown() throws Exception {
		this.E2.tearDown();
	}

	@Test
	public void testgetComandaByMesaCaso3() {
		Mesa mesa = new Mesa(1);
		try {
			Comanda comanda1 = local.getComandaByMesa(mesa);
			Assert.fail("Deberia tirar una excepcion, la comanda no existe");
		}catch(Exception e) {	
			
		}
	}
	
	@Test
	public void testgetMozoByMesaCaso3() {
		Mesa mesa = new Mesa(1);
		try {
			Mozo mozo = local.getMozoByMesa(mesa);
			Assert.fail("Deberia tirar una excepcion, la coleccion de mozos esta vacia");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testLoginCaso4() {
		try {
			local.login("Meolans", "QWERTY1234");
			Assert.fail("Deberia tirar una excepcion, el operario no existe");
		}catch(Exception e) {
			
		}
	}
	
}
