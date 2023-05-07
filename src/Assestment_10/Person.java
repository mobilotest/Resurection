package Assestment_10;

import java.util.ArrayList;
import java.util.Arrays;

public class Person implements Comparable<Person>{
    String name;
    String id;
    public Person(String n, String i) {
	name = n;
	id = i;
    }
    public int compareTo(Person p) {
		return name.compareTo(((Person)p).name);
    }
}

class Test {
    public static void main(String [] a) {
		Person p1 = new Person("abc", "123");
		Person p2 = new Person("abc", "456");
		Person p3 = new Person("cde", "789");
		System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2));
		System.out.println("p1.compareTo(p3) = " + p1.compareTo(p3));
		BinarySearchTree<Person> b = new BinarySearchTree<Person>(p1);
		b.add(p2);
		b.add(p3);

		System.out.println("b.contains(p1) = " + b.contains(p1));
		System.out.println("b.contains(p2) = " + b.contains(p2));

		System.out.println("- - - - - - - - - - - - - - - - - - -");

		BinarySearchTree<Integer> intTree = new BinarySearchTree<>(50);
		intTree.add(30);
		intTree.add(20);
		intTree.add(40);
		intTree.add(70);
		intTree.add(60);
		intTree.add(80);

		System.out.println("intTree.isBalanced() = " + intTree.isBalanced());
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		System.out.println("intTree.isBST() = " + intTree.isBST());
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		System.out.println("intTree.getPredecessor(30) = " + intTree.getPredecessor(30));
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(12, 5, 787, 1, 23, 456, 34));
		int k = 3;
		System.out.println("getKthSmallest(aList, k) = " + MaxHeap.getKthSmallest(aList, k));
	}
}

/*
		p1.compareTo(p2) = 0
		p1.compareTo(p3) = -2
		b.contains(p1) = true
		b.contains(p2) = true
		- - - - - - - - - - - - - - - - - - -
		intTree.isBalanced() = true
		- - - - - - - - - - - - - - - - - - -
		intTree.isBST() = true
		- - - - - - - - - - - - - - - - - - -
		intTree.getPredecessor(30) = 20
		- - - - - - - - - - - - - - - - - - -
		getKthSmallest(aList, k) = 12

		Process finished with exit code 0
*/
