package firstJSONapp;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;

public class Aspirants3 extends createteams
{
	public static void main(String args[]) throws ParseException,IOException,FileNotFoundException
	{
		//Creating an object to create teams
		createteams team=new createteams();
		//Scanner class to take input
		Scanner sc= new Scanner(System.in);
		//Variable for storing team size given my user
		int teamSize=0;
		System.out.println("enter teamsize:");
		//Taking input from user and checking for valid input
		try
		{
			teamSize=sc.nextInt();
		}
		//if input invalid displays error
		catch(Exception e)
		{
			System.out.println("Invalid Input!");
			System.exit(-1);
		}
		//checking for condition input given by user
		if(teamSize==0)
    	{
    		System.out.println("Team size cannot be zero");
    		System.exit(0);
    	}
		//initializing JSON parser to parse input file
		JSONParser parser=new JSONParser();
		//creating a object of JSONArray of students
		JSONArray students= new JSONArray();
		try
		{
			//parsing and converting into students Array
			students=(JSONArray) parser.parse(new FileReader("C:\\Users\\Akhil\\Desktop\\Aspirants.json"));
		}
		catch(Exception e)
		{
			//if file not found prints error
			System.out.println("Input file no found!");
			System.exit(-1);
		}
		//Variable to store size of array
		int noofstudents=students.size();
		//Checking for condition if teamSize>noofStudents
		if(teamSize>noofstudents)
    	{
    		System.out.println("Team size cannot be more than total no of students");
    		System.exit(0);
    	}
		//shuffling the students randomly in the JSONArray
		Collections.shuffle(students);
		//variable to store noofteams
		int noofteams=(students.size())/teamSize;
		//Variable to store number of extra students for unequal teams
		int extra= noofstudents%teamSize; 
		//if equal no of teams
		if(extra==0)
		{
			System.out.println("Equal teams");
			//function call to create teams
			team.create(noofstudents, teamSize, students);
		}
		//if unequal no of teams
		else
		{
			System.out.println("Unequal teams");
			//asks the user whether to continue
			System.out.println("Would you like to continue(Y/N):");
			String flag=sc.next();
			//if Yes create teams
			if(flag.equals("Y")||flag.equals("y")||flag.equals("Yes")||flag.equals("yes"))
    			team.create(noofteams, teamSize, students);
			//if no exits
			else if(flag.equals("N")||flag.equals("n")||flag.equals("No")||flag.equals("no"))
				System.exit(0);
			// prints invalid for invalid input
			else
				System.out.println("Invalid Input");
		}
		sc.close();
		
	}
}


class createteams
{
	public void create(int noofstudents,int teamSize,JSONArray students)
	{
		int j=1;//to check teamMembercount
		int i=1;//to count teams
		System.out.println("Team"+i);
		//for each loop to iterate over the students array using object
		for(Object person:students)
		{
			//typecasting Object person to JSONObject 
			JSONObject student=(JSONObject)person;
			if(j<=teamSize)//checks for teamMembercount
			{
				//Retrieves the name of student from array
				String name=(String)student.get("name");
				System.out.println("Name:"+name);
				j++;//increments teamMembercount
			}
			else//if condition fails creates another team and adds one member
			{
				j=1;//initializes to 1 for new team
				i++;//increments team
				System.out.println("Team"+i);
				String name=(String)student.get("name");
				System.out.println("Name:"+name);
				j++;
			}
		}
	}
}