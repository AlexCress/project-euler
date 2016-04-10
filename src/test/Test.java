package test;

import projectEuler.*;

public class Test{
    
    public static void main(String[] args){
    	long start = System.currentTimeMillis();
    	
    	ProjectEuler023 pe = new ProjectEuler023();
    	System.out.println(pe.solve());
    	
    	long end = System.currentTimeMillis();
    	
    	System.out.println("Total time: " + (end - start));
    }
}
