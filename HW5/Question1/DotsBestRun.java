package javaWork;

import java.util.Random;
import java.util.Scanner;

public class DotsBestRun 
{	
	public static void main(String[] args) 
	{
		long before = System.currentTimeMillis();
		
		int radius = 0;
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("Give me the radius");
		radius = sc.nextInt();
		radius += 1;
		
		int xCoord;
		int yCoord;
		
		double circleDots = 0;
		double squareDots = 4E9;
		double distance;
		
		int num = (int) (Integer.MAX_VALUE-4E9);
		
		for(int i = num; i < Integer.MAX_VALUE; i++) 
		{
			xCoord = rand.nextInt(radius);
			yCoord = rand.nextInt(radius);
			
			distance = Math.sqrt((xCoord*xCoord) + (yCoord*yCoord));
			
			if(distance <= radius)
				circleDots++;
		}
			
		double PI = 0;
		PI = (4.0 * (circleDots/squareDots));

		System.out.println("The value of PI determined by this program is: " + PI);
		System.out.println("The actual value of PI is: " + Math.PI);
		
		sc.close();
		System.out.println("Time in milliseconds: " + (System.currentTimeMillis()-before));
		System.out.println("Time in seconds: " + (System.currentTimeMillis()-before)/1000.0);
	}
}