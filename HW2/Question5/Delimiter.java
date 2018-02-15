package javaWork;

import java.util.Scanner;


public class Delimiter {

	public static void main(String[] args)
	{
		String line = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Give me some values separated by commas not spaces");
		line = sc.nextLine();
		sc.close();
		
		Scanner myScan = new Scanner(line);
		myScan.useDelimiter(",");
		
		while(myScan.hasNextInt())
		{
			System.out.println(myScan.nextInt());
		}
		
		myScan.close();
		
	}
	
}
