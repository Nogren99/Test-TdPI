package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Mesa;
import capaDeDatos.Producto;
import capaDeNegocios.ConfiguracionDeSistema;
import capaDeNegocios.Local;

public class TestConfiguracionDeSistemaConDatos {
	private Local local;
	private EscenarioConDatos E1 = new EscenarioConDatos();
	ConfiguracionDeSistema config=ConfiguracionDeSistema.getInstance();

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
	public void testAltaMesa() {
		try {
			System.out.println();
			config.altaMesa();
			int size= local.getMesas().size();
			int id1=local.getMesas().get(size-2).getId();
			int id2=local.getMesas().get(size-1).getId()-1;
			//System.out.println(a+"----"+b);
			assertEquals("El id no fue asignado correctamente",id1,id2);
			
		}catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testBajaMesaCaso1() {
		Mesa mesaBaja= local.getMesas().get(0);
		try{
			config.bajaMesa(mesaBaja);
			assertFalse("La lista aun contiene el elemento", local.getMesas().contains(mesaBaja));
		}
		catch(Exception e) {
			Assert.fail("No deberia lanzar excepcion");
		}
		
		
	}
	
	//modifica mesa:
	
	@Test 
	public void testModificaMesaComensales1() {
		try {
			//System.out.println(local.getMesas().get(1));
			config.modificaMesa(local.getMesas().get(1),"comensales",8);
			//System.out.println(local.getMesas().get(1));
			assertEquals("La cantidad de comensales de la mesa no se modifico correctamente",8,local.getMesas().get(1).getComensales());
		}catch(Exception e) {
			
		}
		
	}
	
	@Test 
	public void testModificaMesaComensales2() {

		try{
			config.modificaMesa(local.getMesas().get(0), "comensales", 1);
			assertEquals("La cantidad de comensales de la mesa no se modifico correctamente",1,local.getMesas().get(0).getComensales());
		}
		catch(Exception e) {
			
		}
	}
	
	
	@Test 
	public void testModificaMesaComensales3() {
		try{
			config.modificaMesa(local.getMesas().get(1),"PEPA", 1);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	@Test 
	public void testModificaMesaComensales4() {
		
		try{
			config.modificaMesa(null, "comensales", 2);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	@Test 
	public void testModificaMesaComensales5() {
		
		try{
			config.modificaMesa(local.getMesas().get(1), null, 8);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testModificaMesaComensales6() {

		try{
			config.modificaMesa(local.getMesas().get(1), "comensales", -1);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	//estado
	
	@Test 
	public void testModificaMesaEstado1() {
		try {
			config.modificaMesa(local.getMesas().get(1), "estado", "libre");
			assertEquals("El estado de la mesa no se modifico correctamente","libre",local.getMesas().get(1).getEstado());
		
		}catch(Exception e) {
			
		}
		
	}
	@Test 
	public void testModificaMesaEstado2() {
		try {
			config.modificaMesa(local.getMesas().get(1), "estado", "ocupada");
			assertEquals("El estado de la mesa no se modifico correctamente","ocupada",local.getMesas().get(1).getEstado());
		
		}catch(Exception e) {
			
		}
		
	}
	
	@Test 
	public void testModificaMesaEstado3() {
		try {
			config.modificaMesa(local.getMesas().get(1), "PEPA", "libre");
			Assert.fail("No deberia poder ejecutarse");
		}catch(Exception e) {
			
		}
		
	}
	
	@Test 
	public void testModificaMesaEstado4() {
		try{
			config.modificaMesa(local.getMesas().get(1), "estado", "PEPA");
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testModificaMesaEstado5() {
		try{
			config.modificaMesa(null, "estado", "libre");
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	@Test 
	public void testModificaMesaEstado6() {
		try{
			config.modificaMesa(local.getMesas().get(1), null, "libre");
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void testModificaMesaEstado7() {
		try{
			config.modificaMesa(local.getMesas().get(1), "estado", null);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	//altaProducto
	
	@Test 
	public void testAltaProducto1() {
		
		try {
			config.altaProducto(234,"Macchiato", 100, 400);

			int size=local.getProductos().size();
			assertEquals("La lista no contiene el elementado a agregar",local.getProductos().get(size-1).getNombre(),"Macchiato");
			assertEquals("El id no se genera correctamente", local.getProductos().get(size-1).getId(), 1);
			
		}catch(Exception e){
			
		}
	}
	
	@Test 
	public void testAltaProductoCaso2() {

		try{
			config.altaProducto(-2,"Macchiato", 100, 400);
			Assert.fail("No deberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	//4 casos restantes pero van al escenario 2
	
	//bajaProducto
	
	@Test
	public void testBajaProducto1() {
		Producto productoAEliminar = local.getProductos().get(0);
		try{
			config.bajaProductos(productoAEliminar);
			assertEquals("La lista aun contiene el elemento", local.getProductos().contains(productoAEliminar),productoAEliminar);
		}
		catch(Exception e) {
		}
		
		
	}
	

	@Test
	public void testBajaProductoCaso3() {
		try{
			config.bajaProductos(null);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	//nodificaProducto
	//
	
	
	@Test 
	public void testModificaProductoStockCaso1() {
		
		try {
			Producto productoMod=local.getProductos().get(1);
			config.modificaProducto(productoMod, "stock", 245);
			assertEquals("El stock no se modifico correctamente", productoMod.getStock(), 245);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	@Test 
	public void  testModificaProductoStockCaso2() {
		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod, "ASD", 245);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void  testModificaProductoStockCaso3() {
		try{
			config.modificaProducto(null,"stock", 245);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void  testModificaProductoStockCaso4() {
		Producto productoMod=local.getProductos().get(1);
		System.out.println(productoMod);
		try{
			config.modificaProducto(productoMod,null, 245);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	

	@Test 
	public void  testModificaProductoStockCaso5() {
		Producto productoMod=local.getProductos().get(1);
		System.out.println(productoMod);
		try{
			config.modificaProducto(productoMod,"stock", -245);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	//ahora vamos con nombre
	
	@Test 
	public void testModificaProductoNombreCaso1() {
		try {
			Producto productoMod=local.getProductos().get(1);
			config.modificaProducto(productoMod, "nombre", "CervezaAntares");
			assertEquals("El nombre del producto no se modifico correctamente", productoMod.getNombre(), "CervezaAntares");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	@Test 
	public void  testModificaProductoNombreCaso2() {
		Producto productoMod=local.getProductos().get(1);
		String nuevoNombre="CervezaAntares";
		try{
			config.modificaProducto(productoMod, "ASD", nuevoNombre);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	@Test 
	public void  testModificaProductoNombreCaso3() {
		String nuevoNombre="CervezaAntares";

		try{
			config.modificaProducto(null,"nombre", nuevoNombre);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void  testModificaProductoNombreCaso4() {
		String nuevoNombre="CervezaAntares";

		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod,null, nuevoNombre);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	

	@Test 
	public void  testModificaProductoNombreCaso5() {

		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod,"nombre", null);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	//precio costo y precio venta
	
	@Test 
	public void testModificaProductoPreciosCaso1() {
		Producto productoMod=local.getProductos().get(1);
		config.modificaProducto(productoMod, "precioCosto", (float)50);
		Assert.assertEquals("El precio de costo no se modifico correctamente",  productoMod.getPrecioCosto(), 50);
	}
	
	@Test 
	public void testModificaProductoPreciosCaso2() {
		Producto productoMod=local.getProductos().get(1);
		config.modificaProducto(productoMod, "precioVenta", (float)50);
		Assert.assertEquals("El precio de costo no se modifico correctamente",  productoMod.getPrecioVenta(), 50);
	}
	

	@Test 
	public void  testModificaProductoPreciosCaso3() {
		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod, "ASD", (float)50);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void  testModificaProductoPreciosCaso4() {
		try{
			config.modificaProducto(null,"precioCosto", (float)50);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	@Test 
	public void  testModificaProductoPreciosCaso5() {
		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod,"precioCosto", (float)0);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	

	@Test 
	public void  testModificaProductoPreciosCaso6() {
		Producto productoMod=local.getProductos().get(1);
		try{
			config.modificaProducto(productoMod,null, (float)50);
			Assert.fail("No deaberia poder ejecutarse");
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	

}
