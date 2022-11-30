package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeNegocios.Local;
import controlador.ControladorLogin;
import testtTemporal.TestUtil;

public class TestInterfazGraficaSinDatos {
	Robot robot;
    ControladorLogin controlador;
	private Local local;
	private EscenarioSinDatos E2 = new EscenarioSinDatos();

	public TestInterfazGraficaSinDatos() {
		try {
			robot = new Robot();
			
		}catch(AWTException e) {
			
		}
	}
	@Before
	public void setUp() throws Exception {
		this.E2.setUp();
		this.local=this.E2.getLocal();
		controlador= new ControladorLogin();
	}

	@After
	public void tearDown() throws Exception {
		this.E2.tearDown();
		controlador.getVista().setVisible(false);
	}

	@Test
    public void testLogeoCorrecto() {
    	robot.delay(TestUtil.getDelay());
    	
    	JTextField nombreUsuario= (JTextField) TestUtil.getComponentForName(controlador.getVista(), "textUsuario");
    	JTextField contrasenia =(JTextField) TestUtil.getComponentForName(controlador.getVista(), "textPassword");
    	JButton ingresar= (JButton) TestUtil.getComponentForName(controlador.getVista(), "botonIngreso");
    	
    	TestUtil.clickComponent(nombreUsuario, robot);
    	TestUtil.tipeaTexto("Nahuel", robot);
    	TestUtil.clickComponent(contrasenia, robot);
    	TestUtil.tipeaTexto("Calle123", robot);
    	TestUtil.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El tipo de usuario debe ser 0", 0, controlador.getTipoUsuario());
    	
    	Assert.assertNotNull("El usuario obtenido no deberia ser null",controlador.getOperario());
    	Assert.assertEquals("El usuario obtenido no tiene el mismo nombre de usuario que el ingresado","Nahuel",controlador.getOperario().getNombreUsuario());
    	Assert.assertEquals("El usuario obtenido no tiene la misma contrasenia que la ingresada","Calle123",controlador.getOperario().getPassword());
    	
    }

}
