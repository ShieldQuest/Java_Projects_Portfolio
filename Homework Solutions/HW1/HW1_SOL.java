/*
 * Author: COP2551
 * Date: 9-22-25
 * Description: see full specs in Canvas
 */
package hw1_sol;
//Imports:
import java.util.Scanner;

public class HW1_SOL 
{

	public static void main(String[] args) 
	{
		//declarations:
			//object: weather for a city
			String City = " ";
			int Temp    = 0;
			//working variables:
			int answer = 1;
			Scanner get = new Scanner(System.in);
		//processes:
		while(answer == 1)
		{
			//input:
			System.out.println("Enter the name of this city: ");
			City = get.nextLine(); //this WILL cause the problem discussed in class
			System.out.println("Enter outdoor temperature in degrees Fahrenheit: ");
		    Temp = get.nextInt();
		    //evaluate and report
		    System.out.println("City Name: " + City);
		    if(Temp < 85)
		    	System.out.println("GREEN alert!");
		    else
		    	if(Temp >= 85 && Temp <= 95) //specs states 'exclusive' should 'inclusive' 
		    		                         //otherwise 85 and 95 will be excluded
		    		System.out.println("YELLOW alert!");
		    	else //Temp > 95
		    		System.out.println("RED alert!");
		    //continue
		    System.out.println("Another entry? 1 for yes or 0 for no: ");
		    answer = get.nextInt(); //this is the input that will cause the next
		                            //city name to be skipped
		    while(answer != 1 && answer != 0)
		    {
			    System.out.println("Wrong answer! re-enter 1 for yes or 0 for no: ");
			    answer = get.nextInt();
		    }//end while(answer != 1 && answer != 0)
		}//end while(answer == 1)
		//close scanner:
		get.close();
		//goodbye!
		System.out.println("Goodbye!");
	}//end main
}//end class HW1_SOL
