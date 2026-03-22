package factorialrecursion;

import java.util.Scanner;

/*
 * Author: COP2551C
 * Date:  
 * Description:  factorial by recursion 
 */

public class FactorialRecursion 
{
	//declarations:
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args)
	{
		 //declarations:
		int F = 0;
		int N = 0;
		
		//input:
		System.out.println("Enter N: (for factorial N or N!)");
		N = get.nextInt();
		//getting factorial:
		F = fact(N);
		//output:
		System.out.println( N + "!=" + F);

	}//end main
	//-----------------------------------------------------11111110
	public static int fact(int N)
	{
		if(N == 0)
			return 1;
		else
		    return N * fact(N - 1);  //N! = N * (N - 1)! = N * (N - 1) * (N - 2)! =  N * (N - 1) * (N - 2) * (N - 3) *...*(N - K)!
	}//end 

}//end summation class
