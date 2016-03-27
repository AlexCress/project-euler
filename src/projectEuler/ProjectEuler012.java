package projectEuler;



//After solving the problem with a running time of 547ms, I decided to try to optimize further.
//The following co-prime voodoo is taken from a stackoverflow post regarding the problem:

//It is based on coprime numbers properties. The triangle number is equal to n*(n+1)/2 
//where n and n+1 are coprimes => n and (n+1)/2 are coprimes or n/2 and n+1 are coprimes 
//( it depends if n is even or odd ). 

public class ProjectEuler012 {

	public long solve(int numberOfDivisors){
		
		int firstCoprime;
		int secondCoprime;

		//Pseudo-infinite loop, exit conditions within
		for(long i = 1; i < Long.MAX_VALUE; i++){
			
			if(i % 2 == 0){
				firstCoprime = checkNumberOfDivisors(i / 2);
				secondCoprime = checkNumberOfDivisors(i + 1);				
			}
			else{
				firstCoprime = checkNumberOfDivisors((i + 1) / 2);
				secondCoprime = checkNumberOfDivisors(i);
			}
			
			int divisors = firstCoprime * secondCoprime;
			
			if(divisors > numberOfDivisors){
				return i*(i+1)/2;			
			}		
		}		
		return 0;
	}
	
	private int checkNumberOfDivisors(final long number){

		//Preliminary checks
		if(number <= 0){
			return 0;
		}
		else if(number == 1){
			return 1;
		}
		else if(number <= 3){
			return 2;
		}
		
		//Assumed to always have 2 divisors- 1 and itself
		int divisors = 2;
		long sqrt = (long) Math.sqrt(number);
		
		for(int i = 2; i < sqrt; i++){
			if(number % i == 0){
				divisors += 2;
			}
		}
		
		return divisors;
	}
	
}
