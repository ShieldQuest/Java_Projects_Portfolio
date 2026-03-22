/*
 * Author: COP2551C
 * Date: 3-25-25
 * Description: this program demonstrates sorting Primitive Data Type (PDT)
 *              using wrapping classes: Integer, Double, String, Character
 */
package sortingListPDT;

import java.util.ArrayList;
import java.util.Collections;

public class SortingListPDT 
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
		sortIntegers(IntList);
		sortDoubles(DoubleList);
		sortStrings(StringList);
		sortCharacters(CharList);
		//Let's display the sorted content of each list:
		System.out.println("Sorted lists:");
		System.out.println("List of Integers after sorting  :"   + IntList);
		System.out.println("List of Doubles after sorting   :"   + DoubleList);
		System.out.println("List of Strings after sorting   :"   + StringList);
		System.out.println("List of Characters after sorting:"   + CharList);
		
	}//end main
	//=====================================================
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

}//end SirtingListPDT
