/*
 * Author: COP2551C
 * Date: 11-18-25
 * Description: this program implements a routine that calculates the factorial
 *              of a positive integer N using a loop.
 */
package factorialLoop;

import java.util.Scanner;

public class FactorialLoop 
{
	static Scanner get = new Scanner(System.in);
	public static void main(String[] args) 
	{
		//declarations:
		int N = 0;
		long F = 0;
		int answer = 1;
		while(answer == 1)
		{
			//get N:
			N = getN();
			//calc factorial:
			F = Fact(N);
			//display result:
			System.out.println(N + "!=" + F);
			//continue:
			System.out.println("Another factorial? 1 for yes or 0 for no: ");
			answer = get.nextInt();
		}//end while answer
		System.out.println("Goodbye!");
	}//end main
	//===========================
	public static int getN()
	{
		int N = 0;
		System.out.println("Enter N: ");
		N = get.nextInt();
		return N;
	}//end getN
	//=============================
	public static long Fact(int N)
	{
		long F = 1;
		if(N == 0)
			return 1;
		else
		{
			for(int i = 1; i <= N; i++)
				F = F * i; //1*1, 1*2, 2*3, 6*4, 25*5, ....
		}//end else if(N == 0
		return F;
	}//end Fact
	//==============================

}//end class FactorialLoop
