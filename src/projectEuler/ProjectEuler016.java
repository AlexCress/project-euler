package projectEuler;

import java.math.BigInteger;


/**
 * Challenge:<p>
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.<p>
 * What is the sum of the digits of the number 2^1000?
 * @author Alex
 *
 */
public class ProjectEuler016 {
	
	//Used for optimization- don't have to create new BigInteger each loop
	public enum BigIntegerConstant{
		ZERO(BigInteger.ZERO),
		ONE(BigInteger.ONE),
		TWO(new BigInteger("2")),
		THREE(new BigInteger("3")),
		FOUR(new BigInteger("4")),
		FIVE(new BigInteger("5")),
		SIX(new BigInteger("6")),
		SEVEN(new BigInteger("7")),
		EIGHT(new BigInteger("8")),
		NINE(new BigInteger("9"));
		
		private BigInteger value;
		
		private BigIntegerConstant(BigInteger i){
			this.value = i;
		}
		
		public BigInteger getValue(){
			return this.value;
		}

	}

	/**
	 * Calculates 2 ^ <code>exponent</code> and returns
	 * the sum of all its digits.
	 * @param exponent - a positive <code>int</code>
	 * @return a <code>BigInteger</code> sum of all the digits
	 */
	public BigInteger solve(final int base, final int exponent){
		
		final BigInteger BASE = new BigInteger(Integer.toString(base));
		
		BigInteger product = BASE;
		BigInteger sum = new BigInteger("0");
		
		//Manually find BASE ^ EXPONENT
		//Start at 1 because product already set to base
		for(int i = 1; i < exponent; i++){
			product = product.multiply(BASE);
		}
		
		//Convert for manipulation purposes
		String prod = product.toString();
		
		//Find sum
		for(int i = 0; i < prod.length(); i++){
			BigInteger n = matchConstant(Character.valueOf(prod.charAt(i)));
			sum = sum.add(n);
		}
		
		return sum;
	}
	
	private BigInteger matchConstant(char c){
		switch(c){
		case '1':
			return BigInteger.ONE;
		case '2':
			return BigIntegerConstant.TWO.getValue();
		case '3':
			return BigIntegerConstant.THREE.getValue();
		case '4':
			return BigIntegerConstant.FOUR.getValue();
		case '5':
			return BigIntegerConstant.FIVE.getValue();
		case '6':
			return BigIntegerConstant.SIX.getValue();
		case '7':
			return BigIntegerConstant.SEVEN.getValue();
		case '8':
			return BigIntegerConstant.EIGHT.getValue();
		case '9':
			return BigIntegerConstant.NINE.getValue();
		default:
			return BigInteger.ZERO;
		}
	}
}
