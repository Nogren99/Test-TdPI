package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCajaBlancaConDatos.class, TestCajaBlancaSinDatos.class, TestConfiguracionDeSistemaConDatos.class,
		TestConfiguracionDeSistemaSinDatos.class, TestGestionDePersonalConDatos.class,
		TestGestionDePersonalSinDatos.class, TestInterfazGraficaConDatos.class, TestInterfazGraficaSinDatos.class,
		TestLocalConDatos.class, TestLocalSinDatos.class, TestMetodosFacturacionConDatos.class,
		TestMetodosFacturacionSinDatos.class, TestPersistenciaNoVacio.class, TestPersistenciaVacio.class })
public class AllTests {

}
