/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Problem01 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a / b);
        }
        catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
