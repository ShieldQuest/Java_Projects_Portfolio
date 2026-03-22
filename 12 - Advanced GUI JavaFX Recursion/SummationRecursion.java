package summationrecursion;

import java.util.Scanner;

/*
 * Author: COP2551C
 * Date:  
 * Description:  summation through recursion
 */

public class SummationRecursion 
{
	//declarations:
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args)
	{
		 //declarations:
		int sum = 0;
		int N = 0;
		
		//input:
		System.out.println("Enter N: (summation from 1 to N)");
		N = get.nextInt();
		//gettin sum:
		sum = add(N);
		//output:
		System.out.println("The sum of all integers from 1 to " + N + " is " + sum);

	}//end main
	//-----------------------------------------------------
	public static int add(int N)
	{
		if(N != 0)
			return (N + add(N -1));  //this recursive call (the function calls itself) simulates the for loop from before
		return 0;
	 
	}//end 

}//end summation class
