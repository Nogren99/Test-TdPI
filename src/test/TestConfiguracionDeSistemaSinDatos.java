package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;

public class TestConfiguracionDeSistemaSinDatos {

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

	
	//Se testean los casos de ESCENARIO 2 de caja negra, para los metodos que tengan escenario 2
	@Test 
	public void testAltaProducto3() {

		try{
			config.altaProducto(234,null, 100, 400);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testAltaProducto4() {

		try{
			config.altaProducto(234,"Macchiato", -100, 400);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	@Test 
	public void testAltaProducto5() {

		try{
			config.altaProducto(234,"Macchiato", 100, -400);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testAltaProducto6() {

		try{
			config.altaProducto(234,"Macchiato", 1000, 4);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	//un caso para bajaProducto
	
	@Test
	public void testBajaProducto2() {
		
		try{
			Producto productoAEliminar = local.getProductos().get(0);
			config.bajaProductos(productoAEliminar);
			assertEquals("La lista aun contiene el elemento", local.getProductos().contains(productoAEliminar),productoAEliminar);
		}
		catch(Exception e) {
		}
		
		
	}
	
	//un caso para modifica producto stock
	
	@Test 
	public void testModificaProductoStockSinDato() {
		try {
			Producto productoMod=local.getProductos().get(0);
			config.modificaProducto(productoMod, "stock", 245);
			assertEquals("El stock no se modifico correctamente", productoMod.getStock(), 245);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	@Test 
	public void testModificaProductoNombreSinDato() {
		try {
			Producto productoMod=local.getProductos().get(0);
			config.modificaProducto(productoMod, "nombre", "CervezaAntares");
			assertEquals("El nombre del producto no se modifico correctamente", productoMod.getNombre(), "CervezaAntares");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
