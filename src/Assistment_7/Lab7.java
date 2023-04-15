package Assistment_7;

import java.util.* ;

public class Lab7
{
	// Problem 1
	public static int findMissing(int [] a) {
		int n = a.length;
		int expectedSum = (n + 1) * (n + 2) / 2;
		int actualSum = 0;
		for (int i = 0; i < n; i++) {
			actualSum += a[i];
		}
		return expectedSum - actualSum;
	}
	
	// Problem 2
	public static void countingSort(int[] a, int n ) {
		int[] count = new int[n];
		for (int i = 0; i < a.length; i++) {
			count[a[i] - 1]++;
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			while (count[i] > 0) {
				a[index++] = i + 1;
				count[i]--;
			}
		}
	} 

	// Problem 3
	public satic int findKSmallest(int[] a, int k) {
		
	}

	public satic int findMedian(int[] a, int k) {
		
	}
} 
