package projectEuler;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * Challenge:
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author Alex
 *
 */

public class ProjectEuler003{

	public String solve(final long number) {
		long temp = number;
		long largestPrime = 1;
		int counter = 2;
		
		while(temp > 1){
			while(temp % counter == 0){
				largestPrime = counter;
				temp /= counter;
			}
			counter += (counter > 2) ? 2 : 1;
		}
		
		return String.valueOf(largestPrime);
	}
	
}

