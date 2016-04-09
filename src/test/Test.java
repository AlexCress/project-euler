package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
		
		ProjectEuler022 pe = new ProjectEuler022();

		System.out.println(pe.solve());
		
		long end = System.currentTimeMillis();
		
		System.out.println("Running time: " + (end - start));
	}
}
