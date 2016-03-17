package projectEuler;

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

/*
 * I wrote all of this, only to discover that a number like 600bil is going to take forever.
 * Had to cheat on this one- TIL that you can divide the number by a known prime factor to 
 * narrow down the largest prime factor in next to no time.
 * 

public class ProjectEuler003 implements Solvable{
	
	public long findLargestPrimeFactor(final long number){
		long temp = number / 2;
		//Set to odd number
		temp += (temp % 2 == 0) ? 1 : 0;
		
		//Increment down from halfway, find first prime	factor
		while(temp > 1){
			if(isPrime(temp) && number % temp == 0){
				return temp;
			}
			temp -= 2;
		}

		//If the number given is a prime
		return 1;
	}
	
	public boolean isPrime(final long number){
		//If even
		//--Redundant check, the number is already set to odd before passing to this method, left for public use
		if(number % 2 == 0){
			return false;
		}
		//Increment through odd numbers starting at 3, go to half the number
		for(int i = 3; i < number / 2; i += 2){
			if(number % i == 0){
				return false;
			}
		}
		//If above fail, then it is prime
		return true;
	}

	@Override
	public <T> String solve(T... args) {
		//The number to be checked
		long number = 0;
		
		//Validity checking- null/length, must be Integer/Long/String above 0
		if(args.length > 0){		
			if(args[0].getClass().equals(Integer.class) && (int)args[0] > 0){
				number = Long.valueOf((int)args[0]);
			}
			else if(args[0].getClass().equals(Long.class) && (long)args[0] > 0){
				number = (long) args[0];
			}
			else if(args[0].getClass().equals(String.class) && ((String) args[0]).length() > 0){
				number = Long.parseLong((String) args[0]);
			}
		}
		else{
			return "Error, invalid input";
		}
		
		String answer = Long.toString(findLargestPrimeFactor(number));

		return answer;
	}

}
*/
