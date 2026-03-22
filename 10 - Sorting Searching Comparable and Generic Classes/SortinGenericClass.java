/*
 * Author: COP2551C
 * Date: 3-25-25
 * Description: this program demonstrates sorting Primitive Data Type (PDT)
 *              using wrapping classes: Integer, Double, String, Character
 *              this version will use a single generic class to sort all
 *              types by implementing a generic class    
 */
/*To Do:
 * recode this program and the original one, make it more modular, and instead of hard coding 
   data, randomly generate all. see session 2-4-25 More Methods and intro to Arrays
   for how to generate random data. You may need to be more creative
   generating double values, strings, and chars.
*/
package sortinGenericClass;

import java.util.ArrayList;
import java.util.Collections;

public class SortinGenericClass 
{

	public static void main(String[] args) 
	{
		//declarations:
		ArrayList<Integer>   IntList    = new ArrayList<Integer>();
		ArrayList<Double>    DoubleList = new ArrayList<Double>();
		ArrayList<String>    StringList = new ArrayList<String>();
		ArrayList<Character> CharList   = new ArrayList<Character>();
		//populate all lists with data:
		//------------------integers
		IntList.add(12);
		IntList.add(3);
		IntList.add(56);
		IntList.add(2);
		//------------------double
		DoubleList.add(34.56);
		DoubleList.add(1.45);
		DoubleList.add(3.89);
		DoubleList.add(18.50);
		DoubleList.add(10.25);
		//-------------------strings
		StringList.add("qwerty");
		StringList.add("azerty");
		StringList.add("ABC");
		StringList.add("mile");
		//-------------------Characters
		CharList.add('x');
		CharList.add('m');
		CharList.add('c');
		//----------------------
		//print the content of each list before sorting:
		System.out.println("Non Sorted lists:");
		System.out.println("List of Integers before sorting  :"   + IntList);
		System.out.println("List of Doubles before sorting   :"   + DoubleList);
		System.out.println("List of Strings before sorting   :"   + StringList);
		System.out.println("List of Characters before sorting:"   + CharList);
		//call related sort method:
		/*
		sortIntegers(IntList);
		sortDoubles(DoubleList);
		sortStrings(StringList);
		sortCharacters(CharList);
		*/
		sort(IntList);
		sort(DoubleList);
		sort(StringList);
		sort(CharList);
		//Let's display the sorted content of each list:
		System.out.println("Sorted lists:");
		System.out.println("List of Integers after sorting  :"   + IntList);
		System.out.println("List of Doubles after sorting   :"   + DoubleList);
		System.out.println("List of Strings after sorting   :"   + StringList);
		System.out.println("List of Characters after sorting:"   + CharList);
		
	}//end main
	//=====================================================
	/* instead of one sort for each of the lists, we will use a single 
	 * sort routine supported by a single generic class
	 * 
	*/
	//Let's 'disable' all sort routines
	/*
	public static void sortIntegers(ArrayList<Integer> IntList)
	{
		Collections.sort(IntList);
	}//end sortIntegers
	//=====================================================
	public static void sortDoubles(ArrayList<Double> DoubleList)
	{
		Collections.sort(DoubleList);
	}//end sortDoubles
	//=====================================================
	public static void sortStrings(ArrayList<String> StringList)
	{
		Collections.sort(StringList);
	}//end sortStrings
	//=====================================================
	public static void sortCharacters(ArrayList<Character> CharList)
	{
		Collections.sort(CharList);
	}//end sortCharacters
	//=====================================================
	 * 
	 */
	//let's code the generic class:
	//think of 'E' to mean any type
	public static <E extends Comparable <E>> void sort(ArrayList<E> anyList)
	{
		E swap; //E is a generic type will take on Integer, Double, String, or Character
		int i = 0;
		int j = i + 1;
		while(i < anyList.size() - 1)
		{
			while(j < anyList.size())
			{
				if(anyList.get(i).compareTo(anyList.get(j)) > 0)
				{
					swap = anyList.get(i);          //I
					anyList.set(i, anyList.get(j)); //II
					anyList.set(j, swap);           //III
				}//end if(anyList.get(i).compareTo(anyList.get(j)) > 0)
				j++;
			}//end while(j < anyList.size())
			i++; j = i + 1;
		}//end while(i < anyList.size() - 1)
	}//end sort
}//end SirtingListPDT
