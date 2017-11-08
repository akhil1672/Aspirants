package firstJSONapp;
import java.util.*;
import java.util.Collections;
public class randomnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r= new Random();
		Integer st[]= {1,2,3,4,5,6,7,8,9};
		Collections.shuffle(Arrays.asList(st));
		
		for(int i=0;i<9;i++)
		{
			System.out.println(r.nextInt(st[i]));
		}
		System.out.println(Arrays.toString(st));

	}

}
