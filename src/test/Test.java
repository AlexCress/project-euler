package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
		
		ProjectEuler016 pe = new ProjectEuler016();
		System.out.println(pe.solve(2, 1000));
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
