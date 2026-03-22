/*
	Author: COP2551C
	Date: 9-2-25
	Description: this program prompts the user to input
             two real numbers, add both, then displays
             the two numbers and their sum. 
*/
package additionReal;
//Imports:
import java.util.Scanner;//the class Scanner will allow for the creation
                         //of scanning tools in the program
public class AdditionReal 
{
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				double a = 0;
				double b = 0;
				double s = 0;
				//previous last 3 lines can be combined: int a = 0, b = 0, s = 0;
			//working variables:
				Scanner get = new Scanner(System.in); //'get' is the programmer 
			                                      //chosen name for the scanner
			                                      //"System.in" refer to the keyboard	
		//input:
			System.out.println("Enter a: ");
			a = get.nextDouble();//using 'get' to input an integer
			System.out.println("Enter b: ");
			b = get.nextDouble();
		//processes: adding a to b and storing result in s
			s = a + b;
		//output:
			System.out.println("The sum of " + a + " and " + b + " is " + s);
		//closing the scanner:
			get.close();//closing this resource to avoid memory leak
	}//end main
}//end class Addition
