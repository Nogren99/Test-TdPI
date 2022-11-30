package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import capaDeNegocios.Local;

public class EscenarioSinDatos {
	Local local = Local.getInstance();
	
	public Local getLocal() {
		return local;
	}

	@Before
	public void setUp() throws Exception {
		local.getMesas().clear();
		local.getOperarios().clear();
		local.getProductos().clear();
		local.getMozos().clear();
	}

	@After
	public void tearDown() throws Exception {
	}

	
}
