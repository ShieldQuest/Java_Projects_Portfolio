/*
	Author: COP2551C
	Date: 9-9-25
	Description: this program prompts the user to input
             two real numbers (N and D), divide first by second (N / D), then displays
             the two numbers and their quotient (Q). 
             this version will prevent the division by zero
             by implementing a selection.
*/
package divisionV2;
//Imports:
import java.util.Scanner; 
import java.text.DecimalFormat;
public class DivisionV2 
{
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				double N = 0.0;
				double D = 0.0;
				double Q = 0.0;
			//working variables:
				Scanner get = new Scanner(System.in);  
		        DecimalFormat DF = new DecimalFormat("##.##"); 
			//input:
			System.out.println("Enter N: ");
			N = get.nextDouble(); 
			System.out.println("Enter D: ");
			D = get.nextDouble();
			if(D == 0)
				System.out.println("Cannot divide by zero!");
				//we can, at this level, provide the user with another attempt
			    //entering a non-zero D
			else
			{
				//processes:  division
					Q = N / D;//division by zero leads to infinity: not practical
				//output:
					System.out.println("The quotient of " + DF.format(N) + " and " + DF.format(D) + " is " + DF.format(Q));
			}//end else if (D == 0)
					//goodbye!
			System.out.println("Goodbye!");
			//closing the scanner:
			get.close();//closing this resource to avoid memory leak
	}//end main
}//end class Addition
