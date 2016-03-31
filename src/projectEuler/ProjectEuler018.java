package projectEuler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * I immediately notice that this is similar to Challenge #15, and
 * will attempt to brute force using the same recursive methodology.
 * Challenge says it cannot be brute forced...
 */

public class ProjectEuler018 implements Serializable{

	/*
	 * Private class declaration to be used in solving.
	 * ProjectEuler018 class attributes and methods start
	 * below...
	 * ------------------------------------
	 */
	
	private class Node implements Serializable{
		private int value;
		private int highestSum;
		private boolean isChecked = false;
		
		public Node(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public boolean isChecked() {
			return isChecked;
		}

		public void setChecked() {
			this.isChecked = true;
		}

		public int getHighestSum() {
			return highestSum;
		}

		public void setHighestSum(int highestSum) {
			this.highestSum = highestSum;
		}
	}
	
	/* ------------------------------------
	 * Main class declarations begin here
	 */
	
	private Node[][] triangleNumbers;
	
	public ProjectEuler018(){};
	
	public ProjectEuler018(String fileName){
		
		try {
			readFromFile(fileName);
//			initialize();
//			writeToFile(fileName);
		} catch (Exception e) {
			//I know I should be burned at the stake for catching with Exception...
			//I do not plan on recovering from any error regardless, so f it
			e.printStackTrace();
		} 
	}
	
	public int solve(){
		
		int highestSum = 0;
		
		highestSum = checkNode(0, 0, triangleNumbers.length - 1);
		
		return highestSum;
	}
	
	private int checkNode(int row, int x, int movesRemain){
		
		// Not at the end
		if (movesRemain > 0) {
			
			//Has already been calculated
			if(triangleNumbers[row][x].isChecked()){
				return triangleNumbers[row][x].getHighestSum();
			}	
			
			//Surprisingly few checks required; any move will automatically be valid
			//until bottom is reached (movesRemain == 0).
			
			int highestSum = 0;

			// Check right
			int temp = checkNode(row + 1, x + 1, movesRemain - 1);

			// Check left
			int temp2 = checkNode(row + 1, x, movesRemain - 1);
			
			highestSum = Math.max(temp, temp2) + triangleNumbers[row][x].getValue();
			
			//Set node
			triangleNumbers[row][x].setHighestSum(highestSum);
			triangleNumbers[row][x].setChecked();

			return highestSum;

		} 
		//Otherwise just return the Node's value
		return triangleNumbers[row][x].getValue();	
	}
	
	/**
	 * Allows for runtime input of the triangle numbers. Will prompt
	 * and parse the input into <code>Node</code>s and set the class
	 * attribute.
	 */
	public void initialize(){
		//Gets the raw triangle numbers
		List<Integer> numberList = getInput();

		//Calculate the amount of rows based off of amount of elements in list
		int rows = (int) ((Math.sqrt(8 * numberList.size() + 1) - 1) / 2);
		//Initialize array size
		triangleNumbers = new Node[rows][];
		
		//For tracking index through numberList
		int index = 0;
		
		//Add elements to array in hierarchical manner (basically reconstruct triangle using 2d array)
		for(int i = 0; i < rows; i++){
			//Array to be inserted into triangleNumbers[i], 
			//the length is equal to the current row
			Node[] temp = new Node[i + 1];
			
			for(int j = 0; j < i + 1; j++){
				temp[j] = new Node(numberList.get(index));
				index++;
			}
			triangleNumbers[i] = temp;
		}
	}
	
	
	/**
	 * Prompts the user for a valid set of triangle numbers
	 * and returns a <code>List</code> of the values
	 * in the order they were input. 
	 * @return a List<Integer> of triangle numbers
	 */
	private List<Integer> getInput(){
		
		List<Integer> numbers = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the numbers separated by whitespace, and \"done\" when complete: ");
		
		while(scan.hasNextLine()){
			
			String line = scan.nextLine();
			if(line.equals("done")){
				break;
			}
			String[] nums = line.split(" ");
			for(String s : nums){
				numbers.add(Integer.parseInt(s));
			}			
		}	
		return numbers;
	}
	
	public void writeToFile(String fileName) throws FileNotFoundException, IOException{
		ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(fileName));
		oStream.writeObject(triangleNumbers);
		oStream.close();
	}
	
	public void readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(fileName));
		triangleNumbers = (Node[][]) iStream.readObject();
		iStream.close();
	}
}
