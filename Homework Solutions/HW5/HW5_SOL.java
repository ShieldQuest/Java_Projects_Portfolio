/*
 * Author: COP2551
 * Date: 12-1-25
 * Description: see in Canvas for full specs.
 */
package hw5_sol;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HW5_SOL 
{
	//declarations:
		//lists of Pro and amateurs:
	    static ArrayList<Professional> proList  = new ArrayList<Professional>();
	    static ArrayList<Amateur>      amatList = new ArrayList<Amateur>();
	    //working vars
	    static String input = " ";
	public static void main(String[] args) 
	{
		//declartions:
			//menu related:
			int mainOption = 0;
			int proOption  = 0;
			int amatOption = 0;
			//search related:
			String searchID = " ";
			int proFoundAt  = -1;
			int amatFoundAt = -1;
			Golfer dummy = new Golfer(); //used as an accessor to access the checkID
		//processes:
		while(mainOption != 3)
		{
			mainOption = mainMenu();
			switch(mainOption)
			{
				case 1: while(proOption != 3)
						{
							proOption = proMenu();
							switch(proOption)
							{
								case 1: Professional pro = new Professional();
									    pro.getID();
									    pro.getFirst();
									    pro.getLast();
									    pro.determineFees();
									    pro.getYears();
									    pro.determineActualFees();
									    proList.add(pro);
									    break;
								case 2: if(proList.isEmpty())
									        JOptionPane.showMessageDialog(null, "Pro Databse id empty!");
										else
										{
											input = JOptionPane.showInputDialog("Enter the ID to search for: ");
											while(!dummy.checkID(input))
											{
												input = JOptionPane.showInputDialog("Invalid ID! re-Enter this golfer ID: ");
											}//end while(!checkID(input))
											searchID = input;
											proFoundAt = searchProfessional(searchID);
											if(proFoundAt == -1)
											     JOptionPane.showMessageDialog(null, searchID + "was not found!");
											else
											{
												proList.get(proFoundAt).dispGolfer();
												proList.get(proFoundAt).dispProfessional();
											}//end else if(proFoundAt == -1) 
										}//end else if(proList.isEmpty())
								        break;
								case 3: JOptionPane.showMessageDialog(null, "Hit ok to go back to main menu...");
										break;
								default: JOptionPane.showMessageDialog(null, "Wrong option...re-enter...");
							}//end switch(proOption) 
						}//end while(proOption != 3)
				        proOption = 0;
				        break;
				case 2: while(amatOption != 3)
						{
					        amatOption = amatMenu();
					        switch(amatOption)
					        {
								case 1: Amateur amat = new Amateur();
								        amat.getID();
								        amat.getFirst();
								        amat.getLast();
								        amat.determineFees();
								        amat.getYears();
								        amat.getGamesPlayed();
								        amat.determineExtraFees();
								        amatList.add(amat);
								        break;
								case 2: if(amatList.isEmpty())
							        		JOptionPane.showMessageDialog(null, "Amat Database id empty!");
										else
										{
											input = JOptionPane.showInputDialog("Enter the ID to search for: ");
											while(!dummy.checkID(input))
											{
												input = JOptionPane.showInputDialog("Invalid ID! re-Enter this golfer ID: ");
											}//end while(!checkID(input))
											searchID = input;
											amatFoundAt = searchProfessional(searchID);
											if(amatFoundAt == -1)
											     JOptionPane.showMessageDialog(null, searchID + "was not found!");
											else
											{
												amatList.get(proFoundAt).dispGolfer();
												amatList.get(proFoundAt).dispAmateur();
											}//end else if(amatFoundAt == -1) 
										}//end else if(amatList.isEmpty())
								        break;
								case 3: JOptionPane.showMessageDialog(null, "Hit ok to go back to main menu...");
								break;
						        default: JOptionPane.showMessageDialog(null, "Wrong option...re-enter...");
					        }//end switch(amatOption)
	
						}//end while(amatOption != 3)
					    amatOption = 0;
					    break;
				case 3: JOptionPane.showMessageDialog(null, "Goodbye!");
				        break;
				default: JOptionPane.showMessageDialog(null, "Wrong option! ok to re-enter...");	
			}//end switch(mainOption)
		}//end while(mainOption != 3)

	}//end main
	//======================================
	public static int mainMenu()
	{
		int mainOption = 0;
		String mainPrompt = "-1-Process Professional Golfer\n" +
		                    "-2-Process Amateur Golfer\n" + 
		                    "-3-Quit Program\n" +
		                    "\t\tEnter option 1-3: ";
		input = JOptionPane.showInputDialog(mainPrompt);
		while(!checkOption(input))
		{
			JOptionPane.showMessageDialog(null, "Invalid main opion! ok to re-enter...");
			input = JOptionPane.showInputDialog(mainPrompt);
		}//end while(!checkOption(input))
		mainOption = Integer.parseInt(input);
		return mainOption;
	}//end mainMenu
	//========================================
	public static int proMenu()
	{
		int proOption = 0;
		String proPrompt = "-1-Add a Professional Golfer\n" +
		                   "-2-Display a Professional Golfer\n" +
				           "-3-Go back to main menu...";
		input = JOptionPane.showInputDialog(proPrompt);
		while(!checkOption(input))
		{
			JOptionPane.showMessageDialog(null, "Invalid pro opion! ok to re-enter...");
			input = JOptionPane.showInputDialog(proPrompt);
		}//end while(!checkOption(input))
		proOption = Integer.parseInt(input);
		return proOption;
	}//end proMenu
	//========================================
	public static int amatMenu()
	
	{
		int amatOption = 0;
		String amatPrompt = "-1-Add an Amateur Golfer\n" +
		                   "-2-Display an Amateur Golfer\n" +
				           "-3-Go back to main menu...";
		input = JOptionPane.showInputDialog(amatPrompt);
		while(!checkOption(input))
		{
			JOptionPane.showMessageDialog(null, "Invalid amat opion! ok to re-enter...");
			input = JOptionPane.showInputDialog(amatPrompt);
		}//end while(!checkOption(input))
		amatOption = Integer.parseInt(input);
		return amatOption;
	}//end amatMenu
	//=========================================
	public static int searchProfessional(String searchID)
	{
		int i = 0;
		while(i < proList.size())
		{
			if(searchID.equalsIgnoreCase(proList.get(i).id))
				return i;
			else
				i++;
		}//end while i
		return -1;
	}//end searchProfessional
	//=========================================
	public static int searchAmateur(String searchID)
	{
		int i = 0;
		while(i < amatList.size())
		{
			if(searchID.equalsIgnoreCase(amatList.get(i).id))
				return i;
			else
				i++;
		}//end while i
		return -1;
	}//end searchAmateur
	//=========================================Validations========================
	public static boolean checkOption(String input)
	{
		String pattern = "^\\d+$";
		return input.matches(pattern);
	}//end checkOption
	//-------------------------------------------
}//end class HW5_SOL
class Golfer
{
	//declarations:
		//object: golfer
		String id;
		String first;
		String last;
		double fees;
		int    years;
		//working variables:
		String input;
	//constructors:
		Golfer()
		{
			id    = " ";
			first = " ";
			last  = " ";
			fees  = 0.0;
			years = 0;
		}//end const. w/o arguments
		Golfer(String id, String first, String last, double fees, int years)
		{
			this.id    = id;
			this.first = first;
			this.last  = last;
			this.fees  = fees;
			this.years = years;
		}//end const. w/ arguments
	//methods:
		//--------------------------
		void getID()
		{
			input = JOptionPane.showInputDialog("Enter this golfer ID: ");
			while(!checkID(input))
			{
				input = JOptionPane.showInputDialog("Invalid ID! re-Enter this golfer ID: ");
			}//end while(!checkID(input))
			id = input;
		}//end getID
		//---------------------------
		void getFirst()
		{
			input = JOptionPane.showInputDialog("Enter this golfer First Name: ");
			while(!checkFirstOrLast(input))
			{
				input = JOptionPane.showInputDialog("Invalid first name! re-Enter this golfer First Name: ");
			}//end while(!checkFirstOrLast(input))
			first = input;
		}//end getFirst 
		//---------------------------
		void getLast()
		{
			input = JOptionPane.showInputDialog("Enter this golfer Last Name: ");
			while(!checkFirstOrLast(input))
			{
				input = JOptionPane.showInputDialog("Invalid last name! re-Enter this golfer Last Name: ");
			}//end while(!checkFirstOrLast(input))
			last = input;
		}//end getLast
		//---------------------------
		void determineFees()
		{
			if(id.charAt(3) == 'P')
				fees = 35000.00;
			else
				if(id.charAt(3) == 'A')
					fees = 8000.00;
		}//end determineFees
		//----------------------------
		void getYears()
		{
			input = JOptionPane.showInputDialog("Enter this golfer years as a member: ");
			while(!checkYears(input))
			{
				input = JOptionPane.showInputDialog("Invalid years! re-Enter this golfer years as a member: ");
			}//end while(!checkYears(input))
			years = Integer.parseInt(input);
		}//end getYears
		//-----------------------------
		void dispGolfer()
		{
			JOptionPane.showMessageDialog(null, "Golfer ID              : " + id + "\n" +
		                                        "       First Name      : " + first + "\n" +
					                            "       Last Name       : " + last + "\n" +
		                                        "       Membership Fees : $" + fees + "\n" +
					                            "       Year as a Member: " + years);
		}//end dispGolver
		//=================================validations===================================
		boolean checkID(String input)
		{
			String pattern = "^[0-9]{3}[PA]$";
			return input.matches(pattern); //will return true or false based on match/ no match
		}//end checkId
		//----------------------------------
		boolean checkFirstOrLast(String input)
		{
			String pattern = "^[A-Za-z]+$";
			return input.matches(pattern);
		}//end checkFirstOrLast
		//----------------------------------
		boolean checkYears(String input)
		{
			String pattern = "^\\d+$";
			return input.matches(pattern);
		}//end checkYears
		//----------------------------------
}//end class Golfer
//===============================================
class Professional extends Golfer
{
	//declarations:
		//object: Pro Golfer
		double actualFees;
		//working vars:
		String input = " ";
	//constructors:
		Professional()
		{
			super();
			actualFees = 0.0;
		}//end const. w/o arguments
		Professional(String id, String first, String last, double fees, int years, double actualFees)
		{
			super(id, first, last, fees, years);
			this.actualFees = actualFees;
		}//end const. w/ arguments
	//methods:
		//---------------------------------
		void determineActualFees()
		{
			if(id.charAt(3) == 'P')
			{
				if(years > 5)
					actualFees = fees - fees * .1;
			}//end if if(id.charAt(3) == 'P')
		}//end determineActualFees
		//---------------------------------
		void dispProfessional()
		{
			JOptionPane.showMessageDialog(null, "Professional Golfer Actual Fees: " + actualFees);
			
		}//end dispProfessionl
		//-------------------------------NO validations----------------------
}//end class Pro
//====================================================
class Amateur extends Golfer
{
	//declarations:
		//object: Amateur Golfer
		int gamesPlayed;
		double extraFees;
		//working vars:
		String input = " ";
	//constructors:
		Amateur()
		{
			super();
			gamesPlayed = 0;
			extraFees   = 0.0;
		}//end const w/o arguments
		Amateur(String id, String first, String last, double fees, int years, int gamesPlayed, double extraFees)
		{
			super(id, first, last, fees, years);
			this.gamesPlayed = gamesPlayed;
			this.extraFees = extraFees;
		}//end const. w/ arguments
	//methods:
		//---------------------------------
		void getGamesPlayed()
		{
			input = JOptionPane.showInputDialog("Enter this Amateur Golfer Games Played: ");
			while(!checkGames(input))
			{
				input = JOptionPane.showInputDialog("Invalid games! re-Enter this Amateur Golfer Games Played: ");
			}//end while(!checkGames(input))
			gamesPlayed = Integer.parseInt(input);
		}//end getGamesPLayed
		//----------------------------------
		void determineExtraFees()
		{
			extraFees = gamesPlayed * 50.00;
			fees = fees + extraFees;
		}//end determineExtraFees
		//----------------------------------
		void dispAmateur()
		{
			JOptionPane.showMessageDialog(null, "Amateur Games Played:  " + gamesPlayed + "\n" +
		                                        "        Extra Fees  : $" + extraFees);
		}//end dispAmateur
		//--------------------------validations---------------------------		
		//----------------------------------
		boolean checkGames(String input)
		{
			String pattern = "^\\d+$";
			return input.matches(pattern);
		}//end checkGames
		//----------------------------------
}//end class Amateur
