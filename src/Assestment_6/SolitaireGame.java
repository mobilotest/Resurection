package Assestment_6;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

/**
   A solitaire matching game in which you have a list of random
   integer values between 10 and 99. You remove from the list any
   pair of consecutive integers whose first or second digits match.
   If all values are removed, you win.

 */
public class SolitaireGame
{
	/** Initializes the list with 40 random 2 digit numbers. */
	public static void initializeList(ArrayListWithIterator<Integer> theList)
	{
		Random random = new Random();
		for (int i = 0; i < 40; i++) {
			theList.add(random.nextInt(90) + 10);
		}
	} // end initializeList

	/** Sees whether two numbers are removable.
		@param x  The first 2 digit integer value.
		@param y  The second 2 digit integer value.
 		@return  True if x and y match in the first or second digit. */
	public static boolean removable(Integer x, Integer y)
	{
		return x / 10 == y / 10 || x % 10 == y % 10;
	} // end removable

	/** Display the contents of theList using an Iterator
	 * 
	 */
	public static void displayList(ArrayListWithIterator<Integer> theList) 
	{
		Iterator<Integer> iterator = theList.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	/** Scans over the list and removes any pairs of values that are removable.
		@param theList  The list of 2 digit integers to scan over.
		@return  True if any pair of integers was removed. */
	public static boolean scanAndRemovePairs(ArrayListWithIterator<Integer> theList)
	{
		boolean removedPair = false;
		ListIterator<Integer> iterator = theList.listIterator();
		while (iterator.hasNext()) {
			Integer current = iterator.next();
			if (iterator.hasNext()) {
				Integer next = iterator.next();

				if (removable(current, next)) {
					iterator.remove();
					iterator.previous();
					iterator.remove();
					removedPair = true;
				} else {
					iterator.previous();
				}
			}
		}
		return removedPair;
	} // end scanAndRemovePairs

	public static void main(String args[])
	{
		ArrayList<Integer> theList = new ArrayList<Integer>();
		initializeList(theList);

		System.out.println("The list is originally: ");
		displayList(theList);

		while (!theList.isEmpty()) {
			if (scanAndRemovePairs(theList)) {
				System.out.println("After removing a pair: ");
				displayList(theList);
			} else {
				System.out.println("No more pairs can be removed.");
				break;
			}
		}

		if (theList.isEmpty()) {
			System.out.println("Congratulations! You win!");
		} else {
			System.out.println("Sorry, better luck next time.");
		}
	} // end main
} // end SolitaireGame

/*
Example outupt
The list is originally: [81, 50, 11, 61, 42, 74, 16, 65, 49, 49, 11, 19, 67, 79, 33, 95, 85, 52, 59, 67, 46, 81, 62, 30, 60, 66, 80, 96, 30, 81, 37, 30, 34, 30, 15, 80, 11, 61, 55, 46]
   Removed: 11  61
   Removed: 49  49
   Removed: 11  19
   Removed: 95  85
   Removed: 52  59
   Removed: 30  60
   Removed: 37  30
   Removed: 34  30
   Removed: 11  61
The list is now: [81, 50, 42, 74, 16, 65, 67, 79, 33, 67, 46, 81, 62, 66, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 65  67
   Removed: 62  66
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 81, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 81  80
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 96, 30, 81, 15, 80, 55, 46]
   Removed: 46  96
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 30, 81, 15, 80, 55, 46]
No more pairs to remove.

 */
