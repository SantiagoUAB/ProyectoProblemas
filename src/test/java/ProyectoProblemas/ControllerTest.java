package ProyectoProblemas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	
	Controller controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new Controller();
	}
	
	@Test
	public void outofLimitTest() {
		boolean caseA = controller.proxyOutofLimit(0,0);
		boolean caseB = controller.proxyOutofLimit(-10,14);
		assertFalse(caseA);
		assertTrue(caseB);
	}

}
