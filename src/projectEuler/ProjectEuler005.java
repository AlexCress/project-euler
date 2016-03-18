package projectEuler;

/**
 * Challenge:
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author Alex
 *
 */

public class ProjectEuler005 {

	/**
	 * Finds the smallest number that is evenly divisible by all the numbers
	 * between <code>min</code> and <code>max</code>, inclusive.
	 * 
	 * @param min - the floor of range to be checked
	 * @param max - the ceiling of range to be checked
	 * @return a String representation of the lowest number found
	 */
	public String solve(final int min, final int max){
		
		for(int i = max; i < Integer.MAX_VALUE; i++){
			if(isDivisibleByAllInRange(i, min, max)){
				return Integer.toString(i);
			}
		}
		//Should never happen
		return "Challenge #5 could not find any numbers for specified range!";
	}
	
	/**
	 * Checks if the given <code>number</code> is evenly divisible by all numbers from
	 * <code>min</code> to <code>max</code>, inclusive.
	 * 
	 * @param number - a valid integer value to be checked
	 * @param min - the floor of range to be checked
	 * @param max - the ceiling of range to be checked
	 * @return a boolean indicating success
	 */
	public boolean isDivisibleByAllInRange(final int number, final int min, final int max){
		for(int i = min; i <= max; i++){
			if(!(number % i == 0)){
				return false;
			}
		}
		return true;
	}
}
