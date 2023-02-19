package Assestment_2_1;

import java.util.Scanner;

class Lab2 {
	public static void main(String[] arg) {
		int [] a = { 2, 3, 5, 7, 11, 13, 17, 19, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 23, 29, 31, 37, 41, 43 };
		int min = min(a, 10,24);
		System.out.println("The minimum element in the array: " + min);

		System.out.println("- - - - - - - - - - - - - -");

		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.print("Enter how may days you plan to work: ");
		int days = myObj.nextInt();  // Read user input
		System.out.println("On the day " + days + " you will earn " + computePay(days) + " cents per day");
		System.out.println("By the day " + days + " you will collect " + computeSavings(days) + " cents in savings");
	}
	// Problem 4
	public static int min(int [] a, int begin, int end) {
		if(begin == end){
			return a[begin];
		}else{
			int mid = (begin + end) / 2;
			int leftMin = min(a, begin, mid);
			int rightMin = min(a, mid + 1, end);
			if (leftMin < rightMin) {
				return leftMin;
			} else {
				return rightMin;
			}
		}
	}

	// Problem 5
	public static long computePay(int day) {
			long sum = 1;
			for (int i = 1; i < day; i++) {
				sum = computePay(i) * 2;
			}
			return sum;
	}
	public static long computeSavings(int day) {
		long sum = 1;
		for (int i = 1; i < day; i++) {
			sum += computePay(i) * 2;
		}
		return sum;
	}

	// Problem 6
	public static int countSubstrings(String s1, String s2) {
		return 0;
	}
}