package projectEuler;

import func.PrimeFunc;

public class ProjectEuler010 {
	
	public long solve(int ceiling){

		long finalSum = 0;
		
		for(int i = 2; i < ceiling; i++){
			if(PrimeFunc.isPrime(i)){
				finalSum += i;
			}
		}
		
		return finalSum;
	}
}
