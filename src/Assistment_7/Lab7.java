package Assistment_7;

public class Lab7 {
	// Problem 1
	public static int findMissing(int[] a) {
		int n = a.length;
		int expectedSum = (n + 1) * (n + 2) / 2;
		int actualSum = 0;
		for (int i = 0; i < n; i++) {
			actualSum += a[i];
		}
		return expectedSum - actualSum;
	}

	// Problem 2
	public static void countingSort(int[] a, int n) {
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

	// Problem 3 - Find k-th smallest element
	public static int findKthSmallest(int[] a, int k) {
		int[] count = new int[100001]; // assuming array elements are <= 100000
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		int index = 0;
		for (int i = 1; i < count.length; i++) {
			index += count[i];
			if (index >= k) {
				return i;
			}
		}
		return -1; // if k is greater than the number of distinct elements
	}

	// Problem 4 - Find median
	public static int findMedian(int[] a) {
		int[] count = new int[100001]; // assuming array elements are <= 100000
		for (int i = 0; i < a.length; i++) {
			count[a[i]]++;
		}
		int index = 0;
		int median = 0;
		int n = a.length;
		for (int i = 1; i < count.length; i++) {
			index += count[i];
			if (index >= (n + 1) / 2) {
				median = i;
				break;
			}
		}
		if (n % 2 == 0) {
			int index2 = 0;
			for (int i = 1; i < count.length; i++) {
				index2 += count[i];
				if (index2 >= n / 2 + 1) {
					median += i;
					break;
				}
			}
			median /= 2;
		}
		return median;
	}
}

/*
		2
		3
		- - - - - - - - - - - - - - - - - - -
		[1, 2, 3, 4, 5]
		[1, 2, 2, 2, 2, 3, 4, 4, 5, 7, 8, 8, 9, 9]
		- - - - - - - - - - - - - - - - - - -
		1
		5
		7
		8
		10
		20
		- - - - - - - - - - - - - - - - - - -
		7
		4
		3
		3
		2
		3

		Process finished with exit code 0
*/
