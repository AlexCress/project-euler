package projectEuler;

/**
 * The following iterative sequence is defined for the set of positive integers:<p>

n → n/2 (n is even)<p>
n → 3n + 1 (n is odd)<p>

Using the rule above and starting with 13, we generate the following sequence:<p>

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1<p>
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.<p>

Which starting number, under one million, produces the longest chain?<p>

NOTE: Once the chain starts the terms are allowed to go above one million.
 * @author Alex
 *
 */

public class ProjectEuler014 {

	public int solve(final int ceiling){
		int highestChainCount = 0;
		int highestChainNumber = 0;
		
		for(int i = 1; i < ceiling; i++){
			int terms = calculateCollatzChain(i);
			if(terms > highestChainCount){
				highestChainCount = terms;
				highestChainNumber = i;
			}
		}
		
		return highestChainNumber;
	}
	
	private int calculateCollatzChain(final int number){
		
		if(number < 1){
			return -1;
		}
		
		int chainCount = 0;
		long n = number;
		
		while(n != 1){
			if(n % 2 == 0){
				n /= 2;
			}else{
				n = (3* n) + 1;
			}
			chainCount++;
		}
		
		return chainCount;
	}
}
