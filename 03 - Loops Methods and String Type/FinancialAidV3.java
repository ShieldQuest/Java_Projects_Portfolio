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
 *              A problem exists when attempting to enter data for the second student
 */
package FinancialAidV3;
//imports:
import java.util.Scanner;

public class FinancialAidV3
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
		//process:
			while(answer == 1)
			{
				//input:
				System.out.println("Enter full name: ");
				name = get.nextLine();//.nextLine will accept a set of chars
				                      //then a new line char is appended to the end = Enter key code
				System.out.println("Enter annual income: $");
				annualIncome = get.nextDouble();
				System.out.println("Enter family size: ");
				familySize = get.nextInt();
				System.out.println("Is the student a VET? 1 for yes or 0 for no: ");
				VET = get.nextInt();  //this input, will cause a new line char
				                      //to persist in the buffer. this char will
				                      //overflow into name causing the input
				                      //for name to be skipped!
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
				answer = get.nextInt();
				while(answer != 1 && answer != 0)
				{
					System.out.println("Wrong answer! re-enter 1 for yes or 0 for no: ");
					answer = get.nextInt();
				}//end while(answer != 1 && answer != 0)
				
			}//end while(answer == 1)
			//goodbye:
			System.out.println("Goodbye!");
			//closing the scanner:
			get.close();
	}//end main
}//end class FinancialAidV1
