package javaWork;

public class MyString
{
	private char[] mystring_chars;
	private String str = "";
	
	
	public MyString(char[] chars) 
	{
		mystring_chars = new char[chars.length];
		
		for(int i = 0; i < chars.length; i++)
		{
			mystring_chars[i] = chars[i];
			str += chars[i];
		}	
	}	
	
	
	public char charAt(int index) 
	{		
		return mystring_chars[index];	
	}
	
	
	public int length() 
	{
		return mystring_chars.length;
	}
	
	
	public MyString substring(int begin, int end) 
	{
		int length = end - begin;
		char[] substring = new char[length];
		
		
		for(int i = 0; i < substring.length; i++)
		{
				substring[i] = mystring_chars[begin];
				begin++;
		}	
			
		MyString sub = new MyString(substring);
		
		return sub;
	}
	
	
	public MyString toLowerCase() 
	{
		char[] lowercase_chars = new char[mystring_chars.length];
		
		for(int i = 0; i < lowercase_chars.length; i++) {
			lowercase_chars[i] = mystring_chars[i];
			
			if(lowercase_chars[i] >= 'A' && lowercase_chars[i] <= 'Z')
				lowercase_chars[i] += 32;
			
		}
		
		MyString lower = new MyString(lowercase_chars);
		
		return lower;
	}
	
	
	public MyString toUpperCase() 
	{
		char[] uppercase_chars = new char[mystring_chars.length];
		
		for(int i = 0; i < uppercase_chars.length; i++) {
			uppercase_chars[i] = mystring_chars[i];
			
			if(uppercase_chars[i] >= 'a' && uppercase_chars[i] <= 'z')
				uppercase_chars[i] -= 32;
			
		}
		
		MyString upper = new MyString(uppercase_chars);
		
		return upper;
	}
	
		
	public int compareTo(MyString s) 
	{
		
		for(int i = 0; i < mystring_chars.length; i++)
		{
				if(mystring_chars[i] != s.mystring_chars[i])
				{
					return (mystring_chars[i] - s.mystring_chars[i]);
				}
		}	
		
		return 0;
	}	
	
	
	public MyString getMyString() 
	{
		MyString myS = new MyString(mystring_chars);
		return myS;
	}
	
	
	public String toString()
	{
		return str;
	}
		
	
	public static MyString valueOf(int i)
	{
		int num = i;
		int numDigits = 0;
		
		while(num > 0) 
		{
			numDigits++;
			num /= 10;
		}
		
		char[] valChars = new char[numDigits];
	
		for(int n = numDigits - 1; n >= 0; n--) 
		{
			valChars[n] = Character.forDigit(i % 10, 10);
			i /= 10;
		}
		
		MyString valOfNum = new MyString(valChars);
		return valOfNum;
	}	
}