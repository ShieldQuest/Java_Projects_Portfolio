/*
 * Author: COP2551
 * Date: 9-30-25
 * Description: this program moved the display to a separate method.
 *              main() is providing a reference/address to the array to the method
 *              for the purpose of accessing the array and printing its content.
 *              this version, will add a method that displays the content
 *              backward.
 *              this version, will code a method that searches and displays 
 *              all even numbers and another methods that displays all odd numbers.
 *               
 */
public class Arrayv7                
{
	public static void main(String[] args) 
	{
		//declaring an int array already populated (constant):
		int [] num = {12, 57, 34, 8, 11, 78, 65, 101};
		//display content in forward:
		System.out.println("Displaying content of num forward: ");
		dispForward(num);
		//display content in forward:
		System.out.println("Displaying content of num forward: ");
		dispBackward(num);
		//list of even numbers in the array:
		System.out.println("List of even numbers in the array: ");
		findEven(num);
		//list of odd numbers in the array:
		System.out.println("List of odd numbers in the array: ");
		findOdd(num);
	}//end main
	//========================================
	public static void dispForward(int [] num)
	{
		int i = 0; 
		//while(i < 8)                   // ;//remember this problem!
		//let's assume this function is not aware of the size:
		while( i < num.length)
		{
			System.out.println("Value stored at position " + i + " is " + num[i]);
			i++;
		}//end while (i < num.length)
	}//end dispForward
	//=========================================
	public static void dispBackward(int [] num)
	{
		int i = num.length - 1; //8 - 1 = position 7 
		while( i > -1) //as long as index is >= 0
		{
			System.out.println("Value stored at position " + i + " is " + num[i]);
			i--;
		}//end while (i > -1)
	}//end dispBackward
	//=========================================
	public static void findEven(int [] num)
	{
		int i = 0;
		while(i < num.length)
		{
			if(num[i] % 2 == 0)//remainder of num[i] by 2
				System.out.println("Value stored at position " + i + 
						" is " + num[i] + "and is even!");
			i++;
		}//end while(i < num.length)
	}//end findEven
	//===========================================
	public static void findOdd(int [] num)
	{
		int i = 0;
		while(i < num.length)
		{
			if(num[i] % 2 != 0)//remainder of num[i] by 2
				System.out.println("Value stored at position " + i + 
						" is " + num[i] + "and is odd!");
			i++;
		}//end while(i < num.length)
	}//end findOdd
	//===========================================
	
}//end class Arrayv4
