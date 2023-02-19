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

		System.out.println("- - - - - - - - - - - - - -");

		String s1 = "Java is a programming language originally developed by James Gosling at Sun Microsystems and released in 1995 as a core component of Sun Microsystems Java platform. The language derives much of its syntax from C and C++ but has simpler object model and fewer low-level facilities. Java applications are typically compiled to bytecode (class file) that can run on any Java Virtual Machine (JVM) regardless of computer architecture. Java is a general-purpose, concurrent, class-based, object-oriented language that is specifically designed to have as few implementation dependencies as possible. Java is currently one of the most popular programming languages in use, particularly for client-server web applications, with a reported 10 million users.";
		String s2= "Java";
		countSubstrings(String s1, String s2);
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
		if(day == 1){
			return 1;
		}else {
			long sum = 1;
			for (int i = 1; i < day; i++) {
				sum = computePay(i) * 2;
			}
			return sum;
		}
	}
	public static long computeSavings(int day) {
		if(day == 1){
			return 1;
		}else {
			long sum = 1;
			for (int i = 1; i < day; i++) {
				sum += computePay(i) * 2;
			}
			return sum;
		}
	}

	// Problem 6
	public static int countSubstrings(String s1, String s2) {
		int  s1_length = s1.length();
		int  s2_length = s2.length();
		int count = 0;
		for(int i=0; i<=s1_length; i++){
			for(int j=0; j<=s2_length; j++){
				if(s1.indexOf(j).equals(s2.indexOf(i))){
					count++;
				}
			}
		}
		return count;
	}
}


//		The minimum element in the array: 23
//		- - - - - - - - - - - - - -
//		Enter how may days you plan to work: 39
//		On the day 39 you will earn 274877906944 cents per day
//		By the day 39 you will collect 549755813887 cents in savings