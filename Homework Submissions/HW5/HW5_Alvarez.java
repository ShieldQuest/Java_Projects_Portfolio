/*
 *      Author: Robert Alvarez
 *      Date: 11-30-25
 *      Description: program manages membership in a Golfing Club. Registers 
 *                   professional and amateur golfers, searches by golfer ID, 
 *                   and displays their information.
 */
package hw5_Alvarez;
//import
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class HW5_Alvarez 
{
	// declarations
			static ArrayList<ProfessionalGolfer> proList = new ArrayList<ProfessionalGolfer>();
			static ArrayList<AmateurGolfer> amList = new ArrayList<AmateurGolfer>();
	// Working variables
			static String input = " ";
	public static void main(String[] args) 
	{
			// declarations
	                //objects
        					int mainMenu       = 0;
        					int proMenu        = 0;
        					int amMenu         = 0;
        					int proFoundAt     = -1;
        					int amateurFoundAt = -1;
        					int start          = 0;
        			//working var
    					    String searchID    = " ";
			// processes
        			start = JOptionPane.showConfirmDialog(null, "Golfing Club Registration Program!" + "\n" +
        			                                            "Begin? ", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(start == JOptionPane.NO_OPTION)
                    {
                            JOptionPane.showMessageDialog(null, "Program closing. Farewell!");
                    }//end if start
                    else
                    {
        					while (mainMenu != 3) 
        					{
        							mainMenu = getMainMenu();
        							switch (mainMenu) 
        							{
        									case 1: while (proMenu != 3) 
        										    {
        											       proMenu = getProMenu();
        											       switch (proMenu) 
                        										{
                                                                       //---------------------------------------------------------
                            											case 1 : ProfessionalGolfer pro = new ProfessionalGolfer();
                            												     pro.getGolferData();
                            												     pro.getProfessionalData();
                            												     pro.dispProGolfer();
                                                                                 proList.add(pro);
                            												     break;            
                                                                       //---------------------------------------------------------
                            											case 2: if (proList.isEmpty()) 
                            											        {
                            													        JOptionPane.showMessageDialog(null, "Database is empty!");
                            											        }//end if
                            											        else 
                            											        {
                            											                input = JOptionPane.showInputDialog("Enter Golfer ID to search (3-digits + P): ");
                        										                        //-----------------------
                                                                                        while (!checkProSearchID(input)) 
                            											                {
                            											                        input = JOptionPane.showInputDialog("Invalid ID! Re-enter Golfer ID to search (3-digits + P): ");
                            											                }//end while
                        										                        //-----------------------
                            											                searchID = input;
                            											                proFoundAt = searchProfessional(searchID);
                                                                                        //-----------------------
                            											                if (proFoundAt == -1)
                            											                {
                            											                        JOptionPane.showMessageDialog(null, searchID + " was not found!");
                            											                }//end if
                            											                else
                            											                {
                            											                        proList.get(proFoundAt).dispGolfer();
                            											                }//end else
                            											         }//end else
                            												    break;
                            												    //---------------------------------------------------------
                            											case 3: JOptionPane.showMessageDialog(null, "Back to main menu...");
                            												    break;
                            										   default: JOptionPane.showMessageDialog(null, "Invalid option!");
                        										}//end switch proMenu
        										    }//end while
        										    proMenu = 0;
        										    break; //end proMenu
                                            case 2: while (amMenu != 3) 
                                                    {
        										            amMenu = getAmMenu();
                    										switch (amMenu) 
                    										{
                        											case 1: AmateurGolfer am = new AmateurGolfer();
                            												am.getGolferData();
                            												am.getAmateurData();
                            												am.dispAmGolfer();
                                                                            amList.add(am);
                            												break;
                                                                    //---------------------------------------------------------
                        											case 2: if (amList.isEmpty()) 
                        											        {
                        													        JOptionPane.showMessageDialog(null, "Database is empty!");
                        											        }//end if
                        											        else 
                        											        {
                                													input = JOptionPane.showInputDialog("Enter Golfer ID to search (3-digits + A): ");
                                													while (!checkAmSearchID(input)) 
                                													{
                                														    input = JOptionPane.showInputDialog("Invalid ID! Re-enter Golfer ID to search (3-digits + A): ");
                                													}//end while
                        													}//end else
                        											        //-----------------------
                        													searchID = input;
                        													amateurFoundAt = searchAmateur(searchID);
                                                                            //-----------------------
                        													if (amateurFoundAt == -1)
                        													{
                        														    JOptionPane.showMessageDialog(null, searchID + " was not found!");
                        													}//end if
                        													else
                        													{
                        														    amList.get(amateurFoundAt).dispGolfer();
                        													}//end else
                        													break;
                                                                    //---------------------------------------------------------
                        											case 3: JOptionPane.showMessageDialog(null, "Back to main menu...");
                    												        break;
                        										   default: JOptionPane.showMessageDialog(null, "Invalid option!");
                    										}//end switch amMenu
                    								}//end while amMenu
                    								amMenu = 0;
                    								break;
                                            case 3: JOptionPane.showMessageDialog(null, "Thank you for using this app!");
        									        break;
        								   default: JOptionPane.showMessageDialog(null, "Invalid option!");
        							}//end switch mainMenu
        					}//end while mainMenu
        			}//end else start
	}//end main
    //menu methods ========================================================================================
				public static int getMainMenu() 
				{
    					String prompt = "Main Menu:\n" + 
                                        "------------------------------" + "\n" +
    					                "-1-Process Professional Golfer" + "\n" +
    					                "-2-Process Amateur Golfer"      + "\n" + 
    					                "-3-Quit Program"                + "\n" +
    				                    "Enter option 1-3: ";
    					input = JOptionPane.showInputDialog(prompt);
                        //-----------------------
    					while (!checkMenu(input))
    					{
                                JOptionPane.showMessageDialog(null, "Invalid option!");
                                input = JOptionPane.showInputDialog(prompt);
    					}//end while
                        //-----------------------
    					return Integer.parseInt(input);
				}//end getMainMenu
                //-----------------------------------------------------------------------
				public static int getProMenu() 
				{
    					String prompt = "Professional Golfer Menu:"        + "\n" +
                                        "--------------------------------" + "\n" +
            							"-1-Add Professional Golfer"       + "\n" +
            							"-2-Display a Professional Golfer" + "\n" + 
            							"-3-Back to Main Menu"             + "\n" +
            							"Enter option 1-3: ";
    					input = JOptionPane.showInputDialog(prompt);
                        //-----------------------
    					while (!checkMenu(input))
    					{
                                JOptionPane.showMessageDialog(null, "Invalid option!");
                                input = JOptionPane.showInputDialog(prompt);
    					}//end while
                        //-----------------------
    					return Integer.parseInt(input);
				}//end getProMenu
                //-----------------------------------------------------------------------
				public static int getAmMenu() 
				{
    					String prompt = "Amateur Golfer Menu:"         + "\n" + 
                                        "----------------------------" + "\n" +
    					                "-1-Add Amateur Golfer"        + "\n" +
    					                "-2-Display an Amateur Golfer" + "\n" + 
    					                "-3-Back to Main Menu"         + "\n" +
    					                "Enter option 1-3: ";
    					input = JOptionPane.showInputDialog(prompt);
    					//-----------------------
    					while (!checkMenu(input))
    					{
    						    JOptionPane.showMessageDialog(null, "Invalid option!");
    					        input = JOptionPane.showInputDialog(prompt);
    					}//end while
                        //-----------------------
    					return Integer.parseInt(input);
				}//end getAmMenu
		//Search methods ========================================================================================
				public static int searchProfessional(String searchID) 
				{
    					int i = 0;
    					while (i < proList.size()) 
    					{
        						if(searchID.equalsIgnoreCase(proList.get(i).id))
        						{
        							    return i;
        						}//end if
        						else
        						{
        							    ++i;
        						}//end else
    					}//end while
    					return -1;
				}//end searchProfessional
                //-----------------------------------------------------------------------
				public static int searchAmateur(String searchID) 
				{
    					int i = 0;
    					while (i < amList.size()) 
    					{
        						if (searchID.equalsIgnoreCase(amList.get(i).id))
        						{
        							    return i;
        						}//end if
        						else
        						{
        							    ++i;
        						}//end else
    					}//end while
    					return -1;
				}//end searchAmateur
		//validation method ========================================================================================
				public static boolean checkMenu(String input) 
				{
    					if (input.isEmpty())
    					{
    						    return false;
    					}//end if
                        //-----------------------
    					for (int i = 0; i < input.length(); i++)
    					{
        						if (!Character.isDigit(input.charAt(i)))
        						{
        							return false;
        						}//end if
    					}//end for
    					return true;
				}//end checkMenu
                //-------------------------------------------------
				public static boolean checkAmSearchID(String input)
	            {
	                    if(input.isEmpty())
	                    {
	                            return false;
	                    }//end if
	                    //-------------------------------------
	                    if(input.length() != 4)
	                    {
	                            return false;
	                    }//end if
	                    //-------------------------------------
	                    for(int i = 0; i < input.length(); i++)
	                    {
	                            if(!Character.isDigit(input.charAt(i)) && input.charAt(input.length() - 4) != 'A')  
	                            {
	                                    return false;
	                            }//end if digit
	                    }//end for 1
	                    return true;
	            }//end checkSearchID   
                //-------------------------------------------------
				public static boolean checkProSearchID(String input)
                {
                        if(input.isEmpty())
                        {
                                return false;
                        }//end if
                        //-------------------------------------
                        if(input.length() != 4)
                        {
                                return false;
                        }//end if
                        //-------------------------------------
                        for(int i = 0; i < input.length(); i++)
                        {
                                if(!Character.isDigit(input.charAt(i)) && input.charAt(input.length() - 4) != 'P')  
                                {
                                        return false;
                                }//end if digit
                        }//end for 1
                        return true;
                }//end checkSearchID   
}//end class HW5_Alvarez
//SUPER CLASS ==========================================================================================
class Golfer 
{
    	//declaration
            	String id;
            	String firstName;
            	String lastName;
            	int    yearsMember;
            	double baseFees;
        //working var
            	DecimalFormat DF = new DecimalFormat("###,##0.00");
            	String input     = " ";
    	//constructors
            	Golfer() 
            	{
                		id          = " ";
                		firstName   = " ";
                		lastName    = " ";
                		yearsMember = 0;
                		baseFees    = 0.0;
            	}//end const. w/o argument
            	Golfer(String id, String firstName, String lastName, int yearsMember, double baseFees)
            	{
            	        this.id          = id;
                        this.firstName   = firstName;
                        this.lastName    = lastName;
                        this.yearsMember = yearsMember;
                        this.baseFees    = baseFees;            	    
            	}//end const. w/ argument
    	//input method =========================================================================================
            	void getGolferData()
            	{
                		input = JOptionPane.showInputDialog("Enter Golfer ID (3 digits): ");
                		        while (!checkID(input))
                		        {
                		                input = JOptionPane.showInputDialog("Invalid ID! Re-enter Golfer ID (3 digits): ");
                		        }//end while
                		        id = input;
                		//-----------------------------------------------------------------------
                		input = JOptionPane.showInputDialog("Enter first name: ");
                		        while (!checkLetters(input))
                		        {
                		                input = JOptionPane.showInputDialog("Invalid! Re-enter first name: ");
                		        }//end while
                		        firstName = input;
                		//-----------------------------------------------------------------------
                		input = JOptionPane.showInputDialog("Enter last name: ");
                	            while (!checkLetters(input))
                	            {
                	                    input = JOptionPane.showInputDialog("Invalid! Re-enter last name: ");
                	            }//end while
                	            lastName = input;
                	    //-----------------------------------------------------------------------
                	    input = JOptionPane.showInputDialog("Enter years as a member: ");
                	            while (!checkDigits(input))
                	            {
                	                    input = JOptionPane.showInputDialog("Invalid! Re-enter years: ");
                	            }//end while
                	            yearsMember = Integer.parseInt(input);
                 }//end getGolferData
    	//display method ===========================================================================================
            	void dispGolfer() 
            	{
            		    JOptionPane.showMessageDialog(null, "Golfer Information:\n" + 
            		                                        "---------------------------------------------" + "\n" +
            		                                        "ID: "                    + id                  + "\n" + 
            		                                        "First Name: "            + firstName           + "\n" + 
            		                                        "Last Name: "             + lastName            + "\n" + 
            		                                        "Years as Member: "       + yearsMember         + "\n");  
            	}//end dispGolfer
         //validation method ========================================================================================
            	boolean checkID(String input) 
                {
                	    if(input.isEmpty())
                        {
                                return false;
                        }//end if empty
                        //-----------------------
            		    if (input.length() != 3)
            		    {
            		            return false;
            		    }//end if not 3
                        //-----------------------
            		    for (int i = 0; i < input.length(); i++)     
            		    {
            		            if (!Character.isDigit(input.charAt(i)))  
            		            {
            		                    return false;
            		            }//end if not digit
            		    }//end for i
        		        return true;
		        }//end checkID 
                //-----------------------------------------------------------------------
            	boolean checkLetters(String input) 
            	{
                        if(input.isEmpty())
                        {
                                return false;
                        }//end if empty
                        //-----------------------
                        for (int i = 0; i < input.length(); i++)
                        {
                                if (!Character.isLetter(input.charAt(i)))
                                {
                                        return false;
                                }//end if not letters
                        }//end for
                        return true;
            	}//end checkLetters
                //-----------------------------------------------------------------------
            	boolean checkDigits(String input) 
            	{
                        if(input.isEmpty())
                        {
                                return false;
                        }//end if empty
                        //-----------------------
                        for (int i = 0; i < input.length(); i++)
                        {
                                if (!Character.isDigit(input.charAt(i)))
                                {
                                        return false;
                                }//end if
                        }//end for
                        return true;
            	}// end checkDigits
}//end class Golfer
//SUBClass Professional =========================================================
class ProfessionalGolfer extends Golfer 
{
    	//declaration
                double actualFees;
        //constructors
            	ProfessionalGolfer() 
            	{
                		super();
                		actualFees = 0.0;
            	}//end const. w/o arguments
            	ProfessionalGolfer(String id, String firstName, String lastName, int yearsMember, double baseFees, double actualFees)
            	{
            	        super(id, firstName, lastName, yearsMember, baseFees);
            	        this.actualFees = actualFees;
            	}//end const. w/ arguments
        //process method ======================================================
            	void getProfessionalData() 
            	{
            		    baseFees = 35000.00;
            		    if (yearsMember > 5)
            		    {
            		            actualFees = baseFees * 0.90; // 10% discount
            		    }//end if
            		    else
            		    {
            		            actualFees = baseFees;
            		    }//end else
            	}//end getProfessionalData
         //display method ======================================================
            	void dispProGolfer() 
            	{  
            	        id = id + 'P';  //*****************************************************************************************************
                	    dispGolfer();
                	    JOptionPane.showMessageDialog(null, "Professional Golfer Fee:"                 + "\n" +
                		                                    "----------------------------------------" + "\n" +
                		                                    "Actual Yearly Fees: $" + DF.format(actualFees));
            	}//end dispGolfer
}//end class ProfessionalGolfer
//SubClass Amateur =========================================================
class AmateurGolfer extends Golfer 
{
        //declaration
                int    gamesPlayed;
                double extraFees;
        //constructors
            	AmateurGolfer() 
            	{
                		super();
                		gamesPlayed = 0;
                		extraFees   = 0.0;
            	}//end const. w/o arguments
            	AmateurGolfer(String id, String firstName, String lastName, int yearsMember, double baseFees, int gamesPlayed, double extraFees)
            	{
                        super(id, firstName, lastName, yearsMember, baseFees);
            	        this.gamesPlayed = 0;
            	        this.extraFees   = 0.0;
            	}//end const. w/ arguments
         //process method ======================================================
            	void getAmateurData() 
            	{
                		baseFees = 8000.00;
                		input    = JOptionPane.showInputDialog("Enter number of games played last year: ");
                        //-----------------------
                		while (!checkDigits(input))
                		{
                			    input = JOptionPane.showInputDialog("Invalid! Re-enter number of games: ");
                		}//end while
                        //-----------------------
                		gamesPlayed = Integer.parseInt(input);
                		extraFees   = baseFees + 50.00;
            	}//end getAmateurData
          //display method ======================================================
            	void dispAmGolfer() 
            	{
                        id = id + 'A';  //*****************************************************************************************************
            	        dispGolfer();
                        JOptionPane.showMessageDialog(null, "Amateur Golfer Games:\n" + 
                                                            "-----------------------------" + "\n"        +
                                                            "Games Played Last Year: "      + gamesPlayed + "\n");
                                                          //-----------------------
                		JOptionPane.showMessageDialog(null, "Amateur Golfer Fee:\n" + 
                                                            "------------------------------------"  + "\n" +
                                                            "Base fees: "                + baseFees + "\n" +
                                                            "Extra Fees ($50) added : $" + DF.format(extraFees));
            	}//end dispGolfer
}//end AmateurGolfer
