/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week13;

/**
 *
 * @author User
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class Problem04 {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = ss.accept();
            System.out.println("Client connected!");

            DataInputStream dis =
                    new DataInputStream(socket.getInputStream());

            DataOutputStream dos =
                    new DataOutputStream(socket.getOutputStream());

            while (true) {
                String input = dis.readUTF();

                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                StringTokenizer st = new StringTokenizer(input);

                int num1 = Integer.parseInt(st.nextToken());
                String operator = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());

                int result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        if (num2 == 0) {
                            dos.writeUTF("Cannot divide by zero");
                            continue;
                        }
                        result = num1 / num2;
                        break;

                    default:
                        dos.writeUTF("Invalid operator");
                        continue;
                }

                dos.writeUTF(String.valueOf(result));
            }

            socket.close();
            ss.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
