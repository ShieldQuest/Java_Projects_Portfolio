/*
 * Author: COP2551
 * Date: 10-6-25
 * Description: see Canvas for full specs and the XC part.
 */
//Imports:
import java.util.Scanner;

public class HW2_XC_SOL 
{
	//'global' vars:
	static Scanner get = new Scanner(System.in);
	static String input = " ";
	public static void main(String[] args) 
	{
		//declarations:
			//object: Patient
			String patientName        = " ";
			int patientAge            = 0;
			int patientGlucose        = 0;
			String patientStatus      = " ";
			//working variables:
			int answer     = 1;
			int minGlucose = 0;
			int maxGlucose = 0;
			String minName = " ";
			String maxName = " ";
			//if you need to display everything about a patient, you must memorize
			//the age, glucose, and status: try it!
			
		//processes:
		while(answer == 1)
		{
			//input:
			patientName    = getPatientName();
			patientAge     = getPatientAge();
			patientGlucose = getPatientGlucose();
			//........................................
			if(minGlucose == 0)
			{
				minGlucose = patientGlucose;
				minName    = patientName;
			}//end if(minGlucose == 0)
			else
					if(minGlucose > patientGlucose)
					{
						minGlucose = patientGlucose;
						minName    = patientName;
					}//end if(minGlucose != 0)
			//........................................
			if(maxGlucose == 0)
			{
				maxGlucose = patientGlucose;
				maxName    = patientName;
			}//if(maxGlucose == 0)
			else
				if(maxGlucose < patientGlucose)
				{
					maxGlucose = patientGlucose;
					maxName    = patientName;
				}//end if(maxGlucose < patientGlucose)
			//.........................................
			//evaluate glucose and determine status:
			patientStatus  = determinePatientStatus(patientGlucose);
			//report:
			report(patientName, patientAge, patientGlucose, patientStatus);
			//another patient?
			System.out.println("Another patient? 1 for yes or 0 for no: ");
			input = get.nextLine();
			answer = Integer.parseInt(input);
			while(answer != 1 && answer != 0)
			{
				System.out.println("Wrong answer! 1 for yes or 0 for no: ");
				input = get.nextLine();
				answer = Integer.parseInt(input);
			}//END while(answer != 1 && answer != 0) 
		}//end while(answer != 1 && answer != 0) 
		dispStats(minGlucose, minName, maxGlucose, maxName);
		//bye!
		System.out.println("Goodbye!");
	}//end main
	//=================================
	public static String getPatientName()
	{
		String patientName = " ";
		System.out.println("Enter this patient full name: ");
		input = get.nextLine();
		patientName = input;
		return patientName;
		//return (input)
	}//end getPatientName
	//==================================
	public static int getPatientAge()
	{
		int patientAge = 0;
		System.out.println("Enter this patient age: ");
		input = get.nextLine();
		patientAge = Integer.parseInt(input);
		return patientAge;
		//return (Integer.parseInt(get.nextLine()));
	}//end getPatientAge()
	//===================================
	public static int getPatientGlucose()
	{
		int patientGlucose = 0;
		System.out.println("Enter this patient glucose reading: ");
		input = get.nextLine();
		patientGlucose = Integer.parseInt(input);
		return patientGlucose;
		//return (Integer.parseInt(get.nextLine()));
	}//end getPatientGlucose
	//=====================================
	public static String determinePatientStatus(int patientGlucose)
	{
		String patientStatus = " ";
		if(patientGlucose >= 80 && patientGlucose <= 130)
			patientStatus =  "Normal";
		else
			if(patientGlucose < 80)
				patientStatus = "Too Low";
			else
				if(patientGlucose > 130)
					patientStatus =  "Too High";
		return patientStatus;
		//code the 3 statuses as 0 for normal, 1 for low, and 3 for high
		//this  encoding will allow you to elaborate further on the status
		//inside your report method using simple selections.
	}//end determinePatientStatus
	//=========================================
	public static void report(String patientName, int patientAge, 
			                  int patientGlucose, String patientStatus)
	{
		System.out.println("Patient Name           : " + patientName    + "\n"  +
	                       "        Age            : " + patientAge     + "\n"  +
				           "        Glucose Reading: " + patientGlucose + "\n"  +
	                       "        Status         : " + patientStatus);
	}//end report
	//=========================================
	public static void dispStats(int minGlucose, String minName, int maxGlucose, String maxName)
	{
		System.out.println(minName + " has the lowest glucose reading of " + minGlucose);
		System.out.println(maxName + " has the highest glucose reading of " + maxGlucose);
	}//end dispStats
}//end class HW2_SOL
