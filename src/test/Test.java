package test;

import java.io.FileNotFoundException;
import java.io.IOException;

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

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		long start = System.currentTimeMillis();
		
		ProjectEuler021 pe = new ProjectEuler021();

		System.out.println(pe.solve(10000));
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
