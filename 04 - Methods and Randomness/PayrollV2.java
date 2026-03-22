/*
 * Author: COP2220
 * Date: 9-23-25
 * Description: this is a payroll program. this program implements all payroll
 * 				related processes as modules/methods.
 */
package payrollV2;
//imports:
import java.text.DecimalFormat;
import java.util.Scanner;

public class PayrollV2 
{
	//'global' variables 
			//object: employee
			static String SSN         = " ";
			static String firstName   = " ";
			static String lastName    = " ";
			static double hourlyRate  = 0.0;
			static int    hoursWorked = 0;
			static double grossSalary = 0.0;
			//working vars:
			static Scanner get = new Scanner(System.in);
			static DecimalFormat DF = new DecimalFormat("#####0.00");//if zero, value will be 0.00
			static String input = " ";//available everywhere we process an input
	//======================================
	public static void main(String[] args) 
	{
		 //declarations:
			
			//working variables:
			int answer = 1;
		//processes:
		while(answer == 1)
		{
			//input:
			getSSN();
			getFirstName();
			getLastName();
			getHourlyRate();
			getHoursWorked();
			//calculations:
		    calcGrossSalary(); 
			//report:
			dispReport();
			//continue?
			System.out.println("Process another employee? 1 for yes or 0 for no: ");
			input = get.nextLine();
			answer = Integer.parseInt(input);
			while(answer != 1 && answer != 0)
			{
				System.out.println("Wrong answer! re-enter 1 for yes or 0 for no: ");
				input = get.nextLine();
				answer = Integer.parseInt(input);
			}//end while(answer != 1 && answer != 0)
		}//end while(answer == 1)
		System.out.println("\nGoodbye!");
	}//end main
	//======================================
	public static void getSSN()
	{
		System.out.println("Enter SSN: ");
		input = get.nextLine();
		SSN = input;
	}//end getSSN
	//======================================
	public static void getFirstName()
	{
		System.out.println("Enter First Name: ");
		input = get.nextLine();
		firstName = input;
	}//end getFirstName
	//======================================
	public static void getLastName()
	{
		System.out.println("Enter Last Name: ");
		input = get.nextLine();
		lastName = input;
	}//end getLastName
	//======================================
	public static void getHourlyRate()
	{
		System.out.println("Enter HourlyRate: $");
		input = get.nextLine();
		hourlyRate = Double.parseDouble(input);
	}//end getHourlyRate
	//======================================
	public static void getHoursWorked()
	{
		System.out.println("Enter Hours Worked: ");
		input = get.nextLine();
		hoursWorked = Integer.parseInt(input);
	}//end getHoursWorked
	//=======================================
	public static void calcGrossSalary()
	{
		grossSalary = hourlyRate * hoursWorked;
	}//end calcGrosssalary
	//=======================================
	public static void dispReport()
	{
		System.out.println("Employee SSN         : "  + SSN         + "\n" + 
	                       "         First Name  : "  + firstName   + "\n" +
				           "         Last Name   : "  + lastName    + "\n" +
	                       "         Hourly Rate : $" + hourlyRate  + "\n" +
				           "         Hours Worked: "  + hoursWorked + "\n" +
	                       "         Gross Salary: $" + DF.format(grossSalary));
	}//end dispReport
	//=======================================
}//end class PayrollV1
