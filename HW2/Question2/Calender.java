package javaWork;

import java.util.Scanner;

public class Calender {

	public static void main(String[] args)
	{
		int year; 
		String day;
		int dayNum = 0;
		Scanner sc = new Scanner(System.in);
		int numDays = 0; 
		
		System.out.println("What year is it");
		year = sc.nextInt();
		
		System.out.println("What day did the first of January fall on");
		day = sc.next();
		
		day = day.toUpperCase();
		
		switch (day)
		{
		case "SUNDAY":
			dayNum = 1;
			break;
		case "MONDAY":
			dayNum = 2;
			break;
		case "TUESDAY":
			dayNum = 3;
			break;
		case "WEDNESDAY":
			dayNum = 4;
			break;
		case "THURSDAY":
			dayNum = 5;
			break;
		case "FRIDAY":
			dayNum = 6;
			break;
		case "SATURDAY":
			dayNum = 7;
			break;
		}
		
		
		for(int i = 1; i <= 12; i++) {
			
			switch (i)
			{
			case 1:
				System.out.printf("\t%s %-10d", "January", year);
				numDays = 31;
				break;
				
			case 2:
				System.out.printf("\t%s %-10d", "February", year);
				
				if((year % 4 == 0)&&(year % 100 != 0)||(year % 400 == 0))
					numDays = 29;
				else
					numDays = 28;
				break;
				
			case 3: 
				System.out.printf("\t%s %-10d", "March", year);
				numDays = 31;
				break;
				
			case 4: 
				System.out.printf("\t%s %-10d", "April", year);
				numDays = 30;
				break;
				
			case 5:
				System.out.printf("\t%s %-10d", "May", year);
				numDays = 31;
				break;
				
			case 6:
				System.out.printf("\t%s %-10d", "June", year);
				numDays = 30;
				break;
				
			case 7:
				System.out.printf("\t%s %-10d", "July", year);
				numDays = 31;
				break;
				
			case 8:
				System.out.printf("\t%s %-10d", "August", year);
				numDays = 31;
				break;
				
			case 9:
				System.out.printf("\t%s %-10d", "September", year);
				numDays = 30;
				break;
				
			case 10:
				System.out.printf("\t%s %-10d", "October", year);
				numDays = 31;
				break;
				
			case 11:
				System.out.printf("\t%s %-10d", "November", year);
				numDays = 30;
				break;
				
			case 12:
				System.out.printf("\t%s %-10d", "December", year);
				numDays = 31;
				break;
			}
			
			System.out.println();
			System.out.printf("%3s %3s %3s %3s %3s %3s %3s", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");
			System.out.println();
			
			
			for(int k = 1; k < dayNum; k++)
			{
				System.out.print("    ");
			}
			
			for(int x = 1; x <= numDays; x++)
			{
				System.out.printf("%3d" + " ", x);
				
				if(((x + dayNum) - 1) %7 == 0)
					System.out.println();
			}
			
			System.out.println("\n");
			dayNum = (dayNum + numDays)%7;
			
		}

		
		sc.close();
	}
	
}
