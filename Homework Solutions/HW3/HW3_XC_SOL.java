/*
 * Author: COP2551
 * Date: 10-18-25
 * Description: see full specs for HW3 in Canvas and the XC specs: implement ArrayList and validations using primitive approaches ...for now
 *              until we cover pattern matching in Java.
 */
package hw3_xc_sol;
//imports:
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HW3_XC_SOL 
{
	//'global' vars:
	static ArrayList<Boat> boatList = new ArrayList<Boat>();
	static String input = " ";

	public static void main(String[] args) 
	{
		//declarations
			//working variables:
			int selection    = 0;
			String searchVIN = " ";
			int foundAt      = -1;
			Boat accessor = new Boat(); //will allow access to members vars and methods from the class Boat
        //processes:
		while(selection != 4)
		{
			selection = menu();
			switch(selection)
			{
					case 1: Boat boat = new Boat();
							boat.getVIN();
							boat.getOriginalPrice();
							boat.getEngineHours();
							boat.getYearsInService();
							boat.determineAuctionStatus();
							boat.calcAuctionPrice();
							boatList.add(boat);
							break;
					case 2: if(boatList.isEmpty()) //check if the list is empty
								JOptionPane.showMessageDialog(null, "database is empty!");
							else
								for(int i = 0; i < boatList.size(); i++)
									boatList.get(i).dispReport();//get the boat at position i in the list and display it
					        break;
					case 3: if(boatList.isEmpty())
								JOptionPane.showMessageDialog(null, "database is empty!");
							else
							{
								input = JOptionPane.showInputDialog("Enter the VIN to search for: ");
								//validate: 17 digits and letters : question: can we recycle the validation in the class boat
								//while(!checkVIN(input)) //.checkVIN() is a member of the class boat and hence not available this way to main()
								if(!accessor.checkVIN(searchVIN)) //allowed access via the member 'accessor'
								{
									input = JOptionPane.showInputDialog("Wrong VIN! re-Enter the VIN to search for: ");
								}//end while(!checkVIN(input))
					            searchVIN = input;
					            foundAt = searchBoat(searchVIN);
					            if(foundAt == -1)
					            	JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
					            else
					            	boatList.get(foundAt).dispReport();
							}//end else if(boatCount == 0)
							break;
					case 4:  JOptionPane.showMessageDialog(null, "Goodbye!");
				            break;
				    default: JOptionPane.showMessageDialog(null, "Wrong selection! try again...");
					
			}//end switch(selection)
		}//end while(selection != 4)
	}//end main
	//----------------------------------------
	public static int menu()
	{
		int selection = 0;
		String prompt = "-1-Add boat\n"                 +
		                "-2-Display all boats\n"        +
		                "-3-Search for a boat by VIN\n" +
		                "-4-Quit Program\n"             +
		                "\t\tEnter selection 1-4: ";
		input = JOptionPane.showInputDialog(prompt);
		while(!checkSelection(input)) //no need to pass 'input' as it is accessible globally within this class
		{
			JOptionPane.showMessageDialog(null, "Wrong selection! hit ok to try again...");
			input = JOptionPane.showInputDialog(prompt);
		}//end while check
		selection = Integer.parseInt(input);
		return selection;
	}//end menu()
	//-----------------------------------------
	public static int searchBoat(String searchVIN)  //what, how many
	{
		int i = 0;
		while(i < boatList.size())
		{
			if(searchVIN.equalsIgnoreCase(boatList.get(i).vin))
				return i;
			else
				i++; //keep looking
		}//end while i
		return -1;
	}//end searchBoat
	//-------------------------------------------
	//============================================validation method=======================
	public static boolean checkSelection(String input)//we know 'input' is visible, but just to visually see that input is passed
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)))  //if the char 'i' in input is not a digit
				return false;
		return true;
	}//end checkSelection
	//==========================================

}//end class HW3_SOL
//=================================
class Boat
{
	//declarations:
		//object: boat
		String  vin;
		double  originalPrice;
		int     engineHours;
		int     yearsInService;
		boolean toBeAuctionned;
		double  auctionPrice;
		//working variables:
		String input = " ";
		DecimalFormat DF = new DecimalFormat("#####0.00");
	//constructors:
	Boat()
	{
		vin            = " ";
		originalPrice  = 0.0;
		engineHours    = 0;
		yearsInService = 0;
		toBeAuctionned = false;
		auctionPrice   = 0.0;
	}//end const. w/o arguments
	Boat(String vin, double originalPrice, int engineHours, 
		 int yearsInService,boolean toBeAuctionned, double auctionPrice)
	{
		this.vin            = vin;
		this.originalPrice  = originalPrice;
		this.engineHours    = engineHours;
		this.yearsInService = yearsInService;
		this.toBeAuctionned = toBeAuctionned;
		this.auctionPrice   = auctionPrice;
	}//end const. w/ arguments
	//=============================methods========================
	//-----------------------------
	void getVIN()
	{
		input = JOptionPane.showInputDialog("Enter this boat VIN: ");
		//validate: 17 digits and letters for testing use 3 digits
		while(!checkVIN(input))
		{
			input = JOptionPane.showInputDialog("Wrong VIN! re-Enter this boat VIN: ");
		}//end while(!checkVIN(input))
		vin = input;
	}//end getVIN
	void getOriginalPrice()
	{
		input = JOptionPane.showInputDialog("Enter this boat original price:$ ");
		//validate: format ######.## where # is a digit  we are going to ignore the length and worry about the type and '.'
		while(!checkOriginalPrice(input))
		{
			input = JOptionPane.showInputDialog("Wrong price! re-Enter this boat original price (eg. 1234.56):$ ");
		}//end while(!checkOriginalPrice(input))
		originalPrice = Double.parseDouble(input);
	}//end getOriginalPrice
	void getEngineHours()
	{
		input = JOptionPane.showInputDialog("Enter this boat engine hours: ");
		//validate: digits only
		while(!checkEngineHours(input))
		{
			input = JOptionPane.showInputDialog("Wrong hours! re-Enter this boat engine hours: ");
		}//end while(!checkEngineHours(input))
		engineHours = Integer.parseInt(input);
	}//end getEngineHours
	void getYearsInService()
	{
		input = JOptionPane.showInputDialog("Enter this boat years in service: ");
		//validate: digits only
		while(!checkYearsInService(input))
		{
			input = JOptionPane.showInputDialog("Wrong input for years in service! re-Enter this boat years in service: ");
		}//end while(!checkYearsInService(input))
		yearsInService = Integer.parseInt(input);
	}//end getYearsInService
	//-----------------------------
	void determineAuctionStatus()
	{
		if(yearsInService > 5 && engineHours >= 1500 || yearsInService > 10)
			toBeAuctionned = true;
		else
			toBeAuctionned = false;
	}//enddetermineAuctionStatus() 
	void calcAuctionPrice()
	{
		if(toBeAuctionned)  //same as: if(toBeAuctionned == true)
			auctionPrice = originalPrice * .25;
		else //means if(!toBeAuctionned) //same as if(toBeAuctionned == false)
			auctionPrice = 0.0;		
	}//end calcAuctionPrice() 
	//------------------------------
	void dispReport()
	{
		JOptionPane.showMessageDialog(null, "Boat VIN              : "  + vin             + "\n" + 
	                                        "     OriginalPrice    : $" + originalPrice   + "\n" +
				                            "     Engine Hours     : "  + engineHours     + "\n" +
	                                        "     Years in Service : "  + yearsInService  + "\n" +
				                            "     to be auctionned?: "  + toBeAuctionned  + "\n" + 
                                            "     Auction Price    : $" + DF.format(auctionPrice));
	}//end dispReport
	//===============================all  validation methods============================
	boolean checkVIN(String input)
	{
		if(input.length() != 3)//if(input.length() != 17) //using 3 for testing purpose only
			return false;
		else
			for(int i = 0; i < input.length(); i++)
				if(!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)))
					return false;
		return true;
		
	}//end checckVIN
	//==========================================
	boolean checkOriginalPrice(String input)
	{
		int dotCount = 0;
		for(int i = 0; i < input.length(); i++)
		{
			if(!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.')
				return false;
		}//for i
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '.')
				dotCount++;
		}//end for i
		if(dotCount != 1)
			return false;
		if(input.charAt(input.length() - 3) != '.') //if the 3rd position from the back is not a dot
			return false;
		//now that we have passed all possible checks:
		return true;
	}//end checkOriginalPrice
	//========================================
	public static boolean checkEngineHours(String input)//we know 'input' is visible, but just to visually see that input is passed
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)))  //if the char 'i' in input is not a digit
				return false;
		return true;
	}//end checkEngineHours
	//========================================
	public static boolean checkYearsInService(String input)//we know 'input' is visible, but just to visually see that input is passed
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)))  //if the char 'i' in input is not a digit
				return false;
		return true;
	}//end checkYearsInOperation()
	//========================================
	//many validations can be handled by one method: checkSelection(), checkEngineHours(), checkYearsInService()
}//end class Boat
