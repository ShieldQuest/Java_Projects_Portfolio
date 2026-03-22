/*
 * Author: COP2551
 * Date: 11-4-25
 * Description:    We are using the program from session 10-14-25
 *                 In this version, we will save all records to file and read them back.
 *                 after the user completes creating all records, display all, and search for one, the selection
 *                 of option '4' to quit will trigger a process to save all records and read them back.
 *                 the records will be read back to a different ArrayList to confirm reading from a file.
 *                 this program demonstrates the use of pattern matching with the SSN.
 */
/*
 * For this week's practice:
 * Go back to the payroll program with data validations and ArrayList, code a method that
 * write records to disk, then recycle the same program without the write record method
 * and code a read method that you call before the user start acting on the menu. At this stage, the user
 * can start working with option 2 and 3 of the menu without adding more records.
 * 
 */
//all Imports:
	//file IO related imports:
		import java.io.FileOutputStream;
		import java.io.ObjectOutputStream;
		import java.io.IOException;
		import java.io.Serializable;
		import java.io.FileInputStream;
		import java.io.ObjectInputStream;
	//other imports:
		import javax.swing.JOptionPane;
		import java.text.DecimalFormat;
		import java.util.ArrayList;
	//pattern matching imports:
		import java.util.regex.Matcher;
		import java.util.regex.Pattern;

public class PayrollListFileWriteRead 
{
	//declarations:
	static ArrayList<Employee> empList = new ArrayList<Employee>();
	//working vars:
	static String input = " ";
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		 //declarations:
			//working variables:
				int choice = 0;
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
			case 4: //-------------------------------Write-----------------------------------------
					JOptionPane.showMessageDialog(null, "Hit ok to write all records to file...");
					try
					(
							FileOutputStream outFile = new FileOutputStream("employees");
							ObjectOutputStream outObject = new ObjectOutputStream(outFile);
							//ObjectOutputStream outObject = new ObjectOutputStream(new FileOutputStream("employee");)
					)
					{
						for(int i = 0; i < empList.size(); i++)
							outObject.writeObject(empList.get(i));
					}//end no exception section
					//----------------------------------Read---------------------------------------
					JOptionPane.showMessageDialog(null, "Hit ok to read all records from the file...");
					try
					(
							FileInputStream inFile = new FileInputStream("employees");
							ObjectInputStream inObject = new ObjectInputStream(inFile);
							//ObjectInputStream inObject = new ObjectInputStream(new FileInputStream("employees"));		
					)
					{
						//let's create a different list to load all records in:
						ArrayList<Employee> readEmpList = new ArrayList<Employee>();
						Employee readEmployee = new Employee(); //used to read one object each time
						//int i = 0;
						//while(i < empList.size())  //<=====cheating! what if we do not know the number of records
						while(inFile.available() > 0)//as long as there are records available in the file
						{
							readEmployee = (Employee)inObject.readObject();
							readEmpList.add(readEmployee); //add the newly read rec to the new list
							//i++;
						}//while i
						JOptionPane.showMessageDialog(null, "Hit ok to display the records you just read...");
						for(int j = 0; j < readEmpList.size(); j++)
							readEmpList.get(j).dispReport();
					}
				
					JOptionPane.showMessageDialog(null,"Goodbye!");
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
				if(searchSSN.equals(empList.get(i).ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchEmployee
		//==================================
}//end class PayrollObjectV1
//-------------------------------------------
class Employee implements Serializable 
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
			while(!checkSSN(input))
			{
				input = JOptionPane.showInputDialog("Invalid SSN! re-Enter this employee SSN: ");
			}//end while !checkSSN
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
			//validate: format '###.##'
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
		/*boolean checkSSN(String input)
		{
			if(input.length() != 9)
				return false;
			else
				for(int i= 0; i < input.length(); i++)
					if(!Character.isDigit(input.charAt(i)))
						return false;
			return true;
						
		}//end checkSSN*/
		//validating ssn using pattern matching:
		boolean checkSSN(String input)//try implementing similar process for rat, name, hours, ...etc
		{
			String ssnPattern = "^(\\d{9})$";//all digits and 9 of them exactly
			Pattern pattern = Pattern.compile(ssnPattern);
			Matcher matcher = pattern.matcher(input);
			return matcher.matches();
		}//end checkSSN
}//end class Employee
