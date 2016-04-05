package projectEuler;

import java.util.HashMap;

public class ProjectEuler021 {
	
	HashMap<Integer, Boolean> amicableNumberChecked = new HashMap<Integer, Boolean>();
	
	public int solve(final int ceiling){
		
		int sum = 0;
		
		for(int i = 1; i < ceiling; i++){
			
			if(amicableNumberChecked.get(i) == null
					|| amicableNumberChecked.get(i) == false){
				
				int n1 = getDivisorSum(i);
				int n2 = getDivisorSum(n1);
				
				
				if(n2 == i && n1 != n2){
					amicableNumberChecked.put(n1, true);
					amicableNumberChecked.put(n2, true);
					
					sum += n1 + n2;
				}
			}
			
		}
		
		
		return sum;
	}
	
	private int getDivisorSum(final int number){
		
		if(number < 1){
			return -1;
		}
		
		int sum = 1;	
		int ceiling = (int) Math.sqrt(number);
		
		for(int i = 2; i <= ceiling; i++){
			if(number % i == 0){
				sum += i;
				int d = number/i;
				if(d != i){
					sum += d;
				}
			}
		}
		
		return sum;
	}
}
