package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mozo;
import capaDeNegocios.Local;

public class TestCajaBlancaConDatos {

	private Local local;
	private EscenarioConDatos E1 = new EscenarioConDatos();
	
	@Before
	public void setUp() throws Exception {
		this.E1.setUp();
		this.local=this.E1.getLocal();
	}

	@After
	public void tearDown() throws Exception {
		this.E1.tearDown();
	}

	@Test
	public void getMozoMaxVentasCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMaxVentas();
			Assert.assertEquals("El mozo no es el que tiene maximo en ventas",local.getMozos().get(0).getAcumulados(),(float)mozo.getAcumulados(),0);
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMaxVentasCamino_4() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(500);
			local.getMozos().get(1).setAcumulados(1000);
			mozo = local.getMozoMaxVentas();
			Assert.assertEquals("El mozo no es el que tiene maximo en ventas",local.getMozos().get(1).getAcumulados(),(float)mozo.getAcumulados(),0);
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMinVentasCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(500);
			local.getMozos().get(1).setAcumulados(1000);
			mozo = local.getMozoMinVentas();
			Assert.assertEquals("El mozo no es el que tiene minimo en ventas",local.getMozos().get(0).getAcumulados(),(float)mozo.getAcumulados(),0);
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMinVentasCamino_4() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMinVentas();
			Assert.assertEquals("El mozo no es el que tiene minimo en ventas",local.getMozos().get(1).getAcumulados(),(float)mozo.getAcumulados(),0);
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMaxPromedioCamino_2() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(1);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(4);
			mozo = local.getMozoMaxPromedio();
			Assert.assertEquals("El mozo no es el que tiene maximo promedio",mozo,local.getMozos().get(0));
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMaxPromedioCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(4);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(1);
			mozo = local.getMozoMaxPromedio();
			Assert.assertEquals("El mozo no es el que tiene maximo promedio",mozo,local.getMozos().get(1));
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	
	@Test
	public void getMozoMinPromedioCamino_2() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(4);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(1);
			mozo = local.getMozoMinPromedio();
			Assert.assertEquals("El mozo no es el que tiene minimo promedio",mozo,local.getMozos().get(0));
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}
	
	@Test
	public void getMozoMinPromedioCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(1);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(4);
			mozo = local.getMozoMinPromedio();
			Assert.assertEquals("El mozo no es el que tiene minimo promedio",mozo,local.getMozos().get(1));
		} catch (Exception e) {
			Assert.fail("No deberia lanzar Exception");
		}
	}

}
