package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mozo;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;

public class TestCajaBlancaSinDatos {

	private Local local;
	private EscenarioSinDatos E2 = new EscenarioSinDatos();
	ConfiguracionDeSistema config=ConfiguracionDeSistema.getInstance();

	@Before
	public void setUp() throws Exception {
		this.E2.setUp();
		this.local=this.E2.getLocal();
		
	}

	@After
	public void tearDown() throws Exception {
		this.E2.tearDown();
	}

	@Test
	public void getMozoMaxVentasCamino_2() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMaxVentas();
			assertNotNull("Mozo deberia retornar null",mozo);
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void getMozoMaxVentasCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMaxVentas();
			Assert.fail("no deberia poder ejecutarse");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void getMozoMaxVentasCamino_4() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(500);
			local.getMozos().get(1).setAcumulados(1000);
			mozo = local.getMozoMaxVentas();
			Assert.fail("no deberia poder ejecutarse");
		} catch (Exception e) {
		}
	}
	
	
	
	@Test
	public void getMozoMinVentasCamino_2() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMinVentas();
			assertNotNull("Mozo deberia retornar null",mozo);
		} catch (Exception e) {
			
		}
	}
	
	@Test
	public void getMozoMinVentasCamino_3() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(1).setAcumulados(500);
			mozo = local.getMozoMinVentas();
			Assert.fail("no deberia poder ejecutarse");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void getMozoMinVentasCamino_4() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(500);
			local.getMozos().get(1).setAcumulados(1000);
			mozo = local.getMozoMinVentas();
			Assert.fail("no deberia poder ejecutarse");
		} catch (Exception e) {
		}
	}


	@Test
	public void getMozoMaxPromedioCamino_1() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(1);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(4);
			mozo = local.getMozoMaxPromedio();
			assertNotNull("Mozo deberia retornar null",mozo);
		} catch (Exception e) {
		}
	}
	
	@Test
	public void getMozoMinPromedioCamino_1() {
		try {
			Mozo mozo;
			local.getMozos().get(0).setAcumulados(1000);
			local.getMozos().get(0).setMesasAtentidas(1);
			local.getMozos().get(1).setAcumulados(1000);
			local.getMozos().get(1).setMesasAtentidas(4);
			mozo = local.getMozoMinPromedio();
			assertNotNull("Mozo deberia retornar null",mozo);
		} catch (Exception e) {
		}
	}
}
