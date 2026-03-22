/*
 * Author: COP2551
 * Date: 11-17-25
 * Description: see full specs in Canvas
 */
package hw4_sol;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HW4_SOL 
{
	//declarations:
		//objects: Car and Boat
			static ArrayList<Car> carList = new ArrayList<Car>();
			static ArrayList<Boat> boatList = new ArrayList<Boat>();
		//working variables:
			static String input = " ";
	public static void main(String[] args) 
	{
		//declarations:
		int mainOption   = 0;
		int carOption    = 0;
		int boatOption   = 0;
		int start        = 0;
		String searchVIN = " ";
		int carFoundAt   = -1;
		int boatFoundAt  = -1;
		Vehicle dummy = new Vehicle(); //this will be used to access methods from the class Vehicle
		                               //eg. the checkVIN() method so we don't have to code it again.
		
		
		//processes:
		start = JOptionPane.showConfirmDialog(null, "Car/boat program. Proceed?", "Confirm", JOptionPane.YES_NO_OPTION);
		if(start == JOptionPane.NO_OPTION)
			JOptionPane.showMessageDialog(null, "Thank you for visiting this application!");
		else
		{
			while(mainOption != 3)
			{
				mainOption = mainMenu();
				switch(mainOption)
				{
					//......................................................................
					case 1: while(carOption != 3)
							{
							  carOption = carMenu();
							  switch(carOption)
							  {
								  case 1: Car car = new Car();
								          car.getVIN();
								          car.getMake();
								          car.getModel();
								          car.getEngineSize();
								          carList.add(car);
								          break;
								  case 2: if(carList.isEmpty())
									  		JOptionPane.showMessageDialog(null, "Database is empty!");
										  else
										  {
											  input = JOptionPane.showInputDialog("Enter the VIN for this car: ");
											 while(!dummy.checkVIN(input))
											 {
												 input = JOptionPane.showInputDialog("Enter the VIN for this car: "); 
											 }//end  while(!dummy.checkVIN(input))
											  searchVIN = input;
											  carFoundAt = searchCar(searchVIN);
											  if(carFoundAt == -1)
												  JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
											  else
											  {
												  carList.get(carFoundAt).dispVehicle();
												  carList.get(carFoundAt).dispCar();
											  }//end else if(carFoundAt == -1)
										  }//end else if(carList.isEmpty())
								           break;
								  case 3: JOptionPane.showMessageDialog(null, "Ok to go back to main menu...");
								           break;
								  default: JOptionPane.showMessageDialog(null, "Wrong option!");
							  }//end switch(carOption)
							}//end while(carOption != 3)
					         carOption = 0;
					         break;
					//......................................................................
					case 2: while(boatOption != 3)
							{
								boatOption = boatMenu();
								switch(boatOption)
								{
								case 1: Boat boat = new Boat();
								        boat.getVIN();
								        boat.getMake();
								        boat.getModel();
								        boat.getBoatType();
								        boat.getEngineHours();
								        boatList.add(boat);
								        break;
								case 2: if(boatList.isEmpty())
											JOptionPane.showMessageDialog(null, "database is empty!");
										else
										{
											input = JOptionPane.showInputDialog("Enter the boat VIN: ");
											while(!dummy.checkVIN(input))
											 {
												 input = JOptionPane.showInputDialog("Enter the VIN for this car: "); 
											 }//end  while(!dummy.checkVIN(input))
											searchVIN = input;
											boatFoundAt = searchBoat(searchVIN);
											if(boatFoundAt == -1)
												JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
											else
											{
												boatList.get(boatFoundAt).dispVehicle();
												boatList.get(boatFoundAt).dispBoat();
											}//end else if(boatFoundAt == -1)
										}//end if(boatList.isEmpty())
								}//end switch(boatOption)
							}//end while(boatOption != 3)
					         boatOption = 0;
					         break;
					case 3: 	JOptionPane.showMessageDialog(null, "Thank you for using this app!");
					            break;
					default: 	JOptionPane.showMessageDialog(null, "Wrong option...");
				}//end switch(mainOption)
			}//end while(mainOption != 3)
		}//end else if(start == JOptionPane.NO_OPTION)
		JOptionPane.showMessageDialog(null, "Goodbye!");
	}//end main
	//----------------------------------------
	public static int mainMenu()
	{
		int mainOption = 0;
		String mainPrompt = "-1-Process a Car\n"  +
		                    "-2-Process a Boat\n" +
				            "-3-Quit Program\n"   +
		                    "\t\tEnter option 1-3: ";
		input = JOptionPane.showInputDialog(mainPrompt);
		while(!checkMenuOption(input))
		{
			input = JOptionPane.showInputDialog("Invalid option! re-enter\n" + mainPrompt);
		}//end while(!checkMenuOption(input))
		mainOption = Integer.parseInt(input);
		return mainOption;
	}//end mainMenu
	//-----------------------------------------
	public static int carMenu()
	{
		int carOption = 0;
		String carPrompt = "-1-Add a Car\n"            +
		                   "-2-Display a Car\n"        +
		                   "-3-Go back to main menu\n" +
		                   "\t\tEnter option 1-3: ";
		input = JOptionPane.showInputDialog(carPrompt);
		while(!checkMenuOption(input))
		{
			input = JOptionPane.showInputDialog("Invalid option! re-enter\n" + carPrompt);
		}//end while(!checkMenuOption(input))
		carOption = Integer.parseInt(input);
		return carOption;
	}//end carMenu
	//-------------------------------------------
	public static int boatMenu()
	{
		int boatOption = 0;
		String boatPrompt = "-1-Add a Boat\n"            +
		                   "-2-Display a Boat\n"        +
		                   "-3-Go back to main menu\n" +
		                   "\t\tEnter option 1-3: ";
		input = JOptionPane.showInputDialog(boatPrompt);
		while(!checkMenuOption(input))
		{
			input = JOptionPane.showInputDialog("Invalid option! re-enter\n" + boatPrompt);
		}//end while(!checkMenuOption(input))
		boatOption = Integer.parseInt(input);
		return boatOption;
	}//end boatMenu
	//-------------------------------------------
	public static int searchCar(String searchVIN)
	{
		int i = 0;
		while(i < carList.size())
		{
			if(searchVIN.equalsIgnoreCase(carList.get(i).vin))
				return i;
			else
				i++;
		}//end while i
		return -1;
	}//end searchCar
	//---------------------------------------------
	public static int searchBoat(String searchVIN)
	{
		int i = 0;
		while(i < boatList.size())
		{
			if(searchVIN.equalsIgnoreCase(boatList.get(i).vin))
				return i;
			else
				i++;
		}//end while i
		return -1;
	}//end searchBoat
	//---------------------------------------------
	//validations:
	//---------------------------------------------
	public static boolean checkMenuOption(String input)
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)))
				return false;
		return true;
	}//end checkMenuOption
	//----------------------------------------------
	//code all necessary methods to write/read cars/boats
	public static void writeCars()
	{
		
	}
	public static void writeBoats()
	{
		
	}
	public static void readCars()
	{
		
	}
	public static void readBoats()
	{
		
	}
}//end class HW4_SOL
//=============================================
class Vehicle
{
	//declarations:
		//object vehicle
			String vin;
			String make;
			String model;
		//working variables:
			String input = " ";
	//constructors:
	Vehicle()
	{
		vin   = " ";
		make  = " ";
		model = " ";
	}//end const w/o arguments
	Vehicle(String vin, String make, String model)
	{
		this.vin   = vin;
		this.make  = make;
		this.model = model;
	}//end const w/ arguments
	//methods:
	//-----------------------------------
	void getVIN()
	{
		input = JOptionPane.showInputDialog("Enter this vehicle VIN: ");
		while(!checkVIN(input))
		{
			input = JOptionPane.showInputDialog("Invalid VIN! re-Enter this vehicle VIN: ");
		}//end while(!checkVIN(input))
		vin = input;
	}//end getVIN
	//-----------------------------------
	void getMake()
	{
		input = JOptionPane.showInputDialog("Enter this vehicle Make: ");
		while(!checkMake(input))
		{
			input = JOptionPane.showInputDialog("Invalid make! re-Enter this vehicle Make: ");
		}//end while(!checkMake(input))
		make = input;
	}//end getMake
	//------------------------------------
	void getModel()
	{
		input = JOptionPane.showInputDialog("Enter this vehicle Model: ");
		while(!checkModel(input))
		{
			input = JOptionPane.showInputDialog("Invalid model! re-Enter this vehicle Model: ");
		}//end while(!checkModel(input))
		model = input;
	}//end getModel
	//-------------------------------------
	void dispVehicle()
	{
		JOptionPane.showMessageDialog(null, "Vehicle VIN  : " + vin  + "\n" +
	                                        "        Make : " + make + "\n" +
				                            "        Model: " + model);
	}//end dispVehicle
	//--------------------------------------
	//validation methods:
	//--------------------------------------
	boolean checkVIN(String input)
	{
		if(input.length() != 17)
			return false;
		else
			for(int i = 0; i < input.length(); i++)
				if(!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)))
					return false;
		return true;
	}//end checkVIN
	//--------------------------------------
	boolean checkMake(String input)
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isLetter(input.charAt(i)))
				return false;
		return true;
	}//end checkMake
	//---------------------------------------
	boolean checkModel(String input)
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)))
				return false;
		return true;
	}//end checkModel
	//-----------------------------------------
}//end class Vehicle
//==========================================
class Car extends Vehicle
{
	//declarations:
		//object: Car subset of vehicle
			double engineSize;
		//working variables:
			String input = " ";
	//constructors:
	Car()
	{
		super();
		engineSize = 0.0;
	}//end const w/o arguments
	Car(String vin, String make, String model, double engineSize)
	{
		super(vin, make, model);
		this.engineSize = engineSize;
	}//end const. w/ arguments
	//methods:
	//--------------------------------------
	void getEngineSize()
	{
		input = JOptionPane.showInputDialog("Enter this Engine Size: ");
		while(!checkEngineSize(input))
		{
			input = JOptionPane.showInputDialog("Invalid size! re-Enter this Engine Size: ");
		}//end while(!checkEngineSize(input))
		engineSize = Double.parseDouble(input);
	}//end getEngineSize
	//--------------------------------------
	void dispCar()
	{
		JOptionPane.showMessageDialog(null, "Car Engine Size: " + engineSize);
	}//end dispCar
	//--------------------------------------
	//validation method:
	boolean checkEngineSize(String input) //allowed: ##.# or #.# 
	{
		String pattern = "^[0-9]{2}+\\.[0-9]{1}$"; 
		return input.matches(pattern);
	}//end checkEngineSize
}//end class Car
//==========================================
class Boat extends Vehicle
{
	//declarations:
		//object: boat
			String boatType;
			int engineHours;
		//working variables:
			String input = " ";
	//constructors:
	Boat()
	{
		boatType    = " ";
		engineHours = 0;
	}//end const. w/o arguments
	Boat(String vin, String make, String model, String boatType, int engineHours)
	{
		super(vin, make, model);
		this.boatType    = boatType;
		this.engineHours = engineHours;
	}//end comnst. w/ arguments
	//-----------------------------------
	void getBoatType()
	{
		input = JOptionPane.showInputDialog("Enter this Boat Type: ");
		while(!checkBoatType(input))
		{
			input = JOptionPane.showInputDialog("Invalid type! re-Enter this Boat Type: ");
		}//end while(!checkBoatType(input))
		boatType = input;
	}//end getBoatType
	//------------------------------------
	void getEngineHours()
	{
		input = JOptionPane.showInputDialog("Enter this Boat Engine Hours: ");
		while(!checkEngineHours(input))
		{
			input = JOptionPane.showInputDialog("Invalid hours! re-Enter this Boat Engine Hours: ");
		}//end while(!checkEngineHours(input))
		engineHours = Integer.parseInt(input);
	}//end getEngineHours
	//-------------------------------------
	void dispBoat()
	{
		JOptionPane.showMessageDialog(null, "Boat Type        : " + boatType + "\n" +
	                                        "     Engine Hours: " + engineHours);
	}//end dispBoat
	//validations:
	boolean checkBoatType(String input)
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isLetter(input.charAt(i)))
				return false;
		return true;
	}//end checkBOatType
	//----------------------------------------
	boolean checkEngineHours(String input)
	{
		for(int i = 0; i < input.length(); i++)
			if(!Character.isDigit(input.charAt(i)))
				return false;
		return true;
	}//end checkEngineHours
	//-----------------------------------------
}//end class Boat
