package test;

import pe001.ProjectEuler001;

/**
 * 
 * Contains main method to test projects. Each project should perform its task automatically on instantiation
 * 
 * @author Alex
 * 
 */
public class Test {
	public static void main(String[] args){
		ProjectEuler001 pe001 = new ProjectEuler001();
		System.out.println(pe001.findSumOfMultiples(10));
	}
}
