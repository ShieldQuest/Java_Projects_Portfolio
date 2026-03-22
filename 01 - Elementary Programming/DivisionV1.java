/*
	Author: COP2551C
	Date: 9-2-25
	Description: this program prompts the user to input
             two real numbers (N and D), divide first by second (N / D), then displays
             the two numbers and their quotient (Q). 
*/
package divisionV1;
//Imports:
import java.util.Scanner;//the class Scanner will allow for the creation
                         //of scanning tools in the program
import java.text.DecimalFormat;
public class DivisionV1 
{
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				double N = 0.0;
				double D = 0.0;
				double Q = 0.0;
			//working variables:
				Scanner get = new Scanner(System.in); //'get' is the programmer 
			                                      //chosen name for the scanner
			                                      //"System.in" refer to the keyboard	
		        DecimalFormat DF = new DecimalFormat("##.##");//this toll will be used
		                                                      //to format the output
		                                                      //to show exactly 2 decimals
			//input:
			System.out.println("Enter N: ");
			N = get.nextDouble();//using 'get' to input an integer
			System.out.println("Enter D: ");
			D = get.nextDouble();
		//processes: adding a to b and storing result in s
			Q = N / D;
		//output:
			System.out.println("The quotient of " + DF.format(N) + " and " + DF.format(D) + " is " + DF.format(Q));
		//closing the scanner:
			get.close();//closing this resource to avoid memory leak
	}//end main
}//end class Addition
