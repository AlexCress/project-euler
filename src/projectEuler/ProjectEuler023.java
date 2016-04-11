package projectEuler;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Project description: https://projecteuler.net/problem=23
 *
 */
public class ProjectEuler023 {
	
	//Both constants given in challenge description
	public static final int MIN_ABUNDANT = 12;
	public static final int MAX_ABUNDANT = 28123;
	
	private ArrayList<Integer> abundantNumbers;
	private HashSet<Integer> abNumSet;
	
	public int solve(){
		
		abundantNumbers = new ArrayList<Integer>(6965); //6965 taken after solution was confirmed, optimization
		abNumSet = new HashSet<Integer>(6965);

		for(int i = MIN_ABUNDANT; i <= MAX_ABUNDANT; i++){
			if(isAbundant(i)){
				abundantNumbers.add(i);
				abNumSet.add(i);
			}
		}

		int nonabundantSum = 0;
		for(int i = 1; i <= MAX_ABUNDANT; i++){
			if( ! (isSumOfAbundantNumbers(i))){
				nonabundantSum += i;
			}
		}

		return nonabundantSum;
	}
	
	private boolean isAbundant(final int number){

		return(sumOfDivisors(number) > number * 2);
	}
	
	private int sumOfDivisors(int number){

		int sum = 1;
		for(int i = 2; i * i <= number; i++){
			int p = 1;
			while(number % i == 0){
				p = p * i + 1;
				number /= i;
			}
			sum *= p;
		}
		if(number > 1){
			sum *= 1 + number;
		}
		return sum;
		
//		int sum = 0;
//		
//		for(int i = 1; i <= number / 2; i++){
//			if(number % i == 0){
//				sum += i;
//			}
//		}
//		
//		return sum;
	}
	
	private boolean isSumOfAbundantNumbers(final int number){
		
		for(int i = 0; i < abundantNumbers.size(); i++){
			if(number - abundantNumbers.get(i) < MIN_ABUNDANT){
				return false;
			}

			int n = number - abundantNumbers.get(i);
			if(abNumSet.contains(n)){
				return true;
			}
		}
		return false;
		
		
//		for(int i = 0; i < abundantNumbers.size(); i++){
//			for(int j = i; j < abundantNumbers.size(); j++){
//				int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
//				
//				//All possibilities have been exhausted
//				if(j == i + 1 && sum > number){
//					return false;
//				}
//				//Not necessarily done, reset j to save time
//				else if(sum > number){
//					break;
//				}
//				else if(sum == number){
//					return true;
//				}
//			}
//		}
//		return false;
	}
}
