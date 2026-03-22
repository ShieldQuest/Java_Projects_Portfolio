/*
 * Author: COP2551
 * Date: 10-7-25
 * Description:                                  
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class PayrollObjectV1 
{
	//declarations:
	static Employee [] emp = new Employee[100];//an array of objects 
	//working vars:
	static String input = " ";
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) 
	{
		 //declarations:
		
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
			case 1: emp[empCount] = new Employee();//an instance of an employee
				    emp[empCount].getSSN();// . is a membership dot
				    emp[empCount].getFirst();
				    emp[empCount].getLast();
				    emp[empCount].getRate();
				    emp[empCount].getHours();
				    emp[empCount].calcGross();
					empCount++;
				    break;
			case 2: for(int i = 0; i < empCount; ++i)
						emp[i].dispReport();
				    break;
			case 3: System.out.println("Enter the SSN to search for: ");
					input = get.nextLine();
					searchSSN = input;
					foundAt = searchEmployee(searchSSN, empCount); //where, what, into how many
				    if(foundAt == -1)
				    		System.out.println(searchSSN + " was not found!");
				    else
				    		emp[foundAt].dispReport();
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
		public static int searchEmployee(String searchSSN, int empCount)
		{
			int i = 0;
			while(i < empCount)
			{
				//if(searchSSN == ssn[i])//the '=='will not work in this context
					                   //you are comparing addresses instead of content
				if(searchSSN.equals(emp[i].ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchEmployee
		//==================================
}//end class PayrollObjectV1
//-------------------------------------------
class Employee
{
	//declarations:
		//object: employee
		String ssn;
		String first;
		String last;
		double rate;
		int    hours;
		double gross;
		//working variables:
		Scanner get = new Scanner(System.in);
		DecimalFormat DF = new DecimalFormat("#####0.00");
		String input = " ";
	//constructors:
		Employee()
		{
			ssn   = " ";
			first = " ";
			last  = " ";
			rate  = 0.0;
			hours = 0;
			gross = 0.0;
		}//end constructor w/o arguments
		Employee(String ssn, String first, String last, double rate, int hours)
		{
			this.ssn   = ssn;
			this.first = first;
			this.last  = last;
			this.rate  = rate;
			this.hours = hours;	 
		}//end constructor w/ arguments
		//================================methods==========================
		void getSSN()
		{
			System.out.println("Enter this employee SSN: ");
			input = get.nextLine();
			ssn = input;
		}//end getSSN
		//==============================
		void getFirst()
		{
			System.out.println("Enter this employee first name: ");
			input = get.nextLine();
			first = input;
		}//end getFirst
		//==============================
		void getLast()
		{
			System.out.println("Enter this employee last name: ");
			input = get.nextLine();
			last = input;
		}//end getLast()
		//===============================
		void getRate()
		{
			System.out.println("Enter this employee hourly rate: $");
			input = get.nextLine();
			rate = Double.parseDouble(input);
		}//end getRate()
		//===============================
		void getHours()
		{
			System.out.println("Enter this employee hours worked: ");
			input = get.nextLine();
			hours = Integer.parseInt(input);
		}//end getHours
		//==============end input=========
		//================================
		void calcGross()
		{
			gross = rate * hours;
		}//end calcGross
		//================================
		void dispReport()
		{
			System.out.println("Employee ssn         : "  + ssn   + "\n" + 
		                       "         first name  : "  + first + "\n" +
		                       "         last name   : "  + last  + "\n" +
					           "         hourly rate : $" + rate  + "\n" + 
		                       "         hours worked: "  + hours + "\n" +
					           "         gross salary: $" + DF.format(gross));
		}//end dispreport()
		//================================
}
