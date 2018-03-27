//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
	   ArrayList<Class> classes = new ArrayList<Class>();
	   
	   
		out.println("Welcome to the Class Stats program!");
		Scanner keyboard = new Scanner(System.in);
		
		
		
		System.out.println("How many classes?");
		int numClasses = keyboard.nextInt();
		keyboard.nextLine();
		
		for (int k = 0; k < numClasses; k++){
		
		
			out.print("\nWhat is the name of this class? ");
			String className = keyboard.nextLine();
			
			out.print("\nHow many students are in this class? ");
			int stuCount = keyboard.nextInt();
		
			
			//-------------------------------
			Class test = new Class(className,stuCount);
			//-------------------------------
			
			for (int i = 0; i < stuCount; i++){
				out.print("Enter the name of student " + (i+1) + " : ");
				String stuName = keyboard.next();
				
				keyboard.nextLine();
			
				out.print("Enter the grades for " + stuName + "\nUse the format x - grades (2 - 100 100): ");
				String gradeList = keyboard.nextLine();
				
				Student s = new Student(stuName, gradeList);
				test.addStudent(i, s);	
			}
			
			classes.add(test);
			
		}
		
		// Classes all added, now print 
		
		for(int k=0; k< classes.size(); k++) {
			
			Class test = classes.get(k);
			out.println();
			out.println(test.toString());
			out.println("Failure List =  " + test.getFailureList(70));
			out.println("Highest Average = " + test.getStudentWithHighestAverage());
			out.println("Lowest Average = " + test.getStudentWithLowestAverage());
			out.println("Class Average = " + test.getClassAverage());
		
		
		}


















	}		
}