// Jagged Arrays

package javaWork;

import java.util.Scanner;

public class LetterCombo {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		char[][] ch;
		int row = 0;
		int length = 0;
		
		System.out.println("How many rows will your array have?");
		row = sc.nextInt();
		ch = new char[row][];
		
		for(int i = 0; i < ch.length; i++)
		{
			System.out.println("Give me the length of ch[" + i + "]" );
			length = sc.nextInt();
			ch[i] = new char[length];
			
			System.out.println("Give me the letters in ch[" + i + "]");
			for(int k = 0; k < ch[i].length; k++)
			{
				String line = "";
				line = sc.next();
				ch[i][k] = line.charAt(0);
			}
		}
		
		System.out.println("print array:");
		
		for(int i = 0; i < ch.length; i++)
		{
			for(int k = 0; k < ch[i].length; k++)
				System.out.print(ch[i][k] + " ");
			
			System.out.println();
		}
		
		sc.close();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		int totalCombs = 1;
		
		for(int i = 0; i < ch.length; i++)
			totalCombs *= ch[i].length;
		
		char[][] combs = new char[totalCombs][ch.length];
		int combCounter = 0;
		int trackElement = 1;
		
		for(int i = 0; i < ch.length; i++)
		{
			combCounter = 0;
			
			while(combCounter < totalCombs)
			{
				for(int k = 0; k < ch[i].length; k++)
				{
					for(int m = 0; m < trackElement; m++)
					{
						if(combCounter < totalCombs)
						{
							combs[combCounter][i] = ch[i][k];
							combCounter++;
						}
					}
				}
			}
			
			trackElement *= ch[i].length;
			
		}
		
		
		System.out.println("Every possible combination of array:");
		
		for(int m = 0; m < combs.length; m++)
		{
			for(int n = 0; n < combs[m].length; n++)
				System.out.print(combs[m][n] + " ");
			
			System.out.println();
		}
	}
}
