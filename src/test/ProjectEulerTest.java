package test;

import static org.junit.Assert.*;

import org.junit.Test;

import projectEuler.ProjectEuler001;
import projectEuler.ProjectEuler002;


/**
 * 
 * The answers contained in the asserts are retrieved from the website after confirmation.
 * 
 * 
 * @author Alex
 *
 */
public class ProjectEulerTest {

	@Test
	public void pe001Test(){
		ProjectEuler001 pe = new ProjectEuler001();
		assertEquals(pe.solve(), "233168");
	}
	
	@Test
	public void pe002Test(){
		ProjectEuler002 pe = new ProjectEuler002();
		assertEquals(pe.solve(), "4613732");
	}

}
