/*
 * Author: COP2551C
 * Date: 9-16-25
 * Description: this program prompts the user to enter annual income and 
 *              family size of a student, then determine eligibility for 
 *              financial aid based on the following criteria:
 *              a student is eligible for financial aid if annual income is 15k 
 *              or less AND family size is 3 or more OR the student is a VET
 *              In this version, we will prompt the user to enter the student
 *              first and last name in a single input.
 *             
				In this version, we will adopt a different approach
				for all our input. This program uses an input buffer of type
				'String' via which all input will be channeled.
				String to String: no conversion/parsing (eg. name)
				String to double: parse as double (eg. income)
				String to int   : parse as int (size, VET, and answer)
 */
package FinancialAidV5;
//imports:
import java.util.Scanner;

public class FinancialAidV5
{

	public static void main(String[] args) 
	{
		 //declarations:
			//object: student
			String name         = " ";
			double annualIncome = 0.0;
			int familySize      = 0;
			int VET             = 0; //0 for no or 1 for yes
			//working variables:
			Scanner get = new Scanner(System.in);
			int answer = 1;
			String input = " ";//this memory will be used for all input
		//process:
			while(answer == 1)
			{
				//input:
				System.out.println("Enter full name: ");
				input = get.nextLine(); 
				name = input; //string to string no need for parsing
				System.out.println("Enter annual income: $");
				input = get.nextLine();
				annualIncome = Double.parseDouble(input);//'converting' or parsing
				                                         //the content of input into a double
				System.out.println("Enter family size: ");
				input = get.nextLine();
				familySize = Integer.parseInt(input);//parsing content of input into an int
				System.out.println("Is the student a VET? 1 for yes or 0 for no: ");
				input = get.nextLine();
				VET = Integer.parseInt(input);;   
				//report and evaluate
				System.out.println("Full Name   : "  + name         + "\n" +
				                  "Annual Salary: $" + annualIncome + "\n" +
						          "Family Size  : "  + familySize);
				if(annualIncome <= 15000.00 && familySize >= 3 || VET == 1)
					//evaluated as if((annualIncome <= 15000.00 && familySize >= 3) || VET == 1)
					System.out.println("Decision: Eligible!");
				else
					System.out.println("Decision: NOT Eligible!");
				//continue?
				System.out.println("Continue? 1 for yes or 0 for no: ");
				input = get.nextLine();
				answer = Integer.parseInt(input);
				while(answer != 1 && answer != 0)
				{
					System.out.println("Wrong answer! re-enter 1 for yes or 0 for no: ");
					input = get.nextLine();
					answer = Integer.parseInt(input);
				}//end while(answer != 1 && answer != 0)
				
			}//end while(answer == 1)
			//goodbye:
			System.out.println("Goodbye!");
			//closing the scanner:
			get.close();
	}//end main
}//end class FinancialAidV1
