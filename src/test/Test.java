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
		
		ProjectEuler018 pe = new ProjectEuler018("challenge018.txt");
		System.out.println(pe.solve());
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
