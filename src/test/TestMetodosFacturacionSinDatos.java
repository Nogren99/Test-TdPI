package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.Factura;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;

public class TestMetodosFacturacionSinDatos {
	private MetodosFacturacion mf = MetodosFacturacion.getInstance();
	private Local local;
	
	@Before
	public void setUp() throws Exception {
		local = Local.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		Local.elimInstance();
	}

	@Test
	public void testAltaPromocionProductoCaso5() {
		try {
			mf.altaPromocionProducto(null,"Lunes", true, true, 6, 25, true);
			Assert.fail("El producto no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testBajaPromocionProductoCaso2() {
		try {
			mf.bajaPromocionProducto(null);			
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso5() {
		try {
			mf.altaPromocionTemporal("Promo Dia", null, 50, "Lunes", true, true);
			int i = 0;
			ArrayList<PromocionTemporal> promTemp = local.getPromocionesTemporales();
			while(i< promTemp.size() && !promTemp.get(i).getNombre().equals("Promo Dia") && !promTemp.get(i).getFormaPago().equals("null") 
					&& promTemp.get(i).getPorcentajeDesc() != 50 && !promTemp.get(i).getDiasDePromo().equals("Lunes") 
					&& promTemp.get(i).isActiva() != true && promTemp.get(i).isAcumulable() != true)
				i++;
			Assert.assertTrue("Se deberia haber agregado la promocion temporal.", i < promTemp.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso3(){
		try {
			mf.modificacionPromocionTemporal(new PromocionTemporal("Promocion365", "efectivo", 50, "Lunes", true, true), "Promocion365", "tarjeta", 60, "Jueves", true, true);
			Assert.fail("No deberia haberse encontrado la promocion");
		}catch(Exception e) {
			
		}
	}
	
}
