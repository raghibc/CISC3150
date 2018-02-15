package javaWork;

import java.util.Scanner;

public class Pyramid {
	public static void main(String[] args)
	{
		int height;
		int numSpaces;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How tall of a pyramid do you want to display on the screen?");
		height = sc.nextInt();
		numSpaces = height;
	
		for(int b = 1; b <= height; b++)
		{			
			while(numSpaces > 0)
			{
				System.out.print("   ");
				numSpaces--;
			}
			
			
			for(int i = 1; i <= b; i++)
			{
				System.out.printf("%3d", i);
			}
		 
			for(int j = (b-1); j > 0; j--)
			{
				System.out.printf("%3d", j);
			}
			
			System.out.println();
			numSpaces = height-b;
		}
		
		sc.close();
	}
	
	
}
