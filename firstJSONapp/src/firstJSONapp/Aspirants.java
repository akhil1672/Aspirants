package firstJSONapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Aspirants extends shuffle
{
    public static void main(String[] args) throws FileNotFoundException,
            IOException, ParseException
    {
    	
    	Scanner s= new Scanner(System.in);
    	System.out.println("Enter the teamSize:");
    	int teamSize = s.nextInt();
    	if(teamSize==0)
    	{
    		System.out.println("Team size cannot be zero");
    		System.exit(0);
    	}
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\Akhil\\Desktop\\Aspirants.json"));
    	int totalStudents = jsonArray.size();
    	if(teamSize>totalStudents)
    	{
    		System.out.println("Team size cannot be more than total no of students");
    		System.exit(0);
    	}
    	Collections.shuffle(jsonArray);
   		int noofteams=totalStudents/teamSize;
    	int remainder=totalStudents%teamSize;
    	shuffle sh=new shuffle();
    	
    	if(remainder==0)
    	{
    		System.out.println("Equal teams");
    		System.out.println("Creating "+noofteams+" teams of size "+teamSize);
    		sh.shuffleTeams(noofteams, teamSize, jsonArray);
    	/*	for(int i=1;i<=noofteams;i++)
    		{
    			System.out.println("Team"+i);
    			int j=0;
    			for(Object o:jsonArray)
    			{
    				if(j<teamSize)
    				{
    					JSONObject person=(JSONObject)o;
    					String strName = (String) person.get("name");
    					System.out.println("Name:" + strName);
    					j++;
    				}
    				else
    				{
    					j=0;i++;
    					System.out.println("Team"+i);
    					JSONObject person=(JSONObject)o;
    					String strName = (String) person.get("name");
    					System.out.println("Name:" + strName);
    					j++;
    				}
    			}
    			*/
    		}
    	
    	else
    	{
    		System.out.println("Unequal teams");
    		System.out.println("Would you like to continue(Y/N):");
    		String flag=s.next();
    		if(flag.equals("Y")||flag.equals("y")||flag.equals("Yes")||flag.equals("yes"))
    			sh.shuffleTeams(noofteams, teamSize, jsonArray);
    		//if(flag=="Y" ||flag=="y"||flag=="yes"||flag=="Yes")
    		{
    //		System.out.println("Creating "+noofteams+" teams of equal size "+teamSize+" and teams of unequal teams "+remainder);
 /*   			for(int i=1;i<=noofteams;i++)
    			{
    				System.out.println("Team"+i);
    				int j=0;
    				for(Object o:jsonArray)
    				{
    					if(j<teamSize)
    					{
    						JSONObject person=(JSONObject)o;
    						String strName = (String) person.get("name");
    						System.out.println("Name:" + strName);
    						j++;
    					}
    					else
    					{
    						j=0;i++;
    						System.out.println("Team"+i);
    						JSONObject person=(JSONObject)o;
    						String strName = (String) person.get("name");
    						System.out.println("Name:" + strName);
    						j++;
    					}
    				}
    			}*/
    		}
    	}
    }
}

class shuffle
{
	public void shuffleTeams(int noofteams,int teamSize,JSONArray jsonArray)
	{
		
		for(int i=1;i<=noofteams;i++)
		{
			System.out.println("Team"+i);
			int j=0;
			for(Object o:jsonArray)
			{
				if(j<teamSize)
				{
					JSONObject person=(JSONObject)o;
					String strName = (String) person.get("name");
					System.out.println("Name:" + strName);
					j++;
				}
				else
				{
					j=0;i++;
					System.out.println("Team"+i);
					JSONObject person=(JSONObject)o;
					String strName = (String) person.get("name");
					System.out.println("Name:" + strName);
					j++;
				}
			}
		}
	}
}