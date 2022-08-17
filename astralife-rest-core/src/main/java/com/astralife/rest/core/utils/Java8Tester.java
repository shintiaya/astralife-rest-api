package com.astralife.rest.core.utils;

import java.util.ArrayList;
import java.util.List;

public class Java8Tester {

	   public static void main(String args[]) {
	      Java8features javaLambda = (String mainMessage, Java8Tester tester) ->{
	    	  
	    	  System.out.println(mainMessage);
	    	//with type declaration
		      MathOperation addition = (int a, int b) -> a + b;
		      
		      //with out type declaration
		      MathOperation subtraction = (a, b) -> a - b;
				
		      //with return statement along with curly braces
		      MathOperation multiplication = (int a, int b) -> { return a * b; };
				
		      //without return statement and without curly braces
		      MathOperation division = (int a, int b) -> a / b;
				
		      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
				
		      //without parenthesis
		      GreetingService greetService1 = message ->
		      System.out.println("Hello " + message);
				
		      //with parenthesis
		      GreetingService greetService2 = (message) ->
		      System.out.println("Hello " + message);
				
		      greetService1.sayMessage("Mahesh");
		      greetService2.sayMessage("Suresh");
	      };
	      Java8features javaMethodReference =(mainMessage, tester)->{
	    	  List<String> names = new ArrayList<>();
	    	  names.add(mainMessage);
		      names.add("Mahesh");
		      names.add("Suresh");
		      names.add("Ramesh");
		      names.add("Naresh");
		      names.add("Kalpesh");
				
		      names.forEach(System.out::println);
	      };
	      javaLambda.runFeature("this is java lambda", new Java8Tester());
	      javaMethodReference.runFeature("this is java method reference", new Java8Tester());
	   }
		
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	   private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }
	   
	   interface Java8features{
		   void runFeature(String message, Java8Tester a);
	   } 
	}