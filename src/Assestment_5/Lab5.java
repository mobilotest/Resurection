package Assestment_5;

import java.util.* ;
public class Lab5
{
	// Problem 1
	public static <T extends Comparable<? super T>> 
	       boolean inArrayIterativeSorted(T[] anArray, T anEntry) {
			int first = 0;
			int last = anArray.length - 1;

			while (first <= last) {
				int mid = first + (last - first) / 2;

				if (anEntry.equals(anArray[mid])) {
					return true;
				} else if (anEntry.compareTo(anArray[mid]) < 0) {
					last = mid - 1;
				} else {
					first = mid + 1;
				}
			}
			return false;
	}
	
	// Problem 2
	public static <T extends Comparable<? super T>>
		Interval findInterval(T[] sortedData, List<T> targetValues){
		int lowerBound = sortedData.length;
		int upperBound = -1;

		for (T targetValue : targetValues) {
			int index = Arrays.binarySearch(sortedData, targetValue);

			if (index < 0) {
				index = -(index + 1);
			}
			lowerBound = Math.min(lowerBound, index);
			upperBound = Math.max(upperBound, index);
		}
		if (lowerBound == sortedData.length) {
			lowerBound = -1;
		}
		if (upperBound == -1) {
			upperBound = sortedData.length;
		}
		return new Interval(lowerBound, upperBound);
		/*
		Combining the complexities:
		The loop iterates m times, and for each iteration, the binary search takes O(log(n)) time, where 'n' is the length of the sorted array.
		The other operations inside the loop and the if statements outside the loop have constant time complexity
		and do not significantly contribute to the overall complexity.
		Thus, the overall complexity of the algorithm is O(m * log(n)).
		*/
	}

	// Problem 3
	public static <T extends Comparable<? super T>> boolean  isSorted(T[ ] a) {
	for (int i = 1; i < a.length; i++) {
		if (a[i - 1].compareTo(a[i]) > 0) {
			return false;
		}
	}
	return true;
	}
	
	// Problem 4
    public static <T extends Comparable<? super T>> void modifiedSelectionSort(T[] a, int n) {
		int startIndex = 0;
		int endIndex = n - 1;

		while (startIndex < endIndex) {
			int indexOfSmallest = startIndex;
			int indexOfLargest = startIndex;

			for (int index = startIndex + 1; index <= endIndex; index++) {
				if (a[index].compareTo(a[indexOfSmallest]) < 0) {
					indexOfSmallest = index;
				}
				if (a[index].compareTo(a[indexOfLargest]) > 0) {
					indexOfLargest = index;
				}
			}

			T temp = a[startIndex];
			a[startIndex] = a[indexOfSmallest];
			a[indexOfSmallest] = temp;

			// If indexOfLargest is the first index, update it to the index of the smallest item.
			if (indexOfLargest == startIndex) {
				indexOfLargest = indexOfSmallest;
			}

			temp = a[endIndex];
			a[endIndex] = a[indexOfLargest];
			a[indexOfLargest] = temp;

			startIndex++;
			endIndex--;
		}

		/*
		In the modified selection sort algorithm, the number of comparisons necessary to sort n values can be calculated as follows:

		Sum = (n - 1) + (n - 3) + (n - 5) + ...

		This is an arithmetic series with the common difference of 2. The number of terms in the series is given by (n + 1) / 2 for odd n or n / 2 for even n. Using the arithmetic series sum formula:

		Sum = (number of terms) * (first term + last term) / 2

		For odd n:
		Sum = ((n + 1) / 2) * (n - 1 + 1) / 2
		Sum = ((n + 1) * n) / 4

		For even n:
		Sum = (n / 2) * (n - 1 + 1) / 2
		Sum = (n * n) / 4

		So, the modified selection sort algorithm performs approximately (n^2)/4 comparisons to sort n values.
		*/
    }

	public static void main(String[] args) {
		// Problem 1
		Integer[] a = {2, 5, 8, 10, 15};
		System.out.println("8 in array: " + inArrayIterativeSorted(a, 8));
		System.out.println("3 in array: " + inArrayIterativeSorted(a, 3));

		System.out.println("- - - - - - - - - - - - - - - - - - -");

		// Problem 2
		Integer[] sortedData = {5, 8, 10, 13, 15, 20, 22, 26};
		List<Integer> targetValues = Arrays.asList(8, 2, 9, 17);

		Interval interval = Lab5.findInterval(sortedData, targetValues);
		System.out.println("Lower bound: " + interval.getLower());
		System.out.println("Upper bound: " + interval.getUpper());

		System.out.println("- - - - - - - - - - - - - - - - - - -");

		// Problem 3
		Integer[] b = {1, 2, 3, 4, 5};
		Integer[] c = {1, 3, 2, 4, 5};
		System.out.println("Array b sorted? " + isSorted(b));
		System.out.println("Array c sorted? " + isSorted(c));

		System.out.println("- - - - - - - - - - - - - - - - - - -");

		// Problem 4
		Integer[] d0 = {15, 8, 10, 2, 5, 7, 1, 11, 6};
		modifiedSelectionSort(d0, d0.length);
		System.out.println("d0 = " + Arrays.toString(d0));

		Integer[] d1 = {15, 8, -3, -8, 11, 0, 10, 2, 5};
		modifiedSelectionSort(d1, d1.length);
		System.out.println("d1 = " + Arrays.toString(d1));

		Integer[] d2 = {1, 20, 12, 3, 1001, 45, 23, 9, 12, 12, 0, 45};
		modifiedSelectionSort(d2, d2.length);
		System.out.println("d2 = " + Arrays.toString(d2));

		String[] d3 = {"banana", "corn", "apple", "apple", "orange", "kiwi", "kiwi", "grape", "lemon", "pear", "peach"};
		modifiedSelectionSort(d3, d3.length);
		System.out.println("d3 = " + Arrays.toString(d3));
	}
}

/*
8 in array: true
3 in array: false
- - - - - - - - - - - - - - - - - - -
Lower bound: 0
Upper bound: 5
- - - - - - - - - - - - - - - - - - -
Array b sorted? true
Array c sorted? false
- - - - - - - - - - - - - - - - - - -
d0 = [1, 2, 5, 6, 7, 8, 10, 11, 15]
d1 = [-8, -3, 0, 2, 5, 8, 10, 11, 15]
d2 = [0, 1, 3, 9, 12, 12, 12, 20, 23, 45, 45, 1001]
d3 = [apple, apple, banana, corn, grape, kiwi, kiwi, lemon, orange, peach, pear]

Process finished with exit code 0
*/
