package test;

import static org.junit.Assert.*;

import org.junit.Test;

import projectEuler.*;


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
		assertEquals("233168", pe.solve());
	}
	
	@Test
	public void pe002Test(){
		ProjectEuler002 pe = new ProjectEuler002();
		assertEquals("4613732", pe.solve());
	}

	@Test
	public void pe003Test(){
		ProjectEuler003 pe = new ProjectEuler003();
		assertEquals("29", pe.solve(Long.valueOf("13195")));
	}
	
	@Test
	public void pe004Test(){
		ProjectEuler004 pe = new ProjectEuler004();
		assertEquals("9009", pe.solve(2));
	}
	
	@Test
	public void pe005Test(){
		ProjectEuler005 pe = new ProjectEuler005();
		assertEquals("2520", pe.solve(1, 10));
	}
}
