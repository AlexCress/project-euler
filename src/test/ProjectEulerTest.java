package test;

import static org.junit.Assert.*;

import org.junit.Test;

import projectEuler.ProjectEuler001;

public class ProjectEulerTest {

	@Test
	public void pe001Test(){
		ProjectEuler001 pe = new ProjectEuler001();
		assertEquals(pe.findSumOfMultiples(), 233168);
	}
	


}
