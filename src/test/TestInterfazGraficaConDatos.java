package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import capaDeNegocios.Local;
import controlador.ControladorLogin;
import testtTemporal.TestUtil;

public class TestInterfazGraficaConDatos {
	
	Robot robot;
    ControladorLogin controlador;
    private Local local;
	private EscenarioConDatos E1 = new EscenarioConDatos();

	
	
	public TestInterfazGraficaConDatos() {
		try {
			robot = new Robot();
			
		}catch(AWTException e) {
			
		}
	}
	
	
	@Before
	public void setUp() throws Exception {
		this.E1.setUp();
		this.local=this.E1.getLocal();
		controlador= new ControladorLogin();
		
	}

	@After
	public void tearDown() throws Exception {
		this.E1.tearDown();
		controlador.getVista().setVisible(false);
	}

	

    @Test
    public void testLoginAdminCorrecto() {
    	robot.delay(TestUtil.getDelay());
    	
    	JTextField nombreUsuario= (JTextField) TestUtil.getComponentForName(controlador.getVista(), "textUsuario");
    	JTextField contrasenia =(JTextField) TestUtil.getComponentForName(controlador.getVista(), "textPassword");
    	JButton ingresar= (JButton) TestUtil.getComponentForName(controlador.getVista(), "botonIngreso");
    	
    	TestUtil.clickComponent(nombreUsuario, robot);
    	TestUtil.tipeaTexto("ADMIN", robot);
    	TestUtil.clickComponent(contrasenia, robot);
    	TestUtil.tipeaTexto("ADMIN1234", robot);
    	TestUtil.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El tipo de usuario debe ser 0", 0, controlador.getTipoUsuario());
    	
    	Assert.assertNotNull("El usuario obtenido no deberia ser null",controlador.getOperario());
    	Assert.assertEquals("El usuario obtenido no tiene el mismo nombre de usuario que el ingresado","ADMIN",controlador.getOperario().getNombreUsuario());
    	Assert.assertEquals("El usuario obtenido no tiene la misma contrasenia que la ingresada","ADMIN1234",controlador.getOperario().getPassword());
    	
    }
    
    @Test
    public void testLoginOperarioCorrecto() {
    	robot.delay(TestUtil.getDelay());
    	
    	JTextField nombreUsuario= (JTextField) TestUtil.getComponentForName(controlador.getVista(), "textUsuario");
    	JTextField contrasenia =(JTextField) TestUtil.getComponentForName(controlador.getVista(), "textPassword");
    	JButton ingresar= (JButton) TestUtil.getComponentForName(controlador.getVista(), "botonIngreso");
    	
    	TestUtil.clickComponent(nombreUsuario, robot);
    	TestUtil.tipeaTexto("Meolans", robot);
    	TestUtil.clickComponent(contrasenia, robot);
    	TestUtil.tipeaTexto("QWERTY1234", robot);
    	TestUtil.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El tipo de usuario debe ser 0", 0, controlador.getTipoUsuario());
    	
    	Assert.assertNotNull("El usuario obtenido no deberia ser null",controlador.getOperario());
    	Assert.assertEquals("El usuario obtenido no tiene el mismo nombre de usuario que el ingresado","Meolans",controlador.getOperario().getNombreUsuario());
    	Assert.assertEquals("El usuario obtenido no tiene la misma contrasenia que la ingresada","QWERTY1234",controlador.getOperario().getPassword());
    	
    }
 
    @Test
    public void testLoginUsuarioIncorrecto() {
    	robot.delay(TestUtil.getDelay());
    	
    	JTextField nombreUsuario= (JTextField) TestUtil.getComponentForName(controlador.getVista(), "textUsuario");
    	JTextField contrasenia =(JTextField) TestUtil.getComponentForName(controlador.getVista(), "textPassword");
    	JButton ingresar= (JButton) TestUtil.getComponentForName(controlador.getVista(), "botonIngreso");
    	JLabel lblusuario=(JLabel) TestUtil.getComponentForName(controlador.getVista(),"labelErrorUsuario");
    	
    	
    	TestUtil.clickComponent(nombreUsuario, robot);
    	TestUtil.tipeaTexto("meolans", robot);
    	TestUtil.clickComponent(contrasenia, robot);
    	TestUtil.tipeaTexto("QWERTY1234", robot);
    	TestUtil.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El error de usuario no es correcto","Error Usuario",lblusuario.getText());
    	Assert.assertNull("El usuario obtenido no deberia ser null",controlador.getOperario());
    }
    
    @Test
    public void testLoginPassIncorrecta() {
    	robot.delay(TestUtil.getDelay());
    	
    	JTextField nombreUsuario= (JTextField) TestUtil.getComponentForName(controlador.getVista(), "textUsuario");
    	JTextField contrasenia =(JTextField) TestUtil.getComponentForName(controlador.getVista(), "textPassword");
    	JButton ingresar= (JButton) TestUtil.getComponentForName(controlador.getVista(), "botonIngreso");
    	JLabel lblcontrasenia=(JLabel) TestUtil.getComponentForName(controlador.getVista(),"labelErrorContrasenia");
    	
    	
    	TestUtil.clickComponent(nombreUsuario, robot);
    	TestUtil.tipeaTexto("Meolans", robot);
    	TestUtil.clickComponent(contrasenia, robot);
    	TestUtil.tipeaTexto("qwerty1234", robot);
    	TestUtil.clickComponent(ingresar, robot);
    	
    	Assert.assertEquals("El error de contrasenia no es correcto","Error Contraseña",lblcontrasenia.getText());
    	Assert.assertNull("El usuario obtenido no deberia ser null",controlador.getOperario());
    }
	
	
}
