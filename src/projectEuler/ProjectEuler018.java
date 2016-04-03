package projectEuler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * I immediately notice that this is similar to Challenge #15, and
 * will attempt to brute force using the same recursive methodology.
 * Challenge says it cannot be brute forced...
 * Challenge #67 solved with this implementation
 */

public class ProjectEuler018 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 450749858421809192L;

	/*
	 * Private class declaration.
	 * ProjectEuler018 class attributes and methods start
	 * below...
	 * ------------------------------------
	 */

	/**
	 * A private inner utility class used to hold multiple pieces of
	 * imperative information. Each triangle number is represented as
	 * a node. In addition to holding its initial value, it will also 
	 * save the highest sum between its left and right paths.
	 * 
	 * @author Alex
	 *
	 */
	private class Node implements Serializable{
	
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 7961680068278171698L;
		
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
	 * 
	 */
	
	/**
	 * An array containing every <code>Node</code> in a structured
	 * format resembling a triangle. For example, take the following
	 * 3-row triangle:<p>
	 * 
	 * __1<br>
	 * _2_3<br>
	 * 4_5_6<p>
	 * 
	 * Would be represented as:<p>
	 * 
	 * nodeArray[0][0...] 1<br>
	 * nodeArray[1][0...] 2, 3<br>
	 * nodeArray[2][0...] 4, 5, 6<p>
	 * 
	 * Note that the array is initialized with exact values, so the first
	 * row will only have room for one element, second will have two, etc.
	 */
	
	private Node[][] nodeArray;
	
	/**
	 * No-arg constructor -- does not do anything. Use this
	 * if you wish to manually initialize <code>nodeArray[][]</code>
	 * through the <code>initialize()<code> method.
	 */
	public ProjectEuler018(){}
	
	/**
	 * Reconstructs a serialized node array from file which
	 * sets <code>nodeArray</code>. Use <code>initialize()</code>
	 * to create a new file.
	 * 
	 * @param fileName - a file located in the root directory containing 
	 * a valid serialized representation of a <code>Node</code> array.
	 */
	public ProjectEuler018(String fileName){
		
		try {
			readFromFile(fileName);
		} catch (Exception e) {
			//I know I should be burned at the stake for catching with Exception...
			//but I do not plan on recovering from any error regardless, so f it
			e.printStackTrace();
		} 
	}
	
	public int solve(){
		
		int highestSum = 0;
		
		highestSum = checkNode(0, 0, nodeArray.length - 1);
		
		return highestSum;
	}
	
	private int checkNode(int row, int x, int movesRemain){
		
		if (movesRemain > 0) {
			
			//Has already been calculated
			if(nodeArray[row][x].isChecked()){
				return nodeArray[row][x].getHighestSum();
			}	
			
			//Surprisingly few checks required; any move will automatically be valid
			//until bottom is reached (movesRemain == 0).
			
			int highestSum = 0;

			// Check right
			int temp = checkNode(row + 1, x + 1, movesRemain - 1);

			// Check left
			int temp2 = checkNode(row + 1, x, movesRemain - 1);
			
			highestSum = Math.max(temp, temp2) + nodeArray[row][x].getValue();
			
			//Set node
			nodeArray[row][x].setHighestSum(highestSum);
			nodeArray[row][x].setChecked();

			return highestSum;

		} 
		//Otherwise just return the Node's value
		return nodeArray[row][x].getValue();	
	}
	
	/**
	 * Allows for runtime input of the triangle numbers. Will prompt
	 * and parse the input into <code>Node</code>s and set the class
	 * attribute <code>nodeArray[][]</code>
	 */
	public void initialize(){
		//Gets the raw triangle numbers
		List<Integer> numberList = getInput();

		//Calculate the amount of rows based off of amount of elements in list
		int rows = (int) ((Math.sqrt(8 * numberList.size() + 1) - 1) / 2);
		//Initialize array size
		nodeArray = new Node[rows][];
		
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
			nodeArray[i] = temp;
		}
	}
	
	
	/**
	 * Prompts the user for a valid set of triangle numbers
	 * and returns a <code>List</code> of the values
	 * in the order they were input. 
	 * 
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
		oStream.writeObject(nodeArray);
		oStream.close();
	}
	
	public void readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(fileName));
		nodeArray = (Node[][]) iStream.readObject();
		iStream.close();
	}
}
