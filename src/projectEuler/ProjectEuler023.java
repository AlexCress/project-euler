package projectEuler;

import java.util.ArrayList;

public class ProjectEuler023 {
	
	ArrayList<Integer> abundantNumbers;
	
	public int solve(){
		
		int nonabundantSum = 0;
		abundantNumbers = new ArrayList<Integer>();
		
		//12 is given in challenge as first abundant number
		//28123 is given as the upper bound, could technically be 28123-12
		for(int i = 12; i <= 28123; i++){
			if(isAbundant(i)){
				abundantNumbers.add(i);
			}
		}
		
		for(int i = 1; i <= 28123; i++){
			if( ! (isSumOfAbundantNumbers(i))){
				nonabundantSum += i;
			}
		}
		
		
		return nonabundantSum;
	}
	
	private boolean isAbundant(final int number){

		int i = getSumOfProperDivisors(number);
		if(i > number){
			return true;
		}
		
		return false;
	}
	
	private int getSumOfProperDivisors(final int number){
		int sum = 0;
		
		for(int i = 1; i <= number / 2; i++){
			if(number % i == 0){
				sum += i;
			}
		}
		
		return sum;
	}
	
	private boolean isSumOfAbundantNumbers(final int number){
		for(int i = 0; i < abundantNumbers.size(); i++){
			for(int j = i; j < abundantNumbers.size(); j++){
				int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
				
				//All possibilities have been exhausted
				if(j == i + 1 && sum > number){
					return false;
				}
				//Not necessarily done, reset j to save time
				else if(sum > number){
					break;
				}
				else if(sum == number){
					return true;
				}
			}
		}
		return false;
	}
}
