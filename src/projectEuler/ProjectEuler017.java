package projectEuler;

import java.util.HashMap;
import java.util.Map;

/**
 * Challenge:<p>
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, 
 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.<p>

 * If all the numbers from 1 to 1000 (one thousand) inclusive were written 
 * out in words, how many letters would be used?<p>

 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use 
 * of "and" when writing out numbers is in compliance with British usage.
 * @author Alex
 *
 */

public class ProjectEuler017 {
	
	/**
	 * Holds the words that correspond to various numbers. Numbers found in this map:<p>
	 * 
	 * 1 <= n <= 19<br>
	 * n = 10 * i where 2 <= i <= 9 (20, 30... 90)<p>
	 * 
	 * It is necessary to break the number apart accordingly before looking in the table,
	 * however you can build any number by simply appending the proper affix.<br>
	 * Example: 1,234,567 can be broken into [one] million [two] hundred [thirty][four] thousand
	 * [five] hundred and [sixty][seven].<p>
	 * 
	 * <b>Note:</b> this creates an anonymous subclass of HashMap and any sideffects should be
	 * noted before using this class. Notably, any equals() operations will always fail. You
	 * will also serialize both the inner and outer classes.
	 * 
	 * @see http://www.c2.com/cgi/wiki?DoubleBraceInitialization
	 */
	public static Map<Integer, String> WORD_MAP = new HashMap<Integer, String>(){{
		put(0, "");
		put(1, "one");
		put(2, "two");
		put(3, "three");
		put(4, "four");
		put(5, "five");
		put(6, "six");
		put(7, "seven");
		put(8, "eight");
		put(9, "nine");
		put(10, "ten");
		put(11, "eleven");
		put(12, "twelve");
		put(13, "thirteen");
		put(14, "fourteen");
		put(15, "fifteen");
		put(16, "sixteen");
		put(17, "seventeen");
		put(18, "eighteen");
		put(19, "nineteen");
		put(20, "twenty");
		put(30, "thirty");
		put(40, "forty"); //I learned that "forty" is not spelled "fourty". My entire life is a lie.
		put(50, "fifty");
		put(60, "sixty");
		put(70,"seventy");
		put(80,"eighty");
		put(90,"ninety");
	}};
	
	public long solve(final int floor, final int ceiling){
		
		long length = 0;
		
		for(int i = floor; i <= ceiling; i++){
			String phrase = getPhrase(i);
			
			for(int j = 0; j < phrase.length(); j++){
				if( !(Character.isWhitespace(phrase.charAt(j)))){
					length++;
				}
			}
		}
		
		return length;
	}
	
	/**
	 * Returns the English phrase for the given <code>number</code>.<br>
	 * For example, 14552 becomes "fourteen thousand five hundred and fifty two".
	 * 
	 * @param number - a positive integer value
	 * @return a String representation of the <code>number</code> 
	 * written in English
	 */
	public String getPhrase(final int number){
		
		//Preliminary checks
		if(number < 1){
			return null;
		}
		else if(number < 20){
			return getWord(number);
		}
		
		//The returned phrase
		StringBuilder phrase = new StringBuilder();
		
		//Put number into array backwards (starting at ones)
		String ns = Long.toString(number);
		int[] numberArray = new int[ns.length()];
		
		for(int i = numberArray.length - 1, j = 0; i >= 0; i--, j++){
			numberArray[j] = Character.getNumericValue(ns.charAt(i));
		}
		
		//Build string
		//All inserts follow the rule that they leave trailing whitespace, 
		//otherwise formatting breaks
		for(int i = 0; i < numberArray.length; i++){
			
			//Insert "and" only after the hundreds position
			//unless tens and ones are 0 then do not add
			if(i == 2 && phrase.length() > 0){
				phrase.insert(0, "and ");
			}
			
			//Skip if zero
			if(numberArray[i] != 0){

				//Ones position
				if(i % 3 == 0){
					if(i == 3){ phrase.insert(0, "thousand "); }
					else if(i == 6){ phrase.insert(0, "million "); }
					else if(i == 9){ phrase.insert(0, "billion "); }
					//Can add more... currently int will not be able to handle it regardless
					
					//If this is the last digit, no need to check for 2-digit pronunciation (10 to 19)
					if(i + 1 >= numberArray.length){
						phrase.insert(0, getWord(numberArray[i]) + " ");
					}
					//Otherwise increment i so the following Tens position check will succeed
					//Will analyze both digits so that proper pronunciation is output
					else{			
						i++;	
					}
				}
				
				//Tens position
				if((i - 1) % 3 == 0){
					//Check for special case 1 <= n <= 19
					if(numberArray[i] == 1 || numberArray[i] == 0){
						//Concatenate digits and truncate leading zero
						String s = (numberArray[i]) + "" + (numberArray[i-1]);
						phrase.insert(0, getWord(Integer.parseInt(s)) + " ");
					}
					//Otherwise get the words for both digits and insert them (21 becomes twenty one)
					else{
						phrase.insert(0, getWord(numberArray[i] * 10) + " " + getWord(numberArray[i - 1]) + " ");
					}				
				}
				//Hundreds
				else if((i - 2) % 3 == 0){
					phrase.insert(0, getWord(numberArray[i]) + " hundred ");
				}
			}
			
		}
		
		return phrase.toString();
	}
	
	/**
	 * Returns the string representation of the given 
	 * <code>number</code>. Ensure that only valid input 
	 * is given to this method, see {@link #WORD_MAP} 
	 * for specifications.
	 * @param number - positive integer >= 1 to
	 * be converted to word.
	 * @return an English String representation of <code>number</code>
	 * 
	 */
	private String getWord(final int number){		
		String word = WORD_MAP.get(number);
		
		return word;
	}
}
