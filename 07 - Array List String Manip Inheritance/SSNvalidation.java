/*
 * Author: COP2551
 * Date: 10-14-25
 * Description:  this program validate the user input for SSN: 9 digits
 */
package ssnvalidation;

import javax.swing.JOptionPane;

public class SSNvalidation 
{
	//'global declarations:
	static String input = " ";
	public static void main(String[] args) 
	{
		 //declarations:
		String ssn = " ";
		//input:
		input = getSSN();
		ssn = input;
		JOptionPane.showMessageDialog(null,  "You have entered a valid ssn: " + ssn);
	}//end main
	//=================================
	public static String getSSN()
	{
		boolean validSSN = false;
		input = JOptionPane.showInputDialog("Enter SSN: ");
		validSSN = checkSSN(input);
		while(validSSN == false)
		{
			input = JOptionPane.showInputDialog("Invalid SSN! re-Enter SSN: ");
			validSSN = checkSSN(input);
		}//end while...
		return input;
	}//end getSSN
	//===================================
	public static boolean checkSSN(String input)
	{
		if(input.length() != 9)
			return false; //non valid length must be 9
		else
			for(int i = 0; i < input.length(); i++)
				if(Character.isDigit(input.charAt(i)) == false)
					return false;
		return true;
	}//end checkSSN()
	//====================================
}//end SSNvalidation
