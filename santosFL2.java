// Santos, Johan D. CS22S1
// CS201A - Data Structures and Algorithms Analysis
// Final Laboratory 2 - Infix to Postfix

import java.util.*;

public class santosFL2 {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        // takes an Infix Expression via input from user.
	        System.out.print("Enter Infix Expression: ");
	        String infix = sc.nextLine();
	        
	        // applies the infix to postfix conversion
	        String postfix = convert(infix);
	        
	        // prints the result of the conversion
	        System.out.println("The Postfix of the given Infix Expression is: " + postfix);
	        sc.close();
	    }
	
	 public static String convert(String infix) {
		 
		 	// creates a new stack which serves as a container for the characters before forming the postfix expression
	        Stack<Character> stack = new Stack<>();
	        String postfix = "";
	        
	        // scans all the characters in the infix expression
	        for (int i = 0; i < infix.length(); i++) {
	            char c = infix.charAt(i);
	            
	            // identifies if the current char is a letter or a digit
	            if (Character.isLetterOrDigit(c)) {
	                postfix += c;
	                
	            // proceeds here if the character is neither a digit or a character
	            } else if (c == '(') {
	                stack.push(c); // pushes the current character to the stack
	            } else if (c == ')') {
	                while (!stack.isEmpty() && stack.peek() != '(') {
	                    postfix += stack.pop(); // takes the top of the stack and gets added to the postfix expression
	                }
	                stack.pop();
	            } else {
	                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
	                    postfix += stack.pop(); // if stack is full(all chars are scanned)
	                    						//, and the precedence of the character is higher than the top of the stack, adds it to the postfix expression
	                }
	                stack.push(c); // pushes character after meeting the conditions above
	            }
	        }
	        
	        while (!stack.isEmpty()) {
	            postfix += stack.pop(); // takes the top of the stack and adds it to the postfix expression
	        }
	        
	        return postfix; // returns the value of the postfix to be printed
	    }
	    
	 // dictates the precedence of operators and letters, 2 being the highest priority and 0 being the lowest
	    public static int priority(char c) {
	        if (c == '+' || c == '-') {
	            return 1;
	        } else if (c == '*' || c == '/') {
	            return 2;
	        } else {
	            return 0;
	        }
	    }
	    
	  
	    
	}