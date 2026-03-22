package summationiteration;

import java.util.Scanner;

/*
 * Author: COP2551C
 * Date:  
 * Description:  summation through iteration
 */

public class SummationIteration 
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
		sum = summation(N);
		//output:
		System.out.println("The sum of all integers from 1 to " + N + " is " + sum);

	}//end main
	//-----------------------------------------------------
	public static int summation(int N)
	{
		int sum = 0;
		for(int i = 0; i <= N; i++)
			sum = sum + i;
		return sum;
	}//end 

}//end summation class
