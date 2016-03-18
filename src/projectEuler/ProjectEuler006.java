package projectEuler;


/**
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 1^2 + 2^2 + ... + 10^2 = 385
 * <p>
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * <p>
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * 
 * @author Alex
 *
 */
public class ProjectEuler006 {
	
	public String solve(final int min, final int max){
		
		int squareOfSum = 0;
		int sumOfSquares = 0;
		
		for(int i = min; i <= max; i++){
			sumOfSquares += Math.pow(i, 2);
			squareOfSum += i;
		}
		squareOfSum = (int) Math.pow(squareOfSum, 2);
		
		int difference = squareOfSum - sumOfSquares;
		
		return Integer.toString(difference);
	}
}
