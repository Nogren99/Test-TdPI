package test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import capaDeDatos.AsignacionDiaria;
import capaDeDatos.Comanda;
import capaDeDatos.Factura;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.Pedido;
import capaDeDatos.Producto;
import capaDeDatos.PromocionProducto;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;
import capaDeNegocios.MetodosFacturacion;

public class TestMetodosFacturacionConDatos {
	private MetodosFacturacion mf = MetodosFacturacion.getInstance();
	private Local local;
	private PromocionProducto promocionProducto1;
	private PromocionTemporal promocionTemporal1;
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
	public void testAltaPromocionProductoCaso1() {
		try {
			mf.altaPromocionProducto(local.getProductos().get(0),"Lunes", true, true, 6, 25, true);
			int i = 0;
			ArrayList<PromocionProducto> promProd = local.getPromocionesProductos();
			while(i< promProd.size() && promProd.get(i).getProducto() != local.getProductos().get(0) && !promProd.get(i).getDiaProm().equals("Lunes") && 
					promProd.get(i).isDosXuno() != true && promProd.get(i).isDescuentoCantMin() != true && promProd.get(i).getCantidadMinima() != 6
					&& promProd.get(i).getPorcentajeDescCantMin() != (float) 25 && promProd.get(i).isActiva() != true) {
				i++;
			}
			Assert.assertTrue("Se deberia haber agregado la promocion producto", i < promProd.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso2() {
		try {
			mf.altaPromocionProducto(local.getProductos().get(0),"Lunes", true, false, 6, 25, true);
			int i = 0;
			ArrayList<PromocionProducto> promProd = local.getPromocionesProductos();
			while(i< promProd.size() && promProd.get(i).getProducto() != local.getProductos().get(0) && !promProd.get(i).getDiaProm().equals("Lunes") && 
					promProd.get(i).isDosXuno() != true && promProd.get(i).isDescuentoCantMin() != false && promProd.get(i).getCantidadMinima() != 6
					&& promProd.get(i).getPorcentajeDescCantMin() != (float) 25 && promProd.get(i).isActiva() != true) {
				i++;
			}
			Assert.assertTrue("Se deberia haber agregado la promocion producto", i < promProd.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso3() {
		try {
			mf.altaPromocionProducto(local.getProductos().get(0),"Lunes", false, true, 6, 25, true);
			int i = 0;
			ArrayList<PromocionProducto> promProd = local.getPromocionesProductos();
			while(i< promProd.size() && promProd.get(i).getProducto() != local.getProductos().get(0) && !promProd.get(i).getDiaProm().equals("Lunes") && 
					promProd.get(i).isDosXuno() != false && promProd.get(i).isDescuentoCantMin() != true && promProd.get(i).getCantidadMinima() != 6
					&& promProd.get(i).getPorcentajeDescCantMin() != (float) 25 && promProd.get(i).isActiva() != true) {
				i++;
			}
			Assert.assertTrue("Se deberia haber agregado la promocion producto", i < promProd.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso4() {
		try {
			mf.altaPromocionProducto(local.getProductos().get(0),"Lunes", true, true, 6, 25, false);
			int i = 0;
			ArrayList<PromocionProducto> promProd = local.getPromocionesProductos();
			while(i< promProd.size() && promProd.get(i).getProducto() != local.getProductos().get(0) && !promProd.get(i).getDiaProm().equals("Lunes") && 
					promProd.get(i).isDosXuno() != true && promProd.get(i).isDescuentoCantMin() != true && promProd.get(i).getCantidadMinima() != 6
					&& promProd.get(i).getPorcentajeDescCantMin() != (float) 25 && promProd.get(i).isActiva() != false) {
				i++;
			}
			Assert.assertTrue("Se deberia haber agregado la promocion producto", i < promProd.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso5() {
		try {
			mf.altaPromocionProducto(null,"Lunes", true, true, 6, 25, true);
			Assert.fail("El producto no deberia ser nullo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso6() {
		try {
			mf.altaPromocionProducto(new Producto(4, 8, "Pollo", 10, 25),"LuneZ", true, true, 6, 25, true);
			Assert.fail("El dia de la semana deberia existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso7() {
		try {
			mf.altaPromocionProducto(new Producto(4, 8, "Pollo", 10, 25),null, true, true, 6, 25, true);
			Assert.fail("El dia de la semana no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionProductoCaso8() {
		try {
			mf.altaPromocionProducto(local.getProductos().get(0), "Lunes", true, true, -999, -25, true);
			Assert.fail("La cantidad minima no deberia ser <= 0");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testBajaPromocionProductoCaso1() {
		try {
			mf.bajaPromocionProducto(local.getPromocionesProductos().get(0));
			int i = 0;
			ArrayList<PromocionProducto> promProd = local.getPromocionesProductos();
			while(i< promProd.size() && promocionProducto1 != promProd.get(i))
				i++;
			Assert.assertTrue("Se deberia haber eliminado la promocion producto.", i >= promProd.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
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
	public void testModificacionPromocionProductoCaso1() {
		try {
			String str = promocionProducto1.getDiaProm();
			mf.modificacionPromocionProducto(promocionProducto1, "Lunes", true, true, 6, 25, true);
			Assert.assertNotEquals("Se deberia haber cambiado el dia de la promocion", str, local.getPromocionesProductos().get(0).getDiaProm());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testModificacionPromocionProductoCaso2() {
		try {
			Boolean bool = promocionProducto1.isDosXuno();
			mf.modificacionPromocionProducto(promocionProducto1, "Lunes", false, false, 6, 25, true);
			Assert.assertNotEquals("Se deberia haber cambiado el dia de la promocion", bool, local.getPromocionesProductos().get(0).isDosXuno());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testModificacionPromocionProductoCaso3(){
		try {
			Boolean pre = promocionProducto1.isActiva();
			mf.modificacionPromocionProducto(null, "Lunes", false, true, 6, 25, true);
			Assert.assertNotEquals("Promocion producto no deberia ser nulo", pre, local.getPromocionesProductos().get(0).isActiva());
		}catch(Exception e) {

		}
	}
	
	@Test
	public void testModificacionPromocionProductoCaso4(){
		try {
			Boolean bool = promocionProducto1.isDescuentoCantMin();
			mf.modificacionPromocionProducto(promocionProducto1, "LuneZ", false, false, 6, 25, false);
			Assert.assertNotEquals("El dia de la semana deberia ser valido", bool, local.getPromocionesProductos().get(0).isDescuentoCantMin());
		}catch(Exception e) {

		}
	}
	

	
	@Test
	public void testModificacionPromocionProductoCaso5(){
		try {
			mf.modificacionPromocionProducto(promocionProducto1, "Lunes", true, true, -999, 25, false);
			Assert.fail("Porcentaje cantidada minima no deberia ser <= 0");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso1() {
		try {
			mf.altaPromocionTemporal("Gran promo", "efectivo", 30, "Martes", true, true);
			
			int i = 0;
			ArrayList<PromocionTemporal> promTemp = local.getPromocionesTemporales();
			
			while(i< promTemp.size() && !promTemp.get(i).getNombre().equals("Gran promo") && !promTemp.get(i).getFormaPago().equals("efectivo") 
					&& promTemp.get(i).getPorcentajeDesc() != 30 && !promTemp.get(i).getDiasDePromo().equals("Martes") 
					&& promTemp.get(i).isActiva() != true && promTemp.get(i).isAcumulable() != true)
				i++;
			
			Assert.assertTrue("Se deberia haber agregado la promocion temporal", i < promTemp.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso2() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "efectivo", 50, "Lunes", false, false);
			int i = 0;
			ArrayList<PromocionTemporal> promTemp = local.getPromocionesTemporales();
			while(i< promTemp.size() && !promTemp.get(i).getNombre().equals("Promo Dia") && !promTemp.get(i).getFormaPago().equals("efectivo") 
					&& promTemp.get(i).getPorcentajeDesc() != 50 && !promTemp.get(i).getDiasDePromo().equals("Lunes") 
					&& promTemp.get(i).isActiva() != false && promTemp.get(i).isAcumulable() != false)
				i++;
			Assert.assertTrue("Se deberia haber agregado la promocion temporal", i < promTemp.size());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso3() {
		try {
			mf.altaPromocionTemporal(null, "efectivo", 50, "Lunes", true, true);
			Assert.fail("El nombre de la promocion no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso4() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "Bitcoin", 50, "Lunes", true, true);
			Assert.fail("El tipo de pago deberia existir");
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}	
	
	@Test
	public void testAltaPromocionTemporalCaso6() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "efectivo", -999, "LuneZ", true, true);
			Assert.fail("El porcentaje de descuento deberia ser >= 0");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso7() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "efectivo", 50, "LuneZ", true, true);
			Assert.fail("El dia deberia existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso8() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "efectivo", -1000, "Lunes", true, true);
			Assert.fail("No deberia seguir con la ejecucion.");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPromocionTemporalCaso9() {
		try {
			mf.altaPromocionTemporal("Promo Dia", "efectivo", 30, null , true, true);
			Assert.fail("El dia no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testBajaPromocionTemporalCaso1() {
		try {
			mf.bajaPromocionProducto(local.getPromocionesProductos().get(0));
			int i = 0;
			ArrayList<PromocionTemporal> promTemps = local.getPromocionesTemporales();
			while(i< promTemps.size() && promocionTemporal1 != promTemps.get(i)) 
				i++;
			Assert.assertTrue("Se deberia haber eliminado la promocion producto.", i >= promTemps.size());
		}catch(Exception e) {
			Assert.fail("No deberia haber lanzado excepcion.");
		}
	}
	
	@Test
	public void testBajaPromocionTemporalCaso2() {
		try {
			mf.bajaPromocionProducto(null);
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	@Test
	public void testBajaPromocionTemporalCaso3() {
		try {
			mf.bajaPromocionTemporal(new PromocionTemporal("Prma", "efectivo", 30, "Jueves", false, true));
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado una excepcion");
		}
	}
	
	
	@Test
	public void testModificacionPromocionTemporalCaso1() {
		try {
			String Str = promocionTemporal1.getNombre();
			int Int = promocionTemporal1.getPorcentajeDesc();
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promo Dia", "efectivo", 50, "Lunes", true, true);
			Assert.assertNotEquals("Deberia haberse cambiado el nombre de la promocion", Str, local.getPromocionesTemporales().get(0).getNombre());
			Assert.assertNotEquals("Deberia haberse cambiado el porcentaje de la promocion", Int, local.getPromocionesTemporales().get(0).getPorcentajeDesc());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado excepcion");
		}
	}

	@Test
	public void testModificacionPromocionTemporalCaso2() {
		try {
			Boolean bool = promocionTemporal1.isActiva();
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promo Dia", "efectivo", 50, "Lunes", false, false);
			Assert.assertNotEquals("Deberia haberse cambiado la promocion", bool, local.getPromocionesTemporales().get(0).isActiva());
		}catch(Exception e) {
			Assert.fail("No deberia haberse lanzado excepcion");
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso3(){
		try {
			mf.modificacionPromocionTemporal(null, "Promo Dia", "efectivo", 50, "Lunes", false, false);
			Assert.fail("La promocion no deberia ser nula");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso4(){
		try {
			mf.modificacionPromocionTemporal(promocionTemporal1, null, "efectivo", 50, "Lunes", false, false);
			Assert.fail("No deberia ser nulo el nombre");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso6(){
		try {
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promo Dia", "Bitcoin", 50, "Lunes", true, true);
			Assert.fail("El tipo de pago debe existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso7(){
		try {
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promocion1", null, 50, "Lunes", true, true);
			Assert.fail("El tipo de pago no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso8(){
		try {
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promocion1", "efectivo", 40, "Lunez", true, true);
			Assert.fail("El dia deberia existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testModificacionPromocionTemporalCaso9(){
		try {
			mf.modificacionPromocionTemporal(promocionTemporal1, "Promocion1", "efectivo", 50, null, true, true);
			Assert.fail("El dia no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
}
