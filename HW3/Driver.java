package javaWork;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		String word = "";
		char[] chars;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Give me a word with at least eight letters");
		word = sc.nextLine();	
		sc.close();
		chars = word.toCharArray();
		
			
		MyString myS = new MyString(chars);
		System.out.println("Character at pos 3: " + myS.charAt(3));
		System.out.println("Length: " + myS.length());
		System.out.println("Substring -- 3 characters from pos 5: " + myS.substring(5,8));
		System.out.println("To lowercase: " + myS.toLowerCase());
		System.out.println("To uppercase: " + myS.toUpperCase());
		System.out.println("Get mystring: " + myS.getMyString());
		System.out.println("toString:  " + myS);
		System.out.println("value of 4241: " + MyString.valueOf(4241));
		
		String line = "encapsulation";
		MyString myS_2 = new MyString(line.toCharArray());
		System.out.println("compare " + word + " to the word encapsulation: " + myS.compareTo(myS_2));
		
	}
	
	
	
	
}
