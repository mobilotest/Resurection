package Assestment_9;

import java.util.Iterator;

class Driver {
    public static void iteratorTraversal() {
		// Build the tree
		// Leaves: d, e, g
		BinaryTree<String> dTree = new BinaryTree<String>("d");
		BinaryTree<String> eTree = new BinaryTree<String>("e");
		BinaryTree<String> gTree = new BinaryTree<String>("g");

		BinaryTree<String> bTree = new BinaryTree<String>("b", dTree, eTree);
		BinaryTree<String> fTree = new BinaryTree<String>("f", null, gTree);
		BinaryTree<String> cTree = new BinaryTree<String>("c", fTree, null);
		BinaryTree<String> aTree = new BinaryTree<String>("a", bTree, cTree);

		System.out.println("Inorder traversal of tree rooted at A using Iterator");
	
		Iterator<String> iter = aTree.getInorderIterator();
	
		while(iter.hasNext()) {
			String s = iter.next();
			// Process s if needed
			System.out.println("String: " + s);
		}
		System.out.println("Preorder traversal of tree rooted at A using Iterator");
	
		Iterator<String> iter2 = aTree.getPreorderIterator();
	
		while(iter2.hasNext()) {
			String s = iter2.next();
			// Process s if needed
			System.out.println("String: " + s);
		}
	
    }
    public static void expressionTree() {
		ExpressionTree aTree = new ExpressionTree("a");
		ExpressionTree bTree = new ExpressionTree("b");
		ExpressionTree cTree = new ExpressionTree("c");
		ExpressionTree timesTree = new ExpressionTree();
		timesTree.setTree("*",aTree, bTree);
		ExpressionTree plusTree = new ExpressionTree();
		plusTree.setTree("+", timesTree, cTree);

		System.out.println(" (a*b) + c = " + plusTree.evaluate());

    }

	public static void testCountMethods() {
		// Create a binary tree
		BinaryTree<String> aTree = new BinaryTree<>("a");
		BinaryTree<String> bTree = new BinaryTree<>("b");
		BinaryTree<String> cTree = new BinaryTree<>("c");
		BinaryTree<String> aTree2 = new BinaryTree<>("a");

		BinaryTree<String> dTree = new BinaryTree<>("d", aTree, bTree);
		BinaryTree<String> eTree = new BinaryTree<>("e", cTree, aTree2);
		BinaryTree<String> rootTree = new BinaryTree<>("f", dTree, eTree);

		// Count the occurrences of "a" using count1 and count2 methods
		int count1Result = rootTree.count1("a");
		int count2Result = rootTree.count2("a");

		// Print the results
		System.out.println("Occurrences of 'a' using count1 method: " + count1Result);
		System.out.println("Occurrences of 'a' using count2 method: " + count2Result);
	}

	public static void testIsIsomorphic() {
		BinaryTree<String> tree1 = new BinaryTree<>("A");
		BinaryTree<String> left1 = new BinaryTree<>("B");
		BinaryTree<String> right1 = new BinaryTree<>("C");
		tree1.setTree("A", left1, right1);

		BinaryTree<String> tree2 = new BinaryTree<>("X");
		BinaryTree<String> left2 = new BinaryTree<>("Y");
		BinaryTree<String> right2 = new BinaryTree<>("Z");
		tree2.setTree("X", left2, right2);

		BinaryTree<String> tree3 = new BinaryTree<>("A");
		BinaryTree<String> left3 = new BinaryTree<>("B");
		tree3.setTree("A", left3, null);

		System.out.println("tree1 and tree2 isomorphic? " + tree1.isIsomorphic(tree2)); // Expected: true
		System.out.println("tree1 and tree3 isomorphic? " + tree1.isIsomorphic(tree3)); // Expected: false
	}
    public static void main(String [] args) {
		// D, F, G and H are leaves
		BinaryTree<String> dTree = new BinaryTree<String>("D");
		BinaryTree<String> fTree = new BinaryTree<String>();
		fTree.setTree("F");
		BinaryTree<String> gTree = new BinaryTree<String>("G");
		BinaryTree<String> hTree = new BinaryTree<String>("H");
		BinaryTree<String> eTree = new BinaryTree<String>();
		// E has F and G as left and right children
		eTree.setTree("E", fTree, gTree);
		// B has D and E as children
		BinaryTree<String> bTree = new BinaryTree<String>("B", dTree, eTree);
		// C has H as right child
		BinaryTree<String> cTree = new BinaryTree<String>("C", null, hTree);
		// A has B and C as children 
		BinaryTree<String> aTree = new BinaryTree<String>();
		aTree.setTree("A", bTree, cTree);
		// display root, height, number of nodes
		System.out.println("Tree rooted at A:");
		System.out.println("Root of tree contains " + aTree.getRootData());
		System.out.println("Height of tree is " + aTree.getHeight());
		System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");
		System.out.println();
		// display root, height, number of nodes
		System.out.println("Tree rooted at B:");
		System.out.println("Root of tree contains " + bTree.getRootData());
		System.out.println("Height of tree is " + bTree.getHeight());
		System.out.println("Tree has " + bTree.getNumberOfNodes() + " nodes");

		// Inorder traversal of tree rooted at A
		System.out.println("Inorder traversal of tree rooted at A");
		aTree.inorderTraversal();

    	
		iteratorTraversal();
		expressionTree();
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		testCountMethods();
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		testIsIsomorphic();
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		String infix = "a*b/(c-d*e)+f/g";
		ExpressionTree tree = new ExpressionTree(infix);
		System.out.println("Inorder traversal of the expression tree:");
		tree.inorderTraversal();
    }
}

/*		Tree rooted at A:
		Root of tree contains A
		Height of tree is 4
		Tree has 8 nodes

		Tree rooted at B:
		Root of tree contains B
		Height of tree is 3
		Tree has 5 nodes
		Inorder traversal of tree rooted at A
		D
		B
		F
		E
		G
		A
		C
		H
		Inorder traversal of tree rooted at A using Iterator
		String: d
		String: b
		String: e
		String: a
		String: f
		String: g
		String: c
		Preorder traversal of tree rooted at A using Iterator
		String: a
		String: b
		String: d
		String: e
		String: c
		String: f
		String: g
		(a*b) + c = 5.0
		- - - - - - - - - - - - - - - - - - -
		Occurrences of 'a' using count1 method: 2
		Occurrences of 'a' using count2 method: 2
		- - - - - - - - - - - - - - - - - - -
		tree1 and tree2 isomorphic? true
		tree1 and tree3 isomorphic? false
		- - - - - - - - - - - - - - - - - - -
		Inorder traversal of the expression tree:
		a
		*
		b
		/
		c
		-
		d
		*
		e
		+
		f
		/
		g

		Process finished with exit code 0
*/
