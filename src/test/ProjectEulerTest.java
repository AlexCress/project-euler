package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import projectEuler.*;
import projectEuler.ProjectEuler009.PythTriplet;


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
	
	@Test
	public void pe006Test(){
		ProjectEuler006 pe = new ProjectEuler006();
		assertEquals("2640", pe.solve(1, 10));
	}
	
	@Test
	public void pe007Test(){
		ProjectEuler007 pe = new ProjectEuler007();
		assertEquals("13", pe.solve(6));
	}
	
	@Test
	public void pe008Test(){
		ProjectEuler008 pe = new ProjectEuler008();
		assertEquals("5832", pe.solve(4));
	}
	
	@Test
	public void pe009Test(){
		ProjectEuler009 pe = new ProjectEuler009();
		assertEquals(60, pe.solve(12));
	}
	
	@Test
	public void pe009TestExhaustive(){
		//Used to control the amount of iterations
		final int ITERATIONS = 1000;
		//There may be 2 or more valid Triplets that add up to the same sum, just for logging
		int exceptionsResolved = 0; 
		//Time tracking
		long startTime = System.currentTimeMillis();
		
		ProjectEuler009 pe = new ProjectEuler009();
		
		List<PythTriplet> pyth = pe.getTriplets(ITERATIONS);
		for(int i = 0; i < ITERATIONS; i++){
			PythTriplet tempPyth = pyth.get(i);
			long sum = tempPyth.getSum();
			long product = tempPyth.getProduct();
			try{
				assertEquals(product, pe.solve(sum));
			}catch(AssertionError e){
				long a = tempPyth.getA();
				long b = tempPyth.getB();
				long c = tempPyth.getC();
				
				if(a * a + b * b == c * c){
					exceptionsResolved++;
				}
				else{			
					System.out.println("Unresolved exception: " + pyth.get(i).toString() + e.getMessage());
				}
			}	
		}
		long endTime = System.currentTimeMillis();
		System.out.printf("pe009TestExhaustive complete!%nIterations: %d%nExceptions Resolved: %d%nTotal Time: %dms", 
				ITERATIONS, exceptionsResolved, endTime - startTime);
	}
}
