/*
 * Author: COP2551
 * Date: 10-14-25
 * Description:  this program demonstrates that a string cannot be treated as an array
 *               for the purpose of access to its individual chars.
 *               s1[i] will not work.
 *               s1.charAt(i) will.
 *
 */
package string;

public class StringProcess 
{

	public static void main(java.lang.String[] args) 
	{
		String s1 = "qwerty"; //is this an array of chars? no it is not!
		//if it is this will work:
		/*
		for(int i = 0; i < s1.length(); i++)
			System.out.println("char at position " + i + " is " + s1[i]);
		//that did not work a string is NOT an array
		///*/
		//let's now code the correct method that access the string char by char
		for(int i = 0; i < s1.length(); i++)
			System.out.println("char at position " + i + " is " + s1.charAt(i));
			
		

	}//end main

}//end class String
