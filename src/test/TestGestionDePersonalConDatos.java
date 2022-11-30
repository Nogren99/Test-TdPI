package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.GestionDePersonal;
import capaDeNegocios.Local;

public class TestGestionDePersonalConDatos {

	private Local local;
	private EscenarioConDatos E1 = new EscenarioConDatos();
	GestionDePersonal gestion=GestionDePersonal.getInstance();

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
	public void testAltaOperariocaso1() {
		try {
			gestion.altaOperario("Juan","19/12/1995","Juan8","Promocion2022");
			assertEquals("No se dio el alta", local.getOperarios().get(1).getNombreUsuario(),"Juan8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test 
	public void testAltaOperariocaso2() {
		try{
			gestion.altaOperario(null, "19/12/1995","Juan8","Promocion2022");
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
			
		}
		
	}
	
	@Test 
	public void testAltaOperariocaso3() {
		try{
			gestion.altaOperario("Juan", null,"Juan8","Promocion2022");
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
		}
	}
	
	@Test 
	public void testAltaOperariocaso4() {
		try{
			gestion.altaOperario("Juan","19/12/1995",null,"Promocion2022");
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
		}
	}
	@Test 
	public void testAltaOperariocaso5() {
		try{
			gestion.altaOperario("Juan","19/12/1995","Juan8",null);
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
		}
	}
	
	@Test 
	public void testAltaOperariocaso6() {
		try{
			gestion.altaOperario("Juan","19/12/1995","Juan8","a");
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
		}
	}
	
	//bajaOp	
	
	@Test
	public void testBajaOperarioCaso1() {
		try{
			Operario operarioAElim = local.getOperarios().get(0);
			gestion.bajaOperario(operarioAElim);
			assertEquals("La lista aun contiene el elemento", operarioAElim,local.getOperarios().get(0));
		}
		catch(Exception e) {
		}
		
	}
	


	@Test
	public void testBajaOperarioCaso3() {
		try{
			gestion.bajaOperario(null);
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
			
		}
	}
	
	//modifica OPERARIO
	
	@Test
	public void testModificaOperarioCaso1() {
		Operario operarioMod = local.getOperarios().get(0);
		String nuevoNombre="Gabriel";
		gestion.modificaOperario(operarioMod, "nombreApellido", nuevoNombre);
		
		Assert.assertEquals("El nombre no se modifico correctamente",nuevoNombre, operarioMod.getNombreApellido());
	}
	
	@Test
	public void testModificaOperarioCaso2() {
		Operario operarioMod = local.getOperarios().get(0);
		String nuevoNaci="19/12/2021";
		gestion.modificaOperario(operarioMod, "nacimiento", nuevoNaci);
		
		Assert.assertEquals("El nacimiento no se modifico correctamente",nuevoNaci, operarioMod.getNombreApellido());
	}
	@Test
	public void testModificaOperarioCaso3() {
		Operario operarioMod = local.getOperarios().get(0);
		String nuevoNombreUsuario="juan10";
		gestion.modificaOperario(operarioMod, "nombreUsuario", nuevoNombreUsuario);
		
		Assert.assertEquals("El nombre de usuario no se modifico correctamente",nuevoNombreUsuario, operarioMod.getNombreUsuario());
	}
	@Test
	public void testModificaOperarioCaso4() {
		Operario operarioMod = local.getOperarios().get(0);
		String nuevoPassword="Gabriel2022";
		gestion.modificaOperario(operarioMod, "password", nuevoPassword);
		
		Assert.assertEquals("El pass no se modifico correctamente",nuevoPassword, operarioMod.getPassword());
	}
	
	@Test
	public void testModificaOperarioCaso5() {
		Operario operarioMod = local.getOperarios().get(0);
		String nuevoPassword="Gabriel";
		try {
			gestion.modificaOperario(operarioMod, "password", nuevoPassword);
			Assert.fail("El password no cumple .No deberia poder ejecutarse");
			
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificaOperarioCaso6() {
		String nuevoNombre="Gabriel";
		try {
			gestion.modificaOperario(null, "nombreApellido", nuevoNombre);
			Assert.fail("No deberia seguir con la ejecucion");
			
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificaOperarioCaso007() {
		Operario operarioMod = local.getOperarios().get(0);
		try {
			gestion.modificaOperario(operarioMod, "nombreApellido", null);
			Assert.fail("No deberia seguir con la ejecucion");
			
		}
		catch(Exception e) {
			
		}
	}
	
	

	//MOZOS
	//altaMOZO
	
	@Test
	public void testAltaMozoCaso1() {

		try {
			gestion.altaMozo("Lionel Messi","24/06/1987",3);
			int size = local.getMozos().size();
			assertEquals("La lista no contiene el elementado a agregar", local.getMozos().get(size-1).getNombreApellido(),"Lionel Messi");
			assertEquals("El id no se genera correctamente", local.getMozos().get(size-1).getId(), 1);
			
		} catch (Exception e) {
			// TODO: handle exception
	}
		
		
		
		
	}
	
	@Test
	public void testAltaMozoCaso2() {
		try {
			gestion.altaMozo(null, "24/06/1987",3);
			Assert.fail("No deberia seguir con la ejecucion");
			
		}
		catch(Exception e) {
			
		}
	}
	@Test
	public void testAltaMozoCaso3() {
		
		
		try {
			gestion.altaMozo("Lionel Messi",null,3);
			Assert.fail("No deberia seguir con la ejecucion");
			
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaMozoCaso4() {
		
		
		try {
			gestion.altaMozo("Lionel Messi","24/06/2022",3);
			Assert.fail("No deberia seguir con la ejecucion, edad erronea");
			
		}
		catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaMozoCaso5() {
		
		
		try {
			gestion.altaMozo("Lionel Messi","24/06/2022",-3);
			Assert.fail("No deberia seguir con la ejecucion,hijos negativos");
			
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	//bajaMozo
	
	@Test 
	public void testBajaMozoCaso1() {
		try{
			Mozo mozoAElim = local.getMozos().get(0);
			gestion.bajaMozo(mozoAElim);
			assertEquals("La lista aun contiene el elemento", mozoAElim,local.getMozos().get(0));	
		}
		catch(Exception e) {
		}
		
	}
	
	@Test 
	public void testBajaMozoCaso2() {
		try{
			gestion.bajaMozo(null);
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
			
		}
	}
	
	
	//modificaMozo
	
	@Test 
	public void testModificaMozoNombreYEstadosCaso1() {
		Mozo mozoMod = local.getMozos().get(0);
		String nombreNuevo="Lionel Andres Messi";
		gestion.modificaMozo(mozoMod, "nombreApellido", nombreNuevo);
		
		assertEquals("El nombre no se modifico correctamente", mozoMod.getNombreApellido(), nombreNuevo);
	}
	
	@Test 
	public void testModificaMozoNombreYEstadosCaso2() {
		Mozo mozoMod = local.getMozos().get(0);
		String estadoNuevo="activo";
		gestion.modificaMozo(mozoMod, "estado", estadoNuevo);
		
		assertEquals("El estado no se modifico correctamente", mozoMod.getEstado(), estadoNuevo);
	}
	
	@Test 
	public void testModificaMozoNombreYEstadosCaso3() {
		String estadoNuevo="a";
		Mozo mozoMod = local.getMozos().get(0);
		try{
			gestion.modificaMozo(mozoMod, "estado", estadoNuevo);
			Assert.fail("No deberia seguir con la ejecucion, estado no existe");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testModificaMozoNombreYEstadosCaso4() {
		String nombreNuevo="Lionel Andres Messi";
		try{
			gestion.modificaMozo(null, "nombreApellido", nombreNuevo);
			Assert.fail("No deberia seguir con la ejecucion");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testModificaMozoNombreYEstadosCaso5() {
		Mozo mozoMod = local.getMozos().get(0);
		try{
			gestion.modificaMozo(mozoMod, "estado", null);
			Assert.fail("No deberia seguir con la ejecucion, estado no existe");
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
