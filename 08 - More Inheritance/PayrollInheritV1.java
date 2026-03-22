/*
 * Author: COP2551
 * Date: 10-28-25
 * Description:    This program implements the concept of inheritance 
 *                 We have now subcatergories of Employees : in this version we will code a sub class 'PT' for part time employees 
 */
/*FOR PRACTICE THIS WEEK, COMPLETE THIS PROGRAM BY:
 * -FINISHING THE FT AND THE CONTRACTOR PARTS
 * -FINISH ALL VALIDATIONS FOR ALL INPUT REFER BAACK TO THE SOLUTION OF HW3
 */
//Imports:
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class PayrollInheritV1 
{
	//declarations:
	//static ArrayList<Employee> empList = new ArrayList<Employee>();//this list may be needed if we are processing an employee as an Employee 
	//regardless if they are PT, FT, or Contractor
	//working vars:
	static ArrayList<PT> PTlist                 = new ArrayList<PT>();
	static ArrayList<FT> FTlist                 = new ArrayList<FT>();
	static ArrayList<Contractor> ContractorList = new ArrayList<Contractor>();
	static String input = " ";
	public static void main(String[] args) 
	{
		 //declarations:
			//working variables:
				int mainChoice = 0;
				int PTchoice   = 0;
				int FTchoice   = 0;
				int Contchoice = 0;
				//........................
				String searchSSN = " ";
				int PTfoundAt    = -1;
				int FTfoundAt    = -1;
				int ContFoundAt  = -1;
				//........................
				
	//processes:
	while(mainChoice != 4)
	{
		mainChoice = mainMenu();
		switch(mainChoice)
		{
			case 1:while(PTchoice != 4)
					{
						PTchoice = PTmenu();
						switch(PTchoice)
						{
							case 1: PT pt = new PT();
							        pt.getSSN();
							        pt.getFirst();
							        pt.getLast();
							        pt.getRate();
							        pt.getHours();
							        pt.calcGross();
							        PTlist.add(pt);
							        break;
							case 2: if(PTlist.isEmpty())
										JOptionPane.showMessageDialog(null," Database is empty!");
							        else
							        	    for(int i = 0; i <PTlist.size(); i++)
							        	    {
							        	    		PTlist.get(i).dispEmployee();
							        	    		PTlist.get(i).dispPT();
							        	    }//end for i
							         break;	
							case 3: if(PTlist.isEmpty())
										JOptionPane.showMessageDialog(null," Database is empty!");
					        			else
					        			{
					        				input = JOptionPane.showInputDialog("Enter the SSN to search for: ");
										//validate: 9 digits
										searchSSN = input;
										PTfoundAt = searchPT(searchSSN);
										if(PTfoundAt == -1)
											JOptionPane.showMessageDialog(null, searchSSN+ " was not found!");
										else
										{
											PTlist.get(PTfoundAt).dispEmployee();
					        	    				PTlist.get(PTfoundAt).dispPT();
										}//end else if(PTfoundAt == -1)
					        			}//end else if(PTlist.isEmpty())
										break;		
							case 4: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
					        				break;
							default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");
						}//end switch(PTchoice)
					}//end while(PTchoice != 4)
					PTchoice = 0;
			        break;
			case 2: //remove when complete
						JOptionPane.showMessageDialog(null," FT part Coming soon ...");
						FTchoice = 4;
			        //end remove when complete
				   while(FTchoice != 4)
					{
						FTchoice = FTmenu();
						switch(PTchoice)
						{
							case 1: 
							case 2:
							case 3:
							case 4: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
					        break;
							default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");
						}//end switch(FTchoice)
					}//end while(FTchoice != 4)
				   FTchoice = 0;
			        break;
			case 3: //remove when complete
					JOptionPane.showMessageDialog(null," Contractor part Coming soon... ");
					Contchoice = 4;
					//end remove when complete
				
				    while(Contchoice != 4)
					{
						Contchoice = Contmenu();
						switch(PTchoice)
						{
							case 1: 
							case 2:
							case 3:
							case 4: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
					        break;
							default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");
						}//end switch(Contchoice)
					}//end while(Contchoice != 4)
				    Contchoice = 4;
			        break;
			case 4: JOptionPane.showMessageDialog(null, "Goodbye!");
			        break;
			default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");
		}//end switch(mainChoice)
		
	}//end while(choice != 4)

	}//end main
	//=============================
		public static int mainMenu()
		{
			int mainChoice = 0;
			input = JOptionPane.showInputDialog("-1-Process a PT\n" +
							                    "-2-Process a FT\n" +
									            "-3-Process a Contractor\n" +
							                    "-4-Quit\n" + 
									            "\tEnter choice 1-4: ");
			//validate: integer
			mainChoice = Integer.parseInt(input);
			return mainChoice;
		}//end menu
		//==============================
		public static int PTmenu()
		{
			int PTchoice = 0;
			input = JOptionPane.showInputDialog("-1-Add a PT\n" +
							                    "-2-Display all PT\n" +
									            "-3-Search for a PT\n" +
							                    "-4-Go back to main menu\n" + 
									            "\tEnter choice 1-4: ");
			//validate: integer
			PTchoice = Integer.parseInt(input);
			return PTchoice;
		}//end PTmenu
		//==============================
		public static int FTmenu()
		{
			int FTchoice = 0;
			input = JOptionPane.showInputDialog("-1-Add a FT\n" +
							                    "-2-Display all FT\n" +
									            "-3-Search for a FT\n" +
							                    "-4-Go back to main menu\n" + 
									            "\tEnter choice 1-4: ");
			//validate: integer
			FTchoice = Integer.parseInt(input);
			return FTchoice;
		}//end PTmenu
		//==============================
		public static int Contmenu()
		{
			int Contchoice = 0;
			input = JOptionPane.showInputDialog("-1-Add a Contractor\n" +
							                    "-2-Display all Contractor\n" +
									            "-3-Search for a Contractor\n" +
							                    "-4-Go back to main menu\n" + 
									            "\tEnter choice 1-4: ");
			//validate: integer
			Contchoice = Integer.parseInt(input);
			return Contchoice;
		}//end PTmenu
		//==============================
		public static int searchPT(String searchSSN)
		{
			int i = 0;
			while(i < PTlist.size())
			{
				//if(searchSSN == ssn[i]) 
				if(searchSSN.equals(PTlist.get(i).ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchPT
		//==================================
		public static int searchFT(String searchSSN)
		{
			int i = 0;
			while(i < FTlist.size())
			{
				if(searchSSN.equals(FTlist.get(i).ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchFT
		//==================================
		public static int searchContractor(String searchSSN)
		{
			int i = 0;
			while(i < ContractorList.size())
			{
				//if(searchSSN == ssn[i])//the '=='will not work in this context
					                   //you are comparing addresses instead of content
				if(searchSSN.equals(ContractorList.get(i).ssn))
					return i;
				else
					++i;//keep searching
			}//end while(i < empCount)
			return -1; //to mean not found
		}//end searchContractor
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
		//working variables:
		String input = " ";
	//constructors:
		Employee()
		{
			ssn   = " ";
			first = " ";
			last  = " ";
			
		}//end constructor w/o arguments
		Employee(String ssn, String first, String last)
		{
			this.ssn   = ssn;
			this.first = first;
			this.last  = last;
			
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
		
		void dispEmployee()
		{
			JOptionPane.showMessageDialog(null, "Employee ssn         : "  + ssn   + "\n" + 
		                                        "         first name  : "  + first + "\n" +
						                        "         last name   : "  + last );
									            
		}//end disEmployee()
		//================================
		//================================all validations methods=======================
		
}//end class Employee
//========================================all subclasses=================================
class PT extends Employee //PT inherits from Employee
{
	//declarations:
		//object: PT who happens to be an Employee too.
			double rate;
			int    hours;
			double gross;
		//working variable:
			String input = " ";
			DecimalFormat DF = new DecimalFormat("#####0.0");
	//constructors:
			PT()
			{
				super(); //this will construct the part 'Employee' of a PT
				rate  = 0.0;
				hours = 0;
				gross = 0.0;
				
			}//end const w/o arguments
			PT(String ssn, String first, String last, double rate, int hours, double gross)
			{
				super(ssn, first, last); //constructing the part 'Employee' by invoking the constructor w/ arguments in 'Employee'
				this.rate  = rate;
				this.hours = hours;	 
				this.gross = gross;
			}//end const w/ arguments
			//==================================methods===========================
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
			void dispPT()
			{
				JOptionPane.showMessageDialog(null, "hourly rate : $" + rate  + "\n" + 
						                            "hours worked: "  + hours + "\n" +
									                "gross salary: $" + DF.format(gross));
			}//end dispPT
			//=============================================validation methods for all input in this class======================
}//end class PT
//======================================
class FT extends Employee
{
	
}//end class FT
//======================================
class Contractor extends Employee
{
	
}//end class Contractor
//======================================
