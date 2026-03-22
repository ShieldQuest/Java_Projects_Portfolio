/*
	Author: COP2551C
	Date: 9-16-25
	Description: this program prompts the user to input
             two integers, add both, then displays
             the two integers and their sum. 
             This program implements a new method (other than main())
             to conduct the addition
*/

//Imports:
import java.util.Scanner;
public class AdditionMODv1 
{
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				int a = 0;
				int b = 0;
				int s = 0;
			//working variables:
			Scanner get = new Scanner(System.in); 
		//input:
			System.out.println("Enter a: ");
			a = get.nextInt();//using 'get' to input an integer
			System.out.println("Enter b: ");
			b = get.nextInt();
		//processes: adding a to b and storing result in s
			s = add(a, b);//method call by value: the method add is called
			              //value of a and b are copied onto a and b in the
			              //method add()
			              //s will receive whatever value is returned by add()
		//output:
			System.out.println("The sum of " + a + " and " + b + " is " + s);
		//closing the scanner:
			get.close(); 
	}//end main
	//=====================================================================
	public static int add(int a, int b) //a will get value of a in main and 
	                                    //b will get the value of b in main
	{
		int s = 0;//this a new local memory called 's'
		s = a + b;
		return s;//value in 's' is returned back to the caller in main
	}//end add
	//=====================================================================
}//end class Addition
