package Assestment_10;

public class BinarySearchTree < T extends Comparable < ? super T >> {
    private BinaryNode<T> root;
    
    public BinarySearchTree () {
	root = null;
    } 
    
    public BinarySearchTree (T rootData) {
		root = new BinaryNode<T>(rootData);
    } 
    
    public T get(T entry) {
        return getEntry (root, entry);
    } 

    private T getEntry (BinaryNode<T> rootNode, T entry) {
        T result = null;
        if (rootNode != null) {
            T rootEntry = rootNode.getData ();
            if (entry.compareTo(rootEntry) == 0)
                result = rootEntry;
            else if (entry.compareTo(rootEntry) < 0)
                result = getEntry(rootNode.getLeftChild (), entry);
            else
                result = getEntry(rootNode.getRightChild (), entry);
        } 
        return result;
    }

    public boolean contains (T entry) {
        return get(entry) != null;
    }
    
    // Adds newEntry to the nonempty subtree rooted at rootNode.
    private T addEntry (BinaryNode< T > rootNode, T newEntry) {
        // assume that rootNode is NOT null
        T result = null;
        int comparison = newEntry.compareTo (rootNode.getData ());
        if (comparison == 0) { // duplicates NOT allowed
            result = rootNode.getData ();
            rootNode.setData (newEntry);
        }
        else if (comparison < 0) {
            if (rootNode.hasLeftChild ())
                result = addEntry (rootNode.getLeftChild (), newEntry);
            else
                rootNode.setLeftChild (new BinaryNode < T > (newEntry));
        }
        else {
            if (rootNode.hasRightChild ())
                result = addEntry (rootNode.getRightChild (), newEntry);
            else
                rootNode.setRightChild (new BinaryNode < T > (newEntry));
        } // end if
        return result;
    } // end addEntry


    public T add (T newEntry) {
        T result = null;
        if (root == null)
            root = new BinaryNode<T>(newEntry);
        else
            result = addEntry (root, newEntry);
        return result;
    } // end add

    class ReturnObject {
	T data;
	public void set(T newData) { data = newData; }
	public T get() { return data; }
    }

    public T remove (T entry) {
        ReturnObject oldEntry = new ReturnObject();
        BinaryNode<T> newRoot = removeEntry (root, entry, oldEntry);
        root = newRoot;
        return oldEntry.get ();
    } // end remove
    
    // Removes an entry from the tree rooted at a given node.
    // rootNode is a reference to the root of a tree.
    // entry is the object to be removed.
    // oldEntry is an object whose data field is null.
    // Returns the root node of the resulting tree; if entry matches
    // an entry in the tree, oldEntry's data field is the entry
    // that was removed from the tree; otherwise it is null.
	// 
	// Why removeEntry returns BinaryNode<T>
	//    Answer: To return a new modified tree: example root node removed so root of tree will change
    private BinaryNode<T> removeEntry (BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
        if (rootNode != null) {
            T rootData = rootNode.getData ();
            int comparison = entry.compareTo (rootData);
            if (comparison == 0) { // entry == root entry
                oldEntry.set (rootData);
                rootNode = removeFromRoot (rootNode);
            }
            else if (comparison < 0) { // entry < root entry
                BinaryNode<T> leftChild = rootNode.getLeftChild ();
                BinaryNode<T> newLeftChild = removeEntry(leftChild, entry, oldEntry);
                rootNode.setLeftChild (newLeftChild);
            }
            else { // entry > root entry
                BinaryNode< T > rightChild = rootNode.getRightChild ();
				BinaryNode<T> newRightChild = removeEntry (rightChild, entry, oldEntry);
				rootNode.setRightChild (newRightChild);
            } 
        } 
        return rootNode;
    } 
    
    // Removes the entry in a given root node of a subtree.
    // rootNode is the root node of the subtree.
    // Returns the root node of the revised subtree.
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
        // Case 1: rootNode has two children
        if (rootNode.hasLeftChild () && rootNode.hasRightChild ())
        {
            // find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild ();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            // replace entry in root
            rootNode.setData (largestNode.getData ());
            // remove node with largest entry in left subtree
            rootNode.setLeftChild (removeLargest(leftSubtreeRoot));
        } // end if
        // Case 2: rootNode has at most one child
        else if (rootNode.hasRightChild ())
            rootNode = rootNode.getRightChild ();
        else
            rootNode = rootNode.getLeftChild ();
        return rootNode;
    }
    
    // Finds the node containing the largest entry in a given tree.
    // rootNode is the root node of the tree.
    // Returns the node containing the largest entry in the tree.
    private BinaryNode<T> findLargest (BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild ())
            rootNode = findLargest (rootNode.getRightChild ());
        return rootNode;
    } 
    
    // Removes the node containing the largest entry in a given tree.
    // rootNode is the root node of the tree.
    // Returns the root node of the revised tree.
    private BinaryNode<T> removeLargest (BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild()) {
	    BinaryNode<T> rightChild = rootNode.getRightChild ();
	    BinaryNode<T> root = removeLargest (rightChild);
	    rootNode.setRightChild (root);
        }
        else
            rootNode = rootNode.getLeftChild ();
        return rootNode;
    }

    //P1:
    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    private int isBalanced(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = isBalanced(node.getLeftChild());
        int rightHeight = isBalanced(node.getRightChild());

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //P2:
    public boolean isBST() {
        return isBSTHelper(root, null, null);
    }

    private boolean isBSTHelper(BinaryNode<T> node, T min, T max) {
        if (node == null) {
            return true;
        }

        T value = node.getData();

        if (min != null && value.compareTo(min) <= 0) {
            return false;
        }

        if (max != null && value.compareTo(max) >= 0) {
            return false;
        }

        return isBSTHelper(node.getLeftChild(), min, value) && isBSTHelper(node.getRightChild(), value, max);
    }

    //P3:

    public T getPredecessor(T entry) {
        return getPredecessorHelper(root, entry, null);
    }

    private T getPredecessorHelper(BinaryNode<T> node, T entry, T predecessor) {
        if (node == null) {
            return null;
        }

        int comparison = entry.compareTo(node.getData());
        if (comparison == 0) {
            if (node.hasLeftChild()) {
                return findMaxValue(node.getLeftChild());
            } else {
                return predecessor;
            }
        } else if (comparison < 0) {
            return getPredecessorHelper(node.getLeftChild(), entry, predecessor);
        } else {
            return getPredecessorHelper(node.getRightChild(), entry, node.getData());
        }
    }

    private T findMaxValue(BinaryNode<T> node) {
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node.getData();
    }

    public static void main(String[] args) {
        // Test case 1: An empty string should be balanced
        String str1 = "";
        boolean result1 = isBalanced(str1);
        System.out.println("Test case 1: " + result1); // Expected output: true

        // Test case 2: A string with balanced parentheses should return true
        String str2 = "((()))";
        boolean result2 = isBalanced(str2);
        System.out.println("Test case 2: " + result2); // Expected output: true

        // Test case 3: A string with unbalanced parentheses should return false
        String str3 = "(()))";
        boolean result3 = isBalanced(str3);
        System.out.println("Test case 3: " + result3); // Expected output: false

        // Test case 4: A string with only one type of parentheses should return false
        String str4 = "(){}[]";
        boolean result4 = isBalanced(str4);
        System.out.println("Test case 4: " + result4); // Expected output: false

        // Test case 5: A string with mismatched types of parentheses should return false
        String str5 = "({[}])";
        boolean result5 = isBalanced(str5);
        System.out.println("Test case 5: " + result5); // Expected output: false
    }
}


