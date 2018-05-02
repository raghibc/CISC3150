package javaWork;

import java.util.Stack;

public class Calculator {

	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
			
		try {
			String[] strArray = new String[args.length];
			 
			for(int i = 0; i < args.length; i++) 
				strArray[i] = args[i];
			
			
			for(int i = 0; i < strArray.length; i++) 
				System.out.print(strArray[i]);
	
		 	postFix(strArray, myStack);
		 	System.out.println("\n"+myStack);
		 	
		    System.out.println("Answer: " + doArithmetic(myStack));
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	} 
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////PEMDAS METHOD///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
		
	public static int pemdas(String str) {
		switch(str) 
		{
			case "+": 
			case "-": return 0;

			case "'*'": 
			case "/": return 1;
					  
			case "^": return 2;
					  
			case "(":
			case ")": return 3;

			default:  return -1;
		}
	}

	

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////POSTFIX METHOD//////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
		
	
	
	public static void postFix(String[] str, Stack<String> myStack) throws QuitMashingOnYourKeyboardException, AlgebraFailException, UserIsADumbassException {
		Stack<String> operatorStack = new Stack<String>();
		Stack<String> postfixStack = new Stack<String>();
		int numOperands = 0;
		int numOperators = 0;
		
		for(int i = 0; i < str.length; i++) {
			
				if((str[i].equals("^")) || (str[i].equals("'*'")) || (str[i].equals("/")) || (str[i].equals("+")) || (str[i].equals("-"))){
					++numOperators;
					
					if(operatorStack.isEmpty()) {
						operatorStack.push(str[i]);
					}
					else if(operatorStack.peek().equals("(")) {
						operatorStack.push(str[i]);
					}
					else { 
						if(pemdas(operatorStack.peek()) < pemdas(str[i])) {
							operatorStack.push(str[i]);
						}
						else if(pemdas(operatorStack.peek()) == pemdas(str[i])) {
							postfixStack.push(operatorStack.pop());
							operatorStack.push(str[i]);
						}
						else {
							while((pemdas(operatorStack.peek()) > pemdas(str[i])) && (!operatorStack.peek().equals("("))){
								postfixStack.push(operatorStack.pop());	
							}
							
							while(pemdas(operatorStack.peek()) == pemdas(str[i])){
								postfixStack.push(operatorStack.pop());
							}
							
							operatorStack.push(str[i]);
						}
					}

				}
				
				else if(str[i].equals("(")) { 
					operatorStack.push(str[i]);
				}
				
				else if(str[i].equals(")")) {
					boolean parenthesis = false;
					
					while(!parenthesis) {
							
						if(operatorStack.peek().equals("(")) {
							operatorStack.pop();
							parenthesis = true;
						}
						
						else 
							postfixStack.push(operatorStack.pop());
					}				
				}
				
				else { 
					char[] checkIfDigit = str[i].toCharArray();
					
					for(int j = 0; j < checkIfDigit.length; j++) {
						
						if(Character.isDigit(checkIfDigit[j])) {
							++numOperands;
						}
						
						else { 
							throw new QuitMashingOnYourKeyboardException("Unsupported operation: " + str[i]);
						}
					}
					
					postfixStack.push(str[i]);
				}
				
				if(i < str.length-1) {
					
					if(str[i].equals("(") && ( str[i+1].equals("^") || str[i+1].equals("'*'") || str[i+1].equals("/") 
							|| str[i+1].equals("+") || str[i+1].equals("-")))
					{
						throw new AlgebraFailException("Entered " + str[i+1] + " instead of number");
					}
					
					char[] algebraCheck = str[i+1].toCharArray();
					
					for(int j = 0; j < algebraCheck.length; j++) {
					
						if((str[i].equals("^") || str[i].equals("'*'") || str[i].equals("/") 
							|| str[i].equals("+") || str[i].equals("-")) && (!str[i+1].equals("(")) && (!Character.isDigit(algebraCheck[j]))) {
							
							throw new AlgebraFailException("Entered " + str[i+1] + " instead of number");
						}		
					}
				}

		}
		
		if((numOperands != numOperators+1) || (numOperands < 2)) {
			throw new UserIsADumbassException("Forgot to enter a number");
		}
			
		while(!operatorStack.isEmpty()) {
			postfixStack.push(operatorStack.pop());
		}
		
		while(!postfixStack.isEmpty()) {
			myStack.push(postfixStack.pop());
		}
	}
	
	

///////////////////////////////////////////////////////////////////////////////////////////////////
//////////////OPERATION METHODS////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	public static double add(double operandOne, double operandTwo) {
		return operandOne + operandTwo;
	}
	
	public static double subtract(double operandTwo, double operandOne) {
		return operandTwo - operandOne;
	}
	
	public static double multiply(double operandOne, double operandTwo) {
		return operandOne * operandTwo;
	}
	
	public static double divide(double operandTwo, double operandOne) throws ArithmeticException { 
		if(operandOne == 0.0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		
		return operandTwo / operandOne;
	}
	
	public static double power(double operandTwo, double operandOne) {
		int i = (int)operandOne;
	
		while(i > 1) {
			operandTwo = operandTwo*operandTwo;
			i--;
		}
	
		return operandTwo;
	}
		
	
	

///////////////////////////////////////////////////////////////////////////////////////////////////
////////////ARITHMETIC METHOD//////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public static double doArithmetic(Stack<String> stk) {
		Stack<Double> solutionStack = new Stack<Double>();
		double operandOne;
		double operandTwo;
		double answer;
		
		while(!stk.isEmpty()) {
			if(pemdas(stk.peek()) == -1) {
				solutionStack.push(Double.parseDouble(stk.pop()));
			}
			
			else if(pemdas(stk.peek()) == 0) {
				
				if(stk.peek().equals("+")) {
					stk.pop();
					operandOne = solutionStack.pop();
					operandTwo = solutionStack.pop();
					answer = add(operandOne, operandTwo);
					solutionStack.push(answer);
				}
				
				else {
					stk.pop();
					operandOne = solutionStack.pop();
					operandTwo = solutionStack.pop();
					answer = subtract(operandTwo, operandOne);
					solutionStack.push(answer);
				}
				
			}
			
			else if(pemdas(stk.peek()) == 1) {
				
				if(stk.peek().equals("'*'")) {
					stk.pop();
					operandOne = solutionStack.pop();
					operandTwo = solutionStack.pop();
					answer = multiply(operandOne, operandTwo);
					solutionStack.push(answer);
				}
				
				else {
					stk.pop();
					operandOne = solutionStack.pop();
					operandTwo = solutionStack.pop();
					answer = divide(operandTwo, operandOne);
					solutionStack.push(answer);
				}
				
			}
			
			else if(pemdas(stk.peek()) == 2) {
				stk.pop();
				operandOne = solutionStack.pop();
				operandTwo = solutionStack.pop();
				answer = power(operandTwo, operandOne);
				solutionStack.push(answer);
			}
		}
		
		return  solutionStack.pop();

	}	
}