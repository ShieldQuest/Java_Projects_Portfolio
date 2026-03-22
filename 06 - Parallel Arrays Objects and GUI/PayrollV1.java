/*
 * Author: COP2551
 * Date: 10-7-25
 * Description: this program processes a payroll for a max of
 *              100 employees. The employees will be stored
 *              in a set of parallel arrays.
 *              This program implements a menu of options:
 *              -1-Add an employee
 *              -2-Display all employees
 *              -3-Search for an employee
 *              -4-Quit program
 */
package payrollv1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PayrollV1 
{
	//'global' vars:
	static Scanner get = new Scanner(System.in);
	static DecimalFormat DF = new DecimalFormat("#####0.00");
	static String input = " ";
	public static void main(String[] args) 
	{
		 //declarations:
			//object: employee
			String [] ssn   = new String[100];
			String [] first = new String[100];
			String [] last  = new String[100];
			double [] rate  = new double[100];
			int    [] hours = new int[100];
			double [] gross = new double[100];
			//working variables:
			int choice = 0;
			int empCount = 0;//used to keep track of the employee
			                 //currently processed and the total employees
			String searchSSN = " ";
			int foundAt      = -1; //-1 means not found
		//processes:
		while(choice != 4)
		{
			choice = menu();
			switch(choice)
			{
				case 1: getSSN(ssn, empCount);
						getFirst(first, empCount);
						getLast(last, empCount);
						getRate(rate, empCount);
						getHours(hours, empCount);
						calcGross(rate, hours, gross, empCount);
						empCount++;
					    break;
				case 2: for(int i = 0; i < empCount; ++i)
							dispReport(ssn, first, last, rate, hours, gross, i);
					    break;
				case 3: System.out.println("Enter the SSN to search for: ");
						input = get.nextLine();
						searchSSN = input;
						foundAt = searchEmployee(ssn, searchSSN, empCount); //where, what, into how many
					    if(foundAt == -1)
					    		System.out.println(searchSSN + " was not found!");
					    else
					    		dispReport(ssn, first, last, rate, hours, gross, foundAt);
						break;
				case 4: System.out.println("Goodbye!");
						break;
				default: System.out.println("Wrong choice...please try again...");
			}
		}//end while(choice != 4)
	}//end main
	//=============================
	public static int menu()
	{
		int choice = 0;
		System.out.println("-1-Add employee\n" +
		                   "-2-Display all employees\n" +
				           "-3-Search for an employee\n" +
		                   "-4-Quit\n" + 
				           "\tEnter choice 1-4: ");
		input = get.nextLine();
		choice = Integer.parseInt(input);
		return choice;
	}//end menu
	//==============================
	//===========input methods======
	public static void getSSN(String [] ssn, int current)
	{
		System.out.println("Enter this employee SSN: ");
		input = get.nextLine();
		ssn[current] = input;
	}//end getSSN
	//==============================
	public static void getFirst(String [] first, int current)
	{
		System.out.println("Enter this employee first name: ");
		input = get.nextLine();
		first[current] = input;
	}//end getFirst
	//==============================
	public static void getLast(String [] last, int current)
	{
		System.out.println("Enter this employee last name: ");
		input = get.nextLine();
		last[current] = input;
	}//end getLast()
	//===============================
	public static void getRate(double [] rate, int current)
	{
		System.out.println("Enter this employee hourly rate: $");
		input = get.nextLine();
		rate[current] = Double.parseDouble(input);
	}//end getRate()
	//===============================
	public static void getHours(int [] hours, int current)
	{
		System.out.println("Enter this employee hours worked: ");
		input = get.nextLine();
		hours[current] = Integer.parseInt(input);
	}//end getHours
	//==============end input=========
	//================================
	public static void calcGross(double [] rate, int [] hours, 
			                    double [] gross, int current)
	{
		gross[current] = rate[current] * hours[current];
	}//end calcGross
	//================================
	public static void dispReport(String [] ssn, String [] first, String [] last,
			                      double [] rate, int [] hours, double [] gross, int current)
	{
		System.out.println("Employee ssn         : "  + ssn[current]   + "\n" + 
	                       "         first name  : "  + first[current] + "\n" +
	                       "         last name   : "  + last[current]  + "\n" +
				           "         hourly rate : $" + rate[current]  + "\n" + 
	                       "         hours worked: "  + hours[current] + "\n" +
				           "         gross salary: $" + DF.format(gross[current]));
	}//end dispreport()
	//================================
	public static int searchEmployee(String [] ssn, String searchSSN, int empCount)
	{
		int i = 0;
		while(i < empCount)
		{
			//if(searchSSN == ssn[i])//the '=='will not work in this context
				                   //you are comparing addresses instead of content
			if(searchSSN.equals(ssn[i]))
				return i;
			else
				++i;//keep searching
		}//end while(i < empCount)
		return -1; //to mean not found
	}//end searchEmployee
	//==================================
}//end class Payroll
