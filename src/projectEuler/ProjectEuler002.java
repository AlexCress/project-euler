package projectEuler;

/**
 * Challenge:
 * <p>
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * <p>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * <p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * 
 * 
 * @author Alex
 *
 */
public class ProjectEuler002{
	
	/**
	 * Calculation will stop if x >= MAX_VALUE
	 */
	public final static int MAX_VALUE = 4000000;
	
	public int findSumOfEvenFibonacci(){
		int finalSum = 0;
		int lastNum = 1;
		int currentNum = 1;
		
		while(currentNum < MAX_VALUE){			
						
			if(currentNum % 2 == 0){
				finalSum += currentNum;
			}
			
			int temp = currentNum;
			currentNum += lastNum;
			lastNum = temp;
		}
		
		return finalSum;
	}

	public String solve() {
		String answer = Integer.toString(findSumOfEvenFibonacci());		

		return answer;
	}
	
}
