/*
 * Author: COP2551C
 * Date: 2-18-25
 * Description:      
 * 
 */
/*
 * TO DO:
 * -implement the Comparable class with the payroll with inheritance and 
 * file write/read
 */
 
//imports:
package payrollArrayComparable;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class PayrollArrayComparable
{
	//global access vars:
		//Object: employee
	        //array of objects/employees:
	        static comparableEmployee [] empArray = new comparableEmployee[3];
	        //when I had 100 and loaded only 3 the remaining pointers to all remianing 
	        //empty entries are all NULL ..pointing to no object ...yet!
	        //sort will not work as we are asking it to process NULL poinetrs
	        //limited by available memory
		//working vars:
			static DecimalFormat DF = new DecimalFormat("###0.00");
			static String input     = " ";
			static int empCount = 0;
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
						empCount++;
				        break;
				case 2: if(empCount == 0)
							JOptionPane.showMessageDialog(null, "Database is empty!");
						else
							dispAllEmployees();
				        break;
				case 3: if(empCount == 0)
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
							empArray[foundAt].dispReport();
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
		/*empArray[empCount] = new comparableEmployee();
		empArray[empCount].getSSN();
		empArray[empCount].getFirst();
		empArray[empCount].getLast();
		empArray[empCount].getRate();
		empArray[empCount].getHours();
		empArray[empCount].calcGross(); */
		JOptionPane.showMessageDialog(null,"Hit ok to load 3 hard coded employees...");
		empArray[empCount] = new comparableEmployee("333", "Naj", "Say", 12.34, 44); 
		empCount++;
		empArray[empCount] = new comparableEmployee("222", "Dan", "Loyd", 11.59, 40);
		empCount++;
		empArray[empCount] = new comparableEmployee("111", "Michelle", "Liang", 56.78, 20); 
	}//end addEmployye
	//==============================================================
	public static void dispAllEmployees()
	{
		for(int i = 0; i < empCount; i++)
			empArray[i].dispReport();
	}//end dispAllEmployees
	//==============================================================
	public static void sortEmployees()
	{
		Arrays.sort(empArray);//sort in ascending order by ssn
		dispAllEmployees();
	}//end sortEmployees
	//===============================================================
	public static int searchEmployee(String searchSSN)//this method return the position of the match
	{
		comparableEmployee comparableSearchEmployee 
		           = new comparableEmployee(searchSSN, " ", " ", 0.0, 0);
		int foundAt = Arrays.binarySearch(empArray, comparableSearchEmployee);
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
 
