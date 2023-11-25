package com.example.lib;

import java.util.Scanner;



public class MyClass {

    public static void main(String[] args) {
        ex1();
    }


    static void ex1() {
        System.out.println("Enter the radius: ");
        Circle circle = new Circle(new Scanner(System.in).nextInt());
        System.out.println("The area of the circle is: " + circle.getArea());
    }

}