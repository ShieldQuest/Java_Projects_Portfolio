/*
 * Author: COP2551
 * Date: 10-14-25
 * Description:  this program will access a string containing different type
 *               of characters and identify each (digit, letter, space, special symbol)
 *               using a primitive approach.
 */
package string;

public class StringManip 
{

	public static void main(java.lang.String[] args) 
	{
		 String s = "Ab  /; 76  x+@";
		 System.out.println("s = " + s);
		 System.out.println("The length of s1 is: " + s.length());
		 //let's identify every char inside s:
		 for(int i = 0; i < s.length(); i++)
			 if(Character.isDigit(s.charAt(i)))
				 System.out.println("Char at position " + i + " is a digit!");
			 else
				 if(Character.isLetter(s.charAt(i)))
					 System.out.println("Char at position " + i + " is a letter!");
				 else
					 if(Character.isWhitespace(s.charAt(i)))
						 System.out.println("Char at position " + i + " is a space!");
					 else
						 System.out.println("Char at position " + i + " is a special symbol!");		
	}//end main
}//end class String
