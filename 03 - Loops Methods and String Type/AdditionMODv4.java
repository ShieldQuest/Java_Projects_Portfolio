/*
	Author: COP2551C
	Date: 9-16-25
	Description: this program prompts the user to input
             two integers, add both, then displays
             the two integers and their sum. 
             This program implements a new method (other than main())
             to conduct the addition
             this version will move the two input (a and b) to two separate modules
             in this version, we had to declare the scanner everywhere we need it
             this is not efficient.
             In this version, we will learn how to make the scanner available
             to all method that need it
             Also, in this version, we will continue with our modular design and move
             the report routines to a separate method.
             In this current version, we will make the Scanner available to all methods that
             need it without passing a reference to it.
*/

//Imports:
import java.util.Scanner;
public class AdditionMODv4 
{
	//"global" vars:
	static Scanner get = new Scanner(System.in); //Scanner get is now visible
	                                             //everywhere in the class.
	public static void main(String[] args) 
	{
		 //declarations:
			//addition: 
				int a = 0;
				int b = 0;
				int s = 0;
			//working variables:
			   //the scanner was moved to the class to make it available everywhere
				//within this class.
		//input:
		a = getA();
		b = getB();
		//processes: adding a to b and storing result in s
			s = add(a, b);//method call by value: the method add is called
			              //value of a and b are copied onto a and b in the
			              //method add()
			              //s will receive whatever value is returned by add()
		//output:
			disp(a, b, s);
		//closing the scanner:
			get.close(); 
	}//end main
	//=====================================================================
	public static int getA()
	{
		int a = 0;
		System.out.println("Enter a: ");
		a = get.nextInt(); 
		//get.close();//cannot close the scanner this early maybe needed by
		              //different routines/methods
		return a;
	}//end getA
	//======================================================================
	public static int getB()
	{ 
		int b = 0;
		System.out.println("Enter b: ");
		b = get.nextInt();
		return b;
	}//end getB
	//======================================================================
	public static int add(int a, int b) //a will get value of a in main and 
	                                    //b will get the value of b in main
	{
		int s = 0;//this a new local memory called 's'
		s = a + b;
		return s;//value in 's' is returned back to the caller in main
	}//end add
	//=====================================================================
	//practice assignment 2: renaming the variables used by this method add()
	//a becomes x and b becomes y and s becomes z
	//will this program work? support your answers through coding
	//and elaborate why it works or not.
	public static void disp(int a, int b, int s)
	{
		System.out.println("The sum of " + a + " and " + b + " is " + s);
	}//end disp
	//======================================================================
}//end class Addition
 