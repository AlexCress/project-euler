package projectEuler;

//After solving the problem with a running time of 547ms, I decided to try to optimize further.
//The following co-prime voodoo is taken from a stackoverflow post regarding the problem:

//It is based on coprime numbers properties. The triangle number is equal to n*(n+1)/2 
//where n and n+1 are coprimes, n and (n+1)/2 are coprimes when n is odd, or n/2 and n+1 are 
//coprimes when n is even.
//[Edited for clarity]

//After implementation, it was reduced to 31ms

/**
 * 
 * Challenge:<p>
 * 
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first
 * ten terms would be:<p> 
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...<p>
 * 
 * Let us list the factors of the first seven triangle numbers:<p>
 * 
 * 1: 1 <p>
 * 3: 1,3 <p>
 * 6: 1,2,3,6 <p>
 * 10: 1,2,5,10 <p>
 * 15: 1,3,5,15 <p>
 * 21: 1,3,7,21 <p>
 * 28: 1,2,4,7,14,28 <p>
 * 
 * We can see that 28 is the first triangle number to have over
 * five divisors.<p>
 * 
 * What is the value of the first triangle number to have over five hundred
 * divisors?
 * 
 * 
 * @author Alex
 *
 */

public class ProjectEuler012 {

	/**
	 * Returns the smallest number where its number of divisors are
	 * >= <code>numberOfDivisors</code>.<p>
	 * 
	 * 
	 * @param numberOfDivisors - a positive <code>int</code> value
	 * @return a <code>long</code> that has >= <code>numberOfDivisors</code>, 
	 * 0 if all possibilities <= <code>Long.MAX_VALUE</code> have been checked,
	 * or -1 if <code>numberOfDivisors</code> <= 0.
	 */
	public long solve(final int numberOfDivisors){
		
		if(numberOfDivisors < 1){
			return -1;
		}
		
		int firstCoprime, secondCoprime;

		//Pseudo-infinite loop
		for(long i = 1; i < Long.MAX_VALUE; i++){
			
			//Find coprimes of i based on whether i is even or odd
			if(i % 2 == 0){
				firstCoprime = checkNumberOfDivisors(i / 2);
				secondCoprime = checkNumberOfDivisors(i + 1);				
			}
			else{
				firstCoprime = checkNumberOfDivisors((i + 1) / 2);
				secondCoprime = checkNumberOfDivisors(i);
			}
			
			//Multiplying both coprimes together will return the number of divisors
			//Note: this corresponds to the triangle number calculated below, not i
			int divisors = firstCoprime * secondCoprime;
			
			//If a solution is discovered, convert i to its corresponding triangle number and return
			if(divisors >= numberOfDivisors){
				return i * (i + 1) / 2;			
			}		
		}		
		return 0;
	}
	
	private int checkNumberOfDivisors(final long number){

		if(number < 1){
			return 0;
		}

		int divisors = 0;
		long sqrt = (long) Math.sqrt(number);
		
		for(int i = 1; i <= sqrt; i++){
			if(number % i == 0){
				divisors += 2;
			}
		}
		
		//Check for perfect squares' off-by-one error
		//i.e. 36 == 6 * 6, but 6 should only be counted once
		if(sqrt * sqrt == number){
			divisors--;
		}
		
		return divisors;
	}
	
}
