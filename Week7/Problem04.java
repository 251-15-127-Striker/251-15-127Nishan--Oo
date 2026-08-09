/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week7;

import java.util.Scanner;


class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;
   
  Student(String firstName, String lastName, int identification,int[] testScores){
    super(firstName, lastName, identification);
    this.testScores=testScores;
  }
   public char calculate() { 
    int sum = 0; 
    for (int score : testScores) 
    { 
        sum += score; 
        } 
        int average = sum / testScores.length;
         if (average >= 90)
          { 
            return 'O';
             } 
             else if (average >= 80)
              { 
                return 'E'; 
                } 
                else if (average >= 70)
                 { 
                    return 'A';
                     } 
                     else if (average >= 55)
                      { 
                        return 'P'; 
                        } 
                         else if (average >= 40) 
                          { 
                               return 'D'; 
                                } 
                                  else
                                        {
                                          return 'T';
                                          } 
                                      }
    
}
public class Problem04 {
   public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}  
}
