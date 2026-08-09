/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week12;

import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 *
 * @author User
 */
class Singleton {

    public String str;

    private Singleton() {
    }

    private static Singleton single_instance = null;

    public static Singleton getSingleInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }

        return single_instance;
    }
}
public class Problem01 {
  public static void main(String args[])throws Exception{
	
	Scanner sc=new Scanner(System.in);
	Singleton s1 = Singleton.getSingleInstance(); //retrive the single instance
    Singleton s2=Singleton.getSingleInstance();
    assert(s1==s2);
    
	//verify that the constructor is private
	Class c=s1.getClass();
	Constructor[] allConstructors = c.getDeclaredConstructors();
	assert allConstructors.length==1;
	for (Constructor ctor : allConstructors) 
	{
		if(ctor.getModifiers()!=2 || !ctor.toString().equals("private Singleton()")) //The constructor must be private
		{
			System.out.println("Wrong class!");
		}
	}
    String str=sc.nextLine();
	s1.str=str;
    s2.str=str;
    System.out.println("Hello I am a singleton! Let me say "+str+" to you");
	
 }
  
}

