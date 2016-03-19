package projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Challenge:
 * <p>
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * <p>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * <p>
 * Find the product abc.
 * 
 * @author Alex
 *
 */

// a = m^2 - n^2 
// b = 2mn
// c = m^2 + n^2 
//
//a = k * (m^2 - n^2)
//b = k * (2mn)
//c = k * (m^2 + n^2)
//where m, n, and k are positive integers with m > n, m − n odd, and with m and n coprime.

public class ProjectEuler009 {
	
	/**
	 * Reverse-engineers a Pythagorean Triplet when given a sum of
	 * a + b + c. Satisfies the challenge by returning the product
	 * abc.
	 * 
	 * @param sum - a + b + c sum of a valid Pythagorean Triplet
	 * @return the product a * b * c, or -1 if not found
	 * @see ProjectEuler009 Example
	 */
	public long solve(final long sum){
		long tempSum = 0;
		
		//Pseudo-infinte loop.
		for(int m = 2; m < Integer.MAX_VALUE; m++){
			//Constraint "m − n is odd", set n accordingly and increment by 2
			for(int n = (m % 2 == 0) ? 1 : 2; n < m; n += 2){	
				long a = (m * m) - (n * n);
				long b = 2 * m * n;
				long c = (m * m) + (n * n);
				
				tempSum = a + b + c;
				
				//Found the Triple
				if(tempSum == sum){ 
					return a * b * c;
				}
				//Checked all possible Pythagorean Triples
				if(tempSum > sum && n < 3){
					return -1;
				}
			}
		}
		
	    return -1;
	}
	
	public List<PythTriplet> getTriplets(final int amount){
		int counter = 0;
		List<PythTriplet> pyth = new ArrayList<PythTriplet>(amount);
		
		//Pseudo-infinite loop; exit condition is arbitrary therefore it is handled in inner loop
		outerloop:
		for(int m = 2; m < Integer.MAX_VALUE; m++){
			//Constraint "m − n is odd", set n accordingly and increment by 2
			for(int n = (m % 2 == 0) ? 1 : 2; n < m; n += 2){	
				long a = (m * m) - (n * n);
				long b = 2 * m * n;
				long c = (m * m) + (n * n);
				pyth.add(new PythTriplet(a, b, c));
				//Break to return statement
				if(++counter == amount){ break outerloop; }
			}
		}	
		
		return pyth;
	}

	public class PythTriplet{
		private long a, b, c;
		
		public PythTriplet(long a, long b, long c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public long getProduct(){
			return a * b * c;
		}
		
		public long getSum(){
			return a + b + c;
		}
		
		public String toString(){
			String s = String.format("(a,b,c): (%d,%d,%d)%nSum: %d%nProduct: %d%n", a, b, c, getSum(), getProduct());
			return s;
		}

		public long getA() {
			return a;
		}

		public long getB() {
			return b;
		}

		public long getC() {
			return c;
		}
	}
}
