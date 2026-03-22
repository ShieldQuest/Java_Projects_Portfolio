package factorialproduct;

import java.util.Scanner;

/*
 * Author: COP2551C
 * Date:  
 * Description:  factorial by product 
 */

public class FactorialProduct 
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
	//-----------------------------------------------------
	public static int fact(int N)
	{
		int F =  1;
		if(N == 0)
			return 1;
		else
		{
			for(int i = 1; i <= N; i++)
			F = F * i;
		}//end for i
		return F;
	}//end 

}//end summation class
