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
		ProjectEuler003 pe = new ProjectEuler003();
		System.out.println(pe.solve(Long.valueOf("600851475143")));
	}
}
