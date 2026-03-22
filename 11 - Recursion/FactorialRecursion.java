/*
 * Author: COP2551C
 * Date: 11-18-25
 * Description: this program implements a routine that calculates the factorial
 *              of a positive integer N using recursion.
 */
package factorialRecursion;

import java.util.Scanner;

public class FactorialRecursion 
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
	public static long Fact(int N) //recursive process
	{
		if(N == 0)
			return 1;
		else
			return N * Fact(N - 1);
	}//end Fact
	//==============================

}//end class FactorialLoop
