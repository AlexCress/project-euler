package projectEuler;

/**
 * Project challenge:
 * <p>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author Alex
 *
 */

public class ProjectEuler001 {
	
	/**
	 * The default number of iterations to perform.
	 */
	public static final int NUM_ITERATIONS = 1000;

	/**
	 * @param numOfIterations - the number of iterations to check
	 * @return an <code>int</code> sum of all the multiples of 3 or 5 between 1 and <code>numOfIterations</code>
	 */
	public int findSumOfMultiples(){
		int finalSum = 0;
		
		for(int i = 0; i < NUM_ITERATIONS; i++){
			if(i % 3 == 0 || i % 5 == 0){
				finalSum += i;
			}
		}
		
		//Print it for debugging
		System.out.println(finalSum);
		
		return finalSum;
	}
}
