/*
 * Author: COP2551
 * Date: 9-30-25
 * Description: this program processes the payroll for 4 employees using
 *              a set of parallel arrays. This version implements a method to calc
 *              the gross for all employees using a for ...loop and another to 
 *              display all employees reports using a for ...loop
 *              In this version we have adopted  adopt a different approach by 
 *              coding the two for loops in main
 */
public class PayrollV2 
{
	public static void main(String[] args) 
	{
		//declarations:  
			//object: employee
			String [] ssn   = {"111"     , "222"    , "333"    , "444"  };
			String [] First = {"Robert"  , "John"   , "Ali"    , "Sam"  };
			String [] Last  = {"Rich"    , "Maxwell", "Sanford", "Fredo"};
			double [] Rate  = { 12.34    ,  15.90   ,   34.25  , 10.75  };
			int    [] Hours = {   44     ,   35     ,   60     ,   20   };
			double [] Gross = {  0.0     ,   0.0    ,   0.0    ,   0.0  };
			//working variables:
		//process the gross:
		for(int i = 0; i < ssn.length; ++i)
			calcGross(Rate, Hours, Gross, i);
		//generate a payroll report
		for(int i = 0; i < ssn.length; ++i)
			report(ssn, First, Last, Rate, Hours, Gross, i);

	}//end main
	//============================================
	public static void calcGross(double [] Rate, int [] Hours, double [] Gross, int current)
	{
			Gross[current] = Rate[current] * Hours[current];
	}//end calcGross
	//=============================================
	public static void report(String [] ssn, String [] First, String [] Last,
			                  double [] Rate, int [] Hours, double [] Gross, int current)
	{
		
			System.out.println("Employee SSN: "           + ssn[current]   + "\n" + 
		                       "         First Name: "    + First[current] + "\n" +
					           "         Last Name: "     + Last[current]  + "\n" +
		                       "         Hourly Rate: $"  + Rate[current]  + "\n" +
					           "         Hours Worked: "  + Hours[current] + "\n" +
		                       "         Gross Salary: $" + Gross[current]);
		
	}//end report
	//==============================================
}//end class Payroll
