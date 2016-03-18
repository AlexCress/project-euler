package projectEuler;

/**
 * Challenge:
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 * 
 * @author Alex
 *
 */

public class ProjectEuler007 {
	public String solve(final int primeNumberIndex){
		int primeCounter = 0;
		int primeAtIndex = 0; //The prime number at the given index
		for(int i = 2; i < Integer.MAX_VALUE; i++){
			if(isPrime(i)){
				primeCounter++;
				//Found the prime at the given index
				if(primeCounter == primeNumberIndex){
					primeAtIndex = i;
					break;
				}
			}
		}
		
		return Integer.toString(primeAtIndex);
	}
	
	public boolean isPrime(final int number){
		long temp = number;
		int counter = 2;
		
		while(counter <= number / 2){
			if(temp % counter == 0){
				return false;
			}
			counter += (counter > 2) ? 2 : 1;
		}
		return true;
	}
}
