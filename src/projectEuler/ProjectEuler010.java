package projectEuler;

import func.NumberFunc;

public class ProjectEuler010 {
	
	public long solve(int ceiling){

		long finalSum = 0;
		
		for(int i = 2; i < ceiling; i++){
			if(NumberFunc.isPrime(i)){
				finalSum += i;
			}
		}
		
		return finalSum;
	}
}
