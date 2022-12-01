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
	private MetodosFacturacion mf;
	private Local local;
	private Producto producto1; 
	private PromocionProducto promocionProducto1, promocion producto 2;
	private PromocionTemporal promocionTemporal1;
	private Mesa mesa1;
	private Pedido pedido1, pedido2;
	private Comanda comanda1, comanda2;

	@Before
	public void setUp() throws Exception {
		mf = MetodosFacturacion.getInstance();
		local = Local.getInstance();		
		producto1 = new Producto(0,255,"Agua Mineral", 50, 250);
		local.getProductos().add(producto1);
		promocionProducto1 = new PromocionProducto(local.getProductos().get(0), "Lunes", true, true, 6, 25, true);
		local.getPromocionesProductos().add(promocionProducto1);
		promocionTemporal1 = new PromocionTemporal("Promocion1", "efectivo", 50, "Lunes", true, true);
		local.getPromocionesTemporales().add(promocionTemporal1);
		mesa1 = new Mesa(1);
		local.getMesas().add(mesa1);
		Mozo mozo1 = new Mozo(0, "Walter White", "07/09/1958", 1);
		AsignacionDiaria asignacionDiaria = new AsignacionDiaria(mozo1, mesa1);
		local.getAsignacionDiaria().add(asignacionDiaria);
		promocionProducto2 = new PromocionProducto(local.getProductos().get(0), "Sabado", true, true, 6, 25, true);
		local.getPromocionesProductos().add(promocionProducto2);
		pedido1 = new Pedido("Jueves", 2, local.getProductos().get(0));
		comanda1 = new Comanda(mesa1, pedido1, true);
		local.getComandas().add(comanda1);		
		Producto producto2 = new Producto(1,300,"Cerveza Quilmes",49,500);
		local.getProductos().add(producto2);
		pedido2 = new Pedido("Lunes", 2, local.getProductos().get(1));
		comanda2 = new Comanda(mesa1, pedido2, true);
		local.getComandas().add(comanda2);		
	}

	@After
	public void tearDown() throws Exception {
		local.getProductos().removeAll(local.getProductos());
		local.getPromocionesProductos().removeAll(local.getPromocionesProductos());
		local.getPromocionesTemporales().removeAll(local.getPromocionesTemporales());
		local.getComandas().removeAll(local.getComandas());
		local.getMesas().removeAll(local.getMesas());
		Local.elimInstance();
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

	@Test
	public void testGeneracionDeFacturaCaso1() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			Mozo mozo = local.getMozoByMesa(mesa1);
			float acumAnt = mozo.getAcumulados();
			int mesasAnt = mozo.getMesasAtentidas();
			float totalSinPromo = comanda1.getListaPedidos().get(0).getCantidad() * comanda1.getListaPedidos().get(0).getProducto().getPrecioVenta();
			float descPromProd = promocionProducto2.getPorcentajeDescCantMin()/100;
			float descPromTemp = promocionTemporal1.getPorcentajeDesc()/100;			
			factura = mf.generacionDeFactura(fecha, "Lunes", comanda1, "efectivo");	
			Assert.assertTrue("La factura no se acumulo", mozo.getAcumulados() == acumAnt+factura.getTotal());
			Assert.assertTrue("La mesa no se agrego", mesasAnt + 1 == mozo.getMesasAtentidas());
			Assert.assertTrue("Promocions no aplicadas", factura.getTotal() == totalSinPromo*descPromProd*descPromTemp);
			Assert.assertEquals("El estado de mesa no ha sido cambiado", factura.getMesa().getEstado(), "libre");
		}catch (Exception e) {
			Assert.fail("No deberia ser lanzada una excepcion");
		}
	}
	
	@Test
	public void testGeneracionDeFacturaCaso3() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			factura = mf.generacionDeFactura(null, "Lunes", comanda1, "efectivo");
			Assert.fail("No deberia ser nula la fecha");
		}catch(Exception e) {
			
		}
	}
	@Test
	public void testGeneracionDeFacturaCaso4() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			factura = mf.generacionDeFactura(fecha, "LuneZ", comanda1, "efectivo");
			Assert.fail("El dia deberia de existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testGeneracionDeFacturaCaso5() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			factura = mf.generacionDeFactura(fecha, null, comanda1, "efectivo");
			Assert.fail("El dia no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testGeneracionDeFacturaCaso6() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			factura = mf.generacionDeFactura(fecha, "Lunes", null, "efectivo");
			Assert.fail("No deberia ser nula la comanda");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testGeneracionDeFacturaCaso7() {
		Calendar fecha = Calendar.getInstance();
		Factura factura;
		try {
			factura = mf.generacionDeFactura(fecha, "Lunes", comanda1, "Bitcoin");
			Assert.fail("El metodo de pago deberia existir");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPedidoCaso1() {
		try {
			int stock = producto1.getStock();
			Pedido pedido = mf.altaPedido(new GregorianCalendar().toString(), 10, producto1);
			Assert.assertNotNull("Deberia de haberse creado el pedido", pedido);
			Assert.assertEquals("No se actualizo el stock del producto", producto1.getStock(), stock);			
		}catch(Exception e) {
			Assert.fail("No deberia ser lanzada una excepcion");
		}
	}
	
	@Test
	public void testAltaPedidoCaso2() {
		try {
			Pedido pedido = mf.altaPedido(null, 10, producto1);
			Assert.fail("El pedido no deberia de ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testAltaPedidoCaso3() {
		try {
			Pedido ped = mf.altaPedido(new GregorianCalendar().toString(), -999, producto1);
			Assert.fail("La cantidad deberia ser > 0");
		}catch(Exception e) {

		}
	}
	
	@Test
	public void testAltaPedidoCaso4() {
		try {
			Pedido ped = mf.altaPedido(new GregorianCalendar().toString(), 10, null);
			Assert.fail("El producto no deberia de ser nulo");
		}catch(Exception e) {

		}
	}
	@Test
	public void testBajaPedidoCaso1() {
		try {
			mf.bajaPedido(comanda1, pedido1);
			int i = 0;
			while(i<comanda1.getListaPedidos().size() && comanda1.getListaPedidos().get(i) != pedido1)
				i++;
			Assert.assertTrue("No se deberia haber encontrado el pedido", i >= comanda1.getListaPedidos().size());
		}catch(Exception e) {
			Assert.fail("No deberia ser lanzada una excepcion.");
		}
	}
	
	@Test
	public void testBajaPedidoCaso2() {
		try {
			mf.bajaPedido(null, pedido1);
			Assert.fail("La comanda no deberia ser nula");
		}catch(Exception e) {
			
		}
	}
	@Test
	public void testBajaPedidoCaso3() {
		try {
			mf.bajaPedido(comanda1, null);
			Assert.fail("El pedido no deberia ser nulo");
		}catch(Exception e) {
			
		}
	}
	
	
	@Test
	public void testAltaComandaCaso1() {
		try {
			Comanda comanda = mf.altaComanda(mesa1, pedido1);
			int i = 0;
			while(i < local.getComandas().size() && local.getComandas().get(i) != comanda)
				i++;
			Assert.assertTrue("Se deberia de haber encontrado la comanda", i <= local.getComandas().size());
			Assert.assertTrue("La comanda deberia estar activa", comanda.isEstado() == true);	
		}catch(Exception e) {
			Assert.fail("No deberia de ser lanzada una excepcion");
		}
	}
	
	@Test
	public void testModificacionComandaCaso1() {
		try {
			mf.modificacionComanda(comanda1, pedido2, true);
			int i = 0;
			while(i < comanda1.getListaPedidos().size() && comanda1.getListaPedidos().get(i) != pedido2)
				i++;
			Assert.assertTrue("Deberia de haberse agregado el pedido", i < comanda1.getListaPedidos().size() );
		}catch(Exception e) {
			Assert.fail("No deberia ser lanzada una excepcion");
		}
	}
	
	@Test
	public void testModificacionComandaCaso2() {
		try {
			mf.modificacionComanda(comanda1, pedido, false);
			int i = 0;
			while(i < comanda1.getListaPedidos().size() && comanda1.getListaPedidos().get(i) != pedido)
				i++;
			Assert.assertTrue("Deberia de haberse dado de baja el pedido", i >= comanda1.getListaPedidos().size() );
		}catch(Exception e) {
			Assert.fail("No deberia ser lanzada una excepcion");
		}
	}
	
	@Test
	public void testModificacionComandaCaso3() {
		try {
			mf.modificacionComanda(comanda1, pedido2, false);
			Assert.fail("No deberia continuar con la ejecucion");
		}catch(Exception e) {
			
		}
	}
	
}
