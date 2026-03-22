/*
 * Author: COP2551
 * Date: 10-14-25
 * Description:    this version of the payroll program implements the GUI elements (JOptionPane)
 *                 this version implements an ArrayList of objects instead of an array of objects          
 *                 ArrayList are dynamic while arrays are static
 *                 ArrayList can expand to accommodate more objects. Array are fixed and cannot
 *                 extend at run time.        
 *                 notice areas of input that need validations to ensure that this code
 *                 is robust. eg. ssn must be 9 digits  
 *                 this version implements input validations for all input using primitive
 *                 approaches (not pattern matching yet!).          
 */
//for practice: implements all validatiosn using primitive approaches only
//we will cover a different technique using pattern matching in java after the MT exam.
//Imports:
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class PayrollValidations 
{
	//declarations:
	//static Employee [] emp = new Employee[100];//an array of objects //array: static and continguous
	static ArrayList<Employee> empList = new ArrayList<Employee>();
	//working vars:
	static String input = " ";
	public static void main(String[] args) 
	{
		 //declarations:
			//working variables:
				int choice = 0;
				//int empCount = 0; //not necessary to keep count as ArrayList
				                    //offer a method that return the 'size' of the list
				String searchSSN = " ";
				int foundAt      = -1; //-1 means not found
	//processes:
	while(choice != 4)
	{
		choice = menu();
		switch(choice)
		{
			case 1: Employee emp = new Employee();//an instance of an employee
				    emp.getSSN();// . is a membership dot
				    emp.getFirst();
				    emp.getLast();
				    emp.getRate();
				    emp.getHours();
				    emp.calcGross();
				    empList.add(emp); //emp as an employee 'form' is now added to the 'folder' empList
				    break;
			case 2: for(int i = 0; i < empList.size(); ++i)
						empList.get(i).dispReport();
				    break;
			case 3: input = JOptionPane.showInputDialog("Enter the SSN to search for: ");
					//validate: 9 digits
					searchSSN = input;
					foundAt = searchEmployee(searchSSN); //where, what, into how many
				    if(foundAt == -1)
				    	JOptionPane.showMessageDialog(null, searchSSN + " was not found!");
				    else
				    		empList.get(foundAt).dispReport();
					break;
			case 4: JOptionPane.showMessageDialog(null,"Goodbye!");
					break;
			default: JOptionPane.showMessageDialog(null,"Wrong choice...please try again...");
		}
	}//end while(choice != 4)

	}//end main
	//=============================
		public static int menu()
		{
			int choice = 0;
			input = JOptionPane.showInputDialog("-1-Add employee\n" +
							                    "-2-Display all employees\n" +
									            "-3-Search for an employee\n" +
							                    "-4-Quit\n" + 
									            "\tEnter choice 1-4: ");
			//validate: integer
			choice = Integer.parseInt(input);
			return choice;
		}//end menu
		//==============================
		public static int searchEmployee(String searchSSN)
		{
			int i = 0;
			while(i < empList.size())
			{
				//if(searchSSN == ssn[i])//the '=='will not work in this context
					                   //you are comparing addresses instead of content
				if(searchSSN.equals(empList.get(i).ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchEmployee
		//==================================
		//==================================validation methods in the main class==========
		
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
			input = JOptionPane.showInputDialog("Enter this employee SSN: ");
			//validate: 9 digits
			ssn = input;
		}//end getSSN
		//==============================
		void getFirst()
		{
			input = JOptionPane.showInputDialog("Enter this employee first name: ");
			//validate: letters only
			first = input;
		}//end getFirst
		//==============================
		void getLast()
		{
			input = JOptionPane.showInputDialog("Enter this employee last name: ");
			//validate: letters only
			last = input;
		}//end getLast()
		//===============================
		void getRate()
		{
			input = JOptionPane.showInputDialog("Enter this employee hourly rate: $");
			//validate: format '###.##'//all digits and one decimal point located 2 digits from the back
			rate = Double.parseDouble(input);
		}//end getRate()
		//===============================
		void getHours()
		{
			input = JOptionPane.showInputDialog("Enter this employee hours worked: ");
			//validate: integer
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
			JOptionPane.showMessageDialog(null, "Employee ssn         : "  + ssn   + "\n" + 
		                                        "         first name  : "  + first + "\n" +
						                        "         last name   : "  + last  + "\n" +
									            "         hourly rate : $" + rate  + "\n" + 
						                        "         hours worked: "  + hours + "\n" +
									            "         gross salary: $" + DF.format(gross));
		}//end dispreport()
		//================================
		//================================all validations methods=======================
		
}//end class Employee
