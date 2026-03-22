/*
 * 	Author: Robert Alvarez
 * 	Date: 11-16-25
 * 	Description: this program defines a Vehicle superclass and two subclasses, 
 * 				 Car and Boat, using 'inheritance'. It stores multiple vehicles 
 * 				 in an 'ArrayList' and interacts with the user through 'JOptionPane' 
 * 				 dialogs for input and output.
 */
//Imports:
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
//======================
public class HW4_Alvarez
{
		//declarations:
				//working variables:
				static ArrayList<Car> CarList 	= new ArrayList<Car>();
				static ArrayList<Boat> BoatList = new ArrayList<Boat>();
				static String input 			= " ";
		//======================
	public static void main(String[] args) 
	{
			//declaration:
					//working variables:
							int mainChoice = 0;
							int carChoice  = 0;
							int boatChoice = 0;
							//.....................
							String searchVIN = " ";
							int carFoundAt	 = -1;
							int boatFoundAt	 = -1;
							//.....................
			//processes:
			while(mainChoice != 3)
			{
					mainChoice = mainMenu();
					switch(mainChoice)
					{
							case 1: while(carChoice != 3)
									{
											carChoice =CarMenu();
											switch(carChoice)
											{
													case 1: Car car = new Car();
															car.getVIN();
															car.getMake();
															car.getModel();
															car.getEngineSize();
																CarList.add(car);
															break;
													case 2: if(CarList.isEmpty())
																	JOptionPane.showMessageDialog(null, "Database is empty!");
															else
															{
																	input = JOptionPane.showInputDialog("Enter Car VIN to search for: ");
																	//validation
																	searchVIN = input;
																	carFoundAt = searchCar(searchVIN); 
																	if(carFoundAt == -1)
																			JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
																	else
																	{
																			CarList.get(carFoundAt).dispVehicle();
																			CarList.get(carFoundAt).dispCar();

																	}//end if
															}//end if
															break;
													case 3: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
															break;
												   default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");							
											}//end switch										
									}//end case 1 while
									carChoice = 0;
									break;
							case 2: while(boatChoice != 3)
									{
											boatChoice = BoatMenu();
											switch(boatChoice)
											{
													case 1: Boat boat = new Boat();
															boat.getVIN();
															boat.getMake();
															boat.getModel();
															boat.getBoatType();
															boat.getEngineHours();
																BoatList.add(boat);
															break;
													case 2: if(BoatList.isEmpty())
																	JOptionPane.showMessageDialog(null, "Database is empty!");
															else
															{
																	input = JOptionPane.showInputDialog("Enter boat VIN to search for: ");
																	//validation
																	searchVIN = input;
																	boatFoundAt = searchBoat(searchVIN); 
																	if(boatFoundAt == -1)
																			JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
																	else
																	{
																			BoatList.get(boatFoundAt).dispVehicle();
																			BoatList.get(boatFoundAt).dispBoat();

																	}//end if
															}//end if
															break;
													case 3: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
															break;
												   default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");							
											}//end switch										
									}//end case 2: while
									boatChoice = 0;
									break;
							case 3: JOptionPane.showInternalMessageDialog(null, "Goodbye!");
									break;
						   default: JOptionPane.showMessageDialog(null, "Wrong choice! try again...");							
					}//end switch
			}//end while
	}//end main()
	//========================== mainMenus ==========================
	public static int mainMenu()
	{
			int mainChoice = 0;
			String prompt = "-1-Process a Car\n"	+
							"-2-Process a Boat\n" 	+
							"-3-Quit\n" 			+ 
							"\tEnter choice 1-3: ";
			input = JOptionPane.showInputDialog(prompt);
			//validation
			while(!checkChoice(input))
			{
					JOptionPane.showMessageDialog(null, "Wrong Choice! Hit ok to try again...");
					input = JOptionPane.showInputDialog(prompt);
			}//end while
			mainChoice = Integer.parseInt(input);
			return mainChoice;
	}//end mainMenu()
	//==============================
	public static int CarMenu()
	{
			int carChoice = 0;
			String prompt = "-1-add car\n"				+
							"-2-Display car\n" 			+
							"-3-Go back to main menu\n" +	 
							"\tEnter choice 1-3: ";
			input = JOptionPane.showInputDialog(prompt);
			//validation
			while(!checkChoice(input))
			{
					JOptionPane.showMessageDialog(null, "Wrong Choice! Hit ok to try again...");
					input = JOptionPane.showInputDialog(prompt);
			}//end while
			carChoice = Integer.parseInt(input);
			return carChoice;
	}//end CarMenu()
	//============================== 
	public static int BoatMenu()
	{
			int boatChoice = 0;
			String prompt = "-1-add boat\n"				+
							"-2-Display boat\n" 		+
							"-3-Go back to main menu\n" +	 
							"\tEnter choice 1-3: ";
			input = JOptionPane.showInputDialog(prompt);
			//validation
			while(!checkChoice(input))
			{
					JOptionPane.showMessageDialog(null, "Wrong Choice! Hit ok to try again...");
					input = JOptionPane.showInputDialog(prompt);
			}//end while
			boatChoice = Integer.parseInt(input);
			return boatChoice;
	}//end BoatMenu()
	//========================== Search Method ==========================
	public static int searchCar(String searchVIN)
	{
			int i = 0;
			while(i < CarList.size())
			{
				if(searchVIN.equals(CarList.get(i).VIN))
				{
					return i;
				}
				else
				{
					++i;
				}//end if
			}//end while
			return -1; 
	}//end searchCar()
	//==============================
	public static int searchBoat(String searchVIN)
	{
			int i = 0;
			while(i < BoatList.size())
			{
					if(searchVIN.equals(BoatList.get(i).VIN))
					{
							return i;
					}
					else
					{
							++i;//keep searching
					}//end if
			}//end while
			return -1; 
	}//end searchBoat()
	//========================== Validation Method ==========================
	public static boolean checkChoice(String input)
	{
			for(int i = 0; i < input.length(); i++)
			{
					if(!Character.isDigit(input.charAt(i)))
					{
							return false;
					}//end if
			}//end for
			return true;
	}//end checkChoice()
	//==============================
}//end class HW4_Alvarez
//====================== class Vehicle =======================
class Vehicle
{
		//declarations
				//object: vehicle
				String VIN;
				String Make;
				String Model;
				//working variables
				String input = " ";
		//constructors:
				Vehicle()
				{
						VIN	   = " ";
						Make   = " ";
						Model  = " ";
				}//end constructor w/o arguments
				Vehicle(String VIN, String Make, String Model)
				{
						this.VIN 	   = VIN;
						this.Make = Make;
						this.Model  = Model;
				}//end constructor w/ arguments
				//================== mainMenus Methods ==================
				void getVIN()
				{
						input = JOptionPane.showInputDialog("Enter vehicle VIN: ");
						//validation
						while(!checkVIN(input))
						{
								input = JOptionPane.showInputDialog("Wrong VIN! Enter vehicle VIN: ");
						}//end while
						VIN   = input;
				}//end getVIN()
				//==============================
				void getMake()
				{
						input = JOptionPane.showInputDialog("Enter vehicle make: ");
						//validation
						while(!checkMake(input))
						{
								input = JOptionPane.showInputDialog("Wrong entry! Use only letters. Enter vehicle make: ");
						}//end while
						Make = input;
				}// end getMake()
				//==============================
				void getModel()
				{
						input = JOptionPane.showInputDialog("Enter vehicle model: ");
						//validation
						while(!checkModel(input))
						{
								input = JOptionPane.showInputDialog("Wrong entry! Use only letters. Enter vehicle model: ");
						}//end while
						Model = input;
				}// end getModel()
				//==============================
				void dispVehicle()
				{
						JOptionPane.showMessageDialog(null, "Vehicle VIN: "   + VIN   + "\n" +
															"Vehicle Make: "  + Make  + "\n" +
															"Vehicle Model: " + Model);
				}//end dispVehicle()
				//================== all validation methods ==================
				boolean checkVIN(String input)
				{
						if(input.length() != 10)
						{
								return false;
						}
						else
						{
								for(int i = 0; i < input.length(); i++)
								{
										if(!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)))
										{
											return false;
										}//end if
								}//end for
						}//end if
						return true; 
				}//end checkVIN()
				//==============================
				boolean checkMake(String input)
				{
						for(int i = 0; i < input.length(); i++)
						{
								if(!Character.isLetter(input.charAt(i)))
								{
										return false;
								}//end if
						}//end for
						return true; 
				}//end checkMake()
				//==============================
				boolean checkModel(String input)
				{
						for(int i = 0; i < input.length(); i++)
						{
								if(!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)))
								{
										return false;
								}//end if
						}//end for
						return true; 
				}//end checkModel()
				//==============================
}//end class Vehicle
//======================= all subclasses =======================
class Car extends Vehicle //Car inherits from vehicle
{
		//declarations
				//object: car 
						double  engineSize;
				//working variable:
						String input	 = " ";
						DecimalFormat DF = new DecimalFormat("#####0.0");
				//constructors:
						Car()
						{
								super(); 	//this will construct the part 'Vehicle' of a Car
								engineSize  = 0.0; 		//it calls the Vehicle class into play
						}//end const w/o argument
						Car(String VIN, String Make, String Model, double engineSize)
						{
								super(VIN, Make, Model); //Constructing the part 'Vehicle' by
								this.engineSize = engineSize; //invoking the constructor w/ arguments in 'Vehicle'.
						}//end constructor w/ argument
						//========================= Methods =======================
						void getEngineSize()
						{
								input = JOptionPane.showInputDialog("Enter car engine size ('#.#'): ");
								//validate: format '##.##'
								while(!checkEngineSize(input))
								{
										input = JOptionPane.showInputDialog("Invalid! re-Enter car engine size ('#.#'): ");
								}//end while
								engineSize  = Double.parseDouble(input);
						}//end getEngineSize()
						//==============================
						void dispCar()
						{
								JOptionPane.showMessageDialog(null, "Car engine size: " + DF.format(engineSize));
						}//end dispCar()
						//================== all validation methods ==================
						boolean checkEngineSize(String input)
						{
								int dotCount = 0;
								for(int i = 0; i < input.length(); i++)
								{
										if(!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.')
										{
												return false;
										}//end if
								}//end for 
								for(int i = 0; i < input.length(); i++)
								{
										if(input.charAt(i) == '.')
										{
												dotCount++;
										}//end if
								}//end for i
								if(dotCount != 1)
								{
										return false;
								}//end if
								if(input.charAt(input.length() - 2) != '.')
								{
										return false;
								}//end if
								return true;
						}//end checkEngineSize()
						//==============================
}//end class Car
class Boat extends Vehicle //Boat inherits from Vehicle
{
		//declarations
				//object: boat
						String boatType;
						int engineHours;
				//working variable:
						String input	 = " ";
		//constructors:
				Boat()
				{
						super(); 
						boatType  = " "; 		
						engineHours = 0;
						
				}//end const w/o argument
				Boat(String VIN, String Make, String Model, String boatType, int engineHours)
				{
						super(VIN, Make, Model); 
						this.boatType  = boatType; 			
						this.engineHours = engineHours;
				}//end constructor w/ argument
				//========================= Methods =======================
				void getBoatType()
				{
						input = JOptionPane.showInputDialog("Enter boat type: ");
						//validation
						while(!checkBoatType(input))
						{
								input = JOptionPane.showInputDialog("Invalid! re-Enter boat type: ");
						}//end while
						boatType  = input;
				}//end getBoatType()
				//==============================
				void getEngineHours()
				{
						input = JOptionPane.showInputDialog("Enter boat engine hours: ");
						//validation
						while(!checkEngineHours(input))
						{
								input = JOptionPane.showInputDialog("Invalid! re-Enter boat engine hours: ");
						}//end while
						engineHours = Integer.parseInt(input);
				}//end getEngineHours()
				//==============================
				void dispBoat()
				{
						JOptionPane.showMessageDialog(null, "Boat Type: "  		  + boatType	+ "\n" +
															"Boat engine hours: " + engineHours);
				}//end dispBoat()
				//================== all validation methods ==================
				boolean checkBoatType(String input)
				{
						for(int i = 0; i < input.length(); i++)
						{
								if(!Character.isLetter(input.charAt(i)))
								{
										return false;
								}//end if
						}//end for
						return true;
				}//end checkBoatType()	
				//==============================
				boolean checkEngineHours(String input)
				{
						for(int i = 0; i < input.length(); i++)
						{
								if(!Character.isDigit(input.charAt(i)))
								{
										return false;
								}//end if
						}//end for
						return true;
				}//end checkEngineHours()
				//==============================
}//end class Boat
