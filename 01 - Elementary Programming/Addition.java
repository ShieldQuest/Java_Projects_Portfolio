/*
	Author: COP2551C
	Date: 9-2-25
	Description: this program prompts the user to input
             two integers, add both, then displays
             the two integers and their sum. 
*/
package addition;
//Imports:
import java.util.Scanner;//the class Scanner will allow for the creation
                         //of scanning tools in the program
public class Addition 
{
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				int a = 0;
				int b = 0;
				int s = 0;
			//working variables:
				Scanner get = new Scanner(System.in); //'get' is the programmer 
			                                      //chosen name for the scanner
			                                      //"System.in" refer to the keyboard	
		//input:
			System.out.println("Enter a: ");
			a = get.nextInt();//using 'get' to input an integer
			System.out.println("Enter b: ");
			b = get.nextInt();
		//processes: adding a to b and storing result in s
			s = a + b;
		//output:
			System.out.println("The sum of " + a + " and " + b + " is " + s);
		//closing the scanner:
			get.close();//closing this resource to avoid memory leak
	}//end main
}//end class Addition
