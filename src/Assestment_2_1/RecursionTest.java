package Assestment_2_1;

import java.util.Scanner;

public class RecursionTest extends Lab2{
    public static void main(String[] args) {
        int [] a = { 2, 3, 5, 7, 11, 13, 17, 19, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 23, 29, 31, 37, 41, 43 };
        int min = min(a, 10,20);
        System.out.println("The minimum element in the array: " + min);

        System.out.println("- - - - - - - - - - - - - -");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter how may days you plan to work: ");
        int days = myObj.nextInt();  // Read user input
        System.out.println("On the day " + days + " you will earn " + computePay(days) + " cents per day");
        System.out.println("By the day " + days + " you will collect " + computeSavings(days) + " cents in savings");

        System.out.println("- - - - - - - - - - - - - -");

        String s1 = "Recursion is the technique of making a function call itself. This technique provides a way to break complicated problems down into simple problems which are easier to solve.\n" +
                "\n" +
                "Recursion may be a bit difficult to understand. The best way to figure out how it works is to experiment with it.";
        String s2 = "a";
        System.out.println(countSubstrings(s1,s2));
    }
}