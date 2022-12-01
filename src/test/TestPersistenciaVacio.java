package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.AsignacionDiaria;
import capaDeDatos.Comanda;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;
import persistencia.PersistenciaXML;

public class TestPersistenciaVacio {
	private Local local;
	
	@Before
    public void setUp(){
        local = Local.getInstance();
        File archivo = new File("Local.xml");
        if (archivo.exists())
            archivo.delete();
    }

	@After
	public void tearDown() throws Exception {
		Local.elimInstance();
	}

	@Test
	public void testCrearPersistencia() {
		 try{
	            File archivo = new File("Local.xml");
	            local.cargarLocal("Local.xml");
	            Assert.assertTrue("Debería existir el archivo local.xml", archivo.exists());
	        }
	        catch (Exception e){
	            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
	        }
	}
	
	@Test
	public void testGuardarPersistencia() {
		 try{
	            File archivo = new File("Local.xml");
	            local.guardarLocal("Local.xml");
	            Assert.assertTrue("Debería existir el archivo local.xml", archivo.exists());    
	        }
	        catch (Exception e){
	            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
	        }
	}
	
	@Test
    public void testLocalVacio(){
        try{
        	Local local1= Local.getInstance();
        	local.cargarLocal("Local.xml");
        	local.guardarLocal("Local.xml");
        	Local localAux=Local.getInstance();
            Assert.assertEquals("Los archivos deberían ser distintos, uno vacio", local1,Local.getInstance()); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
    }
	
	@Test
	public void testLocalMesas() {
		try{
			Local local1= Local.getInstance();
			local.getMesas().add(new Mesa(6));
			local.getMesas().add(new Mesa(7));
        	local1.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux);  
        }
        catch (Exception e){
            Assert.fail("No debería lanzar excepcion: " + e.getMessage());
        }
	}
	
	@Test
	public void testLocalMozos() {
		try{
        	Local local1= Local.getInstance();
        	local.getMozos().add(new Mozo(3,"Lucas","07/05/1986",6));
    		local.getMozos().add(new Mozo(5,"Marcos","03/12/1993",7));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistió correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}

	@Test
	public void testLocalProductos() {
		try{
        	Local local1= Local.getInstance();
    		local.getProductos().add(new Producto(2,4, "Manaos", 10, 25));
    		local.getProductos().add(new Producto(5,15, "Pitusas", 20, 25));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}

	@Test
	public void testLocalOperarios() {
		try{
        	Local local1= Local.getInstance();
    		local.getOperarios().add(new Operario(3,"Lucas","07/05/1986", "LucasCARP", "LucasCARP"));
    		local.getOperarios().add(new Operario(4,"Marcos","03/12/1993", "LucassARP", "LucasCARP"));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}
	
	@Test
	public void testLocalComandas() {
		try{
        	Local local1= Local.getInstance();
    		local.getComandas().add(new Comanda(new Mesa(1), new Pedido("Lunes", 2, new Producto(2,4, "Manaos", 10, 25)), true));
    		local.getComandas().add(new Comanda(new Mesa(2), new Pedido("Viernes", 2, new Producto(5,15, "Pitusas", 20, 25)), true));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}
	
	@Test
	public void testLocalPromocionTemporal() {
		try{
        	Local local1= Local.getInstance();
    		local.getPromocionesTemporales().add(new PromocionTemporal("Promo1", "efectivo", 40, "Lunes", true, true));
    		local.getPromocionesTemporales().add(new PromocionTemporal("Promo2", "ctaDNI", 30, "Lunes", true, true));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}
		
	@Test
	public void testLocalPromocionProducto() {
		try{
        	Local local1= Local.getInstance();
        	local.getPromocionesProductos().add(new PromocionProducto(new Producto(2,4, "Manaos", 10, 25), "Miercoles", true, true, 2, 50, true));
    		local.getPromocionesProductos().add(new PromocionProducto(new Producto(5,15, "Pitusas", 20, 25), "Miercoles", true, true, 2, 50, true));
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local localAux=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,localAux); 
        }
        catch (Exception e){
            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
        }
	}
	
}
