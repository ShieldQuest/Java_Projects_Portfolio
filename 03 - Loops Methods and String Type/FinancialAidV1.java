/*
 * Author: COP2551C
 * Date: 9-16-25
 * Description: this program prompts the user to enter annual income and 
 *              family size of a student, then determine eligibility for 
 *              financial aid based on the following criteria:
 *              a student is eligible for financial aid if annual income is 15k 
 *              or less AND family size is 3 or more.
 */
package financialAidV1;
//imports:
import java.util.Scanner;

public class FinancialAidV1 
{

	public static void main(String[] args) 
	{
		 //declarations:
			//object: student
			double annualIncome = 0.0;
			int familySize      = 0;
			//working variables:
			Scanner get = new Scanner(System.in);
			int answer = 1;
		//process:
			while(answer == 1)
			{
				//input:
				System.out.println("Enter annual income: $");
				annualIncome = get.nextDouble();
				System.out.println("Enter family size: ");
				familySize = get.nextInt();
				//evaluate and report
				if(annualIncome <= 15000.00 && familySize >= 3)
					System.out.println("Eligible!");
				else
					System.out.println("NOT Eligible!");
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
