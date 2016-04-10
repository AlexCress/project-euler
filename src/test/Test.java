package test;

import projectEuler.*;

/**
 * 
 * Contains main method to test challenges.
 * 
 * 
 * 
 * @author Alex
 * 
 */
public class Test {

	public static void main(String[] args){

		long start = System.currentTimeMillis();
		
		ProjectEuler023 pe = new ProjectEuler023();

		System.out.println(pe.solve());
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
