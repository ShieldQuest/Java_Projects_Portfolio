/*
 *  Author: COP2220
 * Date: 9-23-25
 * Description: simulating throwing a dice 10 times
*/
package randomV2;

public class RandomV2 
{

	public static void main(String[] args) 
	{
		 double r = 0.0;
		 int dice = 0;
		 for(int i = 0; i < 10; i++)
		 {
			 	r = Math.random() * 6 + 1;//generate a random number < 1
			 	dice = (int)(r);
		       // System.out.println(" r = " + (int)(r)); 
		        System.out.println(" dice outcome = " + dice); 
		 }//end for i
	}//end main
}//end class RandomV1
