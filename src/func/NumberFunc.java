package func;

public class NumberFunc {
	
	public static boolean isPrime(final long number){
		
		if(number <= 1){
			return false;
		}
		else if(number <= 3){ //2 or 3
			return true;
		}
		else if(number % 2 == 0 || number % 3 == 0){
			return false;
		}
		
		//The number to iterate to. Primes only need to be checked until sqrt(n)
		long ceiling = (long) Math.sqrt(number);
		
		//Learned this trick from the Wikipedia page.
		//The explanation is kind of short and hard to follow...
		//but it states that all primes can be represented as
		//6*k + i, where i = −1, 0, 1, 2, 3, or 4.
		//Since any result where i = 0, 2, 3, 4 is already checked
		//via mod 2 or 3 checks, only -1 and 1 need be checked
		//Ex. 5 and 7, 11 and 13, 17 and 19...
		for(int i = 5; i <= ceiling; i += 6){
			if(number % i == 0 || number % (i + 2) == 0){
				return false;
			}
		}
		return true;
	}
}
