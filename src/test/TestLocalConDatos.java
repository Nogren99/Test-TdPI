package test;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import capaDeDatos.AsignacionDiaria;
import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeNegocios.Local;

public class TestLocalConDatos {
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
	public void testgetComandaByMesaCaso1() {
		Mesa mesa1 = local.getMesas().get(0);
		try {
			Comanda comanda1 = local.getComandaByMesa(mesa1);
		}catch(Exception e) {
			Assert.fail("No deberia lanzar una excepcion");
		}
	}
	
	@Test
	public void testgetComandaByMesaCaso2() {
		Mesa mesa3 = new Mesa(3);
		try {
			Comanda comanda1 = local.getComandaByMesa(mesa3);
			Assert.fail("Deberia tirar una excepcion, la mesa no existe");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testgetMozoByMesaCaso1() {
		Mesa mesa = local.getMesas().get(0);
		try{
			Mozo mozo = local.getMozoByMesa(mesa);
			Assert.assertNotNull("Error mozo no deberia ser nulo", mozo);
			int i = 0;
			while(i < local.getAsignacionDiaria().size() && local.getAsignacionDiaria().get(i).getMozo().getId() != mozo.getId())
				i++;			
			Assert.assertEquals("Error la mesa deberia estar asignada al mozo", local.getAsignacionDiaria().get(i).getMesa(), mesa);
		}catch(Exception e) {
			Assert.fail("No deberia lanzar excepcion");
		}		
	}
	
	@Test
	public void testgetMozoByMesaCaso2() {
		Mesa mesaX = new Mesa(3);
		try {
			Mozo mozo = local.getMozoByMesa(mesaX);
			Assert.fail("No deberia seguir con la ejecucion, la mesa no existe");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testLoginCaso1() {
		try{
			local.login("ADMIN", "ADMIN1234");
			Assert.assertTrue("Error deberia encontrarse el administrador" , local.getAdmin());
		}catch(Exception e) {
			Assert.fail("No deberia lanzar excepcion");

		}		
	}
	
	@Test
	public void testLoginCaso2() {
		try{
			local.login("Lucas", "xaB1113");
			Assert.assertFalse("Error el operario ingresado no es el administrador" , local.getAdmin());
		}catch(Exception e) {
			Assert.fail("No deberia lanzar excepcion");
		}				
	}
	
	@Test
	public void testLoginCaso3() {
		try {
			local.login(null, "xaB1113");
			Assert.fail("No deberia continuar con la ejecucion.");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testLoginCaso5() {
		try {
			local.login("Lucas", null);
			Assert.fail("No deberia continuar con la ejecucion.");
		}catch(Exception e) {
			
		}
	}
	
}