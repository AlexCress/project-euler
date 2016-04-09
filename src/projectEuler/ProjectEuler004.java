package projectEuler;


/**
 * Challenge:
 * <p>
 * A palindromic number reads the same both ways. The largest palindrome 
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * @author Alex
 *
 */
public class ProjectEuler004 {
	public static final int NUM_DIGITS = 3;

	public String solve(final int numberOfDigits){
		int largestPalindrome = 0;
		int upperBound = 0;
		
		if(numberOfDigits > 0){
			upperBound = (int) Math.pow(10, numberOfDigits) - 1;
		}
		else{
			upperBound = (int) Math.pow(10, NUM_DIGITS) - 1;
		}
				
		for(int i = upperBound; i > 0; i--){
			for(int j = upperBound; j > 0; j--){
				int product = i * j;
				if(isPalindrome(product) && largestPalindrome < product){
					largestPalindrome = product;
				}
			}
		}
		
		return Integer.toString(largestPalindrome);
	}
	
	public boolean isPalindrome(final int number){
		int reverse = reverseNumber(number);
		if(reverse == number){
			return true;
		}
		return false;
	}
	
	public int reverseNumber(final int number){
		int temp = number;
		int reverse = 0;
		
		while(temp > 1){
			int last = temp % 10;
			reverse = reverse * 10 + last;
			temp /= 10;
		}
		
		return reverse;
	}
}
