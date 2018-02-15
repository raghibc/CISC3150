package javaWork;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args)
	{
		String line = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("GIve me a string");
		line = sc.nextLine();
		
		int midVal = 0;
		int start = 0;
		int end = line.length() - 1; 
		int x;
		midVal = (line.length() / 2);
			
		for(x = start; x <= midVal; x++)
		{
				
				if(line.charAt(start) == line.charAt(end))
				{
					start++;
				}
				
				else
					end--;
				
		}			
			
		
		if(x == midVal + 1)
			System.out.println("It is a palindrome");
		else
			System.out.println("This is not a palindrome");
		
		
		
		sc.close();
		
	}
	
	
	
}
