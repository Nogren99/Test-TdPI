package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;

public class TestGestionDePersonalSinDatos {

	private Local local;
	private EscenarioSinDatos E2 = new EscenarioSinDatos();
	GestionDePersonal gestion=GestionDePersonal.getInstance();

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
	public void testBajaOperarioSINDATOS() {
		try{
			Operario operarioAElim = local.getOperarios().get(0);
			gestion.bajaOperario(operarioAElim);
			assertEquals("La lista aun contiene el elemento", operarioAElim,local.getOperarios().get(0));
		}
		catch(Exception e) {
		}
		
	}
	
	@Test
	public void testModificaOperarioSINDATOS() {
		
		try {
			Operario operarioMod = local.getOperarios().get(0);
			String nuevoNombre="Gabriel";
			gestion.modificaOperario(operarioMod, "nombreApellido", nuevoNombre);
			
			Assert.assertEquals("El nombre no se modifico correctamente",nuevoNombre, operarioMod.getNombreApellido());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test 
	public void testBajaMozoSINDATOS() {
		try{
			Mozo mozoAElim = local.getMozos().get(0);
			gestion.bajaMozo(mozoAElim);
			assertEquals("La lista aun contiene el elemento", mozoAElim,local.getMozos().get(0));	
		}
		catch(Exception e) {
		}
		
	}
	
	@Test 
	public void testModificaMozoNombreSINDATOS() {
		try {
			Mozo mozoMod = local.getMozos().get(0);
			String nombreNuevo="Lionel Andres Messi";
			gestion.modificaMozo(mozoMod, "nombreApellido", nombreNuevo);
			
			assertEquals("El nombre no se modifico correctamente", mozoMod.getNombreApellido(), nombreNuevo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
