package test;

import java.util.InputMismatchException;
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
		
		ProjectEuler017 pe = new ProjectEuler017();
		System.out.println(pe.solve(1, 1000));
		
		/*
		Scanner s = new Scanner(System.in);
		while(s.hasNextLine()){
			try{
				int i = s.nextInt();
				
				System.out.println(pe.getPhrase(i));
			}catch(InputMismatchException e){
				System.out.println("Error: incorrect input. Please enter a valid integer in the range of "
						+ "1 <= i <= " + Integer.MAX_VALUE);
				s.nextLine();
			}

		}
		*/
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
