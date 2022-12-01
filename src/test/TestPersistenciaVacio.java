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
	public void testCrearPersistencia() {
		 try{
	            File archivo = new File("Local.xml");
	            local.cargarLocal("Local.xml");
	            Assert.assertTrue("Debería existir el archivo local.xml", archivo.exists());
	        }
	        catch (Exception e) {
	            Assert.fail("No debería lanzar una excepcion: " + e.getMessage());
	        }
	}
	
	@Test
	public void testLocalConMesas() {
		try{
			Local local1= Local.getInstance();
        	agregarMesas(local1);
        	local1.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2);  
        }
        catch (Exception e)
        {
            Assert.fail("No debería lanzar excepcion: " + e.getMessage());
        }
	}
	
	private void agregarMesas(Local local) {
		local.getMesas().add(new Mesa(3));
		local.getMesas().add(new Mesa(4));
		local.getMesas().add(new Mesa(5));
	}
	
	@Test
	public void testLocalConMozos() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarMozos(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarMozos(Local local) {
		local.getMozos().add(new Mozo(3,"Nahuel","13/10/1998",3));
		local.getMozos().add(new Mozo(5,"Nahu","13/10/1998",4));
		local.getMozos().add(new Mozo(4,"Nahue","13/10/1998",5));
		
	}
	
	@Test
	public void testLocalConProductos() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarProductos(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarProductos(Local local) {
		local.getProductos().add(new Producto(3,10, "Pepeya", 400, 500));
		local.getProductos().add(new Producto(4,10, "Coca cola", 400, 500));
		local.getProductos().add(new Producto(5,10, "Pepsi", 400, 500));
		
	}
	
	@Test
	public void testLocalConOperarios() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarOperarios(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarOperarios(Local local) {
		local.getOperarios().add(new Operario(3,"Nahuel","13/10/1998", "Nahuel03", "Nahuel03"));
		local.getOperarios().add(new Operario(4,"Imanol","13/10/1998", "Nahue03", "Nahuel03"));
		local.getOperarios().add(new Operario(5,"Juan","13/10/1998", "Nahu03", "Nahuel03"));
	}
	

	@Test
	public void testLocalConComandas() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarComandas(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarComandas(Local local) {
		local.getComandas().add(new Comanda(new Mesa(1), new Pedido("Jueves", 2, new Producto(3,10, "Pepeya", 400, 500)), true));
		local.getComandas().add(new Comanda(new Mesa(2), new Pedido("Viernes", 2, new Producto(4,10, "Coca cola", 400, 500)), true));
		local.getComandas().add(new Comanda(new Mesa(3), new Pedido("Domingo", 2, new Producto(5,10, "Pepsi", 400, 500)), true));
		
	}
	
	@Test
	public void testLocalConPromocionTemporal() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarPromocionTemporal(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarPromocionTemporal(Local local) {
		local.getPromocionesTemporales().add(new PromocionTemporal("Promocion1", "ctaDNI", 40, "Jueves", true, true));
		local.getPromocionesTemporales().add(new PromocionTemporal("Promocion2", "ctaDNI", 40, "Jueves", true, true));
		local.getPromocionesTemporales().add(new PromocionTemporal("Promocion3", "ctaDNI", 40, "Jueves", true, true));
		
	}
	
	@Test
	public void testLocalConPromocionProducto() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarPromocionProducto(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarPromocionProducto(Local local) {
		local.getPromocionesProductos().add(new PromocionProducto(new Producto(3,10, "Pepeya", 400, 500), "Martes", true, true, 2, 50, true));
		local.getPromocionesProductos().add(new PromocionProducto(new Producto(4,10, "Coca cola", 400, 500), "Martes", true, true, 2, 50, true));
		local.getPromocionesProductos().add(new PromocionProducto(new Producto(5,10, "Pepsi", 400, 500), "Martes", true, true, 2, 50, true));
		
	}
	@Test
	public void testLocalConAsignacionDiaria() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarAsignacionDiaria(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	private void agregarAsignacionDiaria(Local local) {
		local.getAsignacionDiaria().add(new AsignacionDiaria(new Mozo(3,"Nahuel","13/10/1998",3),new Mesa(1)));
		local.getAsignacionDiaria().add(new AsignacionDiaria(new Mozo(3,"Nahu","13/10/1998",3),new Mesa(2)));
		local.getAsignacionDiaria().add(new AsignacionDiaria(new Mozo(3,"Nahue","13/10/1998",3),new Mesa(3)));
		
	}
	
	@Test
	public void testLocalConFormasDePago() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarFormasDePago(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	
	private void agregarFormasDePago(Local local) {
		local.getFormasDePago().add("CuentaDni");
		local.getFormasDePago().add("MercadoPago");
		local.getFormasDePago().add("Tarjeta");
		
	}
	
	@Test
	public void testLocalConNombreLocal() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarNombreLocal(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	
	private void agregarNombreLocal(Local local) {
		local.setNombreLocal("Carre4");
	}
	
	@Test
	public void testLocalConSueldo() {
		try
        {
        	Local local1= Local.getInstance();
        	agregarSueldo(local1);
        	local.guardarLocal("Local.xml");
        	Local.elimInstance();
        	Local local2=Local.getInstance();
        	local.cargarLocal("Local.xml");
            Assert.assertEquals("El local no se persistio correctamente", local1,local2); 
        }
        catch (Exception e)
        {
            Assert.fail("No deberÃ­a lanzar excepcion: " + e.getMessage());
        }
	}
	
	private void agregarSueldo(Local local) {
		local.setSueldo(1500);
	}
	
	

}
