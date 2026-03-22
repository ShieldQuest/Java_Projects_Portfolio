/*
 * Author: COP2551
 * Date: 10-18-25
 * Description: see full specs for HW3 in Canvas 
 */
package hw3_sol;
//imports:
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class HW3_SOL 
{
	//'global' vars:
	static Boat [] boat = new Boat[100];
	static String input = " ";

	public static void main(String[] args) 
	{
		//declarations
			//working variables:
			int selection    = 0;
			int boatCount    = 0;
			String searchVIN = " ";
			int foundAt      = -1;
        //processes:
		while(selection != 4)
		{
			selection = menu();
			switch(selection)
			{
					case 1: boat[boatCount] = new Boat();
							boat[boatCount].getVIN();
							boat[boatCount].getOriginalPrice();
							boat[boatCount].getEngineHours();
							boat[boatCount].getYearsInService();
							boat[boatCount].determineAuctionStatus();
							boat[boatCount].calcAuctionPrice();
							boatCount++; //move to the next boat in the array
							break;
					case 2: if(boatCount == 0)
								JOptionPane.showMessageDialog(null, "database is empty!");
							else
								for(int i = 0; i < boatCount; i++)
									boat[i].dispReport();
					        break;
					case 3: if(boatCount == 0)
								JOptionPane.showMessageDialog(null, "database is empty!");
							else
							{
								input = JOptionPane.showInputDialog("Enter the VIN to search for: ");
								//validate: 17 digits and letters : question: can we recycle the validation in the class boat
					            searchVIN = input;
					            foundAt = searchBoat(searchVIN, boatCount);
					            if(foundAt == -1)
					            	JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
					            else
					            	boat[foundAt].dispReport();
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
		input = JOptionPane.showInputDialog("-1-Add boat\n"                 +
	                                        "-2-Display all boats\n"        +
				                            "-3-Search for a boat by VIN\n" +
	                                        "-4-Quit Program\n"             +
				                            "\t\tEnter selection 1-4: ");
		//validate: digit only
		selection = Integer.parseInt(input);
		return selection;
	}//end menu()
	//-----------------------------------------
	public static int searchBoat(String searchVIN, int boatCount)  //what, how many
	{
		int i = 0;
		while(i < boatCount)
		{
			if(searchVIN.equalsIgnoreCase(boat[i].vin))
				return i;
			else
				i++; //keep looking
		}//end while i
		return -1;
	}//end searchBoat
	//-------------------------------------------
	//============================================validation method=======================

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
	Boat(String vin, double orginalPrice, int engineHours, 
		 int yearsInService,boolean toBeAucionned, double auctionPrice)
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
		//validate: 17 digist and letters for testing use 3 digits
		vin = input;
	}//end getVIN
	void getOriginalPrice()
	{
		input = JOptionPane.showInputDialog("Enter this boat original price:$ ");
		//validate: format ######.## where # is a digit
		originalPrice = Double.parseDouble(input);
	}//end getOriginalPrice
	void getEngineHours()
	{
		input = JOptionPane.showInputDialog("Enter this boat engine hours: ");
		//validate: digits only
		engineHours = Integer.parseInt(input);
	}//end getEngineHours
	void getYearsInService()
	{

		input = JOptionPane.showInputDialog("Enter this boat years in service: ");
		//validate: digits only
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
}//end class Boat
