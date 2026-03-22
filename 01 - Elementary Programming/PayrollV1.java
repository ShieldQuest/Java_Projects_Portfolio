/*
	Author: COP2551C
	Date: 9-2-25
	Description: this program prompts the user to input
             hourly rate and hours worked, then computer
             the gross salary.
*/
package payrollV1;
//Imports:
import java.util.Scanner;

public class PayrollV1 
{

	public static void main(String[] args) 
	{
		//declarations:
			//Object: employee and payroll
				double HourlyRate  = 0.0;
				double HoursWorked = 0.0;
				double GrossSalary = 0.0;
			//working variables:
				Scanner get = new Scanner(System.in);
		//input:
			System.out.println("Enter hourly rate: $");
			HourlyRate = get.nextDouble();
			System.out.println("Enter hours worked: ");
			HoursWorked = get.nextDouble();
		//calculations:
			GrossSalary = HourlyRate * HoursWorked;
		//output:
			System.out.println("Hourly Rate : $"  + HourlyRate  + "\n" +
		                       "Hours Worked: "   + HoursWorked + "\n" +
							   "Gross salary: $ " + GrossSalary);
		//closing the scanner:
			get.close();
	}//end main

}//end class PayrollV1
