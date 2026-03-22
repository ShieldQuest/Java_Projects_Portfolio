/*
 * Author: COP2551C
 * Date: 2-18-25
 * Description:      
 * 
 */
package payrollListComparable;
//imports:
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class PayrollListComparable
{
	//global access vars:
		//Object: employee
	        //list of objects/employees:
	        static ArrayList<comparableEmployee> empList = new ArrayList<comparableEmployee>();
	        //limited by available memory
		//working vars:
			static DecimalFormat DF = new DecimalFormat("###0.00");
			static String input     = " ";
	//======================================================
	public static void main(String[] args) 
	{
		//declarations:
			//working variables:
				int option       = 0;
				String searchSSN = " ";
				int foundAt      = -1; //-1 not found
		//processes:
		while(option != 4)
		{
			option = menu();
			switch(option)
			{
				case 1: addEmployee();
				        break;
				case 2: if(empList.isEmpty())
							JOptionPane.showMessageDialog(null, "Database is empty!");
						else
							dispAllEmployees();
				        break;
				case 3: if(empList.isEmpty())
							JOptionPane.showMessageDialog(null, "Database is empty!");
						else
						{
							//let's sort the objects in ascending order by ssn:
							sortEmployees();
							input = JOptionPane.showInputDialog("Enter the SSN to search for: ");
						//validate: 9 digits
						searchSSN = input;
						foundAt = searchEmployee(searchSSN);
						if(foundAt == -1)
							JOptionPane.showMessageDialog(null, searchSSN + " was not found!");
						else
							empList.get(foundAt).dispReport();
						}//end else if if(empCount == 0)
						break;
				case 4: JOptionPane.showMessageDialog(null, "Goodbye!");
				        break;
				default: JOptionPane.showMessageDialog(null, "Wrong option!");		
			}//end switch(option)
		}//end while)option 1= 4)
		//closing the Scanner:
	}//end main
	//==============================================================
	public static int menu()
	{
		int option = 0;
		input = JOptionPane.showInputDialog("-1-Add employee\n"           +
		                                    "-2-Display all employees\n"  +
				                            "-3-Search for an employee\n" +
		                                    "-4-Quit program\n"           +
				                            "\t\tEnter option 1-4: ");
		//validate: digit only
		option = Integer.parseInt(input);
		return option;
	}//end menu
	//==============================================================
	public static void addEmployee()
	{
		/*comparableEmployee emp = new comparableEmployee();
		emp.getSSN();
		emp.getFirst();
		emp.getLast();
		emp.getRate();
		emp.getHours();
		emp.calcGross();*/
		JOptionPane.showMessageDialog(null,"Hit ok to load 3 hard coded employees...");
		comparableEmployee emp = new comparableEmployee("333", "Naj", "Say", 12.34, 44);
		empList.add(emp); //just added a new employee to the list
		                  emp = new comparableEmployee("222", "Dan", "Loyd", 11.59, 40);
		empList.add(emp); //just added a new employee to the list
		                  emp = new comparableEmployee("111", "Michelle", "Liang", 56.78, 20);
		empList.add(emp); //just added a new employee to the list
	}//end addEmployye
	//==============================================================
	public static void dispAllEmployees()
	{
		for(int i = 0; i < empList.size(); i++)
			empList.get(i).dispReport();
	}//end dispAllEmployees
	//==============================================================
	public static void sortEmployees()
	{
		Collections.sort(empList);//sort in ascending order by ssn
		dispAllEmployees();
	}//end sortEmployees
	//===============================================================
	public static int searchEmployee(String searchSSN)//this method return the position of the match
	{
		comparableEmployee comparableSearchEmployee 
		           = new comparableEmployee(searchSSN, " ", " ", 0.0, 0);
		int foundAt = Collections.binarySearch(empList, comparableSearchEmployee);
		return foundAt;
	}//end searchEmployee
}//end class PayrollV1
//=============================================
class Employee
{
	//declarations:
		//attributes: object = employee
			String ssn;
			String first;
			String last;
			double rate;
			int    hours;
			double gross;
		//working variables:
			DecimalFormat DF = new DecimalFormat("###0.00");
			String input     = " ";
			
	//constructors:
	Employee()
	{
		ssn   = " ";
		first = " ";
		last  = " ";
		rate  = 0.0;
		hours = 0;
		gross = 0.0;
	}//const. w/o arguments
	Employee(String ssn, String first, String last, double rate, int hours)
	{
		this.ssn   = ssn;
		this.first = first;
		this.last  = last;
		this.rate  = rate;
		this.hours = hours;	
	}//end const. w/ arguments
			
	//methods: methods that act on a single specific employee
	//==========================================================
	void getSSN()
	{
		input = JOptionPane.showInputDialog("Enter this employee SSN: ");
		//validate: 9 digits
		ssn = input; //no parsing needed : string to string
	}//end getSSN()
	//==========================================================	
	void getFirst()
	{
		input = JOptionPane.showInputDialog("Enter this employee first name: ");
		//validate: letters and spaces only
		first = input; //no parsing needed : string to string
	}//end getFirst()
	//==========================================================
	void getLast()
	{
		input = JOptionPane.showInputDialog("Enter this employee last name: ");
		//validate: letters and spaces only
		last = input; //no parsing needed : string to string
	}//end getLast()
	//===========================================================
	void getRate()
	{
		input = JOptionPane.showInputDialog("Enter this employee hourly rate: ");
		//validate: format ###.## all digits and a decimal point
		rate = Double.parseDouble(input); //parsing the content of input as double : String to Double
	}//end getRate
	//============================================================
	void getHours() 
	{
		input = JOptionPane.showInputDialog("Enter this employee hours worked: ");
		//validate: all digits
		hours = Integer.parseInt(input); //parsing string to int for hours
	}//end getHours
	//=============================================================
	void calcGross()
	{
		gross = rate * hours;  
	}//end calcGross
	//=============================================================	
	void dispReport()
	{
		JOptionPane.showMessageDialog(null, "Employee SSN         : "  + ssn   + "\n" +
				 		   "         First Name  : "  + first + "\n" +
				 		   "         Last  Name  : "  + last  + "\n" +
                           "         Hourly Rate : $" + rate  + "\n" +
		                   "         Hours Worked: "  + hours + "\n" +
                           "         Gross Salary: $" + DF.format(gross));
	}//end dispReport
	//=============================================================	
}//end class Employee
//__________________________the comparable class for sorting__________________
class comparableEmployee extends Employee implements Comparable <comparableEmployee>
{
	comparableEmployee()
	{
		super();
	}//end const. w/o arguments
	comparableEmployee(String ssn, String first, String last, double rate, int hours)
	{
		super(ssn, first, last, rate, hours);
	}//end const. w/ arguments
	//comparing methods:
	@Override
	public int compareTo(comparableEmployee o)
	{
		int r = ssn.compareTo(o.ssn);
		return r;
	}//end compareTo
}//end class comparableEmployee
//_____________________________________________________________________________
 
