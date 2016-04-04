package projectEuler;

import java.math.BigInteger;

public class ProjectEuler020 {
	
	public BigInteger solve(final int number){
		
		BigInteger sum = BigInteger.ZERO;
		BigInteger product = BigInteger.ONE;
		
		//Find factorial
		for(int i = number; i > 0; i--){
			product = product.multiply(BigInteger.valueOf(i));
		}
		
		//Add digits together
		while(product.doubleValue() > 0){
			//Removes last digit, adds to sum
			BigInteger[] nums = product.divideAndRemainder(BigInteger.valueOf(10));
			product = nums[0];
			sum = sum.add(nums[1]);
		}
		
		return sum;
	}
}
